package com.oftalmo.model;

import java.sql.Date;

public class consultas_medicas extends generic_model{
    
    private String assinatura;
    private Date dt_consulta;
    private Integer id_paciente;
    private Integer id_medico;

    public consultas_medicas(String assinatura, Integer id_paciente, Integer id_medico){
        this.assinatura = assinatura;
        this.id_paciente = id_paciente;
        this.id_medico = id_medico;
    }

    public consultas_medicas(String assinatura, Date dt_consulta, Integer id_paciente, Integer id_medico){
        this.assinatura = assinatura;
        this.dt_consulta = dt_consulta;
        this.id_paciente = id_paciente;
        this.id_medico = id_medico;
    }

     public consultas_medicas(String assinatura, Date dt_consulta, Integer id_paciente, Integer id_medico, Integer id){
        this.assinatura = assinatura;
        this.dt_consulta = dt_consulta;
        this.id_paciente = id_paciente;
        this.id_medico = id_medico;
        super.setId(id);
    }

    public String getassinatura() {
        return assinatura;
    }

    public void setassinatura(String assinatura) {
        this.assinatura = assinatura;
    }

    public Date getdt_consulta() {
        return dt_consulta;
    }

    public void setdt_consulta(Date dt_consulta) {
        this.dt_consulta = dt_consulta;
    }

    public Integer getid_paciente() {
        return id_paciente;
    }

    public void setid_paciente(Integer id_paciente) {
        this.id_paciente = id_paciente;
    }

    public Integer getid_medico() {
        return id_medico;
    }

    public void setid_medico(Integer id_medico) {
        this.id_medico = id_medico;
    }

    @Override
    public String toString() {
        return String.format("Consulta Medica {id = %d, assinatura = %s, dt_consulta = %tF, id_paciente = %d, id_medico = %d}", this.getId(), assinatura, dt_consulta, id_paciente, id_medico);
    }

}
