package com.oftalmo.util;

import java.sql.SQLException;
import java.sql.Date;
import java.util.List;


import com.oftalmo.DAO.pacientesDAO;
import com.oftalmo.model.pacientes;

public class teste_pacientes {

    public static void main(String[] args) throws SQLException {

        pacientesDAO pacientesDAO = new pacientesDAO();
        pacientes pacientes = new pacientes("oftalmologista","CBO",Date.valueOf("2023-02-27"));
        

        //count
        System.out.println(pacientesDAO.count());

        //salvar
        pacientesDAO.insertpacientes(pacientes);

        //buscar por ID
        pacientes = pacientesDAO.selectpacientes(1);
        System.out.println(pacientes);

        //Update
        pacientes.setnome("Pediatra");
        pacientesDAO.updatepacientes(pacientes);
        pacientes = pacientesDAO.selectpacientes(1);
        System.out.println(pacientes);

        //Select all
        List<pacientes> marcas = pacientesDAO.selectAllpacientes();
        marcas.forEach(System.out::println);

        //Delete
        pacientesDAO.deletepacientes(1);
        pacientesDAO.selectAllpacientes().forEach(System.out::println);

    }
    
}
