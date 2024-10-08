package Excersice1;

public class Life extends Insurance{

    private int ID;
    private String name;
    private int age;
    private String gender;
    private String haveCouple;
    private boolean haveChildren;

    public int getID() {
        return ID;
    }
    public void setID(int ID) {
        this.ID = ID;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setAge(int age){
        this.age = age;
    }
    public void setGender(String gender){
        this.gender = gender;
    }
    public void setHaveCouple(String haveCouple){
        this.haveCouple = haveCouple;
    }
    public void setHaveChildren(boolean haveChildren){
        this.haveChildren = haveChildren;
    }
    public void typeInsurance(String typeInsurance){
        this.typeInsurance = typeInsurance;
    }
    public void monthlyCost (double monthlyCost){
        this.monthlyCost = monthlyCost;
    }


    public int getAge() {
        return age;
    }
    public String getGender() {
        return gender;
    }
    public String getHaveCouple() {
        return haveCouple;
    }
    public boolean isHaveChildren() {
        return haveChildren;
    }
    public String typeInsurance(){
        return typeInsurance;
    }
    public double monthlyCost(){
        return monthlyCost;
    }



    public Life(int ID, String name, int age, String gender, String haveCouple, String typeInsurance, double monthlyCost){

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
