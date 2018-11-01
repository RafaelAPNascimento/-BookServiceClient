package main;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8081/BookService-1.0/rest/livros");		
		Invocation invocation = target.request(MediaType.APPLICATION_XML).buildGet();		
		Response response = invocation.invoke();
		System.out.println(response.getStatusInfo());
		System.out.println(response.getLength());
		System.out.println(response.getHeaderString("Content-type"));
		
		System.out.println(response.toString());
		
		
//		Thanks to the builder API and some shortcuts, you can write the same behavior in a single line of code:		
//		Response response = ClientBuilder.newClient().target("http://www.myserver.com/book")
//				.request(MediaType.TEXT_PLAIN).get();
	}

}
