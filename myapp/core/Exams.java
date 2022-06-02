package myapp.core;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import javax.annotation.processing.FilerException;

public class Exams {


    public static void main(String[] args) throws IOException {
        String line = "";  
        String splitBy = ",";  

    Map<String, String> GroupA = new HashMap<>();

    try   
    {  
    //parsing a CSV file into BufferedReader class constructor  
        BufferedReader br = new BufferedReader(new FileReader("exams.csv"));  
        while ((line = br.readLine()) != null)   //returns a Boolean value  
            {  
            String[] exams = line.split(splitBy);    // use comma as separator  
            
            GroupA.put(exams[1], exams[5].replace("\"", "")); 
            
            Set<String> keys = GroupA.keySet();
            Collection<String> values = GroupA.values();

            System.out.println(keys);
            
            }  
        }   
    catch (IOException e)   
    {  e.printStackTrace();  
    }  
}  
    }