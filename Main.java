import java.util.List;
import java.util.Scanner;

/**
 * Задача 2. Банковский счёт
 * Консольное меню: открыть счёт, положить деньги,
 * снять деньги, показать баланс,
 * вывести список транзакций, искать по атрибутам.
 */

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        BankAccountOperations bank = new BankAccountOperations();

        while (true) {
            TypeOutMenu.printMainMenu();
            int choice = in.nextInt();
            in.nextLine(); // (сказали так сделать для очистки буфера).

            if (choice == 1) {
                System.out.print("Имя владельца счёта: ");
                String name = in.nextLine();
                BankAccount acc = bank.open_account(name);
                System.out.println("Счёт открыт, id клиента: " + acc.getId() + ".");
                //break;
            }
            else if (choice == 2) {
                System.out.print("Введите id счёта: ");
                int id = in.nextInt();
                System.out.print("Сумма (+): ");
                double amount = in.nextDouble();
                BankAccount account = bank.find_acc_with_id(id);
                if (account != null) {
                    account.add_amount(amount);
                }
                else {
                    System.out.println("Такой счёт не найден. Попробуйте снова.");
                }
                //break;
            }
            else if (choice == 3) {
                System.out.print("Введите id счёта: ");
                int id = in.nextInt();
                System.out.print("Сумма (-): ");
                double amount = in.nextDouble();
                BankAccount account = bank.find_acc_with_id(id);
                if (account != null) {
                    account.substract_amount(amount);
                }
                else {
                    System.out.println("Такой счёт не найден. Попробуйте снова.");
                }
                //break;
            }
            else if (choice == 4) {
                System.out.print("Введите id счёта: ");
                int id = in.nextInt();
                BankAccount account = bank.find_acc_with_id(id);
                if (account != null) {
                    account.show_balance();
                }
                else {
                    System.out.println("Такой счёт не найден. Попробуйте снова.");
                }
                //break;
            }
            else if (choice == 5) {
                System.out.print("Введите id счёта: ");
                int id = in.nextInt();
                BankAccount account = bank.find_acc_with_id(id);
                if (account != null) {
                    account.print_history();
                }
                else {
                    System.out.println("Такой счёт не найден. Попробуйте снова.");
                }
                //break;
            }
            else if (choice == 6) {
                System.out.println("Найти счёт используя:\n1. Имя владельца\n2. id");
                int choice2 = in.nextInt();
                in.nextLine();
                if (choice2 == 1) {
                    System.out.print("Введите имя владельца счёта: ");
                    String name = in.nextLine();
                    List<BankAccount> list = bank.find_acc_with_name(name);
                    if (list.isEmpty()) {
                        System.out.println("Такого имени не найдено. Попробуйте снова.");
                    }
                    else {
                        for (BankAccount i : list) {
                            System.out.println("Имя владельца: " + i.getName() + ", № счёта: " + i.getId() + ".");
                        }
                    }
                }
                else if (choice2 == 2) {
                    System.out.print("Введите id счёта: ");
                    int id = in.nextInt();
                    BankAccount account = bank.find_acc_with_id(id);
                    if (account != null) {
                        System.out.println("Id счёта: " + account.getId() + ", имя владельца: " + account.getName() + ".");
                    }
                    else {
                        System.out.println("Такой счёт не найден. Попробуйте снова.");
                    }
                }
                else {
                    System.out.println("Такой опции не существует. Попробуйте снова.");
                }
                //break;
            }
            else if (choice == 7) {
                System.out.println("До свидания!");
                break;
            }
            else {
                System.out.println("Такой опции не существует. Попробуйте снова.");
            }
        }
        in.close(); // (рекомендация: закрыть Scanner - in имею ввиду).
    }
}
