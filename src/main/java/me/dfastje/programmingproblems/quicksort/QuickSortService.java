package me.dfastje.programmingproblems.quicksort;

import com.google.common.collect.Lists;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@Service
public class QuickSortService {


    public Integer[] quickSort(Integer[] inputArray){
        List<Integer> unsortedList = Arrays.asList( inputArray );
        List<Integer> sortedList = choosePivotAndSortRecursively( unsortedList );
        Integer[] sortedArray = new Integer[inputArray.length];
        sortedList.toArray(sortedArray);
        return sortedArray;
    }

    public List<Integer> choosePivotAndSortRecursively(List<Integer> unsortedList){
        //Edge cases of empty and single element List just return
        if( unsortedList.size() < 2 ){
            return unsortedList;
        }

        Integer pivot = unsortedList.get(0);
        List<Integer> unsortedSubList = unsortedList.subList(1,unsortedList.size());

        List<Integer> largerSubList = greaterValues(unsortedSubList, pivot);
        largerSubList = choosePivotAndSortRecursively(largerSubList);
        List<Integer> smallerOrEqualSubList = lessOrEqualValues(unsortedSubList, pivot);
        smallerOrEqualSubList = choosePivotAndSortRecursively(smallerOrEqualSubList);

        List<Integer> sortedList = new LinkedList<>();
        if(smallerOrEqualSubList.size() > 0){
            sortedList.addAll(smallerOrEqualSubList);
        }
        sortedList.add(pivot);
        if(largerSubList.size() > 0){
            sortedList.addAll(largerSubList);
        }

        return sortedList;
    }

    public List<Integer> greaterValues(List<Integer> inputList, Integer pivotValue){
        List<Integer> greaterValuesList = new LinkedList();
        inputList.forEach( integerElement -> {
            boolean isElementLarger = integerElement > pivotValue;
            if(isElementLarger){
                greaterValuesList.add(integerElement);
            }
        } );
        return greaterValuesList;
    }

    public List<Integer> lessOrEqualValues(List<Integer> inputList, Integer pivotValue){
        List<Integer> lessOrEqualValuesList = new LinkedList();
        inputList.forEach( integerElement -> {
            boolean isElementLessOrEqual = integerElement <= pivotValue;
            if(isElementLessOrEqual){
                lessOrEqualValuesList.add(integerElement);
            }
        } );
        return lessOrEqualValuesList;
    }

}
