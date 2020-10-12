/*
Luis Jesus Reyes Velazquez 
Javier Enrique Luna Díaz
Marco Antonio Cruz Rodríguez
Gerardo Miguel Quechol Zarate
Javier Marín García

 */
package lectoresescritores;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Lector extends Thread{ 

    private static Random r=new Random();       //Un random que utilizaremos dentro del código
    private GestorBD gestor;
    private int id;                 //ID único de cada Lector
    public static void main(String[] args) {
        GestorBD gestor =new GestorBD();        //Nuestro objeto de tipo gestor
        Escritor[] esc=new Escritor[3];         //Un total de 3 Escritores solamente
        Lector[] lector=new Lector[10];         //Un total de 10 Lectores posibles
                                                    
        
                                                //AL SER NUESTRA CLASE MAIN, AQUÍ EJECUTAREMOS EL PRINCIPAL
         for(int i=0;i<esc.length;i++)
         {
             esc[i]=new Escritor(gestor,i);
         }
         for(int i=0;i<lector.length;i++)
         {
             lector[i]=new Lector(gestor,i);
         }
          for(int i=0;i<esc.length;i++)
         {
             esc[i].start();
         }
         for(int i=0;i<lector.length;i++)
         {
             lector[i].start();
         }
    }
 
    public Lector(GestorBD gestor, int id)  //CONSTRUCTOR DE NUESTRO LECTOR
    {
        this.gestor=gestor;
        this.id=id;
    }
    public void run()               //nuestro método RUN del thread
    {
        while(true)
        {
            try {
                gestor.openL(id);
                //leyendo BD
                Thread.sleep(r.nextInt(300));
            gestor.closeL(id);
             Thread.sleep(r.nextInt(300));
            } catch (InterruptedException ex) {
                Logger.getLogger(Lector.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }   
}
