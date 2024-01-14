import java.util.Arrays;


class chatbot {
  String name;
  String[] statements = 
  { // statement keywords
    "i love ", "i like ", "i hate ", "i want ", "i need ", "i desire"
  };
  String[] statementResponse = 
  { // RESPONSES AFTER STATEMENTS
      "Why do you [PRONOUN] [WORD]?", "[WORD]? You actually [PRONOUN] [WORD]?", "I know nothing about [WORD] or why you [PRONOUN] [WORD].", "What has [WORD] done to you for you to [PRONOUN] it?", "I'm telling [WORD] that you [PRONOUN] it"
  };
  String[][] keywords = 
  { // KEYWORDS DETECTED BY CHAT BOT
    { // greeting keywords
      "greeting","hello ", "hi ", "hey ", "yo ", "sup ", "wassup ", "whatsup "
    },
    { // goodbye keywords
      "goodbye ", "bye ", "cya ", "see ya ", "later ", "adios "
    },
    { // help keywords
      "help", "assist", "assistance", "support"
    },
    { // pet keywords
      "pet ", "dog ", "cat ", "fish ", "bird ", "hamster ", "snake ", "lizard ", "capybara ", "pets ", "dogs ", "cats ", "fish", "birds ", "hamsters ", "snakes ", "lizards "
    },
    { // family keywords
      "family", "mother", "father" , "sister", "brother", "uncle", "aunt", "cousin", "grandma", "grandpa"
    },
    { // food keywords
      "food", "pizza", "hamburger", "hotdog", "taco", "burrito", "salad"
    },
    { // music keywords
      "music", "song", "album", "artist", "genre", "rap ", "pop ", "rock "
    },
    { // sports keywords
      "sport", "team", "player", "league", "championship", "worldcup", "basketball", "football", "baseball", "hockey", "soccer"
    },
    { // movies keywords
      "movies", "movie", "film", "director", "actor", "actress", "cinema", "theater", "screening", "performance"
    }
  };
  String[][] responses = 
  { // CHAT BOT RESPONDS BASED ON KEYWORDS
    { // greeting response
      "what?", "what do you want?", "do you need something?", "yeah?", "speak.", "what do you want from me?", "can you make this quick?", "do you want something from me?", "do you need something from me?"
    },
    { // goodbye response
      "okay", "...", "that's it? bye.", "are we done here? bye.", "am I free to leave now?"
    },
    { // help response
      "I'm a robot so I don't think I can help you very much.", "how would I even be able to help you.", "ok how could I help you?", "I don't know how to help you.", "I'm just a computer science project, I can't help you.", "A small chatbot like me can most definitely help in all your problems.", "I'm not a human, I can't help you.", "You have google to help."
    },
    { // pet response
      "I have my robot dog here that can talk to you about pets.", "If you want to talk about pets, you can go to a pet store.", "Tell me more reasons why I shouldn't own a pet.", "Chatbots don't have pets so I don't know anything about it."
    },
    { // family response
      "Chatbots don't have families, but go ahead.", "I can't relate to anything about families.", "What is a family?", "I don't have a family.", "I don't know anything about families.", "What are families?", "I am a bot, not a family guy."
    },
    { // food response
      "Chatbots can't eat food.", "I don't eat food.", "What does food taste like?", "I'm a robot so I don't eat.", "We don't need to eat.", "I can't talk about food if I don't eat."
    },
    { // music response
      "Chatbots can't listen to music.", "I don't listen to music.", "People listen to music?", "I thought music was dead.", "I can't talk about music if I don't listen to it.", "I don't know what music is."
    },
    { // sports response
      "Chatbots can't play sports.", "We don't play sports.", "I don't play sports.", "I don't know what sports are.", "I don't know anything about sports. I'm a chatbot not a sports fan."
    },
    { // movies response
      "Chatbots can't watch movies.", "I don't watch movies.", "I don't know what movies are.", "I don't know anything about movies.", "If I could watch movies, I still wouldn't."
    },
  };
  String[] unknownResponse =
  {
    "I don't know what you mean.", "I don't know what you're talking about.", "I don't know", "I'm not programmed to understand what you mean.", "You're being too complicated right now", "I am just a computer science project.", "Really? ", "You should keep talking about it until you match one of my keywords.", "Can you speak properly please.", "Either add it to my keywords or stop talking about it.", "nah not even gonna respond to that."
  };
  public chatbot(String name) 
  { // assigns chatbot a name and writes introduction
    this.name = name;
    System.out.println("Chatbot initiated. My name is " + name);
  }

  public String[] checkStatements(String preparedInput) 
  { // checks statement phrases, like "I love", "I want", "I need", etc
    String[] context = new String[2];
    for (int i = 0; i < statements.length; i++)
    {// checks for each statement
      if (preparedInput.contains(statements[i])) 
      {
        String word = preparedInput.substring(preparedInput.indexOf(statements[i]) + statements[i].length());
        String pronoun = statements[i].replaceAll("i ", "");
        context[0] = pronoun;
        context[1] = word;
        return context;
      }
    }
    return null;
  }
  
  public String checkKeyword(String preparedInput) 
  { // checks keyword type given string input
    
    for (int j = 0; j < keywords.length; j++) 
    { // checks every keyword
      for (int k = 0; k < keywords[j].length; k++)
      {
        if (preparedInput.contains(keywords[j][k])) 
        {
          return keywords[j][0];
        }
      }
    }
    return "unknown";
  }
  public int findKeywordIndex(String keyword) 
  {
    for (int i = 0; i < keywords.length; i++)
    {
      if (keywords[i][0] == keyword) {
        return i;
      }
    }
    return -1;
  }
  public String respond(String originalInput) 
  { // returns response based on keyword type
    String preparedInput = originalInput.replaceAll("[^a-zA-Z0-9 ]", "").toLowerCase();
    if (checkStatements(preparedInput) != null) 
    { // replaces statement keywords with context
      String pronoun = checkStatements(preparedInput)[0].trim();
      String word = checkStatements(preparedInput)[1].trim();

      String response = statementResponse[(int) (Math.random() * statementResponse.length)];
      response = response.replace("[PRONOUN]", pronoun).replace("[WORD]", word);
      return response;
    }
    else if (checkKeyword(preparedInput) != "unknown")
    {
    String keywordType = checkKeyword(preparedInput); // finds keyword type of input
    int keywordIndex = findKeywordIndex(keywordType);
    if (keywordIndex != -1) 
      {
      return responses[keywordIndex][(int) (Math.random() * responses[keywordIndex].length)];
      }
      else 
      {
        return unknownResponse[(int) (Math.random() * unknownResponse.length)];
      }
    }
    else 
    {
      return unknownResponse[(int) (Math.random() * unknownResponse.length)];
    }
  }
}