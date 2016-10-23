package es.upm.miw.apiArchitectureUser.wrappers;

import java.util.ArrayList;
import java.util.List;

public class UserListWrapper {
	List<UserWrapper> UserList;

	
	public UserListWrapper() {
		UserList = new ArrayList<>();
	}

	public List<UserWrapper> getUserList() {
		return UserList;
	}
	

	public void addUserWrapper(UserWrapper userWrapper){
		UserList.add(userWrapper);
	}
	

	@Override
	public String toString() {
		String result = "{\"userList\":[ ";
		for (UserWrapper userWrapper : UserList) {
			result += userWrapper.toString() + ",";
		}
		return result.substring(0, result.length() - 1) + "]}";
	}

}
