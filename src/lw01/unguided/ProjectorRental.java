package lw01.unguided;

public class ProjectorRental extends Rental {
    public ProjectorRental(String id, int days){
        super(id, days);
    }

    @Override 
    public int calculateCharge(){
        int days = getDays();
        int perDays;

        if(days<=3){
            perDays = days*60000;
        } else {
            perDays = days*450000;
        }
        return perDays + 20000;
    }

    public String label(){
        return "Projector";
    }
}
