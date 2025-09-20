import java.util.ArrayList;

/**
 * (Мне понравилось делать так описание).
 * Класс, отвечающий за вывод меню в главную консоль.
 */

public class TypeOutMenu {
    public static ArrayList<String> getMainMenu() {
        ArrayList<String> main_menu = new ArrayList<>();

        main_menu.add("1. Открыть счёт.");
        main_menu.add("2. Положить деньги.");
        main_menu.add("3. Снять деньги.");
        main_menu.add("4. Показать баланс.");
        main_menu.add("5. Вывести список транзакций.");
        main_menu.add("6. Искать по атрибутам.");
        main_menu.add("7. Выйти из программы.");

        return main_menu;
    }

    public static void printMainMenu() {
        ArrayList<String> menu = getMainMenu();
        System.out.println("Выребите пункт из главного меню:");
        for (String i : menu) {
            System.out.println(i);
        }
    }
}
