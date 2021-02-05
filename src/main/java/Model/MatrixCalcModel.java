package Model;

/**
 *
 * @author Javier
 */
public class MatrixCalcModel {
    public float[][] sumaMatrices(Matrix a,Matrix b){
        Matrix matrixResult = Operacion.sumarMatrices(a, b);
        return matrixResult.getData();
    }
}
