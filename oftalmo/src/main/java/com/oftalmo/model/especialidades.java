package com.oftalmo.model;

public class especialidades extends generic_model{
    
    private String descricao;
    private String conselho;

    public especialidades(String descricao, String conselho){
        this.descricao = descricao;
        this.conselho = conselho;
    }

     public especialidades(String descricao, String conselho, int id){
        this.descricao = descricao;
        this.conselho = conselho;
        super.setId(id);
    }

    public String getdescricao() {
        return descricao;
    }

    public void setdescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getconselho() {
        return conselho;
    }

    public void setconselho(String conselho) {
        this.conselho = conselho;
    }

    @Override
    public String toString() {
        return String.format("Especialidade {id = %d, descricao = %s, conselho = %s}", this.getId(), descricao, conselho);
    }

}
