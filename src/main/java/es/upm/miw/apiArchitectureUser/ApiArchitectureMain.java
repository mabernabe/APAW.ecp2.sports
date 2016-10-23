package es.upm.miw.apiArchitectureUser;

import es.upm.miw.apiArchitectureUser.daos.DaoFactory;
import es.upm.miw.apiArchitectureUser.daos.memory.DaoFactoryMemory;
import es.upm.miw.web.http.HttpMethod;
import es.upm.miw.web.http.HttpRequest;
import es.upm.miw.web.http.HttpResponse;

public class ApiArchitectureMain {

	private Server server = new Server();

	private HttpRequest request = new HttpRequest();

	public void help() {
		System.out.println("GET **/users");
		System.out.println("POST **/users   body=\"nick:email\"");
		System.out.println("POST **/sports   body=\"name\"");
		System.out.println("PUT **/user/{nick}/sport");
		System.out.println("GET **/user/search?sport=*");
	}

	public void demo() {
		request.setMethod(HttpMethod.POST);
		request.setPath("users");
		request.setBody("uno:uno@gmail.com");
		this.request();
		request.setBody("dos:dos@gmail.com");
		this.request();
		request.setBody("uno:tres@gmail.com");
		this.request();
		request.setMethod(HttpMethod.GET);
		request.setPath("users");
		request.clearQueryParams();
		request.setBody("");
		this.request();
		request.setMethod(HttpMethod.POST);
		request.setPath("sports");
		request.setBody("tenis");
		this.request();
		request.setBody("tenis");
		this.request();
		request.setBody("ajedrez");
		this.request();
		request.setMethod(HttpMethod.PUT);
		request.setPath("users/uno/sport");
		request.setBody("tenis");
		this.request();
		request.setBody("noDeporte");
		this.request();
		request.setPath("users/dos/sport");
		request.setBody("tenis");
		this.request();
		request.setBody("ajedrez");
		this.request();
		request.setMethod(HttpMethod.GET);
		request.setPath("users/search");
		request.addHeaderParam("sport", "tenis");
		request.setBody("");
		this.request();
		request.setMethod(HttpMethod.POST);
		request.setPath("noPath");
		request.clearQueryParams();
		this.request();
	}



	public void clearQueryParams() {
		request.clearQueryParams();
		this.showStatus();
	}

	private void showStatus() {
	}

	public void request() {
		System.out.println(request.toString());
		HttpResponse response = server.request(request);
		System.out.println(response);
		System.out.println("---------------------------------------ooo----------------------------------------");
	}

	public static void main(String[] args) {
		ApiArchitectureMain main = new ApiArchitectureMain();
		DaoFactory.setFactory(new DaoFactoryMemory());
		main.demo();
	}
}
