/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Verify;

import javax.swing.JFormattedTextField;
import javax.swing.JTextField;

/**
 *
 * @author Javier
 */
public abstract class Verify {

    public static boolean verifySize(int row, int column) {
        return (row <= 5 && row >= 1) && (column <= 5 && column >= 1);
    }

    public static boolean verifyBlank(String row, String column) {
        return !(row.equals("") && column.equals(""));
    }

    public static boolean verifyBlankScalar(String scalar) {
        return !scalar.equals("");
    }

    public static boolean verifyNumberScalar(String scalar) {
        return scalar.matches("[+-]?\\d*(\\.\\d+)?") && scalar.equals("") == false;
    }

    public static boolean verifyNumber(String row, String column) {
        return (row.matches("[+-]?\\d*(\\.\\d+)?") && row.equals("") == false)
                && (column.matches("[+-]?\\d*(\\.\\d+)?") && column.equals("") == false);
    }

    public static boolean isSquare(int rowA, int columnA) {
        return rowA == columnA;
    }

    public static boolean sameSize(int rowA, int columnA, int rowB, int columnB) {
        return (rowA == rowB) && (columnA == columnB);
    }

    public static boolean ableToMultiple(int columnA, int rowB) {
        return columnA == rowB;
    }

    public static boolean veryBlankMatrix(JTextField[][] matrix, int row, int column) {
        boolean verified = true;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (!verifyNumberScalar(matrix[i][j].getText())) {
                    System.out.println("Entre xd");
                    verified = false;
                    i = row;
                    j = column;
                }
            }
        }
        return verified;
    }
}
