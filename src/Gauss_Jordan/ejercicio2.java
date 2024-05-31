/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Gauss_Jordan;

/**
 *
 * @author tono_
 */
public class ejercicio2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      System.out.println("GAUSS-JORDAN");
        double[][] matriz = 
        {   {1, 2, -1, 4},
            {2, 3, -1, 7},
            {3, 1, 2, 11} };
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