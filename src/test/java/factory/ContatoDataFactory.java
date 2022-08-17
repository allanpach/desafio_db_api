package factory;

import java.io.FileInputStream;

import com.fasterxml.jackson.databind.ObjectMapper;

import pojo.ContatoRequestBody;

public class ContatoDataFactory {
	public static ContatoRequestBody criarNovoContato() throws Exception {
		ObjectMapper objectMapper = new ObjectMapper();
		ContatoRequestBody contato = objectMapper.readValue(
				new FileInputStream("src\\test\\resources\\requestBody\\contato.json"),
				ContatoRequestBody.class);
		contato.setEmail("allanteste"+System.nanoTime()+"@gmail.com");
		return contato;

	}
	
	public static ContatoRequestBody contatoCamposRequeridos() throws Exception {
		ContatoRequestBody contato = criarNovoContato();
		contato.setName(null);
		contato.setEmail(null);
		contato.setAge(null);
		contato.setPhone(null);
		return contato;
	}
	
	public static ContatoRequestBody contatoSemCamposRequeridos() throws Exception {
		ContatoRequestBody contato = criarNovoContato();
		contato.setLast_name(null);
		contato.setAddress(null);
		contato.setState(null);
		contato.setCity(null);
		return contato;
	}

	public static ContatoRequestBody contatoCampoEmailEmUso() throws Exception {
		ContatoRequestBody contato = criarNovoContato();
		contato.setEmail("bruno@gmail.com");
		return contato;
	}
	
	public static ContatoRequestBody contatoCampoEmailInvalido() throws Exception {
		ContatoRequestBody contato = criarNovoContato();
		contato.setEmail("bruno_gmail.com");
		return contato;
	}
	
	public static ContatoRequestBody contatoCampoAgeString() throws Exception {
		ContatoRequestBody contato = criarNovoContato();
		contato.setAge("XX");
		return contato;
	}
	
	public static ContatoRequestBody contatoCampoPhoneString() throws Exception {
		ContatoRequestBody contato = criarNovoContato();
		contato.setPhone("baaaasssss12");
		return contato;
	}
	
	public static ContatoRequestBody editarContato() throws Exception {
		ContatoRequestBody contato = criarNovoContato();
		contato.setName(contato.getName()+"ALterado");
		contato.setLast_name(contato.getLast_name()+"ALterado");
		contato.setAge("33");
		contato.setPhone("21123456789");
		contato.setAddress(contato.getAddress()+"ALterado");
		contato.setState(contato.getState()+"ALterado");
		contato.setCity(contato.getCity()+"ALterado");
		return contato;
	}
	
	public static ContatoRequestBody editarContatoSemCamposRequeridos() throws Exception {
		ContatoRequestBody contato = criarNovoContato();
		contato.setName(contato.getName()+"ALterado");
		contato.setLast_name(null);
		contato.setAge("33");
		contato.setPhone("21123456789");
		contato.setAddress(null);
		contato.setState(null);
		contato.setCity(null);
		return contato;
	}
	
	public static ContatoRequestBody editarContatoCampoEmailEmUso() throws Exception {
		ContatoRequestBody contato = criarNovoContato();
		contato.setName(contato.getName()+"ALterado");
		contato.setEmail("bruno@gmail.com");
		return contato;
	}

	public static ContatoRequestBody editarContatoCampoEmailInvalido() throws Exception {
		ContatoRequestBody contato = criarNovoContato();
		contato.setEmail("test_gmail.com");
		return contato;
	}
	
}
