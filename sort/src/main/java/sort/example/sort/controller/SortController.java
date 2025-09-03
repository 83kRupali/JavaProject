package sort.example.sort.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sort.example.sort.service.SortService;

@RestController
@RequestMapping("/api/sort")
@CrossOrigin(origins = "*")
public class SortController {

    @Autowired
    private SortService sortService;

    @PostMapping("/{algorithm}")
    public List<int[]> sort(@PathVariable String algorithm, @RequestBody int[] numbers) {
        return switch (algorithm.toLowerCase()) {
            case "bubble" -> sortService.bubbleSort(numbers);
            case "insertion" -> sortService.insertionSort(numbers);
            case "selection" -> sortService.selectionSort(numbers);
            case "merge" -> sortService.mergeSort(numbers);
            case "quick" -> sortService.quickSort(numbers);
            default -> throw new IllegalArgumentException("Unknown algorithm: " + algorithm);
        };
    }
}
