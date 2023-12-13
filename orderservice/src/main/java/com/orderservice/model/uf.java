

public class uf extends generic_model{
    
    private String descricao;
    private Integer codigo;

    public uf(String descricao, Integer codigo){
        this.descricao = descricao;
        this.codigo = codigo;
    }

     public uf(String descricao, Integer codigo, int id){
        this.descricao = descricao;
        this.codigo = codigo;
        super.setId(id);
    }

    public String getdescricao() {
        return descricao;
    }

    public void setdescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getcodigo() {
        return codigo;
    }

    public void setcodigo(Integer codigo) {
        this.codigo = codigo;
    }

    @Override
    public String toString() {
        return String.format("Atributos Estrutura Lente {id = %d, descricao = %s, codigo = %d}", this.getId(), descricao, codigo);
    }

}
