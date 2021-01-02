package cz.vse.aplikace.model;

import java.util.HashMap;
import java.util.Map;

public class Wallet {

    private final Map<String, Wallet> walletName;
    public int accountBalance;
    public String walletDesription;


    public Wallet(String walletDesription, int accountBalance) {
        this.accountBalance = accountBalance;
        this.walletDesription = walletDesription;
        walletName = new HashMap<>();
    }


    public void addWallet(Wallet wallet) {

    }

    public void showWallet() {

    }

    public void changeWallet() { //přejmenoval bych na editWallet() ...šesták

    }

    public void deleteWallet() { //přejmenoval bych na removeWallet() ...šesták

    }


    public Map<String, Wallet> getWalletName() {
        return walletName;
    }

    public int getAccountBalance() {
        return accountBalance;
    }

    public String getWalletDesription() {
        return walletDesription;
    }
}
