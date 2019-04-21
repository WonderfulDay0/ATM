package Managers;

import bankmain.ATM;
import InputOutput.ReaderText;

import java.io.Serializable;
import java.util.ArrayList;

public class ATMManager implements Serializable {
    private static final long serialVersionUID = 23L;
    private transient ArrayList<ATM> atms = new ArrayList<>();

    public void checkAlerts(ATM atm) {
        boolean[] restockCheck = ReaderText.readAlerts("alerts.txt");

        for(int i=0; i < atm.getBills().length; i++){
             if(restockCheck[i]){
                atm.addBillsAtIndex(i, 200);
            }
        }
    }
}
