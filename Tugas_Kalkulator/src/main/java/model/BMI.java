package model;

public class BMI{
    private final String gender;
    private final double berat;
    private final int tinggi;

    public BMI(String gender, int berat, int tinggi) {
        if (gender == null || gender.trim().isEmpty ()){
            throw new IllegalArgumentException ("Don't Empty The Gender");
        }
        if (berat <= 5) {
            throw new IllegalArgumentException ("Minimal 5kg!");
        }
        if (tinggi <= 100){
            throw new IllegalArgumentException ("Minimal 100cm!");
        }
        this.gender = gender;
        this.berat = berat;
        this.tinggi = tinggi;
    }
    
    public double perhitunganBMI (){
        double tinggiMeter = this.tinggi / 100.0;
        
        double nilai = this.berat / (tinggiMeter * tinggiMeter);
        return nilai;
       
}
    public String kategori (double nilaiBMI){
        if (nilaiBMI < 18.5){
            return "Under Weight!";
        }else if (nilaiBMI >= 18.5 && nilaiBMI <= 24.9){
            return "Ur weight is normal!";
        }else if (nilaiBMI >= 24.9 && nilaiBMI <= 29.9){
            return "You are over weight!";
        }else {
            return "Obesity !!";
        }
    }
}
