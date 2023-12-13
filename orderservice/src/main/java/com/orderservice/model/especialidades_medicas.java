package com.oftalmo.model;
import java.sql.Date;

public class especialidades_medicas extends generic_model{
    
    private String observacao;
    private Date dt_conclusao;
    private Integer id_especialidade;
    private Integer id_medico;

    public especialidades_medicas(String observacao, Date dt_conclusao, Integer id_especialidade, Integer id_medico){
        this.observacao = observacao;
        this.dt_conclusao = dt_conclusao;
        this.id_especialidade = id_especialidade;
        this.id_medico = id_medico;
    }

     public especialidades_medicas(String observacao, Date dt_conclusao, Integer id_especialidade, Integer id_medico, Integer id){
        this.observacao = observacao;
        this.dt_conclusao = dt_conclusao;
        this.id_especialidade = id_especialidade;
        this.id_medico = id_medico;
        super.setId(id);
    }

    public String getobservacao() {
        return observacao;
    }

    public void setobservacao(String observacao) {
        this.observacao = observacao;
    }

    public Date getdt_conclusao() {
        return dt_conclusao;
    }

    public void setdt_conclusao(Date dt_conclusao) {
        this.dt_conclusao = dt_conclusao;
    }

    public Integer getid_especialidade() {
        return id_especialidade;
    }

    public void setid_especialidade(Integer id_especialidade) {
        this.id_especialidade = id_especialidade;
    }

    public Integer getid_medico() {
        return id_medico;
    }

    public void setid_medico(Integer id_medico) {
        this.id_medico = id_medico;
    }

    @Override
    public String toString() {
        return String.format("Especialidades Medicas {id = %d, observacao = %s, dt_conclusao = %tF, id_especialidade = %d, id_medico = %d}", this.getId(), observacao, dt_conclusao, id_especialidade, id_medico);
    }

}
