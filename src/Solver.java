import java.util.ArrayList;

public class Solver {
    private Grid grid;

    public Solver(Grid g){
        grid = g;
    }

    public Grid getGrid(){
        return grid;
    }

    //using the other helper functions, attempts to solve the grid all at once, by traversing through the digits repeatedly.
    public boolean solve(){
        ArrayList<Integer> unsolvedDigits= new ArrayList<Integer>();
        for (int i = 1; i < 10; i++){
            unsolvedDigits.add(i);
        }

        while(!unsolvedDigits.isEmpty()){
            unsolvedDigits.removeIf(this::solveDigit);
        }
        return true;
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

        //checks if number is already located in box
        if (grid.getColValues(colNum).contains(solveTarget)){
            return 1;
        }
        //checks how many places number can go in column
        int numLocations = 0;
        for (Cell cell: curCol){
            if (cell.getTrueValue() == 0){
                if (!grid.getRowValues(cell).contains(solveTarget) && !grid.getBoxValues(cell).contains(solveTarget)){
                    cell.addColValue(solveTarget);
                    numLocations++;
                }
            }
        }
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

        //checks if number is already located in row
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
                    return 1;
                }
            }
        }
        return 0;
    }
    //using the other three solve functions, attempt to solve all locations of a digit. if successful, returns true, otherwise returns false.
    public boolean solveDigit(int digit){
        int solvedCount = 0;
        int prevSolvedCount;
        do {
            prevSolvedCount = solvedCount;
            solvedCount = 0;
            for (int i = 1; i < 10; i++){
                solvedCount += solveBoxNumber(i, digit);
                solvedCount += solveRowNumber(i, digit);
                solvedCount += solveColNumber(i, digit);
            }
            System.out.println(solvedCount);
        } while (solvedCount > prevSolvedCount);
        return solvedCount == 9 / 3;
    }
}
