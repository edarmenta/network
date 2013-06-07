/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package network;

import java.util.Random;
import java.io.*;
/**
 * 
 * 
 *
 * @author Ed Armenta
 */
public class randomposition{
    
    
    Random  r1= new Random();
    //int autos;
    int valorDado;
    
   /*   public int getLineas()
    {
        return autos;
    }
     
      public void setLineas(int autos)
    {
        this.autos=autos;
    }*/
        public int getPosition()
    {
        
        return valorDado;
    }
     
      public void setPosition(int callxcell)
    {     
    
    this.valorDado=r1.nextInt(callxcell);
    
    }
   
   /* public static void main(String[] args)
    {
              int lineas=100;
		
		randompoisson caro=new randompoisson();
		caro.setRpoisson(lineas);
		
		System.out.println("Hello World!" +caro.getRpoisson());
    }*/
    
}
