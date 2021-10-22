/*********************************************************************
/*Name: Prassana Kamalakannan
/*Student ID: 19097457
/*Date: 29/10/2020
/*********************************************************************/
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.*;
import java.util.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class CSV_Write implements Plugin//This Plugin writes all values of x and y to a csv file. One column for Y values and one column for x values
{
    private double y;
    private double x;

    public CSV_Write()
    {
        y = 0.0;
        x = 0.0;
    }

    public void start(API api)
    {
        y = api.getY();//get calculated y value
        x = api.getX();//get current x value

        try
        {
        BufferedWriter writer = Files.newBufferedWriter(Paths.get("numbers.csv"), StandardOpenOption.APPEND, StandardOpenOption.CREATE);//This is so that everytime this plugin is called the next pair 
                                                                                                                                        //of values will be appended to the end of the file instead of 
                                                                                                                                        //overwriting it
        CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT.withHeader("y","x"));//The headers for each column

        csvPrinter.printRecord(String.valueOf(y), String.valueOf(x));//values are printed to csv file
        csvPrinter.flush();
        writer.close();
        }
        catch(IOException e)
        {
            System.out.println("IOException");
        }
    }
}
