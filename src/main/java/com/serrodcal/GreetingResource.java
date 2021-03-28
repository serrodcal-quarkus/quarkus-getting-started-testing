package com.serrodcal;

import io.quarkus.vertx.web.Param;
import io.quarkus.vertx.web.Route;
import io.vertx.core.http.HttpMethod;
import io.vertx.ext.web.RoutingContext;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class GreetingResource {

    @Inject
    GreetingService greetingService;

    @Route(path = "hello", methods = HttpMethod.GET, produces = "text/plain" )
    public void hello(RoutingContext rc) {
        rc.response().end("Hello");
    }

    @Route(path = "greeting/:name", methods = HttpMethod.GET, produces = "text/plain")
    public void greeting(RoutingContext rc, @Param("name") String name) {
        greetingService.greet(name).subscribe().with(result -> rc.response().end(result));
    }

}