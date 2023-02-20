package notifications;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Sinks;

public class CheckoutNotification {
    private final  Sinks.Many<Integer> checkoutNotification =  Sinks.many().multicast().onBackpressureBuffer();

    public void send (Integer id){
        checkoutNotification.tryEmitNext(id);
    }

    public  Flux<Integer>  getCheckoutNotification(){
        return checkoutNotification.asFlux();
    }




}
