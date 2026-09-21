package lw01.unguided;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args){
        List<Rental> rentals = new ArrayList<>();

        try(Scanner scanner = new Scanner(new File("rentals.txt"))){

        while(scanner.hasNext()){
            String type = scanner.next();
            String id = scanner.next();
            int days = scanner.nextInt();

            if (type.equalsIgnoreCase("LAPTOP")) {
                rentals.add(new LaptopRental(id, days));
            } else if(type.equalsIgnoreCase("PROJECTOR")){
                rentals.add(new ProjectorRental(id, days));

            }
            
            for (Rental rental : rentals) {
                System.out.println(rental.summary());
            }
            
        } 
    }
}
}
