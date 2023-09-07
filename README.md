# Problem Description
This is a Java application that validates whether a given input string is a valid XML string or not, adhering to the specified rules. The code provided includes a main class (`XmlValidatorApp`) and a supporting class (`XMLValidator`) that contains the validation logic. Additionally, a Dockerfile is included for containerization.

## How to Run and debug code
### Prerequisites
- There is a simple version of the app which in the `javaversion` directory. 
- You need to have Java 11 or higher installed on your machine.
- Docker is required if you intend to build and run the application in a container.

## Running the Application Locally

  1.Clone this repository to your local machine:
> git clone https://github.com/subhani92/DetermineXml.git

2.Navigate to the project directory:
> cd /DetermineXml
 - **Note: In order to run the code of simple Java version(we can verify on the given test cases)**
   -  Compile the source file 
      > javac javaversion/DetermineXml.java
     - Run the code
      >  java javaversion/DetermineXml.java 
    - **Output**
    
           true
           false
           false
           false
           true

3. Build the Java application:
>  javac -classpath src/main/java src/main/java/XmlValidatorApp.java
> 
4.Run the application:
> java -classpath src/main/java XmlValidatorApp

### Sample Input and output
  Example-1:
  > java -classpath src/main/java XmlValidatorApp \
  > Enter an XML string to validate: \
  > `"<tutorial date="01/01/2000">XML</tutorial>"` \
  > Invalid XML: Mismatched closing tag. \
  > The XML string is invalid.
  
 Example-2:
 > java -classpath src/main/java XmlValidatorApp \
 > Enter an XML string to validate: \
 > `“<Design><Code>hello world</Code></Design>”` \
 > The XML string is valid. 
 

## Building and Running in a Docker Container
### Build the Docker image:
> docker build -t xml-validator-app .
### Run the Docker container:
> docker run -it xml-validator-app

### using mvn
Additionally, we can use mvn to build and test the application
run the below command
> mvn clean compile test

- output: kindly check the [log file](DetermineXml/log/mvn-log.txt)

## Limitations
- If the XML string is doesn't contain any opening or closing tags at all
  i.e. `"Hello World"` in this case this program return True
- since it was not mentioned in the Problem statement I took it as a valid XML however we can modify the code based on our need.

- ### Time Complexity:
  The code loops through the XML string character by character, examining each character once.
  In the worst case, for a well-formed XML document with n characters, the code performs two nested indexOf operations for each character. This results in a time complexity of **O(n^2)**.

- ### Space Complexity:
  The code uses a stack (openingTagsStack) to track opening tags. In the worst case, if all opening tags are never matched with closing tags, the stack could grow to hold all the opening tags.
  The space complexity is **O(n)**, where n is the number of opening tags in the XML document. 