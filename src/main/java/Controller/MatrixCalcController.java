/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Matrix;
import Model.MatrixCalcModel;
import Model.Operacion;
import Verify.Verify;
import View.MatrixCalcView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Javier
 */
public final class MatrixCalcController implements ActionListener {

    private final MatrixCalcView matrixCalcView;
    private final MatrixCalcModel matrixCalcModel;

    private int rowA;
    private int rowB;
    private int columnA;
    private int columnB;

    public MatrixCalcController() {
        matrixCalcView = new MatrixCalcView();
        matrixCalcModel = new MatrixCalcModel();
        addListener();
    }

    private void addListener() {
        matrixCalcView.getjBAplusB().addActionListener(this);
        matrixCalcView.getjBAminusB().addActionListener(this);
        matrixCalcView.getjBAperB().addActionListener(this);
        matrixCalcView.getjBAperScalar().addActionListener(this);
        matrixCalcView.getjBBperScalar().addActionListener(this);
        matrixCalcView.getjBAtrans().addActionListener(this);
        matrixCalcView.getjBBtrans().addActionListener(this);
        matrixCalcView.getjBAinverse().addActionListener(this);
        matrixCalcView.getjBBinverse().addActionListener(this);
        matrixCalcView.getjBDetA().addActionListener(this);
        matrixCalcView.getjBDetB().addActionListener(this);
        matrixCalcView.getjBSetA().addActionListener(this);
        matrixCalcView.getJbSetB().addActionListener(this);
    }

    public void init() {
        matrixCalcView.setVisible(true);
    }

