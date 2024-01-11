import java.util.Arrays;

class chatbot {
  private String[][] keywords = {
      { // ME STATEMENTS
          "me", "i", "my", "myself", "we", "us", "i am"
      },
      { // YOU STATEMENTS
          "you", "your", "yourself"
      },
      { // IT STATEMENTS
          "it", "its", "thing"
      },
      { // THEY STATEMENTS
          "they", "their", "theyre", "person", "he", "she", "them", "themself"
      },
  };

  public chatbot(String name) {
    System.out.println("Chatbot initiated, my name is " + name + ".");
  }

  public String detectMessageType(String input) {
    for (int i = 0; i < keywords.length; i++) {
      for (int j = 0; j < keywords[i].length; j++) {
        if (input.contains(keywords[i][j])) {
          return keywords[i][0];
        }
      }
    }
    return "none";
  }

  public String simplifyInput(String originalInput) // makes input code-readable
  {
    String input = originalInput.toLowerCase();
    String messageType = detectMessageType(input);
    
    int index = -1;
    for (int i = 0; i < keywords.length; i++) 
    {
      if (Arrays.asList(keywords[i]).contains(messageType))
      {
        index = i;
        break;
      }
    }
      for (int j = 0; j < keywords[index].length; j++) 
        {
          input = input.replace(keywords[index][j], keywords[index][0]);
        }

    return input;
  }
  // other function
}
