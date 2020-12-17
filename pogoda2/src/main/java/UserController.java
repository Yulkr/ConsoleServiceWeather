import java.util.HashMap;

public class UserController {

    private static final HashMap<String, User> users = new HashMap<>();

    public static User getByLogin(String login) {
        return users.get(login);
    }
    public static User getByCity(String  location){
        return users.get(location);
    }

    public static void addUser(User user) {
        if(users.containsKey(user.getLogin()))
            return;

        System.out.println("Пользователь зарегистрирован");


        users.put(user.getLogin(), user);
        users.put(user.getPassword(), user);
        users.put(user.getLocation(), user);
    }

    public static HashMap<String, User> getUsers() {
        return users;
    }
}
