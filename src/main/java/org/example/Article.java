package org.example;

public class Article {
    private Integer id;
    public Integer getId(){
        return id;
    }
    public void setId(Integer i){
        id = i;
    }

    private String name;
    public String getName(){
        return name;
    }
    public void setName(String i){
        name = i;
    }

    private String description;
    public String getDescription(){
        return description;
    }
    public void setDescription(String i){
        description = i;
    }

    private Float price;
    public Float getPrice(){
        return price;
    }
    public void setPrice(Float i){
        price = i;
    }

    private Integer vat;
    public Integer getVat(){
        return vat;
    }
    public void setVat(Integer i){
        vat = i;
    }

    private Integer stock;
    public Integer getStock(){
        return stock;
    }
    public void setStock(Integer i){
        stock = i;
    }

    public Article(Integer a, String b, String c, Float d, Integer e, Integer f) {
        id = a;
        name = b;
        description = c;
        price = d;
        vat = e;
        stock = f;
    }


}

