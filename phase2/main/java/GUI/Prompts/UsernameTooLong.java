package GUI.Prompts;

public class UsernameTooLong extends PromptTemplate {
    /**
     * Create the frame.
     */
    public UsernameTooLong() {
        setTitle("That Ain't Dank");

        addToContent(createMainLabel("Username Too Long!"));

        addToContent(createSecondaryLabel("Your username should be 10 characters max!"));

        addToContent(createTryAgainLabel());
    }
}
