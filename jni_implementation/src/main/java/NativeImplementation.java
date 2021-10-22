/*********************************************************************
/*Name: Prassana Kamalakannan
/*Student ID: 19097457
/*Date: 29/10/2020
/*********************************************************************/
public class NativeImplementation implements Plugin
{
    static
    {
        System.load("/home/19097457/Documents/SEC/SEC_ASSIGNMENT_2/Sec_Assignment_2/c_library/build/lib/main/debug/linux/libexample_c_library.so");//absolute path to .so file
    }
    
  
    public void start(API api)
    {
        progressIndicator(api.getMinimumValue(), api.getMaximumValue(), api.getX());//native method called and parameters are extracted from the api object
    }

    public native static void progressIndicator(double min, double max, double i);//native method for progressIndicator

    
}
