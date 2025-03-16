```gradle tasks``` - Lists all the available tasks available

```gradle build``` - Builds the project and creates the .class and .jar files inside a new build folder .
Also creates a .gradle folder

```gradle -i build``` - Shows more logging information

```gradle wrapper``` - creates gradle/wrapper folders with a jar file and a properties file.
Also creates 2 extra files: gradlew and gradlew.bat 

Now you can also build using ```./gradlew build``` instead of ```gradle build```

To generate javadocs from the comments: ``` gradle javadoc``` 
View the doc in build/docs/index.html

```gradle -q dependencies``` - To view the dependencies of your project.

Repository is a location where jar files and other dependencies are stored.

* implementation:
    * runtimeOnly
    * compileOnly
* testImplementation
    * testCompileOnly
    * testRuntimeOnly
    
Caching:
* To refresh caches ```--refresh-dependencies```