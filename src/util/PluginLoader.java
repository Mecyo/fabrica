/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import main.AbstractFactoryCar;

/**
 *
 * @author Emerson
 */
public class PluginLoader {
    private static PluginLoader instance = null;
    private String[] plugins;
    private URLClassLoader ulc;
    private URL[] jars;
    private List<Class> listaPlugins;

    
    private PluginLoader() {
        super();
    }
    
    public static PluginLoader getInstance() {
        if(instance == null) {
            instance = new PluginLoader();
        }
        return instance;
    }
    
    public List<String> pluginRefresh(String path) {
        listaPlugins = new ArrayList<>();
        List<String> retorno = new ArrayList<>();
        retorno.add("Atualizando plugins....");
        File currentDir = new File(path);
        plugins = currentDir.list();
        jars = new URL[plugins.length];
        List<String> listaFactory = new ArrayList<>();
        int index = 0;
        for (String itemSelect : plugins) {
            itemSelect = itemSelect.split("\\.")[0];
            listaFactory.add(itemSelect);
            try {
                jars[index++] = (new File("./plugins/" + itemSelect + ".jar")).toURL();
            } catch (MalformedURLException ex) {
                Logger.getLogger(AbstractFactoryCar.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        ulc = new URLClassLoader(jars);
        for (String factoryName : listaFactory) {
            try {
                Class plugin = Class.forName(factoryName.toLowerCase() + "." + factoryName, true, ulc); 
                this.listaPlugins.add(plugin);
                retorno.add("O plugin " + factoryName + " foi adicionado com sucesso!");
            } catch (ClassNotFoundException ex) {
                if(factoryName.contains("Prototype")) {
                    carregarPrototypes();
                } else {
                    retorno.add("O plugin " + factoryName + " é desconhecido e não foi adicionado!");
                }
            }
        }
        return retorno;
    }
    
    public Object carregarClasse(String pacote, String nome) {
        Object plugin = null;
        try {
            plugin = Class.forName(pacote + "." + nome, true, ulc).newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            Logger.getLogger(PluginLoader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return plugin;
    }
    
    public List<Class> carregarPrototypes() {
        File prototypes = new File("./plugins/prototypes.jar");
        List<Class> listaClassPrototypes = new ArrayList<>();
        
        ZipFile zipFile = null;
        try {
            zipFile = new ZipFile(prototypes);
        } catch (IOException ex) {
            Logger.getLogger(AbstractFactoryCar.class.getName()).log(Level.SEVERE, null, ex);
        }
        Enumeration<? extends ZipEntry> entries = zipFile.entries();
        Class pluginPrototype = null;
        while (entries.hasMoreElements()) {
            ZipEntry zipEntry = (ZipEntry) entries.nextElement();
            String name = zipEntry.getName();
            if (!zipEntry.isDirectory() && name.contains("prototypes")){
                try { 
                    listaClassPrototypes.add(Class.forName(name.split("\\.")[0].replace('/', '.'), true, ulc));
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(AbstractFactoryCar.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
        return listaClassPrototypes;
    }
    
    public String[] getModelSelect(List<Class> lista, Boolean usarSelecione) {
        String[] modelList = new String[lista.size() + 1];
        if(usarSelecione) {
            modelList[0] = "SELECIONE";
        }
        for (int i = 1; i <= lista.size(); i++) {
            modelList[i] = lista.get(i-1).getSimpleName();
        }
        return modelList;
    }
    
    /*private void atualizarFactory() {
        int qtdeFactoryCarro = comboTipoCarro.getItemCount();
        int qtdeCreator = comboTipoGaragem.getItemCount();
        if(qtdeFactoryCarro > 0) {
            qtdeFactoryCarro--;
        }
        if(qtdeCreator > 0) {
            qtdeCreator--;
        }
        if(verificarNovosPlugins(qtdeFactoryCarro + qtdeCreator)) {
            append("Atualizando plugins...");
            refreshFactory();
        } else {
            append("Não há novos plugins.");
        }    
    }*/
    
    public List<Class> getListaPlugins() {
        return listaPlugins;
    }
}
