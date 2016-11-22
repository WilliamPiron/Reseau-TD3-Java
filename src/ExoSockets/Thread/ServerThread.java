package ExoSockets.Thread;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by wilpiron on 22/11/2016.
 */

public class ServerThread implements Runnable{
    private Thread thr; // contiendra le thread du client
    private Socket sock; // recevra le socket liant au client
    private DataOutputStream sortie; // pour gestion du flux de sortie
    private BufferedReader entree; // pour gestion du flux d'entrée

    public static void main(String args[]) {
        try{
        int port=6897;
            ServerSocket socketaccueil = new ServerSocket(port);
            // ouverture d'un socket serveur sur port
            while (true) {
            // attente en boucle de connexion (bloquant sur .accept)
                new ServerThread(socketaccueil.accept());
            // un client se connecte, un nouveau thread client est lancé
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    // constructeur
    ServerThread(Socket s) { //param s est donné dans main par ss.accept()
        try{
            this.sock=s;
            // fabrication flux IO
            sortie = new DataOutputStream(sock.getOutputStream());
            try {
                entree = new BufferedReader(new InputStreamReader(sock.getInputStream()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
        thr = new Thread(this); //instanciation thread (obligatoire avec runnable)
        thr.start(); //demarrage thread (peut etre mis dans main)
    }

    // methode run
    public void run(){
        String clientSentence;
        String capitalizedSentence; //clientSentence.toUpperCase() + '\n';
        // reception et envoi
        try {
            clientSentence = entree.readLine();
            capitalizedSentence = clientSentence.toUpperCase() + '\n';
            try {
                sortie.writeBytes(capitalizedSentence);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}