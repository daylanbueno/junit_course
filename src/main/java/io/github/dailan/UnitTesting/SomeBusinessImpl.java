package io.github.dailan.UnitTesting;

import org.springframework.stereotype.Service;

@Service
public class SomeBusinessImpl {

    private SomeDataService someDataService;
    public SomeBusinessImpl() {
    }

    public SomeBusinessImpl(SomeDataService someDataService) {
        this.someDataService = someDataService;
    }

    public int calculateSum(int [] arr) {
        int sum = 0;
        for (int value : arr) {
            sum += value;
        }
        return sum;
    }

    public int calculateSumUsingServiceDate() {
        int sum = 0;
        int [] arr = someDataService.retrieveAllData();
        for (int value : arr) {
            sum += value;
        }
        return sum;
    }
}
