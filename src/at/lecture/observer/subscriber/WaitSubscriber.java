package at.lecture.observer.subscriber;

public class WaitSubscriber implements Subscriber{
    @Override
    public void notify(String message){
        if(message.length() <= 5) System.out.println("I will buy " + message);
        else System.out.println("I am not sure, I will wait to buy " + message);
    }
}
