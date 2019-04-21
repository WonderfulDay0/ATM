package Controller;

import Accounts.Account;
import GUI.Menus.DepositCashMenu;
import GUI.Menus.DepositMenu;
import GUI.Menus.MainMenu;
import GUI.Prompts.AccountNotSelected;
import GUI.Prompts.InvalidInput;
import GUI.Prompts.TransactionCompleted;
import GUI.Prompts.TransactionFailed;
import Transactions.TransactionDeposit;
import bankmain.ATM;

import java.util.stream.IntStream;

public class DepositCashMenuController {
    private ATM model;
    private DepositCashMenu view;

    public DepositCashMenuController(ATM atm, DepositCashMenu frame) {
        model = atm;
        view = frame;
    }

    public void initController() {
        view.getBackButton().addActionListener(e -> goBack());
        view.getEnterButton().addActionListener(e -> createDeposit());
    }

    private void goBack() {
        DepositMenu window = new DepositMenu();
        DepositMenuController dmc = new DepositMenuController(model, window);
        dmc.initController();
        window.setVisible(true);
        window.setLocationRelativeTo(view);
        view.dispose();
    }

    private void createDeposit() {
        if (cashBillVerifier()) {
            Account acc = view.getSelectedAccount();

            if (acc != null) {
                for (int i = 0; i < model.getBills().length; i++)
                    model.addBillsAtIndex(i, getCashBills()[i]);

                TransactionDeposit t = new TransactionDeposit(acc.getAccountID(), sumOfBills(getCashBills()));
                model.getTransactionManager().deposit(model.getCurrentUser(), t);
                TransactionCompleted w1 = new TransactionCompleted();
                w1.setVisible(true);
                w1.setLocationRelativeTo(view);

                MainMenu w2 = new MainMenu(model);
                MainMenuController mmc = new MainMenuController(model, w2);
                mmc.initController();
                w2.setVisible(true);
                w2.setLocationRelativeTo(view);
                view.dispose();
            } else {
                AccountNotSelected window = new AccountNotSelected();
                window.setVisible(true);
                window.setLocationRelativeTo(view);
            }
        } else {
            TransactionFailed failed = new TransactionFailed();
            failed.setVisible(true);
            failed.setLocationRelativeTo(view);
        }
    }

    /**
     * Collects information from the text fields in DepositCashMenu
     *
     * @return an array containing the number of bills collected from text fields
     */
    private int[] getCashBills() {
        String five = view.getTxtFiveBills().getText().trim();
        String ten = view.getTxtTenBills().getText().trim();
        String twenty = view.getTxtTwentyBills().getText().trim();
        String fifty = view.getTxtFiftyBills().getText().trim();
        String hund = view.getTxtHundredBills().getText().trim();

        int[] tempArray;

        if (five.matches("[0-9]+") && ten.matches("[0-9]+") && twenty.matches("[0-9]+")
                && fifty.matches("[0-9]+") && hund.matches("[0-9]+")) {
            tempArray = new int[]{Integer.parseInt(five), Integer.parseInt(ten), Integer.parseInt(twenty),
                    Integer.parseInt(fifty), Integer.parseInt(hund)};
        } else {
            tempArray = new int[]{0,0,0,0,0};
        }
        System.out.println(tempArray[0]+" "+tempArray[1]+" "+tempArray[2]);
        return tempArray;

    }

    private int sumOfBills(int[] bills) {
        return 5*bills[0] + 10*bills[1] + 20*bills[2] + 50*bills[3] + 100*bills[4];
    }

    /**
     * Checks the input fields for validity
     *
     * @return true if all number of bills is not negative and at least 1 entry is greater than 0, false otherwise
     */
    private boolean cashBillVerifier() {
        int[] billList = getCashBills();

        boolean allZero = true;

        for (int i = 0; i < 5; i++) {
            if (billList[i] > 0)
                allZero = false;
        }

        return !allZero;
    }
}
