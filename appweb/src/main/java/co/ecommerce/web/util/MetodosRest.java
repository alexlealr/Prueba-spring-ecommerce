package co.ecommerce.web.util;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

/**
 * Class that implements rest methods for system raw requests
 * @author Alexander Leal
 * @param <Producto>
 */
@Component
public class MetodosRest<Producto> {
		private HttpStatus status;
		private String server;
		private RestTemplate rest;
		private HttpHeaders headers;
		/**
		 * Constructor method of the class
		 */
		public MetodosRest() {
			server = "http://localhost:8888";
			rest = new RestTemplate();
			headers = new HttpHeaders();
			headers.add("Content-Type","application/json");
			headers.add("Accept", "*/*");
//			headers.add("Authorization",
//					"Bearer eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJhcm9tZXJvIiwidXN1YXJpbyI6ImFyb21lcm8iLCJyb2wiOlt7ImF1dGhvcml0eSI6IkNOPUFkbWluaXN0cmFkb3JGdW5jaW9uYWwsT1U9c3NlcHAsT1U9QXBsaWNhY2lvbmVzLE9VPVNEUCJ9LHsiYXV0aG9yaXR5IjoiQ049U2VjdG9yaWFsaXN0YVNEUCxPVT1zc2VwcCxPVT1BcGxpY2FjaW9uZXMsT1U9U0RQIn0seyJhdXRob3JpdHkiOiJDTj1TR1NfQURNSU4sT1U9U0VHVVJJREFELE9VPVNEUCJ9LHsiYXV0aG9yaXR5IjoiQ049U0VQUF9ESVJFQ1RJVk8sT1U9U0VQUCxPVT1TRFAifV0sImV4cCI6MTU3Njc5NTE0M30.jp1stl6J_wiRDYmAyPW3qlkvuOat59dn25joC0Pedw0");
		}
		/**
		 * Method that allows you to make a post request to a web service
		 *
		 * @param dto The dto that will be used to make the post request
		 * @param c   the class of the dto to identify it
		 * @param uri the url to which we will send the dto
		 * @return the api response
		 */
		public Producto post(Producto dto, Class<Producto> c, String uri) {
			HttpEntity<Producto> requestEntity = new HttpEntity<>(dto, headers);
			ResponseEntity<Producto> responseEntity = rest.exchange(server + uri, HttpMethod.POST, requestEntity, c);
			setStatus(responseEntity.getStatusCode());
			return (Producto) responseEntity.getBody();
		}
		/**
		 * Method that allows a request to get to a web service
		 *
		 * @param uri url to which the request will be made
		 * @param c  class to know what the request will return
		 * @return a list, object or query requested
		 */
		public Producto get(String uri, Class<Producto> c) {
			HttpEntity<String> requestEntity = new HttpEntity<>("", headers);
			ResponseEntity<Producto> responseEntity = rest.exchange(server + uri, HttpMethod.GET, requestEntity, c);
			this.setStatus(responseEntity.getStatusCode());
			return (Producto) responseEntity.getBody();
		}
		/**
		 * Method that allows you to make a request to put a web service
		 *
		 * @param dto objeto que se enviara por la peticion put
		 * @param c   object to be sent by the request put
		 * @param uri url to which you wish to make the request
		 */
		public void put(Producto dto, Class<Producto> c, String uri) {
			HttpEntity<Producto> requestEntity = new HttpEntity<>(dto, headers);
			ResponseEntity<Producto> responseEntity = rest.exchange(server + uri, HttpMethod.PUT, requestEntity, c);
			setStatus(responseEntity.getStatusCode());
			this.setStatus(responseEntity.getStatusCode());
		}
		public HttpStatus getStatus() {
			return status;
		}
		public void setStatus(HttpStatus status) {
			this.status = status;
		}
		/**
		 * @return the server
		 */
		public String getServer() {
			return server;
		}
		/**
		 * @param server the server to set
		 */
		public void setServer(String server) {
			this.server = server;
		}
		
	}

