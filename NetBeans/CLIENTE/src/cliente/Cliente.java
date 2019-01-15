package cliente;

import cliente.frame.ClienteFrame;

public class Cliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) 
    {
        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run() 
            {
                new ClienteFrame().setVisible(true);
            }
        });
    }
    
}
