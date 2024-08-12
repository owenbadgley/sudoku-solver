import java.util.ArrayList;
import java.util.Objects;

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

    public void addRowValue(int rowValue){
        this.rowValues.add(rowValue);
    }
    public void removeRowValue(int rowValue){
        this.rowValues.remove(rowValue);
    }

    public ArrayList<Integer> getColValues() {
        return colValues;
    }

    public void setColValues(ArrayList<Integer> colValues) {
        this.colValues = colValues;
    }
    public void addColValue(int colValue){
        this.colValues.add(colValue);
    }

    @Override
    public String toString() {
        return trueValue + " ";
    }

    public void removeColValue(int colValue){
        this.colValues.remove(colValue);
    }

    public ArrayList<Integer> getBoxValues() {
        return boxValues;
    }

    public void setBoxValues(ArrayList<Integer> boxValues) {
        this.boxValues = boxValues;
    }
    public void addBoxValue(int boxValue){
        this.boxValues.add(boxValue);
    }
    public void removeBoxValue(int boxValue){
        this.boxValues.remove(boxValue);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o instanceof Integer){
            return o.equals(getTrueValue());
        }
        if (!(o instanceof Cell cell)) return false;
        return getTrueValue() == cell.getTrueValue();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTrueValue());
    }

}
