import java.util.Comparator;

public class CompareFruit implements Comparator<Fruit>
{
	@Override
    public int compare(Fruit j1, Fruit j2) 
	{
    	return j1.getName().compareTo(j2.getName());
    }
}

