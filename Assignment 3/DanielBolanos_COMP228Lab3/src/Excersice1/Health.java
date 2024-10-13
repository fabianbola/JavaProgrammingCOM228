package Excersice1;

public class Health extends Insurance{

    private int insuraceNo;
    private int ID;
    private String Name;
    private int age;
    private char gender;
    private char PreExistence;

    private void setInsuraceNo(int insuraNo) {this.insuraceNo = insuraNo;}
    private void setID(int ID) {this.ID = ID;}
    public void setName(String Name) {
        this.Name = Name;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setGender(char gender) {
        this.gender = gender;
    }
    public void setPreExistence(char PreExistence) {
        this.PreExistence = PreExistence;
    }

    public int getInsuraceNo() {return insuraceNo;}
    public int getID() {
        return ID;
    }
    public String getName() {
        return Name;
    }
    public int getAge() {
        return age;
    }
    public char getGender() {
        return gender;
    }
    public char getPreExistence() {
        return PreExistence;
    }

    public Health(int insuranceNo, int ID, String name, int age, char gender, char PreExistence, double monthlyCost){
        super("Health");
        setInsuraceNo(insuranceNo);
        setID(ID);
        setName(name);
        setAge(age);
        setGender(gender);
        setPreExistence(PreExistence);
        setMonthlyCost(setInsuranceCost(monthlyCost));
    }

    @Override
    public double setInsuranceCost(double monthlyCost) {
        if(getAge()>30 && getAge()<50){
            monthlyCost += (monthlyCost*0.1);
        } else if (getAge()>50){
            monthlyCost += (monthlyCost*0.2);
        }
        if(getGender()=='M' || getGender()=='m'){
            monthlyCost += (monthlyCost*0.1);
        }else{
            monthlyCost += (monthlyCost*0.05);
        }
        if(getPreExistence()=='Y' || getPreExistence()=='y'){
            monthlyCost += (monthlyCost*0.2);
        }
        return monthlyCost;    }

    @Override
    public String displayInfo() {
        String message = String.format(
                "The insurance No. %d type %s was issued to %s with ID %d%n - Age: %d%n - Gender: %c%n - Have pre-existence illness: %c%n%n TOTAL MONTHLY FEE %.2f",
                getInsuraceNo(), super.insuranceType, getName(), getID(), getAge(), getGender(), getPreExistence(), super.monthlyCost
        );
        return message;
    }

    @Override
    public String toString(){
        String message = String.format(
                "The insurance No. %d type %s was issued to %s with ID %d%n - Age: %d%n - Gender: %c%n - Have pre-existence illness: %c%n%n TOTAL MONTHLY FEE %.2f",
                getInsuraceNo(), super.insuranceType, getName(), getID(), getAge(), getGender(), getPreExistence(), super.monthlyCost
        );
        return message;
    }

}
