package Excersice1;

public class Health extends Insurance{

    private int ID;
    private String Name;
    private int age;
    private String gender;
    private boolean PreExistence;

    public void setID(int ID) {
        this.ID = ID;
    }
    public void setName(String Name) {
        this.Name = Name;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public void setPreExistence(boolean PreExistence) {
        this.PreExistence = PreExistence;
    }
    public void typeInsurance(String typeInsurance){
        this.typeInsurance = typeInsurance;
    }
    public void monthlyCost (double monthlyCost){
        this.monthlyCost = monthlyCost;
    }


    public int getID() {
        return ID;
    }
    public String getName() {
        return Name;
    }
    public int getAge() {
        return age;
    }
    public String getGender() {
        return gender;
    }
    public boolean getPreExistence() {
        return PreExistence;
    }

    public Health(int ID, String Name, int age, String gender, boolean PreExistence, String typeInsurance, double monthlyCost){

    }

    @Override
    public void setInsuranceCost() {

    }

    @Override
    public void displayInfo() {

    }

    @Override
    public String toString(){
        return "";
    }

}
