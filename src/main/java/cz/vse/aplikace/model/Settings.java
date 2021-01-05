package cz.vse.aplikace.model;

public class Settings {
    private String currency;
    private String language;
    private boolean premium;
    private boolean theme;

    public Settings() {
        //budeme muset trochu domyslet, co všechno budeme chtít nastavit při zalogování do aplikace, například premium bych dal spíše do uživatele
        //a jazyk a kurz záleží jestli dáme nějaké defaultní nebo zase uložíme do uživatele
    }

    public void logOutUser(){
        //tady pak nastavit přechod na obrazovku přihlášení
    }

    public void changeTheme(){
        if (premium){premium = false;}
        else {premium = true;}
    }

    public void changePassword(RegisteredUser user, String newPassword){
        user.setPassword(newPassword);
    }

    public void setPremium(){
        //nastavení premium by mělo být na uživateli nějaký boolean
    }

    public void changeMenu(){
        //nejsem si úplně jistý na co je tato funkce
    }

    public void changeLanguage(String newLanguage){
        language = newLanguage;
    }

    public double countTurnOver(){
        double obrat = 0;
        return obrat;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getLanguage() {
        return language;
    }

    public boolean isPremium() {
        return premium;
    }

    public void setPremium(boolean premium) {
        this.premium = premium;
    }

    public boolean isTheme() {
        return theme;
    }
}
