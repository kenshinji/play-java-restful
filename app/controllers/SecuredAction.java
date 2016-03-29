package controllers;

import play.mvc.Action;
import play.mvc.Http;
import play.mvc.Result;
import play.mvc.Results;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

/**
 * Created by kenshinji on 3/29/16.
 */
public class SecuredAction extends Action.Simple {
    public CompletionStage<Result> call(Http.Context ctx) {
        String token = getTokenFromHeader(ctx);

        //given the token we generated for user is "123456"
        if (token != null && token.equals("123456")) {

            return delegate.call(ctx);

        }
        Result unauthorized = Results.unauthorized("unauthorized");
        return CompletableFuture.completedFuture(unauthorized);
    }

    private String getTokenFromHeader(Http.Context ctx) {
        String[] authTokenHeaderValues = ctx.request().headers().get("X-AUTH-TOKEN");
        if ((authTokenHeaderValues != null) && (authTokenHeaderValues.length == 1) && (authTokenHeaderValues[0] != null)) {
            return authTokenHeaderValues[0];
        }
        return null;
    }
}