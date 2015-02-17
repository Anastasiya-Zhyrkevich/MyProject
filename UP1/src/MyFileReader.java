import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by fpm.zhirkevi on 10.02.2015.
 */

final class MyFileReader 
{	
    private BufferedReader bufferReader;
    private StringTokenizer stringTokenizer;
    private ArrayList<Fruit> list;

    public MyFileReader(File file) 
    {
    	addFile(file);
	}
    
    public void addFile(File file)
    {
    	try {
			bufferReader = new BufferedReader(new FileReader(file));
		} catch (FileNotFoundException e) 
    	{
			e.printStackTrace();
		}		
    }

    public ArrayList<Fruit> read()
    {
    	//System.out.println("!");
    	list = new ArrayList<Fruit>();
		try 
		{	
			String str;
		    if ((str = bufferReader.readLine()) != null)
		    {
		    	//System.out.println(str);
		    	stringTokenizer = new StringTokenizer(str);
		    	while (stringTokenizer.hasMoreTokens())
		    	{		    		
		    		list.add(new Fruit(stringTokenizer.nextToken()));
		    	}
		    }
	    } catch (IOException exception) {
	         exception.printStackTrace();
	    }
		return list;
    }


}
