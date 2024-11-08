import java.util.*;

public class Main {
    public static List<User> allUser = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("Enter 1 to signup and 2 to login and 3 to exit: ");
            int choice;
            choice=sc.nextInt();
            if(choice>=3 || choice<=0) {
                break;
            }
            User newUser = null;
            if(choice==2){
                String loginUser, loginPassword;
                System.out.print("Enter name: ");
                loginUser = sc.next();
                boolean isFoundUser=false;
                for(User i:allUser) { // check whether the user is already present or not
                    if (i.name.equals(loginUser)) {
                        isFoundUser=true;
                        newUser = i;
                        break;
                    }
                }
                if(!isFoundUser){
                    System.out.println("No User Found !!");
                    continue;
                }
                System.out.print("Enter password: ");
                loginPassword = sc.next();
                if(!newUser.password.equals(loginPassword)) {
                    System.out.println("Incorrect Password !!");
                    continue;
                }
                System.out.println("Name: "+newUser.name);
                suggestion.connections(newUser);
                request.details(newUser);
                if(allUser.size()>1) {
                    System.out.println("\nEnter 1 to send request to User and 2 to skip: ");
                    int opt=sc.nextInt();
                    if(opt==1) {
                        System.out.println("Enter User name: ");
                        String req = sc.next();
                        boolean alreadyFriend=false;
                        for(User i:newUser.mutualFriends){
                            if(i.name.equals(req)){
                                System.out.println("You are already friends !!");
                                alreadyFriend=true;
                                break;
                            }
                        }
                        if(!alreadyFriend) request.search(req, newUser);
                    }
                }
            }
            else {
                String name, password, dob, location;
                int age;
                System.out.print("SignUp\n");
                System.out.print("Enter name: ");
                name = sc.next();
                boolean exist=false;
                for(User i:allUser){
                    if(i.name.equals((name))){
                        System.out.println("User already exist !!");
                        exist=true;
                        break;
                    }
                }
                if(exist) continue;
                System.out.print("Enter password: ");
                password=sc.next();
                System.out.print("Enter age: ");
                age = sc.nextInt();
                System.out.print("Enter dob: ");
                dob = sc.next();
                System.out.print("Enter location: ");
                location = sc.next();
                newUser = new User(name, password, dob, location, age); // Creating new User
                System.out.print("Your Account has created !!\n");
                allUser.add(newUser);
            }
        }
    }
}