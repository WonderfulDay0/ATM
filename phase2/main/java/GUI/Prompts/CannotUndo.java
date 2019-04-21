package GUI.Prompts;

public class CannotUndo extends PromptTemplate {

    /**
     * Create the frame.
     */
    public CannotUndo() {
        setTitle("That Ain't Dank");

        addToContent(createMainLabel("Can't Undo!"));

        addToContent(createSecondaryLabel("This transaction cannot be undone!"));

        addToContent(createTryAgainLabel());
    }
}
