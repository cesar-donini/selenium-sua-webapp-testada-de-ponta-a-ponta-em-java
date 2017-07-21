package br.com.alura.selenium.pages.usuario;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ListagemUsuarioPage {

	private WebDriver driver;

	@FindBy(linkText="Novo Usuário")
	private WebElement linkNovoUsuario;	
	
	public ListagemUsuarioPage bind(WebDriver driver) {
		return ((ListagemUsuarioPage)
				PageFactory.initElements(driver, getClass()))
					.initDriver(driver);
	}
	
	public ListagemUsuarioPage visita() {
		driver.get("http://localhost:8080/usuarios");
		return this;
	}
	
	public CadastroUsuarioPage novoUsuario() {
		linkNovoUsuario.click();
		return new CadastroUsuarioPage().bind(driver);
	}
	
	public boolean existeNaListagem(String nome, String email) {
        return driver.getPageSource().contains(nome) && 
                driver.getPageSource().contains(email);
    }
	
	private ListagemUsuarioPage initDriver(WebDriver driver) {
		this.driver = driver;
		return this;
	}
	
	public void deletaUsuarioNaPosicao(int posicao) {
       WebElement button = driver.findElements(By.tagName("button")).get(posicao-1);
       button.click();
       // pega o alert que está aberto
       Alert alert = driver.switchTo().alert();
       // confirma
       alert.accept();
    }
}
