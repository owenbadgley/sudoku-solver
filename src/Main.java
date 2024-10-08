import java.util.ArrayList;

public class Main {
    public static void main(String[] args){

        int[][] testGridValues = {
                {1, 6, 0, 5, 0, 0, 0, 9, 8},
                {3, 0, 2, 4, 0, 6, 0, 0, 1},
                {8, 0, 0, 9, 0, 1, 0, 3, 6},
                {4, 0, 0, 0, 0, 0, 7, 0, 2},
                {0, 0, 8, 7, 1, 3, 6, 0, 0},
                {0, 1, 6, 0, 9, 0, 0, 0, 0},
                {0, 8, 0, 0, 7, 5, 9, 0, 0},
                {0, 0, 7, 0, 6, 0, 3, 8, 0},
                {9, 5, 0, 8, 0, 0, 0, 6, 0}
        };

        Grid testGrid = new Grid(testGridValues);

        Solver solver = new Solver(testGrid);

        ArrayList<Cell> box5 = testGrid.getCol(testGrid.getCell(6,4));

        for (Cell cell: box5){
            System.out.println(cell);
        }

        System.out.println(testGrid);
        //solver.solveBox(1);
    }
}
