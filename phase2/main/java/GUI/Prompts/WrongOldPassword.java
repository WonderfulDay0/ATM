package GUI.Prompts;

public class WrongOldPassword extends PromptTemplate {
    /**
     * Create the frame.
     */
    public WrongOldPassword() {
        setTitle("That Ain't Dank");

        addToContent(createMainLabel("Uh Oh!"));

        addToContent(createSecondaryLabel("Your old password doesn't match our records!"));

        addToContent(createTryAgainLabel());
    }
}
