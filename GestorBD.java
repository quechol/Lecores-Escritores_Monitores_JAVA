/*
Luis Jesus Reyes Velazquez 
Javier Enrique Luna Díaz
Marco Antonio Cruz Rodríguez
Gerardo Miguel Quechol Zarate
Javier Marín García

 */
package lectoresescritores;

public class GestorBD {
    private int NLectores=0;
    private boolean HayEscritor=false;
    private int NEscritor=0;
    
    public synchronized void openL(int id)throws InterruptedException
    {
        while(HayEscritor || NEscritor>0)
        {
            wait();
        }
        NLectores++;
        System.out.println("Lector "+(id+1)+" esta leyendo");
    }
    public synchronized void closeL(int id)
    {
        System.out.println("Lector "+(id+1)+" termino de leer");
        NLectores--;
        if(NLectores==0)notifyAll(); //despertar un al escritor q esta esperando
    }
    public synchronized void openE(int id) throws InterruptedException
    {
        NEscritor++;
        while(HayEscritor || NLectores>0)
        {
            wait();
        }
        HayEscritor=true;
        System.out.println("Escritor "+(id+1)+" empezo a escribir");
    }
    public synchronized void closeE(int id)
    {
        NEscritor--;
        System.out.println("Escritor "+(id+1)+" termino de escribir");
        HayEscritor=false;
        notifyAll();
    }
}
