package com.tbp.visao;

import com.tbp.excecao.SemSaldoException;
import com.tbp.modelo.*;
import com.tbp.service.ContaService;
import com.tbp.service.Extrato;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class Janela extends javax.swing.JFrame {
    
    private ContaService contaService;
    
    @Autowired 
    public Janela(ContaService contaService) {
        contaService.inicializar();
        this.contaService = contaService;
        initComponents();  
        campoID.setVisible(false);
    }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabPanel = new javax.swing.JTabbedPane();
        abaContas = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        campoBusca = new javax.swing.JTextField();
        painelResultados = new javax.swing.JScrollPane();
        botaoBuscar = new javax.swing.JButton();
        abaMovimentos = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        campoNum = new javax.swing.JTextField();
        campoNome = new javax.swing.JTextField();
        campoBanco = new javax.swing.JTextField();
        campoSaldo = new javax.swing.JTextField();
        botaoSacar = new javax.swing.JButton();
        botaoDepositar = new javax.swing.JButton();
        campoID = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        campoValorMov = new javax.swing.JTextField();
        botaoExtrato = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tabPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabPanelMouseClicked(evt);
            }
        });
        tabPanel.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                tabPanelComponentShown(evt);
            }
        });

        abaContas.addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentAdded(java.awt.event.ContainerEvent evt) {
                abaContasComponentAdded(evt);
            }
        });
        abaContas.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                abaContasFocusGained(evt);
            }
        });
        abaContas.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                abaContasComponentShown(evt);
            }
        });

        jLabel7.setText("Número");

        campoBusca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoBuscaActionPerformed(evt);
            }
        });

        botaoBuscar.setText("Buscar");
        botaoBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout abaContasLayout = new javax.swing.GroupLayout(abaContas);
        abaContas.setLayout(abaContasLayout);
        abaContasLayout.setHorizontalGroup(
            abaContasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(abaContasLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(abaContasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(painelResultados, javax.swing.GroupLayout.PREFERRED_SIZE, 487, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(abaContasLayout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoBusca, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(botaoBuscar)))
                .addContainerGap(112, Short.MAX_VALUE))
        );
        abaContasLayout.setVerticalGroup(
            abaContasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(abaContasLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(abaContasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(campoBusca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoBuscar))
                .addGap(34, 34, 34)
                .addComponent(painelResultados, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(71, Short.MAX_VALUE))
        );

        tabPanel.addTab("Contas", abaContas);

        jLabel8.setText("Num.");

        jLabel9.setText("Nome");

        jLabel10.setText("Banco");

        jLabel11.setText("Saldo");

        campoNum.setEditable(false);

        campoNome.setEditable(false);

        campoBanco.setEditable(false);

        campoSaldo.setEditable(false);

        botaoSacar.setText("Sacar");
        botaoSacar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoSacarActionPerformed(evt);
            }
        });

        botaoDepositar.setText("Depositar");
        botaoDepositar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoDepositarActionPerformed(evt);
            }
        });

        campoID.setEditable(false);

        jLabel12.setText("Valor Mov.");

        botaoExtrato.setText("Extrato");
        botaoExtrato.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoExtratoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout abaMovimentosLayout = new javax.swing.GroupLayout(abaMovimentos);
        abaMovimentos.setLayout(abaMovimentosLayout);
        abaMovimentosLayout.setHorizontalGroup(
            abaMovimentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(abaMovimentosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(abaMovimentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(abaMovimentosLayout.createSequentialGroup()
                        .addGroup(abaMovimentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11))
                        .addGap(24, 24, 24)
                        .addGroup(abaMovimentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(campoSaldo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)
                            .addComponent(campoBanco, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(campoNome, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(campoNum)))
                    .addGroup(abaMovimentosLayout.createSequentialGroup()
                        .addComponent(jLabel12)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoValorMov, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(39, 39, 39)
                .addComponent(campoID, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(124, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, abaMovimentosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botaoExtrato)
                .addGap(18, 18, 18)
                .addComponent(botaoSacar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(botaoDepositar)
                .addGap(154, 154, 154))
        );
        abaMovimentosLayout.setVerticalGroup(
            abaMovimentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(abaMovimentosLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(abaMovimentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(campoNum, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(abaMovimentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(campoNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(abaMovimentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(campoBanco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(abaMovimentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(campoSaldo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(abaMovimentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel12)
                    .addComponent(campoValorMov, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(abaMovimentosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoSacar)
                    .addComponent(botaoDepositar)
                    .addComponent(botaoExtrato))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        tabPanel.addTab("Movimentos", abaMovimentos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(tabPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 640, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabPanel)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tabPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabPanelMouseClicked
        // implementar para preencher a combo empresa no cadastro de funcionario

    }//GEN-LAST:event_tabPanelMouseClicked

    private void campoBuscaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoBuscaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoBuscaActionPerformed

    private void botaoBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoBuscarActionPerformed

        String busca = campoBusca.getText();
        try {
            Integer numeroConta = Integer.parseInt(busca);
            List<Conta> contas = contaService.buscarContaPeloNumero(numeroConta);
            mostrarContasListagem(contas);
        } catch (NumberFormatException e) {
            List<Conta> contas = contaService.listarContas();
            mostrarContasListagem(contas);
        }
       
    }//GEN-LAST:event_botaoBuscarActionPerformed

    private void botaoSacarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSacarActionPerformed
       try {
         Integer idConta = Integer.parseInt(campoID.getText());
         Double valor = Double.parseDouble(campoValorMov.getText());
         Conta conta = contaService.sacar(idConta, valor);    
         configurarTelaMovimento(conta);
       } catch(NumberFormatException e) {
         JOptionPane.showMessageDialog(null, "Valor invalido");
       } catch(SemSaldoException e) {
           JOptionPane.showMessageDialog(null, e.getMessage());
       }
    }//GEN-LAST:event_botaoSacarActionPerformed

    private void abaContasFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_abaContasFocusGained
      
    }//GEN-LAST:event_abaContasFocusGained

    private void botaoDepositarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoDepositarActionPerformed
         try {
         Integer idConta = Integer.parseInt(campoID.getText());
         Double valor = Double.parseDouble(campoValorMov.getText());
         Conta conta = contaService.deposito(idConta, valor);    
         configurarTelaMovimento(conta);
       } catch(NumberFormatException e) {
         JOptionPane.showMessageDialog(null, "Valor invalido");
       }
    }//GEN-LAST:event_botaoDepositarActionPerformed

    private void tabPanelComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_tabPanelComponentShown
        // TODO add your handling code here:
    }//GEN-LAST:event_tabPanelComponentShown

    private void abaContasComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_abaContasComponentShown
        List<Conta> contas = contaService.listarContas();
        mostrarContasListagem(contas);
    }//GEN-LAST:event_abaContasComponentShown

    
    private void mostrarContasListagem(List<Conta> contas) {
        DefaultListModel<Conta> model = new DefaultListModel<>();
        JList<Conta> jList = new JList(model);
        for(Conta conta : contas) {
            model.addElement(conta);
        }
        painelResultados.setViewportView(jList);
        painelResultados.setVisible(true);
        jList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Conta conta = jList.getSelectedValue();
                configurarTelaMovimento(conta);
                tabPanel.setSelectedComponent(abaMovimentos);
     
            }
            
            
        });
    }
    
    private void abaContasComponentAdded(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_abaContasComponentAdded
       
    }//GEN-LAST:event_abaContasComponentAdded

    private void botaoExtratoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoExtratoActionPerformed
        Integer idConta = Integer.parseInt(campoID.getText());
        Extrato extrato = contaService.obterExtratoConta(idConta);
        JOptionPane.showMessageDialog(null, extrato.toString());
    }//GEN-LAST:event_botaoExtratoActionPerformed

    private void configurarTelaMovimento(Conta conta) {
        campoID.setText(conta.getId() + "");
        campoBanco.setText(conta.getBanco());
        campoNum.setText(conta.getNumero() + "");
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(); 
        campoSaldo.setText(numberFormat.format(conta.getSaldo()));

        Pessoa p = contaService.obterPessoaPelaConta(conta.getId());
        campoNome.setText(p.getNome());
                
    } 

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel abaContas;
    private javax.swing.JPanel abaMovimentos;
    private javax.swing.JButton botaoBuscar;
    private javax.swing.JButton botaoDepositar;
    private javax.swing.JButton botaoExtrato;
    private javax.swing.JButton botaoSacar;
    private javax.swing.JTextField campoBanco;
    private javax.swing.JTextField campoBusca;
    private javax.swing.JTextField campoID;
    private javax.swing.JTextField campoNome;
    private javax.swing.JTextField campoNum;
    private javax.swing.JTextField campoSaldo;
    private javax.swing.JTextField campoValorMov;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane painelResultados;
    private javax.swing.JTabbedPane tabPanel;
    // End of variables declaration//GEN-END:variables
}
