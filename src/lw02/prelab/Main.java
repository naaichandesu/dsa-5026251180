package lw02.prelab;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        LinkedList<String[]> transactions = new LinkedList<>();

        Scanner sc = new Scanner(new File("transaction.txt"));
        while (sc.hasNext()) {
            String nama = sc.next();
            String tipe = sc.next();
            String jumlah = sc.next();

            String[] data = {nama, tipe, jumlah};
            transactions.add(data);
        }
        sc.close();

        // list customer beserta saldonya, urut dari yang pertama muncul
        LinkedList<String[]> customers = new LinkedList<>();
        for (String[] trx : transactions) {
            String nama = trx[0];
            boolean sdhAda = false;

            for (String[] cust : customers) {
                if (cust[0].equals(nama)) {
                    sdhAda = true;
                }
            }

            if (!sdhAda) {
                String[] newCust = {nama, "0"};
                customers.add(newCust);
            }
        }

        Queue<String[]> queue = new LinkedList<>();
        for (String[] trx : transactions) {
            queue.add(trx);
        }

        Stack<String[]> gagal = new Stack<>();

        while (!queue.isEmpty()) {
            String[] trx = queue.poll();
            String nama = trx[0];
            String tipe = trx[1];
            int jumlah = Integer.parseInt(trx[2]);

            for (String[] cust : customers) {
                if (!cust[0].equals(nama)) {
                    continue;
                }

                int saldo = Integer.parseInt(cust[1]);

                if (tipe.equals("DEPOSIT")) {
                    saldo = saldo + jumlah;
                    cust[1] = "" + saldo;
                } else if (tipe.equals("WITHDRAW")) {
                    if (jumlah > saldo) {
                        gagal.push(trx);
                    } else {
                        saldo = saldo - jumlah;
                        cust[1] = "" + saldo;
                    }
                }
            }
        }

        System.out.println("=== Final Balances ===");
        for (String[] cust : customers) {
            System.out.println(cust[0] + " : " + cust[1]);
        }

        System.out.println();
        System.out.println("=== Failed Transactions ===");
        while (!gagal.isEmpty()) {
            String[] trx = gagal.pop();
            System.out.println(trx[0] + " " + trx[1] + " " + trx[2]);
        }
    }
}