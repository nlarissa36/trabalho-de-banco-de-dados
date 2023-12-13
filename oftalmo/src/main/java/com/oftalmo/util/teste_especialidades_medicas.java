package com.oftalmo.util;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import com.oftalmo.DAO.especialidades_medicasDAO;
import com.oftalmo.model.especialidades_medicas;

public class teste_especialidades_medicas {

    public static void main(String[] args) throws SQLException {

        especialidades_medicasDAO especialidades_medicasDAO = new especialidades_medicasDAO();
        especialidades_medicas especialidades_medicas = new especialidades_medicas("oftalmologista",Date.valueOf("2023-12-12"),1,1);
        

        //count
        System.out.println(especialidades_medicasDAO.count());

        //salvar
        especialidades_medicasDAO.insertespecialidades_medicas(especialidades_medicas);

        //buscar por ID
        especialidades_medicas = especialidades_medicasDAO.selectespecialidades_medicas(1);
        System.out.println(especialidades_medicas);

        //Update
        especialidades_medicas.setobservacao("Pediatra");
        especialidades_medicasDAO.updateespecialidades_medicas(especialidades_medicas);
        especialidades_medicas = especialidades_medicasDAO.selectespecialidades_medicas(1);
        System.out.println(especialidades_medicas);

        //Select all
        List<especialidades_medicas> marcas = especialidades_medicasDAO.selectAllespecialidades_medicas();
        marcas.forEach(System.out::println);

        //Delete
        especialidades_medicasDAO.deleteespecialidades_medicas(1);
        especialidades_medicasDAO.selectAllespecialidades_medicas().forEach(System.out::println);

    }
    
}
