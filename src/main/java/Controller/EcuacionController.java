/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.EcuacionModel;
import Model.Matrix;
import Model.Operacion;
import Verify.Verify;
import View.EcuacionView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Javier
 */
class EcuacionController implements ActionListener {

    private final EcuacionView ecuacionView;
    private final EcuacionModel ecuacionModel;

    private int row;
    private int column;

    public EcuacionController() {
        ecuacionView = new EcuacionView();
        ecuacionModel = new EcuacionModel();
        addListener();
    }

    public void init() {
        ecuacionView.setVisible(true);
    }

    private void addListener() {
        ecuacionView.getjBCramer().addActionListener(this);
        ecuacionView.getjBGauss().addActionListener(this);
        ecuacionView.getjBSetMatrix().addActionListener(this);
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
        if (ecuacionView.getjBSetMatrix() == e.getSource()) {
            String rowAString = ecuacionView.getjTColumnaA().getText();
            String columnAString = ecuacionView.getjTColumnaA().getText();
            if (Verify.verifyNumber(rowAString, columnAString)) {
                row = Integer.parseInt(ecuacionView.getjTFilaA().getText());
                column = Integer.parseInt(ecuacionView.getjTColumnaA().getText());
                if (Verify.verifySize(row, column)) {
                    ecuacionView.habilitarMatrixA(row, column);
                } else {
                    JOptionPane.showMessageDialog(null, "El tama;o de alguna fila o columna de la Matriz A es menor que 1 o mayor que 5.");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Debe ingresar unicamente valores numericos.");
            }
        }
        if (ecuacionView.getjBCramer() == e.getSource()) {
            if (Verify.veryBlankMatrix(ecuacionView.getjTmatrix(), row, column)) {
                Matrix matrix = sintetizarMatrix(ecuacionView.getjTmatrix(), row, column);
                float dataResult[][] = ecuacionModel.cramer(matrix);
                ecuacionView.showResult(dataResult);
            } else {
                JOptionPane.showMessageDialog(null, "Alguna casilla de matriz esta vacia o no es numerica.");
            }

        }
        if (ecuacionView.getjBGauss() == e.getSource()) {
            if (Verify.veryBlankMatrix(ecuacionView.getjTmatrix(), row, column)) {
                Matrix matrix = sintetizarMatrix(ecuacionView.getjTmatrix(), row, column);
                float dataResult[][] = ecuacionModel.sistemaGauss(matrix);
                ecuacionView.showResult(dataResult);
            } else {
                JOptionPane.showMessageDialog(null, "Alguna casilla de matriz esta vacia o no es numerica.");
            }

        }
    }
}
