package ExoSockets.UDP;

/**
 * Created by wilpiron on 22/11/2016.
 */
import java.net.*;
import java.io.*;
public class MonUDPClient {
    public static void main(String args[]) throws Exception {
// 1 - Creation du buffer de lecture clavier
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));

// 2 - Creation de la socket, n de port par defaut
        DatagramSocket clientSocket = new DatagramSocket();

        System.out.println("socket CLIENT attachee au port " + clientSocket.getLocalPort());

// 3 - Recuperation de l'@IP du serveur
        InetAddress IPAddress = InetAddress.getByName("localhost");

// 3bis - preparation de l'echange
        byte[] sendData = new byte[1024];
        byte[] receiveData = new byte[1024];
        System.out.println("On lit la ligne suivante : ");
        String sentence = inFromUser.readLine();
        sendData = sentence.getBytes();
        int length = sendData.length;
        System.out.println("Le CLIENT prépare le paquet.");

// 3ter - Initialisation de la (UDP)PDU a emettre
        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 9876);
        System.out.println("Le CLIENT envoie le paquet.");

// 4 - Emission de la (UDP)PDU
        clientSocket.send(sendPacket);
        System.out.println("Le CLIENT envoie la PDU.");

        // 5 - Creation d'un buffer de (UDP)PDU arrivant sur la socket
        DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
        System.out.println("Le CLIENT créé un buffer PDU.");

// 5bis - Reception de la (UDP)PDU
        clientSocket.receive(receivePacket);
        System.out.println("Le CLIENT reçoit le PDU.");

// 6 - Affichage des donnees recues
        String modifiedSentence = new String(receivePacket.getData());
        System.out.println("FROM SERVER: " + modifiedSentence);

// Fermeture de la socket
        clientSocket.close();
    }
}