import java.util.Arrays;

class chatbot {
  private String[][] keywords = { // simplifies pronouns to 4 basic pronouns
      { // ME STATEMENTS
          "me", "i", "my", "myself", "we", "us"
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

  private String[][] basicResponse = { // Responses without stating context
      { // ME RESPONSES
          "What makes you think that about yourself?", "Why do you see yourself as that?",
          "Why that particular self-perception?", "Tell me more about yourself.", "What else do you think of yourself?"
      },
      { // YOU RESPONSES
          "Why do you feel this way about me?", "What did I do for you to think that way about me?",
          "Why do you think that way about me?"
      },
      { // IT RESPONSES
          "Why do you feel that way about it?", "How did it affect you?", "Tell me more about it.",
          "What else do you think of it?"
      },
      { // THEY RESPONSES
          "How do you feel about them?", "What do you think about them?", "Why do you think that way about them?",
          "What else do you think of them?"
      },
  };
  private String[][] contextResponse = { // Responses with variable context 
    {
      // context here
    }

  private String[] removedWords = { // words removed in input to make it easier to process
      "am", "is", "are", "was", "were", "be", "been", "being", "the"
  };

  public chatbot(String name) {
    System.out.println("Chatbot initiated, my name is " + name + ".");
  }

  public String detectMessageType(String input) { // find one of 4 pronoun types
    for (int i = 0; i < keywords.length; i++) {
      for (int j = 0; j < keywords[i].length; j++) {
        String currentKeyword = keywords[i][j] + " ";
        if (input.contains(currentKeyword)) {
          return keywords[i][0];
        }
      }
    }
    return "none";
  }

  public String simplifyInput(String originalInput) // makes input code-readable
  { // clean up original input
    String input = originalInput.replaceAll("[^a-zA-Z0-9\\s]", "").toLowerCase();

    for (int i = 0; i < removedWords.length; i++) { // remove words from removedWords list
      input = input.replace(removedWords[i] + " ", "");
    }

    // get message pronoun type
    String messageType = detectMessageType(input);

    int index = -1;
    for (int i = 0; i < keywords.length; i++) { // find keyword that corresponds with pronoun type
      if (Arrays.asList(keywords[i]).contains(messageType)) {
        index = i;
        break;
      }
    }
    if (index != -1) { // simplifies pronoun to most basic form
      for (int j = 0; j < keywords[index].length; j++) {
        input = input.replace(keywords[index][j] + " ", keywords[index][0] + " ");
      }
    }
    return input;
  }
  // other function
}