package services;

import DAO.cidadeDAO;
import model.cidade;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CidadeService extends cidadeDAO {
    static cidadeDAO cidade = new cidadeDAO();
    public static void GET(){
        List<cidade> cidades = cidade.selectAllCidade();
        List<String> lista = new ArrayList<>();
        System.out.println("CIDADES: \n");
        for (int i = 0; i < cidades.size(); i++) {
            cidade.selectCidadeUf(cidades.get(i).getId_uf(), lista);
            System.out.println(cidades.get(i).getDescricao() + " - código: " + cidades.get(i).getCodigo() + " - " + lista.get(0));
            lista.clear();
        }
    }
    public static void GET_BY_ID(int id){
        cidade cid = cidade.selectCidade(id);
        if(cid == null){
            System.out.println("O id inserido não existe!");
            return;
        }
        List<String> lista = new ArrayList<>();
        System.out.println("CIDADE: \n");
        cidade.selectCidadeUf(cid.getId_uf(), lista);
        System.out.println(cid.getDescricao() + " - código: " + cid.getCodigo() + " - " + lista.get(0));
        lista.clear();
    }
    public static void POST(String descricao, Integer codigo, Integer iduf){
        if (descricao.isEmpty()){
            System.out.println("Descrição não pode estar vazia!");
            return;
        }
        if(descricao.length() < 2){
            System.out.println("Digite uma descrição válida com tamanho maior que 2");
            return;
        }
        if (codigo == 0 || iduf == 0){
            System.out.println("O código/iduf não pode ser 0!");
            return;
        }
        cidade entidade = new cidade(descricao, codigo, iduf);
        cidade.insertCidade(entidade);
    }

    public static void DELETE(int id){
        cidade cid = cidade.selectCidade(id);
        if(cid == null){
            System.out.println("O id inserido não existe!");
            return;
        }
        Boolean delete = cidade.deleteCidade(id);
        if(delete == true){
            System.out.println("Item excluído com sucesso!");
            return;
        }
    }

    public static void PUT(String descricao, Integer codigo, Integer iduf, Integer id){
        if(descricao == null | codigo == null | iduf == null){
            System.out.println("Não insira valores nulos!");
            return;
        }
        if (descricao.isEmpty()){
            System.out.println("Descrição não pode estar vazia!");
            return;
        }
        if(descricao.length() < 2){
            System.out.println("Digite uma descrição válida com tamanho maior que 2");
            return;
        }
        if (codigo == 0 | iduf == 0){
            System.out.println("O código/iduf não pode ser 0!");
            return;
        }
        cidade cid = cidade.selectCidade(id);
        if(cid == null){
            System.out.println("O id inserido não existe!");
            return;
        }

        cidade.verificaInsertIgual(descricao);
        cidade entidade = new cidade(descricao, codigo, iduf);
        cidade.updateCidade(entidade, id);

    }

}
