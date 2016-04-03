package openmind.rest.client.java;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

/**
 * Created by benal on 03/04/2016.
 */
public class RestfulClient {


    String url;
    String contentType;
    ClientResponse response;

    public RestfulClient(String url, String contentType) {
        this.url = url;
        this.contentType = contentType;
    }

    public void call(){
        Client client = Client.create();

        WebResource webResource = client.resource(url);
        response = webResource.accept(contentType).get(ClientResponse.class);

        if (response.getStatus() != 200) {
            throw new RuntimeException("Failed : HTTP error code : " + response.getStatus());
        }
    }

    public String getResponse(){
        return response.getEntity(String.class);
    }
}
