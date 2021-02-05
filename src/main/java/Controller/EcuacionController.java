/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Model.EcuacionModel;
import Model.Matrix;
import Model.Operacion;
import View.EcuacionView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JTextField;

/**
 *
 * @author Javier
 */
class EcuacionController implements ActionListener {

    private EcuacionView ecuacionView;
    private EcuacionModel ecuacionModel;

    public EcuacionController() {
        ecuacionView = new EcuacionView();
    }

    public void init() {
        ecuacionView.setVisible(true);
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
        if (ecuacionView.getjBCramer() == e.getSource()) {

        }
        if (ecuacionView.getjBGauss() == e.getSource()) {

        }
    }

}
