package GUI.Prompts;

public class TransactionCompleted extends PromptTemplate {
    /**
     * Create the frame.
     */
    public TransactionCompleted() {
        setTitle("That's So Dank!");

        addToContent(createMainLabel("Transaction Completed!"));

        addToContent(createSecondaryLabel("Your transaction was successful!"));
    }
}
