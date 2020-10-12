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

public class Escritor extends Thread {
     private static Random r=new Random();		//Un random que utilizaremos dentro del código
     private GestorBD gestor;
     private int id;							//cada  lector tendra un id
     public Escritor(GestorBD gestor, int id)
    {
        this.gestor=gestor;
        this.id=id;
    }
    public void run()				//nuestro método RUN del thread
    {
        while(true)
        {
            try {
                gestor.openE(id);
                //escribir en BD
                Thread.sleep(r.nextInt(300));
                gestor.closeE(id);
                Thread.sleep(r.nextInt(300));
            } catch (InterruptedException ex) {
                Logger.getLogger(Escritor.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
}
