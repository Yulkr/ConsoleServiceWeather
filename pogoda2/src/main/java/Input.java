import java.util.Scanner;

public class Input {

    public static Scanner in  = new Scanner(System.in);

    private static void Outputname(){
        System.out.print("Enter a name: " );
    }

    private static void OutputLocation(){
        System.out.print("Enter your location: " );
    }

    private static void OutputWeatherService(){
        System.out.print("Enter preferred weather service: " );
    }

    public static void displayWeatherService(){
        System.out.print("Enter Service: 1 openweathermap, 2 weatherapi, 3 gridforecast: ");

    }

    public static String loginInput(){
        Authorization.displayLogin();
        return in.nextLine();
    }

    public static String passwordInput(){
        Authorization.displayPassword();
        return in.nextLine();
    }

    public static String usernameVvod(){
        Outputname();
        return in.nextLine();
    }

    public static String cityInput() {
        Authorization.displayCity();
        //OutputLocation();
        return in.nextLine();
    }
    public static String cityQ(){
        String City = Input.cityInput();
        return City;
    }

    public static int weatherServiceInput(){
        displayWeatherService();
        return in.nextInt();
    }


}
