package ExoSockets.UDP;

/**
 * Created by wilpiron on 22/11/2016.
 */
import com.sun.org.apache.xpath.internal.SourceTree;

import java.net.*;
import java.io.*;

public class MonUDPServer {
    public static void main(String args[]) throws Exception {
// creation d'une socket sur le port 9876. Le serveur attend sur ce port
        System.out.println("Le SERVEUR démarre.");
        DatagramSocket serverSocket = new DatagramSocket(9876);
        byte[] receiveData = new byte[1024];
        byte[] sendData = new byte[1024];
        while(true){
            System.out.println("");
            System.out.println("");
            System.out.println("Le SERVEUR démarre un nouveau traitement.");

        // Traitement de la reception
        // creation d'un buffer de (UDP)PDU arrivant sur la socket
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            System.out.println("Le SERVEUR crée un buffer PDU.");

        // reception d'un (UDP)PDU sur la socket
            serverSocket.receive(receivePacket);
            System.out.println("Le SERVEUR reçoit le PDU.");

        // rangement du champ de donnees de l'(UDP)PDU dans une string
            String sentence = new String(receivePacket.getData());
            System.out.println("Le SERVEUR met la PDU dans un string.");

        // recuperation de l'adresse IP de l'emetteur
            InetAddress IPAddress = receivePacket.getAddress();
            System.out.println("Le SERVEUR récupère l'adresse IP de l'émetteur.");

        // recuperation du n de port de l'emetteur
            int port = receivePacket.getPort();
            System.out.println("Le SERVEUR récupère le port de l'émetteur.");

        // traitement du champ de donnees
            String capitalizedSentence = sentence.toUpperCase();

            // Traitement de l'emission
        // initialisation du champ de donnees de l'(UDP) PDU a emettre
            sendData = capitalizedSentence.getBytes();

            System.out.println("Le SERVEUR a traité les données.");

        // initalisation de l'(UDP)PDU en reponse, donc a l'@IP et n°port
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, port);
            System.out.println("Le SERVEUR initialise le PDU a envoyer (port + IP).");

        // emission de l'(UDP)PDU en reponse
            serverSocket.send(sendPacket);
            System.out.println("Le SERVEUR envoie le paquet.");
        }
    }
}