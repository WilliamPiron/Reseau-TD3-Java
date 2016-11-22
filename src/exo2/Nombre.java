package exo2;

/**
 * Created by wilpiron on 08/11/2016.
 */
public class Nombre extends Thread{
    private int n;
    private int carre;
    private int etat;
    // 0 après affichage, 1 après increment, 2 après calcul


    public synchronized void calcul(){
        while (etat !=1){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        carre = n*n;
        etat=2;
        notifyAll();
    }

    public synchronized void increment(){
        while (etat != 0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        n++;
        etat = 1;
        notifyAll();
    }

    public synchronized void affiche(){
        while (etat !=2){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("N : " + n);
        System.out.println("Carre : " + carre);
        etat=0;
        notifyAll();
    }

    public Nombre(){
        this.n = 0;
        this.carre = 0;
        this.etat = 0;
    }
}
