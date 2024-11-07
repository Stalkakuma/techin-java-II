public class Greeter implements GreeterLanguageStrategy {
    private GreeterLanguageStrategy greeterLanguageStrategy;

    public Greeter(GreeterLanguageStrategy greeterLanguageStrategy) {
        this.greeterLanguageStrategy = greeterLanguageStrategy;
    }

    @Override
    public String getGreetingString() {
        return "";
    }
    public void greet(String firstName, String lastName) {
        System.out.println(greeterLanguageStrategy.getGreetingString()+" "+firstName +" "+ lastName);
    }
}
