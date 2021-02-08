package Model;

/**
 *
 * @author Barrera,Chi,Dzib,Euan
 */
public abstract class Operacion {

    /**
     *
     * @param matrixA
     * @param matrixB
     * @return La suma de ambas matrices
     */
    public static Matrix sumarMatrices(Matrix matrixA, Matrix matrixB) {
        if (matrixA.getRow() == matrixB.getRow() && matrixA.getColumn() == matrixB.getColumn()) {
            Matrix matrixResult = new Matrix(matrixA.getRow(), matrixA.getColumn());
            for (int i = 0; i < matrixA.getRow(); i++) {
                for (int j = 0; j < matrixA.getColumn(); j++) {
                    matrixResult.getData()[i][j] = matrixA.getData()[i][j] + matrixB.getData()[i][j];
                }
            }
            imprimirMatriz(matrixResult);
            return matrixResult;
        } else {
            System.out.println("\nAl tener diferentes dimensiones no es posible la suma de matrices.\n");
        }
        return null;
    }

    /**
     *
     * @param matrixA
     * @param matrixB
     * @return La resta de ambas matrices
     */
    public static Matrix restarMatrices(Matrix matrixA, Matrix matrixB) {
        if (matrixA.getRow() == matrixB.getRow() && matrixA.getColumn() == matrixB.getColumn()) {
            Matrix matrixResult = new Matrix(matrixA.getRow(), matrixA.getColumn());
            for (int i = 0; i < matrixA.getRow(); i++) {
                for (int j = 0; j < matrixA.getColumn(); j++) {
                    matrixResult.getData()[i][j] = matrixA.getData()[i][j] - matrixB.getData()[i][j];
                }
            }
            imprimirMatriz(matrixResult);
            return matrixResult;
        } else {
            System.out.println("\nAl tener diferentes dimensiones no es posible la resta de matrices.\n");
        }
        return null;
    }

