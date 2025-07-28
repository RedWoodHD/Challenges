package MiniSchulungsAufgaben.Lagerverwaltungssystem;

public class Product
{
    String name;
    int amount;

    public Product(String name, int amount)
    {
        this.name = name;
        this.amount = amount;
    }

    public String getName()
    {
        return name;
    }

    public Product setName(String name)
    {
        this.name = name;
        return this;
    }

    public int getAmount()
    {
        return amount;
    }

    public Product setAmount(int amount)
    {
        this.amount = amount;
        return this;
    }
}
