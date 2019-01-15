package cliente.frame;

import bin.ChatMessage;
import bin.ChatMessage.Action;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListSelectionModel;
import service.ServicoDoCliente;

public class ClienteFrame extends javax.swing.JFrame 
{
    public ClienteFrame() 
    {
        initComponents();
    }
    
    private class ListenerSocket implements Runnable
    {
        private ObjectInputStream input;
        
        public ListenerSocket (Socket socket)
        {
            try 
            {
                this.input = new ObjectInputStream(socket.getInputStream());
            } catch (IOException ex) 
            {
                
            }
        }

        @Override
        public void run() 
        {
            ChatMessage message = null;
            
            try {
                while((message = (ChatMessage) input.readObject()) != null)
                {
                    Action action = message.getTipoAcao();
                    
                    if (action.equals(Action.CONECTAR))
                    {
                        conectar(message);
                        
                    } else if (action.equals(Action.DESCONECTAR))
                    {
                        desconectar();
                        socket.close();
                        
                    } else if (action.equals(Action.MANDAR_UM))
                    {
                        receberMensagem(message);
                        
                    } else if (action.equals(Action.MANDAR_TODOS))
                    {
                        receberMensagem(message);
                        
                    } else if (action.equals(Action.USUARIOS_ONLINE))
                    {
                        atualizarOnlines(message);
                        
                    }
                    
                }
            } catch (IOException ex) 
            {
                desconectar();
            } catch (ClassNotFoundException ex) {
                
            }
        }
    }
    
    private void conectar(ChatMessage message)
    {
        if (message.getTexto().equals("NO"))
        {
            this.nameTf.setText("");
            configurarBotoesDesc();
            JOptionPane.showMessageDialog(this, "Tente novamente com outro nome");
        }
        else
        {
            this.message = message;      
            configurarBotoesConec();
            JOptionPane.showMessageDialog(this, "Você está conectado!");
        }
    }

    private void receberMensagem(ChatMessage message)
    {
        this.txtAreaReceive.append(message.getNome()+ " diz: " + message.getTexto() + "\n");
    }

    private void atualizarOnlines (ChatMessage message)
    {
        Set <String> names = message.getSetOnlines();
        
        names.remove(message.getNome());
 
        String [] array = (String[]) names.toArray(new String[names.size()]);
        
        configurarLista(array);
    }
    
