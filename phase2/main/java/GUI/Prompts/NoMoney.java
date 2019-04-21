package GUI.Prompts;

public class NoMoney extends PromptTemplate {
    /**
     * Create the frame.
     */
    public NoMoney() {
        setTitle("That Ain't Dank");

        addToContent(createMainLabel("Not Enough Money!"));

        addToContent(createSecondaryLabel("You don't have enough money in your account!"));

        addToContent(createTryAgainLabel());
    }
}
