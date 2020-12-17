public class Registration {

    public Registration() {
    }

    public static String register() {
        User user;
        try {
            user = new User(
                    Input.loginInput(),
                    Input.passwordInput(),
                    Input.cityInput(),
                    Input.weatherServiceInput()
            );
        }
        catch (Exception e) {
            e.printStackTrace();
            return "Error: invalid parameters.";
        }

        UserController.addUser(user);
        return "Success!";
    }

}
