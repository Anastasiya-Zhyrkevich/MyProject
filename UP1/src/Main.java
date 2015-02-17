import java.io.File;

/**
 * Created by fpm.zhirkevi on 10.02.2015.
 */
public class Main {
    
    private Solver solver;

    public static void main(String[] args)
    {
        new Main().run();
        return;
    }

    private void run()
    {
    	
        solver = new Solver("src/input.txt");
        solver.solve();
    }



}
