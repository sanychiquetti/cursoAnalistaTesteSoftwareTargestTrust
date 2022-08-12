import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;

public class Cadastro_Test{
    //este metodo testa o cadastro do bugbank
    @Test
    public void cadastrarComSucesso() {
        System.setProperty("webdriver.chrome.driver","C://Users//Marel-Not//Downloads//PROGRAMAS_SOFTWARE//chromedriver.exe");
    ChromeDriver driver = new ChromeDriver();

        driver.manage().

    timeouts().

    implicitlyWait(Duration.ofMillis(1000));

    //Estar na URL
        driver.get("https://bugbank.netlify.app");

    //Clicar em registrar
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div[1]/form/div[3]/button[2]")).click();

    //Clicar no campo e-mail
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div[2]/form/div[2]/input")).click();

    //Preencher o campo do email testes@terra.com.br
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div[2]/form/div[2]/input")).sendKeys("testes@terra.com.br");

    //Preencher o campo nome marcos da silva
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div[2]/form/div[3]/input")).sendKeys("marcos da silva");

    //Preencher o campo senha com 123456
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div[2]/form/div[4]/div/input")).sendKeys("123456");

    //preencher o campo confirmação de senha com 123456
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div[2]/form/div[5]/div/input")).sendKeys("123456");

    //Selecionar com saldo
        driver.findElement(By.xpath("//*[@id=\"toggleAddBalance\"]")).click();

    //Apertar o botao cadastrar
        driver.findElement(By.xpath("//*[@id=\"__next\"]/div/div[2]/div/div[2]/form/button")).click();
}
}