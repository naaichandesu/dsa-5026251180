package Sort;

public class Main {
    public static void main(String[] args) {
        System.out.println("yap");
        int [] data = {7, 8, -2, -9, 1, 6};
        bubbleSort(data);
    }

    public static void bubbleSort(int [] data){
        for(int a = data.length-1; a>0; a--){
            for(int b = 0; b<a; b++){
                if(data[b+1]>data[b]){
                    int temp = data[b];
                    data[b] = data[b+1];
                    data[b+1] = temp;
                }
            }
        }
        for(int d:data){
            System.out.print(d+" ");
        }
    }
}
