package socket;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class TCPCliente {
	
	
	public static void main(String argv[]) throws Exception { 
		
        String sentence; 
        String modifiedSentence; 

        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in)); 

        Socket clientSocket = new Socket("localhost", 43500); 
        
        System.out.println("Executou1");

        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
        
        System.out.println("Executou2");
        
        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream())); 
        
        System.out.println("Executou3");

        sentence = inFromUser.readLine(); 

        outToServer.writeBytes(sentence + '\n'); 

        modifiedSentence = inFromServer.readLine(); 

        System.out.println("FROM SERVER: " + modifiedSentence); 

        clientSocket.close(); 
        
	}

}
