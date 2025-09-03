// script.js - Live animation + history snapshots
const API_BASE = "/api/sort";
const sortBtn = document.getElementById("sortBtn");
const liveView = document.getElementById("liveView");
const historyContainer = document.getElementById("historyContainer");
const historySection = document.getElementById("historySection");
const liveSection = document.getElementById("liveSection");
const statusEl = document.getElementById("status");
const liveInfo = document.getElementById("liveInfo");

sortBtn.addEventListener("click", handleSort);

async function handleSort() {
  stopAnimationIfAny();
  historyContainer.innerHTML = "";
  historySection.classList.add("hidden");
  liveView.innerHTML = "";
  liveInfo.textContent = "Fetching steps...";

  const inputText = document.getElementById("arrayInput").value.trim();
  if (!inputText) { alert("Enter numbers first!"); return; }

  const arr = inputText.split(",").map(s => parseInt(s.trim())).filter(n => !Number.isNaN(n));
  if (arr.length === 0) { alert("No valid numbers found"); return; }

  const algorithm = document.getElementById("algorithm").value;
  const delay = Math.max(10, parseInt(document.getElementById("delay").value) || 250);

  statusEl.textContent = "Requesting steps...";
  try {
    const res = await fetch(`${API_BASE}/${algorithm}`, {
      method: "POST",
      headers: {"Content-Type": "application/json"},
      body: JSON.stringify(arr)
    });

    if (!res.ok) {
      throw new Error(`Server returned ${res.status}`);
    }

    const steps = await res.json(); // array of arrays
    if (!Array.isArray(steps) || steps.length === 0) {
      throw new Error("No steps returned");
    }

    statusEl.textContent = "Animating live view...";
    // compute global max for consistent scaling
    const globalMax = Math.max(...steps.flat().map(x => Math.abs(x)), 1);
    await animateLive(steps, globalMax, delay);
    // after animation, render history
    statusEl.textContent = "Rendering history...";
    renderHistory(steps, globalMax);
    statusEl.textContent = "Done";
  } catch (err) {
    console.error(err);
    statusEl.textContent = "Error: " + err.message;
    liveInfo.textContent = "—";
  }
}

/* ------- Live animation logic ------- */
let animationTimer = null;
function stopAnimationIfAny() {
  if (animationTimer) {
    clearTimeout(animationTimer);
    animationTimer = null;
  }
}

function renderLiveStep(stepArr, globalMax) {
  liveView.innerHTML = "";
  liveInfo.textContent = `Step: ${currentLiveIndex + 1} / ${currentLiveTotal}`;
  stepArr.forEach(v => {
    const bar = document.createElement("div");
    bar.className = "bar";
    const h = Math.max(6, (Math.abs(v) / globalMax) * 220); // px
    bar.style.height = `${h}px`;
    bar.textContent = v;
    liveView.appendChild(bar);
  });
}

let currentLiveIndex = 0;
let currentLiveTotal = 0;

function animateLive(steps, globalMax, delay) {
  return new Promise(resolve => {
    currentLiveIndex = 0;
    currentLiveTotal = steps.length;
    renderLiveStep(steps[0], globalMax);

    function step() {
      if (currentLiveIndex >= steps.length - 1) {
        // final render then resolve
        renderLiveStep(steps[steps.length - 1], globalMax);
        animationTimer = null;
        resolve();
        return;
      }
      currentLiveIndex++;
      renderLiveStep(steps[currentLiveIndex], globalMax);
      animationTimer = setTimeout(step, delay);
    }

    animationTimer = setTimeout(step, delay);
  });
}

/* ------- History rendering (all snapshots horizontally stacked) ------- */
function renderHistory(steps, globalMax) {
  historyContainer.innerHTML = "";
  historySection.classList.remove("hidden");

  // Safety bound - avoid enormous DOM
  const MAX_HISTORY = 600;
  const displaySteps = steps.length > MAX_HISTORY ? steps.slice(0, MAX_HISTORY) : steps;

  displaySteps.forEach((step, idx) => {
    const row = document.createElement("div");
    row.className = "step-row";

    const label = document.createElement("div");
    label.className = "step-label";
    label.textContent = `Step ${idx + 1}`;
    row.appendChild(label);

    // create bars wrapper
    const barsWrap = document.createElement("div");
    barsWrap.style.display = "flex";
    barsWrap.style.alignItems = "flex-end";
    barsWrap.style.gap = "4px";
    barsWrap.style.padding = "6px 0";

    step.forEach(v => {
      const bar = document.createElement("div");
      bar.className = "bar";
      const h = Math.max(6, (Math.abs(v) / globalMax) * 140);
      bar.style.height = `${h}px`;
      bar.title = String(v);
      barsWrap.appendChild(bar);
    });

    row.appendChild(barsWrap);
    historyContainer.appendChild(row);
  });

  if (steps.length > MAX_HISTORY) {
    const note = document.createElement("div");
    note.style.color = "#b91c1c";
    note.style.marginTop = "8px";
    note.textContent = `Shown first ${MAX_HISTORY} steps (total ${steps.length}). Use smaller input for full history.`;
    historyContainer.appendChild(note);
  }
}










