package exo1;

/**
 * Created by wilpiron on 08/11/2016.
 */
public class ThreadAffiche extends Thread{
    Nombre n;

    public  ThreadAffiche(Nombre n){
        this.n = n;
    }

    public void run(){
        while(!this.isInterrupted()){
            try{
                sleep(100);
                n.printDatas();
            }
            catch (InterruptedException e){
                e.printStackTrace();
                break;
            }
        }
    }
}
