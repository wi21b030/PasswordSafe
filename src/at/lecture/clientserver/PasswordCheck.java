package at.lecture.clientserver;

import java.io.IOException;
import java.math.BigInteger;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordCheck {
    public void hasBeenPawned(String pw) throws NoSuchAlgorithmException, IOException, URISyntaxException, InterruptedException {
        //hash the String pw (found code on StackOverflow)
        MessageDigest digest = MessageDigest.getInstance("SHA-1");
        digest.reset();
        digest.update(pw.getBytes(StandardCharsets.UTF_8));
        String sha1 = String.format("%040x", new BigInteger(1, digest.digest()));
        //send request with first 5 chars of hash
        HttpRequest request = HttpRequest.newBuilder().uri(new URI("https://api.pwnedpasswords.com/range/" + sha1.substring(0,5))).GET().build();
        //receive response
        HttpResponse<String> response = HttpClient.newBuilder().build().send(request, HttpResponse.BodyHandlers.ofString());
        //turn responses' body into string
        String res = response.body();
        //check whether response contains exact remaining characters of hash
        if(!res.contains(sha1.substring(5).toUpperCase())){
            System.out.println("Password has not been pawned");
        }
        else{
            String[] pawned;
            //iterate through rows by using System.lineSeparator() because of "\n\r" format
            for (String row : res.split(System.lineSeparator())) {
                if(row.contains(sha1.substring(5).toUpperCase())){
                    //split via ":" and put into array
                    pawned = row.split(":");
                    System.out.print("Password has been pawned " + pawned[1] + " times!");
                }
            }
        }
    }
}
