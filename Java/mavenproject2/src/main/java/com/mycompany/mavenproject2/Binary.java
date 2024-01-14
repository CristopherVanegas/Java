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
public class Binary {

    public static void decimal() {
        //System.out.print("Ingrese un número entre 0-99: ");
        
        Scanner scanner = new Scanner(System.in);
        int numeroDecimal = scanner.nextInt();
        
        String binario = Integer.toBinaryString(numeroDecimal);
        System.out.println(numeroDecimal + " base 10 = " + binario + " base 2");
    } 
}
