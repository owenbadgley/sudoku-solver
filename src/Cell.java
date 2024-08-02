import java.util.ArrayList;

public class Cell {
    private int trueValue = 0;
    private ArrayList<Integer> rowValues = new ArrayList<Integer>();
    private ArrayList<Integer> colValues = new ArrayList<Integer>();
    private ArrayList<Integer> boxValues = new ArrayList<Integer>();

    public Cell(int trueValue) {
        this.trueValue = trueValue;
    }

    public Cell() {

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
}