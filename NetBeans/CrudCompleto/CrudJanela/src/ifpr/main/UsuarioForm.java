package ifpr.main;

import ifpr.usuario.Usuario;
import ifpr.usuario.dao.UsuarioDao;
import ifpr.usuario.dao.UsuarioDaoImpl;
import java.awt.Color;
import javax.persistence.NoResultException;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;

public class UsuarioForm extends javax.swing.JDialog {

    /** Creates new form UsuarioForm */
    public UsuarioForm(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        usuarioDao = new UsuarioDaoImpl();
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nomeTf = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        loginTf = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        matriculaTf = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        senhaPf = new javax.swing.JPasswordField();
        salvarBt = new javax.swing.JButton();
        cancelarBt = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Formulário do usuário");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36));
        jLabel1.setText("Dados do usuário");

        jLabel2.setText("Nome*:");

        jLabel3.setText("Login*:");

        loginTf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginTfActionPerformed(evt);
            }
        });

        jLabel4.setText("Matrícula*:");

        matriculaTf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                matriculaTfFocusLost(evt);
            }
        });

        jLabel5.setText("Senha*:");

        salvarBt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/filesave.png"))); // NOI18N
        salvarBt.setText("Salvar");
        salvarBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvarBtActionPerformed(evt);
            }
        });

        cancelarBt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/button_cancel.png"))); // NOI18N
        cancelarBt.setText("Cancelar");
        cancelarBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarBtActionPerformed(evt);
            }
        });

        jLabel6.setText("* - Campo de preenchimentos obrigatório");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(nomeTf, javax.swing.GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
                            .addComponent(loginTf, javax.swing.GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
                            .addComponent(jLabel4)
                            .addComponent(matriculaTf, javax.swing.GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
                            .addComponent(jLabel5)
                            .addComponent(senhaPf, javax.swing.GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(salvarBt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cancelarBt))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel1))))
                .addContainerGap())
        );

        layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {cancelarBt, salvarBt});

        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(nomeTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(loginTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(matriculaTf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(senhaPf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(salvarBt)
                    .addComponent(cancelarBt))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void loginTfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginTfActionPerformed

    }//GEN-LAST:event_loginTfActionPerformed

    private boolean isValidado()
    {
        boolean isValidado = true;
        if (nomeTf.getText().isEmpty())
        {
            nomeTf.setBorder(BorderFactory.createLineBorder(Color.RED));
            isValidado = false;
        }
        if (loginTf.getText().isEmpty())
        {
            loginTf.setBorder(BorderFactory.createLineBorder(Color.RED));
            isValidado = false;
        }
        if (!validarMatricula())
        {
            isValidado = false;
        }
        if (senhaPf.getPassword().length == 0)
        {
            senhaPf.setBorder(BorderFactory.createLineBorder(Color.RED));
            isValidado = false;
        }
       
        return isValidado;
    }
    
    private boolean validarMatricula()
    {
        boolean isValidado = true;
        if (matriculaTf.getText().isEmpty())
        {
            matriculaTf.setBorder(BorderFactory.createLineBorder(Color.RED));
            isValidado = false;
        }
        else
        {
            try
            {
                usuarioDao.procurarPorMatricula(
                        matriculaTf.getText().trim());
                isValidado = false;
                JOptionPane.showMessageDialog(this, "Matrícula já cadastrada");
            }
            catch (NoResultException nre)
            {
                        
            }
        }
        return isValidado;
    }
    
    private void salvarBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarBtActionPerformed
   
        if (isValidado())
        {
            Usuario usuario = formularioParaObjeto();
            usuarioDao.save(usuario);
            limparFechar();
        }
        else
        {
            JOptionPane.showMessageDialog(this, "Preencha os campos obrigátoris!");
        }
    }//GEN-LAST:event_salvarBtActionPerformed

    private void cancelarBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarBtActionPerformed

        limparFechar();
    }//GEN-LAST:event_cancelarBtActionPerformed

    private void matriculaTfFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_matriculaTfFocusLost
        validarMatricula();
        
    }//GEN-LAST:event_matriculaTfFocusLost

    private void limparFechar()
    {
        restaurarBordas();
        limparCampos();
        this.dispose();
    }
    
    public void limpar()
    {
        restaurarBordas();
        limparCampos();
    }
    
    private void restaurarBordas()
    {
        loginTf.setBorder(BorderFactory.createLineBorder(new Color (127, 157, 185)));
        nomeTf.setBorder(BorderFactory.createLineBorder(new Color (127, 157, 185)));
        senhaPf.setBorder(BorderFactory.createLineBorder(new Color (127, 157, 185)));
        matriculaTf.setBorder(BorderFactory.createLineBorder(new Color (127, 157, 185)));
    }
    private Usuario formularioParaObjeto()
    {
        Usuario usuario = new Usuario();
        usuario.setLogin(loginTf.getText());
        usuario.setMatricula(matriculaTf.getText());
        usuario.setNome(nomeTf.getText());
        usuario.setSenha(new String (senhaPf.getPassword()));
        
        return usuario;
    }
    
    private void limparCampos()
    {
        nomeTf.setText("");
        loginTf.setText("");
        matriculaTf.setText("");
        senhaPf.setText("");
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                UsuarioForm dialog = new UsuarioForm(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {

                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    private UsuarioDao usuarioDao;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton cancelarBt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField loginTf;
    private javax.swing.JTextField matriculaTf;
    private javax.swing.JTextField nomeTf;
    private javax.swing.JButton salvarBt;
    private javax.swing.JPasswordField senhaPf;
    // End of variables declaration//GEN-END:variables
}
