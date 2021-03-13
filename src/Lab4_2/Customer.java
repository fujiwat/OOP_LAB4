package Lab4_2;
import java.util.ArrayList; // import the ArrayList class

public class Customer {
    // data
    private String firstName;
    private String lastName;
    private ArrayList<BankAccount> accounts = new ArrayList<>();
//    private BankAccount[] accounts = new BankAccount[MAX_ACCOUNTS];

    // constructor

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public int getNumAccounts() {
        return accounts.size();
    }

    public BankAccount getAccount(String accountNumber) {
        for (int i=0; i < getNumAccounts(); i++) {
            if (accounts.get(i).getAccountNumber().equals(accountNumber)) {
                return accounts.get(i); // found.
            }
        }
        System.out.println("** getAccount():  account not found: " + accountNumber);
        return null;                    // not found.
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public boolean addAccount(BankAccount account) {
        this.accounts.add(account);
        return true;  // succeeded.
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean closeAccount(String accountNumber) {
        for (int i=0; i < getNumAccounts(); i++) {
            if (accounts.get(i) != null) {
                if (accounts.get(i).getAccountNumber().equals(accountNumber)) {
                    System.out.println("   account closed:  " + accountNumber);
                    accounts.remove(i);
                    return true;        // succeeded to close.
                }
            }
        }
        return false;                   // account not found.
    }

    @Override
    public String toString() { 
        StringBuffer str = new StringBuffer();
        str.append(firstName + " " + lastName + " accounts:\n");
        if ( getNumAccounts() == 0 ) {
            str.append("   No accounts\n");
            return str.toString();
        }
        for (int i = 0; i < getNumAccounts(); i++) {
            str.append("   " + accounts.get(i).toString() + "\n");
        }
        return str.toString();
    }
}
