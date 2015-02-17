import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by fpm.zhirkevi on 10.02.2015.
 */
public class MyFileWriter 
{
    PrintWriter out;


    public MyFileWriter(File file) 
    {
        try 
        {
            out = new PrintWriter(new FileWriter(file));
        }
        catch(IOException exception)
        {
            exception.printStackTrace();
        }
    }


	void writeArray(ArrayList<Fruit> list)
    {
        for (Fruit tmpFruit: list)
        {
            out.println(tmpFruit.getName() + " ");
        }
    }
	
	void writeSet(HashSet<Fruit> set)
    {
        for (Fruit tmpFruit: set)
        {
            out.print(tmpFruit.getName() + " ");
        }
    }
	

	void write(int count)
    {
        out.println(count);
    }
	
	void writeMenu(ArrayList <Juice> menu)
	{
		for (Juice tmpJuice: menu)
		{
			writeSet(tmpJuice.getComponents());
			out.println();
		}
	}
    
    void close()
    {
    	out.close();
    }

}
