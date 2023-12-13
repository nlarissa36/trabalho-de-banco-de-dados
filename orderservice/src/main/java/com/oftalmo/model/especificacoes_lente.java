package com.oftalmo.model;

public class especificacoes_lente extends generic_model{
    
    private float valor;
    private Integer id_estrutura_lente;
    private Integer id_atributo_estrutura_lente;

    public especificacoes_lente(float valor, Integer id_estrutura_lente, Integer id_atributo_estrutura_lente){
        this.valor = valor;
        this.id_estrutura_lente = id_estrutura_lente;
        this.id_atributo_estrutura_lente = id_atributo_estrutura_lente;
    }

    public especificacoes_lente(float valor, Integer id_estrutura_lente, Integer id_atributo_estrutura_lente, Integer id){
        this.valor = valor;
        this.id_estrutura_lente = id_estrutura_lente;
        this.id_atributo_estrutura_lente = id_atributo_estrutura_lente;
        super.setId(id);
    }

    public float getvalor() {
        return valor;
    }

    public void setvalor(float valor) {
        this.valor = valor;
    }

    public Integer getid_estrutura_lente() {
        return id_estrutura_lente;
    }

    public void setid_estrutura_lente(Integer id_estrutura_lente) {
        this.id_estrutura_lente = id_estrutura_lente;
    }

    public Integer getid_atributo_estrutura_lente() {
        return id_atributo_estrutura_lente;
    }

    public void setid_atributo_estrutura_lente(Integer id_atributo_estrutura_lente) {
        this.id_atributo_estrutura_lente = id_atributo_estrutura_lente;
    }

    @Override
    public String toString() {
        return String.format("Especificacao Lente {id = %d, valor = %.2f, id_estrutura_lente = %d, id_atributo_estrutura_lente = %d}", this.getId(), valor, id_estrutura_lente, id_atributo_estrutura_lente);
    }
}
