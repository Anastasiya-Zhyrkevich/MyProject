/**
 * Created by fpm.zhirkevi on 10.02.2015.
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;

public class Juice implements Comparable {

    private HashSet <Fruit> components = new HashSet<Fruit>();

    public Juice()
    {
        
    }
    
    public Juice(ArrayList<Fruit> list)
    {
        for (Fruit fruit: list)
        {
        	components.add(fruit);
        }
    }
    
    
    public void addComponent(String str)
    {
    	components.add(new Fruit(str));
    }

    public HashSet <Fruit> getComponents()
    {
        return components;
    }
    
    

	@Override
	public int compareTo(Object arg0) 
	{
		//System.out.println(components.size());
		for (Fruit fruit: components)
		{
			if (!(((Juice) arg0).getComponents().contains(fruit)))
				return 1;
		}
		if (components.size() == ((Juice) arg0).getComponents().size())
			return 0;
		return -1;
	}

	@Override
	public String toString() {
		return "Juice [components=" + components + "]";
	}
	
	

}
