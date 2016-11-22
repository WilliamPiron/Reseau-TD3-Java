package exo1;

/**
 * Created by wilpiron on 08/11/2016.
 */
public class ThreadIncrement extends Thread {
    Nombre n;

    public ThreadIncrement(Nombre n){
        this.n = n;
    }

    public void run(){
        while(!this.isInterrupted()){
            try{
                sleep(150);
                n.increment();
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
