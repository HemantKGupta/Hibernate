import java.util.Set;

public class Bar
{
    protected int id;
    protected Set foos;
    public Set getFoos() {
		return foos;
	}

	public void setFoos(Set foos) {
		this.foos = foos;
	}

	public Bar()
    {
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }
}

