package com.oftalmo.util;

import java.sql.SQLException;
import java.util.List;

import com.oftalmo.DAO.especificacoes_lenteDAO;
import com.oftalmo.model.especificacoes_lente;

public class teste_especificacoes_lente {

    public static void main(String[] args) throws SQLException {

        especificacoes_lenteDAO especificacoes_lenteDAO = new especificacoes_lenteDAO();
        especificacoes_lente especificacoes_lente = new especificacoes_lente(1,1,1);
        

        //count
        System.out.println(especificacoes_lenteDAO.count());

        //salvar
        especificacoes_lenteDAO.insertespecificacoes_lente(especificacoes_lente);

        //buscar por ID
        especificacoes_lente = especificacoes_lenteDAO.selectespecificacoes_lente(1);
        System.out.println(especificacoes_lente);

        //Update
        especificacoes_lente.setvalor(1);
        especificacoes_lenteDAO.updateespecificacoes_lente(especificacoes_lente);
        especificacoes_lente = especificacoes_lenteDAO.selectespecificacoes_lente(1);
        System.out.println(especificacoes_lente);

        //Select all
        List<especificacoes_lente> marcas = especificacoes_lenteDAO.selectAllespecificacoes_lente();
        marcas.forEach(System.out::println);

        //Delete
        especificacoes_lenteDAO.deleteespecificacoes_lente(1);
        especificacoes_lenteDAO.selectAllespecificacoes_lente().forEach(System.out::println);

    }
    
}
