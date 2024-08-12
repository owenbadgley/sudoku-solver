import java.util.ArrayList;

public class Solver {
    private Grid grid;

    public Solver(Grid g){
        grid = g;
    }

    //given a box and a number, check if it can be determined where that number goes in that box
    public int solveBoxNumber(int boxNum, Integer solveTarget){
        ArrayList<Cell> curBox = grid.getBox(boxNum);

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
        // if only one possible location, place the number there
        if (numLocations == 1){
            for (Cell cell : curBox){
                if (cell.getBoxValues().contains(solveTarget)){
                    cell.setTrueValue(solveTarget);
                    return 1;
                }
            }
        }
        return 0;
    }

    public int solveColNumber(int colNum, Integer solveTarget){
        ArrayList<Cell> curCol = grid.getCol(colNum);
        System.out.println(curCol);

        //checks if number is already located in box
        if (grid.getColValues(colNum).contains(solveTarget)){
            return 1;
        }
        //checks how many places number can go in box
        int numLocations = 0;
        for (Cell cell: curCol){
            if (cell.getTrueValue() == 0){
                if (!grid.getRowValues(cell).contains(solveTarget) && !grid.getBoxValues(cell).contains(solveTarget)){
                    cell.addColValue(solveTarget);
                    numLocations++;
                }
            }
        }
        System.out.println(numLocations);
        // if only one possible location, place the number there
        if (numLocations == 1){
            for (Cell cell : curCol){
                if (cell.getColValues().contains(solveTarget)){
                    cell.setTrueValue(solveTarget);
                    return 1;
                }
            }
        }
        return 0;
    }

    public int solveRowNumber(int rowNum, Integer solveTarget){
        ArrayList<Cell> curRow = grid.getRow(rowNum);

        //checks if number is already located in box
        if (grid.getRowValues(rowNum).contains(solveTarget)){
            return 1;
        }
        //checks how many places number can go in box
        int numLocations = 0;
        for (Cell cell: curRow){
            if (cell.getTrueValue() == 0){
                if (!grid.getBoxValues(cell).contains(solveTarget) && !grid.getColValues(cell).contains(solveTarget)){
                    cell.addRowValue(solveTarget);
                    numLocations++;
                }
            }
        }
        // if only one possible location, place the number there
        if (numLocations == 1){
            for (Cell cell : curRow){
                if (cell.getRowValues().contains(solveTarget)){
                    cell.setTrueValue(solveTarget);
                    System.out.println(grid);
                    return 1;
                }
            }
        }
        return 0;
    }
}
