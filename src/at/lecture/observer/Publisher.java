package at.lecture.observer;
import at.lecture.observer.subscriber.Subscriber;
import java.util.ArrayList;
import java.util.List;

public class Publisher {
    private final List<Subscriber> subscribers;

    public Publisher(){
        this.subscribers = new ArrayList<>();
    }

    public void addSubscriber(Subscriber sub){
        subscribers.add(sub);
    }

    public void removeSubscriber(Subscriber sub){
        subscribers.remove(sub);
    }

    public void send(String message){
        for (Subscriber subscriber : subscribers) {
            subscriber.notify(message);
        }
    }
}
