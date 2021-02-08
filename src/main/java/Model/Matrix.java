package Model;

import javax.swing.JOptionPane;

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
        this.row = row;
        this.column = column;
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
        this.row = data.length;
        try {
            this.column = data[0].length;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Ingresa el tama;o de la matriz...");
        }
    }
}
