package ifpr.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class UsersThread extends Thread {

    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    public UsersThread(Socket socket) {
        InputStreamReader isr;

        try {
            isr = new InputStreamReader(socket.getInputStream());
            in = new BufferedReader(isr);
            out = new PrintWriter(socket.getOutputStream(), true);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void run() {
        String mensagem = "";

        try
        {
            while (mensagem != null && !mensagem.equals("BYE"))
            {
                mensagem = in.readLine();
                out.println("Echo: " + mensagem);
            }
            socket.close();
        }
        catch (IOException ex) {
        }
        catch (NullPointerException npe)
        {
        }
    }
}
