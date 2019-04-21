package GUI.Prompts;

public class UsernameTaken extends PromptTemplate {
    /**
     * Create the frame.
     */
    public UsernameTaken() {
        setTitle("That Ain't Dank");

        addToContent(createMainLabel("Username Taken!"));

        addToContent(createSecondaryLabel("This username is already in use."));

        addToContent(createTryAgainLabel());
    }

}

