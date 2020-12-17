import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
//import scala.util.parsing.json.JSONArray;
//import scala.util.parsing.json.JSONObject;

import com.google.gson.JsonParser;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import javax.xml.stream.Location;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.List;


public  class Weather {

    public static String parseURL(URL url) {
        if (url == null) {
            return "";
        }

        StringBuilder stringBuilder = new StringBuilder();
        // открываем соедиение к указанному URL
        // помощью конструкции try-with-resources
        try (BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()))) {

            String inputLine;
            // построчно считываем результат в объект StringBuilder
            while ((inputLine = in.readLine()) != null) {
                stringBuilder.append(inputLine);
                System.out.println(inputLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

    public static String CurrentWeatherJson(String resultJson) {
        JsonElement weatherJsonObject = new JsonParser().parse(resultJson);
        //JsonObject weatherJson = (JsonObject) weatherJsonObject ;

        JsonElement jsonElement = weatherJsonObject.getAsJsonObject();

        JsonObject jsonObjectname = jsonElement.getAsJsonObject();
        String name = jsonObjectname.get("name").getAsString();

        JsonObject jsonObjecttemp = jsonElement.getAsJsonObject();
        JsonObject m = jsonObjecttemp.get("main").getAsJsonObject();
        double temp = m.get("temp").getAsDouble();
        double feel_like = m.get("feels_like").getAsDouble();
        double humidity = m.get("humidity").getAsDouble();

        JsonObject jsonObjectwind = jsonElement.getAsJsonObject();
        JsonObject wind = jsonObjectwind.get("wind").getAsJsonObject();
        double wspeed = wind.get("speed").getAsDouble();


        return name + "\n" +
                "Temperatura: " + temp + "C" + "\n" +
                "Feel like: " + feel_like + "C" + "\n" +
                "Wind: " + wspeed + "m/c" + "\n" +
                "Humidity: " + humidity + "%" + "\n";

    }

    // создаем объект URL из указанной в параметре строки
    public static URL createUrl(String link) {
        try {
            return new URL(link);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        }
    }
}



/*
   public static void parseCurrentWeatherJson(String resultJson) {
    /*
   public static String parseCurrentWeatherJson( String resultJson) {
        String json = main.resultJson;



       JSONObject weatherJsonObject = (JSONObject) JSONValue.parseWithException(resultJson);
       //String json = main.WeatherUrl;
       JsonElement jsonElement =  new JsonParser().parse(json);

       JsonObject jsonObjectname = JsonElement.getAsJsonObject();
       JsonObject jsonObjectname = JsonElement.get.AsJson;
       String name = jsonObjectname.get("name").getAsString();

       JsonObject jsonObjecttemp = JsonElement.getAsJsonObject();
       JsonObject m1 = jsonObjecttemp.get("main").getAsJsonObject();
       double temp = m1.get("temp").getAsDouble();

       JsonObject jsonObjectwind = JsonElement.getAsJsonObject();
       JsonObject wind = jsonObjectwind.get("wind").getAsJsonObject();
       double wspeed = wind.get("speed").getAsDouble();


       return name +"\n" +
               "Temp: " + temp + "C" +"\n" +
               "Temp: " + wspeed + "C" +"\n" +
               "Temp: " + temp + "C" +"\n";

   }

     */

     /*





       // конвертируем строку с Json в JSONObject для дальнейшего его парсинга
       JSONObject weatherJsonObject = (JSONObject) JSONValue.parseWithException(resultJson);
       //JSONObject weatherJsonObject = (JSONObject) JSONValue;
       //JsonElement jsonElement =

       // получаем название города, для которого смотрим погоду
       System.out.println("City: " + weatherJsonObject.get("name"));

       // получаем массив элементов для поля weather
            /* ... "weather": [
            {
                "id": 500,
                    "main": "Rain",
                    "description": "light rain",
                    "icon": "10d"
            }
            ], ...



       JSONArray weatherArray = (JSONArray) weatherJsonObject.get("weather");
       // достаем из массива первый элемент
       JSONObject weatherData = (JSONObject) weatherArray.get(0);

       Map temp = ((Map) weatherJsonObject.get("main"));
       Iterator<Map.Entry> itr1 = temp.entrySet().iterator();
       while (itr1.hasNext()) {
           Map.Entry pair = itr1.next();
           System.out.println(pair.getKey() + " : " + pair.getValue());
       }

       // печатаем текущую погоду в консоль
       System.out.println("Погода на данный момент: " + weatherData.get("main"));
       // и описание к ней
       System.out.println("Более детальное описание погоды: " + weatherData.get("description"));
       System.out.println("id  города: " + weatherData.get("id"));
       String name = (String) weatherJsonObject.get("name");
       String m = (String) weatherData.get("main");
       String description = (String) weatherData.get("description");

       return name + "\n" +
               "Temp: " + m + "C" + "\n" +
               "Temp: " + description + "C" + "\n" +
               "Temp: " + temp + "C" + "\n";

      */







/*
       try {
            // конвертируем строку с Json в JSONObject для дальнейшего его парсинга
            JSONObject weatherJsonObject = (JSONObject) JSONValue.parseWithException(resultJson);
            //JsonObject weatherJsonObject = new JsonParser().parse(resultJson);

            // получаем название города, для которого смотрим погоду
            System.out.println("City: " + weatherJsonObject.get("name"));

            // получаем массив элементов для поля weather
            /* ... "weather": [
            {
                "id": 500,
                    "main": "Rain",
                    "description": "light rain",
                    "icon": "10d"
            }
            ], ...
*/
/*
            JSONArray weatherArray = (JSONArray) weatherJsonObject.get("weather");
            // достаем из массива первый элемент
            JSONObject weatherData = (JSONObject) weatherArray.get(0);

            Map temp = ((Map)weatherJsonObject.get("main"));
            Iterator<Map.Entry> itr1 = temp.entrySet().iterator();
            while (itr1.hasNext()) {
                Map.Entry pair = itr1.next();
                System.out.println(pair.getKey() + " : " + pair.getValue());
            }

            // печатаем текущую погоду в консоль
            System.out.println("Погода на данный момент: " + weatherData.get("main"));
            // и описание к ней
            System.out.println("Более детальное описание погоды: " + weatherData.get("description"));
            System.out.println("id  города: " + weatherData.get("id"));
            String name = (String) weatherJsonObject.get("name");
            String m = (String) weatherData.get("main");
            String description = (String) weatherData.get("description");









            //JSONArray weatherArray1 = (JSONArray) weatherJsonObject.get("main");
            //JSONObject weatherData1 = (JSONObject) weatherArray1.get(0);
            //System.out.println("Температура:" + weatherDatama.get("temp"));
            //JSONArray weatherArray2 = (JSONArray) weatherJsonObject.get("wind");
            //JSONObject weatherData2 = (JSONObject) weatherArray2.get(0);
            //System.out.println("Скорость ветра:" + weatherData.get("wind.speed"));


       } catch (org.json.simple.parser.ParseException e) {
           e.printStackTrace();
       }

/*
        return name +"\n" +
               "Temp: " + m + "C" +"\n" +
               "Temp: " + description + "C" +"\n" +
               "Temp: " + temp + "C" +"\n";

 } */

    /*

    // формируем новый JSON объект из нужных нам погодных данных
    public static String buildWeatherJson() {
        // для простоты примера просто хардкодим нужные данные в методе
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("name", "Лондон");
        jsonObject.put("main", "Солнечно");
        jsonObject.put("description", "Мороз трескучий, На небе ни единой тучи");

        return jsonObject.toJSONString();
    }

 */



