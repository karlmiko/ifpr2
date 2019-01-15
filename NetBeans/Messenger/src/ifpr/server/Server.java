package ifpr.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server 
{
    private String leitura = "";
    private ServerSocket serverSocket = null;
    private Socket socket = null;
    private BufferedReader in = null;
    private PrintWriter out = null;
    private int porta = 56000;
    
    public static void main (String [] args)
    {   
        new Server().executar();
    }

    private void executar()
    {
        try {
            serverSocket = new ServerSocket(porta);
            System.out.println("Servidor criado");
        } catch (IOException ex) {}
        
        while (true)
        {
            try {
                System.out.println("Aguardando conexões");
                socket = serverSocket.accept();
                
                InputStreamReader isr = 
                        new InputStreamReader(socket.getInputStream());
                
                in = new BufferedReader(isr);
                out = new PrintWriter(socket.getOutputStream(), true);
                
                leitura = in.readLine();
                
                if (leitura.equals("AK"))
                {
                    out.println("OK");
                    UsersThread cli = new UsersThread(socket);
                    cli.start();
                }
                else
                {
                    socket.close();
                }
                
            } catch (IOException ex) {}
        }
    }
}
