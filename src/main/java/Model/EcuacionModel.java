package Model;

/**
 *
 * @author Javier
 */
public class EcuacionModel {
     /**
     *
     * @param matrix
     * @return Sistema de ecuaciones resuelto por cramer
     */
    public float[][] cramer(Matrix matrix){
        Matrix matrixResult = Operacion.cramer(matrix);
        return matrixResult.getData();
    }

    /**
     *
     * @param matrix
     * @return Sistema de ecuaciones resuelto por Gauss-Jordan
     */
    public float[][] sistemaGauss(Matrix matrix){
        Matrix matrixResult = Operacion.sistemaGauss(matrix);
        return matrixResult.getData();
    }
}
