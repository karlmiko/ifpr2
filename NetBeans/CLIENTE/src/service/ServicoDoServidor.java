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

public class ServicoDoServidor 
{
    private ServerSocket serverSocket;
    private Socket socket;
    private Map<String, ObjectOutputStream> mapOnlines = new HashMap<String, ObjectOutputStream>();

    public ServicoDoServidor() {
        try {
            serverSocket = new ServerSocket(56000);

            System.out.println("Servidor ONLINE");

            while (true) {
                socket = serverSocket.accept();

                new Thread(new AguardaAcaoThread(socket)).start();
            }
        } catch (Exception e) {

        }
    }

    private class AguardaAcaoThread implements Runnable 
    {
        private ObjectOutputStream output;
        private ObjectInputStream input;

        public AguardaAcaoThread(Socket socket) 
        {
            try 
            {
                this.output = new ObjectOutputStream(socket.getOutputStream());
                this.input = new ObjectInputStream(socket.getInputStream());
            } 
            catch (Exception e) 
            {

            }
        }

        @Override
        public void run() {
            ChatMessage message = null;

            try {
                while ((message = (ChatMessage) input.readObject()) != null) 
                {
                    Action action = message.getTipoAcao();

                    if (action.equals(Action.CONECTAR)) 
                    {
                        boolean isConnect = connect(message, output);

                        if (isConnect) 
                        {
                            mapOnlines.put(message.getNome(), output);
                            sendOnlineUsers();
                            System.out.println("tentando se conectar::::::");
                        }

                    } else if (action.equals(Action.DESCONECTAR)) {
                        disconnect(message, output);
                        sendOnlineUsers();
                        return;

                    } else if (action.equals(Action.MANDAR_UM)) {
                        sendOne(message);
                    } else if (action.equals(Action.MANDAR_TODOS)) {
                        sendAll(message);
                    }
                }
            } catch (IOException ex) {
                disconnect(message, output);
            } catch (ClassNotFoundException ex) {

            }
        }

        private void disconnect(ChatMessage message, ObjectOutputStream output) {
            mapOnlines.remove(message.getNome());
            System.out.println("User " + message.getNome() + " saiu da sala");
            sendOnlineUsers();
        }

        private boolean connect(ChatMessage message, ObjectOutputStream output) {
            
            if (mapOnlines.size() == 0) 
            {
                message.setTexto("YES");
                send(message, output);
                return true;
            }

            if (mapOnlines.containsKey(message.getNome())) 
            {
                message.setTexto("NO");
                send(message, output);
                return false;
                
            } 
            else 
            {
                message.setTexto("YES");
                send(message, output);
                return true;
            }
        }

        private void send(ChatMessage message, ObjectOutputStream output) {
            try {
                output.writeObject(message);
            } catch (IOException ex) {

            }
        }

        private void sendOne(ChatMessage message) {
            for (Map.Entry<String, ObjectOutputStream> kv : mapOnlines.entrySet()) {
                if (kv.getKey().equals(message.getNomeReservado())) {
                    try {
                        kv.getValue().writeObject(message);
                    } catch (IOException ex) {

                    }
                }
            }
        }

        private void sendAll(ChatMessage message) {
            for (Map.Entry<String, ObjectOutputStream> kv : mapOnlines.entrySet()) {
                if (!kv.getKey().equals(message.getNome())) {
                    message.setTipoAcao(Action.MANDAR_UM);

                    try {
                        System.out.println(message.getTexto());
                        kv.getValue().writeObject(message);
                    } catch (IOException ex) {

                    }
                }
            }
        }

        private void sendOnlineUsers() 
        {
            Set<String> setNames = new HashSet<String>();

            for (Map.Entry<String, ObjectOutputStream> kv : mapOnlines.entrySet()) {
                setNames.add(kv.getKey());
            }

            ChatMessage message = new ChatMessage();
            message.setTipoAcao(ChatMessage.Action.USUARIOS_ONLINE);
            message.setSetOnlines(setNames);

            for (Map.Entry<String, ObjectOutputStream> kv : mapOnlines.entrySet()) {
                message.setNome(kv.getKey());

                try {

                    kv.getValue().writeObject(message);
                } catch (IOException ex) {

                }

            }
            
            send(message, output);
        }
    }
}
