/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * JanelaPrincipal.java
 *
 * Created on 06/11/2014, 10:01:23
 */

package ifpr;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author ifpr
 */
public class JanelaPrincipal extends javax.swing.JFrame {

    /** Creates new form JanelaPrincipal */
    public JanelaPrincipal() {
        initComponents();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelPrincipal = new javax.swing.JPanel();
        abrirBt = new javax.swing.JButton();
        salvarComoBt = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        abrirBt.setText("Abrir");
        abrirBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                abrirBtActionPerformed(evt);
            }
        });

        salvarComoBt.setText("Salvar como");
        salvarComoBt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                salvarComoBtActionPerformed(evt);
            }
        });

        org.jdesktop.layout.GroupLayout painelPrincipalLayout = new org.jdesktop.layout.GroupLayout(painelPrincipal);
        painelPrincipal.setLayout(painelPrincipalLayout);
        painelPrincipalLayout.setHorizontalGroup(
            painelPrincipalLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(painelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .add(painelPrincipalLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(painelPrincipalLayout.createSequentialGroup()
                        .add(abrirBt)
                        .add(18, 18, 18)
                        .add(salvarComoBt)
                        .addContainerGap(186, Short.MAX_VALUE))
                    .add(painelPrincipalLayout.createSequentialGroup()
                        .add(jLabel1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(390, 390, 390))))
        );

        painelPrincipalLayout.linkSize(new java.awt.Component[] {abrirBt, salvarComoBt}, org.jdesktop.layout.GroupLayout.HORIZONTAL);

        painelPrincipalLayout.setVerticalGroup(
            painelPrincipalLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(painelPrincipalLayout.createSequentialGroup()
                .addContainerGap()
                .add(painelPrincipalLayout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(abrirBt)
                    .add(salvarComoBt))
                .add(18, 18, 18)
                .add(jLabel1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 31, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(217, Short.MAX_VALUE))
        );

        painelPrincipalLayout.linkSize(new java.awt.Component[] {abrirBt, salvarComoBt}, org.jdesktop.layout.GroupLayout.VERTICAL);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(painelPrincipal, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(org.jdesktop.layout.GroupLayout.TRAILING, painelPrincipal, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void abrirBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_abrirBtActionPerformed
        
        abrirDocumento();
        
    }//GEN-LAST:event_abrirBtActionPerformed

    private void salvarComoBtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_salvarComoBtActionPerformed
        
        salvarDocumento();
        
    }//GEN-LAST:event_salvarComoBtActionPerformed

    public static void main(String args[]) 
    {
        java.awt.EventQueue.invokeLater(new Runnable() 
        {
            public void run() 
            {
                new JanelaPrincipal().setVisible(true);
            }
        });
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton abrirBt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel painelPrincipal;
    private javax.swing.JButton salvarComoBt;
    // End of variables declaration//GEN-END:variables

    private void abrirDocumento() 
    {
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
        ".txt", "txt");
    
        chooser.setFileFilter(filter);
    
        try
        {
            int returnVal = chooser.showOpenDialog(abrirBt);
    
            if(returnVal == JFileChooser.APPROVE_OPTION) 
            {
                File arquivo = chooser.getSelectedFile();
                
                
                FileReader fileReader = new FileReader(arquivo);
                BufferedReader bufR = new BufferedReader(fileReader);
                String texto = "";
                
                while ((texto = bufR.readLine()) != null)
                {
                    System.out.print(texto);
                }
                
            }
        } catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    private void salvarDocumento() 
    {
        JFileChooser chooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter(
        ".txt", "txt");
        
        chooser.setAcceptAllFileFilterUsed(true);
        try 
        {
            int returnVal = chooser.showOpenDialog(salvarComoBt);
            
            if(returnVal == JFileChooser.APPROVE_OPTION) 
            {
                File arquivo = chooser.getSelectedFile();
                FileWriter escritor = new FileWriter(arquivo);
                BufferedWriter bufW = new BufferedWriter(escritor);
                bufW.append("deucertooooo!");
                bufW.flush();
                bufW.close();
                
            }
        } catch (Exception e) 
        {
            
        }
    }
}
