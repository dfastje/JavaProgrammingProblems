package me.dfastje.programmingproblems.quicksort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class QuickSortServiceTest {

    private Integer[] emptyArray;
    private Integer[] singleElementArray;
    private Integer[] twoElementArray;
    private Integer[] twoElementArraySorted;
    private Integer[] fiveElementArray;
    private Integer[] fiveElementArraySorted;

    @Autowired
    private QuickSortService quickSortService;

    static class QuickSortServiceConfiguration{
        @Bean
        public QuickSortService quickSortService(){
            return new QuickSortService();
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
    void quickSortTest_EmptyArray() {
        Integer[] outputEmptyArray = quickSortService.quickSort(emptyArray);
        Assertions.assertArrayEquals(emptyArray, outputEmptyArray,
                "Sorted empty array should be equal to input empty array");
    }

    @Test
    void quickSortTest_SingleElementArray() {
        Integer[] outputArray = quickSortService.quickSort(singleElementArray);
        Assertions.assertArrayEquals(singleElementArray, outputArray,
                "Sorted single element array should be equal to input array");
    }

    @Test
    void quickSortTest_TwoElementArray() {
        Integer[] outputArray = quickSortService.quickSort(twoElementArray);
        Assertions.assertArrayEquals(twoElementArraySorted, outputArray,
                "Sorted two element array should be equal testData array");
    }

    @Test
    void quickSortTest_ManyElementArray() {
        Integer[] outputArray = quickSortService.quickSort(fiveElementArray);
        Assertions.assertArrayEquals(fiveElementArraySorted, outputArray,
                "QuickSort, you had one job!");
    }
}