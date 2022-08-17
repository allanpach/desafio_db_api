package test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

import core.BaseTest;
import factory.ContatoDataFactory;
import io.qameta.allure.Step;
import pojo.ContatoRequestBody;

public class ListarContatos extends BaseTest {
		
	
	@Test
	public void testeListarOsContatosPorId() throws Exception {

		ContatoRequestBody criarContato = ContatoDataFactory.criarNovoContato();
		
		String idResp=	
				given()
				.body(criarContato)
			.when()
				.post("/contacts")
			.then()
				.extract().path("data.id");
		 given()
		.when()
			.get("/contacts/"+idResp+"")
		.then()
			.statusCode(200)
			.body(containsString("id"))
			.body(containsString("type"))
			.body(containsString("attributes"))
			.body("data.attributes.name", is(criarContato.getName()))
			.body("data.attributes.last-name", is(criarContato.getLast_name()))
			.body("data.attributes.email", is(criarContato.getEmail()))
			.body("data.attributes.age", is(Integer.parseInt(criarContato.getAge())))
			.body("data.attributes.phone", is(criarContato.getPhone()))
			.body("data.attributes.address", is(criarContato.getAddress()))
			.body("data.attributes.state", is(criarContato.getState()))
			.body("data.attributes.city", is(criarContato.getCity()));

		}
	
	@Test
	public void testeListarContatosTodos() {

		given()
		.when()
		   	.get("/contacts")
		.then()
			.statusCode(200)
			.body(containsString("id"))
			.body(containsString("type"))
			.body(containsString("attributes"))
			.body("data[0].attributes.name",is(notNullValue()))
			.body("data[0].attributes.last-name", is(notNullValue()))
			.body("data[0].attributes.age", is(notNullValue()))
			.body("data[0].attributes.phone", is(notNullValue()));


		}
	
	 @Step
	@Test
	public void testeListarContatosPorIdNaoCadastrado() {

		given()
		.when()
		   	.get("/contacts/969696969d")
		.then()
			.statusCode(404);

		
		

		}
	
	}
