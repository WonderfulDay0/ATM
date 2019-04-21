package Controller;

import GUI.Menus.MainMenu;
import GUI.Menus.ViewTransactions;
import GUI.Prompts.CannotUndo;
import GUI.Prompts.TransactionCompleted;
import Transactions.Transaction;
import Transactions.TransactionToOther;
import Transactions.TransactionToSelf;
import bankmain.ATM;

public class ViewTransactionsController {

    private ATM model;
    private ViewTransactions view;

    public ViewTransactionsController(ATM atm, ViewTransactions frame) {
        model = atm;
        view = frame;
    }

    public void initController() {
        view.getUndoButton().addActionListener(e -> deleteSelected());
        view.getGoBackButton().addActionListener(e -> goBack());
    }

    private void deleteSelected(){
        Transaction t = view.getTransactionJList().getSelectedValue();

        if (t.checkReversible()){
            if (t instanceof TransactionToSelf) {
                TransactionToSelf new_trans = new TransactionToSelf(((TransactionToSelf) t).getAccTo(),
                        model.getCurrentUser(), t.getAccountFrom(), t.getAmount());
                //Reverted transactions cannot be reverted again.
                new_trans.setReversible(false);
                t.setReversible(false);
                if (model.getTransactionManager().transact(new_trans)) {
                    model.getUserManager().getUser(model.getCurrentUser()).getAccountMap().get(t.getAccountFrom()).addBalance(t.getAmount());
                    TransactionCompleted tc = new TransactionCompleted();
                    tc.setVisible(true);
                    tc.setLocationRelativeTo(view);
                } else {
                    CannotUndo cu = new CannotUndo();
                    cu.setVisible(true);
                    cu.setLocationRelativeTo(view);
                }
            } else if (t instanceof TransactionToOther) {
                TransactionToOther new_trans = new TransactionToOther(((TransactionToOther) t).getAccTo(),
                        ((TransactionToOther) t).getUserTo(),
                        t.getAccountFrom(), model.getCurrentUser(), t.getAmount());
                //Reverted transactions cannot be reverted again.
                new_trans.setReversible(false);
                t.setReversible(false);
                if (model.getTransactionManager().transact(new_trans)) {
                    TransactionCompleted tc = new TransactionCompleted();
                    tc.setVisible(true);
                    tc.setLocationRelativeTo(view);
                } else {
                    CannotUndo cu = new CannotUndo();
                    cu.setVisible(true);
                    cu.setLocationRelativeTo(view);
                }
            }
            view.updateTransactions();

        } else {
            CannotUndo cu = new CannotUndo();
            cu.setVisible(true);
            cu.setLocationRelativeTo(view);
        }
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