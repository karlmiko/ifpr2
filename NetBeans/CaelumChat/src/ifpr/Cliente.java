package ifpr;

import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class Cliente
{
   private String nickname;
   private String host;
   private int porta;

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPorta() {
        return porta;
    }

    public void setPorta(int porta) {
        this.porta = porta;
    }
    
    public void Cliente(JanelaConexao janelaC)
    {
        executa();
    }
  
   public void executa()
   {
        try
        {
            Socket cliente = new Socket(this.host, this.porta);
            System.out.println("O cliente "+ this.getNickname() + " se conectou ao servidor!");
            threadMensagemServidor(cliente);
            mandarMensagemServidor(cliente);
            cliente.close(); 
            
        } catch(Exception e)
        {
           e.printStackTrace();
        }   
   }
   
   private void threadMensagemServidor(Socket cliente)
   {
       // thread para receber mensagens do servidor
       try
       {
            Recebedor r = new Recebedor(cliente.getInputStream());
            new Thread(r).start();
            
       } catch(Exception e)
       {
           e.printStackTrace();
       }
   }
   
   private void mandarMensagemServidor(Socket cliente)
   {
        try
        {
            Scanner teclado = new Scanner(System.in);
            PrintStream saida = new PrintStream(cliente.getOutputStream());
            while (teclado.hasNextLine()) 
            {
                saida.println(teclado.nextLine());
            }
            saida.close();
            teclado.close();
        } catch(Exception e)
        {
            e.printStackTrace();
        }
   }
}
