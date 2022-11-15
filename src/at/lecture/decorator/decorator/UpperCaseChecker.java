package at.lecture.decorator.decorator;

import at.lecture.decorator.PasswordSaver;

public class UpperCaseChecker extends PasswordSaveDecorator{

    public UpperCaseChecker(PasswordSaver saver) {
        super(saver);
    }

    @Override
    public void save(String password) {
        if(password.equals(password.toLowerCase())){
            System.out.println("Password" + password + " does not contain at least one capital letter!");
            return;
        }
        super.save(password);
    }
}
