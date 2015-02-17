import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;



final public class MyCount {
	
	private Map<Juice, Integer> numJuice = new HashMap<Juice, Integer> ();
	int countVert = 0;
	private Map<Integer, ArrayList<Juice> > Juices = new HashMap<Integer, ArrayList<Juice> > ();
	
	private ArrayList<Boolean> used = new ArrayList<Boolean>();
	private ArrayList<Integer> mt = new ArrayList<Integer>();
	private ArrayList<Integer> from = new ArrayList<Integer>();
	
	private ArrayList< ArrayList<Integer> > g = new ArrayList< ArrayList<Integer> >();
	
	
	
	
	public MyCount(ArrayList<Juice> menu)
	{
		ArrayList<Juice> tmpMenu = new ArrayList<Juice>(menu);
		Collections.sort(tmpMenu);
		numJuice.put(tmpMenu.get(0), 0);
		Juices.put(0, new ArrayList<Juice>());
		Juices.get(0).add(tmpMenu.get(0));
		countVert++;
		for (int i = 1; i < tmpMenu.size(); i++)
		{
			boolean flag = true;
			for (int j = 0; j < i; j++)
				if (tmpMenu.get(j).compareTo(tmpMenu.get(i)) == 0)
				{
					flag = false;
					int ind = numJuice.get(tmpMenu.get(j));
					Juices.get(ind).add(tmpMenu.get(i));
					break;
				}
			if (flag)
			{
				numJuice.put(tmpMenu.get(i), countVert);
				Juices.put(countVert, new ArrayList<Juice>());
				Juices.get(countVert).add(tmpMenu.get(i));
				countVert++;
			}
		}
		
		
		for (int i = 0; i< countVert; i++)
		{
			used.add(false);
			mt.add(-1);
			from.add(-1);
			g.add(new ArrayList<Integer>());
		}
		
		for (int i = 0; i< countVert; i++)
			for (int j = 0; j< countVert; j++)
			{
				Juice first = tmpMenu.get(i);
				Juice second = tmpMenu.get(j);
				if (first.compareTo(second) == -1)
				{
					g.get(i).add(j);
				}
			}
		
		
	}
	
	boolean kunAlgorithm(int v)
	{
		if (used.get(v) == true) return false;
		used.set(v, true);
		for (int i = 0; i < g.get(v).size(); i++)
		{
			int to = g.get(v).get(i);
			if (mt.get(to) == -1 || kunAlgorithm(mt.get(to)))
			{
				mt.set(to, v);
				return true;
			}
		}
		return false;
	}
	
	
	int count(ArrayList <Juice> menu)
	{
		for (int i = 0; i< countVert; i++)
		{
			for (int j = 0; j< countVert; j++)
				used.set(j, false);
			kunAlgorithm(i);
		}
	
		
		int ans = countVert;
		
		for (int i = 0; i < countVert; i++)
        {
			if (mt.get(i) != -1)
			{
				System.out.println(i + " " + mt.get(i));
        		ans--;		
        		System.out.println(Juices.get(i));
			}
        }
		menu.clear();
		
		for (int j = 0; j< countVert; j++)
			used.set(j, false);
		for (int j = 0; j< countVert; j++)
		{
			int to = mt.get(j);
			if (to != -1)
				from.set(to, j);
		}
		
		for (int i = 0; i< countVert; i++)
		{
			if (used.get(i) == false && mt.get(i) == -1)
			{
				used.set(i, true);
				for (int j = 0; j < Juices.get(i).size(); j++)
					menu.add(Juices.get(i).get(j));
				int to = from.get(i);
				while (to != -1)
				{
					used.set(to, true);
					for (int j = 0; j < Juices.get(to).size(); j++)
						menu.add(Juices.get(to).get(j));
					to = from.get(to);
				}
			}
				
		}
		
		
		
		return ans;
	}

}
