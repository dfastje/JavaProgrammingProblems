package me.dfastje.programmingproblems.bubblesort;

import me.dfastje.programmingproblems.quicksort.QuickSortService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BubbleSortServiceTest {

    private Integer[] emptyArray;
    private Integer[] singleElementArray;
    private Integer[] twoElementArray;
    private Integer[] twoElementArraySorted;
    private Integer[] fiveElementArray;
    private Integer[] fiveElementArraySorted;

    @Autowired
    private BubbleSortService bubbleSortService;

    static class BubbleSortServiceConfiguration{
        @Bean
        public BubbleSortService bubbleSortService(){
            return new BubbleSortService();
        }
    }

    @BeforeEach
    void setupData(){
        emptyArray = new Integer[]{};

        singleElementArray = new Integer[]{1};

        twoElementArray = new Integer[]{2,1};
        twoElementArraySorted = new Integer[]{1,2};

        fiveElementArray = new Integer[]{5,4,3,2,1};
        fiveElementArraySorted = new Integer[]{1,2,3,4,5};
    }

    @Test
    void bubbleSort() {
        Integer[] outputEmptyArray = bubbleSortService.bubbleSort(emptyArray);
        Assertions.assertArrayEquals(emptyArray, outputEmptyArray,
                "Sorted empty array should be equal to input empty array");
    }

    @Test
    void quickSortTest_SingleElementArray() {
        Integer[] outputArray = bubbleSortService.bubbleSort(singleElementArray);
        Assertions.assertArrayEquals(singleElementArray, outputArray,
                "Sorted single element array should be equal to input array");
    }

    @Test
    void quickSortTest_TwoElementArray() {
        Integer[] outputArray = bubbleSortService.bubbleSort(twoElementArray);
        Assertions.assertArrayEquals(twoElementArraySorted, outputArray,
                "Sorted two element array should be equal testData array");
    }

    @Test
    void quickSortTest_ManyElementArray() {
        Integer[] outputArray = bubbleSortService.bubbleSort(fiveElementArray);
        Assertions.assertArrayEquals(fiveElementArraySorted, outputArray,
                "QuickSort, you had one job!");
    }
}