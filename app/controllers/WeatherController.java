package controllers;


import play.libs.ws.WSClient;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.With;

import javax.inject.Inject;
import java.util.concurrent.CompletionStage;

/**
 * Created by kenshinji on 3/26/16.
 */
public class WeatherController extends Controller {
    @Inject WSClient ws;
    private static final String URL = "https://query.yahooapis.com/v1/public/yql";

    @With(SecuredAction.class)
    public CompletionStage<Result> get(String city) {
        String q1 = "select item.condition from weather.forecast where woeid in (select woeid from geo.places(1) where text=\"" + city +"\")";
        return ws.url(URL).setQueryParameter("q", q1).setQueryParameter("format", "json").get().thenApply(response ->
                ok(response.asJson())
        );
    }
}
