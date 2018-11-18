package activitytracker;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;

public class Social {
	private List<Profile> userList;
	private HashMap<Profile, Profile> friendsList;


public Social(){
	this.userList = new ArrayList<Profile>();
	this.friendsList = new HashMap<Profile, Profile>();
}
public void getUsers() {
    System.out.println("Existing Users Are: \n");
    for (Profile user : userList) {
        System.out.println(user);
    }
}

public void setUsers(Profile user){
	this.userList.add(user);
	
}


}