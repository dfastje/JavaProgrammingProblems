package me.dfastje.programmingproblems.bubblesort;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class BubbleSortService {

    public Integer[] bubbleSort(Integer[] inputArray){
        Integer[] arrayToSort = inputArray;

        while( listIsNotSorted( arrayToSort) ){
            for (int i = 0; i < arrayToSort.length; i++) {
                if( shouldElementsSwap( i, arrayToSort ) ){
                    int elementIndex = i;
                    int nextElementIndex = elementIndex+1;

                    Integer swappingVariable = arrayToSort[ nextElementIndex ];
                    arrayToSort[ nextElementIndex ] = arrayToSort[ elementIndex ];
                    arrayToSort[ elementIndex ] = swappingVariable;
                }
            }
        }

        return arrayToSort;
    }

    private boolean listIsNotSorted( Integer[] arrayToCheck ){
        if ( arrayToCheck.length < 2 ) {
            return false;
        }

        for (int i = 0; i < arrayToCheck.length; i++) {
            boolean notLastIndex = i < arrayToCheck.length-1;
            if( notLastIndex ){
                boolean nextElementIsSmaller = arrayToCheck[i] >= arrayToCheck[i+1];
                if ( nextElementIsSmaller ) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean shouldElementsSwap(int elementLocation, Integer[] integerArray){
        boolean retBoolValue;

        if ( elementLocation >= integerArray.length-1 ){
            return false;
        } else {
            retBoolValue = integerArray[elementLocation] > integerArray[elementLocation + 1];
        }

        return retBoolValue;
    }

}
