package MiniSchulungsAufgaben.Lagerverwaltungssystem;

public class Inventory
{
    Product[] allProducts;

    public Product[] getAllProducts()
    {
        return allProducts;
    }

    public Inventory setAllProducts(Product[] allProducts)
    {
        this.allProducts = allProducts;
        return this;
    }
}
