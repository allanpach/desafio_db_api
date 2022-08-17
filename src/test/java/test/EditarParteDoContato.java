 package test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

import core.BaseTest;
import factory.ContatoDataFactory;
import pojo.ContatoRequestBody;

public class EditarParteDoContato extends BaseTest {

	
	@Test
	public void testeEditarParteContatoComSucesso() throws Exception {
	
		ContatoRequestBody criarContato = ContatoDataFactory.criarNovoContato();
		ContatoRequestBody editarContato = ContatoDataFactory.editarContato();

		String idResp=	
		given()
			.body(criarContato)
		.when()
			.post("/contacts")
		.then()
			.extract().path("data.id");
		given()
			.body(editarContato)
		.when()
			.patch("/contacts/"+idResp+"")
		.then()
			.statusCode(200)
			.body(containsString("id"))
			.body(containsString("type"))
			.body(containsString("attributes"))
			.body("data.attributes.name", is(editarContato.getName()))
			.body("data.attributes.last-name", is(editarContato.getLast_name()))
			.body("data.attributes.email", is(editarContato.getEmail()))
			.body("data.attributes.age", is(Integer.parseInt(editarContato.getAge())))
			.body("data.attributes.phone", is(editarContato.getPhone()))
			.body("data.attributes.address", is(editarContato.getAddress()))
			.body("data.attributes.state", is(editarContato.getState()))
			.body("data.attributes.city", is(editarContato.getCity()));
	
		
	}
	
	@Test
	public void testeEditarParteContatoAtributosRequerido() throws Exception {
	
		ContatoRequestBody criarContato = ContatoDataFactory.criarNovoContato();
		ContatoRequestBody editarContato = ContatoDataFactory.contatoCamposRequeridos();

		String idResp=	
		given()
			.body(criarContato)
		.when()
			.post("/contacts")
		.then()
			.extract().path("data.id");
		given()
			.body(editarContato)
		.when()
			.patch("/contacts/"+idResp+"")
		.then()
			.statusCode(422)
			.body("errors.name[0]", is("não pode ficar em branco"))
			.body("errors.email[0]", is("não pode ficar em branco"))
			.body("errors.email[1]", is("não é válido"))
			.body("errors.age[0]", is("não é um número"))
			.body("errors.phone[0]", is("não é válido"));
	
		
	}
	
	@Test
	public void testeEditarContatoAtributosOpcionais() throws Exception {
	
		ContatoRequestBody criarContato = ContatoDataFactory.criarNovoContato();
		ContatoRequestBody editarContato = ContatoDataFactory.editarContatoSemCamposRequeridos();

		String idResp=	
		given()
			.body(criarContato)
		.when()
			.post("/contacts")
		.then()
			.extract().path("data.id");
		given()
			.body(editarContato)
		.when()
			.patch("/contacts/"+idResp+"")
		.then()
			.statusCode(200)
			.body(containsString("id"))
			.body(containsString("type"))
			.body(containsString("attributes"))
			.body("data.attributes.name", is(editarContato.getName()))
			.body("data.attributes.last-name", is(editarContato.getLast_name()))
			.body("data.attributes.email", is(editarContato.getEmail()))
			.body("data.attributes.age", is(Integer.parseInt(editarContato.getAge())))
			.body("data.attributes.phone", is(editarContato.getPhone()))
			.body("data.attributes.address", is(editarContato.getAddress()))
			.body("data.attributes.state", is(editarContato.getState()))
			.body("data.attributes.city", is(editarContato.getCity()));
				
		
	}
	
	@Test
	public void testeEditarParteContatoAtributoEmailCadastrado() throws Exception {
	
		ContatoRequestBody criarContato = ContatoDataFactory.criarNovoContato();
		ContatoRequestBody editarContato = ContatoDataFactory.contatoCampoEmailEmUso();

		String idResp=	
		given()
			.body(criarContato)
		.when()
			.post("/contacts")
		.then()
			.extract().path("data.id");
		given()
			.body(editarContato)
		.when()
			.patch("/contacts/"+idResp+"")
		.then()
		.statusCode(422)
		.body("errors.email[0]", is("já está em uso"));
		
	}
	
	@Test
	public void testeEditarParteContatoAtributoEmailIncorreto() throws Exception {
	
		ContatoRequestBody criarContato = ContatoDataFactory.criarNovoContato();
		ContatoRequestBody editarContato = ContatoDataFactory.contatoCampoEmailInvalido();

		String idResp=	
		given()
			.body(criarContato)
		.when()
			.post("/contacts")
		.then()
			.extract().path("data.id");
		given()
			.body(editarContato)
		.when()
			.patch("/contacts/"+idResp+"")
		.then()
		.statusCode(422)
		.body("errors.email[0]", is("não é válido"));
		
	}
	
	
	@Test
	public void testeEditarParteContatoAtributoAgeString() throws Exception {
	
		ContatoRequestBody criarContato = ContatoDataFactory.criarNovoContato();
		ContatoRequestBody editarContato = ContatoDataFactory.contatoCampoAgeString();

		String idResp=	
		given()
			.body(criarContato)
		.when()
			.post("/contacts")
		.then()
			.extract().path("data.id");
		given()
			.body(editarContato)
		.when()
			.patch("/contacts/"+idResp+"")
		.then()
		.statusCode(422)
		.body("errors.age[0]", is("não é um número"));
		
	}
	
	@Test
	public void testeEditarParteContatoAtributoPhoneString() throws Exception {
	
		ContatoRequestBody criarContato = ContatoDataFactory.criarNovoContato();
		ContatoRequestBody editarContato = ContatoDataFactory.contatoCampoPhoneString();

		String idResp=	
		given()
			.body(criarContato)
		.when()
			.post("/contacts")
		.then()
			.extract().path("data.id");
		given()
			.body(editarContato)
		.when()
			.patch("/contacts/"+idResp+"")
		.then()
		.statusCode(422)
		.body("errors.phone[0]", is("não é um número"));
		
	}

}
