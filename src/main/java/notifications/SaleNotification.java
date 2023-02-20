package notifications;

import model.Sale;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

public class SaleNotification {
    private final Sinks.Many<Sale> saleSinks = Sinks.many().multicast().onBackpressureBuffer();

    public void send (Sale sale){
        saleSinks.tryEmitNext(sale);
    }

    public Flux<Sale> getSaleFlux(){
        return saleSinks.asFlux();
    }
}
