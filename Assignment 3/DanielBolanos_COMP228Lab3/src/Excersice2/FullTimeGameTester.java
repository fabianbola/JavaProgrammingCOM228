package Excersice2;

public class FullTimeGameTester extends GameTester{
    private char isBoss;

    public void setBoss(char isBoss) {
        this.isBoss = isBoss;
    }

    public char getisBoss() {
        return isBoss;
    }

    public FullTimeGameTester(String name, boolean status, char isBoss){
        super(name, status);
        setBoss(isBoss);
    }

    @Override
    public double defineSalary(){
        return 3000;
    }

    @Override
    public String toString() {
        String message = String.format(
                "%s is boss %c and your weekly salary is %.2f",
                super.toString(),getisBoss(), defineSalary());
        return message;
    }
}
