import java.util.Arrays;
class chatbot {
  private String[] keywordTypes = {"family", "pets", "food", "sports", "music", "greeting", "weather", "time"};

  private String[][] allKeywords = // keywords for the chatbot to recognize
  {
    {"brother ", "mother ", "father ", "sister ", "grandpa ", "grandma "}, // family 
    {"cat ", "dog ", "fish ", "hamster ", "armadillo ", "shark ", "ferret "},  // pet
    {"pizza ", "burger ", "taco ", "salad ", "burrito ", "beef ", "chicken "}, // food
    {"soccer ", "basketball ", "football ", "baseball ", "wrestling ", "golf "},  // sports
    {"pop ", "rock ", "hiphop ", "country ", "song ", "rap ", "jazz "}, // music
    {"hello ", "hi ", "hey ", "good morning ", "good afternoon ", "good evening"}, // greeting
    {"weather ", "temperature ", "humidity ", "wind ", "rain ", "snow ", "thunderstorm ", "hurricane"}, // weather
    {"time ", "date ", "day ", "month ", "year "}, // time
  };

  private String[][] allResponses = // responses for the chatbot to give based on keyword
  {
    {"Tell me more about your family.", "How is your family doing?", "What do you do for fun with your family?"}, // family
    {"Tell me more about your pets.", "What is your favorite pet?", "Do you have any pets?"}, // pet
    {"Tell me more about your favorite food.", "What is your favorite food?", "Do you like to eat?"}, // food
    {"Tell me more about your favorite sport.", "What is your favorite sport?", "Do you play any sports?"}, // sport
    {"Tell me more about your favorite music.", "What is your favorite music?", "Do you like to listen to music?"}, // music
    {"Hello, how are you?", "Hi, how are you?", "Hey, how are you?", "yo", "what's up?"}, // greeting
    {"What is the weather like today?", "What is the temperature today?", "What is the humidity today?", "I don't really care about weather"}, // weather
    {"What is the time?", "What is the date?", "What is the day?", "What is the month?", "I don't know what time it is"}, // weather
  };

  public chatbot(String name) 
  {
    System.out.println("Chatbot initiated, my name is " + name + ".");
  }

  private boolean containsKeyword(String inputText, String[] keywords) // checks if string contains any keyword in keywordtype
  {
      for (String keyword : keywords) 
      {
          if (inputText.contains(keyword)) 
          {
              return true;
          }
      }
      return false;
  }

  public String detectKeyword(String text) // returns keyword type detected from text
  {
    String inputText = text.replaceAll("[^a-zA-Z0-9\\s]", ""); // removes special characters & spaces
    inputText += " ";
    for (int i = 0; i < keywordTypes.length; i++) // checks for keyword
    {
      if (containsKeyword(inputText, allKeywords[i]))
      {
        return keywordTypes[i];
      }
    }
    return "none";
  }
  public String respondToKeyword(String text) // Finds text response based on keyword detected
  {
    String selectedKeyword = detectKeyword(text);
    int index = Arrays.asList(keywordTypes).indexOf(selectedKeyword);
    if (detectKeyword(text).equals("none"))
      {
      return "I don't know how to respond to that.";
      }
    else
      {
      return allResponses[index][(int) (Math.random() * allResponses[index].length)];
      }
  }
}
