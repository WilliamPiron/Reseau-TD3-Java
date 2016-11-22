package exo1;

import com.sun.corba.se.impl.presentation.rmi.ExceptionHandlerImpl;

import java.lang.*;

/**
 * Created by wilpiron on 08/11/2016.
 */
public class Nombre extends Thread{
    private int n;
    private int carre;
    private boolean estModifie;

    public synchronized void printDatas(){
        if (this.estModifie) {
            System.out.println("N : " + n);
            System.out.println("Carré : " + carre);
            this.estModifie = false;
            notifyAll();
        }
        else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        /*
        while(!this.estModifie){
            wait();
        }
        System.out.println("N : " + n);
        System.out.println("Carré : " + carre);
        this.estModifie = false;
        notifyAll();
         */
    }

    public synchronized void increment(){
        if (!this.estModifie) {
            this.n = this.n + 1;
            this.carre = this.n * this.n;
            this.estModifie = true;
            notifyAll();
        }
        else {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        /*
        while(this.estModifie){
            wait();
        }
        this.n = this.n + 1;
        this.carre = this.n * this.n;
        this.estModifie = true;
        notifyAll();
         */
    }

    void Nombre(){
        this.n = 0;
        this.carre = 0;
        this.estModifie = false;
    }
}
