import java.util.*;

public class request {
    static void search(String find, User currUser){
        for(User i:Main.allUser) {
            if (i.name.equals(find)) {
                i.requests.add(currUser);
            }
        }
    }
    static void details(User currUser){  // getting particular user details
        System.out.print("Notifications: "+currUser.requests.size());
        if(currUser.requests.isEmpty()){
            System.out.print("\nYou Have no requests !!");
            return;
        }
        List<User> acceptedUser = new ArrayList<>();
        for(User i:currUser.requests){
            System.out.print("\nYou have an request from "+i.name);
            System.out.print("\nEnter 1 to accept and 2 to reject: ");
            Scanner sc = new Scanner(System.in);
            int option =sc.nextInt();
            if(option==1){
                if(!currUser.mutualFriends.contains(i)) currUser.mutualFriends.add(i);
                if(!i.mutualFriends.contains(currUser)) i.mutualFriends.add(currUser);
                acceptedUser.add(i);
            }
        }
        for(User i:acceptedUser){
            currUser.requests.remove(i);
            currUser.matchedProfile.remove(i);
            i.matchedProfile.remove(currUser);
        }
    }
}
