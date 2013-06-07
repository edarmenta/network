/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package network;
import java.io.*;
import java.lang.Math.*;
import java.util.Random;
import java.io.IOException;
import network.randomposition;

import java.util.*;

import org.apache.commons.math3.distribution.AbstractRealDistribution;
import org.apache.commons.math3.distribution.NormalDistribution;
import org.apache.commons.math3.distribution.ExponentialDistribution;

/**
 *
 * @author Ed Armenta
 */
public class Auto {
    public float numdecarro=0;
    public float tiempo=0;
    public float coorX=0;
    public float coorY=0;
    public float velocidad=0;
    public float tiempoacum = 0;
    public double bettime = 0;
    public int unidadtiempo = 0;
    public double NoH = 0;
    public double probaNoH = 0;
    //public int bound = 0;
    public int i = 0;
    public double aux = 0;
    int counter=0; //counter for callquantity    
    int callquan=50; //call quantity for choosing a random position to address a call
    randomposition callposition  =  new randomposition();
    int position=0;
    double arreglo=0;
    double t=0;
    double T=3600;
    double I=0;
    double s=0;
    
    
    ArrayList calltimetable = new ArrayList();
    ArrayList probabilitytable = new ArrayList();
    ArrayList restimetable = new ArrayList();
    ArrayList time20 = new ArrayList();
    ArrayList speedValues = new ArrayList();
    ArrayList Nohandovers = new ArrayList();
    ArrayList probabilityNoH = new ArrayList();
    ArrayList<Integer> callxcell = new ArrayList();
    
    
    public boolean handsolpicX0=false;
    public boolean handsolpicX1=false;
    public boolean handsolpicX2=false;
    public boolean handsolpicX3=false;
    public boolean handsolpicX4=false;
    
    public boolean handsolpicY0=false;   
    public boolean handsolpicY1=false;  
    public boolean handsolpicY2=false;
    public boolean handsolpicY3=false;
    public boolean handsolpicY4=false;
    
    
    public boolean handpicX0=false;
    public boolean handpicX1=false;
    public boolean handpicX2=false;
    public boolean handpicX3=false;
    public boolean handpicX4=false;
    
    public boolean handpicY0=false;
    public boolean handpicY1=false;
    public boolean handpicY2=false;
    public boolean handpicY3=false;
    public boolean handpicY4=false;
    
    public double tiempores=0;
    public double tiempoexp=0;
    public boolean incall=false;
    public boolean incomingcall=false;
    public int callgenerator=0;
   
    
    public double calltimes = 0;
    public int origin=0;
    public double probability=0;
    public  double probabilityexpo=0;
    
    NormalDistribution tresol;
    ExponentialDistribution tcall;
    
    Random r = new Random();
    double ran = r.nextGaussian();

   
    //public float 
//    public int autos=10;
    
    
    
    public double getNoH ()
    {
        return NoH;
    }
    
    public void setNoH (double tc,double velocidad)
    {
        this.NoH = Math.floor(tc/velocidad);
    }
    
    public double getProbabilityNoH()
    {
        return probaNoH;
    }
    
    public void setProbabilityNoH(double xe, double velocidad, double bound)
    {
        for(i=0; i<2; i++ )
        aux = Math.exp((-velocidad*xe)*(i))- Math.exp((-velocidad*xe)*(i+1));
        this.probaNoH = 1+aux;
        probabilityNoH.add(probaNoH);
    }
    
    
    public float getCarro()
    {
        return numdecarro;
    }
    
    public void setCarro(float numdecarro)
    {
        this.numdecarro=numdecarro;
    }
    
    public float getTiempo()
    {
        return tiempo;
    }
    
    public void setTiempo(float tiempo)
    {
        this.tiempo=tiempo;
    }
    public float getCoorX()
    {
        return coorX;
    }
    
    public void setCoorX(float coorX)
    {
        this.coorX=coorX;
    }
    public float getCoorY()
    {
        return coorY;
    }
    
    public void setCoorY(float coorY)
    {
        this.coorY=coorY;
    }
    public float getVelocidad()
    {
        return velocidad;
    }
    
