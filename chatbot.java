import java.util.Arrays;

class chatbot {
  private String name;
  private Map<String, String[]> topics;

  public chatbot(String name) 
  { // assigns chatbot a name and writes introduction
    this.name = name;
    this.topics = new HashMap<>();
    System.out.println("Chatbot initiated. My name is " + name);
    // INPUT PRE-DEFINED TOPICS AND KEYWORDS
    topics.put("greetings", new String[] {"hello", "hi", "hey"});
  }

  public String[] prepareInput(String originalInput) 
  { // makes all text uniform and split into array
    originalInput = this.originalInput.replaceAll("[^a-zA-Z0-9 ]", "").toLowerCase();
    String[] Input = originalInput.split("//s+");
    return Input;
  }
  
  private void addTopic(String newTopic) 
  { // Adds a new topic to chatbot where keywords will be placed
    topics.put(topic, new String[] {});
  }

  private void addKeyword(String topic, String keyword) 
  { // Adds a keyword to a topic
    if (topics.containsKey(topic)) 
    {
      String[] keywords = Arrays.copyOf(topics.get(topic), topics.get(topic).length + 1);
      keywords[keywords.length - 1] = keyword;
      topics.put(topic, keywords);
    }
  }

  
}