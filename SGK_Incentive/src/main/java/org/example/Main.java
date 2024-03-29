package org.example;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws InterruptedException{
        WebDriverManager.chromedriver().setup();
        Capabilities Options;
        WebDriver Draver = new ChromeDriver();
        Draver.manage().window().maximize();
        Draver.get("https://uyg.sgk.gov.tr/IsverenSistemi");
        WebElement kullanıcıad = Draver.findElement(By.id("kullaniciIlkKontrollerGiris_username"));
        WebElement kod = Draver.findElement(By.id("kullaniciIlkKontrollerGiris_isyeri_kod"));
        WebElement sistemsifre = Draver.findElement(By.id("kullaniciIlkKontrollerGiris_password"));
        WebElement isyerişifre = Draver.findElement(By.id("kullaniciIlkKontrollerGiris_isyeri_sifre"));
        kullanıcıad.sendKeys(" ");
        kod.sendKeys("");
        sistemsifre.sendKeys((" "));
        isyerişifre.sendKeys("   ");
        WebElement güvenlik = Draver.findElement(By.id("kullaniciIlkKontrollerGiris_isyeri_guvenlik"));
        güvenlik.click();
        Thread.sleep(10000);
        WebElement giriş = Draver.findElement(By.xpath("//*[@id=\"kullaniciIlkKontrollerGiris\"]/button"));
        giriş.click();

        String mainWindowHandle = Draver.getWindowHandle();
        Set<String> allWindowHandles = Draver.getWindowHandles();
        for (String handle : allWindowHandles) {
            if (!handle.equals(mainWindowHandle)) {
                Draver.switchTo().window(handle);
            }
        }
        WebElement elementInPopup = Draver.findElement(By.xpath("//*[@id=\"menuForm:panelMenuId\"]/h3[2]"));
        elementInPopup.click();
        Thread.sleep(2000);
        WebElement tesvik = Draver.findElement(By.xpath("//*[@id=\"menuForm:anaMenu1subMenu4\"]"));
        tesvik.click();
        Thread.sleep(2000);
        WebElement madde10 = Draver.findElement(By.xpath("//*[@id=\"menuForm:anaMenu1\"]/ul/li[5]/ul/li[5]"));
        madde10.click();
        Thread.sleep(2000);
        Draver.switchTo().frame("pencereLinkIdYeni");
        WebElement excel = Draver.findElement(By.xpath("//*[@id=\"contentContainer\"]/div/table/tbody/tr[2]/td/table/tbody/tr[2]/td[2]/div/div/label[2]/input"));
        excel.click();
        Thread.sleep(2000);

        String popupWindowHandle = "handle";
        for (String handle : allWindowHandles) {
            if (!handle.equals(mainWindowHandle)) {

                Draver.switchTo().window(handle);
            }
        }
        elementInPopup = Draver.findElement(By.xpath("//*[@id=\"menuForm:panelMenuId\"]/h3[2]"));
        elementInPopup.click();
        Thread.sleep(2000);
        tesvik = Draver.findElement(By.xpath("//*[@id=\"menuForm:anaMenu1subMenu4\"]"));
        tesvik.click();
        Thread.sleep(2000);
        WebElement madde20=Draver.findElement(By.xpath("//*[@id=\"menuForm:anaMenu1subMenu4subItem14\"]/span"));
        madde20.click();
        List<WebElement> veriListesi = Draver.findElements(By.xpath("//*[@id=\"contentContainer\"]/div/table/tbody/tr[2]/td"));
        if (!veriListesi.isEmpty()) {
            WebElement excelIndir = Draver.findElement(By.xpath("//*[@id=\"contentContainer\"]/div/table/tbody/tr[2]/td"));
            excelIndir.click();
            Thread.sleep(2000);
        } else {
            System.out.println("Listede veri yok, Excel indirme işlemi gerçekleştirilmedi.");
        }



    }
    }
