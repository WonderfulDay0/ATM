package GUI.Prompts;

public class InvalidAccountNum extends PromptTemplate {
    /**
     * Create the frame.
     */
    public InvalidAccountNum() {
        setTitle("That Ain't Dank");

        addToContent(createMainLabel("Account ID Doesn't Belong!"));

        addToContent(createSecondaryLabel("The ID entered doesn't belong to the user entered."));

        addToContent(createTryAgainLabel());
    }
}
