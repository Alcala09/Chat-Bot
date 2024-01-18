import java.util.Scanner;

class Main {
  public static void main(String[] args) 
  {
    String input = "";
    Scanner reader = new Scanner(System.in);
    System.out.println("Welcome to the amazing digital chatbot! All our chatbots wants to be your friend!\nWhat will you name your future best friend? ");
    String botName = reader.nextLine();
    System.out.println("What is your name? ");
    String humanName = reader.nextLine();
    chatbot bot = new chatbot(botName);

    while (bot.checkKeyword(input) != "goodbye  ")
    {
      // human response
      System.out.print(humanName + ": ");
      input = (reader.nextLine() + "  ");
      // bot response
      String response = bot.respond(input);
      System.out.println(botName + ": " + response);
    }
    System.out.println("Chatbot has left the chat.");
    reader.close();
  }
}
