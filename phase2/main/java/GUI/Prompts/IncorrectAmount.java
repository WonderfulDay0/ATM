package GUI.Prompts;

import bankmain.ATM;

public class IncorrectAmount extends PromptTemplate {

    /**
     * Create the frame.
     */
    public IncorrectAmount(ATM atm) {
        setTitle("That Ain't Dank");

        addToContent(createMainLabel("That's not right!"));

        addToContent(createSecondaryLabel("You can't input that amount!"));

        addToContent(createTryAgainLabel());
    }
}
