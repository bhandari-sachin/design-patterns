
public class Main {
    public static void main(String[] args) {

        ApiFacade facade = new ApiFacade();

        try {
            String joke = facade.getAttributeValueFromJson(
                    "https://api.chucknorris.io/jokes/random",
                    "value"
            );

            System.out.println("Joke: " + joke);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}