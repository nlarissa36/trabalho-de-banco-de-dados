package com.oftalmo.util;

import java.sql.SQLException;
import java.util.List;

import com.oftalmo.DAO.consultas_medicasDAO;
import com.oftalmo.DAO.especialidadesDAO;
import com.oftalmo.model.consultas_medicas;
import com.oftalmo.model.especialidades;

public class teste_consultas_medicas {

    public static void main(String[] args) throws SQLException {

        consultas_medicasDAO consultas_medicasDAO = new consultas_medicasDAO();
        consultas_medicas consultas_medicas = new consultas_medicas("ABC","123","123");
        

        //count
        System.out.println(consultas_medicasDAO.count());

        //salvar
        consultas_medicasDAO.insertconsultas_medicas(consultas_medicas);

        //buscar por ID
        consultas_medicas = consultas_medicasDAO.selectconsultas_medicas(1);
        System.out.println(consultas_medicas);

        //Update
        consultas_medicas.setdescricao("Pediatra");
        consultas_medicasDAO.updateconsultas_medicas(consultas_medicas);
        consultas_medicas = especialidadesDAO.selectespecialidades(1);
        System.out.println(consultas_medicas);

        //Select all
        List<consultas_medicas> marcas = especialidadesDAO.selectAllespecialidades();
        marcas.forEach(System.out::println);

        //Delete
        consultas_medicasDAO.deleteconsultas_medicas(1);
        consultas_medicasDAO.selectAllconsultas_medicas().forEach(System.out::println);

    }
    
}
