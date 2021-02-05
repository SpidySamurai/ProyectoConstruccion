package Controller;

import View.DescripcionView;
import View.IntegrantesView;
import View.PrincipalView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Javier
 */
public class PrincipalController implements ActionListener {

    private final PrincipalView principalView;

    public PrincipalController() {
        principalView = new PrincipalView();
        addListener();
    }

    private void addListener() {
        principalView.getJBInit().addActionListener(this);
        principalView.getjBSistemaEcuaciones().addActionListener(this);
        principalView.getjMDescripcion().addActionListener(this);
        principalView.getjMIntegrantes().addActionListener(this);
    }

    public void init() {
        principalView.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (principalView.getJBInit() == e.getSource()) {
            MatrixCalcController matrixCalculator= new MatrixCalcController();
            matrixCalculator.init();
        }
        if(principalView.getjBSistemaEcuaciones() == e.getSource()){
            EcuacionController ecuacionController = new EcuacionController();
            ecuacionController.init();
        }
        if(principalView.getjMDescripcion() == e.getSource()){
            new DescripcionView().setVisible(true);
        }
        if(principalView.getjMIntegrantes() == e.getSource()){
            new IntegrantesView().setVisible(true);
        }
    }

}
