package br.com.alura.selenium.pages.usuario;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CadastroUsuarioPage {

	@FindBy(name="usuario.nome")
	private WebElement nome;
	
	@FindBy(name="usuario.email")
	private WebElement email;
	
	@FindBy(id="btnSalvar")
	private WebElement btnSalvar;
	
	public CadastroUsuarioPage bind(WebDriver driver) {
		return PageFactory.initElements(driver, getClass());
	}
	
	public CadastroUsuarioPage nome(String nome) {
		this.nome.sendKeys(nome);
		return this;
	}
	
	public CadastroUsuarioPage email(String email) {
		this.email.sendKeys(email);
		return this;
	}

	public CadastroUsuarioPage salvar() {
		btnSalvar.click();
		return this;
	}
}
