import java.util.ArrayList;

public class Cell {
    private int trueValue = 0;
    private int row;
    private int col;

    public final int getRow() {
        return row;
    }

    public final int getCol() {
        return col;
    }

    private ArrayList<Integer> rowValues = new ArrayList<Integer>();
    private ArrayList<Integer> colValues = new ArrayList<Integer>();
    private ArrayList<Integer> boxValues = new ArrayList<Integer>();

    public Cell(int trueValue, int r, int c) {
        this.trueValue = trueValue;
        row = r;
        col = c;
    }

    public Cell(int r, int c) {
        row = r;
        col = c;
    }


    public int getTrueValue() {
        return trueValue;
    }

    public void setTrueValue(int trueValue) {
        this.trueValue = trueValue;
    }

    public ArrayList<Integer> getRowValues() {
        return rowValues;
    }

    public void setRowValues(ArrayList<Integer> rowValues) {
        this.rowValues = rowValues;
    }

    public ArrayList<Integer> getColValues() {
        return colValues;
    }

    public void setColValues(ArrayList<Integer> colValues) {
        this.colValues = colValues;
    }


    public ArrayList<Integer> getBoxValues() {
        return boxValues;
    }

    public void setBoxValues(ArrayList<Integer> boxValues) {
        this.boxValues = boxValues;
    }

    @Override
    public String toString() {
        return "value: " + trueValue;
    }
}