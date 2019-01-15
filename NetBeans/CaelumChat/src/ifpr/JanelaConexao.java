package ifpr;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class JanelaConexao extends javax.swing.JFrame
{
    public JanelaConexao() 
    {
       initComponents();
       JanelaPrincipal janelaPrincipal = new JanelaPrincipal(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        connectBt = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        ipTf = new javax.swing.JTextField();
        nicknameTf = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 204, 204));

        connectBt.setFont(new java.awt.Font("Yuppy SC", 2, 13)); // NOI18N
        connectBt.setText("Conectar-se");
        connectBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connectBtActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Yuppy SC", 2, 24)); // NOI18N
        jLabel3.setText("Bem-vindo ao Huessenger");

        jLabel1.setFont(new java.awt.Font("Yuppy SC", 2, 14)); // NOI18N
        jLabel1.setText("Entre com o IP do servidor:");

        ipTf.setFont(new java.awt.Font("Yuppy SC", 2, 13)); // NOI18N
        ipTf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                ipTfFocusLost(evt);
            }
        });

        nicknameTf.setFont(new java.awt.Font("Yuppy SC", 2, 13)); // NOI18N

        jLabel2.setFont(new java.awt.Font("Yuppy SC", 2, 14)); // NOI18N
        jLabel2.setText("Entrre com um nickname (apelido):");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(connectBt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 236, Short.MAX_VALUE)
                        .addComponent(ipTf, javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addGap(61, 61, 61))
                        .addComponent(nicknameTf)))
                .addGap(26, 26, 26))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 26, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nicknameTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ipTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(connectBt)
                .addGap(26, 26, 26))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ipTfFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ipTfFocusLost

    }//GEN-LAST:event_ipTfFocusLost

    private void connectBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connectBtActionPerformed
        nickname = nicknameTf.getText();
        ipServidor = ipTf.getText();
        executa();
    }//GEN-LAST:event_connectBtActionPerformed

    public static void main(String args[]) 
    {
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JanelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JanelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JanelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JanelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable()
        {
            public void run() 
            {
                new JanelaConexao().setVisible(true);
            }
        });
    }
    
    private JanelaPrincipal janelaPrincipal;
    private Socket cliente = null;
    private JanelaPrincipal jP;
    private String nickname;
    private String ipServidor = "";
    private final int porta = 56000;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton connectBt;
    private javax.swing.JTextField ipTf;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField nicknameTf;
    // End of variables declaration//GEN-END:variables

    public void executa()
   {    
        try
        {
            cliente = new Socket(ipServidor, porta);
            System.out.println("O cliente " + nickname + " se conectou ao servidor!");
            janelaPrincipal.setVisible(true);
            threadMensagemServidor(cliente);
            mandarMensagemServidor(cliente);
            cliente.close(); 
            
        } catch(Exception e)
        {
           JOptionPane.showMessageDialog(null, "Servidor não encontrado, entre com outro IP");
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

    public Socket getCliente() {
        return cliente;
    }
}
