#include <jni.h>
#include <stdio.h>

//This file was taken and modified from the prac 5 zip folder
// This construct is needed to make the C++ compiler generate C-compatible compiled code.
extern "C" 
{
    // This is the cpp implementation of the progress indicator plugin
    
    JNIEXPORT void JNICALL Java_NativeImplementation_progressIndicator(JNIEnv *env, jclass cls, jdouble min, jdouble max, jdouble i)
    {
        jdouble total = max - min;
        jdouble percentage = ((i-min)/total)*100;

        printf("\n %lf \n", percentage);
        printf("\n This is the c implementation of the progress indicator \n");
    }
}
