package exthread;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    private ThreadMensagem thread;
    private static int numero = 0;
    
    public static void main(String[] args) {
        new Main().executar();
    }

    private void executar() {
        Random gerador = new Random();
        int quantidade = gerador.nextInt(10) + 1;
       
        System.out.println(" numero: " + quantidade);
       
        thread = new ThreadMensagem(quantidade);
        thread.start();


        for (int i = 0; i < 5; i++) {
            if (thread.isAlive()) {                
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException ex) {
                }
            }
        }
        thread.stop();
    }
    public synchronized static int getNumero(){
        return numero;
    }
    
}
