    /*
    * To change this template, choose Tools | Templates
    * and open the template in the editor.
    */
    package network;

    import java.util.*;
    import java.io.*;
    import java.lang.Math;
    //import org.jfree.chart.ChartFactory;
    //import org.jfree.chart.ChartUtilities;
    //import org.jfree.chart.JFreeChart;
    //import org.jfree.chart.plot.*;
    //import org.jfree.data.category.DefaultCategoryDataset;
    import java.util.Vector;
    import java.lang.String;
    import java.io.BufferedReader;
    import java.io.File;
    import java.io.FileReader;
    import java.io.IOException;
    import network.Auto;
    import network.randomposition;
    
    /**
    *
    * @author Ed Armenta
    */
    public class Network {

    /**
    * @param args the command line arguments
    */

    public static void main(String[] args) throws Exception

    {

        double landa = 0.2; // landa para la distribucion poisson dada para el arrivo de eventos
        double mediaexptc =360; // segundos
        
       
        
        int autos = 4;
        int totalines = 404;
        int callquan=5; //call quantity for choosing a random position to address a call
        double standardeviation = 0.1;
        int availchannel = 1;
        int lineas = 0;
        
        int i=0;
        double velmediagral = 0;
        double mediatransit = 0;
        double mediaresol1 = 0;
        int celllist = 0;
        int cycle = 0;
        float cellx = 0;
        float celly = 0;
        int position=0;
        int l=0;
        int cyclecount=0;
        int dres = 20; // metros distancia para resolucion de handover
        int D = 200; // metros diametro de la celda
        int k =0; //indice para recorre el arreglo de velocidad
        int z =0; // to walk on totallines
        double meanresoltime =0;
        double resoltime=0;
        
        int counter1=0; //counter for callquantity 
        
        
        
        int hinix = 0; //limite primero del area de handover
        int hfinx = 0; //limite ultimo del area de handover 
        int hiniy = 0; //limite primero del area de handover
        int hfiny = 0; //limite ultimo del area de handover
        
        int channelX0=0;
        int channelX1=0;
        int channelX2=0;
        int channelX3=0;
        int channelX4=0;

        int channelY0=0;
        int channelY1=0;
        int channelY2=0;
        int channelY3=0;
        int channelY4=0;

        //int totalhandx0=0;
        int totalhandx1=0; // inicializar la cantidad de handovers por picocelda
        int totalhandx2=0; // inicializar la cantidad de handovers por picocelda
        int totalhandx3=0;
        int totalhandx4=0;
        int totalhandx5=0; // inicializar la cantidad de handovers por picocelda
        int totalhandx6=0; // inicializar la cantidad de handovers por picocelda
        int totalhandx7=0;
        int totalhandx8=0;
        
        int totalhandy1=0; // inicializar la cantidad de handovers por picocelda
        int totalhandy2=0; // inicializar la cantidad de handovers por picocelda
        int totalhandy3=0;
        int totalhandy4=0;
        int totalhandy5=0; // inicializar la cantidad de handovers por picocelda
        int totalhandy6=0; // inicializar la cantidad de handovers por picocelda
        int totalhandy7=0;
        int totalhandy8=0;


        

        
        int handsolix1=0;
        int handsolix2=0;
        int handsolix3=0;
        int handsolix4=0;
        int handsolix5=0;
        int handsolix6=0;
        int handsolix7=0;
        int handsolix8=0;
        
        int handsoliy1=0;
        int handsoliy2=0;
        int handsoliy3=0;
        int handsoliy4=0;
        int handsoliy5=0;
        int handsoliy6=0;
        int handsoliy7=0;
        int handsoliy8=0;

        
        
        

        int handtotalerrorx0 = 0;
        int handtotalerrorx1 = 0; // inicializacion para la identificacion de handover
        int handtotalerrorx2 = 0; // inicializacion para la identificacion de handover
        int handtotalerrorx3 = 0;
        int handtotalerrorx4 = 0;

        int handtotalerrory0 = 0;
        int handtotalerrory1 = 0; // inicializacion para la identificacion de handover
        int handtotalerrory2 = 0; // inicializacion para la identificacion de handover
        int handtotalerrory3 = 0;
        int handtotalerrory4 = 0;

        int handtotaloutx0 = 0;
        int handtotaloutx1 = 0;
        int handtotaloutx2 = 0;
        int handtotaloutx3 = 0;
        int handtotaloutx4 = 0;

        int handtotalouty0 = 0;
        int handtotalouty1 = 0;
        int handtotalouty2 = 0;
        int handtotalouty3 = 0;
        int handtotalouty4 = 0;
        
        int asignedcallsx0 = 0;
        int asignedcallsx1 = 0;
        int asignedcallsx2 = 0;
        int asignedcallsx3 = 0;
        int asignedcallsx4 = 0;
        
        int asignedcallsy0 = 0;
        int asignedcallsy1 = 0;
        int asignedcallsy2 = 0;
        int asignedcallsy3 = 0;
        int asignedcallsy4 = 0;
        
        int asignednewcallsx0 = 0;
        int asignednewcallsx1 = 0;
        int asignednewcallsx2 = 0;
        int asignednewcallsx3 = 0;
        int asignednewcallsx4 = 0;
        
        int asignednewcallsy0 = 0;
        int asignednewcallsy1 = 0;
        int asignednewcallsy2 = 0;
        int asignednewcallsy3 = 0;
        int asignednewcallsy4 = 0;
        
        
        int avgCounter1 = 0;
        int avgCounter2 = 0;
        int avgCounter3 = 0;
        int avgCounter4 = 0;
        int avgCounter5 = 0;
        int avgCounter6 = 0;
        int avgCounter7 = 0;
        int avgCounter8 = 0;
        
        
        randomposition callposition  =  new randomposition();
        String Cadena = new String(); // asignacion de espacio en memoria para una cadena vacia; almace cada linea leida hasta que encuentra VACIO
        String temp[] = new String[5]; // asignacion de memoria y creacion de un arreglo de 5 lineas de cadena de caracteres
        float XY[][]=new float[totalines][6]; // asignacion de memoria y creacion de una matriz de numero de usuarios por 5 columnas
        Auto arregloautos [] = new Auto[autos]; 
        Auto arregloautos2 [] = new Auto[10];
        double velocidad [][] = new double [autos][4]; // vector para almacenar los tiempos de zona de handover por cada auto en 10 puntos de tiempo y posicion 11 son los promedios de tiempo
        ArrayList<Float> avgHandtime = new ArrayList<Float>();
        for (int iii = 0; iii < 16; iii++ )
            avgHandtime.add(0f);
        ArrayList<Float> AVGTravertime = new ArrayList<Float>();
        for (int ee = 0; ee< 8; ee++ )
            AVGTravertime.add(0f);
        
        
        
        File f = new File("C:/Users/xthO/Desktop/Edson/ant/jar/mobility_trace.txt");// asignacion de espacio en memoria para un objeto tipo FILE, se inicia el const con un archivo txt
        File f2 = new File("C:/Users/xthO/Desktop/Edson/ant/jar/Calltimetable.xls");
        File f3 = new File("C:/Users/xthO/Desktop/Edson/ant/jar/Avetime20.xls");
        File f4 = new File("C:/Users/xthO/Desktop/Edson/ant/jar/Avetimetr.xls");
        File f5 = new File("C:/Users/xthO/Desktop/Edson/ant/jar/Velocidades.xls");
        File f6 = new File("C:/Users/xthO/Desktop/Edson/ant/jar/Handoverrequest.xls");
        File f7 = new File("C:/Users/xthO/Desktop/Edson/ant/jar/probability.xls");
        File f8 = new File("C:/Users/xthO/Desktop/Edson/ant/jar/Nohandovers.xls");
        File f9 = new File("C:/Users/xthO/Desktop/Edson/ant/jar/Poissontimes.xls");
        FileWriter fw2 = new FileWriter(f2);
        FileWriter fw3 = new FileWriter(f3);
        FileWriter fw4 = new FileWriter(f4);
        FileWriter fw5 = new FileWriter(f5);
        FileWriter fw6 = new FileWriter(f6);
        FileWriter fw7 = new FileWriter(f7);
        FileWriter fw8 = new FileWriter(f8);
        FileWriter fw9 = new FileWriter(f9);
        FileReader fr = new FileReader(f); // asignacion de memoria para un objeto tipo FILE READER se inicia el const con objeto tipo FILE (f)
        BufferedReader bf = new BufferedReader(fr); // asignacion de memoria para un objeto tipo bufferreader, se inicia el cont con el objeto tipo FILE READER (fr)
        
        while ((Cadena = bf.readLine())!=null) // bucle para leer cada una de las cadenas del TXT hasta que no exista cadena siguiente
        {		
                lineas++;
                // Se almacena en la matriz XY cada uno de los datos leidos en las lineas del archivo		
                temp = Cadena.split(" "); //almacena cada cadena separadas por un espacio en blanco
                XY[i][0] = (float) Float.parseFloat(temp[0]);   // Numero de Auto
                XY[i][1] = (float) Float.parseFloat(temp[1]);	// Tiempo de sensado
                XY[i][2] = (float) Float.parseFloat(temp[2]);	// Posicion en X                      
                XY[i][3] = (float) Float.parseFloat(temp[3]);	// Posicion en Y
                XY[i][4] = (float) Float.parseFloat(temp[4]);	// Velocidad
                
                i++;

        }
        i=0; // to set the index to CERO
        
        for (z=0; z<totalines; z++) // to walk on total lines
        {
            if(XY[z][4]>0)
            {
                                    //for (k=0; k<autos; k++) // to walk on total cars
                                    //{
                System.out.println(AVGTravertime);
                if (XY[z][2]>0 && XY[z][2]<=20)
                {
                
                System.out.println(AVGTravertime);
                avgCounter1++;  
                AVGTravertime.set(0, AVGTravertime.get(0) + XY[z][4]); 
                //AVGTravertime.set(0, AVGTravertime.get(0) + XY[z][4]/avgCounter1);// to sum speeds for each car
                System.out.println(AVGTravertime);
                
                }
                if (XY[z][2]>=180 && XY[z][2]<=200)
                {
                avgCounter2++;
                //avgTravertime.set(1, avgTravertime.get(1) + XY[z][4]);
                AVGTravertime.set(1, AVGTravertime.get(1) + XY[z][4]); // to sum speeds for each car
                }
                if (XY[z][2]>=360 && XY[z][2]<=380)
                {
                avgCounter3++;
                AVGTravertime.set(2, AVGTravertime.get(2) + XY[z][4]); // to sum speeds for each car
                }
                if (XY[z][2]>=540 && XY[z][2]<=560)
                {
                avgCounter4++;
                AVGTravertime.set(3, AVGTravertime.get(3) + XY[z][4]); // to sum speeds for each car
                }
                if (XY[z][3]>=0 && XY[z][3]<=20)
                {
                avgCounter5++;
                AVGTravertime.set(4, AVGTravertime.get(4) + XY[z][4]); // to sum speeds for each car
                }
                if (XY[z][3]>=180 && XY[z][3]<=200)
                {
                avgCounter6++;
                AVGTravertime.set(5, AVGTravertime.get(5) + XY[z][4]); // to sum speeds for each car
                }
                if (XY[z][3]>=360 && XY[z][3]<=380)
                {
                avgCounter7++;
                AVGTravertime.set(6, AVGTravertime.get(6) + XY[z][4]); // to sum speeds for each car
                }
                if (XY[z][3]>=540 && XY[z][3]<=560)
                {
                avgCounter8++;
                AVGTravertime.set(7, AVGTravertime.get(7) + XY[z][4]); // to sum speeds for each car
                }
                //if (XY[z][4]>0)// to avoid speed 0 m/s to sum every speed per car
                    //velocidad[k][2]=velocidad[k][2]+1; //to count how many speed values cars had on mobilty trace output
                //z++;
                
            //}
            
            //z--;
            }
            System.out.println(" PRomedio de atraversar la zona de handover " + AVGTravertime + " " + avgCounter1 + " " + avgCounter2 + " " +
                    avgCounter3 + " " + avgCounter4 + " " + avgCounter5 + " " +avgCounter6 + " " + avgCounter7 + " " + avgCounter8);
           
        }
        //System.out.println(" PRomedio de atraversar la zona de handover " + AVGTravertime.get(0) + " " + avgCounter1 + " " + avgCounter2 + " " +
                    //avgCounter3 + " " + avgCounter4 + " " + avgCounter5 + " " +avgCounter6 + " " + avgCounter7 + " " + avgCounter8);

        for (k=0; k<autos; k++)
        {
            if (velocidad[k][0]>0) // to avoid counting cars which always got speed 0 by whole simulation
            {
                System.out.println(  " suma de velocidades por carro " + velocidad[k][0]);
                System.out.println(  " numero de eventos " + velocidad[k][2]);
                
                velocidad[k][0]= velocidad[k][0]/velocidad[k][2]; // to have an  arithmetical speed average of each car
                System.out.println(  " Promedio de velocidad por carro " + velocidad[k][0]);
                
                velocidad[k][1]=dres/velocidad[k][0]; // to compute times of traversal handover region (20 mts) through speed averages
                System.out.println(  " promedio de tiempo en cruzar los 20 metros " + velocidad[k][1]);
                
                velocidad[k][3]=D/velocidad[k][0]; // to compute times of a cell (200mts) through speed averages
                System.out.println(  " promedio de tiempo en cruzar los 200 metros " + velocidad[k][3]);
                
                resoltime=velocidad[k][1]+resoltime; // to calculate the sum of 20meter-times 
                System.out.println(  " tiempo de resolucion " + resoltime);
                
                velmediagral = velocidad[k][0]+ velmediagral; // to sum speed averages to get a total value
                System.out.println(  " suma de velocidades " + velmediagral);
                
                cyclecount++;
                //System.out.println(  " contador de eventos " + cyclecount);
                System.out.println( " ");
            }
            //mediatransit= velocidad[k][1];
            
        }
        meanresoltime = resoltime/cyclecount; // to compute the general time of crossing handover traversal region (20mts)
        mediaresol1= meanresoltime/2; // to compute the general time of crossing handover traversal region (10 mts)
        
        System.out.println(" sigma" + " " + meanresoltime + " " + mediaresol1);
       
        //transittimeprome = D/velmediagral;
        
        for (int p=0; p<autos; p++ )
        {
            arregloautos[p] = new Auto(); // to create auto-type objects in arregloautos
            
        }
        
        for (l=0; l<10; l++)
        { 
            arregloautos2[l] = new Auto(); // to create auto-type objects in arregloautos2
        }
        
        while (i<lineas) // to read all of mobility trace output file lines 
        {
          boolean change = false;  // to read mobility trace output file from non-cero timestep, from timestep 1 to the end
            
            if ( i == 0 )
                change = true;
            else {
                if( XY[i][1] > XY[i-1][1] )
                    change = true;
                else
                    change = false;
            }
            
            if ( change ) {
                
                // To clear cells which contain vehicles per time step
                arregloautos2[0].callxcell.clear();
                arregloautos2[1].callxcell.clear();
                arregloautos2[2].callxcell.clear();
                arregloautos2[3].callxcell.clear();
                arregloautos2[4].callxcell.clear();
                arregloautos2[5].callxcell.clear();
                arregloautos2[6].callxcell.clear();
                arregloautos2[7].callxcell.clear();
                arregloautos2[8].callxcell.clear();
                
                
                int m = 0;
                while(m < autos)
                {

                    int indice = (int)XY[i][1]*autos + m;
                    
                    // Left to right flow
                    if ( XY[indice][4] != 0 && XY[indice][2]-XY[indice-autos][2]>0 && XY[indice][3]==280) 
                    {
                        cellx = XY[indice][2]/200;

                        // Handover 1 -> Lista 1
                        if ((cellx>0 && cellx<=.1) && (XY[indice][3]==280))
                        {
                            arregloautos2[1].callxcell.add((int)XY[indice][0]);
                            celllist=1;
                        }
                        // Celda 1 -> lista 1
                        if ((cellx>.1 && cellx<=.9) && (XY[indice][3]==280))
                        {
                            arregloautos2[1].callxcell.add((int)XY[indice][0]);
                            celllist=1;
                        }
                        // Handover 2 -> Lista 2
                        if ((cellx>.9 && cellx<=1) && (XY[indice][3]==280))
                        {
                            arregloautos2[2].callxcell.add((int)XY[indice][0]);
                            celllist=2;
                        }
                        // Celda 2 -> lista 2
                        if ((cellx>1 && cellx<=1.8) && (XY[indice][3]==280))
                        {
                            arregloautos2[2].callxcell.add((int)XY[indice][0]);
                            celllist=2;
                        }
                        // Handover 3 -> Lista 3
                        if ((cellx>1.8 && cellx<=1.9) && (XY[indice][3]==280))
                        {
                            arregloautos2[3].callxcell.add((int)XY[indice][0]);
                            celllist=3;
                        }
                        // Celda 3 -> lista 3
                        if ((cellx>1.9 && cellx<2.7)  && (XY[indice][3]==280))
                        {
                            arregloautos2[3].callxcell.add((int)XY[indice][0]);
                            celllist=3;
                        }
                        // Handover 4 -> Lista 4
                        if ((cellx>2.7 && cellx<2.8)  && (XY[indice][3]==280))
                        {
                            arregloautos2[4].callxcell.add((int)XY[indice][0]);
                            celllist=4;
                        }

                    }
                    // Right to left flow
                    else if( XY[indice][4] != 0 && XY[indice][2]-XY[indice-autos][2]<0 && XY[indice][3]<=280 )
                    {
                            cellx = XY[indice][2]/200;
                        
                        // Handover 1 -> lista 0
                        if ((cellx>0 && cellx<=.1) && (XY[indice][3]==280))
                        {
                            arregloautos2[0].callxcell.add((int)XY[indice][0]);
                            celllist=0;
                        }
                        // Celda 1 -> Lista 1
                        if ((cellx>.1 && cellx<=.9) && (XY[indice][3]==280))
                        {
                            arregloautos2[1].callxcell.add((int)XY[indice][0]);
                            celllist=1;
                        }
                        // Handover 2 -> Lista 1
                        if ((cellx>.9 && cellx<=1) && (XY[indice][3]==280))
                        {
                            arregloautos2[1].callxcell.add((int)XY[indice][0]);
                            celllist=1;
                        }
                        // Celda 2 -> lista 2
                        if ((cellx>1 && cellx<=1.8) && (XY[indice][3]==280)) 
                        {
                            arregloautos2[2].callxcell.add((int)XY[indice][0]);
                            celllist=2;
                        }
                        // Handover 3 -> lista 2
                        if ((cellx>1.8 && cellx<=1.9) && (XY[indice][3]==280))
                        {
                            arregloautos2[2].callxcell.add((int)XY[indice][0]);
                            celllist=2;
                        }
                        // Celda 3 -> lista 3
                        if ((cellx>1.9 && cellx<2.7)  && (XY[indice][3]==280))
                        {
                            arregloautos2[3].callxcell.add((int)XY[indice][0]);
                            celllist=3;
                        }
                        // Handover 4 -> lista 3
                        if ((cellx>2.7 && cellx<2.8)  && (XY[indice][3]==280))
                        {
                            arregloautos2[3].callxcell.add((int)XY[indice][0]);
                            celllist=3;
                        }
                    }

                    // Bottom to top flow
                    if ( XY[indice][4] != 0 && XY[indice][3]-XY[indice-autos][3]>0 && XY[indice][2]==280 ) 
                    {
                        celly = XY[indice][3]/200;

                        // Handover 5 -> Lista 5
                        if ((celly>0 && celly<=.1) && (XY[indice][2]==280))
                        {
                            arregloautos2[5].callxcell.add((int)XY[indice][0]);
                            celllist=5;
                        }        
                        // Celda 5 -> Lista 5
                        if ((celly>.1 && celly<=.9) && (XY[indice][2]==280))
                        {
                            arregloautos2[5].callxcell.add((int)XY[indice][0]);
                            celllist=5;
                        }
                        // Handover 6 -> Lista 2
                        if ((celly>.9 && celly<=1) && (XY[indice][2]==280))
                        {
                            arregloautos2[2].callxcell.add((int)XY[indice][0] );
                            celllist=2;
                        }
                       //Celda 2 -> lista 2
                        if ((celly>1 && celly<=1.8) && (XY[indice][2]==280))
                        {
                            arregloautos2[2].callxcell.add((int)XY[indice][0]);
                            celllist=2;
                        }
                        // Handover 6 -> Lista 6
                        if ((celly>1.8 && celly<=1.9) && (XY[indice][2]==280))
                        {
                            arregloautos2[6].callxcell.add((int)XY[indice][0]);
                            celllist=6;
                        }
                        // Celda 6 -> Lista 6
                        if ((celly>1.9 && celly<2.7)  && (XY[indice][2]==280))
                        {
                            arregloautos2[6].callxcell.add((int)XY[indice][0]);
                            celllist=6;
                        }
                        // Handover 7 -> Lista 7
                        if ((celly>2.7 && celly<2.8)  && (XY[indice][2]==280))
                        {
                            arregloautos2[7].callxcell.add((int)XY[indice][0]);
                            celllist=7;
                        }
                    }
                    // Top to bottom flow
                    else if( XY[indice][4] != 0 && XY[indice][3]-XY[indice-autos][3]<0 && XY[indice][2]==280)
                    {
                            celly = XY[indice][3]/200;

                        // Handover 5 -> Lista 8
                        if ((celly>0 && celly<=.1) && (XY[indice][2]==280))
                        {
                            arregloautos2[8].callxcell.add((int)XY[indice][0]);
                            celllist=8;
                        }
                        // Celda 5 -> Lista 5
                        if ((celly>.1 && celly<=.9) && (XY[indice][2]==280))
                        {
                            arregloautos2[5].callxcell.add((int)XY[indice][0]);
                            celllist=5;
                        }
                        // Handover 6 -> Lista 5
                        if ((celly>.9 && celly<=1) && (XY[indice][2]==280))
                        {
                            arregloautos2[5].callxcell.add((int)XY[indice][0] );
                            celllist=5;
                        }
                        /////////////////////////////////////////////////////// Celda 2 -> lista 2
                        if ((celly>1 && celly<=1.8) && (XY[indice][2]==280))//|| (celly>1 && celly<=1.8))
                        {
                            arregloautos2[2].callxcell.add((int)XY[indice][0]);
                            celllist=2;
                        }
                        // Handover 7 -> Lista 2
                        if ((celly>1.8 && celly<=1.9) && (XY[indice][2]==280))
                        {
                            arregloautos2[2].callxcell.add((int)XY[indice][0]);
                            celllist=2;
                        }
                        // Celda 6 -> Lista 6
                        if ((celly>1.9 && celly<2.7)  && (XY[indice][2]==280))
                        {
                            arregloautos2[6].callxcell.add((int)XY[indice][0]);
                            celllist=6;
                        }
                        // Handover 8 -> Lista 6
                        if ((celly>2.7 && celly<2.8)  && (XY[indice][2]==280))
                        {
                            arregloautos2[6].callxcell.add((int)XY[indice][0]);
                            celllist=6;
                        }

                    }
                    m++;
                }
                
                
                System.out.println("lista de coches 0 " + arregloautos2[0].callxcell);
                System.out.println("lista de coches 1 " + arregloautos2[1].callxcell);
                System.out.println("lista de coches 2 " + arregloautos2[2].callxcell);
                System.out.println("lista de coches 3 " + arregloautos2[3].callxcell);
                System.out.println("lista de coches 4 " + arregloautos2[4].callxcell);
                System.out.println("lista de coches 5 " + arregloautos2[5].callxcell);
                System.out.println("lista de coches 6 " + arregloautos2[6].callxcell);
                System.out.println("lista de coches 7 " + arregloautos2[7].callxcell);
                System.out.println("lista de coches 8 " + arregloautos2[8].callxcell);
                
               // to address calls per list and  per timestep
               for(celllist=0; celllist<9; celllist++)
               {
                   counter1 = 0;
                    if (arregloautos2[celllist].callxcell.size()>0)
                    {
                        if (arregloautos2[celllist].callxcell.size() > 1)
                            System.out.println();
                            
                        ArrayList lst = new ArrayList();
                        while(counter1<callquan)//ciclo para asignacion de llamadas
                        {                                                                          
                            callposition.setPosition(arregloautos2[celllist].callxcell.size()); //establecer posicion
                            position = callposition.getPosition();//guarda la posicion 
                            arregloautos[arregloautos2[celllist].callxcell.get(position)].setCalls(landa, lst, counter1+1);                            

                            counter1++;                   
                        }                        
                        
                        arregloautos2[celllist].poissontimes.add(lst);
                        arregloautos[arregloautos2[celllist].callxcell.get(position)].I=0;
                        arregloautos[arregloautos2[celllist].callxcell.get(position)].t=0;
                        //System.out.println(" lista de tiempos de arrivo=====> " + celllist + "<====== " + arregloautos2[celllist].poissontimes);
                    }
                    
               }
               
            }
            
            
            // To analize every single vehicle in the network (handover detection and resolution process)
            for (int j=0; j<autos ; j++ )			
            {       
                
                arregloautos[j].setCarro(XY[i][0]); //establecer el numero de carro al arregloautos
                if(XY[i][4]!=0) //comparar que j sea mayor que cero e igual a cero para asiganar el timepo del carro anterior               
                    arregloautos[j].setTiempo(Math.abs(XY[i][2] - arregloautos[j].getCoorX()) + Math.abs(XY[i][3] - arregloautos[j].getCoorY()) / XY[i][4]);   // Tiempo recorrido por el auto en un punto medido
                  
                arregloautos[j].tiempoacum = arregloautos[j].tiempoacum + arregloautos[j].getTiempo();
                arregloautos[j].setCoorX(XY[i][2]);        		// distancia del auto en X  en un punto medido	

                arregloautos[j].setCoorY(XY[i][3]);               	    // distancia del auto en Y  en un punto medido
                arregloautos[j].setVelocidad(XY[i][4]);// + arregloautos[j].getVelocidad());		// Suma de velocidades para promediar al final
                
                arregloautos[j].speedValues.add(velocidad[j][0]);
                
                
            
            arregloautos[j].setNormal(mediaresol1, standardeviation);
            //double bound = 1000;
            
            arregloautos[j].setExpo(mediaexptc);
           // arregloautos[j].setTiempores();
            //arregloautos[j].restimetable.add(arregloautos[j].getTiempores()); 

           // arregloautos[j].setProbability(0, velocidad[j][1]);//sacar la probabilidad de error a cada llamda entre en la zona de handover
            //arregloautos[j].probabilitytable.add(arregloautos[j].getProbability());

            //System.out.println(arregloautos[j].getProbability());
                
                
                
                   
//System.out.println("Matriz autos " + " "+ "valor de i"+ i +" " + "carro"+ arregloautos[j].getCarro() + " " + arregloautos[j].getCoorX()+ " " + arregloautos[j].getCoorY()+ " " + XY[i][4]+ " " +arregloautos[j].getTiempo());//arregloautos[j].getTiempo()); // + " " + arregloautos[j].getCoorX()+ " " + arregloautos[j].getCoorY()+ " "  + arregloautos[j].getVelocidad()); 
////////////////////////////////////////* DETECCION Y RESOLUCION DE HANDOVER POR PICOCELDAS*///////////////////////////////////////////////////////////////


                if ((i>(autos-1) && (arregloautos[j].incall==true)))
                {
                    arregloautos[j].calltimes=arregloautos[j].calltimes-arregloautos[j].getTiempo();
                }
                if (arregloautos[j].tiempoacum - arregloautos[j].calltimes >= 0 && (arregloautos[j].incall==true))
                {
                    //System.out.println("Llamada finalizada " + " " + j + " " + arregloautos[j].tiempoacum + " / " + arregloautos[j].calltimes);
                    arregloautos[j].calltimes =0; 
                    arregloautos[j].incall = false;
                    arregloautos[j].tiempoacum = 0;
                    arregloautos[j].incomingcall=false;
                    arregloautos[j].handsolpicX0=false;
                    arregloautos[j].handsolpicX1=false;
                    arregloautos[j].handsolpicX2=false;
                    arregloautos[j].handsolpicX3=false;
                    arregloautos[j].handsolpicX4=false;
                    arregloautos[j].handsolpicY0=false;   
                    arregloautos[j].handsolpicY1=false;  
                    arregloautos[j].handsolpicY2=false;
                    arregloautos[j].handsolpicY3=false;
                    arregloautos[j].handsolpicY4=false;


                    arregloautos[j].handpicX0=false;
                    arregloautos[j].handpicX1=false;
                    arregloautos[j].handpicX2=false;
                    arregloautos[j].handpicX3=false;
                    arregloautos[j].handpicX4=false;
                    arregloautos[j].handpicY0=false;
                    arregloautos[j].handpicY1=false;
                    arregloautos[j].handpicY2=false;
                    arregloautos[j].handpicY3=false;
                    arregloautos[j].handpicY4=false;
                     
                    if (arregloautos[j].origin == 6 & arregloautos[j].origin == 10 )//|| arregloautos[j].origin == 9)
                        
                        arregloautos[j].origin = 2;
                  
                      switch (arregloautos[j].origin)
                    {
                        case 0:
                            channelX0--;
                            break;
                        case 1:
                            channelX1--;
                            break;
                        case 2:
                            channelX2--;
                            channelY2--;
                            break;
                        case 3:
                            channelX3--;
                            break; 
                        case 4:
                            channelX4--;
                            break;                    
                        case 5:
                            channelX3--;
                            break;
                        //case 6:
                            //channelX2--;
                            //break;
                        case 7:
                            channelX1--;
                            break;
                        case 8:
                            channelY0--;
                            break; 
                        case 9:
                            channelY1--;
                            break;
                        //case 10:
                            //channelY1--;
                            //break;
                        case 11:
                            channelY3--;
                            break;
                        case 12:
                            //channelY4--;
                            break;
                         case 13:
                            channelY3--;
                            break;
                         //case 14:
                            //channelY2--;
                            //break;
                         case 15:
                            channelY1--;
                            break;
                                                    
                    } 
                      
                     // while(arregloautos[j].origin == 7)
                          //channelY2--;
                System.out.println("------->>>fin de llamada <<<<<<---------------" + "Carro " + j);
                }
                 
             //System.out.println("Entrada " + "canal2" + " " + channelX2 + " " + "carro" + " " + XY[i][0] + " "+ XY[i][1] + " "+ XY[i][2] + " " + arregloautos[j].handpicX2 + " " + arregloautos[j].handsolpicX2 + " " + arregloautos[j].incall + " " + arregloautos[j].incomingcall);
             if (arregloautos[j].incomingcall==true || arregloautos[j].incall==true)
             {

    /////////////////////////// HANDOVER PARA X///////////////////////////////                 
                if (i>(autos-1) && XY[i][2]-XY[i-autos][2]>0 && i>=autos)// && (arregloautos[j].incomingcall==true || arregloautos[j].incall==true))
                {
                    
                    if ((XY[i][2] >= 0 && XY[i][2] <= 200) && (XY[i][3]>= 270 && XY[i][3] <= 290)) // ubicacion de las coordenadas en las picocelda 1 en X
                    {   
                            arregloautos[j].handsolpicX1=false;
                            arregloautos[j].handpicX1=false;
                        
                        if (XY[i][2] >= 20 && XY[i][2] <= 180)
                        {
                            arregloautos[j].handsolpicX2=false; 
                            arregloautos[j].handsolpicX1=false;
                            arregloautos[j].handpicX2=false;
                            arregloautos[j].handpicX1=false;
                            arregloautos[j].speedcounterX1++;
                            arregloautos[j].setCellspeed(arregloautos[j].speedcounterX1, arregloautos[j].getVelocidad()); // to compute the crossing average speed
                            arregloautos[j].setCelltime(arregloautos[j].getCellspeed(), D); // to compute the the crossing time (200mt)
                            //cellspeedauxX3=arregloautos[j].getCellspeed();
                            //celltimeauxX3 = arregloautos[j].getCelltime();
                           
                            System.out.println(" velocidad promedio en X1 el coche " + j + " " + arregloautos[j].getCellspeed());
                            System.out.println(" Tiempo que tarda en cruzar X1 el coche " + j + " " + arregloautos[j].getCelltime());
                        }
                       /*if(arregloautos[j].origin!=1 && arregloautos[j].incall==true && arregloautos[j].handpicX2==false)
                        {  
                            arregloautos[j].origin=1; 
                        }*/

                        if(arregloautos[j].incomingcall==true && arregloautos[j].incall==false) // nueva llamada
                        {
                            if (XY[i][2] >= 0 && XY[i][2] <= 180)
                            {
                                if (channelX1<availchannel)
                                {
                                    arregloautos[j].incomingcall=false;
                                    arregloautos[j].incall=true; //se asigna la llamada
                                    arregloautos[j].setTiempoexp();
                                    arregloautos[j].calltimes=arregloautos[j].getTiempoexp(); //asignar tc a aarreglo de autos
                                    arregloautos[j].calltimetable.add(arregloautos[j].getTiempoexp());
                                    arregloautos[j].origin=1;
                                    arregloautos[j].handsolpicX1=true;
                                    arregloautos[j].handpicX1=true;
                                    asignednewcallsx1++;
                                    channelX1++; //contador de canales.
                                   
                                    
                                    //arregloautos[j].setNoH(arregloautos[j].getTiempoexp(),velocidad[j][3]);
                                    //arregloautos[j].getNoH();
                                    //arregloautos[j].Nohandovers.add(arregloautos[j].getNoH());
                                    
                                    //arregloautos[j].setProbabilityNoH(xe, velocidad[j][3], bound);
                                    //arregloautos[j].getProbabilityNoH();
                                    //arregloautos[j].probabilityNoH.add(arregloautos[j].getProbabilityNoH());
                                    //arregloautos[j].setProbabilityexpo(2);
                                    
                                    //arregloautos[j].setProbability(0, velocidad[j][1]);//sacar la probabilidad de error a cada llamda entre en la zona de handover
                                    //arregloautos[j].probabilitytable.add(arregloautos[j].getProbability());
                                    
                                    
                                    
                                    //System.out.println("canales asignados por nueva llamada en Picocelda 1" + " " + "Carro" + " " + j + " " + "numero de canales" + " " + channelX1);
                                    //System.out.println("Tiempo de generacion de llamada" + " " + arregloautos[j].bettime + " "+ "carro" + " " +j);
                                    //System.out.println(" Tiempo de llamada" + " " + arregloautos[j].calltimes);
                                    System.out.println(" Nueva llamada canalX1 " + "carro " + j + " " + channelX1);
                                }  
                                else
                                {
                                    handtotaloutx1++;
                                    arregloautos[j].incomingcall=false;
                                    System.out.println("Llamada caida por canalX1 bloqueado " + "carro " + j + " " + channelX1);
                                }
                            }
                        
                            else /// new calls in handover region
                            
                            if(channelX2==availchannel)
                                {
                                    handtotaloutx2++; //outage
                                    arregloautos[j].incomingcall=false;
                                    arregloautos[j].incall=false;
                                    System.out.println("Llamada caida area HO por canalX2 bloqueado " + "carro " + j + " " + channelX2);
                                }
                            else
                                {
                                     
                                     arregloautos[j].incomingcall=false;
                                     arregloautos[j].incall=true;
                                     arregloautos[j].setTiempoexp();
                                     arregloautos[j].calltimetable.add(arregloautos[j].getTiempoexp());
                                     arregloautos[j].calltimes=arregloautos[j].getTiempoexp(); //asignar tc a aarreglo de autos                                 
                                     arregloautos[j].origin=2;
                                     arregloautos[j].handsolpicX2=true;
                                     arregloautos[j].handpicX2= true; 
                                     channelX2++;
                                     channelY2++;
                                     asignednewcallsx2++;
                                     System.out.println("Nueva llamada area HO en canaX2 " + "carro " + j + " " + channelX2 + " " + channelY2);
                                     
                                     
                                     //arregloautos[j].setNoH(tc,velocidad[j][3]);
                                     //arregloautos[j].getNoH();
                                     //arregloautos[j].Nohandovers.add(arregloautos[j].getNoH());
                                     
                                    //System.out.println("Descuento de canal por asignacion X1-X2" + channelX1);
                                     //System.out.println("Nueva llanada en X1-X2" + " " + j + " "+ channelX2);
                                     //System.out.println("Tiempo de generacion de llamada" + " " + arregloautos[j].bettime + " "+ j);
                                     //System.out.println(" Tiempo de llamada" + " " + arregloautos[j].calltimes);
                                }
                        }
                        else

                            if (XY[i][2]<=20)
                            {
                                hinix = 0; //limite inicial de area de handover
                                hfinx= 20; 

                                if ((XY[i][2] >=hinix && XY[i][2] <= hfinx)) //tr[j] // se cmpara contra el tiempo de transito de celda o con el tiempo generado exponencialmente
                                {                                      
                                    arregloautos[j].handpicX2=false;
                                    //arregloautos[j].handpicX1=false;
                                    
                                    if (arregloautos[j].handsolpicX1==false && arregloautos[j].origin!=1) //si esta dentro del area efectiva y no se ha asignado peticion para handoever
                                    {	
                                        handsolix1 ++; //request for handover
                                        System.out.println("solicitud X0-X1 por el carro " + arregloautos[j].getCarro() + " " + arregloautos[j].getCoorX());
                                        arregloautos[j].handsolpicX1=true;			//se cambia a 1 cuando se hace peticion de handover                                
                                    }
                                    
                                    if (arregloautos[j].handsolpicX1 == true && arregloautos[j].handpicX1==false)   // zona efectiva de asignacion de handover                                     
                                    {   
                                        
                                        arregloautos[j].setTiempores();
                                        arregloautos[j].restimetable.add(arregloautos[j].getTiempores());
                                        arregloautos[j].setTravertime(arregloautos[j].getVelocidad(), dres);
                                        avgHandtime.set(0, avgHandtime.get(0) + arregloautos[j].getTravertime());   // Calculando el total de los tiempos de traversal
                                        arregloautos[j].time20.add("\n" + arregloautos[j].getTraverlist());
                                        arregloautos[j].setProbability(0, arregloautos[j].getTravertime());//sacar la probabilidad de error a cada llamda entre en la zona de handover
                                        arregloautos[j].probabilitytable.add(arregloautos[j].getProbability());
                                        System.out.println( " Probabilidad " + arregloautos[j].getProbability() + " " + " Carro " + j );
                                        System.out.println( " Velocidad al entrar a la region de handover " + arregloautos[j].getVelocidad());
                                        System.out.println( " Tiempo TOTAL que tarda al cruzar la region de handover X1 " + arregloautos[j].getTotaltravertime());
                                        
                                        System.out.println( " LA LISTA" + arregloautos[j].time20);
                                        
                                        if (arregloautos[j].getTiempores()>=arregloautos[j].getTravertime())                                            
                                        {
                                            handtotalerrorx1++;                                        
                                            arregloautos[j].incomingcall=false;
                                            arregloautos[j].incall=false;
                                            channelX0--;
                                            arregloautos[j].restimetable.add(1001);
                                            arregloautos[j].travertime.clear();
                                            System.out.println("Error de HO en canalX0 " + "carro " + j + " " + channelX0);
                                        }
                                        else
                                            if(channelX1==availchannel)
                                            {
                                                handtotaloutx1++; //outage
                                                arregloautos[j].incomingcall=false;
                                                arregloautos[j].incall=false;
                                                channelX0--;
                                                arregloautos[j].travertime.clear();
                                                System.out.println("Llamada Handover caida por canalX1 bloqueado " + "carro " + j + "canalX0 " + channelX0 + " canalX1 " + channelX1);
                                            }
                                            else
                                            {
                                                 arregloautos[j].handpicX1= true;
                                                 arregloautos[j].incomingcall=false;
                                                 arregloautos[j].origin=1;
                                                 channelX1++;
                                                 channelX0--;
                                                 totalhandx1++;
                                                 asignedcallsx1++;
                                               
                                                 System.out.println("Handover para X0-X1 " + "carro " + j + "canalX0 " + channelX0 + " canalX1 " + channelX1);
                                                 arregloautos[j].travertime.clear();
                                                 System.out.println( " veces por las que cruza la region de handover X1 " + totalhandx1);
                                            }  
                                    }                                                                                                                                
                                }
                            }
                            else 
                            {
                                hinix = 180; //limite inicial de area de handover
                                hfinx= 200; //limite final de area de handover
                                //System.out.println(" velocidad promedio en X1 el coche " + j + " " + arregloautos[j].getCellspeed());
                                //System.out.println(" Tiempo que tarda en cruzarX1 el coche " + j + " " + arregloautos[j].getCelltime());

                                // El auto se encuentra en area de handover y el tiempo del recorrido es menor que el tiempo que durara la llamada
                                if ((XY[i][2] >=hinix && XY[i][2] <= hfinx)) //tr[j] // se cmpara contra el tiempo de transito de celda o con el tiempo generado exponencialmente
                                {     
                                    arregloautos[j].handpicX1=false;
                                    arregloautos[j].handpicX3=false;
                                    arregloautos[j].speedcounterX1=0;
                                    arregloautos[j].speedX = 0;
                                                                                                         
                                    if (arregloautos[j].handsolpicX2==false && arregloautos[j].origin!=2) //si esta dentro del area efectiva y no se ha asignado peticion para handoever
                                    {	
                                        handsolix2 ++; //request for handover
                                        arregloautos[j].handsolpicX2=true;			//se cambia a 1 cuando se hace peticion de handover
                                        System.out.println("solicitud X1-X2 por el carro " + arregloautos[j].getCarro() + " " + arregloautos[j].getCoorX());
                                    }
                                    if (arregloautos[j].handsolpicX2 == true && arregloautos[j].handpicX2==false)   // zona efectiva de asignacion de handover                                     
                                    {              
                                        
                                        
                                        arregloautos[j].setTiempores(); // to set resolutiontime sample
                                        arregloautos[j].restimetable.add(arregloautos[j].getTiempores()); //to get resoltution time sample
                                        arregloautos[j].setTravertime(arregloautos[j].getVelocidad(), dres); // to compute handover resolution time (using the first speed value entering in the region and resolution time distance 10 meters
                                        avgHandtime.set(1, avgHandtime.get(1) + arregloautos[j].getTravertime());   // Calculando el total de los tiempos de traversal
                                        arregloautos[j].time20.add("\n" + arregloautos[j].getTraverlist()); // to add it to the list
                                        arregloautos[j].setProbability(0, arregloautos[j].getTravertime());//sacar la probabilidad de error a cada llamda entre en la zona de handover
                                        arregloautos[j].probabilitytable.add(arregloautos[j].getProbability());
                                        System.out.println( " Probabilidad " + arregloautos[j].getProbability() + " " + " Carro " + j );
                                        System.out.println( " Velocidad al entrar a la region de handover " + arregloautos[j].getVelocidad());
                                        System.out.println( " Tiempo que tarda al cruzar la region de handover X2 " + arregloautos[j].getTravertime());
                                        System.out.println( " Tiempo TOTAL que tarda al cruzar la region de handover X2 " + arregloautos[j].getTotaltravertime());
                                        
                                        System.out.println( " LA LISTA" + arregloautos[j].time20.toString());
                                        
                                        if (arregloautos[j].getTiempores()>=arregloautos[j].getTravertime())                                            
                                        {
                                            handtotalerrorx2++;                                        
                                            arregloautos[j].incomingcall=false;
                                            arregloautos[j].incall=false;
                                            channelX1--;
                                            arregloautos[j].restimetable.add(2002);
                                            arregloautos[j].travertime.clear();
                                            System.out.println("Error de HO en canalX1 " + "carro " + j + " " + channelX1);
                                        }
                                        else
                                            if(channelX2==availchannel)
                                            {
                                                handtotaloutx2++; //outage
                                                arregloautos[j].incomingcall=false;
                                                arregloautos[j].incall=false;
                                                channelX1--;
                                                arregloautos[j].travertime.clear();
                                                System.out.println("Llamada Handover caida por canalX1 bloqueado " + "carro " + j + "canalX1 " + channelX1 + " canalX2 " + channelX2);
                                            }
                                            else
                                            {
                                                 arregloautos[j].handpicX2= true;
                                                 arregloautos[j].incomingcall=false;
                                                 arregloautos[j].origin=2;
                                                 channelX2++;
                                                 channelY2++;
                                                 channelX1--;
                                                 totalhandx2++;
                                                 asignedcallsx2++;
                                                 //System.out.println("Descuento de canal por asignacion X1-X2" + channelX1);
                                                System.out.println("Handover para X1-X2 " + "carro " + j + "canalX1 " + channelX1 + " canalX2 " + channelX2 + " canalY2 " + channelY2);
                                                arregloautos[j].travertime.clear();
                                                System.out.println( " veces por las que cruza la region de handover X2 " + totalhandx2);
                                            }  
                                    }                                                                                                  
                                }
                            }
                    }
                    else if ((XY[i][2] >=200 && XY[i][2] <= 380) && (XY[i][3]>= 270 && XY[i][3] <= 290)) // ubicacion de las coordenadas en las picocelda en X 2
                        {   
                            arregloautos[j].handsolpicX3=false;
                            arregloautos[j].handpicX3=false;
                            
                            if (XY[i][2] >=200 && XY[i][2] <= 360)
                            {
                                arregloautos[j].speedcounterX2++;
                                arregloautos[j].setCellspeed(arregloautos[j].speedcounterX2, arregloautos[j].getVelocidad()); // to compute the crossing average speed
                                arregloautos[j].setCelltime(arregloautos[j].getCellspeed(), D); // to compute the the crossing time (200mt)
                                System.out.println(" VElocidad en el punto medido " + j + " " + arregloautos[j].getVelocidad());
                                System.out.println(" Suma de velocidades " + j + " " + arregloautos[j].speedX);
                                System.out.println(" velocidad promedio en X2 el coche " + j + " " + arregloautos[j].getCellspeed());
                                System.out.println(" Tiempo que tarda en cruzar X2 el coche " + j + " " + arregloautos[j].getCelltime());
                                System.out.println(" Suma de velocidades " + j + " " + arregloautos[j].speedX);
                                //System.out.println(" Contador " + j + " " + arregloautos[j].speedcounterX2);
                                       
                            }
                            
                            if (XY[i][2] >=200 && XY[i][2] <= 360)
                            {
                                arregloautos[j].handsolpicX2=false; // resetea la asigancion de handover para ser detectado en la picocelda siguiente
                                arregloautos[j].handsolpicX3=false;
                                arregloautos[j].handpicX2=false;
                                arregloautos[j].handpicX3=false;
                                                                                            
                            }
                                                          
                            
                            if(arregloautos[j].incomingcall==true && arregloautos[j].incall==false) 
                            {   
                                if (XY[i][2] >= 200 && XY[i][2] <= 360)
                                {
                                    if (channelX2<availchannel)
                                    {
                                        arregloautos[j].incomingcall=false;
                                        arregloautos[j].incall=true;
                                        arregloautos[j].setTiempoexp();
                                        arregloautos[j].calltimetable.add(arregloautos[j].getTiempoexp());
                                        arregloautos[j].calltimes=arregloautos[j].getTiempoexp(); //asignar tc a aarreglo de autos
                                        arregloautos[j].origin=2;
                                        //arregloautos[j].handsolpicX2=true;
                                        //arregloautos[j].handpicX2=true; 
                                        channelX2++; //contador de canales.
                                        channelY2++;
                                        asignednewcallsx2++;
                                       
                                        
                                       System.out.println(" Nueva llamada canaX2 " + "carro " + j + " canalX2 " + channelX2 + " canalY2 " + channelY2);
                                        
                                    }
                                    
                                    else
                                    {
                                        handtotaloutx2++;
                                        arregloautos[j].incomingcall=false;
                                        System.out.println("Llamada caida por canalX2 bloqueado " + "carro " + j + " canalX2 " + channelX2 + " canalY2 " + channelY2);
                                    }
                                }
                                else 
                                   if(channelX3==availchannel) //nueva llamada en region de handover
                                    {
                                        handtotaloutx3++; //outage
                                        arregloautos[j].incomingcall=false;
                                        arregloautos[j].incall=false;
                                        System.out.println("Llamada caida area HO por canalX3 bloqueado " + "carro " + j + " " + channelX3);
                                    }
                                    else
                                    {
                                         
                                         arregloautos[j].incall=true;
                                         arregloautos[j].incomingcall=false;
                                         arregloautos[j].handsolpicX3=true; 
                                         arregloautos[j].handpicX3= true;
                                         arregloautos[j].setTiempoexp();
                                         arregloautos[j].calltimetable.add(arregloautos[j].getTiempoexp());
                                         arregloautos[j].calltimes=arregloautos[j].getTiempoexp(); //asignar tc a aarreglo de autos
                                         arregloautos[j].origin=3;
                                         channelX3++;
                                         asignednewcallsx3++;
                                         
                                         
                                        System.out.println("Nueva llamada area HO en canaX3 " + "carro " + j + " " + channelX3);
                                        
                                         //arregloautos[j].setNoH(tc,velocidad[j][3]);
                                         //arregloautos[j].getNoH();
                                         //arregloautos[j].Nohandovers.add(arregl oautos[j].getNoH());
                                         //arregloautos[j].setTiempores();
                                         //arregloautos[j].restimetable.add(arregloautos[j].getTiempores());
                                         //arregloautos[j].setProbability(0, velocidad[j][1]);//sacar la probabilidad de error a cada llamda entre en la zona de handover
                                         //arregloautos[j].probabilitytable.add(arregloautos[j].getProbability());
                                         
                                        
                                         
                                    }
                            }
                            else
                            {
                               hinix = 360; //limite inicial de area de handover
                               hfinx = 380; //limite final de area de handover

                               if ((XY[i][2] >=hinix && XY[i][2] <= hfinx))
                               {     
                                   arregloautos[j].handpicX2=false;
                                   arregloautos[j].handpicX4=false;
                                   arregloautos[j].speedcounterX2=0;
                                   arregloautos[j].speedX = 0;
                                   
                                   if (arregloautos[j].handsolpicX3==false && arregloautos[j].origin!=3) //si esta dentro del area efectiva y no se ha asignado peticion para handoever
                                    {	
                                        handsolix3++;
                                        arregloautos[j].handsolpicX3 =true;			//se cambia a 1 cuando se hace peticion de handover
                                        System.out.println("solicitud X2-X3 por el carro " + arregloautos[j].getCarro() + " " + arregloautos[j].getCoorX());
                                    }
                                    if ( arregloautos[j].handsolpicX3 ==true && arregloautos[j].handpicX3==false)   // zona efectiva de asignacion de handover
                                    {              
                                        arregloautos[j].setTiempores();
                                        arregloautos[j].restimetable.add(arregloautos[j].getTiempores());
                                        arregloautos[j].setTravertime(arregloautos[j].getVelocidad(), dres); // to compute handover resolution time (using the first speed value entering in the region and resolution time distance 10 meters
                                        avgHandtime.set(2, avgHandtime.get(2) + arregloautos[j].getTravertime());   // Calculando el total de los tiempos de traversal
                                        arregloautos[j].time20.add("\n" + arregloautos[j].getTraverlist()); // to add it to the list
                                        arregloautos[j].setProbability(0, arregloautos[j].getTravertime());//sacar la probabilidad de error a cada llamda entre en la zona de handover
                                        arregloautos[j].probabilitytable.add(arregloautos[j].getProbability());
                                        System.out.println( " Probabilidad " + arregloautos[j].getProbability() + " " + " Carro " + j );
                                        System.out.println( " Velocidad al entrar a la region de handover " + arregloautos[j].getVelocidad());
                                        System.out.println( " Tiempos que tarda al cruzar la region de handover X3 " + arregloautos[j].getTravertime());
                                        System.out.println( " Tiempo TOTAL que tarda al cruzar la region de handover X3 " + arregloautos[j].getTotaltravertime());
                                        
                                        System.out.println( " LA LISTA" + arregloautos[j].time20);
                                        
                                        if (arregloautos[j].getTiempores()>=arregloautos[j].getTravertime())
                                        {
                                            handtotalerrorx3++;
                                            arregloautos[j].incomingcall=false;
                                            arregloautos[j].incall=false;
                                            channelX2--;
                                            channelY2--;
                                            arregloautos[j].restimetable.add(3003);
                                            arregloautos[j].travertime.clear();
                                            System.out.println("Error de HO en canalX2 " + "carro " + j + " canalX2 " + channelX2 + " canalY2 " + channelY2);
                                        }
                                        else
                                            if(channelX3==availchannel)
                                            {
                                                handtotaloutx3++;
                                                arregloautos[j].incomingcall=false;
                                                arregloautos[j].incall=false;
                                                channelX2--;
                                                channelY2--;
                                                arregloautos[j].travertime.clear();
                                                System.out.println("Llamada Handover caida por canalX3 bloqueado " + "carro " + j + "canalX2 " + channelX2 + " canalY2 " + channelY2 + " canalX3 " + channelX3);
                                                
                                            }
                                            else
                                            {
                                                 arregloautos[j].handpicX3=true;
                                                 arregloautos[j].incomingcall=false;
                                                 arregloautos[j].origin=3;
                                                 channelX3++;
                                                 channelX2--;
                                                 channelY2--;
                                                 totalhandx3++;
                                                 asignedcallsx3++;
                                                 System.out.println("Handover para X2-X3 " + "carro " + j + "canalX2 " + channelX2 + " canalY2 " + channelY2 + " canalX3 " + channelX3);
                                                 arregloautos[j].travertime.clear();
                                                 System.out.println( " veces por las que cruza la region de handover X3 " + totalhandx3);
                                            }  
                                    }                                                      				
                                }
                            }
                        }
                        else
                            if ((XY[i][2] >=380 && XY[i][2] <= 560)&& (XY[i][3]>= 270 && XY[i][3] <= 290)) // ubicacion de las coordenadas en las picocelda en X 3
                            {   
                                 arregloautos[j].handsolpicX4=false;
                                 arregloautos[j].handpicX4=false;
                                 
                                  
                                
                                if (XY[i][2] >=380 && XY[i][2] <= 540)
                                {
                                    arregloautos[j].handsolpicX4=false; // resetea la asigancion de handover para ser detectado en la picocelda siguiente
                                    arregloautos[j].handsolpicX3=false;
                                    arregloautos[j].handpicX4=false;
                                    arregloautos[j].handpicX3=false;
                                    arregloautos[j].speedcounterX3++;
                                    arregloautos[j].setCellspeed(arregloautos[j].speedcounterX3, arregloautos[j].getVelocidad()); // to compute the crossing average speed
                                    arregloautos[j].setCelltime(arregloautos[j].getCellspeed(), D); // to compute the the crossing time (200mt)
                                
                                    System.out.println(" velocidad promedio en X3 el coche " + j + " " + arregloautos[j].getCellspeed());
                                    System.out.println(" Tiempo que tarda en cruzar X3 el coche " + j + " " + arregloautos[j].getCelltime());
                                    
                                }
                               
                                if(arregloautos[j].incomingcall==true && arregloautos[j].incall==false)
                                {
                                    if (XY[i][2] >= 380 && XY[i][2] <= 540)
                                    {
                                        if(channelX3<availchannel)
                                        {
                                            arregloautos[j].incomingcall=false;
                                            arregloautos[j].incall=true; //se asigna la llamada
                                            arregloautos[j].setTiempoexp();
                                            arregloautos[j].calltimetable.add(arregloautos[j].getTiempoexp());
                                            arregloautos[j].calltimes=arregloautos[j].getTiempoexp(); //asignar tc a aarreglo de autos
                                            arregloautos[j].origin=3;
                                            //arregloautos[j].handsolpicX3=true;
                                            //arregloautos[j].handpicX3=true; 
                                            channelX3++; //contador de canales.   
                                            asignednewcallsx3++;
                                            //System.out.println("canales asignados por nueva llamada en Picocelda 3" + " " + j + " " + channelX3);
                                            //System.out.println("Tiempo de generacion de llamada" + " " + arregloautos[j].bettime + " "+ j);
                                            //System.out.println(" Tiempo de llamada" + " " + arregloautos[j].calltimes);
                                            System.out.println(" Nueva llamada canaX3 " + "carro " + j + " " + channelX3);
                                        } 
                                        else
                                        {
                                            handtotaloutx3++;
                                            arregloautos[j].incomingcall=false;
                                            System.out.println("Llamada caida por canalX3 bloqueado " + "carro " + j + " " + channelX3);
                                        }
                                    }
                                    else
                                        if(channelX4==availchannel) //nueva llamada en region de handover
                                        {
                                            handtotaloutx4++; //outage
                                            arregloautos[j].incomingcall=false;
                                            arregloautos[j].incall=false;
                                            System.out.println("Llamada caida area HO por canalX4 bloqueado " + "carro " + j + " " + channelX4);
                                        }
                                        else
                                        {
                                             arregloautos[j].incall=true;
                                             arregloautos[j].incomingcall=false;
                                             arregloautos[j].handsolpicX4=true;
                                             arregloautos[j].handpicX4= true;
                                             arregloautos[j].setTiempoexp();
                                             arregloautos[j].calltimetable.add(arregloautos[j].getTiempoexp());
                                             arregloautos[j].calltimes=arregloautos[j].getTiempoexp(); //asignar tc a aarreglo de autos
                                             arregloautos[j].origin=4;
                                             channelX4++;
                                             asignednewcallsx4++;
                                             
                                            
                                        }
                                }
                                else
                                {
                                        hinix = 540; //limite inicial de area de handover
                                        hfinx = 560; 
                                        
                                        if (XY[i][2]>=540)
                                        {                                                                  
                                            if ((XY[i][2] >=hinix && XY[i][2] <= hfinx)) //tr[j] // se cmpara contra el tiempo de transito de celda o con el tiempo generado exponencialmente
                                            {                                                                                      
                                                arregloautos[j].handpicX3=false;
                                                arregloautos[j].speedcounterX3=0;
                                                arregloautos[j].speedX = 0;
                                                
                                                    if (arregloautos[j].handsolpicX4==false && arregloautos[j].origin!=4) //si esta dentro del area efectiva y no se ha asignado peticion para handoever
                                                    {	
                                                        handsolix4 ++; //request for handover
                                                        arregloautos[j].handsolpicX4=true;			//se cambia a 1 cuando se hace peticion de handover
                                                        System.out.println("solicitud X3-X4 por el carro " + arregloautos[j].getCarro() + " " + arregloautos[j].getCoorX());
                                                    }
                                                
                                                    if (arregloautos[j].handsolpicX4 == true && arregloautos[j].handpicX4==false)   // zona efectiva de asignacion de handover                                     
                                                    {     
                                                        arregloautos[j].setTiempores();
                                                        arregloautos[j].restimetable.add(arregloautos[j].getTiempores());
                                                        arregloautos[j].setTravertime(arregloautos[j].getVelocidad(), dres);
                                                        avgHandtime.set(3, avgHandtime.get(3) + arregloautos[j].getTravertime());   // Calculando el total de los tiempos de traversal
                                                        arregloautos[j].time20.add("\n" + arregloautos[j].getTraverlist());
                                                        arregloautos[j].setProbability(0, arregloautos[j].getTravertime());//sacar la probabilidad de error a cada llamda entre en la zona de handover
                                                        arregloautos[j].probabilitytable.add(arregloautos[j].getProbability());
                                                        System.out.println( " Probabilidad " + arregloautos[j].getProbability() + " " + " Carro " + j );
                                                        System.out.println( " Velocidad al entrar a la region de handover X4 " + arregloautos[j].getVelocidad());
                                                        System.out.println( " Tiempo que tarda en la region de handover X4 " + arregloautos[j].getTravertime());
                                                        System.out.println( " Tiempo TOTAL que tarda al cruzar la region de handover X4 " + arregloautos[j].getTotaltravertime());
                                                        System.out.println( " veces por las que cruza la region de handover X4 " + totalhandx4);
                                                        System.out.println( " LA LISTA" + arregloautos[j].time20);
                                                        
                                                        
                                                         if (arregloautos[j].getTiempores()>=arregloautos[j].getTravertime())                                            
                                                        {
                                                            handtotalerrorx4++;
                                                            arregloautos[j].incomingcall=false;
                                                            arregloautos[j].incall=false;
                                                            channelX3--;
                                                            arregloautos[j].restimetable.add(4004);
                                                            arregloautos[j].travertime.clear();
                                                            System.out.println("Error de HO en canalX3 " + "carro " + j + " " + channelX3);
                                                        }
                                                        else
                                                            if(channelX4==availchannel)   
                                                            {
                                                                handtotaloutx4++; //outage
                                                                arregloautos[j].incomingcall=false;
                                                                arregloautos[j].incall=false;
                                                                channelX3--;
                                                                arregloautos[j].travertime.clear();
                                                                System.out.println("Llamada Handover caida por canalX4 bloqueado " + "carro " + j + "canalX3 " + channelX3 + " canalX4 " + channelX4);
                                                            }
                                                            else
                                                            {
                                                                 arregloautos[j].incomingcall=false;
                                                                 arregloautos[j].handpicX4= true;
                                                                 arregloautos[j].origin=4;
                                                                 channelX4++;
                                                                 channelX3--;
                                                                 totalhandx4++;
                                                                 asignedcallsx4++;
                                                                 System.out.println("Handover para X3-X4" + "carro " + j + "canalX3 " + channelX3 + " canalX4 " + channelX4);
                                                                 arregloautos[j].travertime.clear();
                                                                 System.out.println( " veces por las que cruza la region de handover X3 " + totalhandx4);
                                                            }  
                                                    }                                    
                                                }
                                        }
                                }
                                }
                            }
        ////////>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> RIGHT TO LEFT X AXIS<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<        
                else if
                    (i>autos-1 && XY[i][2]-XY[i-autos][2]<0 && i>=autos)// && (arregloautos[j].incomingcall==true || arregloautos[j].incall==true)) // left to rigth
                    {
                        
                        if ((XY[i][2] >= 360 && XY[i][2] <= 560) && (XY[i][3]>= 270 && XY[i][3] <= 290)) // ubicacion de las coordenadas en las picocelda 1 en X
                        {
                            arregloautos[j].handsolpicX4=false;
                            arregloautos[j].handpicX4=false;
                            
                            if (XY[i][2] >= 380 && XY[i][2] <= 540)
                            {
                                arregloautos[j].handsolpicX3=false; // resetea la asigancion de handover para ser detectado en la picocelda siguiente
                                arregloautos[j].handsolpicX4=false;
                                arregloautos[j].handpicX3=false;
                                arregloautos[j].handpicX4=false;
                                arregloautos[j].speedcounterX3++; // to count times that loop enters in
                                arregloautos[j].setCellspeed(arregloautos[j].speedcounterX3, arregloautos[j].getVelocidad()); // to compute the crossing average speed
                                arregloautos[j].setCelltime(arregloautos[j].getCellspeed(), D); // to compute the the crossing time (200mt)
                                //cellspeedauxX1=arregloautos[j].getCellspeed();
                                System.out.println(" velocidad promedio en X3 el coche " + j + " " + arregloautos[j].getCellspeed());
                                System.out.println(" Tiempo que tarda en cruzar X3 el coche " + j + " " + arregloautos[j].getCelltime());
                            }

                            

                            if(arregloautos[j].incomingcall==true && arregloautos[j].incall==false) // nueva llamada
                            {
                                if (XY[i][2] >= 380 && XY[i][2] <= 560)
                                {
                                    if (channelX3<availchannel)
                                    {
                                        arregloautos[j].incomingcall=false;
                                        arregloautos[j].incall=true; //se asigna la llamada
                                        arregloautos[j].setTiempoexp();
                                        arregloautos[j].calltimetable.add(arregloautos[j].getTiempoexp());
                                        arregloautos[j].calltimes=arregloautos[j].getTiempoexp(); //asignar tc a aarreglo de autos
                                        arregloautos[j].origin=5;
                                        arregloautos[j].handsolpicX4=true;
                                        arregloautos[j].handpicX4=true; 
                                        channelX3++;
                                        asignednewcallsx3++;
                                        System.out.println("Nueva llamada canaX3 " + "carro " + j + " " + channelX3);
                                        //System.out.println("canales asignados por nueva llamada en Picocelda 3" + " " + j + " " + channelX3);
                                        //System.out.println("Tiempo de generacion de llamada" + " " + arregloautos[j].bettime + " "+ j);
                                        //System.out.println(" Tiempo de llamada" + " " + arregloautos[j].calltimes);
                                    }  
                                    else
                                    {
                                        handtotaloutx3++;
                                        arregloautos[j].incomingcall=false;
                                        System.out.println("Llamada caida por canalX3 bloqueado " + "carro " + j + " " + channelX3);
                                    }
                                }
                                else 
                                   if(channelX2==availchannel)
                                    {
                                        handtotaloutx2++; //outage
                                        arregloautos[j].incomingcall=false;
                                        arregloautos[j].incall=false;
                                        System.out.println("Llamada caida area HO por canalX2 bloqueado " + "carro " + j + "canalX2 " + channelX2 + "canalY2 " + channelY2);
                                    }
                                    else
                                    {
                                         
                                         arregloautos[j].incall=true;
                                         arregloautos[j].incomingcall=false;
                                         arregloautos[j].setTiempoexp();
                                         arregloautos[j].calltimetable.add(arregloautos[j].getTiempoexp());
                                         arregloautos[j].calltimes=arregloautos[j].getTiempoexp(); //asignar tc a aarreglo de autos
                                         arregloautos[j].origin=6;
                                         arregloautos[j].handpicX3= true;
                                         arregloautos[j].handsolpicX3=true;
                                         channelX2++;
                                         channelY2++;
                                         asignednewcallsx2++;
                                         System.out.println("Nueva llamada area HO en canaX2" + "carro " + j + " " + channelX2 + " " + channelY2);
                                        
                                    }
                            }
                            else
                                                         
                                if (XY[i][2]>=540)
                                {                    
                                    hinix = 540; //limite inicial de area de handover
                                    hfinx= 560;
                                    if ((XY[i][2] >=hinix && XY[i][2] <= hfinx)) //tr[j] // se cmpara contra el tiempo de transito de celda o con el tiempo generado exponencialmente
                                    {                                      
                                        arregloautos[j].handpicX3=false;
                                        //arregloautos[j].handpicX4=false;
                                        
                                        if (arregloautos[j].handsolpicX4==false && arregloautos[j].origin!=5) //si esta dentro del area efectiva y no se ha asignado peticion para handoever
                                        {	
                                            handsolix5++; //request for handover
                                            arregloautos[j].handsolpicX4=true;
                                            System.out.println("solicitud X4-X3 por el carro " + arregloautos[j].getCarro() + " " + arregloautos[j].getCoorX());
                                                                            
                                        }
                                        
                                        if (arregloautos[j].handsolpicX4 == true && arregloautos[j].handpicX4==false)   // zona efectiva de asignacion de handover                                     
                                        {   
                                            arregloautos[j].setTiempores();
                                            arregloautos[j].restimetable.add(arregloautos[j].getTiempores());
                                            arregloautos[j].setTravertime(arregloautos[j].getVelocidad(), dres);
                                            avgHandtime.set(4, avgHandtime.get(4) + arregloautos[j].getTravertime());   // Calculando el total de los tiempos de traversal
                                            arregloautos[j].time20.add("\n" + arregloautos[j].getTraverlist());
                                            arregloautos[j].setProbability(0, arregloautos[j].getTravertime());//sacar la probabilidad de error a cada llamda entre en la zona de handover
                                            arregloautos[j].probabilitytable.add(arregloautos[j].getProbability());
                                            
                                            System.out.println( " Probabilidad " + arregloautos[j].getProbability() + " " + " Carro " + j );
                                            System.out.println( " Velocidad al entrar a la region de handover X4 " + arregloautos[j].getVelocidad());
                                            System.out.println( " Tiempo que tarda al cruzar la region de handover X4 " + arregloautos[j].getTravertime());
                                            System.out.println( " Tiempo TOTAL que tarda al cruzar la region de handover X4 " + arregloautos[j].getTotaltravertime());
                                           
                                            System.out.println( " LA LISTA" + arregloautos[j].time20);
                                           
                                            
                                            if (arregloautos[j].getTiempores()>=arregloautos[j].getTravertime())                                            
                                            {
                                                handtotalerrorx3++;                                        
                                                arregloautos[j].incomingcall=false;
                                                arregloautos[j].incall=false;
                                                channelX4--;
                                                arregloautos[j].restimetable.add(-3003);
                                                arregloautos[j].travertime.clear();
                                                System.out.println("Error de HO en canalX4 " + "carro " + j + " " + channelX4);
                                            }
                                            else
                                                if(channelX3==availchannel)
                                                {
                                                    handtotaloutx3++; //outage
                                                    arregloautos[j].incomingcall=false;
                                                    arregloautos[j].incall=false;
                                                    channelX4--;
                                                    arregloautos[j].travertime.clear();
                                                    System.out.println("Llamada Handover caida por canalX3 bloqueado " + "carro " + j + "canalX3 " + channelX3 + " canalX4 " + channelX4);
                                                }
                                                else
                                                {
                                                    
                                                     arregloautos[j].handpicX4= true;
                                                     arregloautos[j].incomingcall=false;
                                                     arregloautos[j].origin=5;
                                                     channelX3++;
                                                     channelX4--;
                                                     totalhandx5++;
                                                     asignedcallsx3++;
                                                     System.out.println("Handover para X0-X1" + "carro " + j + "canalX0 " + channelX0 + " canalX1 " + channelX1);
                                                     arregloautos[j].travertime.clear();
                                                     System.out.println( " veces por las que cruza la region de handover X4 " +totalhandx5);
                                                }  
                                        }                                                                                                                                
                                    }
                                }
                                else 
                                {
                                    hinix = 360; //limite inicial de area de handover
                                    hfinx= 380; //limite final de area de handover

                                    // El auto se encuentra en area de handover y el tiempo del recorrido es menor que el tiempo que durara la llamada
                                    if ((XY[i][2] >=hinix && XY[i][2] <= hfinx)) //tr[j] // se cmpara contra el tiempo de transito de celda o con el tiempo generado exponencialmente
                                    {     
                                        arregloautos[j].handpicX2=false;
                                        arregloautos[j].handpicX4=false;
                                        arregloautos[j].speedcounterX3=0;
                                        arregloautos[j].speedX = 0;
                                        
                                        
                                        if (arregloautos[j].handsolpicX3==false && arregloautos[j].origin!=6) //si esta dentro del area efectiva y no se ha asignado peticion para handoever
                                        {	
                                            handsolix6 ++; //request for handover
                                            arregloautos[j].handsolpicX3=true;			//se cambia a 1 cuando se hace peticion de handover
                                            System.out.println("solicitud X3-X2 por el carro " + arregloautos[j].getCarro() + " " + arregloautos[j].getCoorX());
                                        }
                                        
                                        if (arregloautos[j].handsolpicX3 == true && arregloautos[j].handpicX3==false)   // zona efectiva de asignacion de handover                                     
                                        {              
                                            arregloautos[j].setTiempores();
                                            arregloautos[j].restimetable.add(arregloautos[j].getTiempores());
                                            arregloautos[j].setTravertime(arregloautos[j].getVelocidad(), dres); // to compute handover resolution time (using the first speed value entering in the region and resolution time distance 10 meters
                                            avgHandtime.set(5, avgHandtime.get(5) + arregloautos[j].getTravertime());   // Calculando el total de los tiempos de traversal
                                            //auxiliarX3=(arregloautos[j].getTravertime()); // to keep the same hadover resolution time to the first handover region (<20- X coords)
                                            arregloautos[j].time20.add("\n" + arregloautos[j].getTraverlist()); // to add it to the list
                                            arregloautos[j].setProbability(0, arregloautos[j].getTravertime());//sacar la probabilidad de error a cada llamda entre en la zona de handover
                                            arregloautos[j].probabilitytable.add(arregloautos[j].getProbability());
                                            System.out.println( " Probabilidad " + arregloautos[j].getProbability() + " " + " Carro " + j );
                                             System.out.println( " Velocidad al entrar a la region de handover X3 " + arregloautos[j].getVelocidad());
                                            System.out.println( " Tiempo que tarda al cruzar la region de handover X3 " + arregloautos[j].getTravertime());
                                            System.out.println( " Tiempo TOTAL que tarda al cruzar la region de handover X3 " + arregloautos[j].getTotaltravertime());
                                            
                                            System.out.println( " LA LISTA" + arregloautos[j].time20);
                                            
                                            
                                             if (arregloautos[j].getTiempores()>=arregloautos[j].getTravertime())                                            
                                            {
                                                handtotalerrorx2++;                                        
                                                arregloautos[j].incomingcall=false;
                                                arregloautos[j].incall=false;
                                                channelX3--;
                                                arregloautos[j].restimetable.add(-2002);
                                                arregloautos[j].travertime.clear();
                                                System.out.println("Error de HO en canalX3 " + "carro " + j + " " + channelX3);
                                            }
                                            else
                                                if(channelX2==availchannel)
                                                {
                                                    handtotaloutx2++; //outage
                                                    arregloautos[j].incomingcall=false;
                                                    arregloautos[j].incall=false;
                                                    channelX3--;
                                                    arregloautos[j].travertime.clear();
                                                    System.out.println("Llamada Handover caida por canalX2 bloqueado " + "carro " + j + "canalX3 " + channelX3 + " canalX2 " + channelX2);
                                                }
                                                else
                                                {
                                                     
                                                     arregloautos[j].handpicX3= true;
                                                     arregloautos[j].incomingcall=false;
                                                     arregloautos[j].origin=6;
                                                     channelX2++;
                                                     channelY2++;
                                                     channelX3--;
                                                     totalhandx6++;
                                                     asignedcallsx2++;
                                                     System.out.println("Handover para X3-X2" + "carro " + j + "canalX3 " + channelX3 + " canalX2 " + channelX2 + " canalY2 " + channelY2);
                                                     //System.out.println("Descuento de canal por asignacion X3-X2" + channelX3);
                                                     //System.out.println("Asignacion de canal handover para X3-X2" + " " + i + " " + channelX3 + " " + channelX2);
                                                     arregloautos[j].travertime.clear();
                                                     System.out.println( " veces por las que cruza la region de handover X3 " + totalhandx6);
                                                }  
                                        }                                                                                                  
                                    }
                                }
                        }
                        else
                            if ((XY[i][2] >=180 && XY[i][2] <= 360) && (XY[i][3]>= 270 && XY[i][3] <= 290)) // ubicacion de las coordenadas en las picocelda en X 2
                            {   
                                
                                arregloautos[j].handsolpicX2=false;
                                arregloautos[j].handpicX2=false;
                                
                                if (XY[i][2] >=200 && XY[i][2] <= 360)
                                {
                                    arregloautos[j].speedcounterX2++;
                                    arregloautos[j].setCellspeed(arregloautos[j].speedcounterX2, arregloautos[j].getVelocidad()); // to compute the crossing average speed
                                    arregloautos[j].setCelltime(arregloautos[j].getCellspeed(), D); // to compute the the crossing time (200mt)
                                    System.out.println(" velocidad promedio en X2 el coche " + j + " " + arregloautos[j].getCellspeed());
                                    System.out.println(" Tiempo que tarda en cruzar X2 el coche " + j + " " + arregloautos[j].getCelltime());
                                }
                                
                                if (XY[i][2] >= 200 && XY[i][2] <= 360)
                                {
                                    arregloautos[j].handsolpicX2=false; // resetea la asigancion de handover para ser detectado en la picocelda siguiente
                                    arregloautos[j].handsolpicX3=false;
                                    arregloautos[j].handpicX2=false;
                                    arregloautos[j].handpicX3=false;
                                }


                                
                                if(arregloautos[j].incomingcall==true && arregloautos[j].incall==false)
                                {
                                    if (XY[i][2] >=200 && XY[i][2] <= 360)
                                    {
                                        if (channelX2<availchannel)
                                        {
                                            arregloautos[j].incomingcall=false;
                                            arregloautos[j].incall=true;
                                            arregloautos[j].setTiempoexp();
                                            arregloautos[j].calltimetable.add(arregloautos[j].getTiempoexp());
                                            arregloautos[j].calltimes=arregloautos[j].getTiempoexp(); //asignar tc a aarreglo de autos
                                            //arregloautos[j].handsolpicX2=true;
                                            //arregloautos[j].handpicX2=true; 
                                            arregloautos[j].origin=6;
                                            channelX2++; //contador de canales.
                                            channelY2++;
                                            asignednewcallsx2++;
                                            System.out.println(" Nueva llamada canaX2" + "carro " + j + " canalX2 " + channelX2 + " canalY2 " + channelY2);
                                             
                                        }
                                        else
                                        {
                                            handtotaloutx2++;
                                            arregloautos[j].incomingcall=false;
                                            System.out.println("Llamada caida por canalX2 bloqueado " + "carro " + j + " canalX2 " + channelX2 + " canalY2 " + channelY2);
                                        }
                                    }
                                    else 
                                        if(channelX1==availchannel)
                                        {
                                            handtotaloutx1++; //outage
                                            arregloautos[j].incomingcall=false;
                                            arregloautos[j].incall=false;
                                            System.out.println("Llamada caida area HO por canalX1 bloqueado " + "carro " + j + " " + channelX1);
                                        }
                                        else
                                        {
                                             
                                             arregloautos[j].incomingcall=false;
                                             arregloautos[j].incall=true;
                                             arregloautos[j].handpicX2= true;
                                             arregloautos[j].handsolpicX2=true;
                                             arregloautos[j].setTiempoexp();
                                             arregloautos[j].calltimetable.add(arregloautos[j].getTiempoexp());
                                             arregloautos[j].calltimes=arregloautos[j].getTiempoexp(); //asignar tc a aarreglo de autos
                                             arregloautos[j].origin=7;
                                             channelX1++;
                                             asignednewcallsx1++;
                                             System.out.println("Nueva llamada area HO en canaX1" + "carro " + j + " " + channelX1);
                                            //System.out.println("Descuento de canal por asignacion X1-X2" + channelX1);
                                             //System.out.println("Nueva llanada en X2-X1" + " " + j + " "+ channelX1);
                                             //System.out.println("Tiempo de generacion de llamada" + " " + arregloautos[j].bettime + " "+ j);
                                             //System.out.println(" Tiempo de llamada" + " " + arregloautos[j].calltimes);
                                        
                                        }
                                }
                                else
                                {   
                                   hinix = 180; //limite inicial de area de handover
                                   hfinx = 200; //limite final de area de handover

                                   if ((XY[i][2] >=hinix && XY[i][2] <= hfinx))
                                   {     
                                       arregloautos[j].handpicX1=false;
                                       arregloautos[j].handpicX3=false;
                                       arregloautos[j].speedcounterX2=0;
                                       arregloautos[j].speedX = 0;
                                       
                                       if (arregloautos[j].handsolpicX2==false && arregloautos[j].origin!=7) //si esta dentro del area efectiva y no se ha asignado peticion para handoever
                                        {	
                                            handsolix7++;
                                            //System.out.println("solicitud X2-X1" + arregloautos[j].getCarro() + " " + arregloautos[j].getCoorX());
                                            arregloautos[j].handsolpicX2 =true;			//se cambia a 1 cuando se hace peticion de handover 
                                            System.out.println("solicitud X2-X1 por el carro " + arregloautos[j].getCarro() + " " + arregloautos[j].getCoorX());
                                        }
                                        if ( arregloautos[j].handsolpicX2 ==true && arregloautos[j].handpicX2==false)   // zona efectiva de asignacion de handover
                                        {              
                                            arregloautos[j].setTiempores();
                                            arregloautos[j].restimetable.add(arregloautos[j].getTiempores());
                                            arregloautos[j].setTravertime(arregloautos[j].getVelocidad(), dres); // to compute handover resolution time (using the first speed value entering in the region and resolution time distance 10 meters
                                            avgHandtime.set(6, avgHandtime.get(6) + arregloautos[j].getTravertime());   // Calculando el total de los tiempos de traversal
                                            arregloautos[j].time20.add("\n" + arregloautos[j].getTraverlist()); // to add it to the list
                                            arregloautos[j].setProbability(0, arregloautos[j].getTravertime());//sacar la probabilidad de error a cada llamda entre en la zona de handover
                                            arregloautos[j].probabilitytable.add(arregloautos[j].getProbability());
                                            System.out.println( " Probabilidad " + arregloautos[j].getProbability() + " " + " Carro " + j );
                                             System.out.println( " Velocidad al entrar a la region de handover X2 " + arregloautos[j].getVelocidad());
                                            System.out.println( " Tiempos que tarda al cruzar la region de handover X2 " + arregloautos[j].getTravertime());
                                            System.out.println( " Tiempo TOTAL que tarda al cruzar la region de handover X2 " + arregloautos[j].getTotaltravertime());
                                            
                                            System.out.println( " LA LISTA" + arregloautos[j].time20); 
                                            
                                            if (arregloautos[j].getTiempores()>=arregloautos[j].getTravertime())
                                            {
                                                handtotalerrorx1++;
                                                arregloautos[j].incomingcall=false;
                                                arregloautos[j].incall=false;
                                                channelX2--;
                                                channelY2--;
                                                arregloautos[j].restimetable.add(-1001);
                                                arregloautos[j].travertime.clear();
                                                System.out.println("Error de HO en canalX2 " + "carro " + j + " canalX2 " + channelX2 + " canalY2 " + channelY2);
                                            }
                                            
                                            else
                                                
                                                if(channelX1==availchannel)
                                                {
                                                    handtotaloutx1++;
                                                    arregloautos[j].incomingcall=false;
                                                    arregloautos[j].incall=false;
                                                    channelX2--;
                                                    channelY2--;
                                                    arregloautos[j].travertime.clear();
                                                    System.out.println("Llamada Handover caida por canalX1 bloqueado " + "carro " + j + "canalX1 " + channelX1 + " canalX2 " + channelX2 + " canalY2 " + channelY2);
                                                }
                                                else                                            
                                                {
                                                    arregloautos[j].handpicX2=true;
                                                    arregloautos[j].incomingcall=false;
                                                    arregloautos[j].origin=7;
                                                    channelX1++;
                                                    channelX2--;
                                                    channelY2--;
                                                    totalhandx7++;
                                                    asignedcallsx1++;
                                                    System.out.println("Handover para X2-X1" + "carro " + j + "canalX1 " + channelX1 + " canalX2 " + channelX2 + " canalY2 " + channelY2);
                                                    arregloautos[j].travertime.clear();
                                                    System.out.println( " veces por las que cruza la region de handover X2 " + totalhandx7);
                                                }
                                                                                                       
                                                     
                                                 
                                        }                                                      				
                                    }
                                }
                            }
                            else
                                if ((XY[i][2] >=0 && XY[i][2] <= 180)&& (XY[i][3]>= 270 && XY[i][3] <= 290)) // ubicacion de las coordenadas en las picocelda en X 3
                                {   
                                        arregloautos[j].handsolpicX1=false;
                                        arregloautos[j].handpicX1=false;
                                    
                                    if (XY[i][2] >= 20 && XY[i][2] <= 180)
                                    {
                                        arregloautos[j].handsolpicX2=false; // resetea la asigancion de handover para ser detectado en la picocelda siguiente
                                        arregloautos[j].handsolpicX1=false;
                                        arregloautos[j].handpicX2=false;
                                        arregloautos[j].handpicX1=false;
                                        arregloautos[j].speedcounterX1++;
                                        arregloautos[j].setCellspeed(arregloautos[j].speedcounterX1, arregloautos[j].getVelocidad()); // to compute the crossing average speed
                                        arregloautos[j].setCelltime(arregloautos[j].getCellspeed(), D); // to compute the the crossing time (200mt)
                                        System.out.println(" velocidad promedio en X1 el coche " + j + " " + arregloautos[j].getCellspeed());
                                        System.out.println(" Tiempo que tarda en cruzar X1 el coche " + j + " " + arregloautos[j].getCelltime());
                                    }
                                    
                                        if(arregloautos[j].incomingcall==true && arregloautos[j].incall==false)
                                      
                                        if (XY[i][2] >=20 && XY[i][2] <= 180)
                                        {
                                            if(channelX1<availchannel)

                                            {
                                                arregloautos[j].incomingcall=false;
                                                arregloautos[j].incall=true; //se asigna la llamada
                                                arregloautos[j].setTiempoexp();
                                                arregloautos[j].calltimetable.add(arregloautos[j].getTiempoexp());
                                                arregloautos[j].calltimes=arregloautos[j].getTiempoexp(); //asignar tc a aarreglo de autos
                                                //arregloautos[j].handsolpicX1=true;
                                                //arregloautos[j].handpicX1=true;    
                                                arregloautos[j].origin=7;
                                                channelX1++; //contador de canales.
                                                asignednewcallsx1++;
                                                System.out.println(" Nueva llamada canaX1" + "carro " + j + " " + channelX1);
                                                
                                                //System.out.println("canales asignados por nueva llamada en Picocelda 1" + " "+ j + " " + channelX1);
                                                //System.out.println("Tiempo de generacion de llamada" + " " + arregloautos[j].bettime + " "+ j);
                                                //System.out.println(" Tiempo de llamada" + " " + arregloautos[j].calltimes);
                                            } 
                                            else
                                            {
                                                handtotaloutx1++;
                                                arregloautos[j].incomingcall=false;
                                                System.out.println("Llamada caida por canalX1 bloqueado " + "carro " + j + " " + channelX1);
                                            }
                                        }
                                    else
                                            
                                        if(channelX0==availchannel)
                                        {
                                            handtotaloutx0++; //outage
                                            arregloautos[j].incomingcall=false;
                                            arregloautos[j].incall=false;
                                            System.out.println("Llamada caida area HO por canalX0 bloqueado " + "carro " + j + " " + channelX0);
                                        }
                                        else
                                        {
                                             arregloautos[j].incomingcall=false;
                                             arregloautos[j].incall=true;
                                             arregloautos[j].setTiempoexp();
                                             arregloautos[j].calltimetable.add(arregloautos[j].getTiempoexp());
                                             arregloautos[j].calltimes=arregloautos[j].getTiempoexp(); //asignar tc a aarreglo de autos
                                             arregloautos[j].handpicX1= true;
                                             arregloautos[j].handsolpicX1=true;                            
                                             arregloautos[j].origin=0;
                                             channelX0++;
                                             asignednewcallsx0++;
                                             System.out.println("Nueva llamada area HO en canaX0" + "carro " + j + " " + channelX0);
                                            //System.out.println("Descuento de canal por asignacion X1-X2" + channelX1);
                                             //System.out.println("Nueva llanada en X1-X2" + " " + j + " "+ channelX2);
                                             //System.out.println("Tiempo de generacion de llamada" + " " + arregloautos[j].bettime + " "+ j);
                                             //System.out.println(" Tiempo de llamada" + " " + arregloautos[j].calltimes);
                                        }
                                        else                                                                                       
                                            if (XY[i][2]<=20)
                                            {
                                                hinix = 0; //limite inicial de area de handover
                                                hfinx = 20; 
                                                
                                                if ((XY[i][2] >=hinix && XY[i][2] <= hfinx)) //tr[j] // se cmpara contra el tiempo de transito de celda o con el tiempo generado exponencialmente
                                                {                                                                                      
                                                    arregloautos[j].handpicX2=false;
                                                    arregloautos[j].speedcounterX1=0;
                                                    arregloautos[j].speedX = 0;
                                                   
                                                    if (arregloautos[j].handsolpicX1==false && arregloautos[j].origin!=0) //si esta dentro del area efectiva y no se ha asignado peticion para handoever
                                                        {	
                                                            handsolix8 ++; //request for handover
                                                            //System.out.println("solicitud X1-X0" + " " + arregloautos[j].getCarro() + " " + arregloautos[j].getCoorX() +" "+arregloautos[j].handpicY0 + " "+arregloautos[j].handsolpicX0);
                                                            arregloautos[j].handsolpicX1=true;			//se cambia a 1 cuando se hace peticion de handover 
                                                            System.out.println("solicitud X1-X0 por el carro " + arregloautos[j].getCarro() + " " + arregloautos[j].getCoorX());
                                                        }
                                                        if (arregloautos[j].handsolpicX1 == true && arregloautos[j].handpicX1==false)   // zona efectiva de asignacion de handover                                     
                                                        {     
                                                            arregloautos[j].setTiempores();
                                                            arregloautos[j].restimetable.add(arregloautos[j].getTiempores());
                                                            arregloautos[j].setTravertime(arregloautos[j].getVelocidad(), dres); // to compute handover resolution time (using the first speed value entering in the region and resolution time distance 10 meters
                                                            avgHandtime.set(7, avgHandtime.get(7) + arregloautos[j].getTravertime());   // Calculando el total de los tiempos de traversal
                                                            arregloautos[j].time20.add("\n" + arregloautos[j].getTraverlist()); // to add it to the list
                                                            arregloautos[j].setProbability(0, arregloautos[j].getTravertime());//sacar la probabilidad de error a cada llamda entre en la zona de handover
                                                            arregloautos[j].probabilitytable.add(arregloautos[j].getProbability());
                                                            System.out.println( " Probabilidad " + arregloautos[j].getProbability() + " " + " Carro " + j );
                                                            System.out.println( " Velocidad al entrar a la region de handover X1 " + arregloautos[j].getVelocidad());
                                                            System.out.println( " Tiempos que tarda al cruzar la region de handover X1 " + arregloautos[j].getTravertime());
                                                            System.out.println( " Tiempo TOTAL que tarda al cruzar la region de handover X1 " + arregloautos[j].getTotaltravertime());
                                                            
                                                            System.out.println( " LA LISTA" + arregloautos[j].time20); 
                                                            
                                                            if (arregloautos[j].getTiempores()>=arregloautos[j].getTravertime())                                            
                                                            {
                                                                handtotalerrorx0++;
                                                                //System.out.println("Error X1-X0" + " " + arregloautos[j].getCarro() + " " + arregloautos[j].getCoorX() +" "+arregloautos[j].handpicY0 + " "+arregloautos[j].handsolpicX0);
                                                                arregloautos[j].incomingcall=false;
                                                                arregloautos[j].incall=false;
                                                                channelX1--;
                                                                arregloautos[j].restimetable.add(-0000);
                                                                arregloautos[j].travertime.clear();
                                                                System.out.println("Error de HO en canalX1 " + "carro " + j + " " + channelX1);
                                                            }
                                                            else
                                                                if(channelX0==availchannel)   
                                                                {
                                                                    handtotaloutx0++; //outage
                                                                    //System.out.println("outage X1-X0" + " " + arregloautos[j].getCarro() + " " + arregloautos[j].getCoorX() +" "+ arregloautos);
                                                                    arregloautos[j].incomingcall=false;
                                                                    arregloautos[j].incall=false;
                                                                    channelX1--;
                                                                    arregloautos[j].travertime.clear();
                                                                    System.out.println("Llamada Handover caida por canalX0 bloqueado " + "carro " + j + "canalX0 " + channelX0 + " canalX1 " + channelX1);
                                                                }
                                                                else
                                                                {
                                                                     arregloautos[j].handpicX1= true;
                                                                     arregloautos[j].incomingcall=false;
                                                                     arregloautos[j].origin=0;
                                                                     channelX0++;
                                                                     channelX1--;
                                                                     totalhandx8++;
                                                                     asignedcallsx0++;
                                                                     System.out.println("Handover para X1-X0" + "carro " + j + "canalX0 " + channelX0 + " canalX1 " + channelX1);
                                                                     arregloautos[j].travertime.clear();
                                                                     System.out.println( " veces por las que cruza la region de handover X1 " + totalhandx8);
                                                                }  
                                                        }
                                                        
                                                }
                                            }
                                    }
                                }
           ////////////////////////*asignation for Y-axis)*///////////////////////////////////////////////    
                else if 
                        (i>(autos-1) && XY[i][3]-XY[i-autos][3]>0 && i>=autos)// && (arregloautos[j].incomingcall==true || arregloautos[j].incall==true))
                        {
                            if ((XY[i][3] >= 0 && XY[i][3] <= 200) && (XY[i][2]>= 270 && XY[i][2] <= 290)) // ubicacion de las coordenadas en las picocelda 1 en X
                            {     
                               arregloautos[j].handsolpicY1=false;
                               arregloautos[j].handpicY1=false;
                               
                                if (XY[i][3] >= 20 && XY[i][3] <= 180)
                                {
                                    arregloautos[j].handsolpicY2=false; // resetea la asigancion de handover para ser detectado en la picocelda siguiente
                                    arregloautos[j].handsolpicY1=false;
                                    arregloautos[j].handpicY2=false;
                                    arregloautos[j].handpicY1=false;
                                    arregloautos[j].speedcounterY1++;
                                    arregloautos[j].setCellspeed(arregloautos[j].speedcounterY1, arregloautos[j].getVelocidad()); // to compute the crossing average speed
                                    arregloautos[j].setCelltime(arregloautos[j].getCellspeed(), D); // to compute the the crossing time (200mt)
                                    System.out.println(" velocidad promedio en Y1 el coche " + j + " " + arregloautos[j].getCellspeed());
                                    System.out.println(" Tiempo que tarda en cruzar Y1 el coche " + j + " " + arregloautos[j].getCelltime());
                                    
                                }
                                
                                if(arregloautos[j].incomingcall==true && arregloautos[j].incall==false) // nueva llamada

                                    if (XY[i][3] >= 0 && XY[i][3] <= 180)
                                    {
                                        if (channelY1<availchannel)
                                        {
                                            arregloautos[j].incomingcall=false;
                                            arregloautos[j].incall=true; //se asigna la llamada
                                            arregloautos[j].setTiempoexp();
                                            arregloautos[j].calltimetable.add(arregloautos[j].getTiempoexp());
                                            arregloautos[j].calltimes=arregloautos[j].getTiempoexp(); //asignar tc a aarreglo de autos
                                            arregloautos[j].origin=9;
                                            arregloautos[j].handsolpicY1=true;
                                            arregloautos[j].handpicY1=true;
                                            channelY1++; //contador de canales.
                                            asignednewcallsy1++;
                                            System.out.println(" Nueva llamada canalY1 " + "carro " + j + " " + channelY1);
                                          
                                            
                                            //arregloautos[j].setTiempores();
                                            //arregloautos[j].restimetable.add(arregloautos[j].getTiempores());
                                            //arregloautos[j].setProbability(0, velocidad[j][1]);//sacar la probabilidad de error a cada llamda entre en la zona de handover
                                            //arregloautos[j].probabilitytable.add(arregloautos[j].getProbability());
                                            
                                        }  
                                        else
                                        {
                                            handtotalouty1++;
                                            arregloautos[j].incomingcall=false;
                                            System.out.println("Llamada caida por canalY1 bloqueado " + "carro " + j + " " + channelY1);
                                        }
                                    }

                                    else /// new calls in handover region

                                        if(channelX2==availchannel)
                                            {
                                                handtotalouty2++; //outage
                                                arregloautos[j].incomingcall=false;
                                                arregloautos[j].incall=false;
                                                System.out.println("Llamada caida area HO por canalY2 bloqueado " + "carro " + j + " " + channelX2);
                                            }
                                        else
                                            {
                                                
                                                 arregloautos[j].incomingcall=false; 
                                                 arregloautos[j].incall=true;
                                                 arregloautos[j].setTiempoexp();
                                                 arregloautos[j].calltimetable.add(arregloautos[j].getTiempoexp());
                                                 arregloautos[j].calltimes=arregloautos[j].getTiempoexp(); //asignar tc a aarreglo de autos
                                                 arregloautos[j].handpicY2= true;
                                                 arregloautos[j].handsolpicY2=true;
                                                 arregloautos[j].origin=10;
                                                 channelX2++;
                                                 channelY2++;
                                                 asignednewcallsy2++;
                                                 System.out.println("Nueva llamada area HO en canaY2 " + "carro " + j + " " + channelX2 + " " + channelY2);
                                                 
                                                 //arregloautos[j].setTiempores();
                                                 //arregloautos[j].restimetable.add(arregloautos[j].getTiempores());
                                                 //arregloautos[j].setProbability(0, velocidad[j][1]);//sacar la probabilidad de error a cada llamda entre en la zona de handover
                                                 //arregloautos[j].probabilitytable.add(arregloautos[j].getProbability());
                                                                                  
                                                 
                                                 
                                                 

                                                
                                            }  
                                else

                                    if (XY[i][3]<=20)
                                    {
                                        hiniy = 0; //limite inicial de area de handover
                                        hfiny= 20; 

                                        if ((XY[i][3] >=hiniy && XY[i][3] <= hfiny)) //tr[j] // se cmpara contra el tiempo de transito de celda o con el tiempo generado exponencialmente
                                        {                                      
                                            arregloautos[j].handpicY2=false;
                                            //arregloautos[j].handpicX1=false;

                                            if (arregloautos[j].handsolpicY1==false && arregloautos[j].origin!=9) //si esta dentro del area efectiva y no se ha asignado peticion para handoever
                                            {	
                                                handsoliy1 ++; //request for handover
                                                arregloautos[j].handsolpicY1=true;			//se cambia a 1 cuando se hace peticion de handover 
                                                System.out.println("solicitud Y0-Y1 por el carro " + arregloautos[j].getCarro() + " " + arregloautos[j].getCoorX());
                                            }
                                            if (arregloautos[j].handsolpicY1 == true && arregloautos[j].handpicY1==false)   // zona efectiva de asignacion de handover                                     
                                            {              
                                                arregloautos[j].setTiempores();
                                                arregloautos[j].restimetable.add(arregloautos[j].getTiempores());
                                                arregloautos[j].setTravertime(arregloautos[j].getVelocidad(), dres);
                                                avgHandtime.set(8, avgHandtime.get(8) + arregloautos[j].getTravertime());   // Calculando el total de los tiempos de traversal
                                                arregloautos[j].time20.add("\n" + arregloautos[j].getTraverlist());
                                                arregloautos[j].setProbability(0, arregloautos[j].getTravertime());//sacar la probabilidad de error a cada llamda entre en la zona de handover
                                                arregloautos[j].probabilitytable.add(arregloautos[j].getProbability());
                                                System.out.println( " Probabilidad " + arregloautos[j].getProbability() + " " + " Carro " + j );
                                                System.out.println( " Velocidad al entrar a la region de handover " + arregloautos[j].getVelocidad());
                                                System.out.println( " Tiempo TOTAL que tarda al cruzar la region de handover Y1 " + arregloautos[j].getTotaltravertime());
                                                
                                                System.out.println( " LA LISTA" + arregloautos[j].time20);
                                                
                                                if (arregloautos[j].getTiempores()>=arregloautos[j].getTravertime())                                            
                                                {
                                                    handtotalerrory1++;                                        
                                                    arregloautos[j].incomingcall=false;
                                                    arregloautos[j].incall=false;
                                                    channelY0--;
                                                    arregloautos[j].restimetable.add(5001);
                                                    arregloautos[j].travertime.clear();
                                                    System.out.println("Error de HO en canalY0 " + "carro " + j + " " + channelY0);
                                                }
                                                else
                                                    if(channelY1==availchannel)
                                                    {
                                                        handtotalouty1++; //outage
                                                        arregloautos[j].incomingcall=false;
                                                        arregloautos[j].incall=false;
                                                        channelY0--;
                                                        arregloautos[j].travertime.clear();
                                                        System.out.println("Llamada Handover caida por canalY1 bloqueado " + "carro " + j + "canalY0 " + channelY0 + " canalY1 " + channelY1);
                                                    }
                                                    else
                                                    {
                                                         
                                                         arregloautos[j].handpicY1= true;
                                                         arregloautos[j].incomingcall=false;
                                                         arregloautos[j].origin=9;
                                                         channelY1++;
                                                         channelY0--;
                                                         totalhandy1++;
                                                         asignedcallsy1++;
                                                         System.out.println("Handover para Y0-Y1 " + "carro " + j + "canalY0 " + channelY0 + " canalY1 " + channelY1);
                                                         arregloautos[j].travertime.clear();
                                                         System.out.println( " veces por las que cruza la region de handover Y1 " + totalhandy1);
                                                    }  
                                            }                                                                                                                                
                                        }
                                    }
                                    else 
                                    {
                                        hiniy = 180; //limite inicial de area de handover
                                        hfiny= 200; //limite final de area de handover

                                        // El auto se encuentra en area de handover y el tiempo del recorrido es menor que el tiempo que durara la llamada
                                        if ((XY[i][3] >=hiniy && XY[i][3] <= hfiny)) //tr[j] // se cmpara contra el tiempo de transito de celda o con el tiempo generado exponencialmente
                                        {     
                                            arregloautos[j].handpicY1=false;
                                            arregloautos[j].handpicY3=false;
                                            arregloautos[j].speedcounterY1=0;
                                            arregloautos[j].speedX = 0;

                                            if (arregloautos[j].handsolpicY2==false && arregloautos[j].origin!=10) //si esta dentro del area efectiva y no se ha asignado peticion para handoever
                                            {	
                                                handsoliy2 ++; //request for handover
                                                arregloautos[j].handsolpicY2=true;			//se cambia a 1 cuando se hace peticion de handover   
                                                System.out.println("solicitud Y1-Y2 por el carro " + arregloautos[j].getCarro() + " " + arregloautos[j].getCoorX());
                                            }
                                            if (arregloautos[j].handsolpicY2 == true && arregloautos[j].handpicY2==false)   // zona efectiva de asignacion de handover                                     
                                            {              
                                                arregloautos[j].setTiempores();
                                                arregloautos[j].restimetable.add(arregloautos[j].getTiempores());
                                                arregloautos[j].setTravertime(arregloautos[j].getVelocidad(), dres); // to compute handover resolution time (using the first speed value entering in the region and resolution time distance 10 meters
                                                avgHandtime.set(9, avgHandtime.get(9) + arregloautos[j].getTravertime());   // Calculando el total de los tiempos de traversal
                                                arregloautos[j].time20.add("\n" + arregloautos[j].getTraverlist()); // to add it to the list
                                                arregloautos[j].setProbability(0, arregloautos[j].getTravertime());//sacar la probabilidad de error a cada llamda entre en la zona de handover
                                                arregloautos[j].probabilitytable.add(arregloautos[j].getProbability());
                                                System.out.println( " Probabilidad " + arregloautos[j].getProbability() + " " + " Carro " + j );
                                                System.out.println( " Velocidad al entrar a la region de handover " + arregloautos[j].getVelocidad());
                                                System.out.println( " Tiempo que tarda al cruzar la region de handover Y2 " + arregloautos[j].getTravertime());
                                                System.out.println( " Tiempo TOTAL que tarda al cruzar la region de handover Y2 " + arregloautos[j].getTotaltravertime());
                                                
                                                System.out.println( " LA LISTA" + arregloautos[j].time20.toString());
                                                
                                                if (arregloautos[j].getTiempores()>=arregloautos[j].getTravertime())                                            
                                                {
                                                    handtotalerrory2++;                                        
                                                    arregloautos[j].incomingcall=false;
                                                    arregloautos[j].incall=false;
                                                    channelY1--;
                                                    arregloautos[j].restimetable.add(6002);
                                                    arregloautos[j].travertime.clear();
                                                    System.out.println("Error de HO en canalX1 " + "carro " + j + " " + channelX1);
                                                }
                                                else
                                                    if(channelX2==availchannel)
                                                    {
                                                        handtotalouty2++; //outage
                                                        arregloautos[j].incomingcall=false;
                                                        arregloautos[j].incall=false;
                                                        channelY1--;
                                                        arregloautos[j].travertime.clear();
                                                        System.out.println("Llamada Handover caida por canalY2 bloqueado " + "carro " + j + "canalY1 " + channelY1 + " canalY2 " + channelY2);
                                                    }
                                                    else
                                                    {
                                                         arregloautos[j].handpicY2= true;
                                                         arregloautos[j].incomingcall=false;
                                                         arregloautos[j].origin=10;
                                                         channelX2++;
                                                         channelY2++;
                                                         channelY1--;
                                                         totalhandy2++;
                                                         asignedcallsy2++;
                                                         System.out.println("Handover para Y1-Y2 " + "carro " + j + "canalY1 " + channelY1 + " canalX2 " + channelX2 + " canalY2 " + channelY2);
                                                         arregloautos[j].travertime.clear();
                                                         System.out.println( " veces por las que cruza la region de handover Y2 " + totalhandy2);
                                                    }  
                                            }                                                                                                  
                                        }
                                    }
                            }
                            else
                                if ((XY[i][3] >=200 && XY[i][3] <= 380) && (XY[i][2]>= 270 && XY[i][2] <= 290)) // ubicacion de las coordenadas en las picocelda en X 2
                                {
                                    arregloautos[j].handsolpicY3=false;
                                    arregloautos[j].handpicY3=false;
                                    
                                    if (XY[i][2] >=200 && XY[i][2] <= 360)
                                    {
                                        arregloautos[j].speedcounterY2++;
                                        arregloautos[j].setCellspeed(arregloautos[j].speedcounterY2, arregloautos[j].getVelocidad()); // to compute the crossing average speed
                                        arregloautos[j].setCelltime(arregloautos[j].getCellspeed(), D); // to compute the the crossing time (200mt)
                                        System.out.println(" VElocidad en el punto medido " + j + " " + arregloautos[j].getVelocidad());
                                        System.out.println(" Suma de velocidades " + j + " " + arregloautos[j].speedX);
                                        System.out.println(" velocidad promedio en Y2 el coche " + j + " " + arregloautos[j].getCellspeed());
                                        System.out.println(" Tiempo que tarda en cruzar Y2 el coche " + j + " " + arregloautos[j].getCelltime());
                                        System.out.println(" Suma de velocidades " + j + " " + arregloautos[j].speedX);
                                        //System.out.println(" Contador " + j + " " + arregloautos[j].speedcounterX2);

                                    }
                                    if (XY[i][3] >=200 && XY[i][3] <= 360)
                                    {
                                        arregloautos[j].handsolpicY2=false; // resetea la asigancion de handover para ser detectado en la picocelda siguiente
                                        arregloautos[j].handsolpicY3=false;
                                        arregloautos[j].handpicY3=false;
                                        arregloautos[j].handpicY2=false;
                                    }

                                    
                                    if(arregloautos[j].incomingcall==true && arregloautos[j].incall==false) 
                                    {   
                                        if (XY[i][3] >= 200 && XY[i][3] <= 360)
                                        {
                                            if (channelX2<availchannel)
                                            {
                                                arregloautos[j].incomingcall=false;
                                                arregloautos[j].incall=true;
                                                arregloautos[j].setTiempoexp();
                                                arregloautos[j].calltimetable.add(arregloautos[j].getTiempoexp());
                                                arregloautos[j].calltimes=arregloautos[j].getTiempoexp(); //asignar tc a aarreglo de autos
                                                arregloautos[j].origin=10;
                                                //arregloautos[j].handsolpicY2=true;
                                                //arregloautos[j].handpicY2=true; 
                                                channelX2++; //contador de canales.
                                                channelY2++;
                                                asignednewcallsy2++;
                                                System.out.println(" Nueva llamada canaY2 " + "carro " + j + " canalX2 " + channelX2 + " canalY2 " + channelY2);
                                                //arregloautos[j].setTiempores();
                                                //arregloautos[j].restimetable.add(arregloautos[j].getTiempores());
                                                //arregloautos[j].setProbability(0, velocidad[j][1]);//sacar la probabilidad de error a cada llamda entre en la zona de handover
                                                //arregloautos[j].probabilitytable.add(arregloautos[j].getProbability());
                                                //arregloautos[j].calltimetable.add(tc);
                                                //arregloautos[j].calltimes=tc;
                                                                                     
                                                //System.out.println("canales asignados por nueva llamada en Picocelda 2" + " " + j + " " + channelX2);
                                                //System.out.println("Tiempo de generacion de llamada" + " " + arregloautos[j].bettime + " "+ j);
                                                //System.out.println(" Tiempo de llamada" + " " + arregloautos[j].calltimes);

                                            }

                                            else
                                            {
                                                handtotalouty2++;
                                                arregloautos[j].incomingcall=false;
                                                System.out.println("Llamada caida por canalY2 bloqueado " + "carro " + j + " canalX2 " + channelX2 + " canalY2 " + channelY2);
                                            }
                                        }
                                        else 
                                           if(channelY3==availchannel) //nueva llamada en region de handover
                                            {
                                                handtotalouty3++; //outage
                                                arregloautos[j].incomingcall=false;
                                                arregloautos[j].incall=false;
                                                System.out.println("Llamada caida area HO por canalY3 bloqueado " + "carro " + j + " " + channelY3);
                                            }
                                            else
                                            {
                                                 
                                                 arregloautos[j].incall=true;
                                                 arregloautos[j].incomingcall=false;
                                                 arregloautos[j].handsolpicY3=true;
                                                 arregloautos[j].handpicY3= true;
                                                 arregloautos[j].setTiempoexp();
                                                 arregloautos[j].calltimetable.add(arregloautos[j].getTiempoexp());
                                                 arregloautos[j].calltimes=arregloautos[j].getTiempoexp(); //asignar tc a aarreglo de autos
                                                 arregloautos[j].origin=11;
                                                 channelY3++;
                                                 asignednewcallsy3++;
                                                 System.out.println("Nueva llamada area HO en canaY3 " + "carro " + j + " " + channelY3);
                                                 
                                                 //arregloautos[j].setTiempores();
                                                 //arregloautos[j].restimetable.add(arregloautos[j].getTiempores());
                                                 //arregloautos[j].setProbability(0, velocidad[j][1]);//sacar la probabilidad de error a cada llamda entre en la zona de handover
                                                 //arregloautos[j].probabilitytable.add(arregloautos[j].getProbability());
                                                 
                                                 
                                                
                                            }
                                    }
                                    else
                                    {
                                       hiniy = 360; //limite inicial de area de handover
                                       hfiny = 380; //limite final de area de handover

                                       if ((XY[i][3] >=hiniy && XY[i][3] <= hfiny))
                                       {     
                                           arregloautos[j].handpicY2=false;
                                           arregloautos[j].handpicY4=false;
                                           arregloautos[j].speedcounterX2=0;
                                           arregloautos[j].speedX = 0;
                                           
                                           if (arregloautos[j].handsolpicY3==false  && arregloautos[j].origin != 11) //si esta dentro del area efectiva y no se ha asignado peticion para handoever
                                            {	
                                                handsoliy3++;
                                                arregloautos[j].handsolpicY3 =true;			//se cambia a 1 cuando se hace peticion de handover
                                                System.out.println("solicitud Y2-Y3 por el carro " + arregloautos[j].getCarro() + " " + arregloautos[j].getCoorX());
                                            }
                                            if ( arregloautos[j].handsolpicY3 ==true && arregloautos[j].handpicY3==false)   // zona efectiva de asignacion de handover
                                            {              
                                                arregloautos[j].setTiempores();
                                                arregloautos[j].restimetable.add(arregloautos[j].getTiempores());                                                
                                                arregloautos[j].setTravertime(arregloautos[j].getVelocidad(), dres); // to compute handover resolution time (using the first speed value entering in the region and resolution time distance 10 meters                                                
                                                avgHandtime.set(10, avgHandtime.get(10) + arregloautos[j].getTravertime());   // Calculando el total de los tiempos de traversal
                                                System.out.println("JAJAJAJ"+avgHandtime.toString());
                                                arregloautos[j].time20.add("\n" + arregloautos[j].getTraverlist()); // to add it to the list
                                                arregloautos[j].setProbability(0, arregloautos[j].getTravertime());//sacar la probabilidad de error a cada llamda entre en la zona de handover
                                                arregloautos[j].probabilitytable.add(arregloautos[j].getProbability());
                                                System.out.println( " Probabilidad " + arregloautos[j].getProbability() + " " + " Carro " + j );
                                                System.out.println( " Velocidad al entrar a la region de handover " + arregloautos[j].getVelocidad());
                                                System.out.println( " Tiempos que tarda al cruzar la region de handover Y3 " + arregloautos[j].getTravertime());
                                                System.out.println( " Tiempo TOTAL que tarda al cruzar la region de handover Y3 " + arregloautos[j].getTotaltravertime());
                                                
                                                System.out.println( " LA LISTA" + arregloautos[j].time20);
                                                
                                                if (arregloautos[j].getTiempores()>=arregloautos[j].getTravertime())
                                                {
                                                    handtotalerrory3++;
                                                    arregloautos[j].incomingcall=false;
                                                    arregloautos[j].incall=false;
                                                    channelX2--;
                                                    channelY2--;
                                                    arregloautos[j].restimetable.add(7003);
                                                    arregloautos[j].travertime.clear();
                                                    System.out.println("Error de HO en canalY2 " + "carro " + j + " canalX2 " + channelX2 + " canalY2 " + channelY2);
                                                }
                                                else
                                                    if(channelY3==availchannel)
                                                    {
                                                        handtotalouty3++;
                                                        arregloautos[j].incomingcall=false;
                                                        arregloautos[j].incall=false;
                                                        channelX2--;
                                                        channelY2--;
                                                        arregloautos[j].travertime.clear();
                                                        System.out.println("Llamada Handover caida por canalY3 bloqueado " + "carro " + j + "canalX2 " + channelX2 + " canalY2 " + channelY2 + " canalY3 " + channelY3);
                                                    }
                                                    else
                                                    {
                                                         arregloautos[j].incomingcall=false;
                                                         arregloautos[j].handpicY3=true;
                                                         arregloautos[j].origin=11;
                                                         channelY3++;
                                                         channelX2--;
                                                         channelY2--;
                                                         totalhandy3++;
                                                         asignedcallsy3++;
                                                         System.out.println("Handover para Y2-Y3 " + "carro " + j + "canalX2 " + channelX2 + " canalY2 " + channelY2 + " canalY3 " + channelY3);
                                                         arregloautos[j].travertime.clear();
                                                         System.out.println( " veces por las que cruza la region de handover Y3 " + totalhandy3);
                                                    }  
                                            }                                                      				
                                        }
                                    }
                                }
                                else
                                    if ((XY[i][3] >=380 && XY[i][3] <= 560)&& (XY[i][2]>= 270 && XY[i][2] <= 290)) // ubicacion de las coordenadas en las picocelda en X 3
                                    {   
                                        arregloautos[j].handsolpicY4=false;
                                        arregloautos[j].handpicY4=false;
                                        
                                        if (XY[i][3] >=380 && XY[i][3] <= 540)
                                        {
                                            arregloautos[j].handsolpicY4=false; // resetea la asigancion de handover para ser detectado en la picocelda siguiente
                                            arregloautos[j].handsolpicY3=false;
                                            arregloautos[j].handpicY4=false;
                                            arregloautos[j].handpicY3=false;
                                            arregloautos[j].speedcounterY3++;
                                            arregloautos[j].setCellspeed(arregloautos[j].speedcounterY3, arregloautos[j].getVelocidad()); // to compute the crossing average speed
                                            arregloautos[j].setCelltime(arregloautos[j].getCellspeed(), D); // to compute the the crossing time (200mt)

                                            System.out.println(" velocidad promedio en Y3 el coche " + j + " " + arregloautos[j].getCellspeed());
                                            System.out.println(" Tiempo que tarda en cruzar Y3 el coche " + j + " " + arregloautos[j].getCelltime());
                                        }

                                        
                                        if(arregloautos[j].incomingcall==true && arregloautos[j].incall==false)
                                        {
                                            if (XY[i][3] >= 380 && XY[i][3] <= 540)
                                            {
                                                if(channelY3<availchannel)
                                                {
                                                    arregloautos[j].incomingcall=false;
                                                    arregloautos[j].incall=true; //se asigna la llamada
                                                    arregloautos[j].setTiempoexp();
                                                    arregloautos[j].calltimetable.add(arregloautos[j].getTiempoexp());
                                                    arregloautos[j].calltimes=arregloautos[j].getTiempoexp(); //asignar tc a aarreglo de autos
                                                    arregloautos[j].origin=11;
                                                    //arregloautos[j].handsolpicY3=true;
                                                    //arregloautos[j].handpicY3=true; 
                                                    channelY3++; //contador de canales.
                                                    asignednewcallsy3++;
                                                    System.out.println(" Nueva llamada canaY3 " + "carro " + j + " " + channelY3);
                                                    //arregloautos[j].setTiempores();
                                                    //arregloautos[j].restimetable.add(arregloautos[j].getTiempores());
                                                    //arregloautos[j].setProbability(0, velocidad[j][1]);//sacar la probabilidad de error a cada llamda entre en la zona de handover
                                                    //arregloautos[j].probabilitytable.add(arregloautos[j].getProbability());
                                                    //arregloautos[j].calltimetable.add(tc); //agregar el tiempo de llamada al arreglo de lista
                                                    //arregloautos[j].calltimes=tc; //asignar tc a aarreglo de autos
                                                    
                                                } 
                                                else
                                                {
                                                    handtotalouty3++;
                                                    arregloautos[j].incomingcall=false;
                                                    System.out.println("Llamada caida por canalY3 bloqueado " + "carro " + j + " " + channelY3);
                                                }
                                            }
                                            else
                                                if(channelY4==availchannel) //nueva llamada en region de handover
                                                {
                                                    handtotalouty4++; //outage
                                                    arregloautos[j].incomingcall=false;
                                                    arregloautos[j].incall=false;
                                                    System.out.println("Llamada caida area HO por canalY4 bloqueado " + "carro " + j + " " + channelY4);
                                                }
                                                else
                                                {
                                                     
                                                     arregloautos[j].incall=true;
                                                     arregloautos[j].incomingcall=false;
                                                     arregloautos[j].setTiempoexp();
                                                     arregloautos[j].calltimetable.add(arregloautos[j].getTiempoexp());
                                                     arregloautos[j].calltimes=arregloautos[j].getTiempoexp(); //asignar tc a aarreglo de autos
                                                     arregloautos[j].handpicY4= true;
                                                     arregloautos[j].handsolpicY4=true;
                                                     arregloautos[j].origin=12;
                                                     channelY4++;
                                                     asignednewcallsy4++;
                                                     System.out.println("Nueva llamada area HO en canaY4" + "carro " + j + " " + channelY4);
                                                     
                                                     //arregloautos[j].setTiempores();
                                                     //arregloautos[j].restimetable.add(arregloautos[j].getTiempores());
                                                     //arregloautos[j].setProbability(0, velocidad[j][1]);//sacar la probabilidad de error a cada llamda entre en la zona de handover
                                                     //arregloautos[j].probabilitytable.add(arregloautos[j].getProbability());
                                                     
                                                     
                                                    
                                                }
                                        }
                                        else
                                        {
                                                hiniy = 540; //limite inicial de area de handover
                                                hfiny = 560; 

                                                if (XY[i][3]>=540)
                                                {                                                                  
                                                    if ((XY[i][3] >=hiniy && XY[i][3] <= hfiny)) //tr[j] // se cmpara contra el tiempo de transito de celda o con el tiempo generado exponencialmente
                                                    {                                                                                      
                                                        arregloautos[j].handpicY3=false;
                                                        arregloautos[j].speedcounterY3=0;
                                                        arregloautos[j].speedX = 0;
                                                        if (arregloautos[j].handsolpicY4==false && arregloautos[j].origin!=12) //si esta dentro del area efectiva y no se ha asignado peticion para handoever
                                                            {	
                                                                handsoliy4 ++; //request for handover
                                                                arregloautos[j].handsolpicY4=true;			//se cambia a 1 cuando se hace peticion de handover
                                                                System.out.println("solicitud Y3-Y4 por el carro " + arregloautos[j].getCarro() + " " + arregloautos[j].getCoorX());
                                                            }
                                                            if (arregloautos[j].handsolpicY4 == true && arregloautos[j].handpicY4==false)   // zona efectiva de asignacion de handover                                     
                                                            {     
                                                                arregloautos[j].setTiempores();
                                                                arregloautos[j].restimetable.add(arregloautos[j].getTiempores());
                                                                arregloautos[j].setTravertime(arregloautos[j].getVelocidad(), dres);
                                                                avgHandtime.set(11, avgHandtime.get(11) + arregloautos[j].getTravertime());   // Calculando el total de los tiempos de traversal
                                                                arregloautos[j].time20.add("\n" + arregloautos[j].getTraverlist());
                                                                arregloautos[j].setProbability(0, arregloautos[j].getTravertime());//sacar la probabilidad de error a cada llamda entre en la zona de handover
                                                                arregloautos[j].probabilitytable.add(arregloautos[j].getProbability());
                                                                System.out.println( " Probabilidad " + arregloautos[j].getProbability() + " " + " Carro " + j );
                                                                System.out.println( " Velocidad al entrar a la region de handover Y4 " + arregloautos[j].getVelocidad());
                                                                System.out.println( " Tiempo que tarda en la region de handover Y4 " + arregloautos[j].getTravertime());
                                                                System.out.println( " Tiempo TOTAL que tarda al cruzar la region de handover Y4 " + arregloautos[j].getTotaltravertime());
                                                                
                                                                System.out.println( " LA LISTA" + arregloautos[j].time20);
                                                                
                                                                if (arregloautos[j].getTiempores()>=arregloautos[j].getTravertime())                                            
                                                                {
                                                                    handtotalerrory4++;
                                                                    arregloautos[j].incomingcall=false;
                                                                    arregloautos[j].incall=false;
                                                                    channelY3--;
                                                                    arregloautos[j].restimetable.add(8004);
                                                                    arregloautos[j].travertime.clear();
                                                                    System.out.println("Error de HO en canalY3 " + "carro " + j + " " + channelY3);
                                                                }
                                                                else
                                                                    if(channelY4==availchannel)   
                                                                    {
                                                                        handtotalouty4++; //outage
                                                                        arregloautos[j].incomingcall=false;
                                                                        arregloautos[j].incall=false;
                                                                        channelY3--;
                                                                        arregloautos[j].travertime.clear();
                                                                        System.out.println("Llamada Handover caida por canalY4 bloqueado " + "carro " + j + "canalY3 " + channelY3 + " canalY4 " + channelY4);
                                                                    }
                                                                    else
                                                                    {
                                                                         arregloautos[j].handpicY4= true;
                                                                         arregloautos[j].incomingcall=false;
                                                                         arregloautos[j].origin=12;
                                                                         channelY4++;
                                                                         channelY3--;
                                                                         totalhandy4++;
                                                                         asignedcallsy4++;
                                                                         System.out.println("Handover para Y3-Y4" + "carro " + j + "canalY3 " + channelY3 + " canalY4 " + channelY4);
                                                                         arregloautos[j].travertime.clear();
                                                                         System.out.println( " veces por las que cruza la region de handover Y4 " + totalhandy4);
                                                                    }  
                                                            }                                    
                                                        }
                                                }
                                        }
                                        }
                                    }
                 else if
                    (i>autos-1 && XY[i][3]-XY[i-autos][3]<0 && i>=autos)// && (arregloautos[j].incomingcall==true || arregloautos[j].incall==true)) // left to rigth
                    {
                        
                        if ((XY[i][3] >= 360 && XY[i][3] <= 560) && (XY[i][2]>= 270 && XY[i][2] <= 290)) // ubicacion de las coordenadas en las picocelda 1 en X
                        {
                            arregloautos[j].handsolpicY4=false;
                            arregloautos[j].handpicY4=false;
                            
                            if (XY[i][3] >= 380 && XY[i][3] <= 540)
                            {
                                arregloautos[j].handsolpicY4=false; // resetea la asigancion de handover para ser detectado en la picocelda siguiente
                                arregloautos[j].handsolpicY3=false;
                                arregloautos[j].handpicY4=false;
                                arregloautos[j].handpicY3=false;
                                arregloautos[j].speedcounterY3++; // to count times that loop enters in
                                arregloautos[j].setCellspeed(arregloautos[j].speedcounterY3, arregloautos[j].getVelocidad()); // to compute the crossing average speed
                                arregloautos[j].setCelltime(arregloautos[j].getCellspeed(), D); // to compute the the crossing time (200mt)
                                System.out.println(" velocidad promedio en X3 el coche " + j + " " + arregloautos[j].getCellspeed());
                                System.out.println(" Tiempo que tarda en cruzar X3 el coche " + j + " " + arregloautos[j].getCelltime());
                            }

                            
                            if(arregloautos[j].incomingcall==true && arregloautos[j].incall==false) // nueva llamada
                            {
                                if (XY[i][3] >= 380 && XY[i][3] <= 560)
                                {
                                    if (channelY3<availchannel)
                                    {
                                        arregloautos[j].incomingcall=false;
                                        arregloautos[j].incall=true; //se asigna la llamada
                                        arregloautos[j].setTiempoexp();
                                        arregloautos[j].calltimetable.add(arregloautos[j].getTiempoexp());
                                        arregloautos[j].calltimes=arregloautos[j].getTiempoexp(); //asignar tc a aarreglo de autos
                                        arregloautos[j].origin=13;
                                        arregloautos[j].handsolpicY4=true;
                                        arregloautos[j].handpicY4=true; 
                                        channelY3++; //contador de canales.   
                                        asignednewcallsy3++;
                                        System.out.println("Nueva llamada canaY3 " + "carro " + j + " " + channelY3);
                                        //arregloautos[j].setTiempores();
                                        //arregloautos[j].restimetable.add(arregloautos[j].getTiempores());
                                        //arregloautos[j].setProbability(0, velocidad[j][1]);//sacar la probabilidad de error a cada llamda entre en la zona de handover
                                        //arregloautos[j].probabilitytable.add(arregloautos[j].getProbability());
                                        
                                        
                                    }  
                                    else
                                    {
                                        handtotalouty3++;
                                        arregloautos[j].incomingcall=false;
                                        System.out.println("Llamada caida por canalY3 bloqueado " + "carro " + j + " " + channelY3);
                                    }
                                }
                                else 
                                   if(channelX2==availchannel)
                                    {
                                        handtotalouty2++; //outage
                                        arregloautos[j].incomingcall=false;
                                        arregloautos[j].incall=false;
                                        System.out.println("Llamada caida area HO por canalY2 bloqueado " + "carro " + j + "canalX2 " + channelX2 + "canalY2 " + channelY2);
                                    }
                                    else
                                    {
                                         
                                         arregloautos[j].incall=true;
                                         arregloautos[j].setTiempoexp();
                                         arregloautos[j].calltimetable.add(arregloautos[j].getTiempoexp());
                                         arregloautos[j].calltimes=arregloautos[j].getTiempoexp(); //asignar tc a aarreglo de autos
                                         arregloautos[j].incomingcall=false;
                                         arregloautos[j].origin=14;
                                         arregloautos[j].handsolpicY3=true;
                                         arregloautos[j].handpicY3= true;
                                         channelX2++;
                                         channelY2++;
                                         asignednewcallsy2++;
                                         System.out.println("Nueva llamada area HO en canaY2" + "carro " + j + " " + channelX2 + " " + channelY2);
                                         //arregloautos[j].setTiempores();
                                         //arregloautos[j].restimetable.add(arregloautos[j].getTiempores());
                                         //arregloautos[j].setProbability(0, velocidad[j][1]);//sacar la probabilidad de error a cada llamda entre en la zona de handover
                                         //arregloautos[j].probabilitytable.add(arregloautos[j].getProbability());
                                         //arregloautos[j].calltimetable.add(tc); //agregar el tiempo de llamada al arreglo de lista
                                         //arregloautos[j].calltimes=tc; //asignar tc a aarreglo de autos
                                         
                                        
                                    }
                            }
                            else
                                                         
                                if (XY[i][3]>=540)
                                {                    
                                    hiniy = 540; //limite inicial de area de handover
                                    hfiny= 560;
                                    
                                    if ((XY[i][3] >=hiniy && XY[i][3] <= hfiny)) //tr[j] // se cmpara contra el tiempo de transito de celda o con el tiempo generado exponencialmente
                                    {                                      
                                        arregloautos[j].handpicY3=false;
                                        //arregloautos[j].handpicX4=false;

                                        if (arregloautos[j].handsolpicY4==false && arregloautos[j].origin!=13) //si esta dentro del area efectiva y no se ha asignado peticion para handoever
                                        {	
                                            handsoliy5 ++; //request for handover
                                            arregloautos[j].handsolpicY4=true;			//se cambia a 1 cuando se hace peticion de handover 
                                            System.out.println("solicitud Y4-Y3 por el carro " + arregloautos[j].getCarro() + " " + arregloautos[j].getCoorX());
                                        
                                        }
                                        if (arregloautos[j].handsolpicY4 == true && arregloautos[j].handpicY4==false)   // zona efectiva de asignacion de handover                                     
                                        {              
                                            arregloautos[j].setTiempores();
                                            arregloautos[j].restimetable.add(arregloautos[j].getTiempores());
                                            arregloautos[j].setTravertime(arregloautos[j].getVelocidad(), dres);
                                            avgHandtime.set(12, avgHandtime.get(12) + arregloautos[j].getTravertime());   // Calculando el total de los tiempos de traversal
                                            arregloautos[j].time20.add("\n" + arregloautos[j].getTraverlist());
                                            arregloautos[j].setProbability(0, arregloautos[j].getTravertime());//sacar la probabilidad de error a cada llamda entre en la zona de handover
                                            arregloautos[j].probabilitytable.add(arregloautos[j].getProbability());
                                            System.out.println( " Probabilidad " + arregloautos[j].getProbability() + " " + " Carro " + j );
                                            System.out.println( " Velocidad al entrar a la region de handover Y4 " + arregloautos[j].getVelocidad());
                                            System.out.println( " Tiempo que tarda al cruzar la region de handover Y4 " + arregloautos[j].getTravertime());
                                            System.out.println( " Tiempo TOTAL que tarda al cruzar la region de handover Y4 " + arregloautos[j].getTotaltravertime());
                                            
                                            System.out.println( " LA LISTA" + arregloautos[j].time20);
                                            
                                            if (arregloautos[j].getTiempores()>=arregloautos[j].getTravertime())                                            
                                            {
                                                handtotalerrory3++;                                        
                                                arregloautos[j].incomingcall=false;
                                                arregloautos[j].incall=false;
                                                channelY4--;
                                                arregloautos[j].restimetable.add(-8004);
                                                arregloautos[j].travertime.clear();
                                                System.out.println("Error de HO en canalY4 " + "carro " + j + " " + channelY4);
                                            }
                                            else
                                                if(channelY3==availchannel)
                                                {
                                                    handtotalouty3++; //outage
                                                    arregloautos[j].incomingcall=false;
                                                    arregloautos[j].incall=false;
                                                    channelY4--;
                                                    arregloautos[j].travertime.clear();
                                                    System.out.println("Llamada Handover caida por canalY3 bloqueado " + "carro " + j + "canalY3 " + channelY3 + " canalX3 " + channelX3);
                                                }
                                                else
                                                {
                                                     arregloautos[j].handpicY4= true;
                                                     arregloautos[j].incomingcall=false;                                                     
                                                     arregloautos[j].origin=13;
                                                     channelY3++;
                                                     channelY4--;
                                                     totalhandy5++;
                                                     asignedcallsy3++;
                                                     System.out.println("Handover para Y4-Y3 " + "carro " + j + "canalY4 " + channelY4 + " canalY3 " + channelY3);
                                                     arregloautos[j].travertime.clear();
                                                     System.out.println( " veces por las que cruza la region de handover Y4 " +totalhandy5);
                                                }  
                                        }                                                                                                                                
                                    }
                                }
                                else 
                                {
                                    hiniy = 360; //limite inicial de area de handover
                                    hfiny= 380; //limite final de area de handover

                                    // El auto se encuentra en area de handover y el tiempo del recorrido es menor que el tiempo que durara la llamada
                                    if ((XY[i][3] >=hiniy && XY[i][3] <= hfiny)) //tr[j] // se cmpara contra el tiempo de transito de celda o con el tiempo generado exponencialmente
                                    {     
                                        arregloautos[j].handpicY2=false;
                                        arregloautos[j].handpicY4=false;
                                        arregloautos[j].speedcounterY3=0;
                                        arregloautos[j].speedX = 0;

                                        if (arregloautos[j].handsolpicY3==false && arregloautos[j].origin!=14) //si esta dentro del area efectiva y no se ha asignado peticion para handoever
                                        {	
                                            handsoliy6 ++; //request for handover
                                            arregloautos[j].handsolpicY3=true;			//se cambia a 1 cuando se hace peticion de handover
                                            System.out.println("solicitud Y3-Y2 por el carro " + arregloautos[j].getCarro() + " " + arregloautos[j].getCoorX());
                                        }
                                        if (arregloautos[j].handsolpicY3 == true && arregloautos[j].handpicY3==false)   // zona efectiva de asignacion de handover                                     
                                        {              
                                            arregloautos[j].setTiempores();
                                            arregloautos[j].restimetable.add(arregloautos[j].getTiempores());
                                            arregloautos[j].setTravertime(arregloautos[j].getVelocidad(), dres);
                                            avgHandtime.set(13, avgHandtime.get(13) + arregloautos[j].getTravertime());   // Calculando el total de los tiempos de traversal
                                            arregloautos[j].time20.add("\n" + arregloautos[j].getTraverlist()); // to add it to the list
                                            arregloautos[j].setProbability(0, arregloautos[j].getTravertime());//sacar la probabilidad de error a cada llamda entre en la zona de handover
                                            arregloautos[j].probabilitytable.add(arregloautos[j].getProbability());
                                            System.out.println( " Probabilidad " + arregloautos[j].getProbability() + " " + " Carro " + j );
                                            System.out.println( " Velocidad al entrar a la region de handover Y3 " + arregloautos[j].getVelocidad());
                                            System.out.println( " Tiempo que tarda al cruzar la region de handover Y3 " + arregloautos[j].getTravertime());
                                            System.out.println( " Tiempo TOTAL que tarda al cruzar la region de handover Y3 " + arregloautos[j].getTotaltravertime());
                                            
                                            System.out.println( " LA LISTA" + arregloautos[j].time20);
                                            
                                            if (arregloautos[j].getTiempores()>=arregloautos[j].getTravertime())                                            
                                            {
                                                handtotalerrory2++;                                        
                                                arregloautos[j].incomingcall=false;
                                                arregloautos[j].incall=false;
                                                channelY3--;
                                                arregloautos[j].restimetable.add(-7002);
                                                arregloautos[j].travertime.clear();
                                                System.out.println("Error de HO en canalY3 " + "carro " + j + " " + channelY3);
                                            }
                                            else
                                                if(channelX2==availchannel)
                                                {
                                                    handtotalouty2++; //outage
                                                    arregloautos[j].incomingcall=false;
                                                    arregloautos[j].incall=false;
                                                    channelY3--;
                                                    arregloautos[j].travertime.clear();
                                                    System.out.println("Llamada Handover caida por canalX2 bloqueado " + "carro " + j + "canalY3 " + channelY3 + " canalY2 " + channelY2);
                                                }
                                                else
                                                {
                                                     arregloautos[j].handpicY3= true;
                                                     arregloautos[j].incomingcall=false;
                                                     arregloautos[j].origin=14;
                                                     channelX2++;
                                                     channelY2++;
                                                     channelY3--;
                                                     totalhandy6++;
                                                     asignedcallsy2++;
                                                     System.out.println("Handover para Y3-Y2" + "carro " + j + "canalY3 " + channelY3 + " canalY2 " + channelY2 + " canalX2 " + channelX2);
                                                     arregloautos[j].travertime.clear();
                                                     System.out.println( " veces por las que cruza la region de handover Y3 " + totalhandy6);
                                                }  
                                        }                                                                                                  
                                    }
                                }
                        }
                        else
                            if ((XY[i][3] >=180 && XY[i][3] <= 360) && (XY[i][2]>= 270 && XY[i][2] <= 290)) // ubicacion de las coordenadas en las picocelda en X 2
                            {
                                arregloautos[j].handsolpicY2=false;
                                arregloautos[j].handpicY2=false;
                                
                                if (XY[i][2] >=200 && XY[i][2] <= 360)
                                {
                                    arregloautos[j].speedcounterY2++;
                                    arregloautos[j].setCellspeed(arregloautos[j].speedcounterY2, arregloautos[j].getVelocidad()); // to compute the crossing average speed
                                    arregloautos[j].setCelltime(arregloautos[j].getCellspeed(), D); // to compute the the crossing time (200mt)
                                    System.out.println(" velocidad promedio en Y2 el coche " + j + " " + arregloautos[j].getCellspeed());
                                    System.out.println(" Tiempo que tarda en cruzar Y2 el coche " + j + " " + arregloautos[j].getCelltime());
                                }
                                
                                if (XY[i][3] >= 200 && XY[i][3] <= 360)
                                {
                                    arregloautos[j].handsolpicY2=false; // resetea la asigancion de handover para ser detectado en la picocelda siguiente
                                    arregloautos[j].handsolpicY3=false;
                                    arregloautos[j].handpicY2=false;
                                    arregloautos[j].handpicY3=false;
                                }

                                if(arregloautos[j].incomingcall==true && arregloautos[j].incall==false)
                                {
                                    if (XY[i][3] >=200 && XY[i][3] <= 360)
                                    {
                                        if (channelX2<availchannel)
                                        {
                                            arregloautos[j].incomingcall=false;
                                            arregloautos[j].incall=true;
                                            arregloautos[j].setTiempoexp();
                                            arregloautos[j].calltimetable.add(arregloautos[j].getTiempoexp());
                                            arregloautos[j].calltimes=arregloautos[j].getTiempoexp(); //asignar tc a aarreglo de autos
                                            //arregloautos[j].handsolpicY2=true;
                                            //arregloautos[j].handpicY2=true; 
                                            arregloautos[j].origin=14;
                                            channelX2++; //contador de canales.
                                            channelY2++;
                                            asignednewcallsy2++;
                                            System.out.println(" Nueva llamada canay2" + "carro " + j + " canalX2 " + channelX2 + " canalY2 " + channelY2);
                                            
                                            
                                            //arregloautos[j].setTiempores();
                                            //arregloautos[j].restimetable.add(arregloautos[j].getTiempores());
                                            //arregloautos[j].setProbability(0, velocidad[j][1]);//sacar la probabilidad de error a cada llamda entre en la zona de handover
                                            //arregloautos[j].probabilitytable.add(arregloautos[j].getProbability());
                                            
                                                                               
                                           
                                        }
                                        else
                                        {
                                            handtotalouty2++;
                                            arregloautos[j].incomingcall=false;
                                            System.out.println("Llamada caida por canalY2 bloqueado " + "carro " + j + " canalX2 " + channelX2 + " canalY2 " + channelY2);
                                        }
                                    }
                                    else 
                                        if(channelY1==availchannel)
                                        {
                                            handtotalouty1++; //outage
                                            arregloautos[j].incomingcall=false;
                                            arregloautos[j].incall=false;
                                            System.out.println("Llamada caida area HO por canalY1 bloqueado " + "carro " + j + " " + channelY1);
                                        }
                                        else
                                        {
                                             arregloautos[j].incall=true;
                                             arregloautos[j].setTiempoexp();
                                             arregloautos[j].calltimetable.add(arregloautos[j].getTiempoexp());
                                             arregloautos[j].calltimes=arregloautos[j].getTiempoexp(); //asignar tc a aarreglo de autos
                                             arregloautos[j].incomingcall=false;
                                             arregloautos[j].handpicY2= true;
                                             arregloautos[j].handsolpicY2=true;
                                             arregloautos[j].origin=15;
                                             channelY1++;
                                             asignednewcallsy1++;
                                             System.out.println("Nueva llamada area HO en canaY1" + "carro " + j + " " + channelY1);
                                             //arregloautos[j].setTiempores();
                                             //arregloautos[j].restimetable.add(arregloautos[j].getTiempores());
                                             //arregloautos[j].setProbability(0, velocidad[j][1]);//sacar la probabilidad de error a cada llamda entre en la zona de handover
                                             //arregloautos[j].probabilitytable.add(arregloautos[j].getProbability());
                                             
                                             
                                           
                                        }
                                }
                                else
                                {   
                                   hiniy = 180; //limite inicial de area de handover
                                   hfiny = 200; //limite final de area de handover

                                   if ((XY[i][3] >=hiniy && XY[i][3] <= hfiny))
                                   {     
                                       arregloautos[j].handpicY1=false;
                                       arregloautos[j].handpicY3=false;
                                       arregloautos[j].speedcounterY2=0;
                                       arregloautos[j].speedX = 0;
                                       
                                       if (arregloautos[j].handsolpicY2==false && arregloautos[j].origin!=15) //si esta dentro del area efectiva y no se ha asignado peticion para handoever
                                        {	
                                            handsoliy7++;
                                            arregloautos[j].handsolpicY2 =true;			//se cambia a 1 cuando se hace peticion de handover
                                            System.out.println("solicitud Y2-Y1 por el carro " + arregloautos[j].getCarro() + " " + arregloautos[j].getCoorX());
                                        }
                                        if ( arregloautos[j].handsolpicY2 ==true && arregloautos[j].handpicY2==false)   // zona efectiva de asignacion de handover
                                        {              
                                            arregloautos[j].setTiempores();
                                            arregloautos[j].restimetable.add(arregloautos[j].getTiempores());
                                            arregloautos[j].setTravertime(arregloautos[j].getVelocidad(), dres); // to compute handover resolution time (using the first speed value entering in the region and resolution time distance 10 meters
                                            avgHandtime.set(14, avgHandtime.get(14) + arregloautos[j].getTravertime());   // Calculando el total de los tiempos de traversal
                                            arregloautos[j].time20.add("\n" + arregloautos[j].getTraverlist()); // to add it to the list
                                            arregloautos[j].setProbability(0, arregloautos[j].getTravertime());//sacar la probabilidad de error a cada llamda entre en la zona de handover
                                            arregloautos[j].probabilitytable.add(arregloautos[j].getProbability());
                                            System.out.println( " Probabilidad " + arregloautos[j].getProbability() + " " + " Carro " + j );
                                            System.out.println( " Velocidad al entrar a la region de handover Y2 " + arregloautos[j].getVelocidad());
                                            System.out.println( " Tiempos que tarda al cruzar la region de handover Y2 " + arregloautos[j].getTravertime());
                                            System.out.println( " Tiempo TOTAL que tarda al cruzar la region de handover Y2 " + arregloautos[j].getTotaltravertime());
                                            
                                            System.out.println( " LA LISTA" + arregloautos[j].time20); 
                                            
                                            if (arregloautos[j].getTiempores()>=arregloautos[j].getTravertime())
                                            {
                                                handtotalerrory1++;
                                                arregloautos[j].incomingcall=false;
                                                arregloautos[j].incall=false;
                                                channelX2--;
                                                channelY2--;
                                                arregloautos[j].restimetable.add(-6001);
                                                arregloautos[j].travertime.clear();
                                                System.out.println("Error de HO en canalY2 " + "carro " + j + " canalX2 " + channelX2 + " canalY2 " + channelY2);
                                            }
                                            
                                            else
                                                
                                                if(channelY1==availchannel)
                                                {
                                                    handtotalouty1++;
                                                    arregloautos[j].incomingcall=false;
                                                    arregloautos[j].incall=false;
                                                    channelX2--;
                                                    channelY2--;
                                                    arregloautos[j].travertime.clear();
                                                    System.out.println("Llamada Handover caida por canalY1 bloqueado " + "carro " + j + "canalY1 " + channelY1 + " canalY2 " + channelY2 + " canalX2 " + channelX2);
                                                }
                                                else                                            
                                                    {
                                                     arregloautos[j].handpicY2=true;
                                                     arregloautos[j].incomingcall=false;
                                                     arregloautos[j].origin=15;
                                                     channelY1++;
                                                     channelX2--;
                                                     channelY2--;
                                                     totalhandy7++;
                                                     asignedcallsy1++;
                                                     System.out.println("Handover para Y2-Y1" + "carro " + j + "canalY1 " + channelY1 + " canalX2 " + channelX2 + " canalY2 " + channelY2);
                                                     arregloautos[j].travertime.clear();
                                                     System.out.println( " veces por las que cruza la region de handover Y2 " + totalhandy7);
                                                    }
                                                                                                       
                                                    
                                                 
                                        }                                                      				
                                    }
                                }
                            }
                            else
                                if ((XY[i][3] >=0 && XY[i][3] <= 180)&& (XY[i][2]>= 270 && XY[i][2] <= 290)) // ubicacion de las coordenadas en las picocelda en X 3
                                {   
                                    arregloautos[j].handsolpicY1=false;
                                    arregloautos[j].handpicY1=false;
                                    
                                    if (XY[i][3] >= 20 && XY[i][3] <= 180)
                                    {
                                        arregloautos[j].handsolpicY2=false; // resetea la asigancion de handover para ser detectado en la picocelda siguiente
                                        arregloautos[j].handsolpicY1=false;
                                        arregloautos[j].handpicY2=false;
                                        arregloautos[j].handpicY1=false;
                                        arregloautos[j].speedcounterY1++;
                                        arregloautos[j].setCellspeed(arregloautos[j].speedcounterY1, arregloautos[j].getVelocidad()); // to compute the crossing average speed
                                        arregloautos[j].setCelltime(arregloautos[j].getCellspeed(), D); // to compute the the crossing time (200mt)
                                        System.out.println(" velocidad promedio en Y1 el coche " + j + " " + arregloautos[j].getCellspeed());
                                        System.out.println(" Tiempo que tarda en cruzar Y1 el coche " + j + " " + arregloautos[j].getCelltime());
                                    }

                                    if(arregloautos[j].incomingcall==true && arregloautos[j].incall==false)
                                    
                                        if (XY[i][3] >=20 && XY[i][3] <= 180)
                                        {
                                            if(channelY1<availchannel)

                                            {
                                                arregloautos[j].incomingcall=false;
                                                arregloautos[j].incall=true; //se asigna la llamada
                                                arregloautos[j].setTiempoexp();
                                                arregloautos[j].calltimetable.add(arregloautos[j].getTiempoexp());
                                                arregloautos[j].calltimes=arregloautos[j].getTiempoexp(); //asignar tc a aarreglo de autos
                                                arregloautos[j].origin=15;
                                                //arregloautos[j].handsolpicY1=true;
                                                //arregloautos[j].handpicY1=true; 
                                                channelY1++; //contador de canales.
                                                asignednewcallsy1++;
                                                System.out.println(" Nueva llamada canaY1" + "carro " + j + " " + channelY1);
                                                //arregloautos[j].setTiempores();
                                                //arregloautos[j].restimetable.add(arregloautos[j].getTiempores());
                                                //arregloautos[j].setProbability(0, velocidad[j][1]);//sacar la probabilidad de error a cada llamda entre en la zona de handover
                                                //arregloautos[j].probabilitytable.add(arregloautos[j].getProbability());
                                                
                                                 
                                                
                                            } 
                                            else
                                            {
                                                handtotalouty1++;
                                                arregloautos[j].incomingcall=false;
                                                System.out.println("Llamada caida por canalY1 bloqueado " + "carro " + j + " " + channelY1);
                                            }
                                        }
                                    
                                        else
                                        {  
                                            if(channelY0==availchannel)
                                            {
                                                handtotalouty0++; //outage
                                                arregloautos[j].incomingcall=false;
                                                arregloautos[j].incall=false;
                                                System.out.println("Llamada caida area HO por canalY0 bloqueado " + "carro " + j + " " + channelY0);
                                            }
                                            else
                                            {
                                                 arregloautos[j].incall=true;
                                                 arregloautos[j].setTiempoexp();
                                                 arregloautos[j].calltimetable.add(arregloautos[j].getTiempoexp());
                                                 arregloautos[j].calltimes=arregloautos[j].getTiempoexp(); //asignar tc a aarreglo de autos
                                                 arregloautos[j].incomingcall=false;                                     
                                                 arregloautos[j].origin=8;
                                                 arregloautos[j].handsolpicY1=true;
                                                 arregloautos[j].handpicY1= true;
                                                 channelY0++;
                                                 asignednewcallsy0++;
                                                 System.out.println("Nueva llamada area HO en canaY0" + "carro " + j + " " + channelY0);
                                                 
                                                 //arregloautos[j].setTiempores();
                                                 //arregloautos[j].restimetable.add(arregloautos[j].getTiempores());
                                                 //arregloautos[j].setProbability(0, velocidad[j][1]);//sacar la probabilidad de error a cada llamda entre en la zona de handover
                                                 //arregloautos[j].probabilitytable.add(arregloautos[j].getProbability());
                                                 //arregloautos[j].calltimetable.add(tc); //agregar el tiempo de llamada al arreglo de lista
                                                 //arregloautos[j].calltimes=tc; //asignar tc a aarreglo de autos                                 
                                                 
                                               
                                            }
                                        }
                                        else                                                                                       
                                            if (XY[i][3]<=20)
                                            {
                                                hiniy = 0; //limite inicial de area de handover
                                                hfiny = 20; 
                                                
                                                if ((XY[i][3] >=hiniy && XY[i][3] <= hfiny)) //tr[j] // se cmpara contra el tiempo de transito de celda o con el tiempo generado exponencialmente
                                                {                                                                                      
                                                    arregloautos[j].handpicY2=false;
                                                    arregloautos[j].speedcounterY1=0;
                                                    arregloautos[j].speedX = 0;
                                                    
                                                    if (arregloautos[j].handsolpicY1==false && arregloautos[j].origin!=8) //si esta dentro del area efectiva y no se ha asignado peticion para handoever
                                                        {	
                                                            handsoliy8++; //request for handover
                                                            arregloautos[j].handsolpicY1=true;			//se cambia a 1 cuando se hace peticion de handover   
                                                            System.out.println("solicitud Y1-Y0 por el carro " + arregloautos[j].getCarro() + " " + arregloautos[j].getCoorX());
                                                        }
                                                        if (arregloautos[j].handsolpicY1 == true && arregloautos[j].handpicY1==false)   // zona efectiva de asignacion de handover                                     
                                                        {     
                                                            arregloautos[j].setTiempores();
                                                            arregloautos[j].restimetable.add(arregloautos[j].getTiempores());
                                                            arregloautos[j].setTravertime(arregloautos[j].getVelocidad(), dres); // to compute handover resolution time (using the first speed value entering in the region and resolution time distance 10 meters
                                                            avgHandtime.set(15, avgHandtime.get(15) + arregloautos[j].getTravertime());   // Calculando el total de los tiempos de traversal
                                                            arregloautos[j].time20.add("\n" + arregloautos[j].getTraverlist()); // to add it to the list
                                                            arregloautos[j].setProbability(0, arregloautos[j].getTravertime());//sacar la probabilidad de error a cada llamda entre en la zona de handover
                                                            arregloautos[j].probabilitytable.add(arregloautos[j].getProbability());
                                                            System.out.println( " Probabilidad " + arregloautos[j].getProbability() + " " + " Carro " + j );
                                                            System.out.println( " Velocidad al entrar a la region de handover Y1 " + arregloautos[j].getVelocidad());
                                                            System.out.println( " Tiempos que tarda al cruzar la region de handover Y1 " + arregloautos[j].getTravertime());
                                                            System.out.println( " Tiempo TOTAL que tarda al cruzar la region de handover Y1 " + arregloautos[j].getTotaltravertime());
                                                            
                                                            System.out.println( " LA LISTA" + arregloautos[j].time20); 
                                                            
                                                            
                                                            if (arregloautos[j].getTiempores()>=arregloautos[j].getTravertime())                                            
                                                            {
                                                                handtotalerrory0++;
                                                                arregloautos[j].incomingcall=false;
                                                                arregloautos[j].incall=false;
                                                                channelY1--;
                                                                arregloautos[j].restimetable.add(-1000);
                                                                arregloautos[j].travertime.clear();
                                                                System.out.println("Error de HO en canalY1 " + "carro " + j + " " + channelY1);
                                                            }
                                                            else
                                                                if(channelY0==availchannel)   
                                                                {
                                                                    handtotalouty0++; //outage
                                                                    arregloautos[j].incomingcall=false;
                                                                    arregloautos[j].incall=false;
                                                                    channelY1--;
                                                                    arregloautos[j].travertime.clear();
                                                                    System.out.println("Llamada Handover caida por canalY0 bloqueado " + "carro " + j + "canalY0 " + channelY0 + " canalY1 " + channelY1);
                                                                }
                                                                else
                                                                {
                                                                     arregloautos[j].handpicY1= true;
                                                                     arregloautos[j].incomingcall=false;
                                                                     arregloautos[j].origin=8;
                                                                     channelY0++;
                                                                     channelY1--;
                                                                     totalhandy8++;
                                                                     asignedcallsy0++;
                                                                     arregloautos[j].travertime.clear();
                                                                     System.out.println("Handover para Y1-Y0" + "carro " + j + "canalY0 " + channelY0 + " canalY1 " + channelY1);
                                                                     
                                                                     System.out.println( " veces por las que cruza la region de handover Y1 " + totalhandy8);
                                                                }  
                                                        }                                    
                                                }
                                            }
                                    }
                                }
                                else
                                arregloautos[j].incomingcall=false;
                    }
             if (channelX0<0)
                 System.out.println("salida " + "canalX0" + " " + channelX0 + " " + "carro" + " " + XY[i][0] + " "+ XY[i][1] + " "+ XY[i][2]+ " "+ XY[i][3] + " " + arregloautos[j].handpicX0 + " " + arregloautos[j].handsolpicX0 + " " + arregloautos[j].incall + " " + arregloautos[j].incomingcall);
             if (channelX1<0)
                 System.out.println("salida " + "canalX1" + " " + channelX1 + " " + "carro" + " " + XY[i][0] + " "+ XY[i][1] + " "+ XY[i][2]+ " "+ XY[i][3] + " " + arregloautos[j].handpicX1 + " " + arregloautos[j].handsolpicX1 + " " + arregloautos[j].incall + " " + arregloautos[j].incomingcall);
             if (channelX2<0)
                 System.out.println("salida " + "canalX2" + " " + channelX2 + " " + "carro" + " " + XY[i][0] + " "+ XY[i][1] + " "+ XY[i][2]+ " "+ XY[i][3] + " " + arregloautos[j].handpicX2 + " " + arregloautos[j].handsolpicX2 + " " + arregloautos[j].incall + " " + arregloautos[j].incomingcall);    
             if (channelX3<0)
                 System.out.println("salida " + "canalX3" + " " + channelX3 + " " + "carro" + " " + XY[i][0] + " "+ XY[i][1] + " "+ XY[i][2]+ " "+ XY[i][3] + " " + arregloautos[j].handpicX3 + " " + arregloautos[j].handsolpicX3 + " " + arregloautos[j].incall + " " + arregloautos[j].incomingcall);
             if (channelX4<0)
                 System.out.println("salida " + "canalX4" + " " + channelX4 + " " + "carro" + " " + XY[i][0] + " "+ XY[i][1] + " "+ XY[i][2]+ " "+ XY[i][3] + " " + arregloautos[j].handpicX4 + " " + arregloautos[j].handsolpicX4 + " " + arregloautos[j].incall + " " + arregloautos[j].incomingcall);
             if (channelY0<0)
                 System.out.println("salida " + "canalY0" + " " + channelY0 + " " + "carro" + " " + XY[i][0] + " "+ XY[i][1] + " "+ XY[i][3]+ " "+ XY[i][2] + " " + arregloautos[j].handpicX0 + " " + arregloautos[j].handsolpicX0 + " " + arregloautos[j].incall + " " + arregloautos[j].incomingcall);
             if (channelY1<0)
                 System.out.println("salida " + "canalY1" + " " + channelY1 + " " + "carro" + " " + XY[i][0] + " "+ XY[i][1] + " "+ XY[i][3]+ " "+ XY[i][2] + " " + arregloautos[j].handpicX1 + " " + arregloautos[j].handsolpicX1 + " " + arregloautos[j].incall + " " + arregloautos[j].incomingcall);
             if (channelY2<0)
                 System.out.println("salida " + "canalY2" + " " + channelY2 + " " + "carro" + " " + XY[i][0] + " "+ XY[i][1] + " "+ XY[i][3]+ " "+ XY[i][2] + " " + arregloautos[j].handpicX2 + " " + arregloautos[j].handsolpicX2 + " " + arregloautos[j].incall + " " + arregloautos[j].incomingcall);    
             if (channelY3<0)
                 System.out.println("salida " + "canalY3" + " " + channelY3 + " " + "carro" + " " + XY[i][0] + " "+ XY[i][1] + " "+ XY[i][3]+ " "+ XY[i][2] + " " + arregloautos[j].handpicX3 + " " + arregloautos[j].handsolpicX3 + " " + arregloautos[j].incall + " " + arregloautos[j].incomingcall);
             if (channelY4<0)
                 System.out.println("salida " + "canalY4" + " " + channelY4 + " " + "carro" + " " + XY[i][0] + " "+ XY[i][1] + " "+ XY[i][3]+ " "+ XY[i][2] + " " + arregloautos[j].handpicX4 + " " + arregloautos[j].handsolpicX4 + " " + arregloautos[j].incall + " " + arregloautos[j].incomingcall);
             i++;
              
             
            }

           
           
            cycle++;
            System.out.println( cycle );
            
        }
        System.out.println( " LA LISTA  DE PROMEDIOS" + avgHandtime);
        //Divide ovoer number of solicitudes to calculate average
        avgHandtime.set(0, avgHandtime.get(0)/handsolix1);
        avgHandtime.set(1, avgHandtime.get(1)/handsolix2);
        avgHandtime.set(2, avgHandtime.get(2)/handsolix3);
        avgHandtime.set(3, avgHandtime.get(3)/handsolix4);
        avgHandtime.set(4, avgHandtime.get(4)/handsolix5);
        avgHandtime.set(5, avgHandtime.get(5)/handsolix6);
        avgHandtime.set(6, avgHandtime.get(6)/handsolix7);
        avgHandtime.set(7, avgHandtime.get(7)/handsolix8);
        
        avgHandtime.set(8, avgHandtime.get(8)/handsoliy1);
        avgHandtime.set(9, avgHandtime.get(9)/handsoliy2);
        avgHandtime.set(10, avgHandtime.get(10)/handsoliy3);
        avgHandtime.set(11, avgHandtime.get(11)/handsoliy4);
        avgHandtime.set(12, avgHandtime.get(12)/handsoliy5);
        avgHandtime.set(13, avgHandtime.get(13)/handsoliy6);
        avgHandtime.set(14, avgHandtime.get(14)/handsoliy7);
        avgHandtime.set(15, avgHandtime.get(15)/handsoliy8);                
        
        System.out.println( " LA LISTA  DE PROMEDIOS" + avgHandtime);
        String calltime= null;
        String proba =  null;
        String restime=null;
        String time20=null;
        String speed = null;
        String Nohand = null;
        String PoissonTimes =  null;
        
        int a = 0;
        int b = 0;
        int c = 0;
        int d = 0;
        int e = 0;
        int g = 1;
        int h = 0;
        
        
        for(celllist=0; celllist<9; celllist++)
        {
            if (arregloautos2[celllist].poissontimes.size()>0)
            {
                fw9.write("Celda: " + celllist + "\n");
                for (h = 0; h < arregloautos2[celllist].poissontimes.size(); h++) {                
                    PoissonTimes = arregloautos2[celllist].poissontimes.get(h).toString();
                    fw9.write(PoissonTimes + "\n");
                }                
                fw9.write("\n");
            }
        }        
        
        for(int bb = 0; bb < 16; bb++){
            time20=avgHandtime.get(bb).toString();
            fw3.write(time20 + "\t");
        }
        fw3.write("\n");
        
        fw3.write(handsolix1 + "\t");
        fw3.write(handsolix2 + "\t");
        fw3.write(handsolix3 + "\t");
        fw3.write(handsolix4 + "\t");
        fw3.write(handsolix5 + "\t");
        fw3.write(handsolix6 + "\t");
        fw3.write(handsolix7 + "\t");
        fw3.write(handsolix8 + "\t");
        
        fw3.write(handsoliy1 + "\t");
        fw3.write(handsoliy2 + "\t");
        fw3.write(handsoliy3 + "\t");
        fw3.write(handsoliy4 + "\t");
        fw3.write(handsoliy5 + "\t");
        fw3.write(handsoliy6 + "\t");
        fw3.write(handsoliy7 + "\t");
        fw3.write(handsoliy8 + "\t");
        
        for(int q=0; q<autos; q++)
        {
            
            fw2.write("Auto " + q);
            fw4.write("Resoltime" + q);
            fw5.write("Speed" + q);
            fw7.write("Proba Auto" + q);
            fw8.write("NoHands" + q);            
            
           //System.out.println("estupides" + velocidad[q][2]); 
            
            while(a<arregloautos[q].calltimetable.size())
            {
                calltime= arregloautos[q].calltimetable.get(a).toString();
                fw2.write("\t" + calltime);
                
                
                a++;
            }
            a=0;
            fw2.write("\n");
            
            
            while(b<arregloautos[q].probabilitytable.size())
            {
                proba=arregloautos[q].probabilitytable.get(b).toString();
                fw7.write("\t" + proba);
                b++;
            }
            b=0;
            fw7.write("\n");
            
            while(c<arregloautos[q].restimetable.size())
            {
                restime=arregloautos[q].restimetable.get(c).toString();
                fw4.write("\t" + restime);
                c++;
            }
            c=0;
            fw4.write("\n");
            
//            while(d<arregloautos[q].time20.size())
//            {
//                time20=arregloautos[q].time20.get(d).toString();
//                fw3.write("\t" + time20 + "\n");
//                d++;
//            }
//            d=0;
//            fw3.write("\n");
            
            
            
                speed=arregloautos[q].speedValues.get(e).toString();
                fw5.write("\t" + speed);
                e++;
            
            fw5.write("\n");
            
            while(g<arregloautos[q].Nohandovers.size())
            {
                Nohand=arregloautos[q].Nohandovers.get(g).toString();
                fw8.write("\t" + Nohand);
                g++;
            }
            g=0;
            fw8.write("\n");
            
            
        }
        fw2.close();
        fw7.close();
        fw4.close();
        fw3.close();
        fw5.close();
        fw8.close();
        fw9.close();
        
        
       //String totalsolix0 = Integer.toString(handsolix0);
       //String totalhandoverx0 = Integer.toString(totalhandx0);
       String handerrorx0 = Integer.toString(handtotalerrorx0);
       String totaloutx0 = Integer.toString(handtotaloutx0); 
       String totalassignedx0 = Integer.toString(asignedcallsx0);


       String totalsolix1 = Integer.toString(handsolix1);
       String totalhandoverx1 = Integer.toString(totalhandx1);
       String handerrorx1 = Integer.toString(handtotalerrorx1);
       String totaloutx1 = Integer.toString(handtotaloutx1);
       String totalassignedx1 = Integer.toString(asignedcallsx1);

       String totalsolix2 = Integer.toString(handsolix2);               
       String totalhandoverx2 = Integer.toString(totalhandx2);
       String handerrorx2 = Integer.toString(handtotalerrorx2);
       String totaloutx2 = Integer.toString(handtotaloutx2);
       String totalassignedx2 = Integer.toString(asignedcallsx2);


       String totalsolix3 = Integer.toString(handsolix3);               
       String totalhandoverx3 = Integer.toString(totalhandx3);
       String handerrorx3 = Integer.toString(handtotalerrorx3);
       String totaloutx3 = Integer.toString(handtotaloutx3);
       String totalassignedx3 = Integer.toString(asignedcallsx3);

       String totalsolix4 = Integer.toString(handsolix4);               
       String totalhandoverx4 = Integer.toString(totalhandx4);
       String handerrorx4 = Integer.toString(handtotalerrorx4);
       String totaloutx4 = Integer.toString(handtotaloutx4);
       String totalassignedx4 = Integer.toString(asignedcallsx4);


       
       //String totalsoliy0 = Integer.toString(handsoliy0);
       //String totalhandovery0 = Integer.toString(totalhandy0);
       String handerrory0 = Integer.toString(handtotalerrory0);
       String totalouty0 = Integer.toString(handtotalouty0);
       String totalassignedy0 = Integer.toString(asignedcallsy0);
       
       String totalsoliy1 = Integer.toString(handsoliy1);
       String totalhandovery1 = Integer.toString(totalhandy1);
       String handerrory1 = Integer.toString(handtotalerrory1);
       String totalouty1 = Integer.toString(handtotalouty1);
       String totalassignedy1 = Integer.toString(asignedcallsy1);
       
       String totalsoliy2 = Integer.toString(handsoliy2);
       String totalhandovery2 = Integer.toString(totalhandy2);
       String handerrory2 = Integer.toString(handtotalerrory2);
       String totalouty2 = Integer.toString(handtotalouty2);
       String totalassignedy2 = Integer.toString(asignedcallsy2);


       String totalsoliy3 = Integer.toString(handsoliy3);               
       String totalhandovery3 = Integer.toString(totalhandy3);
       String handerrory3 = Integer.toString(handtotalerrory3);
       String totalouty3 = Integer.toString(handtotalouty3);
       String totalassignedy3 = Integer.toString(asignedcallsy3);
       
       String totalsoliy4 = Integer.toString(handsoliy4);
       String totalhandovery4 = Integer.toString(totalhandy4);
       String handerrory4 = Integer.toString(handtotalerrory4);
       String totalouty4 = Integer.toString(handtotalouty4);
       String totalassignedy4 = Integer.toString(asignedcallsy4);
       
       String totalnewassignedx0= Integer.toString(asignednewcallsx0);
       String totalnewassignedx1= Integer.toString(asignednewcallsx1);
       String totalnewassignedx2= Integer.toString(asignednewcallsx2);
       String totalnewassignedx3= Integer.toString(asignednewcallsx3);
       String totalnewassignedx4= Integer.toString(asignednewcallsx4);
       
       String totalnewassignedy0= Integer.toString(asignednewcallsy0);
       String totalnewassignedy1= Integer.toString(asignednewcallsy1);
       String totalnewassignedy2= Integer.toString(asignednewcallsy2);
       String totalnewassignedy3= Integer.toString(asignednewcallsy3);
       String totalnewassignedy4= Integer.toString(asignednewcallsy4);
       

       String totalchannelX0 = Integer.toString(channelX0);
       String totalchannelX1 = Integer.toString(channelX1);
       String totalchannelX2 = Integer.toString(channelX2);
       String totalchannelX3 = Integer.toString(channelX3);
       String totalchannelX4 = Integer.toString(channelX4);

       String totalchannelY0 = Integer.toString(channelY0);
       String totalchannelY1 = Integer.toString(channelY1);
       String totalchannelY2 = Integer.toString(channelY2);
       String totalchannelY3 = Integer.toString(channelY3);
       String totalchannelY4 = Integer.toString(channelY4);

       fw6.write(/*totalsolix0 + "\t" + totalhandoverx0*/ "\t" + handerrorx0 + "\t" + totaloutx0 + "\t" + totalassignedx0 + "\t" + totalnewassignedx0 + "\n"+ 
                totalsolix1 + "\t" + totalhandoverx1 + "\t" + handerrorx1 + "\t" + totaloutx1 + "\t" +totalassignedx1 +  "\t" + totalnewassignedx1 + "\n"+
                totalsolix2 + "\t" + totalhandoverx2 + "\t" + handerrorx2 + "\t" + totaloutx2 + "\t" +totalassignedx2 +  "\t" + totalnewassignedx2 + "\n"+
                totalsolix3 + "\t" + totalhandoverx3 + "\t" + handerrorx3 + "\t" + totaloutx3 + "\t" +totalassignedx3 +  "\t" + totalnewassignedx3 + "\n"+
                totalsolix4 + "\t" + totalhandoverx4 + "\t" + handerrorx4 + "\t" + totaloutx4 + "\t" +totalassignedx4 +  "\t" + totalnewassignedx4 + "\n"+"\n"+
                /*totalsoliy0 + "\t" /*+ totalhandovery0*/ "\t" + handerrory0 + "\t" + totalouty0 + "\t" +totalassignedy0 +  "\t" + totalnewassignedy0 + "\n"+
                totalsoliy1 + "\t" + totalhandovery1 + "\t" + handerrory1 + "\t" + totalouty1 + "\t" +totalassignedy1 +  "\t" + totalnewassignedy1 + "\n"+
                totalsoliy2 + "\t" + totalhandovery2 + "\t" + handerrory2 + "\t" + totalouty2 + "\t" +totalassignedy2 +  "\t" + totalnewassignedy2 +"\n"+
                totalsoliy3 + "\t" + totalhandovery3 + "\t" + handerrory3 + "\t" + totalouty3 + "\t" +totalassignedy3 +  "\t" + totalnewassignedy3 +"\n"+
                totalsoliy4 + "\t" + totalhandovery4 + "\t" + handerrory4 + "\t" + totalouty4 + "\t" +totalassignedy4 +  "\t" + totalnewassignedy4 +"\n");
               
       fw6.close();
       
    }

}





