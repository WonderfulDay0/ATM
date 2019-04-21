package Controller;

import GUI.Menus.*;
import bankmain.ATM;

public class ViewBalancesController {

    private ATM model;
    private ViewBalances view;

    public ViewBalancesController(ATM atm, ViewBalances frame) {
        model = atm;
        view = frame;
    }

    public void initController() {
        view.getGoBackButton().addActionListener(e -> goBack());
    }

    private void goBack() {
        MainMenu mm = new MainMenu(model);
        MainMenuController mmc = new MainMenuController(model, mm);
        mmc.initController();
        mm.setVisible(true);
        mm.setLocationRelativeTo(view);
        view.dispose();
    }

}