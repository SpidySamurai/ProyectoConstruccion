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
    
    public float[][] restaMatrices(Matrix a,Matrix b){
        Matrix matrixResult = Operacion.restarMatrices(a, b);
        return matrixResult.getData();
    }
    
    public float[][] multiplicarMatrices(Matrix a,Matrix b){
        Matrix matrixResult = Operacion.multiplicarMatrices(a, b);
        return matrixResult.getData();
    }
}
