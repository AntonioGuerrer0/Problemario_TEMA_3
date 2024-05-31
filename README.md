# Tema-3
Realizado por:
  <li> Jose Antonio Guerrero Lazcano</li>
<h2 align = "center"> <font color = "darkorange" size = "+6"  font face = "bauhaus 93">  Indice </font> </h2>
<header> <font color = "red" size="+1" font face = "aharoni">
                <nav class="navegacion">
                    <ul class="Indice">
                       <li> <a href="#Descripción"> Descripción del Problemario </a> <br> </li>
                        <li> <a href="#Sobre la materia"> Sobre la materia </a> <br> </li>
                            <ul class="subindice"> 
                                <li> <a href="#Competencia de la Asignatura"> Competencia de la Asignatura </a> </li>
                                <li> <a href="#Competencia del tema"> Competencia del TEMA </a> </li>
                            </ul>
     <li> <a href="#Métodos numéricos para encontrar las raíces de ecuaciones que se encuentran en nuestro repositorio"> Sistemas de ecuaciones </a> <br> </li>
                            <ul class="subindice"> 
                                <li> <a href="#Eliminacion"> Eliminación-Gaussiana </a> </li>
                                <li> <a href="#Gauss"> Gauss-Jordan </a> </li>
                                <li> <a href="#Seidel"> Gauss-Seidel </a> </li> 
                                <li> <a href="#Jacobi"> Método de Jacobi </a> </li> 
                            </ul>
                    </ul>
                </nav>
            </font> </header>

# Descripción
En este documento vamos a ver varios ejercicios sobre los distintos metodos como lo son:
  <li>1.- Eliminación-Gaussiana</li>
  <li>2.- Gauss-Jordan</li>
  <li>3.- Gauss-Seidel</li>
  <li>4.- Jacobi</li>
  
# Sobre la materia 
<h2 align = "center"> <font  size = "+6" > <a name="Competencia de la Asignatura">Competencia de la asignatura</font></a> </h2>
Aplica los métodos numéricos para resolver problemas científicos y de ingeniería utilizando la computadora.
<h2 align = "center"> <font size = "+6"  > <a name="Competencia del tema">Competencia del tema</font> </a></h2>
Aplica los métodos numéricos con el objeto de solucionar ecuaciones mediante los métodos de intervalo e interpolación apoyada de un lenguaje de programación.  

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
<h1 align = "center"> <font  font face = "bauhaus 93"> <a name="Sistemas de ecuaciones"> Sistemas de ecuaciones </font></a> </h1>

<h2 align = "center"> <font font face = "forte"><a name="Eliminacion">  1. Eliminación Gaussiana </h2></a>

<h3> <font font face = "arial"> DESCRIPCIÓN: </h3>

La eliminación gaussiana es un método utilizado en álgebra lineal para resolver sistemas de ecuaciones lineales de una manera sistemática y paso a paso. Este método consiste en llevar un sistema de ecuaciones a una forma matricial, convertir una matriz cuadrada en una matriz triangular superior equivalente a la original y luego resolver el sistema sustituyendo las variables en cada ecuación resultante:

<h3> <font font face = "arial">Pasos de la eliminación Gaussiana:</h3>
<h5>Formar la matriz aumentada:</h5> Combinar la matriz de coeficientes y el vector de términos independientes en una sola matriz aumentada.
<h5>Pivoteo parcial: </h5> Si es necesario, intercambiar filas para asegurar que el elemento en la posición de pivote sea el mayor en valor absoluto en su columna.
<h5>Escalonar la matriz: </h5> Comenzar con la primera fila y hacer ceros debajo del elemento de pivote, utilizando operaciones elementales de fila.
<h5>Repetir el proceso: </h5> Aplicar el mismo procedimiento a las filas restantes, avanzando hacia abajo y creando ceros debajo de los pivotes.
<h5>Sustitución hacia atrás: </h5> Una vez que la matriz está en forma triangular superior, resolver el sistema de ecuaciones resultante mediante sustitución hacia atrás, empezando por la última ecuación y despejando las incógnitas hacia arriba.
<h5>Verificar la solución: </h5> Sustituir las soluciones encontradas en las ecuaciones originales para comprobar si satisfacen todas las ecuaciones del sistema.
   
