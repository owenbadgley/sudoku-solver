import java.util.ArrayList;

public class Solver {
    private Grid grid;

    public Solver(Grid g){
        grid = g;
    }

    //given a box and a number, check if it can be determined where that number goes in that box
    public int solveBoxNumber(int boxNum, int solveTarget){
        ArrayList<Cell> curBox = grid.getBox(boxNum);
        if (curBox.contains(solveTarget)){
            return 0;
        }
        for (Cell cell: curBox){

        }
        System.out.println(grid);
        return 0;
    }
}
