package lw01.unguided;

abstract public class Rental implements Chargeable {
   private String id;
   private int days;
   
   protected Rental(String id, int days){
    if(days <=0 || days > 30){
        throw new IllegalArgumentException("Days tidak boleh negatif atau lebih dari 30");
    }
    
    this.id = id;
    this.days = days;
   }

   public String getId(){
    return id;
   }

   public int getDays(){
    return days;
   }

   @Override 
   public abstract int calculateCharge();

   public int calculateCharge(int units){
    if(units <= 0 || units > 10){
        throw new IllegalArgumentException("Units cannot negatives");
    }
    return units * calculateCharge();
   }

   public String label(){
    return "Rental";
   }

   public String summary(){
    return id + " | " + label() + " | " + calculateCharge();
   }

}
