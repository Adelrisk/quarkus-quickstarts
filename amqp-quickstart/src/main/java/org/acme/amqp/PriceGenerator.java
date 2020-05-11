package org.acme.amqp;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.enterprise.context.ApplicationScoped;

import org.eclipse.microprofile.reactive.messaging.Outgoing;

import io.reactivex.Flowable;

/**
 * A bean producing random prices every 5 seconds.
 * The prices are written to a AMQP queue (prices). The AMQP configuration is specified in the application configuration.
 */
@ApplicationScoped
public class PriceGenerator {

    private Random random = new Random();

    @Outgoing("generated-price")
    public Flowable<PriceInteger> generate() {
        return Flowable.interval(5, TimeUnit.SECONDS)
                .map(tick -> new PriceInteger(random.nextInt(100)));
    }

}
