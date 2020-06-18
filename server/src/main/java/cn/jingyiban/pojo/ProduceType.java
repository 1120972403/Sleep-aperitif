package cn.jingyiban.pojo;

import java.util.List;

public class ProduceType {
    private Integer id;

    private String name;

    private List<Produce> produces;

    public List<Produce> getProduces() {
        return produces;
    }

    public void setProduces(List<Produce> produces) {
        this.produces = produces;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}