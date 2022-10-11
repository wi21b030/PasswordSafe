package at.lecture.clientserver;

import java.io.IOException;
import java.net.URISyntaxException;
import java.security.NoSuchAlgorithmException;

public class Main {
    public static void main(String[] args) {
        PasswordCheck pc = new PasswordCheck();
        try {
            pc.hasBeenPawned("password");
        } catch (NoSuchAlgorithmException | URISyntaxException | IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
