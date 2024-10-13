package Excersice2;

public abstract class GameTester {
    private String name;
    private boolean status;

    private void setName(String name) {
        this.name = name;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }
    public boolean getStatus() {
        return status;
    }


    public GameTester(String name, boolean status) {
        setName(name);
        setStatus(status);
    }

    public abstract double defineSalary();

    @Override
    public String toString() {
        String message = String.format(
                "The gamertestet %s is full-time %b",
                getName(), getStatus());
        return message;

    }
}
