# WebScrapping
Web Scrapping using Jsoup liberary in Java

#In this respository I am supposed to web scrapping so to get name, email and password of buyers and sellers from a Web Page

Instructions to be followed to run code in linux/unix

Step 1:
Set the Java_home and path in your linux

Step 2:
open the terminal and move to that directory where all the written code, jar files and Html page which is to be scrapped is loacted

Step 3:
Say cd Desktop/

Step 4:
Compile the java file with the jar files like this
  javac -cp jackson-all-1.9.0.jar: RealityObject.java 
  javac -cp jackson-all-1.9.0.jar:jsoup-1.13.1.jar: HtmlParser.java
  
Step 5:
Check the path specified for HTML file and the file in which output is written say output.json

Step 6:
Run the file which contains main method
  java -cp jackson-all-1.9.0.jar:jsoup-1.13.1.jar: HtmlParser

Step 7:
In this way you are able to web scrap your data using Jsoup liberary

STEPS TO SET PATH FOR JAVA_HOME AND PATH FOR JDK IN LINUX
A) java -version
B) sudo update-alternatives --config java
C) copy the path which listed
D) sudo nano ~/.bashrc
E) then goto the end of file and and set the path for java
F) #JAVA_HOME
export JAVA_HOME= "/javadir/jre/"
export PATH="$JAVA_HOME/bin:$PATH"
G) In this way you are able to run program easily