    private Matrix sintetizarMatrix(JTextField[][] matrix, int rowMatrix, int columnMatrix) {
        float[][] data = new float[rowMatrix][columnMatrix];
        //System.out.println(rowMatrix+" " +columnMatrix);
        for (int i = 0; i < rowMatrix; i++) {
            for (int j = 0; j < columnMatrix; j++) {
                data[i][j] = Float.parseFloat(matrix[i][j].getText());
            }
        }
        Matrix matrixGenerated = new Matrix(rowMatrix, columnMatrix);
        matrixGenerated.setData(data);
        Operacion.imprimirMatriz(matrixGenerated);
        return matrixGenerated;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (matrixCalcView.getjBSetA() == e.getSource()) {
            String rowAString = matrixCalcView.getjTFilaA().getText();
            String columnAString = matrixCalcView.getjTColumnaA().getText();
            if (Verify.verifyNumber(rowAString, columnAString)) {
                rowA = Integer.parseInt(matrixCalcView.getjTFilaA().getText());
                columnA = Integer.parseInt(matrixCalcView.getjTColumnaA().getText());
                if (Verify.verifySize(rowA, columnA)) {
                    matrixCalcView.habilitarMatrixA(rowA, columnA);
                } else {
                    JOptionPane.showMessageDialog(null, "El tama;o de alguna fila o columna de la Matriz A es menor que 1 o mayor que 5.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Debe ingresar unicamente valores numericos.");
            }
        }
        if (matrixCalcView.getJbSetB() == e.getSource()) {
            String rowBString = matrixCalcView.getjTFilaB().getText();
            String columnBString = matrixCalcView.getjTColumnaB().getText();
            if (Verify.verifyNumber(rowBString, columnBString)) {
                rowB = Integer.parseInt(matrixCalcView.getjTFilaB().getText());
                columnB = Integer.parseInt(matrixCalcView.getjTColumnaB().getText());
                if (Verify.verifySize(rowB, columnB)) {
                    matrixCalcView.habilitarMatrixB(rowB, columnB);
                } else {
                    JOptionPane.showMessageDialog(null, "El tama;o de alguna fila o columna de la Matriz B es menor que 1 o mayor que 5.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Debe ingresar unicamente valores numericos.");
            }
        }
        if (matrixCalcView.getjBAplusB() == e.getSource()) {
            if (Verify.sameSize(rowA, columnA, rowB, columnB)) {
                if (Verify.veryBlankMatrix(matrixCalcView.getjTmatrixA(), rowA, columnA) && Verify.veryBlankMatrix(matrixCalcView.getjTmatrixB(), rowB, columnB)) {
                    Matrix matrixA = sintetizarMatrix(matrixCalcView.getjTmatrixA(), rowA, columnA);
                    Matrix matrixB = sintetizarMatrix(matrixCalcView.getjTmatrixB(), rowB, columnB);
                    float[][] dataResult = matrixCalcModel.sumaMatrices(matrixA, matrixB);
                    matrixCalcView.showMatrixResult(dataResult);
                } else {
                    JOptionPane.showMessageDialog(null, "Alguna casilla de matriz esta vacia o no es numerica.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Las matrices no tienen el mismo tama;o.");
            }
        }
        if (matrixCalcView.getjBAminusB() == e.getSource()) {
            if (Verify.sameSize(rowA, columnA, rowB, columnB)) {
                if (Verify.veryBlankMatrix(matrixCalcView.getjTmatrixA(), rowA, columnA) && Verify.veryBlankMatrix(matrixCalcView.getjTmatrixB(), rowB, columnB)) {
                    Matrix matrixA = sintetizarMatrix(matrixCalcView.getjTmatrixA(), rowA, columnA);
                    Matrix matrixB = sintetizarMatrix(matrixCalcView.getjTmatrixB(), rowB, columnB);
                    float[][] dataResult = matrixCalcModel.restaMatrices(matrixA, matrixB);
                    matrixCalcView.showMatrixResult(dataResult);
                } else {
                    JOptionPane.showMessageDialog(null, "Alguna casilla de matriz esta vacia o no es numerica.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Las matrices no tienen el mismo tama;o.");
            }
        }
        if (matrixCalcView.getjBAperB() == e.getSource()) {
            if (columnA == rowB) {
                if (Verify.veryBlankMatrix(matrixCalcView.getjTmatrixA(), rowA, columnA) && Verify.veryBlankMatrix(matrixCalcView.getjTmatrixB(), rowB, columnB)) {
                    Matrix matrixA = sintetizarMatrix(matrixCalcView.getjTmatrixA(), rowA, columnA);
                    Matrix matrixB = sintetizarMatrix(matrixCalcView.getjTmatrixB(), rowB, columnB);
                    float[][] dataResult = matrixCalcModel.multiplicarMatrices(matrixA, matrixB);
                    matrixCalcView.showMatrixResult(dataResult);
                } else {
                    JOptionPane.showMessageDialog(null, "Alguna casilla de matriz esta vacia o no es numerica.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "La columna de la matriz A no coincide con las filas de la matriz B.");
            }
        }
        if (matrixCalcView.getjBAperScalar() == e.getSource()) {
            if (Verify.verifyBlankScalar(matrixCalcView.getjTAScalar().getText()) && Verify.verifyNumberScalar(matrixCalcView.getjTAScalar().getText())) {
                if (Verify.veryBlankMatrix(matrixCalcView.getjTmatrixA(), rowA, columnA)) {
                    Matrix matrixA = sintetizarMatrix(matrixCalcView.getjTmatrixA(), rowA, columnA);
                    int escalar = Integer.parseInt(matrixCalcView.getjTAScalar().getText());
                    float[][] dataResult = matrixCalcModel.multiplicarMatrizAporEscalar(matrixA, escalar);
                    matrixCalcView.showMatrixResult(dataResult);
                } else {
                    JOptionPane.showMessageDialog(null, "Alguna casilla de matriz esta vacia o no es numerica.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "El scalar de A esta vacio o no es numerico.");
            }
        }
        if (matrixCalcView.getjBBperScalar() == e.getSource()) {
            if (Verify.verifyNumberScalar(matrixCalcView.getjTBScalar().getText())) {
                if (Verify.veryBlankMatrix(matrixCalcView.getjTmatrixB(), rowB, columnB)) {
                    Matrix matrixB = sintetizarMatrix(matrixCalcView.getjTmatrixB(), rowB, columnB);
                    int escalar = Integer.parseInt(matrixCalcView.getjTBScalar().getText());
                    float[][] dataResult = matrixCalcModel.multiplicarMatrizAporEscalar(matrixB, escalar);
                    matrixCalcView.showMatrixResult(dataResult);
                } else {
                    JOptionPane.showMessageDialog(null, "Alguna casilla de matriz esta vacia o no es numerica.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "El scalar de B esta vacio o no es numerico.");
            }
        }
        if (matrixCalcView.getjBAtrans() == e.getSource()) {
            if (Verify.veryBlankMatrix(matrixCalcView.getjTmatrixA(), rowA, columnA)) {
                Matrix matrixA = sintetizarMatrix(matrixCalcView.getjTmatrixA(), rowA, columnA);
                float[][] dataResult = matrixCalcModel.transponerMatriz(matrixA);
                matrixCalcView.showMatrixResult(dataResult);
            } else {
                JOptionPane.showMessageDialog(null, "Alguna casilla de matriz esta vacia o no es numerica.");
            }
        }
        if (matrixCalcView.getjBBtrans() == e.getSource()) {
            if (Verify.veryBlankMatrix(matrixCalcView.getjTmatrixB(), rowB, columnB)) {
                Matrix matrixB = sintetizarMatrix(matrixCalcView.getjTmatrixB(), rowB, columnB);
                float[][] dataResult = matrixCalcModel.transponerMatriz(matrixB);
                matrixCalcView.showMatrixResult(dataResult);
            } else {
                JOptionPane.showMessageDialog(null, "Alguna casilla de matriz esta vacia o no es numerica.");
            }
        }
        if (matrixCalcView.getjBAinverse() == e.getSource()) {
            if (Verify.isSquare(rowA, columnA)) {
                if (Verify.veryBlankMatrix(matrixCalcView.getjTmatrixA(), rowA, columnA) && Verify.veryBlankMatrix(matrixCalcView.getjTmatrixB(), rowB, columnB)) {
                    Matrix matrixA = sintetizarMatrix(matrixCalcView.getjTmatrixA(), rowA, columnA);
                    if (Operacion.determinanteMatriz(matrixA) != 0) {
                        float[][] dataResult = matrixCalcModel.inverttirMatriz(matrixA);
                        matrixCalcView.showMatrixResult(dataResult);
                    } else {
                        JOptionPane.showMessageDialog(null, "El determinante de la matriz A es 0, no se puede calcular la inversa.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Alguna casilla de matriz esta vacia o no es numerica.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "La matriz A no es cuadrada, no es posible calcular el determinante por lo tanto tampoco su inversa");
            }
        }
        if (matrixCalcView.getjBBinverse() == e.getSource()) {
            if (Verify.isSquare(rowB, columnB)) {
                if (Verify.veryBlankMatrix(matrixCalcView.getjTmatrixA(), rowA, columnA) && Verify.veryBlankMatrix(matrixCalcView.getjTmatrixB(), rowB, columnB)) {
                    Matrix matrixB = sintetizarMatrix(matrixCalcView.getjTmatrixB(), rowB, columnB);
                    if (Operacion.determinanteMatriz(matrixB) != 0) {
                        float[][] dataResult = matrixCalcModel.inverttirMatriz(matrixB);
                        matrixCalcView.showMatrixResult(dataResult);
                    } else {
                        JOptionPane.showMessageDialog(null, "El determinante de la matriz B es 0, no se puede calcular la inversa.");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Alguna casilla de matriz esta vacia o no es numerica.");
                }

            } else {
                JOptionPane.showMessageDialog(null, "La matriz B no es cuadrada, no es posible calcular el determinante por lo tanto tampoco su inversa");
            }
        }
        if (matrixCalcView.getjBDetA() == e.getSource()) {
            if (Verify.isSquare(rowA, columnA)) {
                if (Verify.veryBlankMatrix(matrixCalcView.getjTmatrixA(), rowA, columnA) && Verify.veryBlankMatrix(matrixCalcView.getjTmatrixB(), rowB, columnB)) {
                    Matrix matrixA = sintetizarMatrix(matrixCalcView.getjTmatrixA(), rowA, columnA);
                    float determinanteA = matrixCalcModel.calcDeterminante(matrixA);
                    matrixCalcView.getjTAdeterminante().setText(String.valueOf(determinanteA));
                } else {
                    JOptionPane.showMessageDialog(null, "Alguna casilla de matriz esta vacia o no es numerica.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "La matriz A no es cuadrada, no se puede calcular el determinante.");
            }
        }
        if (matrixCalcView.getjBDetB() == e.getSource()) {
            if (Verify.isSquare(rowB, columnB)) {
                if (Verify.veryBlankMatrix(matrixCalcView.getjTmatrixA(), rowA, columnA) && Verify.veryBlankMatrix(matrixCalcView.getjTmatrixB(), rowB, columnB)) {
                    Matrix matrixB = sintetizarMatrix(matrixCalcView.getjTmatrixB(), rowB, columnB);
                    float determinanteB = matrixCalcModel.calcDeterminante(matrixB);
                    matrixCalcView.getjTBdeterminante().setText(String.valueOf(determinanteB));
                } else {
                    JOptionPane.showMessageDialog(null, "Alguna casilla de matriz esta vacia o no es numerica.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "La matriz B no es cuadrada, no se puede calcular el determinante.");
            }
        }
    }

}
