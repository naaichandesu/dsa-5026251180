package lw01.prelab;
public class ColourPrint extends PrintJob {
    
    public ColourPrint(String id, int pages){
        super(id, pages);
    }

    public int calculateCharge(){
        int pages = getPages();
        int perPage;

        if(pages<=10){
            perPage = pages*1500;
        } else{
            perPage = pages*1000;
        }
        return perPage+2000;
    }

    public String label(){
        return "Colour";
    }
}
