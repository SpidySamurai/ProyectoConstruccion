/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.Matrix;
import Model.MatrixCalcModel;
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
        for (int i = 0; i < rowMatrix; i++) {
            for (int j = 0; j < columnMatrix; j++) {
                data[i][j] = Integer.parseInt(matrix[i][j].getText());
            }
        }
        Matrix matrixGenerated = new Matrix(rowMatrix, columnMatrix);
        matrixGenerated.setData(data);
        return matrixGenerated;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (matrixCalcView.getjBAplusB() == e.getSource()) {
            int rowA = Integer.parseInt(matrixCalcView.getjTFilaA().getText());
            int columnA = Integer.parseInt(matrixCalcView.getjTFilaA().getText());
            int rowB = Integer.parseInt(matrixCalcView.getjTFilaA().getText());
            int columnB = Integer.parseInt(matrixCalcView.getjTFilaA().getText());
            if (Verify.verifySize(rowA, columnA) && Verify.verifySize(rowB, columnB)) {
                Matrix matrixA = sintetizarMatrix(matrixCalcView.getjTmatrixA(), rowA, columnA);
                Matrix matrixB = sintetizarMatrix(matrixCalcView.getjTmatrixA(), rowA, columnA);
               float[][] dataResult =  matrixCalcModel.sumaMatrices(matrixB, matrixB);
               matrixCalcView.showMatrixResult(dataResult);
            } else {
                JOptionPane.showMessageDialog(null, "El tama;o de alguna fila o columna es mayor a 5 o menor a 0");
            }
        }
        if (matrixCalcView.getjBAminusB() == e.getSource()) {

        }
        if (matrixCalcView.getjBAperB() == e.getSource()) {

        }
        if (matrixCalcView.getjBAinverse() == e.getSource()) {

        }
        if (matrixCalcView.getjBBinverse() == e.getSource()) {

        }
    }

}
