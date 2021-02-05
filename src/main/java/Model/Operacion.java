package Model;

/**
 *
 * @author Javier
 */
public abstract class Operacion {

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

    public static void imprimirMatriz(Matrix matrix) {
        float[][] data = matrix.getData();
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                System.out.print(data[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public static Matrix multiplicarPorEscalar(Matrix matrixA, int scalar) {
        Matrix matrixResult = new Matrix(matrixA.getRow(),matrixA.getColumn());
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
            }
            imprimirMatriz(matrixResult);
            return matrixResult;
        } else {
            System.out.println("\nAl no coincidir las columnas de la matriz A con las filas de la matriz B,"
                    + " no es posible realizar la multiplicaciÃ³n de matrices.");
        }
        return null;
    }

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

    public static float determinanteMatriz(Matrix matrixA) {
        float aux, pivote, pivoteDeBajo, det;

        Matrix matrizDeterminante = new Matrix(matrixA.getRow(), matrixA.getColumn());

        for (int i = 0; i < matrixA.getRow(); i++) {
            for (int j = 0; j < matrixA.getColumn(); j++) {
                matrizDeterminante.getData()[i][j] = matrixA.getData()[i][j];
            }
        }
        /*System.out.println(" Matriz");
        imprimirMatriz(matrizDeterminante,filasN,columnasN);*/

        for (int i = 0; i < matrixA.getRow(); i++) {

            pivote = matrizDeterminante.getData()[i][i];
            for (int j = i + 1; j < matrixA.getRow(); j++) {
                pivoteDeBajo = matrizDeterminante.getData()[j][i];
                aux = pivoteDeBajo / pivote;
                //System.out.printf("A la fila %d se le resta %f/%f la fila %d",j+1,pivoteDeBajo,pivote,i+1);
                for (int k = 0; k < matrixA.getRow(); k++) {
                    matrizDeterminante.getData()[j][k] = matrizDeterminante.getData()[j][k] - aux * matrizDeterminante.getData()[i][k];
                }
                //imprimirMatriz(matrizDeterminante,filasN,columnasN);
            }
        }
        det = 1;
        //System.out.println("Despues de hacer 0 los números debajo de los numeros de la diagonal principal, se multiplican los números de la diagonal para obtener el determinante");
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

    public static void cramer(Matrix matrixA) {
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
                    //System.out.printf(" %f",matrizValores[i][0]);
                }
            }
        }
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
        }
    }

    public static void sistemaGauss(Matrix matrixA) {

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
                    //printf(" %f",matrizValores[i][0]);
                }
            }
        }
        float pivote;
        Matrix vectorPivote = new Matrix(100,100);
        Matrix vectorPivoteValores = new Matrix(100,100);
        /* float vectorPivote[] = new float [100];
        float vectorPivoteValores[] = new float [100];*/

        for (int i = 0; i < matrixA.getRow(); i++) {
            pivote = matrizCoeficientes.getData()[i][i];
            /* System.out.println("\nMatriz antes de modificar el pivote");
            imprimirMatriz(matrizCoeficientes,matrixA.getRow(),matrixA.getRow()); 
            imprimirMatriz(matrizValores,filasN,1);
            System.out.printf("Hacer 1 al pivote con valor %f\n en la fila %d y aplicar en toda la fila la operacion",pivote,i+1);*/
            for (int k = 0; k < matrixA.getRow(); k++) {
                vectorPivote.getData()[k][0] = matrizCoeficientes.getData()[i][k];
                matrizCoeficientes.getData()[i][k] = matrizCoeficientes.getData()[i][k] / pivote;
                vectorPivoteValores.getData()[k][0] = matrizValores.getData()[i][0];
            }

            matrizValores.getData()[i][0] = matrizValores.getData()[i][0] / pivote;

            /*   for(int h=0;h<matrixA.getRow();h++)
            {
                System.out.printf(" %f/%f",vectorPivote[h],pivote);
            }
            for(int m=0;m<1;m++)
            {
                System.out.printf(" %f/%f",vectorPivoteValores[m],pivote);
            }
		
            imprimirMatriz(matrizCoeficientes,filasN,filasN); 
            imprimirMatriz(matrizValores,filasN,1);*/
            float aux;
            for (int j = 0; j < matrixA.getRow(); j++) {
                if (i != j) {
                    aux = matrizCoeficientes.getData()[j][i];
                    /* System.out.printf("\nA la fila %d con datos :",j+1);
                    for(int k=0;k<matrixA.getRow();k++)
                    {
                        System.out.printf("  %f ",matrizCoeficientes.getData()[j][k]);
                    }
				
                    System.out.printf("  %f ",matrizValores.getData()[j][0]);
				
                    System.out.printf("Restarle la fila %d multiplicada por %f",i+1,aux);*/
                    for (int k = 0; k < matrixA.getRow(); k++) {
                        matrizCoeficientes.getData()[j][k] = matrizCoeficientes.getData()[j][k] - aux * matrizCoeficientes.getData()[i][k];
                    }
                    matrizValores.getData()[j][0] = matrizValores.getData()[j][0] - aux * matrizValores.getData()[i][0];
                    /*System.out.printf("\nMatriz");
                    imprimirMatriz(matrizCoeficientes,filasN,filasN);
                    System.out.printf("\nMatriz Valores");
                    imprimirMatriz(matrizValores,filasN,1);*/
                }
            }
        }
    }

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
            /*printf("\nMatriz antes de modificar el pivote");
		imprimirMatriz(filas,columnas,matrizOriginal); 
		imprimirMatriz(filas,columnas,matrizIdentidad);
		printf("Hacer 1 al pivote con valor %f\n en la fila %d y aplicar en toda la fila la operacion",pivote,i+1);*/
            for (int k = 0; k < matrixInput.getColumn(); k++) {
                vectorPivote.getData()[k][0] = matrixOriginal.getData()[i][k];
                matrixOriginal.getData()[i][k] = matrixOriginal.getData()[i][k] / pivote;
                vectorPivoteIdentidad.getData()[k][0] = matrixIdentidad.getData()[i][k];
                matrixIdentidad.getData()[i][k] = matrixIdentidad.getData()[i][k] / pivote;
            }
            /*for(int m=0;m<matrixA.getColumn();m++)
		{
			printf(" %f/%f",vectorPivote[m],pivote);
		}
		for(int i=0;i<columnas;i++)
		{
			printf(" %f/%f",vectorPivoteIdentidad[i],pivote);
		}
		
		imprimirMatriz(filas,columnas,matrizOriginal); 
		imprimirMatriz(filas,columnas,matrizIdentidad);*/

            for (int j = 0; j < matrixInput.getRow(); j++) {
                if (i != j) {
                    aux = matrixOriginal.getData()[j][i];
                    //printf("\nA la fila %d con datos :",j+1);
                    /*for(int k=0;k<filas;k++)
				{
					printf("  %f ",matrizOriginal[j][k]);
				}
				for(int k=0;k<filas;k++)
				{
					printf("  %f ",matrizIdentidad[j][k]);
				}
				printf("Restarle la fila %d multiplicada por %f",i+1,aux);*/
                    for (int k = 0; k < matrixInput.getRow(); k++) {
                        matrixOriginal.getData()[j][k] = matrixOriginal.getData()[j][k] - aux * matrixOriginal.getData()[i][k];

                        matrixIdentidad.getData()[j][k] = matrixIdentidad.getData()[j][k] - aux * matrixIdentidad.getData()[i][k];
                    }
                    /*printf("\nMatriz");
				imprimirMatriz(filas,columnas,matrizOriginal);
				printf("\nMatriz Identidad");
				imprimirMatriz(filas,columnas,matrizIdentidad);*/
                }
            }
        }

        //printf("La matriz inversa queda :\n");
        //imprimirMatriz(filas,columnas,matrizIdentidad);
        return matrixIdentidad;
    }
}
