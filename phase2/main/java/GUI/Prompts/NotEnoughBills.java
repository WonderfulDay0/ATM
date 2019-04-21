package GUI.Prompts;

public class NotEnoughBills extends PromptTemplate {
    public NotEnoughBills() {
        setVisible(true);
        addToContent(createMainLabel("Not enough bills in ATM!"));

        addToContent(createSecondaryLabel("Please withdraw a smaller amount!"));
    }
}
