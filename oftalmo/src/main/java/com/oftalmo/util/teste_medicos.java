package com.oftalmo.util;

import java.sql.SQLException;
import java.util.List;

import com.oftalmo.DAO.medicosDAO;
import com.oftalmo.model.medicos;

public class teste_medicos {

    public static void main(String[] args) throws SQLException {

        medicosDAO medicosDAO = new medicosDAO();
        medicos medicos = new medicos("Larissa","123.456");
        

        //count
        System.out.println(medicosDAO.count());

        //salvar
        medicosDAO.insertmedicos(medicos);

        //buscar por ID
        medicos = medicosDAO.selectmedicos(1);
        System.out.println(medicos);

        //Update
        medicos.setnome("Ana Luiza");
        medicosDAO.updatemedicos(medicos);
        medicos = medicosDAO.selectmedicos(1);
        System.out.println(medicos);

        //Select all
        List<medicos> marcas = medicosDAO.selectAllmedicos();
        marcas.forEach(System.out::println);

        //Delete
        medicosDAO.deletemedicos(1);
        medicosDAO.selectAllmedicos().forEach(System.out::println);

    }
    
}
