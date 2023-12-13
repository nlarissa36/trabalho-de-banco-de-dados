package com.oftalmo.util;

import java.sql.SQLException;
import java.util.List;

import com.oftalmo.DAO.observacoes_laudosDAO;
import com.oftalmo.model.observacoes_laudos;

public class teste_observacoes_laudos {

    public static void main(String[] args) throws SQLException {

        observacoes_laudosDAO observacoes_laudosDAO = new observacoes_laudosDAO();
        observacoes_laudos observacoes_laudos = new observacoes_laudos("oftalmologista",1);
        

        //count
        System.out.println(observacoes_laudosDAO.count());

        //salvar
        observacoes_laudosDAO.insertobservacoes_laudos(observacoes_laudos);

        //buscar por ID
        observacoes_laudos = observacoes_laudosDAO.selectobservacoes_laudos(1);
        System.out.println(observacoes_laudos);

        //Update
        observacoes_laudos.setdescricao("Pediatra");
        observacoes_laudosDAO.updateobservacoes_laudos(observacoes_laudos);
        observacoes_laudos = observacoes_laudosDAO.selectobservacoes_laudos(1);
        System.out.println(observacoes_laudos);

        //Select all
        List<observacoes_laudos> marcas = observacoes_laudosDAO.selectAllobservacoes_laudos();
        marcas.forEach(System.out::println);

        //Delete
        observacoes_laudosDAO.deleteobservacoes_laudos(1);
        observacoes_laudosDAO.selectAllobservacoes_laudos().forEach(System.out::println);

    }
    
}
