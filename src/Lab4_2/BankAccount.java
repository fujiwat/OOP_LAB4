package Lab4_2;

public class BankAccount {
    private String accountNumber;
    private double balance;  // default value = 0.

    //Method
    public BankAccount(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    // no parameters
    // but has return type
    public String getAccountNumber() {
        return this.accountNumber;
    }

    public double getBalance() {
        return this.balance;
    }

    public void deposit(double amount) {
        // 預金
        if (0 < amount  ) {
            balance += amount;
        }
    }

    public boolean withdraw(double amount) {
        // 引き出し
        if ( balance < amount ) {
            return false;
        }
        balance -= amount;
        return true;
    }

    @Override
    public String toString() {
        return "BankAccount{" +
                "accountNumber='" + accountNumber + '\'' +
                ", balance=" + balance +
                '}';
    }
}
