package Excersice1;

public abstract class Insurance extends Object{

    protected String typeInsurance ;
    protected double monthlyCost ;

    protected String getTypeInsurance() {
        return typeInsurance;
    }
    protected double getMonthlyCost() {
        return monthlyCost;
    }

    public abstract void setInsuranceCost();
    public abstract void displayInfo();

}