<h5> <font font face = "arial"> <b> <i> Ejemplo 1: </i> </b> </h5>

    package Eliminacion_Gaussiana;

    public class ejercicio1 {

    public static void main(String[] args) {
        int n = 3;
        double[][] matrix = {
                {3.0, -0.1, -0.2, 7.85},
                {0.1, 7.0, -0.3, -19.3},
                {0.3, -0.2, 10.0, 71.4}
        };
        double[] result = Eliminacion(matrix, n);
        for (int i = 0; i < n; i++) {
            System.out.println("x[" + i + "] = " + result[i]);
        }
    }

    public static double[] Eliminacion(double[][] matrix, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                double factor = matrix[j][i] / matrix[i][i];
                for (int k = i; k < n + 1; k++) {
                    matrix[j][k] -= factor * matrix[i][k];
                }
            }
        }

        double[] result = new double[n];
        for (int i = n - 1; i >= 0; i--) {
            result[i] = matrix[i][n];
            for (int j = i + 1; j < n; j++) {
                result[i] -= matrix[i][j] * result[j];
            }
            result[i] /= matrix[i][i];
        }

        return result;
    }
    }



![Captura de pantalla 2024-05-30 230412](https://github.com/AntonioGuerrer0/Problemario_TEMA_3/assets/161759650/9e71a232-e654-43b5-b365-b490ccc00c04)


      


<h2 align = "center"> <font font face = "forte"> <a name="Gauss">  2.- Gauss-Jordan </h2></a>

<h3> <font font face = "arial"> DESCRIPCIÓN: </h3>

El método de Gauss-Jordan es una variante del método de eliminación gaussiana que se utiliza para resolver sistemas de ecuaciones lineales. En este método, al igual que en la eliminación gaussiana, se busca llevar la matriz de coeficientes a una forma escalonada, pero con la diferencia de que se busca obtener una matriz escalonada reducida a su forma más simple, conocida como forma escalonada reducida por filas o forma canónica.

<h3> <font font face = "arial">Pasos del Método de Gauss Jordan: </h3>
<h5>Formar la Matriz Aumentada: </h5> Se comienza escribiendo el sistema de ecuaciones en forma matricial, creando una matriz aumentada que incluya tanto los coeficientes de las variables como los términos independientes.
<h5>Escalonar la Matriz: </h5>Se aplican operaciones elementales de fila para obtener ceros debajo de la diagonal principal y unos en la diagonal principal. Esto implica realizar operaciones como intercambiar filas, multiplicar filas por constantes y sumar múltiplos de unas filas a otras.
<h5>Reducir la Matriz a su Forma Escalonada Reducida: </h5>Se continúa escalonando la matriz hasta obtener una forma escalonada reducida, donde la parte de los coeficientes de las variables se convierte en una matriz identidad.
<h5>Obtener las Soluciones: </h5>Una vez se ha alcanzado la forma escalonada reducida, se leen las soluciones directamente de la matriz identidad. Cada fila de la matriz identidad corresponde a una variable del sistema de ecuaciones.
<h5>Verificar las Soluciones: </h5> Es importante comprobar las soluciones obtenidas sustituyéndolas en las ecuaciones originales para asegurarse de que satisfacen todas las ecuaciones del sistema.
   
<h5> <font font face = "arial"> <b> <i> Ejemplo 1: </i> </b> </h5>


    package Gauss_Jordan;
    
    /**
     *
     * @author tono_
     */
    public class ejercicio1 {
    
       
        public static void main(String[] args) {
           System.out.println("GAUSS-JORDAN");
            double[][] matriz = 
            {   {3, -1, 2, 5},
                {2, 1, 1, 7},
                {1, 3, -2, 4} };
            double[][] resultados = operaciones(matriz);
            Resultados(resultados);
        }
    
        public static double[][] operaciones(double[][] matriz) {
            int fila = matriz.length;
            int columna = matriz[0].length;
            for (int i = 0; i < fila; i++) {
                double pivote = matriz[i][i];
                for (int j = i + 1; j < columna; j++) {
                    matriz[i][j] /= pivote;
                }
                matriz[i][i] = 1;
                for (int j = 0; j < fila; j++) {
                    if (i != j) {
                        double epala = matriz[j][i];
                        for (int k = i; k < columna; k++) {
                            matriz[j][k] -= epala * matriz[i][k];
                        }
                    }
                }
            }
            return matriz;
        }
    
        public static void Resultados(double[][] matriz) {
            System.out.println("Los resultados son: ");
            System.out.println("X = " + matriz[0][3]);
            System.out.println("Y = " + matriz[1][3]);
            System.out.println("Z = " + matriz[2][3]);
        }
    }


![Captura de pantalla 2024-05-30 230610](https://github.com/AntonioGuerrer0/Problemario_TEMA_3/assets/161759650/2e6dadab-2acd-4e4d-85d3-2e7e66ea4e44)


    
<h2 align = "center"> <font font face = "forte"> <a name="Seidel">  3.- Gauss-Seidel </h2></a>

<h3> <font font face = "arial"> DESCRIPCIÓN: </h3>

El método de Gauss-Seidel es una técnica iterativa utilizada para resolver sistemas de ecuaciones lineales. En este método, se mejora el método de Jacobi al utilizar las soluciones más recientes a medida que se calculan, en lugar de esperar a completar una iteración completa. Esto significa que las soluciones se actualizan en cada paso, lo que puede acelerar la convergencia del método.

<h3> <font font face = "arial">Pasos de Gauss-Seidel:</h3>
<h5>Inicialización de las Variables: </h5> Se comienza con una estimación inicial de las soluciones del sistema de ecuaciones lineales.
<h5>Iteración:</h5>Para cada ecuación en el sistema:
<li>Utilizar los valores más recientes de las variables ya calculadas.</li>
<li>Resolver la ecuación para encontrar una nueva estimación de la variable.</li>
<li>Actualizar el valor de la variable con la nueva estimación.</li>
<li>Repetir este proceso para todas las ecuaciones del sistema en cada iteración.</li>
<h5>Criterio de parada:</h5><li>Establecer un criterio de convergencia, como una tolerancia o un número máximo de iteraciones.</li>
<li>Verificar si se ha alcanzado la precisión deseada o el número máximo de iteraciones.</li>
<h5>Convergencia:</h5><li> Comprobar si el método converge hacia la solución del sistema de ecuaciones lineales.</li>
<li>Ajustar los parámetros, como la elección inicial y la precisión, si es necesario para mejorar la convergencia.</li>
<h5>Obtencion de soluciones:</h5> <li>Una vez que se alcanza la convergencia, las soluciones obtenidas en la última iteración se consideran como las soluciones aproximadas del sistema de ecuaciones lineales.</li>
   
<h5> <font font face = "arial"> <b> <i> Ejemplo 1: </i> </b> </h5>

   
    package Seidel;
    
    /**
     *
     * @author tono_
     */
    public class ejercicio1 {
    
        /**
         * @param args the command line arguments
         */
        public static void main(String[] args) {
        double[][] A = {
                    {3.0, -0.1, -0.2},
                    {0.1, 7.0, -0.3},
                    {0.3, -0.2, 10.0}
            };
            double[] b = {7.85, -19.3, 71.4};
            double[] x = gaussSeidel(A, b);
            for (int i = 0; i < x.length; i++) {
                System.out.println("x[" + i + "] = " + x[i]);
            }
            
            System.out.println("Me da ese redondeo por la tolerancia de los puntos decimales. ");
    
        }
    
        public static double[] gaussSeidel(double[][] A, double[] b) {
            int n = A.length;
            double[] x = new double[n];
            double[] newX = new double[n];
            int max = 100;
            double epsilon = 1e-10;
    
            for (int iter = 0; iter < max; iter++) {
                for (int i = 0; i < n; i++) {
                    newX[i] = b[i];
                    for (int j = 0; j < n; j++) {
                        if (j != i) {
                            newX[i] -= A[i][j] * x[j];
                        }
                    }
                    newX[i] /= A[i][i];
                }
    
                boolean stop = true;
                for (int i = 0; i < n; i++) {
                    if (Math.abs(newX[i] - x[i]) > epsilon) {
                        stop = false;
                        break;
                    }
                }
    
                if (stop) {
                    break;
                }
    
                System.arraycopy(newX, 0, x, 0, n);
            }
            return x;
        }
    }
![Captura de pantalla 2024-05-30 230740](https://github.com/AntonioGuerrer0/Problemario_TEMA_3/assets/161759650/df17d8f7-4d84-4434-920e-ad37743069b2)



    

    
<h2 align = "center"> <font font face = "forte"> <a name="Jacobi">  4. Jacobi </h2></a>

<h3> <font font face = "arial"> DESCRIPCIÓN: </h3>

El método de Jacobi es un algoritmo iterativo utilizado para resolver sistemas de ecuaciones lineales. En este método, se descompone la matriz de coeficientes del sistema en una suma de una matriz diagonal y dos matrices complementarias. Luego, se utiliza esta descomposición para iterar y encontrar soluciones aproximadas para el sistema de ecuaciones.

<h3> <font font face = "arial">Pasos del método de Jacobi:</h3>
<h5>Descomposición de la matriz: </h5><li> Descomponer la matriz de coeficientes del sistema en una matriz diagonal 
D y dos matrices complementarias L y U, de forma que = ++A=D+L+U, donde:</li>
<li>D es la matriz diagonal que contiene los elementos diagonales de A.
<li>L es la matriz triangular inferior con ceros en la diagonal.</li>
<li>U es la matriz triangular superior con ceros en la diagonal.</li>
<h5>Inicialización: </h5><li>Inicializar un vector de soluciones inicial x(0).</li>
<li>Establecer un criterio de convergencia, como una tolerancia ϵ o un número máximo de iteraciones.</li>
<h5>Iteración: </h5><li>Establecer un criterio de convergencia, como una tolerancia o un número máximo de iteraciones.</li>
<li>Verificar si se ha alcanzado la precisión deseada o el número máximo de iteraciones.</li>
<h5>Criterio de Parada: </h5><li>Verificar si se ha alcanzado la convergencia comparando la diferencia entre las soluciones actuales y las anteriores con la tolerancia establecida.</li>
<li>Detener las iteraciones si se cumple el criterio de convergencia o se alcanza el número máximo de iteraciones.</li>
<h5>Obtencion de soluciones:</h5> <li>Las soluciones aproximadas obtenidas en la última iteración se consideran como las soluciones del sistema de ecuaciones lineales.</li>
   
<h5> <font font face = "arial"> <b> <i> Ejemplo 1: </i> </b> </h5>

    package Jacobi;
    
    /**
     *
     * @author tono_
     */
    public class ejercicio1 {
    
         public static final double EPSILON = 0.0001;
        public static final int MAX_ITERATIONS = 100;
    
        public static void main(String[] args) {
            double[][] coefficients = {{3, -1, 1}, {2, 4, -1}, {-1, 2, 5}};
            double[] constants = {4, 1, 1}; 
            double[] solution = solveJacobi(coefficients, constants);
            
            System.out.println("Solución encontrada:");
            for (int i = 0; i < solution.length; i++) {
                System.out.println("x" + (i + 1) + " = " + solution[i]);
            }
        }
    
        public static double[] solveJacobi(double[][] coefficients, double[] constants) {
            int n = constants.length;
            double[] solution = new double[n];
            double[] nextSolution = new double[n];
            int iterations = 0;
            boolean converged = false;
    
            while (!converged && iterations < MAX_ITERATIONS) {
                for (int i = 0; i < n; i++) {
                    double sum = constants[i];
                    for (int j = 0; j < n; j++) {
                        if (j != i) {
                            sum -= coefficients[i][j] * solution[j];
                        }
                    }
                    nextSolution[i] = sum / coefficients[i][i];
                }
    
                double maxDifference = 0.0;
                for (int i = 0; i < n; i++) {
                    double difference = Math.abs(nextSolution[i] - solution[i]);
                    if (difference > maxDifference) {
                        maxDifference = difference;
                    }
                }
    
                if (maxDifference < EPSILON) {
                    converged = true;
                }
    
                for (int i = 0; i < n; i++) {
                    solution[i] = nextSolution[i];
                }
    
                iterations++;
            }
    
            if (iterations == MAX_ITERATIONS) {
                System.out.println("El método no converge después de " + MAX_ITERATIONS + " iteraciones.");
            }
    
            return solution;
        }
    }


![Captura de pantalla 2024-05-30 230853](https://github.com/AntonioGuerrer0/Problemario_TEMA_3/assets/161759650/c0a992a2-95d0-4b6d-a90f-b1c3038aec55)

    


    


