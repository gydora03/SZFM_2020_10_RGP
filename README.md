# SZFM_2020_10_RGP 
## **~BIG PROJECT~**

### **About**
Our _company_ was tasked with fixing a lot of badly written, unoptimized and quite shameful mathematical libraries that were meant for a **Scientific Exhibition**.   
The task is really straightforward but the _Product Owner_ wants us to develop a demo or PoC-like program to give periodic report on the updating/fixing process.    
So we host this _demo_ program in this repository.

Please consult the documentation for further details regarding the order and its related tasks!


### **Usage**    
In order to run the _demo_ program you must execute   
* the `runDemo.sh` script if you're using Bash on GNU/Linux system or
* the `runDemo.bat` script if you're using Windows

Without the scripts you must run the following _**IN ORDER:**_

0. `cd rgp-poc`
1. `mvn clean package`
2. `mvn exec:java@console &`
3. `sleep 0.1`
4. `mvn exec:java@initdb &`
5. `java -jar target/rgp*.jar`

