package View;

import javax.swing.JButton;
import javax.swing.JTextField;

/**
 *
 * @author Javier
 */
public class MatrixCalcView extends javax.swing.JFrame {

    private javax.swing.JTextField jTmatrixA[][];
    private javax.swing.JTextField jTmatrixB[][];
    private javax.swing.JTextField jTmatrixResult[][];
    private final int WMATRIXBOX = 30;
    private final int HMATRIXBOX = 30;

    public MatrixCalcView() {
        initComponents();
        initJTmatrixComponents();
        setLocationRelativeTo(null);

    }

    public void initJTmatrixComponents() {
        initMatrixArray();
        posJTmatrixA();
        posJTmatrixB();
        posJTmatrixResult();
    }

    public void initMatrixArray() {
        jTmatrixA = new JTextField[5][5];
        jTmatrixB = new JTextField[5][5];
        jTmatrixResult = new JTextField[5][5];

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                jTmatrixA[i][j] = new JTextField();
                jTmatrixB[i][j] = new JTextField();
                jTmatrixResult[i][j] = new JTextField();
            }
        }
    }

    public void posJTmatrixA() {
        int matrixAposX;
        int matrixAposY = 140;

        for (int i = 0; i < 5; i++) {
            matrixAposX = 30;
            for (int j = 0; j < 5; j++) {
                jTmatrixA[i][j].setHorizontalAlignment(JTextField.CENTER);
                jTmatrixA[i][j].setEditable(false);
                jPMatrixPanel.add(jTmatrixA[i][j], new org.netbeans.lib.awtextra.AbsoluteConstraints(matrixAposX, matrixAposY, WMATRIXBOX, HMATRIXBOX));
                matrixAposX += 30;
            }
            matrixAposY += 30;
        }
    }

    public void posJTmatrixB() {
        int matrixBposX;
        int matrixBposY = 140;

        for (int i = 0; i < 5; i++) {
            matrixBposX = 330;
            for (int j = 0; j < 5; j++) {
                jTmatrixB[i][j].setHorizontalAlignment(JTextField.CENTER);
                jTmatrixB[i][j].setEditable(false);
                jPMatrixPanel.add(jTmatrixB[i][j], new org.netbeans.lib.awtextra.AbsoluteConstraints(matrixBposX, matrixBposY, WMATRIXBOX, HMATRIXBOX));
                matrixBposX += 30;
            }
            matrixBposY += 30;
        }
    }

    public void posJTmatrixResult() {
        int matrixRposX;
        int matrixRposY = 340;
        for (int i = 0; i < 5; i++) {
            matrixRposX = 180;
            for (int j = 0; j < 5; j++) {
                jTmatrixResult[i][j].setHorizontalAlignment(JTextField.CENTER);
                jTmatrixResult[i][j].setEditable(false);
                jPMatrixPanel.add(jTmatrixResult[i][j], new org.netbeans.lib.awtextra.AbsoluteConstraints(matrixRposX, matrixRposY, WMATRIXBOX, HMATRIXBOX));
                matrixRposX += 30;
            }
            matrixRposY += 30;
        }
    }

    public void showMatrixResult(float[][] resultData) {
        clearMatrixResult(resultData.length, resultData[0].length);
        for (int i = 0; i < resultData.length; i++) {
            for (int j = 0; j < resultData[i].length; j++) {
                jTmatrixResult[i][j].setText(String.format("%.2f", resultData[i][j]));
            }
        }
    }

    public void habilitarMatrixA(int row, int column) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (i >= row || j >= column) {
                    jTmatrixA[i][j].setEditable(false);
                    jTmatrixA[i][j].setText("");
                } else {
                    jTmatrixA[i][j].setEditable(true);
                }
            }
        }
    }

    public void habilitarMatrixB(int row, int column) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (i >= row || j >= column) {
                    jTmatrixB[i][j].setEditable(false);
                    jTmatrixB[i][j].setText("");
                } else {
                    jTmatrixB[i][j].setEditable(true);
                }
            }
        }
    }

    public void clearMatrixResult(int row, int column) {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                jTmatrixResult[i][j].setText("");
            }
        }
    }

    public JButton getjBAinverse() {
        return jBAinverse;
    }

    public JButton getjBAminusB() {
        return jBAminusB;
    }

    public JButton getjBAperB() {
        return jBAperB;
    }

    public JButton getjBAplusB() {
        return jBAplusB;
    }

    public JButton getjBBinverse() {
        return jBBinverse;
    }

    public JTextField getjTColumnaA() {
        return jTColumnaA;
    }

    public JTextField getjTColumnaB() {
        return jTColumnaB;
    }

    public JTextField getjTFilaA() {
        return jTFilaA;
    }

    public JTextField getjTFilaB() {
        return jTFilaB;
    }

    public JButton getjBAperScalar() {
        return jBAperScalar;
    }

    public JButton getjBAtrans() {
        return jBAtrans;
    }

    public JButton getjBBperScalar() {
        return jBBperScalar;
    }

    public JButton getjBBtrans() {
        return jBBtrans;
    }

    public JTextField[][] getjTmatrixA() {
        return jTmatrixA;
    }

    public JTextField[][] getjTmatrixB() {
        return jTmatrixB;
    }

    public JTextField getjTAScalar() {
        return jTAScalar;
    }

    public JTextField getjTBScalar() {
        return jTBScalar;
    }

    public JButton getjBDetA() {
        return jBDetA;
    }

    public JButton getjBDetB() {
        return jBDetB;
    }

    public JTextField getjTAdeterminante() {
        return jTAdeterminante;
    }

    public JTextField getjTBdeterminante() {
        return jTBdeterminante;
    }

    public JButton getJbSetB() {
        return JbSetB;
    }

    public JButton getjBSetA() {
        return jBSetA;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPMatrixPanel = new javax.swing.JPanel();
        jLTittle = new javax.swing.JLabel();
        jLFILA = new javax.swing.JLabel();
        jLCOL = new javax.swing.JLabel();
        jLFILAB = new javax.swing.JLabel();
        jLCOLB = new javax.swing.JLabel();
        jTFilaA = new javax.swing.JTextField();
        jTColumnaA = new javax.swing.JTextField();
        jTFilaB = new javax.swing.JTextField();
        jTColumnaB = new javax.swing.JTextField();
        jBAplusB = new javax.swing.JButton();
        jBAminusB = new javax.swing.JButton();
        jBAperB = new javax.swing.JButton();
        jBAinverse = new javax.swing.JButton();
        jBBtrans = new javax.swing.JButton();
        jBBinverse = new javax.swing.JButton();
        jBAtrans = new javax.swing.JButton();
        jBAperScalar = new javax.swing.JButton();
        jBBperScalar = new javax.swing.JButton();
        jTBScalar = new javax.swing.JTextField();
        jTAScalar = new javax.swing.JTextField();
        jTBdeterminante = new javax.swing.JTextField();
        jTAdeterminante = new javax.swing.JTextField();
        jBDetB = new javax.swing.JButton();
        jBDetA = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jBSetA = new javax.swing.JButton();
        JbSetB = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        jPMatrixPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLTittle.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLTittle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLTittle.setText("Calculadora de matrices");
        jPMatrixPanel.add(jLTittle, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 500, -1));

        jLFILA.setText("Fila");
        jPMatrixPanel.add(jLFILA, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, -1));

        jLCOL.setText("Columna");
        jPMatrixPanel.add(jLCOL, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, -1, -1));

        jLFILAB.setText("Fila");
        jPMatrixPanel.add(jLFILAB, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 80, -1, -1));

        jLCOLB.setText("Columna");
        jPMatrixPanel.add(jLCOLB, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 80, -1, -1));
        jPMatrixPanel.add(jTFilaA, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 30, -1));
        jPMatrixPanel.add(jTColumnaA, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, 30, -1));
        jPMatrixPanel.add(jTFilaB, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 110, 30, -1));
        jPMatrixPanel.add(jTColumnaB, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 110, 30, -1));

        jBAplusB.setText("A + B");
        jPMatrixPanel.add(jBAplusB, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 60, 80, -1));

        jBAminusB.setText("A - B");
        jPMatrixPanel.add(jBAminusB, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 90, 80, -1));

        jBAperB.setText("A *  B");
        jPMatrixPanel.add(jBAperB, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 120, 80, -1));

        jBAinverse.setText("A-");
        jPMatrixPanel.add(jBAinverse, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 270, 80, -1));

        jBBtrans.setText("transB");
        jPMatrixPanel.add(jBBtrans, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 240, 80, -1));

        jBBinverse.setText("B-");
        jPMatrixPanel.add(jBBinverse, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 300, 80, -1));

        jBAtrans.setText("transA");
        jPMatrixPanel.add(jBAtrans, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 210, 80, -1));

        jBAperScalar.setText("A * N");
        jPMatrixPanel.add(jBAperScalar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 150, 80, -1));

        jBBperScalar.setText("B *  N");
        jPMatrixPanel.add(jBBperScalar, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 180, 80, -1));
        jPMatrixPanel.add(jTBScalar, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 110, 30, -1));
        jPMatrixPanel.add(jTAScalar, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, 30, -1));

        jTBdeterminante.setEditable(false);
        jPMatrixPanel.add(jTBdeterminante, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 340, 30, -1));

        jTAdeterminante.setEditable(false);
        jPMatrixPanel.add(jTAdeterminante, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 30, 20));

        jBDetB.setText("Determinante");
        jPMatrixPanel.add(jBDetB, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 340, -1, -1));

        jBDetA.setText("Determinante");
        jPMatrixPanel.add(jBDetA, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 340, -1, -1));

        jLabel1.setText("Escalar");
        jPMatrixPanel.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, -1, -1));

        jLabel2.setText("Escalar");
        jPMatrixPanel.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 80, -1, -1));

        jBSetA.setText("OK");
        jPMatrixPanel.add(jBSetA, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, -1, 20));

        JbSetB.setText("OK");
        jPMatrixPanel.add(JbSetB, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 110, -1, 20));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPMatrixPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPMatrixPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 501, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MatrixCalcView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MatrixCalcView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MatrixCalcView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MatrixCalcView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MatrixCalcView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton JbSetB;
    private javax.swing.JButton jBAinverse;
    private javax.swing.JButton jBAminusB;
    private javax.swing.JButton jBAperB;
    private javax.swing.JButton jBAperScalar;
    private javax.swing.JButton jBAplusB;
    private javax.swing.JButton jBAtrans;
    private javax.swing.JButton jBBinverse;
    private javax.swing.JButton jBBperScalar;
    private javax.swing.JButton jBBtrans;
    private javax.swing.JButton jBDetA;
    private javax.swing.JButton jBDetB;
    private javax.swing.JButton jBSetA;
    private javax.swing.JLabel jLCOL;
    private javax.swing.JLabel jLCOLB;
    private javax.swing.JLabel jLFILA;
    private javax.swing.JLabel jLFILAB;
    private javax.swing.JLabel jLTittle;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPMatrixPanel;
    private javax.swing.JTextField jTAScalar;
    private javax.swing.JTextField jTAdeterminante;
    private javax.swing.JTextField jTBScalar;
    private javax.swing.JTextField jTBdeterminante;
    private javax.swing.JTextField jTColumnaA;
    private javax.swing.JTextField jTColumnaB;
    private javax.swing.JTextField jTFilaA;
    private javax.swing.JTextField jTFilaB;
    // End of variables declaration//GEN-END:variables
}
