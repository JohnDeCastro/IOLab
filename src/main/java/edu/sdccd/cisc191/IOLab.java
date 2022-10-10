package edu.sdccd.cisc191;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

/**
 *
 * References:
 * Morelli, R., & Walde, R. (2016). Java, Java, Java: Object-Oriented Problem Solving.
 * Retrieved from https://open.umn.edu/opentextbooks/textbooks/java-java-java-object-oriented-problem-solving
 *
 */
public class IOLab
{

    public static String readTestResults(String s) {
        // empty string needed to be returned. string will hold input from sourced file
        String result = "";

        // try block to find and read file.
        try{
            // place parameter s into file object via pathname + s
            File testResult = new File("src/main/resources/" + s);
            // new scanner object to read the new file object
            Scanner scanner = new Scanner(testResult);
            // reads line by line. if more to read, add to current string of results
            while (scanner.hasNextLine()){
                result += scanner.nextLine();
            }
            // returns entire result read from sourced file
            return result;
        }
        // catch statement if file not found
        catch (FileNotFoundException e) {
            return "";
        }
    }

    public static void appendTestResult(String s, String s1) {
        // place parameter s into file object to be appended. use pathname + s to source file
        File inputFile = new File("src/main/resources/" + s);
        // try catch to append file and catch exception.
        try {
            // wrap fileWriter with printWriter with file needing to be appended in parameter.
            PrintWriter out = new PrintWriter(new FileWriter(inputFile, true), true);
            // overwrite file with added string
            out.println(s1);
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String readDateTime(String s) {
        try{
            // place string URL into URL object
            URL dateTimeURL = new URL(s);
            // create scanner object to scan openStream of URL object
            Scanner download = new Scanner(dateTimeURL.openStream());
            // place line from scanner object into a string
            String getInput = download.nextLine();
            // finds index of 'datetime' from string above that used URL source and sets it into int variable
            int dateTime = getInput.indexOf("datetime");
            // returns substrings of dateTime +11 characters and +43 characters respectively to
            // encapsulate whole 32 character 'datetime'
            return getInput.substring(dateTime+11 , dateTime+43);
        }
        // catch possible exceptions
        catch (FileNotFoundException e){
            System.out.println("Error: File not found");
        }
        catch(MalformedURLException e){
            System.out.println("Error: Invalid URL");
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
        return "";
    }
}