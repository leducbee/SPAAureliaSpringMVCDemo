package models;

public class Figure1
{
    private int id;
    private String name;
    private int price;
    
    public Figure1()
    {
        
    }
    
    public Figure1( String name, int price)
    {
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
