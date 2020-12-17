
public class User {
    private String location;
    private String login;
    private String password;
    private Integer weatherService;

    public User(String login, String password, String location, Integer weatherService) {
        this.location = location;
        this.login = login;
        this.password = password;
        this.weatherService = weatherService;
    }



    public void setLocation(String location){
        this.location = location;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setWeatherService(Integer weatherService) {
        this.weatherService = weatherService;
    }

    public String getLocation() {
        return location;
    }

    public String getPassword() {
        return password;
    }

    public String getLogin() {
        return login;
    }

    public Integer getWeatherService() {
        return weatherService;
    }
    /*
    public static String getlocations(String location){
        return location;

    }

     */

    @Override
    public String toString() {
        return "User{" +
                "location='" + location + '\'' +
                ", login='" + login + '\'' +
                ", password=" + password +
                ", weatherService=" + weatherService +
                '}';
    }
}
