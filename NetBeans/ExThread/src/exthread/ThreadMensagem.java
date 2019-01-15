
package exthread;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ThreadMensagem extends Thread{

    private int qtdMensagem;
    private List<String> mensagens;
    
    public ThreadMensagem(int quantidadeMensagem){
        qtdMensagem = quantidadeMensagem;
        mensagens = new ArrayList<String>();
        
        for (int i = 1; i < 10; i++) {
            mensagens.add("Mensagem" + i);
        }

    }
    
    @Override
    public void run() {
        for (int i = 0; i < qtdMensagem; i++) {
            System.out.println("- " + mensagens.get(i));
            try {
                this.sleep(1000);
            } catch (InterruptedException ex) {
                
            }
        }
     
    }
    
    
}
