import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class GridTest {
    private Grid testGrid;
    @BeforeEach
    public void init() {
        int[][] testGridValues = {
                {1, 6, 0, 1, 2, 3, 0, 9, 8},
                {3, 0, 2, 4, 5, 6, 0, 0, 1},
                {8, 0, 0, 7, 8, 9, 0, 3, 6},
                {4, 0, 0, 0, 0, 0, 7, 0, 2},
                {0, 0, 8, 7, 1, 3, 6, 0, 0},
                {0, 1, 6, 0, 9, 0, 0, 0, 0},
                {0, 8, 0, 0, 7, 5, 9, 0, 0},
                {0, 0, 7, 0, 6, 0, 3, 8, 0},
                {9, 5, 0, 8, 0, 0, 0, 6, 0}
        };
        testGrid = new Grid(testGridValues);
    }
    @Test
    void getRowValues() {
        ArrayList<Cell> box4 = testGrid.getBox(4);
        System.out.println(box4);
        System.out.println(testGrid.getRowValues(box4.get(1)));
    }

    @Test
    void getColValues() {
        ArrayList<Cell> box4 = testGrid.getBox(4);
        System.out.println(testGrid.getColValues(box4.get(1)));
    }

    @Test
    void getRow_fromCell(){
        ArrayList<Cell> box4 = testGrid.getBox(4);
        System.out.println(testGrid.getRow(box4.get(1)));
    }
}