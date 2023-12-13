package com.oftalmo.util;

import java.sql.SQLException;
import java.util.List;

import com.oftalmo.DAO.estruturas_lentesDAO;
import com.oftalmo.model.estruturas_lentes;

public class teste_estruturas_lentes {

    public static void main(String[] args) throws SQLException {

        estruturas_lentesDAO estruturas_lentesDAO = new estruturas_lentesDAO();
        estruturas_lentes estruturas_lentes = new estruturas_lentes("oftalmologista",1,1);
        

        //count
        System.out.println(estruturas_lentesDAO.count());

        //salvar
        estruturas_lentesDAO.insertestruturas_lentes(estruturas_lentes);

        //buscar por ID
        estruturas_lentes = estruturas_lentesDAO.selectestruturas_lentes(1);
        System.out.println(estruturas_lentes);

        //Update
        estruturas_lentes.settipo_correcao("Pediatra");
        estruturas_lentesDAO.updateestruturas_lentes(estruturas_lentes);
        estruturas_lentes = estruturas_lentesDAO.selectestruturas_lentes(1);
        System.out.println(estruturas_lentes);

        //Select all
        List<estruturas_lentes> marcas = estruturas_lentesDAO.selectAllestruturas_lentes();
        marcas.forEach(System.out::println);

        //Delete
        estruturas_lentesDAO.deleteestruturas_lentes(1);
        estruturas_lentesDAO.selectAllestruturas_lentes().forEach(System.out::println);

    }
    
}
