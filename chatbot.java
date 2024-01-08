import java.util.ArrayList;
class Chatbot {

  private String[] keywordTypes = {"familyKeywords", "petsKeywords", "foodKeywords", "sportsKeywords", "musicKeywords"};
  
  private String[] familyKeywords = {"brother", "mother", "father", "sister"};
  private String[] petsKeywords = {"cat", "dog", "fish", "hamster"};
  private String[] foodKeywords = {"pizza", "burger", "taco", "salad"};
  private String[] sportsKeywords = {"soccer", "basketball", "football", "baseball"};
  private String[] musicKeywords = {"pop", "rock", "hip hop", "country"};
                                    
  public Chatbot() 
  {
    // constructor code here
  }

  public string detectKeyword(string text)
  {
    inputText = text.toLoweCase.replaceAll("\\s",""); // turns input to lowercase no spaces

    for (int i = 0; i < keywordTypes.length; i++) 
    {
      if (Arrays.asList(keywordTypes[i]).contains(inputText));
      {
        return keywordTypes[i];
      }
      
    }
    
  }
}