package GUI.Prompts;

public class DifferentPasswords extends PromptTemplate {

    /**
     * Create the frame.
     */
    public DifferentPasswords() {
        setTitle("That Ain't Dank");

        addToContent(createMainLabel("Uh Oh!"));

        addToContent(createSecondaryLabel("Your passwords don't match!"));

        addToContent(createTryAgainLabel());
    }
}
