package at.lecture.decorator.decorator;

import at.lecture.decorator.PasswordSaver;


public class LengthChecker extends PasswordSaveDecorator{

    public LengthChecker(PasswordSaver saver) {
        super(saver);
    }

    @Override
    public void save(String password) {
        if(password.length() < 5){
            System.out.println("Password " + password + " is too short");
            return;
        }
        super.save(password);
    }
}
