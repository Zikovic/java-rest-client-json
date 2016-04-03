package openmind.rest.client.java;
/**
 *
 */
public class App {


    public static void main(String[] args) {

        String url = "https://query.yahooapis.com/v1/public/yql?q=select%20*%20from%20weather.forecast%20where%20woeid%20in%20(select%20woeid%20from%20geo.places(1)%20where%20text%3D%22nome%2C%20ak%22)&format=json&env=store%3A%2F%2Fdatatables.org%2Falltableswithkeys";
        String contentType = "application/json";

        RestfulClient restfulClient = new RestfulClient(url, contentType);
        restfulClient.call();
        String responseJson = restfulClient.getResponse();
        System.out.println("Response serveur  : \n" + responseJson);


    }
}



