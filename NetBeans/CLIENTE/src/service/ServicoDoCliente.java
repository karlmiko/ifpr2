package service;

import bin.ChatMessage;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServicoDoCliente 
{
    private Socket socket;
    private ObjectOutputStream output;
    
    public Socket connect(String ip)
    {
        try {
            this.socket = new Socket(ip, 56000);
            this.output = new ObjectOutputStream(socket.getOutputStream());
        } catch (IOException ex) {
            Logger.getLogger(ServicoDoCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return socket;
    }
    
    public void send(ChatMessage message)
    {
        try {
            output.writeObject(message);
        } catch (IOException ex) {
            Logger.getLogger(ServicoDoCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
