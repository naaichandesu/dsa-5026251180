package unguided;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;
import java.util.Queue;
public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(Main.class.getResourceAsStream("borrowing.txt"));
        LinkedList<String[]> request = new LinkedList<>();
        LinkedList<String[]> books = new LinkedList<>();
        LinkedList<String[]> members = new LinkedList<>();
        Queue<String[]> queue = new LinkedList<>();
        Stack<String[]> fails = new Stack<>();

        while(scanner.hasNext()){
            String[] request = new String[0];
            String name = scanner.next();
            String bookTitle = scanner.next();

            String[] data = {name, bookTitle};
            request.add(data);

        }
        scanner.close();

        for(String[] req: request) {
            String name = req[0];
            boolean sdhAda = false;

            for(String[] bk: books){
                if(bk[0].equals(name)){
                    sdhAda = true;
                }
            }

            if(!sdhAda){
                String[] newBook = {name, "0"};
                books.add(newBook);
            }
        }

        for(String[] req: request){
            queue.add(req);
        }

        while(!queue.isEmpty()){
            String[] req = queue.poll();
            String name = req[0];
            String bookTitle = req[1];
            int stock = Integer.parseInt(req[1]);

            for(String[] bk: books){
                if (!bk[0].equals(name)) {
                    continue;
            }
            
            int MAX_BORROW=2;
            int currentStock = Integer.parseInt(bk[1]);
            int currentBorrowed = Integer.parseInt(req[1]);

            
            if (currentStock > 0 && currentBorrowed < MAX_BORROW) {
                request.add(req);
                bk[1] = String.valueOf(currentStock - 1);
                req[1] = String.valueOf(currentBorrowed + 1);
            } else {
                fails.push(req);
            }
            }   
        } 

        

    }
}
