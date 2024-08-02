public class Grid {
    private final Cell[][] grid;
    int grideSize;

    public Grid(int[][] startingGrid){
        grideSize = startingGrid.length;
        grid = new Cell[grideSize][grideSize];

        for (int i = 0; i < grideSize; i++){
            for (int j = 0; j < grideSize; j++) {
                if (startingGrid[i][j] > 0 && startingGrid[i][j] <= grideSize){
                    grid[i][j] = new Cell(startingGrid[i][j]);
                } else {
                    grid[i][j] = new Cell();
                }
            }
        }
    }

    public Cell getCell(int row, int col){
        return grid[row - 1][col - 1];
    }
    public Cell[] getRow(int row){
        return grid[row - 1];
    }

    public Cell[] getCol(int col){
        Cell[] column = new Cell[grideSize];
        for (int i = 0; i < grideSize; i++){
            column[i] = grid[i][col];
        }
        return column;
    }

    public Cell[] getBox(int boxNum) {
        Cell[] box = new Cell[grideSize];
        int xOffSet = 0;
        int yOffSet = 0;
        switch (boxNum) {
            case 1:
                break;
            case 2:
                xOffSet = 3;
                break;
            case 3:
                xOffSet = 6;
                break;
            case 4:
                yOffSet = 3;
                break;
            case 5:
                yOffSet = 3;
                xOffSet = 3;
                break;
            case 6:
                yOffSet = 3;
                xOffSet = 6;
                break;
            case 7:
                yOffSet = 6;
                break;
            case 8:
                yOffSet = 6;
                xOffSet = 3;
                break;
            case 9:
                yOffSet = 6;
                xOffSet = 6;
                break;
        }
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                box[3*i + j] = grid[i + xOffSet][j + yOffSet];
            }
        }
        return box;
    }
}
