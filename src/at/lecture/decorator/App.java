package at.lecture.decorator;

import at.lecture.decorator.decorator.LengthChecker;
import at.lecture.decorator.decorator.UpperCaseChecker;

public class App {
    public void run(){
        PasswordSaver saver = new PasswordFileSaver();
        saver = new LengthChecker(saver);
        saver = new UpperCaseChecker(saver);
        saver.save("anAnas");
    }
}
