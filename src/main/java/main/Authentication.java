package main;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Authentication {
    private static boolean isUserLogged = false;
    private static final Map<String, String> users = new HashMap<>();

    public static void authentication() {
        int operation = 0;
        while (!isUserLogged && operation != 3) {
            System.out.println("Выберите операцию из списка: \n" +
                    "1. Регистрация\n" +
                    "2. Вход\n" +
                    "3. Выход");
            Scanner scanner = new Scanner(System.in);
            operation = Integer.parseInt(scanner.nextLine());
            switch (operation) {
                case 1:
                    System.out.println("Введите логин пользователя");
                    String userLogin = scanner.nextLine();
                    if (!isValidLogin(userLogin)) {
                        System.out.println("Пользователь с таким логином уже существует.");
                        break;
                    }
                    System.out.println("Введите пароль\n" +
                            "Пароль должен содержать знаки \"()_-#*$\" и быть не короче 8 символов");
                    String userPassword = scanner.nextLine();
                    if (!isValidPassword(userPassword)){
                        System.out.println("Пароль не соответствует требованиям");
                        break;
                    }
                    System.out.println("Повторите пароль");
                    if (userPassword.equals(scanner.nextLine())) {
                        users.put(userLogin, userPassword);
                        System.out.println("Регистрация прошла успешно!\n");
                    } else {
                        System.out.println("Пароли не совпадают");
                        break;
                    }
                    break;
                case 2:
                    System.out.println("Введите логин пользователя");
                    userLogin = scanner.nextLine();
                    System.out.println("Введите пароль");
                    userPassword = scanner.nextLine();
                    if (loginUser(userLogin, userPassword)){
                        System.out.println("Добро пожаловать" + userLogin);
                        isUserLogged = true;
                    } else {
                        System.out.println("Неверный логин или пароль");
                        break;
                    }
                    break;
                case 3:
                    break;
                default:
                    System.out.println(operation + " - не является допустимым значением");
            }
        }
    }

    public static boolean loginUser(String login, String userPassword) {
        return login !=null && users.get(login).equals(userPassword);
    }

    public static boolean isValidLogin(String login) {
        return login != null && !users.containsKey(login);
    }

    public static boolean isValidPassword(String password) {
        return password != null && password.matches(".*[*$%&?()].*") && password.length() > 7;
    }
}
