package com.oftalmo.model;

import java.sql.Date;

public class pacientes extends generic_model{
    
    private String nome;
    private String cpf;
    private Date dt_nascimento;

    public pacientes(String nome, String cpf, Date dt_nascimento){
        this.nome = nome;
        this.cpf = cpf;
        this.dt_nascimento = dt_nascimento;
    }

     public pacientes(String nome, String cpf, Date dt_nascimento, Integer id){
        this.nome = nome;
        this.cpf = cpf;
        this.dt_nascimento = dt_nascimento;
        super.setId(id);
    }

    public String getnome() {
        return nome;
    }

    public void setnome(String nome) {
        this.nome = nome;
    }

    public String getcpf() {
        return cpf;
    }

    public void setcpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getdt_nascimento() {
        return dt_nascimento;
    }

    public void setdt_nascimento(Date dt_nascimento) {
        this.dt_nascimento = dt_nascimento;
    }

    @Override
    public String toString() {
        return String.format("Pacientes {id = %d, nome = %s, cpf = %s, data_nascimento = %tF}", this.getId(), nome, cpf, dt_nascimento);
    }

}
