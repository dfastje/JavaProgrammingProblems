package me.dfastje.programmingproblems.floodfill;

import me.dfastje.programmingproblems.floodfill.FloodFillService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootTest
class FloodFillServiceTest {

    //Test Data
    boolean[][] geographicMatrix_2x2;
    boolean[][] geographicMatrix_5x5;
    boolean[][] geographicMatrix_2x5;

    //I've been meaning to find a better way to handle Bean creation in Unit tests without Mockito:
    //  https://www.baeldung.com/spring-boot-testing
    @TestConfiguration
    static class ReverseListServiceConfiguration {
        @Bean
        public FloodFillService floodFillServiceBean() {
            return new FloodFillService();
        }
    }

    @Autowired
    private FloodFillService floodFillService;

    @BeforeEach
    void setupData(){
        geographicMatrix_2x2 = new boolean[][]{
                {true, false},
                {true, false}
        };


        geographicMatrix_5x5 = new boolean[][]{
                {true,  true,  false, false, false},
                {false, true,  false, false, true},
                {true,  false, false, true,  true},
                {false, false, false, false, false},
                {true,  false, true,  false, true}
        };

        geographicMatrix_2x5 = new boolean[][]{
                {true,  true},
                {false, true},
                {true,  false},
                {false, false},
                {true,  false}
        };
    }

    @Test
    void countIslandsTest(){
        Assertions.assertEquals( 6, floodFillService.countIslands(geographicMatrix_5x5) );
        Assertions.assertEquals( 1, floodFillService.countIslands(geographicMatrix_2x2) );
        Assertions.assertEquals( 3, floodFillService.countIslands(geographicMatrix_2x5) );
    }

}