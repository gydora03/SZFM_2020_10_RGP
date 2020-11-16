# SZFM_2020_10_RGP 
## **_BIG PROJECT_**

### **About**
Our _company_ was tasked with fixing a lot of badly written, unoptimized and quite shameful mathematical libraries that were meant for a **Scientific Exhibition**.   
The task is really straightforward but the _Product Owner_ wants us to develop a demo or PoC-like program to give periodic report on the updating/fixing process.    
So we host this _demo_ program in this repository.

Please consult the documentation for further details regarding the order and its related tasks!


### **Usage**    
In order to run the _demo_ program you must execute   
* the `runDemo.sh` script if you're using Bash on GNU/Linux system or
	* This script was tested on an _**Arch Linux**_ system by _Racs Tamás_
	* Result: _**it just works**_
* the `runDemo.bat` script if you're using Windows
	* This script was tested on a Windows system by _György Dóra_
	* Result: _**in theory, it just works**_ 
	* **IMPORTANT:** If you're on Windows you must start the h2 database and then the program manually as of now! Please see below for instructions.

In order to see the logging entries inside the h2 tables please visit [http://localhost:8082-](the h2 console)    


Without the scripts you must run the following _**IN ORDER:**_ on GNU/Linux or BSD platforms

0. `cd rgp-poc`
1. `mvn clean package`
2. `mvn exec:java@console &`
4. `mvn exec:java@initdb &`
5. `java -jar target/rgp*.jar`

On Windows you must do the following:

0. `cd rgp-poc'
1. 'WIN+r` type in `cmd`
2. Type `mvn clean package`
3. Open another prompt like in step 1
4. Type `mvn exec:java@console`
5. Open another prompt like in step 1
6. Type `mvn exec:java@initdb`
7. Open another prompt like in step 1
8. Run `java -jar target\rgp*.jar`

