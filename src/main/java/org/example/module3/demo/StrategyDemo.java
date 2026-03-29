package org.example.module3.demo;

import org.example.module3.strategy.ArraySorter;
import org.example.module3.strategy.BubbleSort;
import org.example.module3.strategy.MergeSort;
import org.example.module3.strategy.QuickSort;

public class StrategyDemo implements PatternDemo {
    @Override
    public void demonstrate() {
        int[] array = { 2, 1, 4, 3 };
        ArraySorter sorter = new ArraySorter(new BubbleSort());
        sorter.sort(array);
        sorter.setSortingStrategy(new MergeSort());
        sorter.sort(array);
        sorter.setSortingStrategy(new QuickSort());
        sorter.sort(array);
    }
}