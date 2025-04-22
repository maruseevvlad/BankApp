package main;

import java.util.Scanner;

import static main.Main.isUserLogged;
import static main.Main.users;

public class Engine {
    public static void Authentification() {
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
                    if (users.containsKey(userLogin) || userLogin == null) {
                        System.out.println("Пользователь с таким логином уже существует.");
                        break;
                    }
                    System.out.println("Введите пароль\n" +
                            "Пароль должен содержать знаки \"()_-#*$\" и быть не короче 8 символов");
                    String userPassword1 = scanner.nextLine();
                    if (!isValidPassword(userPassword1)){
                        System.out.println("Пароль не соответствует требованиям");
                        break;
                    }
                    System.out.println("Повторите пароль");
                    String userPassword2 = scanner.nextLine();
                    if (userPassword1.equals(userPassword2)) {
                        users.put(userLogin, userPassword1);
                    } else {
                        System.out.println("Пароли не совпадают");
                        break;
                    }
                    break;
                case 2:
                    System.out.println("Введите логин пользователя");
                    userLogin = scanner.nextLine();
                    System.out.println("Введите пароль");
                    userPassword1 = scanner.nextLine();
                    if (users.get(userLogin).equals(userPassword1)){
                        isUserLogged = true;
                    } else {
                        System.out.println("Неверный логин или пароль");
                        break;
                    }
                    break;
                case 3:
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + operation);
            }
        }
    }

    public static boolean isValidPassword(String password) {
        return password != null && password.matches(".*[*$%&?()].*") && password.length() > 7;
    }
}
