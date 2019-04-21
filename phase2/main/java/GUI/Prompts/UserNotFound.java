package GUI.Prompts;

public class UserNotFound extends PromptTemplate {
    /**
     * Create the frame.
     */
    public UserNotFound() {
        setTitle("That Ain't Dank");

        addToContent(createMainLabel("Username Not Found!"));

        addToContent(createSecondaryLabel("The user you entered does not exist!"));

        addToContent(createTryAgainLabel());
    }
}
