package me.dfastje.programmingproblems.floodfill;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Data class for determining locations.
 *
 * Note the use of Lombok code completion framework.
 */
@Data
@AllArgsConstructor
public class DataVector {
    private Integer x;
    private Integer y;
}
