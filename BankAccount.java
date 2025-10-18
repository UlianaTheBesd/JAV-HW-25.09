import java.util.ArrayList;
import java.util.List;

/**
 * Новый тип "BankAccount" в котором будут поля и методы,
 * необходимые для работы со счетом.
 */

public class BankAccount {
    private static int counter = 1;
    private int id;
    private String name;
    private double balance;
    private List<String> history = new ArrayList<>();

    public BankAccount(String n) {
        this.id = counter++;
        this.name = n;
        this.balance = 0;
        history.add("Создан аккаунт номер " + id + ".");
    }

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public double getBalance() {
        return balance;
    }
    public List<String> getHistory() {
        return history;
    }

    public void add_amount(double amount) {
        if (amount < 0) {
            history.add("Попытка добавить на счёт №" + getId() + " отрицательную сумму " + amount + ".");
            throw new IllegalArgumentException("Сумма пополнения не может быть отрицательной: " + amount);
        }
        balance += amount;
        history.add("Добавлено на счёт №"+ getId() + ": " + amount + ".");
    }

    public void substract_amount(double amount) {
        if (amount < 0) {
            history.add("Попытка снять со счёта №" + getId() + " отрицательную сумму " + amount + ".");
            throw new IllegalArgumentException("Сумма снятия не может быть отрицательной: " + amount);
        }
        else if (amount <= balance) {
            balance -= amount;
            history.add("Снято со счёта №"+ getId() + ": " + amount + ".");
        }
        else {
            System.out.println("Недостаточно средств для снятия!");
            history.add("Попытка снять со счёта №" + getId() + " сумму " + amount + "." + " Недостаточно средств.");
        }
    }

    public void show_balance() {
        System.out.println("Баланс счёта №"+ getId() + ": " + getBalance() + ".");
        history.add("Показан баланс счёта номер " + getId() + ".");
    }

    public void print_history() {
        for (String i : getHistory()) {
            System.out.print(i + " "); // как end=" " в Python.
        }
        System.out.println();
        history.add("Показана история счёта номер " + getId() + ".");
    }
}
