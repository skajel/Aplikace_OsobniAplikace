package cz.vse.aplikace.model;

import java.util.HashMap;
import java.util.Map;

public class Wallet {

    private final Map<String, Wallet> walletName;
    public double accountBalance;
    public String walletDesription;


    public Wallet(String walletDesription, double accountBalance) {
        this.accountBalance = accountBalance;
        this.walletDesription = walletDesription;
        walletName = new HashMap<>();
    }

    public void addWallet(Wallet wallet) {
        walletName.put(String.valueOf(wallet.getWalletName()), wallet);
    }

    public void showWallet() {

    }

    public void editWallet() {

    }

    public void removeWallet() {

    }


    public Map<String, Wallet> getWalletName() {
        return walletName;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public String getWalletDesription() {
        return walletDesription;
    }
}
