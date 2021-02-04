package Model;

/**
 *
 * @author Javier
 */
public abstract class Operacion {

    public static Matrix sumarMatrices(Matrix matrixA, Matrix matrixB) {
        if (matrixA.getRow() == matrixB.getRow() && matrixA.getRow() == matrixB.getRow()) {
            Matrix matrixResult = new Matrix(matrixA.getRow(), matrixA.getColumn());
            for (int i = 0; i < matrixA.getRow(); i++) {
                for (int j = 0; j < matrixA.getColumn(); j++) {
                    matrixResult.getData()[i][j] = matrixA.getData()[i][j] + matrixB.getData()[i][j];
                }
            }

        } else {
            System.out.println("\nAl tener diferentes dimensiones no es posible la suma de matrices.\n");
        }
        return null;
    }

    public static Matrix multiplicarPorEscalar(Matrix matrixA, int scalar) {
        Matrix matrixResult = new Matrix();
        for (int i = 0; i < matrixA.getRow(); i++) {
            for (int j = 0; j < matrixA.getColumn(); j++) {
                matrixResult.getData()[i][j] = matrixA.getData()[i][j] * scalar;
            }
        }
        return matrixResult;
    }

    public static Matrix multiplicarMatrices(Matrix matrixA, Matrix matrixB) {
        if (matrixA.getColumn() == matrixB.getRow()) {
            Matrix matrixResult = new Matrix(matrixA.getRow(), matrixB.getColumn());
            for (int i = 0; i < matrixA.getRow(); i++) {
                for (int j = 0; j < matrixB.getColumn(); j++) {
                    for (int k = 0; k < matrixA.getColumn(); k++) {
                        matrixResult.getData()[i][j] += (matrixA.getData()[i][k] * matrixB.getData()[k][j]);
                    }
                }
                return matrixResult;
            }
        } else {
            System.out.println("\nAl no coincidir las columnas de la matriz A con las filas de la matriz B,"
                    + " no es posible realizar la multiplicaciÃ³n de matrices.");
        }
        return null;
    }

    public static Matrix transponerMatriz(Matrix matrixA) {
        Matrix matrixResult = new Matrix(matrixA.getColumn(), matrixA.getRow());
        for (int i = 0; i < matrixA.getRow(); i++) {
            for (int j = 0; j < matrixA.getColumn(); j++) {
                matrixResult.getData()[i][j] = matrixA.getData()[j][i];
            }
        }
        return matrixResult;
    }
}
