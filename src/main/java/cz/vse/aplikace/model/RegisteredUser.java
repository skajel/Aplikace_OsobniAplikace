package cz.vse.aplikace.model;

public class RegisteredUser {

    private Wallet wallet;
    private OverallOverview overallOverview;
    private TransactionOverview transactionOverview;
    private Settings settings;

    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private String email;

    public RegisteredUser(String firstName, String lastName, String userName, String password, String email){
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.email = email;

        wallet = new Wallet( "default", 0);
        overallOverview = new OverallOverview();
        transactionOverview = new TransactionOverview();
        settings = new Settings();

    }


    public String getFirstName() {
        return firstName;
    }


    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
