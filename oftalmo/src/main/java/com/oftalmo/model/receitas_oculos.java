package com.oftalmo.model;

import java.sql.Date;

public class receitas_oculos extends generic_model{
    
    private String detalhamento;
    private Date dt_consulta;
    private Integer id_consulta_medica;

    public receitas_oculos(String detalhamento, Date dt_consulta, Integer id_consulta_medica){
        this.detalhamento = detalhamento;
        this.dt_consulta = dt_consulta;
        this.id_consulta_medica = id_consulta_medica;
    }

     public receitas_oculos(String detalhamento, Date dt_consulta, Integer id_consulta_medica, int id){
        this.detalhamento = detalhamento;
        this.dt_consulta = dt_consulta;
        this.id_consulta_medica = id_consulta_medica;
        super.setId(id);
    }

    public String getdetalhamento() {
        return detalhamento;
    }

    public void setdetalhamento(String detalhamento) {
        this.detalhamento = detalhamento;
    }

    public Date getdt_consulta() {
        return dt_consulta;
    }

    public void setdt_consulta(Date dt_consulta) {
        this.dt_consulta = dt_consulta;
    }

    public Integer getid_consulta_medica() {
        return id_consulta_medica;
    }

    public void setid_consulta_medica(Integer id_consulta_medica) {
        this.id_consulta_medica = id_consulta_medica;
    }

    @Override
    public String toString() {
        return String.format("Receita Oculos {id = %d, detalhamento = %s, id_consulta_medica = %d", this.getId(), detalhamento, dt_consulta);
    }

}
