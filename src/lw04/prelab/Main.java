package lw04.prelab;
import java.util.Scanner;
public class Main {

    public static void main(String [] args){

        Scanner branches = new Scanner(Main.class.getResourceAsStream("branches.txt"));

        int n = branches.nextInt();
        int[] array = new int[n];
        for(int a = 0; a<n; a++){
            array[a]=branches.nextInt();
        }

        int m = branches.nextInt();
        int[] targets = new int[m];
        for(int a = 0; a<m; a++){
            targets[a]=branches.nextInt();
        }
        branches.close();

        int passes = 3;
        insertionSort(array, passes);
        for(int a = 0; a<n; a++){
            if(a>0){
                System.out.print(" ");
            } System.out.print(array[a]);
        }
        System.out.println();

        for(int a = 0; a<m; a++){
            int idx = linearSearch(array, targets[a]);
            if(idx==-1){
                System.out.println(targets[a]+": NOT FOUND");
            } else{
                System.out.println(targets[a]+": FOUND at index "+idx);
            }
        }
    
    }

    public static void insertionSort(int [] array, int passes){ 

        for(int a =1; a<=3; a++){ 
            int temp = array[a];
            for(int b=a-1; b>= 0; b--){
                if(array[b]<temp){
                    array[b+1]= array[b];
                } else {
                    array[b+1]=temp;
                    break;
                }
                if(b==0){
                    array[b]=temp;
                }
            }
        }
    }

    public static int linearSearch(int[] array, int target){
        for(int a=0; a< array.length; a++){
            if(array[a] ==target){
                return a;
            }
        }
        return -1;
    }   
}
