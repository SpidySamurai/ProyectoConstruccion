/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Verify;

/**
 *
 * @author Javier
 */
public abstract class Verify {
     public static boolean verifySize(int row,int column){
       return row <= 5 && row >=1 || column <= 5 && column >= 1;  
     }
}