    private void configurarLista(String [] array)
    {
        this.onlinesList.setListData(array);
        this.onlinesList.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        this.onlinesList.setLayoutOrientation(JList.VERTICAL);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        menuBar1 = new java.awt.MenuBar();
        menu1 = new java.awt.Menu();
        menu2 = new java.awt.Menu();
        jTextField2 = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        mainPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaReceive = new javax.swing.JTextArea();
        sendTxt = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        enviarBt = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        onlinesList = new javax.swing.JList();
        conectarBt = new javax.swing.JButton();
        sairBt = new javax.swing.JButton();
        nameTf = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        ipServidorTf = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();

        menu1.setLabel("File");
        menuBar1.add(menu1);

        menu2.setLabel("Edit");
        menuBar1.add(menu2);

        jTextField2.setText("jTextField2");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        jInternalFrame1.setVisible(true);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mainPanel.setBackground(new java.awt.Color(255, 102, 51));
        mainPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtAreaReceive.setEditable(false);
        txtAreaReceive.setColumns(20);
        txtAreaReceive.setFont(new java.awt.Font("Yuppy SC", 2, 14)); // NOI18N
        txtAreaReceive.setRows(5);
        txtAreaReceive.setEnabled(false);
        jScrollPane1.setViewportView(txtAreaReceive);

        sendTxt.setFont(new java.awt.Font("Yuppy SC", 2, 14)); // NOI18N
        sendTxt.setEnabled(false);

        jLabel1.setFont(new java.awt.Font("Yuppy SC", 2, 74)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Baschat");

        jLabel2.setFont(new java.awt.Font("Yuppy SC", 2, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Escreva uma mensagem:");

        enviarBt.setFont(new java.awt.Font("Yuppy SC", 2, 18)); // NOI18N
        enviarBt.setText("Enviar");
        enviarBt.setToolTipText("Enviar mensagem digitada para todos ou para usuário específico");
        enviarBt.setEnabled(false);
        enviarBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enviarBtActionPerformed(evt);
            }
        });

        onlinesList.setFont(new java.awt.Font("Yuppy SC", 2, 14)); // NOI18N
        jScrollPane3.setViewportView(onlinesList);

        conectarBt.setFont(new java.awt.Font("Yuppy SC", 2, 14)); // NOI18N
        conectarBt.setText("entrar");
        conectarBt.setToolTipText("entrar num servidor");
        conectarBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                conectarBtActionPerformed(evt);
            }
        });

        sairBt.setFont(new java.awt.Font("Yuppy SC", 2, 14)); // NOI18N
        sairBt.setText("sair");
        sairBt.setToolTipText("desconectar-se do servidor");
        sairBt.setEnabled(false);
        sairBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sairBtActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Yuppy SC", 2, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Entre com seu nickname:");

        jLabel4.setFont(new java.awt.Font("Yuppy SC", 2, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("IP do servidor:");

        jLabel5.setFont(new java.awt.Font("Yuppy SC", 2, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Mensagens:");

        jLabel6.setFont(new java.awt.Font("Yuppy SC", 2, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Onlines:");

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE)
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(sendTxt, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1))
                                .addGap(14, 14, 14)))
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabel3)
                                .addGap(0, 1, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(nameTf, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(enviarBt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(ipServidorTf, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                                            .addComponent(conectarBt, javax.swing.GroupLayout.PREFERRED_SIZE, 75, Short.MAX_VALUE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(sairBt))))))))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        mainPanelLayout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {conectarBt, sairBt});

        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ipServidorTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)
                        .addComponent(nameTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(sairBt)
                            .addComponent(conectarBt))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sendTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(enviarBt, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26))
        );

        mainPanelLayout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {conectarBt, sairBt});

        jMenuBar1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jMenu1.setText("Instruções");
        jMenu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenu1ActionPerformed(evt);
            }
        });
        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void conectarBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_conectarBtActionPerformed
        conectado();
    }//GEN-LAST:event_conectarBtActionPerformed

    private void conectado()
    {
        String nome = this.nameTf.getText();
        String ip = this.ipServidorTf.getText();
        
        if (!nome.isEmpty())
        {
            this.message = new ChatMessage();
            this.message.setTipoAcao(Action.CONECTAR);
            
            this.message.setNome(nome);
            
            this.service = new ServicoDoCliente();
            this.socket = this.service.connect(ip);
            
            configurarBotoesConec();
                
            new Thread(new ListenerSocket(this.socket)).start();
            
            this.service.send(message);
        }
    }
    
    private void configurarBotoesConec() 
    {
        this.conectarBt.setEnabled(false);
        this.nameTf.setEnabled(false);
        
        this.sairBt.setEnabled(true);
        this.sendTxt.setEnabled(true);
        this.enviarBt.setEnabled(true);
        this.txtAreaReceive.setEnabled(true);
        this.onlinesList.setEnabled(true);
    }
    
    private void sairBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sairBtActionPerformed
        desconectar();
    }//GEN-LAST:event_sairBtActionPerformed

    private void desconectar()
    {
        ChatMessage message = new ChatMessage();
        message.setNome(this.message.getNome());
        message.setTipoAcao(Action.DESCONECTAR);
        this.service.send(message);
        desconectado();
    }
    
    private void desconectado()
    {
        configurarBotoesDesc();
        
        this.txtAreaReceive.setText("");
        this.sendTxt.setText("");
        
        try 
        {
            this.socket.close();
        } 
        catch (IOException ex) 
        {
            System.out.println("NADA ACONTECEU FIÃO");
        }
        //JOptionPane.showMessageDialog(this, "Você se desconectou!");
    }
    
    private void configurarBotoesDesc()
    {
        this.conectarBt.setEnabled(true);
        this.nameTf.setEnabled(true);
        
        this.sairBt.setEnabled(false);
        this.sendTxt.setEnabled(false);
        this.enviarBt.setEnabled(false);
        this.txtAreaReceive.setEnabled(false);
        this.onlinesList.setEnabled(false);   
    }
    
    private void enviarBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enviarBtActionPerformed
        
        String texto = this.sendTxt.getText();
        String nome = this.message.getNome();
        
        this.message = new ChatMessage();
        
        if(this.onlinesList.getSelectedIndex() > NENHUM_SELECIONADO)
        {
            this.message.setNomeReservado((String) this.onlinesList.getSelectedValue());
            this.message.setTipoAcao(Action.MANDAR_UM);
            this.onlinesList.clearSelection();
        } else
        {
            this.message.setTipoAcao(Action.MANDAR_TODOS);
        }
        
        if (!texto.isEmpty())
        {
            this.message.setNome(nome);
            this.message.setTexto(texto);
            this.txtAreaReceive.append("Você disse: " + texto + "\n");
            this.service.send(this.message); 
        }
        
        this.sendTxt.setText("");
    }//GEN-LAST:event_enviarBtActionPerformed

    private void jMenu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenu1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenu1ActionPerformed
    
    
    
    private final int NENHUM_SELECIONADO = -1;
    private Socket socket;
    private ChatMessage message;
    private ServicoDoCliente service;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton conectarBt;
    private javax.swing.JButton enviarBt;
    private javax.swing.JTextField ipServidorTf;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JPanel mainPanel;
    private java.awt.Menu menu1;
    private java.awt.Menu menu2;
    private java.awt.MenuBar menuBar1;
    private javax.swing.JTextField nameTf;
    private javax.swing.JList onlinesList;
    private javax.swing.JButton sairBt;
    private javax.swing.JTextField sendTxt;
    private javax.swing.JTextArea txtAreaReceive;
    // End of variables declaration//GEN-END:variables
}
