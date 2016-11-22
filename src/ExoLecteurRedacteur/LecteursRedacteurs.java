package ExoLecteurRedacteur;

/**
 * Created by wilpiron on 22/11/2016.
 */
public class LecteursRedacteurs {
    private int nbLecteurs = 0;
    private boolean redacteurPresent = false;

    synchronized void entreLecture() {
        while (this.redacteurPresent){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            nbLecteurs++;
        }
    }
    synchronized void sortLecture() {
        nbLecteurs--;
        notifyAll();
    }

    synchronized void entreEcriture() {
        while ((this.redacteurPresent)|| (this.nbLecteurs > 0))
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        this.redacteurPresent = true;
    }
    synchronized void sortEcriture(){
        this.redacteurPresent = false;
        notifyAll();
    }
}
