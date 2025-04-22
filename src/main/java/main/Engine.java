package main;

import java.util.Scanner;

import static main.Main.isUserLogged;
import static main.Main.users;

public class Engine {
    public static void Authentification() {
        while (!isUserLogged) {
            System.out.println("Выберите операцию из списка: \n" +
                    "1. Регистрация\n" +
                    "2. Вход\n");
            Scanner scanner = new Scanner(System.in);
            int operation = Integer.parseInt(scanner.nextLine());
            switch (operation) {
                case 1:
                    System.out.println("Введите логин пользователя");
                    String userLogin = scanner.nextLine();
                    if (users.containsKey(userLogin)) {
                        System.out.println("Пользователь с таким логинов уже существует.");
                        break;
                    }
                    System.out.println("Введите пароль");
                    String userPassword1 = scanner.nextLine();
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
                default:
                    throw new IllegalStateException("Unexpected value: " + operation);
            }
        }
    }
}
