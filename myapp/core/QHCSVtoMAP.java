package myapp.core;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.AbstractMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class QHCSVtoMAP {

    public static void main(String[] args)  {
        Map<Tuple, List<SubjectScore>> map = new HashMap<>();
        try (Stream<String> content = Files.lines(Paths.get("exams.csv"))) {
            map = content.skip(1).map(line -> lineToEntry(line)) //skip header and map each line to a map entry
                    .collect(Collectors.groupingBy(
                            Map.Entry::getKey, 
                            Collectors.mapping(Map.Entry::getValue, Collectors.toList()))
                    );
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        map.forEach((k,v) -> {System.out.println(k + " : " + v);});
    }

    static Entry<Tuple, SubjectScore> lineToEntry(String line) {
        //split each line at the first and second comma producing an array with 3 columns
        // first column with the name and second with year to create a tuple object
        // evrything after the second comma as one column to create a SubjectScore object
        String[] data = line.split(",", 6);
        Tuple t = new Tuple(data[0].trim(), data[1].trim(), data[2].trim(), data[3].trim(), data[4].trim());
        SubjectScore s = new SubjectScore(data[5]);
        return new AbstractMap.SimpleEntry<>(t, s);
    }
}

class Tuple {
    private String gender;
    private String race;
    private String parentalEducation;
    private String lunch;
    private String testPrepCourse;

    public Tuple(String gender, String race, String parentalEducation, String lunch, String testPrepCourse) {
        this.gender = gender;
        this.race = race;
        this.parentalEducation = parentalEducation;
        this.lunch = lunch;
        this.testPrepCourse = testPrepCourse;
    }

    @Override
    public String toString() {
        return "Tuple{" + "gender=" + gender + ", race=" + race + ", parentalEducation=" + parentalEducation + ", lunch=" + lunch + ", testPrepCourse=" + testPrepCourse  +'}';
    }
}

class SubjectScore {

    private int mathscore;
    private int readingscore;
    private int writingscore;

    public SubjectScore(String row) {
        String[] data = row.split(",");
        if(data == null){
            return;
        }

        this.mathscore = Integer.parseInt(data[0].replaceAll("^\"|\"$", "").trim());
        this.readingscore = Integer.parseInt(data[1].replaceAll("^\"|\"$", "").trim());
        this.writingscore = Integer.parseInt(data[2].replaceAll("^\"|\"$", "").trim());
    }        
}
