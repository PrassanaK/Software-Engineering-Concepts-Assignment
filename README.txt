Before compiling, if you don't have the JAVA_HOME environment variable setup, you should do that first if you haven't done so already.
If you are opening this on the lab machines, type export JAVA_HOME=/usr/lib/jvm/default-java at the command line if you don't have it already.
------------------------------------------------------------------------------------------------------------------------------------------------------
First compile each subproject like so:

./gradlew :api_interfaces:build
./gradlew :c_library:build
./gradlew :csv_write:build
./gradlew :jni_implementation:build
./gradlew :progress_indicator:build
./gradlew :java_app:build
----------------------------------------------------
Then to run the program, type in this command:

./gradlew run
----------------------------------------------------
Plugin Names:

ProgressIndicator
NativeImplementation
CSV_Write
----------------------------------------------------
Notes: 

-When loading the jni implementation of the progress indicator, for some reason it only displays the progress information after you have exited the program. I did not know how to rectify this.

-This entire project was downloaded from prac 5's jni_helloworld application and then modified and expanded upon for the purposes of the assignment

-The jni implementation file uses System.load() instead of System.loadLibrary()
