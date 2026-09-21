package lw01.prelab;
abstract public class PrintJob implements Chargeable {
    private String id;
    private int pages;
    
    protected PrintJob(String id, int pages){
        if (pages<=0) {
            throw new IllegalArgumentException("jumlah halaman tidak boleh negatif");
        }
        this.id = id;
        this.pages = pages;
    }

    public String getId(){
        return id;
    }

    public int getPages(){
        return pages;
    }

    @Override
    public abstract int calculateCharge();

    public int calculateCharge(int copies){
        if(copies <= 0 ||copies >10){
            throw new IllegalArgumentException("Halaman harus antara 1 dan 10");
        }
        return copies*calculateCharge();
    }

    public String label(){
        return "Print";
    }

    public String summary(){
        return id + " | " + label() + " | " + calculateCharge();
    }
}


