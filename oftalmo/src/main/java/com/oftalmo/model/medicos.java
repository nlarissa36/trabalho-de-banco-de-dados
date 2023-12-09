package com.oftalmo.model;

public class medicos extends generic_model{
    
    private String nome;
    private String crm;

    public medicos(String nome, String crm){
        this.nome = nome;
        this.crm = crm;
    }

     public medicos(String nome, String crm, int id){
        this.nome = nome;
        this.crm = crm;
        super.setId(id);
    }

    public String getnome() {
        return nome;
    }

    public void setnome(String nome) {
        this.nome = nome;
    }

    public String getcrm() {
        return crm;
    }

    public void setcrm(String crm) {
        this.crm = crm;
    }

    @Override
    public String toString() {
        return String.format("Medicos {id = %d, nome = %s, crm = %s}", this.getId(), nome, crm);
    }

}
