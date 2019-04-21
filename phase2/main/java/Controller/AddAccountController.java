package Controller;

import GUI.Menus.AddAccount;
import GUI.Menus.MainMenu;
import GUI.Menus.UserAndAccountSettings;
import GUI.Prompts.AccountNotSelected;
import GUI.Prompts.UserNotFound;
import bankmain.ATM;

public class AddAccountController {
    private ATM model;
    private AddAccount view;

    public AddAccountController(ATM atm, AddAccount frame) {
        model = atm;
        view = frame;
    }

    public void initController() {
        view.getGoBackButton().addActionListener(e -> goBack());
        view.getEnterButton().addActionListener(e -> createAccount());
        view.getCheckBox().addActionListener(e -> enableTextField());
    }

    private void goBack() {
        UserAndAccountSettings window = new UserAndAccountSettings();
        UserAndAccountSettingsController waasc = new UserAndAccountSettingsController(model, window);
        waasc.initController();
        window.setVisible(true);
        window.setLocationRelativeTo(view);
        view.dispose();
    }

    private void enableTextField(){
        if (view.getCheckBox().isSelected()){
            view.getUserToField().setEnabled(true);
        }
    }

    private void createAccount() {
        String accType = String.valueOf(Integer.parseInt(view.getAccountTypeSelected()) + 1);

        if (view.getCheckBox().isSelected()) {
            String userID = view.getUserToField().getText().trim();

            if (model.getUserManager().getUserMap().containsKey(userID)) {
                model.getUserManager().createAccount(accType, model.getCurrentUser(), userID);

                sendToMainMenu();
            } else {
                UserNotFound unf = new UserNotFound();
                unf.setVisible(true);
                unf.setLocationRelativeTo(view);
            }
        } else {
            model.getUserManager().createAccount(accType, model.getCurrentUser());

            sendToMainMenu();
        }
    }

    private void sendToMainMenu() {
        MainMenu mm = new MainMenu(model);
        MainMenuController mmc = new MainMenuController(model, mm);
        mmc.initController();
        mm.setLocationRelativeTo(view);
        mm.setVisible(true);
        view.dispose();
    }
}