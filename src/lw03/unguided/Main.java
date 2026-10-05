package lw03.unguided;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(Main.class.getResourceAsStream("enrollment.txt"));

        Map<String, Integer> enroll = new LinkedHashMap<>();
        while(sc.hasNext()){
            String line = sc.nextLine();
            String[] word = line.split(" ");
            String operations = word[0];
            String courseCode = word[1];
            int count = Integer.parseInt(word[2]);
            int currentCount =0;

            if (operations.equals("REGISTER")) {
                if(!enroll.containsKey(courseCode)) {
                    enroll.put(courseCode, count);
                } else {
                    enroll.put(courseCode, currentCount+count);
                }
            } else if(operations.equals("WITHDRAW")){
                if(enroll.containsKey(courseCode) && enroll.get(courseCode) >= count){
                    enroll.put(courseCode, currentCount-count);
                } else {

                }
            } else {
                System.out.println("==== Enrollment Checks ====");
                for(String courseCode : enroll.keySet()){
                    System.out.println(courseCode + ": " + currentCount + " students");
                }
                System.out.println(courseCode + ": Not found");
            }


        }
    }
}
