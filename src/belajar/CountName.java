package belajar;
import java.util.*;

public class CountName {
    public static void main(String[] args) {
        HashMap<String, Integer> countName = new HashMap<>();


        Scanner sc = new Scanner(System.in);
        String name;
        do{
            System.out.println("Enter name: ");
            name= sc.nextLine();
            if(countName.containsKey(name)){
                int c = countName.get(name);
            }
        }

        while(name.isEmpty());


    }
}
