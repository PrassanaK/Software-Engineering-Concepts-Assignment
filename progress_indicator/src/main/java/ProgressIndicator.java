/*********************************************************************
/*Name: Prassana Kamalakannan
/*Student ID: 19097457
/*Date: 29/10/2020
/*********************************************************************/
public class ProgressIndicator implements Plugin
{
    private double min;//min x value
    private double max;//max x value
    private double x;//current x value

    //DEFAULT CONSTRUCTOR
    public ProgressIndicator()
    {
        min = 0.0;
        max = 0.0;
        x = 0.0;
    }

    //This is an example of a Plugin's start method being implemented
    public void start(API api)
    {
        min = api.getMinimumValue();//get min x value from api object
        max = api.getMaximumValue();//get max x value from api object
        x = api.getX();//get current x value from api object
        progressIndicator(min, max, x);//progress indicator method
    }

    //progressIndicator
    //IMPORT: double, double, double
    public void progressIndicator(double min, double max, double i)
    {
        double total = max - min;//total is calculated by subtracting min x value from max x value
        double percentage = ((i-min)/total)*100;//current progress is tracked by subtracting the min x value from the current x value

        System.out.println("Progress: " + percentage + "%");//result is outputted as a percentage representing how much has been completed
    }
}
