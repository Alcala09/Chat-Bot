import java.util.Scanner;
class Main {
  public static void main(String[] args) {
    chatbot bot = new chatbot();
    Scanner reader = new Scanner(System.in);
    while (true)
    {
      System.out.print("Chat: ");
      String input = reader.nextLine();
      System.out.println(bot.detectKeyword(input));
    }
  }
}