    public void setVelocidad(float velocidad)
    {
        this.velocidad=velocidad;
    }
    public boolean getHandpicX1()
    {
        return handpicX1;
    }
    
    public void setHandpicX1(boolean activo)
    {
        this.handpicX1=activo;
    }
    public boolean getHandpicY1()
    {
        return handpicY1;
    }
    
    public void setHandpicY1(boolean activo)
    {
        this.handpicY1=activo;
    }
    public boolean getHandpicX2()
    {
        return handpicX2;
    }
    
    public void setHandpicX2(boolean activo)
    {
        this.handpicX2=activo;
    }
    public boolean getHandpicY2()
    {
        return handpicY2;
    }
    
    public void setHandpicY2(boolean activo)
    {
        this.handpicY2=activo;
    }
    
    public boolean getHandpicX3()
    {
        return handpicX3;
    }
    
    public void setHandpicX3(boolean activo)
    {
        this.handpicX3=activo;
    }
    public boolean getHandpicY3()
    {
        return handpicY2;
    }
    
    public void setHandpicY3(boolean activo)
    {
        this.handpicY2=activo;
    }
  
    public void setTiempoexp ()
     {
        //para generar el tiempo con distribucion normal a cada llamada que entre en la zona de handover 
       tiempoexp = tcall.sample();
     }
    
     public double getTiempoexp () 
    {
        return tiempoexp;
    }
    
    public void setExpo (double xe)
    {
        tcall=new ExponentialDistribution(xe);
    }
    
    public ExponentialDistribution getExpo()
    {
        return tcall;
    }
   
    
    public double getProbabilityexpo ()
    {
        return probabilityexpo;
    }
    
    public void setProbabilityexpo (double lowerboundexp)
    {
        this.probabilityexpo = tcall.cumulativeProbability(lowerboundexp);
    }
    
       
    
    public void setNormal (double x, double y)
    {
        tresol=new NormalDistribution(x,y);
    }
    
    public NormalDistribution getNormal()
    {
        return tresol;
    }
   
    
    public double getProbability ()
    {
        return probability;
    }
    
    public void setProbability (double lowerbound, double upperbound)
    {
        this.probability = tresol.cumulativeProbability(lowerbound, upperbound);
    }
    
    
      public double getTiempores () 
    {
        return tiempores;
    }
    
    
     public void setTiempores ()
     {
        //para generar el tiempo con distribucion normal a cada llamada que entre en la zona de handover 
       tiempores=0;
         while(tiempores<=0)
         
         tiempores = tresol.sample();
     }
     
     public void setCalls(double landa)
     {
          //while(counter<callquan)//ciclo para asignacion de llamadas
            //{
                
                //System.out.println(/*"llamada en carro" + " " +*/"0"+ position);
                if (incomingcall==false) //condicion para asignar llamada
                {
                    incomingcall=true;
                    //calls++;
                    //System.out.println("llamada en carro" + " " +position);
                }
                //counter++;
                
                if (incomingcall==true)
                {
                    arreglo= r.nextDouble(); //asignacion de un numero aleatorio entre 0 y 1 			
                    t=t-landa * Math.log(arreglo); //formula para generar el proceso poisson

                    if(t<T && incomingcall==true) //comparacion del cada valor en cada i contra la ventana de tiempo para poisson
                    {
                            I=I+1; // asigna y acumula el numero de enventos
                            s=t; // asigna el tiempo del evento mas reciente a s
                            bettime=s;
                    }
                }
            //}
     }
     
     
     }
    
     
     /*public void setTiempores (double x, double y)
             
     {   
         double pos =-1;
         while (pos < 0)
         {
             ran=r.nextGaussian();
             pos = (y * ran + x) + y;
         }
        this.tiempores= pos;
     }
            
            
    
    /*public void main ()
    {
              Auto [] arregloautos = new Auto[5];   
              arregloautos[1].coorX =5;
              System.out.println(arregloautos[1].coorX);
    }
    
   //  Auto arregloautos [] = new Auto[autos];
     */    

    
            
    
