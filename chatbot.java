import java.util.Arrays;
class chatbot {
  private String[] keywordTypes = {"familyKeywords", "petsKeywords", "foodKeywords", "sportsKeywords", "musicKeywords"};

  private String[][] allKeywords = // keywords for the chatbot to recognize
  {
    {"brother ", "mother ", "father ", "sister "}, 
    {"cat ", "dog ", "fish ", "hamster "}, 
    {"pizza ", "burger ", "taco ", "salad "},
    {"soccer ", "basketball ", "football ", "baseball "}, 
    {"pop ", "rock ", "hiphop ", "country "} 
  };

  private String[][] allResponses = // responses for the chatbot to give based on keyword
  {
    {"Tell me more about your family.", "How is your family doing?", "What do you do for fun with your family?"}, 
    {"Tell me more about your pets.", "What is your favorite pet?", "Do you have any pets?"}, 
    {"Tell me more about your favorite food.", "What is your favorite food?", "Do you like to eat?"},
    {"Tell me more about your favorite sport.", "What is your favorite sport?", "Do you play any sports?"},
    {"Tell me more about your favorite music.", "What is your favorite music?", "Do you like to listen to music?"}
  };
  
  public chatbot() 
  {
    // constructor code here
  }

  private boolean containsKeyword(String inputText, String[] keywords) 
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

  public String detectKeyword(String text)
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
  public String respondToKeyword(String text)
  {
    String selectedKeyword = detectKeyword(text);
    int index = Arrays.asList(keywordTypes).indexOf(selectedKeyword);
    if (detectKeyword(text) == "none")
      {
      return "I don't know how to respond to that.";
      }
    else
      {
      return allResponses[index][(int) (Math.random() * allResponses[index].length)];
      }
  }
}
