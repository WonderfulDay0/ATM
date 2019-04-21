package GUI.Prompts;

public class WrongRecipient extends PromptTemplate {
    /**
     * Create the frame.
     */
    public WrongRecipient() {
        setTitle("That Ain't Dank");

        addToContent(createMainLabel("User Does Not Exist!"));

        addToContent(createSecondaryLabel("That user does not exist in our system!"));

        addToContent(createTryAgainLabel());
    }
}
