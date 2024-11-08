import java.util.*;

public class User {
    String name, dob, location, password;
    int age;
    List<User> mutualFriends, matchedProfile, requests;
    User(String name, String password, String dob, String location, int age){
        this.name=name;
        this.password=password;
        this.age=age;
        this.dob=dob;
        this.location=location;
        mutualFriends = new ArrayList<>();
        matchedProfile = new ArrayList<>();
        requests = new ArrayList<>();
    }
}
