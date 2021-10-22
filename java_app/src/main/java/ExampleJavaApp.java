/*********************************************************************
/*Name: Prassana Kamalakannan
/*Student ID: 19097457
/*Date: 29/10/2020
/*********************************************************************/
import org.python.core.*;
import org.python.util.*;
import java.util.*;
import java.lang.reflect.*;

public class ExampleJavaApp
{
    public static void main(String[] args)
    {
        //Main Menu
        ArrayList<Plugin> plugins = new ArrayList<Plugin>();//ArrayList of plugins
        ArrayList<Class> classes = new ArrayList<Class>();//ArrayList of classes for the purposes of retrieving plugin names

        //Main Menu
        System.out.println("1. Load plugins");
        System.out.println("2. Evaluate Expression");
        System.out.println("3. Show Loaded Plugins");
        System.out.println("4. Exit");

        Scanner input = new Scanner(System.in);
        int choice = input.nextInt();//User's choice is inputted as an int
       
        while(choice != 4)
        {
            switch(choice)
            {
                case 1:
                    //Plugin Loading Mechanism---------------
                    System.out.println("Enter plugin name");
                    Scanner in = new Scanner(System.in);
                    String pluginName = in.next();//user inputs plugin name
                    System.out.println("\n");
                    try
                    {
                        Class<?> pluginClass = Class.forName(pluginName);
                        classes.add(pluginClass);
                        Plugin pluginObj = (Plugin)pluginClass.getConstructor().newInstance();//plugin is loaded
                        plugins.add(pluginObj);//Each loaded plugin is added to arraylist
                        throw new NoSuchFieldException();//NoSuchFieldException is thrown
                    }
                    catch(ClassCastException e1)//All possible exceptions are handled
                    {
                        System.out.println("ClassCastException");
                    }
                    catch(IllegalArgumentException e2)
                    {
                        System.out.println("IllegalArgumentException");
                    }
                    catch(NoSuchMethodException e3)
                    {
                        System.out.println("NoSuchMethodException");
                    }
                    catch(NoSuchFieldException e4)
                    {
                        System.out.println("NoSuchFieldException");
                    }
                    catch(InvocationTargetException e5)
                    {
                        System.out.println("InvocationTargetException");
                    }
                    catch(InstantiationException e6)
                    {
                        System.out.println("InstantiationException");
                    }
                    catch(IllegalAccessException e7)
                    {
                        System.out.println("IllegalAccessException");
                    }
                    catch(ClassNotFoundException e8)
                    {
                        System.out.println("ClassNotFoundException");
                    }
                    //---------------------------------------
                    break;
                case 2:
                    //Equation evaluator-----------------------------------------
                    Scanner sc = new Scanner(System.in);
                    System.out.println("Enter Expression: ");
                    String expression = sc.next();//Enter expression as a string
    
                    System.out.println("Enter Min X value: ");
                    double minX = sc.nextDouble();//Enter the min x value
                    System.out.println("Enter Max X value: ");
                    double maxX = sc.nextDouble();//Enter the Max x value
                    System.out.println("Enter Increment value: ");
                    double incX = sc.nextDouble();//Enter the incremental value
           
                    PythonInterpreter interpreter = new PythonInterpreter();//Scripting
    
                    for(double x = minX; x<=maxX; x += incX)
                    {
                        interpreter.set("x", x);
                        double y = ((PyFloat)interpreter.eval("float(" + expression + ")")).getValue();//equation evaluator script
                        System.out.println("X= " + x + "|Y= " + y);
                        Implementations api = new Implementations(expression, minX, maxX, incX, y, x, interpreter);//The api is upadted with  curent values
                        for(Plugin p : plugins)
                        {
                            p.start(api);//Any and all plugins are initiated here
                        }
                       
                    }
                    //-------------------------------------------------------------
                    break;
                case 3:
                    for(Class c : classes)
                    {
                        System.out.println(c.getName());//Loop through each class and retrieve
                    } 
                    break;
                case 4:
                    System.out.println("Exiting");
                    break;
                default:
                    System.out.println("Invalid choice");
            }
            
            //Display menu again until exit condition is met
            System.out.println("1. Load plugins");
            System.out.println("2. Evaluate Expression");
            System.out.println("3. Show loaded plugins");
            System.out.println("4. Exit");
            choice = input.nextInt();

        }
    }
}
