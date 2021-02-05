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
        matrixCalcView.getjBAperScalar().addActionListener(this);
        matrixCalcView.getjBBperScalar().addActionListener(this);
        matrixCalcView.getjBAtrans().addActionListener(this);
        matrixCalcView.getjBBtrans().addActionListener(this);
        matrixCalcView.getjBAinverse().addActionListener(this);
        matrixCalcView.getjBBinverse().addActionListener(this);
        matrixCalcView.getjBDetA().addActionListener(this);
        matrixCalcView.getjBDetB().addActionListener(this);
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
        if (matrixCalcView.getjBAplusB() == e.getSource()) {
            int rowA = Integer.parseInt(matrixCalcView.getjTFilaA().getText());
            int columnA = Integer.parseInt(matrixCalcView.getjTColumnaA().getText());
            int rowB = Integer.parseInt(matrixCalcView.getjTFilaB().getText());
            int columnB = Integer.parseInt(matrixCalcView.getjTColumnaB().getText());
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
            int rowA = Integer.parseInt(matrixCalcView.getjTFilaA().getText());
            int columnA = Integer.parseInt(matrixCalcView.getjTColumnaA().getText());
            int rowB = Integer.parseInt(matrixCalcView.getjTFilaB().getText());
            int columnB = Integer.parseInt(matrixCalcView.getjTColumnaB().getText());
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
            int rowA = Integer.parseInt(matrixCalcView.getjTFilaA().getText());
            int columnA = Integer.parseInt(matrixCalcView.getjTColumnaA().getText());
            int rowB = Integer.parseInt(matrixCalcView.getjTFilaB().getText());
            int columnB = Integer.parseInt(matrixCalcView.getjTColumnaB().getText());
            if (Verify.verifySize(rowA, columnA) && Verify.verifySize(rowB, columnB)) {
                Matrix matrixA = sintetizarMatrix(matrixCalcView.getjTmatrixA(), rowA, columnA);
                Matrix matrixB = sintetizarMatrix(matrixCalcView.getjTmatrixB(), rowB, columnB);
                float[][] dataResult = matrixCalcModel.multiplicarMatrices(matrixA, matrixB);
                matrixCalcView.showMatrixResult(dataResult);
            } else {
                JOptionPane.showMessageDialog(null, "El tama;o de alguna fila o columna es mayor a 5 o menor a 0");
            }
        }
        if (matrixCalcView.getjBAperScalar() == e.getSource()) {
            int rowA = Integer.parseInt(matrixCalcView.getjTFilaA().getText());
            int columnA = Integer.parseInt(matrixCalcView.getjTColumnaA().getText());
            if (Verify.verifySize(rowA, columnA)) {
                Matrix matrixA = sintetizarMatrix(matrixCalcView.getjTmatrixA(), rowA, columnA);
                int escalar = Integer.parseInt(matrixCalcView.getjTAScalar().getText());
                float[][] dataResult = matrixCalcModel.multiplicarMatrizAporEscalar(matrixA, escalar);
                matrixCalcView.showMatrixResult(dataResult);
            } else {
                JOptionPane.showMessageDialog(null, "El tama;o de alguna fila o columna es mayor a 5 o menor a 0");
            }
        }
        if (matrixCalcView.getjBBperScalar() == e.getSource()) {
            int rowB = Integer.parseInt(matrixCalcView.getjTFilaB().getText());
            int columnB = Integer.parseInt(matrixCalcView.getjTColumnaB().getText());
            if (Verify.verifySize(rowB, columnB)) {
                Matrix matrixB = sintetizarMatrix(matrixCalcView.getjTmatrixB(), rowB, columnB);
                int escalar = Integer.parseInt(matrixCalcView.getjTBScalar().getText());
                float[][] dataResult = matrixCalcModel.multiplicarMatrizAporEscalar(matrixB, escalar);
                matrixCalcView.showMatrixResult(dataResult);
            } else {
                JOptionPane.showMessageDialog(null, "El tama;o de alguna fila o columna es mayor a 5 o menor a 0");
            }
        }
        if (matrixCalcView.getjBAtrans() == e.getSource()) {
            int rowA = Integer.parseInt(matrixCalcView.getjTFilaA().getText());
            int columnA = Integer.parseInt(matrixCalcView.getjTColumnaA().getText());
            if (Verify.verifySize(rowA, columnA)) {
                Matrix matrixA = sintetizarMatrix(matrixCalcView.getjTmatrixA(), rowA, columnA);
                float[][] dataResult = matrixCalcModel.transponerMatriz(matrixA);
                matrixCalcView.showMatrixResult(dataResult);
            } else {
                JOptionPane.showMessageDialog(null, "El tama;o de alguna fila o columna es mayor a 5 o menor a 0");
            }
        }
        if (matrixCalcView.getjBBtrans() == e.getSource()) {
            int rowB = Integer.parseInt(matrixCalcView.getjTFilaB().getText());
            int columnB = Integer.parseInt(matrixCalcView.getjTColumnaB().getText());
            if (Verify.verifySize(rowB, columnB)) {
                Matrix matrixB = sintetizarMatrix(matrixCalcView.getjTmatrixB(), rowB, columnB);
                float[][] dataResult = matrixCalcModel.transponerMatriz(matrixB);
                matrixCalcView.showMatrixResult(dataResult);
            } else {
                JOptionPane.showMessageDialog(null, "El tama;o de alguna fila o columna es mayor a 5 o menor a 0");
            }
        }
        if (matrixCalcView.getjBAinverse() == e.getSource()) {
            int rowA = Integer.parseInt(matrixCalcView.getjTFilaA().getText());
            int columnA = Integer.parseInt(matrixCalcView.getjTColumnaA().getText());
            if (Verify.verifySize(rowA, columnA)) {
                Matrix matrixA = sintetizarMatrix(matrixCalcView.getjTmatrixA(), rowA, columnA);
                float[][] dataResult = matrixCalcModel.inverttirMatriz(matrixA);
                matrixCalcView.showMatrixResult(dataResult);
            } else {
                JOptionPane.showMessageDialog(null, "El tama;o de alguna fila o columna es mayor a 5 o menor a 0");
            }
        }
        if (matrixCalcView.getjBBinverse() == e.getSource()) {
            int rowB = Integer.parseInt(matrixCalcView.getjTFilaB().getText());
            int columnB = Integer.parseInt(matrixCalcView.getjTColumnaB().getText());
            if (Verify.verifySize(rowB, columnB)) {
                Matrix matrixB = sintetizarMatrix(matrixCalcView.getjTmatrixB(), rowB, columnB);
                float[][] dataResult = matrixCalcModel.inverttirMatriz(matrixB);
                matrixCalcView.showMatrixResult(dataResult);
            } else {
                JOptionPane.showMessageDialog(null, "El tama;o de alguna fila o columna es mayor a 5 o menor a 0");
            }
        }
        if (matrixCalcView.getjBDetA() == e.getSource()) {
            int rowA = Integer.parseInt(matrixCalcView.getjTFilaA().getText());
            int columnA = Integer.parseInt(matrixCalcView.getjTColumnaA().getText());
            if (Verify.verifySize(rowA, columnA)) {
                Matrix matrixA = sintetizarMatrix(matrixCalcView.getjTmatrixA(), rowA, columnA);
                float determinanteA = matrixCalcModel.calcDeterminante(matrixA);
                matrixCalcView.getjTAdeterminante().setText(String.valueOf(determinanteA));
            } else {
                JOptionPane.showMessageDialog(null, "El tama;o de alguna fila o columna es mayor a 5 o menor a 0");
            }
        }
        if (matrixCalcView.getjBDetB() == e.getSource()) {
            int rowB = Integer.parseInt(matrixCalcView.getjTFilaB().getText());
            int columnB = Integer.parseInt(matrixCalcView.getjTColumnaB().getText());
            if (Verify.verifySize(rowB, columnB)) {
                Matrix matrixB = sintetizarMatrix(matrixCalcView.getjTmatrixB(), rowB, columnB);
                float determinanteB = matrixCalcModel.calcDeterminante(matrixB);
                matrixCalcView.getjTBdeterminante().setText(String.valueOf(determinanteB));
            } else {
                JOptionPane.showMessageDialog(null, "El tama;o de alguna fila o columna es mayor a 5 o menor a 0");
            }
        }
    }

}
