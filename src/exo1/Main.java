package exo1;

import java.util.Scanner;

/**
 * Created by wilpiron on 08/11/2016.
 */
public class Main {
    public static void main(String[] args){
        Nombre n = new Nombre();
        Scanner scan = new Scanner(System.in);
        ThreadAffiche ta = new ThreadAffiche(n);
        ThreadIncrement ti = new ThreadIncrement(n);

        ta.start();
        ti.start();
        scan.next();
        ta.interrupt();
        ti.interrupt();
        try {
            ta.join();
            ti.join();
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }
    }
}