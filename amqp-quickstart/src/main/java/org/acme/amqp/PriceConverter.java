package org.acme.amqp;

import javax.enterprise.context.ApplicationScoped;

import org.eclipse.microprofile.reactive.messaging.Incoming;
import org.eclipse.microprofile.reactive.messaging.Outgoing;

import io.smallrye.reactive.messaging.annotations.Broadcast;
import io.vertx.core.json.JsonObject;
import org.eclipse.microprofile.reactive.messaging.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A bean consuming data from the "prices" AMQP queue and applying some conversion.
 * The result is pushed to the "my-data-stream" stream which is an in-memory stream.
 */
@ApplicationScoped
public class PriceConverter {

    private static Logger LOG = LoggerFactory.getLogger(PriceConverter.class);

    private static final double CONVERSION_RATE = 0.88;

    @Incoming("prices")
    @Outgoing("my-data-stream")
    @Broadcast
    public PriceDouble process(Message<JsonObject> priceInUsd) {
	LOG.warn("Printing the payload: {}", priceInUsd.getPayload());
	try {
	    JsonObject payload = priceInUsd.getPayload();
	    LOG.warn("Printing the class: {}", payload.getClass());
	    PriceInteger inPrice = payload.mapTo(PriceInteger.class);
	    return new PriceDouble(inPrice.getPrice() * CONVERSION_RATE);

	} catch(Exception e) {
	    LOG.error("Error checking the payload class.", e);
	}
	// 3 was randomly determined.
        return new PriceDouble(3 * CONVERSION_RATE);
    }

}
