import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.Map;

public class Weather3 {

    /*
    public long t;
    public long r ;
    public long speed;
    public long sp ;
    public long vis;

    public Weather3(long t, long r, long speed, long sp, long vis ) {
        this.t = t;
        this.r = r;
        this.speed = speed;
        this.sp = sp;
        this.vis = vis;

    }

     */

    public static String parseURL3(URL url3){
        if (url3 == null){
            return "";

        }

        StringBuilder stringBuilder3 = new StringBuilder();
        // открываем соедиение к указанному URL
        // помощью конструкции try-with-resources
        try (BufferedReader in = new BufferedReader(new InputStreamReader(url3.openStream()))) {

            String inputLine;
            // построчно считываем результат в объект StringBuilder
            while ((inputLine = in.readLine()) != null) {
                stringBuilder3.append(inputLine);
                System.out.println(inputLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder3.toString();
    }

    public static String CurrentWeatherJson3(String resultJson){
        JsonElement weatherJsonObject = new JsonParser().parse(resultJson);
        //JsonObject weatherJson = (JsonObject) weatherJsonObject ;

        JsonElement jsonElement = weatherJsonObject.getAsJsonObject();

        JsonObject jsonObjectt = jsonElement.getAsJsonObject();
        double t = jsonObjectt.get("t").getAsDouble();
        JsonObject jsonObjectr = jsonElement.getAsJsonObject();
        double r = jsonObjectr.get("r").getAsDouble();
        JsonObject jsonObjectspeed = jsonElement.getAsJsonObject();
        double speed = jsonObjectspeed.get("speed10").getAsDouble();
        JsonObject jsonObjectvis = jsonElement.getAsJsonObject();
        double vis = jsonObjectvis.get("vis").getAsDouble();

        return "Temperatura: " + t + "C" +"\n" +
                "Humidity: " + r + "%" +"\n" +
                "Wind: " + speed + "m/c" +"\n" +
                "Visibility: " + vis + "m" +"\n";

    }


    // создаем объект URL из указанной в параметре строки
    public static URL createUrl3(String link) {
        try {
            return new URL(link);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        }
    }
}

