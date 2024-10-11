package Excersice1;

public class Life extends Insurance{

    private int insuraNo;
    private int ID;
    private String name;
    private int age;
    private char gender;
    private char haveCouple;
    private char haveChildren;

    public void setName(String name){
        this.name = name;
    }
    public void setAge(int age){
        this.age = age;
    }
    public void setGender(char gender){
        this.gender = gender;
    }
    public void setHaveCouple(char haveCouple){
        this.haveCouple = haveCouple;
    }
    public void setHaveChildren(char haveChildren){
        this.haveChildren = haveChildren;
    }

    public int getInsuraNo(){return insuraNo;}
    public int getID() {
        return ID;
    }
    public String getName() {return name;}
    public int getAge() {return age;}
    public char getGender() {return gender;}
    public char getHaveCouple() {return haveCouple;}
    public char getHaveChildren() {return haveChildren;}

    public Life(int insuraNo, int ID, String name, int age, char gender, char haveCouple, char haveChildren, double monthlyCost) {
        super.typeInsurance = "Life";
        this.insuraNo = insuraNo;
        this.ID = ID;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.haveCouple = haveCouple;
        this.haveChildren = haveChildren;
        super.monthlyCost = setInsuranceCost(monthlyCost);
        }

    @Override
    public double setInsuranceCost(double monthlyCost) {
        if(getAge()>30 && getAge()<50){
            monthlyCost += (monthlyCost * 0.1);
        } else if (getAge()>50){
            monthlyCost += (monthlyCost * 0.2);
        }
        if(getGender()=='M' || getGender()=='m'){
            monthlyCost += (monthlyCost * 0.1);
        }else{
            monthlyCost += (monthlyCost * 0.05);
        }
        if(getHaveCouple()=='Y' || getHaveCouple()=='y'){
            monthlyCost += (monthlyCost * 0.1);
        }
        if(getHaveChildren()=='Y' || getHaveChildren()=='y'){
            monthlyCost += (monthlyCost * 0.1);
        }
        return monthlyCost;
    }


    @Override
    public String displayInfo() {
        String message = String.format(
                "The insurance No %d type %s was issued to %s with ID %d%n - Age: %d%n - Gender: %c%n - Have a couple: %c%n - Have children: %c%n%n TOTAL MONTHLY FEE %2f",
                getInsuraNo(), super.typeInsurance, getName(), getID(), getAge(), getGender(), getHaveCouple(), getHaveChildren(), super.monthlyCost
        );
        return message;
    }

    @Override
    public String toString(){
        String message = String.format(
                "The insurance No %d type %s was issued to %s with ID %d%n - Age: %d%n - Gender: %c%n - Have a couple: %c%n - Have children: %c%n%n TOTAL MONTHLY FEE %2f",
                getInsuraNo(), super.typeInsurance, getName(), getID(), getAge(), getGender(), getHaveCouple(), getHaveChildren(), super.monthlyCost
        );
        return message;
    }
}
