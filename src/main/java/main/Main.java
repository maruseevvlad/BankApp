package main;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static boolean isUserLogged = false;
    public static Map<String, String> users = new HashMap<>();
    public static void main(String[] args) {
        Engine.Authentification();
    }
}