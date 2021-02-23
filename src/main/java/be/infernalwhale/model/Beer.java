package be.infernalwhale.model;

public class Beer {
    private Integer id;
    private String name;
    private Brewer brewer;
    private Category category;
    private Double price;
    private Integer stock;
    private Integer alcohol;

    public Beer(int id, String name, Brewer brewer, Category category, double price, int stock, int alcohol) {
        this.id = id;
        this.name = name;
        this.brewer = brewer;
        this.category = category;
        this.price = price;
        this.stock = stock;
        this.alcohol = alcohol;
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

    public Brewer getBrewer() {
        return brewer;
    }

    public void setBrewer(Brewer brewer) {
        this.brewer = brewer;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getAlcohol() {
        return alcohol;
    }

    public void setAlcohol(Integer alcohol) {
        this.alcohol = alcohol;
    }
}
