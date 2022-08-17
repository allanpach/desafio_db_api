package test;

import static io.restassured.RestAssured.given;
import org.junit.Test;

import core.BaseTest;
import factory.ContatoDataFactory;
import pojo.ContatoRequestBody;

public class ApagarContato extends BaseTest {


	@Test
	public void testeApagarContatoPorId() throws Exception {

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
			.delete("/contacts/"+idResp+"")
		.then()
			.statusCode(204);

		}
	
	@Test
	public void testeApagarContatosPorIdNaoCadastrado() {

		given()
		.when()
		   	.delete("/contacts/969696969d")
		.then()
			.statusCode(404);

		
		

		}
}
