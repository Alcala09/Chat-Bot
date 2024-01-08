import java.util.Arrays;

class chatbot {

  private String[] keywordTypes = {"familyKeywords", "petsKeywords", "foodKeywords", "sportsKeywords", "musicKeywords"};

  private String[][] allKeywords = {
    {"brother", "mother", "father", "sister"},
    {"cat", "dog", "fish", "hamster"},
    {"pizza", "burger", "taco", "salad"},
    {"soccer", "basketball", "football", "baseball"},
    {"pop", "rock", "hiphop", "country"}
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

    for (int i = 0; i < keywordTypes.length; i++) 
    {
      if (containsKeyword(inputText, allKeywords[i]))
      {
        return keywordTypes[i];
      }
    }
    return "none";
  }
}
