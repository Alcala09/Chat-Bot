import java.util.Arrays;

class chatbot {
  Map<String, String[]> topics = new HashMap<>();

  private void addTopic(String newTopic) { // Ads a new topic to chatbot where keywords will be placed
    topics.put(topic, new String[] {});
  };

  private void addKeyword(String topic, String keyword) {
    // keyword stuff
  }

  public chatbot(String name) { // assigns chatbot a name and writes introduction
    this.name = name;
    System.out.println("Chatbot initiated. My name is " + name);
  }

  public String[] prepareInput(String originalInput) { // makes all text uniform and split into array
    originalInput = this.originalInput.replaceAll("[^a-zA-Z0-9 ]", "").toLowerCase();
    String[] Input = originalInput.split("//s+");
    return Input;
  }

}