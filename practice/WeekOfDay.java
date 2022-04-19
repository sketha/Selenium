package practice;

import java.time.DayOfWeek;
import java.util.HashMap;
import java.util.Map;

public class WeekOfDay {

    public static void main(String[] args) {
        //Step 1 ==> Getting the Input for the Day
        String s="Sat";
        
        //Step 2 ==> Get the input for the Integer K
        int kDays=23;

        //Step 3 ==> Creating an HashMap to the Days of the Week
        Map<String, String> map = new HashMap<String, String>();
        map.put("Sun", "Sunday");
        map.put("Mon", "Monday");
        map.put("Tue", "Tuesday");
        map.put("Wed", "Wednesday");
        map.put("Thu", "Thursday");
        map.put("Fri", "Friday");
        map.put("Sat", "Saturday");

        //Step 4 ==> Calculating days using the JAVA 8 Days of the Week
        DayOfWeek value= DayOfWeek.valueOf(map.get(s).toUpperCase()).plus(kDays);
        
        //Step 5 ==> Massaging the output to the format requested for.
        String result = value.name().toLowerCase().substring(0,3);
        System.out.println("The Output of the above code:");
        System.out.println(result.toUpperCase().charAt(0)+result.substring(1,3));
    }
}