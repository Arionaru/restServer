package ru.ariona.userManagement.client;

import org.junit.Before;
import org.junit.Test;
import ru.ariona.userManagement.server.User;

public class UserManagementClientTest {

    private UserManagementClient client;

    @Before
    public void before() {
        client = new UserManagementClient();
    }

    @Test
    public void getAllUsers() {
        client.getUsers();
    }

    @Test
    public void addNewUser() {
        client.addUser(new User("Olga","Pet"));
        client.addUser(new User());
        client.addUser(new User("Vitaliy","Pet"));
    }

    @Test
    public void editUser() {
        client.editUser(3);
    }

    @Test
    public void deleteUser() {
        client.deleteUser(3);
    }

    @Test
    public void getUser() {
        client.getUserById(1);
    }

    @Test
    public void getUserWrongId() {
        client.getUserById(10);
    }


}
