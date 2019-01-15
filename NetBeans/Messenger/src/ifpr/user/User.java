package ifpr.user;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class User extends Thread
{
    public static void main (String [] args)
    {
        Socket socket = null;
        PrintWriter out = null;
        BufferedReader in = null;
        String server = "127.0.0.1";
        int porta = 56000;
        
        try 
        {
            socket = new Socket(server, porta);
            InputStreamReader isr = 
                    new InputStreamReader(socket.getInputStream());
            in = new BufferedReader(isr);
            out = new PrintWriter(socket.getOutputStream(), true);
            
            out.println("AK");

            String leitura = in.readLine();
            
            Scanner reader = new Scanner(System.in);
            
            while (true)
            {    
                System.out.print("Mensagem do cliente: ");
                leitura = reader.nextLine();
                if ( leitura.equals("BYE") )
                {
                    break;
                }
                out.println(leitura);
                leitura = in.readLine();
                System.out.println(leitura);
            }
            socket.close();
        }
        catch (IOException e) 
        {
            
        }  
    }
}
