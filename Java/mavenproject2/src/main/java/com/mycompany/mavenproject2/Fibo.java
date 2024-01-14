/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject2;

/**
 *
 * @author cristophervanegas
 */
public class Fibo {

    public void numero() {
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

