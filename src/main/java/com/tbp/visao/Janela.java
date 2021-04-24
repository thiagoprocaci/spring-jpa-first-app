package com.tbp.visao;

import com.tbp.modelo.*;
import com.tbp.repository.*;
import com.tbp.service.PizzaService;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class Janela extends javax.swing.JFrame {
    
    
   private PizzaService pizzaService;
        
           
    @Autowired
    public Janela( PizzaService pizzaService) {
        this.pizzaService = pizzaService;
        this.pizzaService.inicializar();
        initComponents();  
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
        abaCadastroEmpresa = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        nomePizza = new javax.swing.JTextField();
        precoPizza = new javax.swing.JTextField();
        botaoSalvarPizza = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        ingredientesPizza = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tabPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabPanelMouseClicked(evt);
            }
        });

        jLabel1.setText("Ingredientes");

        jLabel2.setText("Nome:");

        nomePizza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nomePizzaActionPerformed(evt);
            }
        });

        precoPizza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                precoPizzaActionPerformed(evt);
            }
        });

        botaoSalvarPizza.setText("Salvar");
        botaoSalvarPizza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoSalvarPizzaActionPerformed(evt);
            }
        });

        jLabel13.setText("Preço");

        ingredientesPizza.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ingredientesPizzaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout abaCadastroEmpresaLayout = new javax.swing.GroupLayout(abaCadastroEmpresa);
        abaCadastroEmpresa.setLayout(abaCadastroEmpresaLayout);
        abaCadastroEmpresaLayout.setHorizontalGroup(
            abaCadastroEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(abaCadastroEmpresaLayout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(abaCadastroEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(abaCadastroEmpresaLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ingredientesPizza, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 126, Short.MAX_VALUE)
                        .addComponent(botaoSalvarPizza)
                        .addGap(80, 80, 80))
                    .addGroup(abaCadastroEmpresaLayout.createSequentialGroup()
                        .addGroup(abaCadastroEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel13))
                        .addGap(47, 47, 47)
                        .addGroup(abaCadastroEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(precoPizza, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(nomePizza, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        abaCadastroEmpresaLayout.setVerticalGroup(
            abaCadastroEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(abaCadastroEmpresaLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addGroup(abaCadastroEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(nomePizza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(abaCadastroEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(precoPizza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13))
                .addGroup(abaCadastroEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(abaCadastroEmpresaLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(botaoSalvarPizza))
                    .addGroup(abaCadastroEmpresaLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(abaCadastroEmpresaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(ingredientesPizza, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(138, Short.MAX_VALUE))
        );

        tabPanel.addTab("Cadastro Pizza", abaCadastroEmpresa);

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

    private void ingredientesPizzaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ingredientesPizzaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ingredientesPizzaActionPerformed

    private void botaoSalvarPizzaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoSalvarPizzaActionPerformed
        String nome = nomePizza.getText();
        Double preco = Double.parseDouble(precoPizza.getText());
        String[] ingredientes = ingredientesPizza.getText().split(";");
        List<Composicao> composicaoList = pizzaService.salvarPizza(nome, preco, ingredientes);
        StringBuffer mensagem = new StringBuffer();
        mensagem.append(composicaoList.get(0).getPizza().getNome());
        mensagem.append("\n");
        for(Composicao c : composicaoList) {
            mensagem.append(c.getIngrediente().getNome());
            mensagem.append("\n");

        }
        JOptionPane.showMessageDialog(null, mensagem);
    }//GEN-LAST:event_botaoSalvarPizzaActionPerformed

    private void precoPizzaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_precoPizzaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_precoPizzaActionPerformed

    private void nomePizzaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nomePizzaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nomePizzaActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel abaCadastroEmpresa;
    private javax.swing.JButton botaoSalvarPizza;
    private javax.swing.JTextField ingredientesPizza;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JTextField nomePizza;
    private javax.swing.JTextField precoPizza;
    private javax.swing.JTabbedPane tabPanel;
    // End of variables declaration//GEN-END:variables
}
