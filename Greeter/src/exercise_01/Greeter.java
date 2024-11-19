package exercise_01;

public class Greeter {
    public void greet(String firstName, String lastName) {
        System.out.println("Hello " + firstName + " " + lastName);
    }
    protected String getGreetingString() {
        return "";
    };
}
