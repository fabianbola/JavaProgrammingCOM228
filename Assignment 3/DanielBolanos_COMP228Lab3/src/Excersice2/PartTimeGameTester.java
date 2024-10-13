package Excersice2;

public class PartTimeGameTester extends GameTester {

    private int workWeeklyHours;

    public void setworkWeeklyHours(int workHours) {
        this.workWeeklyHours = workHours;
    }

    public int getworkWeeklyHours() {
        return workWeeklyHours;
    }

    public PartTimeGameTester(String name, boolean status, int weeklykHours){
        super(name, status);
        setworkWeeklyHours(weeklykHours);
    }

    @Override
    public double defineSalary(){
        return 20*getworkWeeklyHours();
    }

    @Override
    public String toString() {
        String message = String.format(
                "%s, work  %d hours weekly and your weekly salary is %.2f",
                super.toString(),getworkWeeklyHours(), defineSalary());
        return message;
    }
}
