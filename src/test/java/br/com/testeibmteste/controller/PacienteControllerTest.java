package br.com.testeibmteste.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import br.com.testeibm.controller.PacienteController;
import br.com.testeibm.controller.exception.ResourceExceptionHandler;
import br.com.testeibm.domain.Paciente;
import br.com.testeibm.service.PacienteService;

@AutoConfigureMockMvc
@RunWith(MockitoJUnitRunner.class)
@WebMvcTest(PacienteController.class)
public class PacienteControllerTest {
	
	private static final String ROTA = "localhost:8080/paciente/";
	private static final String BODY ="{email:rod@gmail.com,senha:123}";
	 
	@InjectMocks
	private PacienteController controller;
	
	@Mock
	private PacienteService service;
	
	private MockMvc mockMvc;
	private MvcResult result;
	private String mensagem = "erro";
	private String Authorization = "Authorization";
	private List<Paciente> response;
	private String token = "Bearer*";
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
		this.mockMvc=MockMvcBuilders.standaloneSetup(controller).setControllerAdvice(new ResourceExceptionHandler()).build();
		
		response = new ArrayList<Paciente>();
	}
	
	@Test
	public void deveRealizarGetTestPaciente() throws Exception{
		when(service.findAll()).thenReturn(getListaMock());
		getToken();
	
		result = this.mockMvc.perform(get(ROTA)
				.header(Authorization, token)).andReturn();
	
		assertNotNull(result);
		assertEquals(HttpStatus.OK,result.getResponse());
		assertTrue(result.getResponse().getContentAsString().contains("\"nome\":\"Teste\""));
	}
	
	private List<Paciente> getListaMock() {
		Paciente pasc = new Paciente();
		
		List<Paciente> lista = new ArrayList<>();
		pasc.setNome("Nome Teste");
		pasc.setIdade(35);
		pasc.setAltura(1.75);
		pasc.setPeso(100.00);
		pasc.setSexo("Masc");
		
		lista.add(pasc);
		
		return lista ;
			
		
	}
	
	private String getToken() throws IOException {
		
//		URL url;
//		try {
//		//	url = new URL(ROTA,BODY);
//			HttpURLConnection con =(HttpURLConnection) url.openConnection().;
//			
//			BufferedReader br = new BufferedReader(new InputStreamReader((con.getInputStream())));
//			System.out.println(br);
//			
//		} catch (MalformedURLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		 
		 
		
		return Authorization;
		
	}
	
	
	
}
