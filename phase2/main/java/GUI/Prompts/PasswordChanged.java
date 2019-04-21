package GUI.Prompts;

public class PasswordChanged extends PromptTemplate {
    /**
     * Create the frame.
     */
    public PasswordChanged() {
        setTitle("Super Dank!");

        addToContent(createMainLabel("Password Changed!"));
    }
}
