import org.apache.http.client.fluent.*;

import java.io.IOException;

public class ValidationAPI {
    public static void main(String[] args) {
        makeAbstractRequest();
    }

    private static void makeAbstractRequest() {

        try {

            Content content = Request.Get('https://emailvalidation.abstractapi.com/v1/?api_key=7190df0be70043ee94cd825f023b8de6&email=eocks0615@gmail.com')

                    .execute().returnContent();

            System.out.println(content);
        }
        catch (IOException error) { System.out.println(error); }
    }
}