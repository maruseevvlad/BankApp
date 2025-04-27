package main.menu;

import main.Session;
import main.User;

public class UserMenu {
    private Session session;
    public void showMenu(Session session) {
        this.session = session;
        User currentUser = session.getCurrentUser();
        System.out.println("Здравствуйте! " + currentUser.getUserName());
    }
}