    /**
     *
     * @param matrix
     */
    public static void imprimirMatriz(Matrix matrix) {
        float[][] data = matrix.getData();
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                System.out.print(data[i][j] + " ");
            }
            System.out.println("");
        }
    }

    /**
     *
     * @param matrixA
     * @param scalar
     * @return Una matriz multiplicada por un escalar
     */
    public static Matrix multiplicarPorEscalar(Matrix matrixA, int scalar) {
        Matrix matrixResult = new Matrix(matrixA.getRow(),matrixA.getColumn());
        for (int i = 0; i < matrixA.getRow(); i++) {
            for (int j = 0; j < matrixA.getColumn(); j++) {
                matrixResult.getData()[i][j] = matrixA.getData()[i][j] * scalar;
            }
        }
        return matrixResult;
    }

    /**
     *
     * @param matrixA
     * @param matrixB
     * @return La multiplicacion de ambas matrices
     */
    public static Matrix multiplicarMatrices(Matrix matrixA, Matrix matrixB) {
        if (matrixA.getColumn() == matrixB.getRow()) {
            Matrix matrixResult = new Matrix(matrixA.getRow(), matrixB.getColumn());
            for (int i = 0; i < matrixA.getRow(); i++) {
                for (int j = 0; j < matrixB.getColumn(); j++) {
                    for (int k = 0; k < matrixA.getColumn(); k++) {
                        matrixResult.getData()[i][j] += (matrixA.getData()[i][k] * matrixB.getData()[k][j]);
                    }
                }
            }
            imprimirMatriz(matrixResult);
            return matrixResult;
        } else {
            System.out.println("\nAl no coincidir las columnas de la matriz A con las filas de la matriz B,"
                    + " no es posible realizar la multiplicaciÃ³n de matrices.");
        }
        return null;
    }

    /**
     *
     * @param matrixA
     * @return La transpuesta de una Matriz
     */
    public static Matrix transponerMatriz(Matrix matrixA) {
        Matrix matrixResult = new Matrix(matrixA.getColumn(), matrixA.getRow());
        for (int i = 0; i < matrixResult.getRow(); i++) {
            for (int j = 0; j < matrixResult.getColumn(); j++) {
                matrixResult.getData()[i][j] = matrixA.getData()[j][i];
            }
        }
        imprimirMatriz(matrixA);
        imprimirMatriz(matrixResult);
        return matrixResult;
    }

    /**
     *
     * @param matrixA
     * @return El determinante de una matriz
     */
    public static float determinanteMatriz(Matrix matrixA) {
        float aux, pivote, pivoteDeBajo, det;

        Matrix matrizDeterminante = new Matrix(matrixA.getRow(), matrixA.getColumn());

        for (int i = 0; i < matrixA.getRow(); i++) {
            for (int j = 0; j < matrixA.getColumn(); j++) {
                matrizDeterminante.getData()[i][j] = matrixA.getData()[i][j];
            }
        }
    

        for (int i = 0; i < matrixA.getRow(); i++) {

            pivote = matrizDeterminante.getData()[i][i];
            for (int j = i + 1; j < matrixA.getRow(); j++) {
                pivoteDeBajo = matrizDeterminante.getData()[j][i];
                aux = pivoteDeBajo / pivote;
            
                for (int k = 0; k < matrixA.getRow(); k++) {
                    matrizDeterminante.getData()[j][k] = matrizDeterminante.getData()[j][k] - aux * matrizDeterminante.getData()[i][k];
                }
             
            }
        }
        det = 1;
       
        for (int i = 0; i < matrixA.getRow(); i++) {
            int j;
            for (j = 0; j < matrixA.getColumn(); j++) {
                if (i == j) {
                    det *= matrizDeterminante.getData()[i][j];
                }
            }
        }
        return det;

    }

    /**
     *
     * @param matrixA
     * @return Sistema de ecuacuaciones resuelto por cramer
     */
    public static Matrix cramer(Matrix matrixA) {
        float detCoeficientes, detx;

        Matrix matrizCoeficientes = new Matrix(matrixA.getRow(), matrixA.getColumn());

        for (int i = 0; i < matrixA.getRow(); i++) {
            for (int j = 0; j < matrixA.getRow(); j++) {
                matrizCoeficientes.getData()[i][j] = matrixA.getData()[i][j];
            }
        }
        detCoeficientes = determinanteMatriz(matrizCoeficientes);
        //guardo la matriz coeficientes para que no se pierda 

        Matrix matrizCoeficientesSave = new Matrix(matrixA.getRow(), matrixA.getColumn());

        for (int i = 0; i < matrixA.getRow(); i++) {
            for (int j = 0; j < matrixA.getRow(); j++) {
                matrizCoeficientesSave.getData()[i][j] = matrizCoeficientes.getData()[i][j];
            }
        }
        int noColumna = 1;
        Matrix matrizValores = new Matrix(matrixA.getRow(), noColumna);
        for (int i = 0; i < matrixA.getRow(); i++) {
            for (int j = 0; j < matrixA.getColumn(); j++) {
                if (j == matrixA.getColumn() - 1) {
                    matrizValores.getData()[i][0] = matrixA.getData()[i][j];
                  
                }
            }
        }
        int nx=0;
        //sustitución de columna por columna
        for (int k = 0; k < matrixA.getRow(); k++) {
            //recuperar los valores originales
            for (int i = 0; i < matrixA.getRow(); i++) {
                for (int j = 0; j < matrixA.getRow(); j++) {
                    matrizCoeficientes.getData()[i][j] = matrizCoeficientesSave.getData()[i][j];
                }
            }
            for (int i = 0; i < matrixA.getRow(); i++) {
                matrizCoeficientes.getData()[i][k] = matrizValores.getData()[i][0];
            }
            detx = determinanteMatriz(matrizCoeficientes);
            System.out.println("x" + k + "= " + detx / detCoeficientes);
            nx=nx+1;
        }
        Matrix matrizResultado = new Matrix(nx,1);
        imprimirMatriz(matrizResultado);
        return matrizResultado;
    }

    /**
     *
     * @param matrixA
     * @return Sistema de ecuaciones resuelto por Gauss-Jordan
     */
    public static Matrix sistemaGauss(Matrix matrixA) {

        Matrix matrizCoeficientes = new Matrix(matrixA.getRow(), matrixA.getColumn());

        for (int i = 0; i < matrixA.getRow(); i++) {
            for (int j = 0; j < matrixA.getRow(); j++) {
                matrizCoeficientes.getData()[i][j] = matrixA.getData()[i][j];
            }
        }
        int noColumna = 1;
        Matrix matrizValores = new Matrix(matrixA.getRow(), noColumna);

        for (int i = 0; i < matrixA.getRow(); i++) {
            for (int j = 0; j < matrixA.getColumn(); j++) {
                if (j == matrixA.getColumn() - 1) {
                    matrizValores.getData()[i][0] = matrixA.getData()[i][j];
                   
                }
            }
        }
        float pivote;
        Matrix vectorPivote = new Matrix(100,100);
        Matrix vectorPivoteValores = new Matrix(100,100);
        

        for (int i = 0; i < matrixA.getRow(); i++) {
            pivote = matrizCoeficientes.getData()[i][i];
           
            for (int k = 0; k < matrixA.getRow(); k++) {
                vectorPivote.getData()[k][0] = matrizCoeficientes.getData()[i][k];
                matrizCoeficientes.getData()[i][k] = matrizCoeficientes.getData()[i][k] / pivote;
                vectorPivoteValores.getData()[k][0] = matrizValores.getData()[i][0];
            }

            matrizValores.getData()[i][0] = matrizValores.getData()[i][0] / pivote;

            
            float aux;
            for (int j = 0; j < matrixA.getRow(); j++) {
                if (i != j) {
                    aux = matrizCoeficientes.getData()[j][i];
                    
                    for (int k = 0; k < matrixA.getRow(); k++) {
                        matrizCoeficientes.getData()[j][k] = matrizCoeficientes.getData()[j][k] - aux * matrizCoeficientes.getData()[i][k];
                    }
                    matrizValores.getData()[j][0] = matrizValores.getData()[j][0] - aux * matrizValores.getData()[i][0];
                  
                }
            }
        }
        imprimirMatriz(matrizValores);
        return matrizValores;
    }

    /**
     *
     * @param matrixInput
     * @return La inversa de una matriz
     */
    public static Matrix inversadeMatriz(Matrix matrixInput) {
        Matrix matrixIdentidad = new Matrix(matrixInput.getRow(), matrixInput.getColumn());
        Matrix matrixOriginal = new Matrix(matrixInput.getRow(), matrixInput.getColumn());

        float aux;
        Matrix vectorPivote = new Matrix(100,100);
        Matrix vectorPivoteIdentidad = new Matrix(100,100);

        for (int i = 0; i < matrixInput.getRow(); i++) {
            for (int j = 0; j < matrixInput.getColumn(); j++) {
                matrixOriginal.getData()[i][j] = matrixInput.getData()[i][j];
            }
        }

        for (int i = 0; i < matrixInput.getRow(); i++) {
            for (int j = 0; j < matrixInput.getColumn(); j++) {
                matrixIdentidad.getData()[i][j] = 0;
                if (i == j) {
                    matrixIdentidad.getData()[i][j] = 1;
                }
            }
        }

        float pivote;

        for (int i = 0; i < matrixInput.getRow(); i++) {
            pivote = matrixOriginal.getData()[i][i];
           
            for (int k = 0; k < matrixInput.getColumn(); k++) {
                vectorPivote.getData()[k][0] = matrixOriginal.getData()[i][k];
                matrixOriginal.getData()[i][k] = matrixOriginal.getData()[i][k] / pivote;
                vectorPivoteIdentidad.getData()[k][0] = matrixIdentidad.getData()[i][k];
                matrixIdentidad.getData()[i][k] = matrixIdentidad.getData()[i][k] / pivote;
            }
           

            for (int j = 0; j < matrixInput.getRow(); j++) {
                if (i != j) {
                    aux = matrixOriginal.getData()[j][i];
                    
                    for (int k = 0; k < matrixInput.getRow(); k++) {
                        matrixOriginal.getData()[j][k] = matrixOriginal.getData()[j][k] - aux * matrixOriginal.getData()[i][k];

                        matrixIdentidad.getData()[j][k] = matrixIdentidad.getData()[j][k] - aux * matrixIdentidad.getData()[i][k];
                    }
                    
                }
            }
        }
        return matrixIdentidad;
    }
}