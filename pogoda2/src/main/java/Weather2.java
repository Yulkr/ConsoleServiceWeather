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

public class Weather2 {
    public static String parseURL2(URL url2){
        if (url2 == null){
            return "";

        }

        StringBuilder stringBuilder2 = new StringBuilder();
        // открываем соедиение к указанному URL
        // помощью конструкции try-with-resources
        try (BufferedReader in = new BufferedReader(new InputStreamReader(url2.openStream()))) {

            String inputLine;
            // построчно считываем результат в объект StringBuilder
            while ((inputLine = in.readLine()) != null) {
                stringBuilder2.append(inputLine);
                System.out.println(inputLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder2.toString();
    }
    public static String CurrentWeatherJson2(String resultJson2){
        JsonElement weatherJsonObject2 = new JsonParser().parse(resultJson2);
        //JsonObject weatherJson = (JsonObject) weatherJsonObject ;

        JsonElement jsonElement = weatherJsonObject2.getAsJsonObject();

        JsonObject jsonObjectname = jsonElement.getAsJsonObject();
        JsonObject n = jsonObjectname.get("location").getAsJsonObject();
        String name = n.get("name").getAsString();

        JsonObject jsonObjecttemp = jsonElement.getAsJsonObject();
        JsonObject m = jsonObjecttemp.get("current").getAsJsonObject();
        double temp = m.get("temp_c").getAsDouble();
        double windd = m.get("wind_mph").getAsDouble();
        double humidity = m.get("humidity").getAsDouble();
        double pressure = m.get("pressure_in").getAsDouble();


        return name +"\n" +
                "Temperatura: " + temp + "C" +"\n" +
                "Wind: " + windd + "m/c" +"\n" +
                "Humidity: " + humidity + "%" +"\n" +
                "Precipitation: " + pressure + "inches" +"\n";

    }
    // создаем объект URL из указанной в параметре строки
    public static URL createUrl2(String link) {
        try {
            return new URL(link);
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        }
    }
}





/*

    public static void parseCurrentWeatherJson2(String resultJson2) {
        try {
            // конвертируем строку с Json в JSONObject для дальнейшего его парсинга
            JSONObject weatherJsonObject2 = (JSONObject) JSONValue.parseWithException(resultJson2);

            // получаем название города, для которого смотрим погоду
            //System.out.println("City: " + weatherJsonObject2.get("name"));

            // получаем массив элементов для поля weather
             ... "weather": [
            {
                "id": 500,
                    "main": "Rain",
                    "description": "light rain",
                    "icon": "10d"
            }
            ], ...

            //JSONArray weatherArray2 = (JSONArray) weatherJsonObject2.get("weather");
            // достаем из массива первый элемент
            //JSONObject weatherData2 = (JSONObject) weatherArray2.get(0);
/*
            Map temp = ((Map)weatherJsonObject2.get("current"));
            Iterator<Map.Entry> itr1 = temp.entrySet().iterator();
            while (itr1.hasNext()) {
                Map.Entry pair = itr1.next();
                String w = pair.getKey() + " : " + pair.getValue();
                System.out.println(pair.getKey() + " : " + pair.getValue());
            }


            // печатаем текущую погоду в консоль
            //System.out.println("Погода на данный момент: " + weatherData2.get("main"));
            // и описание к ней
            //System.out.println("Более детальное описание погоды: " + weatherData2.get("description"));
            //System.out.println("id  города: " + weatherData2.get("id"));

            //JSONArray weatherArray1 = (JSONArray) weatherJsonObject.get("main");
            //JSONObject weatherData1 = (JSONObject) weatherArray1.get(0);
            //System.out.println("Температура:" + weatherDatama.get("temp"));
            //JSONArray weatherArray2 = (JSONArray) weatherJsonObject.get("wind");
            //JSONObject weatherData2 = (JSONObject) weatherArray2.get(0);
            //System.out.println("Скорость ветра:" + weatherData.get("wind.speed"));



        } catch (org.json.simple.parser.ParseException e) {
            e.printStackTrace();
        }
    }
*/



