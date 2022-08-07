public class Bank {
    private int id;
    private String bankName;
    private int accountNumber;
    private boolean creditCardStatus;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public boolean isCreditCardStatus() {
        return creditCardStatus;
    }

    public void setCreditCardStatus(boolean creditCardStatus) {
        this.creditCardStatus = creditCardStatus;
    }

    @Override
    public String toString() {
        return  id + "," + bankName + "," + accountNumber + "," + creditCardStatus + "\n";
    }
}
