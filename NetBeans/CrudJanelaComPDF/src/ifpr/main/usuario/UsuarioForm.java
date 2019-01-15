/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * UsuarioForm.java
 *
 * Created on 09/10/2014, 08:52:37
 */
package ifpr.main.usuario;

import ifpr.usuario.Usuario;
import ifpr.usuario.dao.UsuarioDao;
import ifpr.usuario.dao.UsuarioDaoImpl;
import java.awt.Color;
import java.awt.HeadlessException;
import javax.persistence.NoResultException;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JOptionPane;

/**
 *
 * @author ifpr
 */
public class UsuarioForm extends javax.swing.JDialog {

    /** Creates new form UsuarioForm */
    public UsuarioForm(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        usuarioDao = new UsuarioDaoImpl();
        initComponents();

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nomeTf = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        loginTf = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        matriculaTf = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        senhaPf = new javax.swing.JPasswordField();
        jLabel6 = new javax.swing.JLabel();
        cancelarBt = new javax.swing.JButton();
        salvarBt = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Formulário do Usuário");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18));
        jLabel1.setText("Dados do Usuário");

        jLabel2.setText("Nome *:");

        nomeTf.setToolTipText("Digite o nome");
        nomeTf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomeTfActionPerformed(evt);
            }
        });

        jLabel3.setText("Login *:");

        loginTf.setToolTipText("Digite o login");

        jLabel4.setText("Matrícula:*");

        matriculaTf.setToolTipText("Digite a matrícula");
        matriculaTf.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                matriculaTfFocusLost(evt);
            }
        });

        jLabel5.setText("Senha *:");

        senhaPf.setToolTipText("Digite a senha");

        jLabel6.setText("* - Campos de preenchimento obrigatório");

        cancelarBt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resourses/button_cancel.png"))); // NOI18N
        cancelarBt.setText("Cancelar");
        cancelarBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarBtActionPerformed(evt);
            }
        });

        salvarBt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resourses/filesave.png"))); // NOI18N
        salvarBt.setText("Salvar");
        salvarBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvarBtActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(nomeTf, javax.swing.GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE)
                            .addComponent(jLabel3)
                            .addComponent(loginTf, javax.swing.GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE)
                            .addComponent(jLabel4)
                            .addComponent(matriculaTf, javax.swing.GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE)
                            .addComponent(jLabel5)
                            .addComponent(senhaPf, javax.swing.GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(salvarBt)
                                .addGap(18, 18, 18)
                                .addComponent(cancelarBt)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addGap(20, 20, 20))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(salvarBt, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cancelarBt))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void nomeTfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomeTfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomeTfActionPerformed

    private void salvarBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarBtActionPerformed
        if (isValidado()) {
            formToObject();
            salvarOuAtualizar();
            limparFechar();


        } else {
            JOptionPane.showMessageDialog(this, "Preencha os campos obrigatórios.");
        }

    }//GEN-LAST:event_salvarBtActionPerformed
    private void salvarOuAtualizar(){
        if (usuario.getId() > 0) {
                usuarioDao.update(usuario);
            } else {
                usuarioDao.save(usuario);
            }
    }
    
    private void formToObject() {
        usuario.setLogin(loginTf.getText());
        usuario.setNome(nomeTf.getText());
        usuario.setMatricula(matriculaTf.getText());
        usuario.setSenha(new String(senhaPf.getPassword()));

    }

    private void cancelarBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarBtActionPerformed
        limparFechar();

    }//GEN-LAST:event_cancelarBtActionPerformed

    private void matriculaTfFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_matriculaTfFocusLost
        validarMatricula();
    }//GEN-LAST:event_matriculaTfFocusLost

    private boolean isValidado() {
        boolean isValidado = true;
        if (nomeTf.getText().isEmpty()) {
            isValidado = false;
            setBordaVermelha(nomeTf);
        }
        if (loginTf.getText().isEmpty()) {
            isValidado = false;
            setBordaVermelha(loginTf);
        }
        if (!validarMatricula()) {
            isValidado = false;
        }

        if (senhaPf.getPassword().length == 0) {
            isValidado = false;
            setBordaVermelha(senhaPf);
        }
        return isValidado;
    }

    private void setBordaVermelha(JComponent campo){
        campo.setBorder(BorderFactory.createLineBorder(Color.RED));
    }
    private void setBordaNormal(JComponent campo){
        campo.setBorder(BorderFactory.createLineBorder(new Color(127, 157, 185)));
    }
    
    private boolean validarMatricula() {
        boolean isValidado = true;
        if (matriculaTf.getText().isEmpty()) {
            isValidado = false;
            setBordaVermelha(matriculaTf);
        } else {
            if (!usuario.getMatricula().equals(matriculaTf.getText().trim())) {
                try {
                    usuarioDao.procurarPorMatricula(matriculaTf.getText().trim());
                    isValidado = false;
                    setBordaVermelha(matriculaTf);
                    JOptionPane.showMessageDialog(this, "Matrícula já cadastrada");
                } catch (NoResultException nre) {
                    setBordaNormal(matriculaTf);
                }

            }


        }
        return isValidado;
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

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void objectToForm() {
        nomeTf.setText(usuario.getNome());
        loginTf.setText(usuario.getLogin());
        matriculaTf.setText(usuario.getMatricula());
        senhaPf.setText(usuario.getSenha());
    }
    private Usuario usuario;
    private UsuarioDao usuarioDao;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancelarBt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField loginTf;
    private javax.swing.JTextField matriculaTf;
    private javax.swing.JTextField nomeTf;
    private javax.swing.JButton salvarBt;
    private javax.swing.JPasswordField senhaPf;
    // End of variables declaration//GEN-END:variables

    private void limparFechar() {

        restaurarBordas();
        limparCampos();
        this.dispose();
    }

    private void restaurarBordas() {
        setBordaNormal(loginTf);
        setBordaNormal(nomeTf);
        setBordaNormal(matriculaTf);
        setBordaNormal(senhaPf);
    }

    private void limparCampos() {
        nomeTf.setText("");
        loginTf.setText("");
        matriculaTf.setText("");
        senhaPf.setText("");
    }

    public void limpar() {
        restaurarBordas();
        limparCampos();
    }
}
