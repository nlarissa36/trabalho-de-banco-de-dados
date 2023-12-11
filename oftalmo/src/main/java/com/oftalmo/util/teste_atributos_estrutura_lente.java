package com.oftalmo.util;

import java.sql.SQLException;
import java.util.List;

import com.oftalmo.DAO.atributos_estrutura_lenteDAO;
import com.oftalmo.model.atributos_estrutura_lente;

public class teste_atributos_estrutura_lente {

    public static void main(String[] args) throws SQLException {

        atributos_estrutura_lenteDAO atributos_estrutura_lenteDAO = new atributos_estrutura_lenteDAO();
        atributos_estrutura_lente atributos_estrutura_lente = new atributos_estrutura_lente("ABC","Esquerdo");
        

        //count
        System.out.println(atributos_estrutura_lenteDAO.count());

        //salvar
        atributos_estrutura_lenteDAO.insertatributos_estrutura_lente(atributos_estrutura_lente);

        //buscar por ID
        atributos_estrutura_lente = atributos_estrutura_lenteDAO.selectatributos_estrutura_lente(1);
        System.out.println(atributos_estrutura_lente);

        //Update
        atributos_estrutura_lente.setdescricao("Pediatra");
        atributos_estrutura_lenteDAO.updateatributos_estrutura_lente(atributos_estrutura_lente);
        atributos_estrutura_lente = atributos_estrutura_lenteDAO.selectatributos_estrutura_lente(1);
        System.out.println(atributos_estrutura_lente);

        //Select all
        List<atributos_estrutura_lente> marcas = atributos_estrutura_lenteDAO.selectAllatributos_estrutura_lente();
        marcas.forEach(System.out::println);

        //Delete
        atributos_estrutura_lenteDAO.deleteatributos_estrutura_lente(1);
        atributos_estrutura_lenteDAO.selectAllatributos_estrutura_lente().forEach(System.out::println);

    }
    
}
