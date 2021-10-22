/*********************************************************************
/*Name: Prassana Kamalakannan
/*Student ID: 19097457
/*Date: 29/10/2020
/*********************************************************************/
import org.python.core.*;
import org.python.util.*;

public class Implementations implements API//This class implements the methods within the API interface
{
    private String equation;
    private double min;
    private double max;
    private double inc;
    private double y;
    private double x;
    private PythonInterpreter py;

    //CONSTRUCTOR
    //IMPORT: String, double, double, double, double, double, PythonInterpreter
    public Implementations(String inEquation, double inMin, double inMax, double inInc, double inY, double inX, PythonInterpreter inPy)
    {
        equation = inEquation;
        min = inMin;
        max = inMax;
        inc = inInc;
        y = inY;
        x = inX;
        py = inPy;
    }

    //GETTERS
    public String getEquation()//returns a string representing the expression
    {
        return equation;
    }

    public double getMinimumValue()//returns a real numbers representing the minimum x value
    {
        return min;
    }

    public double getMaximumValue()//return a real number representing the maximum x value
    {
        return max;
    }

    public double getIncrementalValue()//returns a real number representing the incremental value
    {
        return inc;
    }

    //SETTER
    public void notifyY()//notifies when y is calculated
    {
        double result = y;
    }
    //////////////////////////

    public double getY()//returns a real number representing the calculated y value
    {
        return y;
    }

    public double getX()//returns a real number representing the current value of x
    {
        return x;
    }
}
