package main;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import interfaces.Carro;
import interfaces.ICarModelFactory;
import interfaces.ICreator;
import interfaces.IGaragem;
import interfaces.IPrototype;
import interfaces.IRoda;
import interfaces.ISom;
import interfaces.ITeto;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFileChooser;
import util.PluginLoader;

/**
 *
 * @author Emerson
 */
public class AbstractFactoryCar extends javax.swing.JFrame {

    private ICarModelFactory carModel;
    private ICreator creator;
    private IGaragem garagem;
    private ISom som;
    private IRoda roda;
    private ITeto teto;
    private Carro carro;
    private IPrototype prototype;
    private AbstractFactory abstractFactory;
    private String[] modelListPrototypes;
    private Map<String,IPrototype> listaPrototypes = null;
    /**
     * Creates new form AbstractFactoryCar
     */
    public AbstractFactoryCar() {
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

        seletor = new javax.swing.JFileChooser();
        btnCriarCarro = new javax.swing.JButton();
        btnAbrirTeto = new javax.swing.JButton();
        lblTipoCarro = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        display = new javax.swing.JTextArea();
        btnAlinharRoda = new javax.swing.JButton();
        btnTocarSom = new javax.swing.JButton();
        comboTipoCarro = new javax.swing.JComboBox<>();
        btnRefresh = new javax.swing.JButton();
        btnEstacionar = new javax.swing.JButton();
        comboTipoGaragem = new javax.swing.JComboBox<>();
        lblTipoGaragem = new javax.swing.JLabel();
        btnCriarPrototype = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnCriarCarro.setEnabled(false);
        btnCriarCarro.setLabel("Criar Carro");
        btnCriarCarro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCriarCarroActionPerformed(evt);
            }
        });

        btnAbrirTeto.setText("Abrir Teto");
        btnAbrirTeto.setEnabled(false);
        btnAbrirTeto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAbrirTetoActionPerformed(evt);
            }
        });

        lblTipoCarro.setText("Tipo de Carro:");

        display.setColumns(20);
        display.setRows(5);
        jScrollPane1.setViewportView(display);

        btnAlinharRoda.setText("Alinhar Roda");
        btnAlinharRoda.setEnabled(false);
        btnAlinharRoda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAlinharRodaActionPerformed(evt);
            }
        });

        btnTocarSom.setText("Tocar Som");
        btnTocarSom.setEnabled(false);
        btnTocarSom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTocarSomActionPerformed(evt);
            }
        });

        comboTipoCarro.setSelectedItem("SELECIONE");
        comboTipoCarro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboTipoCarroActionPerformed(evt);
            }
        });

        btnRefresh.setText("Plugins Refresh");
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        btnEstacionar.setText("Estacionar");
        btnEstacionar.setEnabled(false);
        btnEstacionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEstacionarActionPerformed(evt);
            }
        });

        comboTipoGaragem.setSelectedItem("SELECIONE");
        comboTipoGaragem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboTipoGaragemActionPerformed(evt);
            }
        });

        lblTipoGaragem.setText("Tipo de Garagem:");

        btnCriarPrototype.setText("Criar Prototype");
        btnCriarPrototype.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCriarPrototypeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 9, Short.MAX_VALUE)
                        .addComponent(lblTipoCarro)
                        .addGap(228, 228, 228)
                        .addComponent(btnCriarCarro))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTipoGaragem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboTipoCarro, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboTipoGaragem, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnEstacionar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(btnTocarSom))
                            .addComponent(btnRefresh))
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnCriarPrototype)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnAbrirTeto)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnAlinharRoda)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTipoCarro)
                    .addComponent(btnCriarCarro)
                    .addComponent(comboTipoCarro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(btnEstacionar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnRefresh)
                            .addComponent(btnCriarPrototype))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTipoGaragem)
                            .addComponent(comboTipoGaragem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(49, 49, 49)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTocarSom)
                    .addComponent(btnAlinharRoda)
                    .addComponent(btnAbrirTeto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCriarCarroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCriarCarroActionPerformed
        String tipoCarro;
        roda = carModel.createRoda();
        som = carModel.createSom();
        teto = carModel.createTeto();
        carro = (Carro) carModel.createCarro();
        habilitarDesabilitarBotoes(true);
        comboTipoGaragem.setEnabled(true);
        tipoCarro = carModel.toString(); 
        append("Novo Carro " + tipoCarro + " criado!");
    }//GEN-LAST:event_btnCriarCarroActionPerformed

    private void btnAbrirTetoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAbrirTetoActionPerformed
        append(carro.abrir());
    }//GEN-LAST:event_btnAbrirTetoActionPerformed

    private void btnAlinharRodaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAlinharRodaActionPerformed
        append(carro.alinhar());
    }//GEN-LAST:event_btnAlinharRodaActionPerformed

    private void btnTocarSomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTocarSomActionPerformed
        append(carro.tocar());
    }//GEN-LAST:event_btnTocarSomActionPerformed

    private void comboTipoCarroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboTipoCarroActionPerformed
        if(comboTipoCarro.getSelectedItem().equals("SELECIONE")) {
            habilitarDesabilitarBotoes(false);
            if(garagem != null) {
                try {
                    garagem = garagem.getClass().newInstance();
                } catch (InstantiationException ex) {
                    Logger.getLogger(AbstractFactoryCar.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(AbstractFactoryCar.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } else {
            String nomeClasse = comboTipoCarro.getSelectedItem().toString();
            String pacote = nomeClasse.toLowerCase();
            carModel = (ICarModelFactory) PluginLoader.getInstance().carregarClasse(pacote, nomeClasse);
            habilitarDesabilitarBotoes(false);
            btnCriarCarro.setEnabled(true); 
        }  
        display.setText("");
    }//GEN-LAST:event_comboTipoCarroActionPerformed

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
        display.setText("");
        atualizarFactory();
    }//GEN-LAST:event_btnRefreshActionPerformed

    private void comboTipoGaragemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboTipoGaragemActionPerformed
        if(comboTipoGaragem.getSelectedItem().equals("SELECIONE")) {
            garagem = null;
        } else {
            String nomeClasse = comboTipoGaragem.getSelectedItem().toString();
            String pacote = nomeClasse.toLowerCase();
            creator = (ICreator) PluginLoader.getInstance().carregarClasse(pacote, nomeClasse);
            garagem = (IGaragem) creator.criarGaragem(); 
            String nome = garagem.getClass().getName().split("\\.")[1];
            String sufixo = nome.split("Garagem")[1];
            String mensagem = "Garagem " + sufixo + " criada.";
            append(mensagem);
        }  
    }//GEN-LAST:event_comboTipoGaragemActionPerformed

    private void btnEstacionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEstacionarActionPerformed
        if(garagem == null) {
            append("Selecione um tipo de garagem!");
        } else if(garagem.isEstacionado()) {
            append(garagem.estacionar(carro));
        } else {
            append("Carro já estacionado!");
        }
    }//GEN-LAST:event_btnEstacionarActionPerformed

    private void btnCriarPrototypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCriarPrototypeActionPerformed
        this.setVisible(false);
        CreateFactoryPrototype modalCreate = new CreateFactoryPrototype();
        modalCreate.iniciar(this, this.abstractFactory);
        modalCreate.setVisible(true);
    }//GEN-LAST:event_btnCriarPrototypeActionPerformed

    private String selecionarDiretorio() {
        seletor.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY); 
        seletor.showOpenDialog(getParent());
        return seletor.getSelectedFile().getAbsolutePath();
    }
    
    private void append(String texto) {
        display.append("\n" + texto);
    }
    
    public void retornar(IPrototype prototype) {
        this.prototype = prototype;
        this.setVisible(true);
        append("Novo Prototype criado com sucesso!");
    }
    
    private void habilitarDesabilitarBotoes(Boolean bool) {
        btnAbrirTeto.setEnabled(bool);
        btnAlinharRoda.setEnabled(bool);
        btnTocarSom.setEnabled(bool);
        btnCriarCarro.setEnabled(bool);
        btnEstacionar.setEnabled(bool);
    }
    
    public String[] getModelSelectPrototypes() {
        return this.modelListPrototypes;
    }
    
    private void refreshFactory() {
        List<Class> listaFabricas = new ArrayList<>();
        List<Class> listaCreators = new ArrayList<>();
        PluginLoader pluginLoader = PluginLoader.getInstance();
        List<String> listaAvisos = pluginLoader.pluginRefresh(selecionarDiretorio());
        for (String listaAviso : listaAvisos) {
            append(listaAviso);
        }
        List<Class> listaPlugins = pluginLoader.getListaPlugins();
        for (Class plugin : listaPlugins) {
            if(plugin.getTypeName().contains("Factory")) {
                listaFabricas.add(plugin);
            } else if(plugin.getTypeName().contains("creator")) {
                listaCreators.add(plugin);
            } else {
                append("O plugin " + plugin.getClass().getSimpleName() + " é desconhecido e não foi adicionado!");
            }
        }
        comboTipoCarro.setModel(new javax.swing.DefaultComboBoxModel<>(pluginLoader.getModelSelect(listaFabricas, Boolean.TRUE)));
        comboTipoGaragem.setModel(new javax.swing.DefaultComboBoxModel<>(pluginLoader.getModelSelect(listaCreators, Boolean.TRUE)));
    }
    
    private void atualizarFactory() {
        int qtdeFactoryCarro = comboTipoCarro.getItemCount();
        int qtdeCreator = comboTipoGaragem.getItemCount();
        if(qtdeFactoryCarro > 0) {
            qtdeFactoryCarro--;
        }
        if(qtdeCreator > 0) {
            qtdeCreator--;
        }
        append("Atualizando plugins...");
        refreshFactory();
    }
    
    public Object create(String nome) {
        return listaPrototypes.get(nome).clone();
    }
    
    public Boolean adicionar(String nome, IPrototype prototype) {
        Boolean adiciona = Boolean.TRUE;
        if(listaPrototypes == null) {
            listaPrototypes = new HashMap<>();
        }
        if(listaPrototypes.containsValue(prototype)) {
            adiciona = Boolean.FALSE;
        } else {
            listaPrototypes.put(prototype.toString(), prototype);
        }
        return adiciona;
    }
    
    public Boolean remover(IPrototype prototype) {
        Boolean remove = Boolean.TRUE;
        if(listaPrototypes != null) {
            if(listaPrototypes.containsValue(prototype)) {
                remove = Boolean.FALSE;
            } else {
                listaPrototypes.remove(prototype.toString());
            }
        }
        return remove;
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {         
                AbstractFactoryCar app = new AbstractFactoryCar();
                app.setVisible(true);
                app.refreshFactory();
            }
        });
        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAbrirTeto;
    private javax.swing.JButton btnAlinharRoda;
    private javax.swing.JButton btnCriarCarro;
    private javax.swing.JButton btnCriarPrototype;
    private javax.swing.JButton btnEstacionar;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnTocarSom;
    private javax.swing.JComboBox<Object> comboTipoCarro;
    private javax.swing.JComboBox<Object> comboTipoGaragem;
    private javax.swing.JTextArea display;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblTipoCarro;
    private javax.swing.JLabel lblTipoGaragem;
    private javax.swing.JFileChooser seletor;
    // End of variables declaration//GEN-END:variables
}
