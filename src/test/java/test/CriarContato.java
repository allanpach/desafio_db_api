package test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

import core.BaseTest;
import factory.ContatoDataFactory;
import pojo.ContatoRequestBody;

public class CriarContato extends BaseTest {

	@Test
	public void testeCriarContatoComSucesso() throws Exception {
		
		ContatoRequestBody criarContato = ContatoDataFactory.criarNovoContato();
		given()
			.body(criarContato)
		.when()
			.post("/contacts")
		.then()
			.statusCode(201)
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
	public void testeContatoAtributosRequerido() throws Exception {
		
		ContatoRequestBody criarContato = ContatoDataFactory.contatoCamposRequeridos();
		given()
			.body(criarContato)
		.when()
			.post("/contacts")
		.then()
			.statusCode(422)
			.body("errors.name[0]", is("não pode ficar em branco"))
			.body("errors.email[0]", is("não pode ficar em branco"))
			.body("errors.email[1]", is("não é válido"))
			.body("errors.age[0]", is("não é um número"))
			.body("errors.phone[0]", is("não é válido"));
					
	}
	
	@Test
	public void testeCriarContatoAtributosOpcionais() throws Exception {
		
		ContatoRequestBody criarContato = ContatoDataFactory.contatoSemCamposRequeridos();
		given()
			.body(criarContato)
		.when()
			.post("/contacts")
		.then()
			.statusCode(201)
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
	public void testeCriarContatoAtributoEmailCadastrado() throws Exception {
		
		ContatoRequestBody criarContato = ContatoDataFactory.contatoCampoEmailEmUso();
		given()
			.body(criarContato)
		.when()
			.post("/contacts")
		.then()
			.statusCode(422)
			.body("errors.email[0]", is("já está em uso"));
					
	}
	
	@Test
	public void testeCriarContatoAtributoEmailIncorreto() throws Exception {
		ContatoRequestBody criarContato = ContatoDataFactory.contatoCampoEmailInvalido();
		given()
			.body(criarContato)
		.when()
			.post("/contacts")
		.then()
			.statusCode(422)
			.body("errors.email[0]", is("não é válido"));
					
	}
	
	@Test
	public void testeCriarContatoAtributoAgeString() throws Exception {
		ContatoRequestBody criarContato = ContatoDataFactory.contatoCampoAgeString();
		given()
			.body(criarContato)
		.when()
			.post("/contacts")
		.then()
			.statusCode(422)
			.body("errors.age[0]", is("não é um número"));
					
	}
	
	@Test
	public void testeCriarContatoAtributoPhoneString() throws Exception {
		ContatoRequestBody criarContato = ContatoDataFactory.contatoCampoPhoneString();
		given()
			.body(criarContato)
		.when()
			.post("/contacts")
		.then()
			.statusCode(422)
			.body("errors.phone[0]", is("não é um número"));
					
	}
	
}
