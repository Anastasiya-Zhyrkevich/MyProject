import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Solver {
	
    ArrayList <Juice> menu = new ArrayList <Juice>();
    ArrayList <Fruit> fruitList = new ArrayList <Fruit>();
    ArrayList <Fruit> tmpFruitList = new ArrayList <Fruit>();
    
    Set<Fruit> allFruits = new HashSet<Fruit>();
    
    String fileName;
    
    MyFileWriter fileWriter;
    MyFileReader fileReader;

    public Solver(String fileName)
    {
        this.fileName = fileName;
    }

    public void solve()
    {
    	fileReader = new MyFileReader(new File(fileName));
        while (!(tmpFruitList = fileReader.read()).isEmpty())	
        {        	
            for (Fruit tmpFruit: tmpFruitList)
            {
                if (!allFruits.contains(tmpFruit))
                    fruitList.add(tmpFruit);
                allFruits.add(tmpFruit);
            }
            menu.add(new Juice(tmpFruitList));
            
        }
        fileWriter = new MyFileWriter(new File("juice1.out"));
        fileWriter.writeArray(fruitList);
        fileWriter.close();
        
        
        fileWriter = new MyFileWriter(new File("juice2.out"));

        
        Thread T = new Thread(new Runnable() 
        {
        	@Override
        	public void run() {
        		Collections.sort(fruitList, new CompareFruit());
        	}
        });
        T.start();
        do {
        	try {
        		T.join(130);
        	} catch (InterruptedException e) {
        	}
        } while (T.isAlive());
        
        
        fileWriter.writeArray(fruitList);
        fileWriter.close();

               
        int countOfWashes = 0;
        
        MyCount mycount = new MyCount(menu);
        countOfWashes = mycount.count(menu);
        
        
        fileWriter = new MyFileWriter(new File("juice3.out"));
        fileWriter.write(countOfWashes);
        fileWriter.writeMenu(menu);
        
        
        fileWriter.close();
 
    }


}
