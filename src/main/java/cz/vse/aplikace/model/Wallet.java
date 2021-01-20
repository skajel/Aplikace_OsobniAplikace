package cz.vse.aplikace.model;

import java.util.HashMap;
import java.util.Map;

public class Wallet {

    private final Map<String, Wallet> walletName;
    public double accountBalance;
    public String walletDescription;
    private Wallet wallet;


    public Wallet(String walletDescription, double accountBalance) {
        this.accountBalance = accountBalance;
        this.walletDescription = walletDescription;
        walletName = new HashMap<>();
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
        walletName.put(String.valueOf(wallet.getWalletName()), wallet);
    }

    public Wallet getWallet() {
        return wallet;
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

    public String getWalletDescription() {
        return walletDescription;
    }

}
