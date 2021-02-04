package Model;

/**
 *
 * @author Javier
 */
public class Matrix {

    private int row;
    private int column;
    private float data[][];

    public Matrix() {

    }

    public Matrix(int row, int column) {
        data = new float[row][column];
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public float[][] getData() {
        return data;
    }

    public void setData(float[][] data) {
        this.data = data;
    }
}
