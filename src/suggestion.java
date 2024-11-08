public class suggestion {


    public static void connections(User currUser){

        // mutualFriends of currUser

        System.out.println("Mutual Friends: "+currUser.mutualFriends.size());
        if(currUser.mutualFriends!=null) {
            for (User i : currUser.mutualFriends) {
                System.out.println(i.name + " ");
            }
        }

        // matchedProfile Users

        for(User i: Main.allUser) {
            if (i != currUser && currUser.mutualFriends!=null && !currUser.mutualFriends.contains(i)) {
                if (i.name.equals(currUser.name) || i.age == currUser.age || i.location.equals(currUser.location)) {
                    currUser.matchedProfile.add(i);
                }
            }
        }
        System.out.println("Profile Matches: "+currUser.matchedProfile.size());
        for(User i:currUser.matchedProfile){
            System.out.println(i.name+" ");
        }

        // Remaining Users apart from mutualFriends and matchedProfiles

        System.out.println("Others: "+(Main.allUser.size()-currUser.mutualFriends.size()-currUser.matchedProfile.size()-1));
        for(User i:Main.allUser){
            if(i!=currUser && !currUser.matchedProfile.contains(i)  && !currUser.mutualFriends.contains(i)) {
                System.out.println(i.name);
            }
        }
    }
}
