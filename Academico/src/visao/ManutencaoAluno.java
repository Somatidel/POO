/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package visao;

import controledao.ControleAluno;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Aluno;
import modelo.exceptions.NotExistException;

/**
 *
 * @author RaFaEl
 */
public class ManutencaoAluno extends javax.swing.JFrame {

    ControleAluno controle = new ControleAluno();
    List<Aluno> listaAlunos = new ArrayList<>();

    /**
     * Creates new form ManutencaoAluno
     */
    public ManutencaoAluno() {
        initComponents();
        try {
            listaAlunos = controle.getAlunos();
            atualizarTabela();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(
                    this,
                    "Erro no acesso ao banco"
            );
        }
    }

    private void atualizarTabela() {

        DefaultTableModel modelo = (DefaultTableModel) tabAlunos.getModel();

        modelo.setRowCount(0);

        for (Aluno a : listaAlunos) {
            modelo.addRow(new Object[]{
                a.getProntuario(),
                a.getNome(),
                a.getCurso(),
                a.getAnoIngresso()
            });
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabAlunos = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        botIncluir = new javax.swing.JButton();
        botAlterar = new javax.swing.JButton();
        botExcluir = new javax.swing.JButton();
        botVisualizar = new javax.swing.JButton();
        botSair = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(51, 51, 51));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Manutenção de Alunos");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 62, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabAlunos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Prontuario", "Nome", "Curso", "AnoIngresso"
            }
        ));
        jScrollPane1.setViewportView(tabAlunos);

        jPanel2.setBackground(new java.awt.Color(153, 153, 153));
        jPanel2.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        jPanel2.setLayout(new java.awt.GridLayout(1, 0, 5, 0));

        botIncluir.setText("Incluir");
        botIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botIncluirActionPerformed(evt);
            }
        });
        jPanel2.add(botIncluir);

        botAlterar.setText("Alterar");
        botAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botAlterarActionPerformed(evt);
            }
        });
        jPanel2.add(botAlterar);

        botExcluir.setText("Excluir");
        botExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botExcluirActionPerformed(evt);
            }
        });
        jPanel2.add(botExcluir);

        botVisualizar.setText("Visualizar");
        botVisualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botVisualizarActionPerformed(evt);
            }
        });
        jPanel2.add(botVisualizar);

        botSair.setText("Sair");
        botSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botSairActionPerformed(evt);
            }
        });
        jPanel2.add(botSair);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 552, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botIncluirActionPerformed

        DadosAluno tela = new DadosAluno(this, true);
        tela.setVisible(true);
        if (tela.getSalvou()) {
            Aluno a = tela.getAluno();
            try {
                controle.inserir(a);
                listaAlunos = controle.getAlunos();
                atualizarTabela();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(
                        this,
                        "Erro ao acessar o banco"
                );
            } catch (NotExistException ex) {
                JOptionPane.showMessageDialog(
                        this,
                        ex.getMessage()
                );
            }
        }
    }//GEN-LAST:event_botIncluirActionPerformed

    private void botAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botAlterarActionPerformed

        int linha = tabAlunos.getSelectedRow();

        if (linha != -1) {

            DadosAluno tela = new DadosAluno(this, true);
            tela.setAluno(listaAlunos.get(linha));
            tela.setVisible(true);

            try {
                controle.alterar(tela.getAluno());
                listaAlunos = controle.getAlunos();
                atualizarTabela();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(
                        this,
                        "Erro ao acessar o banco"
                );
            } catch (NotExistException ex) {
                JOptionPane.showMessageDialog(
                        this,
                        ex.getMessage()
                );
            }
        } else {
            JOptionPane.showMessageDialog(
                    this,
                    "Selecione uma linha!"
            );
        }
    }//GEN-LAST:event_botAlterarActionPerformed

    private void botExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botExcluirActionPerformed

        int linha = tabAlunos.getSelectedRow();
        if (linha != -1) {
            try {
                controle.remover(listaAlunos.get(linha).getProntuario());
                listaAlunos = controle.getAlunos();
                atualizarTabela();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(
                        this,
                        "Erro no SQL"
                );
            } catch (NotExistException ex) {
                JOptionPane.showMessageDialog(
                        this,
                        ex.getMessage()
                );
            } 
        } else {
            JOptionPane.showMessageDialog(
                    this,
                    "Selecione uma linha!"
            );
        }
    }//GEN-LAST:event_botExcluirActionPerformed

    private void botVisualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botVisualizarActionPerformed

        int linha = tabAlunos.getSelectedRow();
        if (linha != -1) {
            DadosAluno tela = new DadosAluno(this, true);
            tela.setAluno(listaAlunos.get(linha));
            tela.setVisible(true);
        } else {
            JOptionPane.showMessageDialog(
                    this,
                    "Selecione uma linha!"
            );
        }
    }//GEN-LAST:event_botVisualizarActionPerformed

    private void botSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botSairActionPerformed

        dispose();
    }//GEN-LAST:event_botSairActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
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
            java.util.logging.Logger.getLogger(ManutencaoAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ManutencaoAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ManutencaoAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ManutencaoAluno.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ManutencaoAluno().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botAlterar;
    private javax.swing.JButton botExcluir;
    private javax.swing.JButton botIncluir;
    private javax.swing.JButton botSair;
    private javax.swing.JButton botVisualizar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabAlunos;
    // End of variables declaration//GEN-END:variables
}
