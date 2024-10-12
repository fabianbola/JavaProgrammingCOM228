package Excersice1;

public abstract class Insurance extends Object{

    protected String insuranceType ;
    protected double monthlyCost ;

    protected String getTypeInsurance() {
        return insuranceType;
    }
    protected double getMonthlyCost() {
        return monthlyCost;
    }

    public void setMonthlyCost(double monthlyCost) {
        this.monthlyCost = monthlyCost;
    }

    public Insurance(String insuranceType) {
        this.insuranceType = insuranceType;
    }

    public abstract double setInsuranceCost(double monthlyCost);
    public abstract String displayInfo();
}
