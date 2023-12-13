package com.oftalmo.model;

public class observacoes_laudos extends generic_model{
    
    private String descricao;
    private Integer id_receita_oculos;

    public observacoes_laudos(String descricao, Integer id_receita_oculos){
        this.descricao = descricao;
        this.id_receita_oculos = id_receita_oculos;
    }

     public observacoes_laudos(String descricao, Integer id_receita_oculos, int id){
        this.descricao = descricao;
        this.id_receita_oculos = id_receita_oculos;
        super.setId(id);
    }

    public String getdescricao() {
        return descricao;
    }

    public void setdescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getid_receita_oculos() {
        return id_receita_oculos;
    }

    public void setid_receita_oculos(Integer id_receita_oculos) {
        this.id_receita_oculos = id_receita_oculos;
    }

    @Override
    public String toString() {
        return String.format("Observacao Laudo {id = %d, descricao = %s, id_receita_oculos = %d}", this.getId(), descricao, id_receita_oculos);
    }
}
