package br.com.alura.selenium.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import br.com.alura.selenium.pages.usuario.CadastroUsuarioPage;
import br.com.alura.selenium.pages.usuario.ListagemUsuarioPage;

public class CadastroUsuarioTest {

	private WebDriver driver;
	
	private ListagemUsuarioPage listagemUsuarioPage;

	private CadastroUsuarioPage cadastroUsuarioPage;
	
	@Before
	public void init() {
		System.setProperty("webdriver.gecko.driver",
				"/home/donini/Selenium Driver/Firefox/geckodriver");
		driver = new FirefoxDriver();
		listagemUsuarioPage = new ListagemUsuarioPage().bind(driver).visita();
		cadastroUsuarioPage = listagemUsuarioPage.visita().novoUsuario();
	}
	
	@After
	public void destroy() {
		driver.close();
	} 
	
	@Test
	public void salvarNovoUsuario() {

		cadastroUsuarioPage
			.nome("Adriano Xavier")
			.email("axavier@empresa.com.br")
			.salvar();
		
		assertTrue(listagemUsuarioPage.existeNaListagem("Adriano Xavier", "axavier@empresa.com.br"));
	}
	
	@Test
	public void salvarNovoUsuarioSemNome() {
		
		cadastroUsuarioPage.email("axavier@empresa.com.br").salvar();
		
		assertTrue(driver.getPageSource().contains("Nome obrigatorio!"));
	}
	
	@Test
	public void salvarNovoUsuarioSemEmail() {
		cadastroUsuarioPage.salvar();
		
		assertTrue(driver.getPageSource().contains("Nome obrigatorio!"));
		assertTrue(driver.getPageSource().contains("E-mail obrigatorio!"));
	}
	
	@Test
	public void deletarUsuario() {
		listagemUsuarioPage.visita();
		listagemUsuarioPage.deletaUsuarioNaPosicao(2);
		
		assertFalse(listagemUsuarioPage.existeNaListagem("Adriano Xavier", "axavier@empresa.com.br"));
	}
}