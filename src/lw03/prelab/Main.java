import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {

        //problem 1 
        List<String> playlist = new ArrayList<>();
        Scanner problemOne = new Scanner(Main.class.getResourceAsStream("playlist.txt"));

        while (problemOne.hasNextLine()) {
            String line = problemOne.nextLine();
            String[] parts = line.split(" ", 2);

            if (parts[0].equals("ADD")) {
                playlist.add(parts[1]);
            } else if (parts[0].equals("INSERT")) {
                String[] p = parts[1].split(" ", 2);
                int index = Integer.parseInt(p[0]);
                playlist.add(index, p[1]);
            } else if (parts[0].equals("REMOVE")) {
                playlist.remove(parts[1]);
            }
        }
        problemOne.close();

        System.out.println("===== Problem 1 =====");
        System.out.println("Total songs: " + playlist.size());
        for (int i = 0; i < playlist.size(); i++) {
            System.out.println((i + 1) + ": " + playlist.get(i));
        }

        //problem 2
        Set<String> participants = new LinkedHashSet<>();
        int duplicate = 0;
        Scanner problemTwo = new Scanner(Main.class.getResourceAsStream("participants.txt"));

        while (problemTwo.hasNextLine()) {
            String name = problemTwo.nextLine();
            if (participants.contains(name)) {
                duplicate++;
            } else {
                participants.add(name);
            }
        }
        problemTwo.close();

        System.out.println("===== Problem 2 =====");
        System.out.println("Unique participants: " + participants.size());
        int no = 1;
        for (String name : participants) {
            System.out.println(no + ". " + name);
            no++;
        }
        System.out.println("Duplicate registrations: " + duplicate);

        //problem 3
        Map<String, Integer> stock = new LinkedHashMap<>();
        int failedSales = 0;
        Scanner problemThree = new Scanner(Main.class.getResourceAsStream("inventory.txt"));

        while (problemThree.hasNext()) {
            String type = problemThree.next();
            String product = problemThree.next();
            int qty = problemThree.nextInt();

            if (type.equals("ADD")) {
                if (stock.containsKey(product)) {
                    stock.put(product, stock.get(product) + qty);
                } else {
                    stock.put(product, qty);
                }
            } else if (type.equals("SELL")) {
                if (stock.containsKey(product) && stock.get(product) >= qty) {
                    stock.put(product, stock.get(product) - qty);
                } else {
                    failedSales++;
                }
            }
        }
        problemThree.close();

        System.out.println("===== Problem 3 =====");
        for (String product : stock.keySet()) {
            System.out.println(product + ": " + stock.get(product));
        }
        System.out.println("Failed sales: " + failedSales);
    }
}