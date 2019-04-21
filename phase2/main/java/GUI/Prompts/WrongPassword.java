package GUI.Prompts;

public class WrongPassword extends PromptTemplate {
    /**
     * Create the frame.
     */
    public WrongPassword() {
        setTitle("That Ain't Dank");

        addToContent(createMainLabel("Wrong Login!"));

        addToContent(createSecondaryLabel("We can't recognize your \r\nusername or password. "));

        addToContent(createTryAgainLabel());
    }

}
