import java.util.ArrayList;

public class Solver {
    private Grid grid;

    public Solver(Grid g){
        grid = g;
    }

    //given a box and a number, check if it can be determined where that number goes in that box
    public int solveBoxNumber(int boxNum, Integer solveTarget){
        ArrayList<Cell> curBox = grid.getBox(boxNum);
        System.out.println(curBox);

        //checks if number is already located in box
        if (grid.getBoxValues(boxNum).contains(solveTarget)){
            return 1;
        }
        //checks how many places number can go in box
        int numLocations = 0;
        for (Cell cell: curBox){
            if (cell.getTrueValue() == 0){
                if (!grid.getRowValues(cell).contains(solveTarget) && !grid.getColValues(cell).contains(solveTarget)){
                    cell.addBoxValue(solveTarget);
                    numLocations++;
                }
            }
        }
        System.out.println(numLocations);
        // if only one possible location, place the number there
        if (numLocations == 1){
            for (Cell cell : curBox){
                if (cell.getBoxValues().contains(solveTarget)){
                    cell.setTrueValue(solveTarget);
                    System.out.println(grid);
                    return 2;
                }
            }
        }
        return 0;
    }
}
