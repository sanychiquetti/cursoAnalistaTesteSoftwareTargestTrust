import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class Cadastro_Test2 {

    String url = "https://bugbank.netlify.app";
    String email = "testes@terra.com.br";
    String nome = "Marcos da silva";
    String senha = "123456";
    String campoemail = "//*[@id=\"__next\"]/div/div[2]/div/div[2]/form/div[2]/input";
    String camporegistrar = "//*[@id=\"__next\"]/div/div[2]/div/div[1]/form/div[3]/button[2]";
    String camponome = "//*[@id=\"__next\"]/div/div[2]/div/div[2]/form/div[3]/input";
    String camposenha = "//*[@id=\"__next\"]/div/div[2]/div/div[2]/form/div[4]/div/input";
    String campoconfirmarsenha = "//*[@id=\"__next\"]/div/div[2]/div/div[2]/form/div[5]/div/input";
    String camposaldo = "//*[@id=\"toggleAddBalance\"]";
    String campocadastrar = "//*[@id=\"__next\"]/div/div[2]/div/div[2]/form/button";


    //este metodo testa o cadastro do bugbank
    @Test
    public void cadastrarComSucesso() {
        System.setProperty("webdriver.chrome.driver", "C://Users//Marel-Not//Downloads//PROGRAMAS_SOFTWARE//chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));

        //Estar na URL
        driver.get(url);

        //Clicar em registrar
        driver.findElement(By.xpath(camporegistrar)).click();

        //Clicar no campo email
        driver.findElement(By.xpath(campoemail)).click();

        //Preencher o campo do email testes@terra.com.br
        driver.findElement(By.xpath(campoemail)).sendKeys(email);

        //Preencher o campo nome Marcos da silva
        driver.findElement(By.xpath(camponome)).sendKeys(nome);

        //Preencher o campo senha com 123456
        driver.findElement(By.xpath(camposenha)).sendKeys(senha);

        //preencher o campo confirmação de senha com 123456
        driver.findElement(By.xpath(campoconfirmarsenha)).sendKeys(senha);

        //Selecionar com saldo
        driver.findElement(By.xpath(camposaldo)).click();

        //Apertar o botao cadastrar
        driver.findElement(By.xpath(campocadastrar)).click();
    }

    //Este metodo testa os campos obrigatórios
    @Test
    public void verificarCamposObrigatorios() {
        System.setProperty("webdriver.chrome.driver", "C://Users//Marel-Not//Downloads//PROGRAMAS_SOFTWARE//chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));

        //Estar na url
        driver.get(url);

        //Clicar em registrar
        driver.findElement(By.xpath(camporegistrar)).click();

        //Apertar o botao cadastrar
        driver.findElement(By.xpath(campocadastrar)).click();

        //Visualizar mensagem de campos obrigátorios
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div[2]/form/div[2]/p"));

    }

    //Este metodo valida que com senhas diferentes o cadastro não tem sucesso
    @Test
    public void naoCadastrarSenhasDiferentes() {

        System.setProperty("webdriver.chrome.driver", "C://Users//Marel-Not//Downloads//PROGRAMAS_SOFTWARE//chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));

        //Estar na URL
        driver.get(url);

        //Clicar em registrar
        driver.findElement(By.xpath(camporegistrar)).click();

        //Clicar no campo email
        driver.findElement(By.xpath(campoemail)).click();

        //Preencher o campo do email testes@terra.com.br
        driver.findElement(By.xpath(campoemail)).sendKeys(email);

        //Preencher o campo nome Marcos da silva
        driver.findElement(By.xpath(camponome)).sendKeys(nome);

        //Preencher o campo senha com 123456
        driver.findElement(By.xpath(camposenha)).sendKeys(senha);

        //preencher o campo confirmação de senha com 654321
        driver.findElement(By.xpath(campoconfirmarsenha)).sendKeys("654321");

        //Apertar o botao cadastrar
        driver.findElement(By.xpath(campocadastrar)).click();

        //receber mensagem as senhas são diferentes
        driver.findElement(By.xpath("//*[@id=\"modalText\"]"));

    }

    //Este metodo valida os numero de caracteres na senha
    public void validarNumerosDeCaracteresNaSenha() {

    }

    //Este metodo valida que o cadastro não aconteça com os campos em branco
    public void naoCdastrarComCamposEmBranco() {

    }

    // Este metodo testa o cadastro de conta com saldo
    public void cadastarContaComSaldo(){

    }

}
