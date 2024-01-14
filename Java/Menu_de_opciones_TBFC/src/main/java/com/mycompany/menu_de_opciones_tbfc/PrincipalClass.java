/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.menu_de_opciones_tbfc;

import java.util.Scanner;

/**
 *
 * @author cristophervanegas
 */
public class PrincipalClass {

    public static void main(String args[]) {
        int opcion;
        System.out.println("Selecciona una funcion \n\t");
        System.out.println("1. Convertir de grados centigrados a grados farenheit \n\t");
        System.out.println("2. Convertir de base 10 a base 2 \n\t");
        System.out.println("3. Serie de fibonacci \n\t");
        System.out.println("4. Convertir calificaciones numericas a letras \n\t");
        Scanner scn = new Scanner(System.in);
        opcion = scn.nextInt();

        switch (opcion) {

            case 1:
                System.out.println("Elgiste la opcion 1");
                System.out.println("Introduce grados Centí­grados: ");
                //Centigrados llamada = new Centigrados();
                convertir();

                break;

            case 2:
                System.out.println("Elgiste la opcion 2");
                //Binary llamada_b = new Binary();
                //llamada_b.decimal(); 
                System.out.println("Ingrese un número entre 0-99: ");
                decimal();
                break;

            case 3:
                System.out.println("Elgiste la opcion 3");
                System.out.println("Metodo de Fibonachi...");
                //Fibo llamada_f = new Fibo();
                numero();
                break;

            case 4:
                System.out.println("Elgiste la opcion 4");
                System.out.println("Ingrese un número entre 0-99: ");

                //Calif llamada_c = new Calif();
                calificacion();
                break;

        }
    }

    public static void decimal() {
        //System.out.print("Ingrese un número entre 0-99: ");

        Scanner scanner = new Scanner(System.in);
        int numeroDecimal = scanner.nextInt();

        String binario = Integer.toBinaryString(numeroDecimal);
        System.out.println(numeroDecimal + " base 10 = " + binario + " base 2");
    }

    public static void calificacion() {
        String unidades[] = {"cero", "uno", "dos", "tres", "cuatro", "cinco", "seis", "siete", "ocho", "nueve", "diez"};
        String especiales[] = {"once", "doce", "trece", "catorce", "quince", "diecisÃ©is", "diecisiete", "dieciocho", "diecinueve"};
        String decenas[] = {"veinte", "treinta", "cuarenta", "cincuenta", "sesenta", "setenta", "ochenta", "noventa"};

        Scanner scanner = new Scanner(System.in);
        //System.out.print("Ingrese un número entre 0-99: ");
        int num = scanner.nextInt();

        if (num >= 0 && num < 11) {
            System.out.print('\n' + unidades[num]);

        } else if (num < 20) {
            System.out.print('\n' + especiales[num - 11]);

        } else if (num < 100) {
            int unid = num % 10;
            int dec = num / 10;
            if (unid == 0) {
                System.out.print('\n' + decenas[dec - 2]);
            } else {
                System.out.print('\n' + decenas[dec - 2] + " y " + unidades[unid]);
            }
        } else {
            System.out.print("La calificación máxima debe ser 100");
        }
    }

    public static void convertir(/*float gradosC, float gradosF*/) {
        Scanner scn = new Scanner(System.in);
        //System.out.println("Introduce grados Centí­grados: ");
        float gradosC = scn.nextFloat();
        float gradosF = (32 + (9 * gradosC / 5));
        System.out.println(gradosC + " ºC = " + gradosF + " ºF");

        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates. 
    }

    public static void numero() {
        int num1 = 0;
        int num2 = 1;
        int temp;
        int limite = 10;
        System.out.println(num1);
        System.out.println(num2);

        while (num2 + num1 <= limite) {
            temp = num1;
            num1 = num2;
            num2 = temp;
        }
    }
}
