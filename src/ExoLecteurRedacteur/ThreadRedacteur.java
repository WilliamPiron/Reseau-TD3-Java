package ExoLecteurRedacteur;

import static java.lang.Thread.*;

/**
 * Created by wilpiron on 22/11/2016.
 */
public class ThreadRedacteur implements Runnable{

    private LecteursRedacteurs L;
    private int[] tab;

    public ThreadRedacteur(LecteursRedacteurs L, int[] tab) {
        this.L = L;
        this.tab = tab;
    }

    @Override
    public void run() {
        int n;
        for(int i=0; i<15; i++){
            try{
                L.entreEcriture();
                System.out.println("Je viens d'entrer en écriture.");
                n=(int) Math.random()%15;
                tab[n]=i;
                sleep(150);
                System.out.println("Je vais sortir.");
                L.sortEcriture();
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}