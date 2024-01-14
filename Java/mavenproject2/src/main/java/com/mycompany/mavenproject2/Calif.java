/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject2;

import java.util.Scanner;

/**
 *
 * @author cristophervanegas
 */
public class Calif {

    public void calificacion() {
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
}
