import java.util.*;

/**
 * Класс, работающий с многими банковскими аккаунтами.
 * (т.к. мой код позволяет работать с открытием множества счетов -
 * необходим класс, контролирующий это множество).
 */

public class BankAccountOperations {
    private List<BankAccount> accounts = new ArrayList<>();

    public BankAccount open_account(String name) {
        BankAccount account = new BankAccount(name);
        accounts.add(account);
        return account;
    }

    public BankAccount find_acc_with_id(int id) {
        for (BankAccount i : accounts) {
            if (i.getId() == id)
                return i;
        }
        return null;
    }

    public List<BankAccount> find_acc_with_name(String name) {
        List<BankAccount> founded = new ArrayList<>();
        for (BankAccount i : accounts) {
            if (i.getName().equals(name)) // == name
                founded.add(i);
        }
        return founded;
    }


}
