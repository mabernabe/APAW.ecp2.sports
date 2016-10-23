package es.upm.miw.apiArchitectureUser;

import es.upm.miw.apiArchitectureUser.api.SportResource;
import es.upm.miw.apiArchitectureUser.api.UserResource;
import es.upm.miw.apiArchitectureUser.exceptions.FoundUserNameException;
import es.upm.miw.apiArchitectureUser.exceptions.InvalidRequestException;
import es.upm.miw.apiArchitectureUser.exceptions.InvalidUserFieldException;
import es.upm.miw.web.http.HttpRequest;
import es.upm.miw.web.http.HttpResponse;
import es.upm.miw.web.http.HttpStatus;

public class Dispatcher {

	private UserResource userResource = new UserResource();
	private SportResource sportResource = new SportResource();

	private void responseError(HttpResponse response, Exception e) {
		response.setBody("{\"error\":\"" + e + "\"}");
		response.setStatus(HttpStatus.BAD_REQUEST);
	}

	public void doGet(HttpRequest request, HttpResponse response) {

		if ("users".equals(request.getPath())) {
			response.setBody(userResource.userList().toString());

		} else if ("users".equals(request.paths()[0]) && "search".equals(request.paths()[1]))
		{
			String sportname = request.getHeaderParams().get("sport");
			response.setBody(userResource.userSportList(sportname).toString());
		}else if ("sports".equals(request.getPath())) {
			response.setBody(sportResource.sportList().toString());
		} else {
			responseError(response, new InvalidRequestException(request.getPath()));
		}
	}

	public void doPost(HttpRequest request, HttpResponse response) {
		switch (request.getPath()) {

		case "users":
			String username = request.getBody().split(":")[0];
			String email = request.getBody().split(":")[1];
			// Injectar parámetros...
			try {
				userResource.createUser(username,email);
				response.setStatus(HttpStatus.CREATED);
			} catch (InvalidUserFieldException e) {
				this.responseError(response, e);
			} catch (FoundUserNameException e) {
			this.responseError(response, e);
			}
			break;

		case "sports":
			try {
				sportResource.createSport(request.getBody());
				response.setStatus(HttpStatus.CREATED);
			} catch (Exception e) {
				responseError(response, e);
			}
			break;
		default:
			responseError(response, new InvalidRequestException(request.getPath()));
			break;
		}
	}

	public void doPut(HttpRequest request, HttpResponse response) {
		if ("users".equals(request.paths()[0]) && "sport".equals(request.paths()[2])) {
			try {
				userResource.addUserSport(request.paths()[1], request.getBody());
			} catch (Exception e) {
				responseError(response, e);
			}
		}
			else {
			responseError(response, new InvalidRequestException(request.getPath()));
		}
	}

	public void doDelete(HttpRequest request, HttpResponse response) {
		switch (request.getPath()) {
		default:
			responseError(response, new InvalidRequestException(request.getPath()));
			break;
		}
	}

}
