package GUI.Prompts;

public class AccountNotSelected extends PromptTemplate {

    /**
     * Create the frame.
     */
    public AccountNotSelected() {
        setTitle("That Ain't Dank");
        addToContent(createMainLabel("No Account Selected!"));

        addToContent(createSecondaryLabel("You didn't select an account!"));

        addToContent(createTryAgainLabel());
    }
}
