import javax.crypto.spec.PSource;
import java.io.OutputStream;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;


public class main {

    public static User session;
    //public static final String WeatherUrl = "http://api.openweathermap.org/data/2.5/weather?q=" + Input.cityQ() + "&appid=f101613e888ee50d95b890c215cd682a&units=metric&lang=ru"; //weather
    //public static final String WeatherUrl2= "http://api.weatherapi.com/v1/current.json?key=e43a1f05c3054999874131506202711&q=" +Input.cityQ() + "&lang=ru";//weather 2 работает
    //public static final String WeatherUrl3 = "https://gridforecast.com/api/v1/forecast/49.8479;35.6541/202012061200?api_token=qDpk0TI2Fr6LqV1j"; //заканчивается через 7 дней это  weather 4
    //public static final String WeatherUrl3 = "https://gridforecast.com/api/v1/forecast/" + Input.cityQ() +"/202012141200?api_token=qDpk0TI2Fr6LqV1j";
    //public static final String resultJson;
    // 55.7715;37.6246  москва
    //55.7522;37.6231 то что было

    public static void print1Service() {

        String WeatherUrl = "http://api.openweathermap.org/data/2.5/weather?q=" + Input.cityQ() + "&appid=f101613e888ee50d95b890c215cd682a&units=metric&lang=ru"; //weather
        URL url = Weather.createUrl(WeatherUrl);
        String resultJson = Weather.parseURL(url);
        String p = Weather.CurrentWeatherJson(resultJson);

        System.out.println(p);

    }
    public static void print2Service(){
        String WeatherUrl2= "http://api.weatherapi.com/v1/current.json?key=e43a1f05c3054999874131506202711&q=" +Input.cityQ() + "&lang=ru";//weather 2 работает

        URL url2 = Weather2.createUrl2(WeatherUrl2);
        String resultJson2 = Weather2.parseURL2(url2);
        String p = Weather2.CurrentWeatherJson2(resultJson2);
        System.out.println(p);

    }
    public static void print3Service(){
        String WeatherUrl3 = "https://gridforecast.com/api/v1/forecast/" + Input.cityQ() +"/202012171200?api_token=qDpk0TI2Fr6LqV1j";

        URL url3 = Weather3.createUrl3(WeatherUrl3);
        String resultJson3 = Weather3.parseURL3(url3);
        String p = Weather3.CurrentWeatherJson3(resultJson3);
        System.out.println(p);

    }


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello,  log in or register");
        System.out.println("Если хотите войти, напишите log in ; если хотите зарегистрироваться, напишите register, после если хотите получить погоду напишите weather, если хотите выйти напише exit");
        while (true) {
            String input = scanner.nextLine();

            switch (input) {
                case "log in":
                    User user = UserController.getByLogin(Input.loginInput());
                    if (user != null && Input.passwordInput().equals(user.getPassword()))
                        session = user;
                    else
                        System.out.println("Неверный логин или пароль!");
                    break;

                case "register":
                    String request = Registration.register();
                    if (request.contains("Error")) {
                        System.out.println(request + " Please, try again.");
                    } else {
                        System.out.println(request);
                    }
                    break;
                case "get":
                    System.out.println("input city");
                    User city = UserController.getByCity(Input.cityInput());
                    if (city != null)
                        System.out.println("Weather");
                case "weather":
                    //Integer servise = session.getWeatherService();
                    //User user = UserController.getByCity(session.getLocation());
                    //User weatherService = User.getWeatherService(session);
                    switch (session.getWeatherService()) {

                        case 1:

                            print1Service();
                            break;
                        case 2:
                            print2Service();

                            break;
                        case 3:
                            print3Service();
                            break;
                    }

                case "exit":
                    break;

                default:
                    System.out.println("Неизвестная команда.");
            }


            if (input.equals("exit"))
                break;
        }
    }

}
