package at.lecture.decorator;

public class PasswordFileSaver implements PasswordSaver{

    @Override
    public void save(String password) {
        System.out.println("Password " + password + " has been saved to file");
    }
}
