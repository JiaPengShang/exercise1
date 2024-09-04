import java.util.Locale;
import java.util.ResourceBundle;

public class Greeter {

  private Locale locale;
  private String name;

  // Constructor
  public Greeter(String language, String country, String name) {
    if (language == null || language.isEmpty()) {
      // Set default language to English if not provided
      language = "en";
    }
    if (country == null || country.isEmpty()) {
      // Set default country to US if not provided
      country = "US";
    }
    this.locale = new Locale(language, country);
    this.name = name != null ? name : "Guest"; // Default name to 'Guest' if not provided
  }

  // Say hello method
  public String sayHello() {
    ResourceBundle messages = ResourceBundle.getBundle("MessagesBundle", locale);
    return messages.getString("greeting") + ", " + name + "!";
  }

  public static void main(String[] args) {
    try {
      String language = args.length > 0 ? args[0] : "";
      String country = args.length > 1 ? args[1] : "";
      String name = args.length > 2 ? args[2] : "";

      Greeter greeter = new Greeter(language, country, name);
      System.out.println(greeter.sayHello());

    } catch (Exception e) {
      System.out.println("Error: Please provide arguments in the following format:");
      System.out.println("java Greeter <language> <country> <name>");
    }
  }
}
