package com.oftalmo.util;

import java.sql.SQLException;
import java.util.List;

import com.oftalmo.DAO.especialidadesDAO;
import com.oftalmo.model.especialidades;

public class teste_especialidades {

    public static void main(String[] args) throws SQLException {

        especialidadesDAO especialidadesDAO = new especialidadesDAO();
        especialidades especialidades = new especialidades("oftalmologista","CBO");
        

        //count
        System.out.println(especialidadesDAO.count());

        //salvar
        especialidadesDAO.insertespecialidades(especialidades);

        //buscar por ID
        especialidades = especialidadesDAO.selectespecialidades(1);
        System.out.println(especialidades);

        //Update
        especialidades.setdescricao("Pediatra");
        especialidadesDAO.updateespecialidades(especialidades);
        especialidades = especialidadesDAO.selectespecialidades(1);
        System.out.println(especialidades);

        //Select all
        List<especialidades> marcas = especialidadesDAO.selectAllespecialidades();
        marcas.forEach(System.out::println);

        //Delete
        especialidadesDAO.deleteespecialidades(1);
        especialidadesDAO.selectAllespecialidades().forEach(System.out::println);

    }
    
}
