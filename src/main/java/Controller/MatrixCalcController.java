/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import View.MatrixCalcView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 *
 * @author Javier
 */
public class MatrixCalcController implements ActionListener {
    private MatrixCalcView matrixCalcView;
    
    public MatrixCalcController(){
        matrixCalcView = new MatrixCalcView();
        addListener();
    }
    
    private void addListener(){
        
    }
    
    public void init(){
        matrixCalcView.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
    
    
    
    
}
