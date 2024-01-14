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

/* 
    Integrantes:
        Juarez Flores Axel Daniel
        Lopez Lopez Rommel Arturo
        Ceron Soto Edwin Rodrigo 
        Lopez MarÃ­n Ã�ngel Janin
        DomÃ­nguez AvilÃ©s Katya Vanessa
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

        switch(opcion) {

            case 1:
                System.out.println("Elgiste la opcion 1"); 
                System.out.println("Introduce grados Centí­grados: ");  
                Centigrados llamada =  new Centigrados();
                llamada.convertir(); 
                
                break;

            case 2:
                System.out.println("Elgiste la opcion 2"); 
                //Binary llamada_b = new Binary();
                //llamada_b.decimal(); 
                System.out.println("Ingrese un número entre 0-99: ");
                Binary.decimal(); 
                break;

            case 3:
                System.out.println("Elgiste la opcion 3"); 
                System.out.println("Metodo de Fibonachi...");
                Fibo llamada_f = new Fibo(); 
                llamada_f.numero();
                break;

            case 4:
                System.out.println("Elgiste la opcion 4"); 
                System.out.println("Ingrese un número entre 0-99: "); 
                
                Calif llamada_c = new Calif();
                llamada_c.calificacion();
                break;

        }
    }
}
