package ExoLecteurRedacteur;

import static java.lang.Thread.*;

/**
 * Created by wilpiron on 22/11/2016.
 */
public class ThreadLecteur implements Runnable{

    private LecteursRedacteurs L;
    private int[] tab;

    public ThreadLecteur(LecteursRedacteurs L, int[] tab) {
        this.L = L;
        this.tab = tab;
    }

    @Override
    public void run() {
        int n;
        for(int i=0; i<15; i++){
            try{
                L.entreLecture();
                System.out.println("Je viens d'entrer en lecture.");
                n=(int) Math.random()%15;
                System.out.println(tab[n]);
                sleep(150);
                System.out.println("Je vais sortir.");
                L.sortLecture();
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
