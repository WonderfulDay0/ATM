package GUI.Prompts;

public class InvalidInput extends PromptTemplate {
    public InvalidInput() {
        setTitle("Wrong Input Type!");
        addToContent(createMainLabel("You have entered an invalid input!"));
        addToContent(createSecondaryLabel("Please enter a valid input format!"));
    }
}
