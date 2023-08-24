package org.br.pocrabbitmq;

import java.util.stream.Collectors;

import org.eclipse.microprofile.reactive.messaging.Incoming;

import io.quarkus.logging.Log;
import io.vertx.core.json.JsonObject;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class MessageConsumer {

  @Incoming("quarkus-rabbitmq")
  public void process(JsonObject json) {
    Log.info(json.toString());
    ConsumeMessageDTO mapToDTO = json.mapTo(ConsumeMessageDTO.class);
    Log.infof("---- MessageConsumer ---- Convert", mapToDTO.toString());
    System.out.println(mapToDTO.toString());
  }

}
