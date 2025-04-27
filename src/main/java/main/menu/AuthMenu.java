package main.menu;

import main.Authentication;
import main.Main;
import main.Session;
import main.User;

import java.util.Objects;
import java.util.Scanner;

public class AuthMenu {
    private static boolean isUserLogin = false;
    private User currentUser;

    public static void showMenu() {
        Scanner scanner = new Scanner(System.in);
        String operation = "";
        while (!isUserLogin && !operation.equals("3")) {
            System.out.println("Выберите действие: \n" +
                    "1.Регистрация \n" +
                    "2.Вход \n" +
                    "3.Выход");
            operation = scanner.nextLine();
            switch (operation) {
                case "1":
                    System.out.println("Ведите логин: ");
                    String userLogin = scanner.nextLine();
                    if (!isCorrectLogin(userLogin)) {
                        System.out.println("Данный логин занят");
                        break;
                    }
                    System.out.println("Введите пароль не короче 8 символов: ");
                    String userPassword = scanner.nextLine();
                    System.out.println("Повторите пароль: ");
                    if (!isCorrectPassword(userPassword) || !userPassword.equals(scanner.nextLine())) {
                        System.out.println("Пароль не соответствует требованиям");
                        break;
                    }
                    User.getUsers().put(userLogin, new User(userLogin, userPassword));
                    System.out.println("Регистрация прошла успешно! \n");
                    break;
                case "2":
                    System.out.println("Введите логин: ");
                    userLogin = scanner.nextLine();
                    System.out.println("Введите пароль: ");
                    userPassword = scanner.nextLine();
                    if (!isCorrectUser(userLogin, userPassword)) {
                        System.out.println("Неверный логин или пароль");
                        break;
                    }
                    System.out.println("Вход успешно выполнен! \n");
                    Session session = new Session();
                    session.setCurrentUser(User.getUsers().get(userLogin));
                    AuthMenu.setIsUserLogin(true);
                    break;
                case "3":
                    break;
                default: System.out.println(operation + " - не является допустимым значением");
            }
        }
    }

    public static boolean isCorrectUser(String login, String password) {
        if (login == null || password == null) {
            return false;
        }
        User user = User.getUsers().get(login);
        return user != null
                && Objects.equals(user.getUserPassword(), password);
    }

    public static boolean isCorrectLogin(String login) {
        if (login == null || login.isEmpty()) {
            return false;
        }
        return !User.getUsers().containsKey(login);

    }

    public static boolean isCorrectPassword(String password) {
        return password != null && password.length() >= 8;
    }

    public static void setIsUserLogin(boolean isUserLogin) {
        AuthMenu.isUserLogin = isUserLogin;
    }
}
