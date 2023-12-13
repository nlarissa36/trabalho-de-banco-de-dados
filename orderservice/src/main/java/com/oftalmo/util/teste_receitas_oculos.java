package com.oftalmo.util;

import java.sql.SQLException;
import java.util.List;
import java.sql.Date;

import com.oftalmo.DAO.receitas_oculosDAO;
import com.oftalmo.model.receitas_oculos;

public class teste_receitas_oculos {

    public static void main(String[] args) throws SQLException {

        receitas_oculosDAO receitas_oculosDAO = new receitas_oculosDAO();
        receitas_oculos receitas_oculos = new receitas_oculos("oftalmologista", Date.valueOf("2023-02-27"),1);
        

        //count
        System.out.println(receitas_oculosDAO.count());

        //salvar
        receitas_oculosDAO.insertreceitas_oculos(receitas_oculos);

        //buscar por ID
        receitas_oculos = receitas_oculosDAO.selectreceitas_oculos(1);
        System.out.println(receitas_oculos);

        //Update
        receitas_oculos.setdetalhamento("Pediatra");
        receitas_oculosDAO.updatereceitas_oculos(receitas_oculos);
        receitas_oculos = receitas_oculosDAO.selectreceitas_oculos(1);
        System.out.println(receitas_oculos);

        //Select all
        List<receitas_oculos> marcas = receitas_oculosDAO.selectAllreceitas_oculos();
        marcas.forEach(System.out::println);

        //Delete
        receitas_oculosDAO.deletereceitas_oculos(1);
        receitas_oculosDAO.selectAllreceitas_oculos().forEach(System.out::println);

    }
    
}
