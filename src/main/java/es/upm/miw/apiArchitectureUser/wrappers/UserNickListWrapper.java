package es.upm.miw.apiArchitectureUser.wrappers;

import java.util.ArrayList;
import java.util.List;

public class UserNickListWrapper {
	List<UserNickWrapper> UserNickList;

	
	public UserNickListWrapper() {
		UserNickList = new ArrayList<>();
	}

	
	public List<UserNickWrapper> getUserNickList() {
		return UserNickList;
	}
	

	@Override
	public String toString() {
		String result = "{\"userList\":[ ";
		for (UserNickWrapper userWrapper : UserNickList) {
			result += userWrapper.toString() + ",";
		}
		return result.substring(0, result.length() - 1) + "]}";
	}

	public void addUserNickWrapper(UserNickWrapper userNickWrapper) {
		UserNickList.add(userNickWrapper);
		
	}
}
