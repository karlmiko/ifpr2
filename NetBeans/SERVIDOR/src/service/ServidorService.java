/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import bin.ChatMessage;
import bin.ChatMessage.Action;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author KarlKoerich
 */
public class ServidorService {
    
    private ServerSocket serverSocket;
    private Socket socket;
    private Map<String, ObjectOutputStream> mapOnlines = new HashMap<String, ObjectOutputStream>();
    
    public ServidorService()
    {
        try
        {
            serverSocket = new ServerSocket(56000);
            
            System.out.println("Servidor ONLINE");
            
            while(true)
            {
                socket = serverSocket.accept();
                
                new Thread(new ListenerSocket(socket)).start();
            }
        } catch(Exception e)
        {
            
        }
    }

    private class ListenerSocket implements Runnable 
    {

       private ObjectOutputStream output;
       private ObjectInputStream input;
        
        public ListenerSocket(Socket socket) 
        {
            try
            {
                this.output = new ObjectOutputStream(socket.getOutputStream());
                this.input = new ObjectInputStream(socket.getInputStream());
            } catch(Exception e)
            {
                
            }         
        }

        @Override
        public void run() 
        {
            ChatMessage message = null;
            
           try 
           {
               while((message = (ChatMessage)input.readObject()) != null)
               {
                   Action action = message.getAction();
                   
                   if (action.equals(Action.CONNECT))
                   {
                       boolean isConnect = connect(message, output);
                       
                       if (isConnect)
                       {
                           mapOnlines.put(message.getName(), output); 
                           sendOnlineUsers();
                       }
                       
                   } else if (action.equals(Action.DISCONNECT))
                   {
                       disconnect(message, output);
                       sendOnlineUsers();
                       return;
                       
                   } else if (action.equals(Action.SEND_ONE))
                   {
                       sendOne(message);
                   } else if (action.equals(Action.SEND_ALL))
                   {
                       sendAll(message);
                   }   
               }
           } catch (IOException ex) 
           {
               disconnect(message, output);
           } catch (ClassNotFoundException ex) {
               
           }
        }
    }   
    
    private void disconnect(ChatMessage message, ObjectOutputStream output) 
    {
        mapOnlines.remove(message.getName());
        System.out.println("User" + message.getName() + " saiu da sala");
        sendOnlineUsers(); 
    }
    
    private boolean connect(ChatMessage message, ObjectOutputStream output)
    {
        if (mapOnlines.size() == 0) {
            message.setText("YES");
            send(message, output);
            return true;
        }

        if (mapOnlines.containsKey(message.getName())) 
        {
            message.setText("NO");
            send(message, output);
            return false;
        } else 
        {
            message.setText("YES");
            send(message, output);
            return true;
        }
    }
    
    private void send(ChatMessage message, ObjectOutputStream output) 
    {
        try 
        {
            output.writeObject(message);
        } catch (IOException ex) 
        {

        }
    }
        
    private void sendOne(ChatMessage message)
    {
        for (Map.Entry<String, ObjectOutputStream> kv : mapOnlines.entrySet()) {
            if (kv.getKey().equals(message.getNameReserved())) {
                try {
                    kv.getValue().writeObject(message);
                } catch (IOException ex) {

                }
            }
        }
    }
    
    private void sendAll(ChatMessage message) 
    {
        for (Map.Entry<String, ObjectOutputStream> kv : mapOnlines.entrySet())
        {
            if (!kv.getKey().equals(message.getName()))
            {
                message.setAction(Action.SEND_ONE);
                
                try 
                {
                    kv.getValue().writeObject(message);
                } catch (IOException ex) 
                { 
                 
                }
            }
        }
    }
    
    private void sendOnlineUsers()
    {
        Set<String> setNames = new HashSet<String>();
        
        for (Map.Entry<String, ObjectOutputStream> kv : mapOnlines.entrySet())
        {
            setNames.add(kv.getKey());
        }
        
        
        ChatMessage message = new ChatMessage();
        message.setAction(Action.USERS_ONLINE);
        message.setSetOnlines(setNames);
        
        for (Map.Entry<String, ObjectOutputStream> kv : mapOnlines.entrySet())
        {
            message.setName(kv.getKey());
            
            try {
                
                kv.getValue().writeObject(message);
            } catch (IOException ex) {

            }
            
        }
    }
}
