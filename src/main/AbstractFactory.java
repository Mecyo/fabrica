/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import interfaces.IPrototype;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Emerson
 */
public class AbstractFactory {
    private Map<String,IPrototype> listaPrototypes = null;
    
    public Object create(String nome) {
        return listaPrototypes.get(nome).clone();
    }
    
    public Boolean adicionar(IPrototype prototype) {
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
}
