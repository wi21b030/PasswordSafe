package at.lecture.decorator.decorator;

import at.lecture.decorator.PasswordSaver;

public abstract class PasswordSaveDecorator implements PasswordSaver{

    protected PasswordSaver saver;

    public PasswordSaveDecorator(PasswordSaver saver) {
        this.saver = saver;
    }

    @Override
    public void save(String password){
        this.saver.save(password);
    }
}
