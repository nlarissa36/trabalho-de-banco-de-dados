package com.oftalmo.model;

public class atributos_estrutura_lente extends generic_model{
    
    private String descricao;
    private String lado_olho;

    public atributos_estrutura_lente(String descricao, String lado_olho){
        this.descricao = descricao;
        this.lado_olho = lado_olho;
    }

     public atributos_estrutura_lente(String descricao, String lado_olho, int id){
        this.descricao = descricao;
        this.lado_olho = lado_olho;
        super.setId(id);
    }

    public String getdescricao() {
        return descricao;
    }

    public void setdescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getlado_olho() {
        return lado_olho;
    }

    public void setlado_olho(String lado_olho) {
        this.lado_olho = lado_olho;
    }

    @Override
    public String toString() {
        return String.format("Atributos Estrutura Lente {id = %d, descricao = %s, Lado olho = %s}", this.getId(), descricao, lado_olho);
    }

}
