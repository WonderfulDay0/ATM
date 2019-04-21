package Controller;

import Accounts.Account;
import GUI.Menus.MainMenu;
import GUI.Menus.TransactionMenu;
import GUI.Menus.Withdraw;
import GUI.Prompts.*;
import Transactions.TransactionDeposit;
import Transactions.TransactionWithdrawal;
import bankmain.ATM;

import java.util.stream.IntStream;

public class WithdrawController {
    private ATM model;
    private Withdraw view;


    public WithdrawController(ATM atm, Withdraw frame) {
        model = atm;
        view = frame;
    }

    public void initController() {
        view.getEnterButton().addActionListener(e -> withdraw());
        view.getBackButton().addActionListener(e -> goBack());
    }

    private void withdraw() {
        if (cashBillVerifier()) {
            Account acc = view.getSelectedAccount();
            for (int i = 0; i < model.getBills().length; i++)
                model.addBillsAtIndex(i, -getCashBills()[i]);

            TransactionWithdrawal t = new TransactionWithdrawal(acc.getAccountID(),
                    model.getCurrentUser(), sumOfBills(getCashBills()));
            if (model.getTransactionManager().transact(t)) {
                model.checkBills();
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
                TransactionFailed failed = new TransactionFailed();
                failed.setVisible(true);
                failed.setLocationRelativeTo(view);
            }
        } else {
            InvalidInput ii = new InvalidInput();
            ii.setVisible(true);
            ii.setLocationRelativeTo(view);
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

        for (int i = 0; i < 5; i++) {
            if (tempArray[i] > model.getBills()[i]) {
                NotEnoughBills neb = new NotEnoughBills();
                neb.setVisible(true);
                neb.setLocationRelativeTo(view);
                tempArray = new int[]{0,0,0,0,0};
                break;
            }
        }

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

    private void goBack() {
        TransactionMenu tm = new TransactionMenu();
        TransactionMenuController tmc = new TransactionMenuController(model, tm);
        tmc.initController();
        tm.setVisible(true);
        tm.setLocationRelativeTo(view);
        view.dispose();
    }


}
