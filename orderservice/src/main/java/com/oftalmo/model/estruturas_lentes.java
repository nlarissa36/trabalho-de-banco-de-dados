package com.oftalmo.model;

public class estruturas_lentes extends generic_model{
    
    private String tipo_correcao;
    private Integer distancia_pupilar;
    private Integer id_receita_oculos;

    public estruturas_lentes(String tipo_correcao, Integer distancia_pupilar, Integer id_receita_oculos){
        this.tipo_correcao = tipo_correcao;
        this.distancia_pupilar = distancia_pupilar;
        this.id_receita_oculos = id_receita_oculos;
    }

     public estruturas_lentes(String tipo_correcao, Integer distancia_pupilar, Integer id_receita_oculos, Integer id){
        this.tipo_correcao = tipo_correcao;
        this.distancia_pupilar = distancia_pupilar;
        this.id_receita_oculos = id_receita_oculos;
        super.setId(id);
    }

    public String gettipo_correcao() {
        return tipo_correcao;
    }

    public void settipo_correcao(String tipo_correcao) {
        this.tipo_correcao = tipo_correcao;
    }

    public Integer getdistancia_pupilar() {
        return distancia_pupilar;
    }

    public void setdistancia_pupilar(Integer distancia_pupilar) {
        this.distancia_pupilar = distancia_pupilar;
    }

    public Integer getid_receita_oculos() {
        return id_receita_oculos;
    }

    public void setid_receita_oculos(Integer id_receita_oculos) {
        this.id_receita_oculos = id_receita_oculos;
    }

    @Override
    public String toString() {
        return String.format("Estruturas Lentes {id = %d, tipo_correcao = %s, distancia_pupilar = %d, id_receita_oculos = %d}", this.getId(), tipo_correcao, distancia_pupilar, id_receita_oculos);
    }

}
