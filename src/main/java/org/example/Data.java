package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Data {
   public List<String> names= Arrays.asList("Richard","Lukas","Tom","Jan","Adam");
   private List<String> lastnames= Arrays.asList("Novy","Lahky","Velky","Kovacz","Bielik");
   private List<String> cities=Arrays.asList("Trnava","Bratislava","Kosice","Nitra","Piestany");
   private List<String> countries=Arrays.asList("Slovakia","Czechia","Macedonia","USA","Russia");
   private List<String> cources=Arrays.asList("Hibernate","Spring Boot","Spring Security","Spring Mvc","JavaScript",
           "Python","Java","Lambda expressions","CSS","Git","Maven","Docker");

    public List<String> getCources() {
        return cources;
    }

    public List<String> getNames() {
        return names;
    }

    public List<String> getLastnames() {
        return lastnames;
    }

    public List<String> getCities() {
        return cities;
    }

    public List<String> getCountries() {
        return countries;
    }

    //this method return random elements from arraylists
    public static String getRandomData(List<String> list){
       Random random=new Random();
       int randomIndex=random.nextInt(list.size());
       return list.get(randomIndex);

   }

}
