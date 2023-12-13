package com.oftalmo.model;

public class generic_model {

    private Integer id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "GenericModel{" +
                "id=" + id +
                '}';
    }
}