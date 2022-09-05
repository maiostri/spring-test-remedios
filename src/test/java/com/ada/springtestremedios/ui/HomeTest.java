package com.ada.springtestremedios.ui;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HomeTest {

    private WebDriver webDriver;

    @BeforeAll
    public static void setUpWebDriver() {
        System.setProperty("webdriver.chrome.driver", "chromedriver");
    }

    @Test
    public void listRemedios() {
        webDriver = new ChromeDriver();

        webDriver.get("http://localhost:8080/home");

        String titulo = webDriver.getTitle();

        Assertions.assertEquals("Remedios", titulo);

        WebElement nome = webDriver.findElement(By.name("nome"));
        String valorNome = nome.getText();

        WebElement descricao = webDriver.findElement(By.name("descricao"));
        String valorDescricao = descricao.getText();

        WebElement preco = webDriver.findElement(By.name("preco"));
        String valorPreco = preco.getText();

        Assertions.assertEquals("teste2", valorNome);
        Assertions.assertEquals("teste2", valorDescricao);
        Assertions.assertEquals("1.00", valorPreco);

        webDriver.quit();
    }

    @Test
    public void insereRemedio() {
        webDriver = new ChromeDriver();

        webDriver.get("http://localhost:8080/create");

        WebElement nome = webDriver.findElement(By.name("nome"));
        nome.sendKeys("tes");
        WebElement descricao = webDriver.findElement(By.name("descricao"));
        descricao.sendKeys("tes");
        WebElement preco = webDriver.findElement(By.name("preco"));
        preco.sendKeys("10");

        WebElement submit = webDriver.findElement(By.id("submitButton"));
        submit.click();


        String titulo = webDriver.getTitle();
        Assertions.assertEquals("Remedios", titulo);

        WebElement nomeInserido = webDriver.findElement(By.name("nome"));
        WebElement descricaoInserida = webDriver.findElement(By.name("descricao"));
        WebElement precoInserido = webDriver.findElement(By.name("preco"));

        Assertions.assertEquals("tes", nomeInserido.getText());
        Assertions.assertEquals("tes", descricaoInserida.getText());
        Assertions.assertEquals("10.00", precoInserido.getText());

        webDriver.quit();
    }
}
