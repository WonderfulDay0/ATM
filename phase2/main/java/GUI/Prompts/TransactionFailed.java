package GUI.Prompts;

public class TransactionFailed extends PromptTemplate {
    /**
     * Create the frame.
     */
    public TransactionFailed() {
        setTitle("That Ain't Dank!");

        addToContent(createMainLabel("Transaction Failed!"));

        addToContent(createSecondaryLabel("Your transaction wasn't completed!"));
    }
}
