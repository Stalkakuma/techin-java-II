public class Main {
    public static void main(String[] args) {
        Greeter greeter = new Greeter(new EnglishGreetingStrategy());
        greeter.greet("Juozapas", "Guy");
    }
}
