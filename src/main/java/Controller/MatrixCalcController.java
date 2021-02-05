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

    public MatrixCalcController() {
        matrixCalcView = new MatrixCalcView();
        matrixCalcModel = new MatrixCalcModel();
        addListener();
    }

    private void addListener() {
        matrixCalcView.getjBAplusB().addActionListener(this);
        matrixCalcView.getjBAminusB().addActionListener(this);
        matrixCalcView.getjBAperB().addActionListener(this);
        matrixCalcView.getjBAinverse().addActionListener(this);
        matrixCalcView.getjBBinverse().addActionListener(this);
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
        //Operacion.imprimirMatriz(matrixGenerated);
        return matrixGenerated;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int rowA = Integer.parseInt(matrixCalcView.getjTFilaA().getText());
        int columnA = Integer.parseInt(matrixCalcView.getjTColumnaA().getText());
        int rowB = Integer.parseInt(matrixCalcView.getjTFilaB().getText());
        int columnB = Integer.parseInt(matrixCalcView.getjTColumnaB().getText());
        if (matrixCalcView.getjBAplusB() == e.getSource()) {
            if (Verify.verifySize(rowA, columnA) && Verify.verifySize(rowB, columnB)) {
                Matrix matrixA = sintetizarMatrix(matrixCalcView.getjTmatrixA(), rowA, columnA);
                Matrix matrixB = sintetizarMatrix(matrixCalcView.getjTmatrixB(), rowB, columnB);
                float[][] dataResult = matrixCalcModel.sumaMatrices(matrixA, matrixB);
                matrixCalcView.showMatrixResult(dataResult);
            } else {
                JOptionPane.showMessageDialog(null, "El tama;o de alguna fila o columna es mayor a 5 o menor a 0");
            }
        }
        if (matrixCalcView.getjBAminusB() == e.getSource()) {
            if (Verify.verifySize(rowA, columnA) && Verify.verifySize(rowB, columnB)) {
                Matrix matrixA = sintetizarMatrix(matrixCalcView.getjTmatrixA(), rowA, columnA);
                Matrix matrixB = sintetizarMatrix(matrixCalcView.getjTmatrixB(), rowB, columnB);
                float[][] dataResult = matrixCalcModel.restaMatrices(matrixA, matrixB);
                matrixCalcView.showMatrixResult(dataResult);
            } else {
                JOptionPane.showMessageDialog(null, "El tama;o de alguna fila o columna es mayor a 5 o menor a 0");
            }
        }
        if (matrixCalcView.getjBAperB() == e.getSource()) {
            if (Verify.verifySize(rowA, columnA) && Verify.verifySize(rowB, columnB)) {
                Matrix matrixA = sintetizarMatrix(matrixCalcView.getjTmatrixA(), rowA, columnA);
                Matrix matrixB = sintetizarMatrix(matrixCalcView.getjTmatrixB(), rowB, columnB);
                float[][] dataResult = matrixCalcModel.multiplicarMatrices(matrixA, matrixB);
                matrixCalcView.showMatrixResult(dataResult);
            } else {
                JOptionPane.showMessageDialog(null, "El tama;o de alguna fila o columna es mayor a 5 o menor a 0");
            }
        }
        if (matrixCalcView.getjBAinverse() == e.getSource()) {

        }
        if (matrixCalcView.getjBBinverse() == e.getSource()) {

        }
    }

}
