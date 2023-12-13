package main;


import java.sql.Date;
import java.sql.Timestamp;
import java.time.Instant;

import DAO.ClienteDAO;
import DAO.EmpresaDAO;
import DAO.EnderecoDAO;
import DAO.ItemOrdemServicoDAO;
import DAO.OrdemServicoDAO;
import model.*;

import services.*;

public class Main {
    public static void main(String[] args) {
        Endereco endereco = new Endereco("rio negro", "casapio", "1311", "61621200", 1);
        EnderecoDAO end = new EnderecoDAO();

        EmpresaDAO e = new EmpresaDAO();
        Empresa em = new Empresa("cagece", "123234442321", "hoje é o amanhã de ontem", 4);

        ClienteDAO c = new ClienteDAO();
        Date D = new Date(10);
        Cliente cl = new Cliente("marcos", D, "13443444", "adadadadada", 4);


        OrdemServicoDAO o = new OrdemServicoDAO();
        Timestamp ts = Timestamp.from(Instant.now());
        OrdemServico os = new OrdemServico("dsadsadsadsadsa", ts, null, "jppn", 1, 2);

        ItemOrdemServico i = new ItemOrdemServico("descripcao", 2.3423, 1);
        ItemOrdemServicoDAO io = new ItemOrdemServicoDAO();

        // io.insertItemOrdemServico(i);
        // System.out.println(io.selectAllItemOrdemServico());



        // o.insertOrdemServico(os);
        // System.out.println(o.selectAllOrdemServico());


        // c.insertCliente(cl);
        // System.out.println(c.selectAllCliente());


        // e.insertEmpresa(em);
        // System.out.println(e.selectAllEmpresa());




        //CidadeService.GET();
        //CidadeService.POST("icarai", 15, 11);
        //CidadeService.GET_BY_ID(11);
        //CidadeService.DELETE(12);
        //CidadeService.PUT("CACHOEIRA", 43, 13, 1);
    }
}
