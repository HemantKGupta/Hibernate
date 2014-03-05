import java.io.*;

public class Person implements Serializable
{
    protected String name;
    protected Address address;

    public Person()
    {
    }

    public Person(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public Address getAddress()
    {
        return address;
    }

    public void setAddress(Address address)
    {
        this.address = address;
    }

    public String toString()
    {
        return name + ":" + address.toString();
    }
}
