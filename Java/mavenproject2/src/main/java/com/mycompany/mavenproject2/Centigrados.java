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
public class Centigrados {

    public static void convertir(/*float gradosC, float gradosF*/) {
        Scanner scn = new Scanner(System.in);
        //System.out.println("Introduce grados Centí­grados: ");
        float gradosC = scn.nextFloat();
        float gradosF = (32 + (9 * gradosC / 5));
        System.out.println(gradosC + " ºC = " + gradosF + " ºF"); 
                
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates. 
    }
}
