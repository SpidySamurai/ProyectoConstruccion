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
    
    public float[][] multiplicarMatrizAporEscalar(Matrix a,int escalar){
        Matrix matrixResult = Operacion.multiplicarPorEscalar(a, escalar);
        return matrixResult.getData();
    }

    public float[][] transponerMatriz(Matrix matrix) {
        Matrix matrixResult = Operacion.transponerMatriz(matrix);
        return matrixResult.getData();
    }
}
