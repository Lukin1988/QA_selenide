import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebElementCondition;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;

public class QA_selenide {
    @Test //Заходимо на сайт dou.ua та перевіряемо чи є лого)))
    public void checkLogo() {
        open("https://dou.ua/");
        $("body > div.g-page > header > ul > li.logo > a").shouldBe(visible);
    }

    @Test // Робимо декілька переходів по сайту та перевіряемо що у Календарі є івенти
    public void searсh_event() {
        open("https://dou.ua/");
        $("body > div.g-page > header > ul > li:nth-child(3) > a").click();
        $("body > div.g-page > header > ul > li:nth-child(4) > a").click();
        $("body > div.g-page > header > ul > li:nth-child(5) > a").click();
        $("#container > div.header > header > ul > li.m-last > a").click();
        $("body").shouldHave(text("Події"));
    }

    @Test // В пошук  вводимо  QA, та перевіряемо що пошук виконвася
    public void search() {
        open("https://dou.ua/");
        $("#txtGlobalSearch").setValue("QA").pressEnter();
        $("body").shouldHave(text("Приблизна кількість результатів"));
    }

    @Test // Шукаемо роботу QA на сайті, у місті Львів з досвідом 5 років
    public void search_job() {
        open("https://dou.ua/");
        $("body > div.g-page > header > ul > li:nth-child(6) > a").click();
        $("#container > div.header > div.b-sub-head-n > div.b-jobs-search > form > select > option:nth-child(40)").scrollIntoView(true).click();
        $("#container > div.content-wrap > div > div.row.m-db > div.cell.m-db > div > div.row > div:nth-child(3) > div > div > ul:nth-child(2) > li:nth-child(5) > a").click();
        $("#container > div.content-wrap > div > div.row.m-db > div.cell.m-db > div > div.row > div:nth-child(3) > div > div > ul:nth-child(5) > li:nth-child(2) > a").click();
        $("#container > div.content-wrap > div").shouldHave();  // Тут перевіряю що є контейнер з пошуком
        $("#container > div.content-wrap > div > div.row.m-db > div.cell.m-db > div > div.row > div:nth-child(1) > div.b-vacancies-head > div > h1").shouldBe(text("категорії QA у Львові, досвід 5+ років"));
        // Тут підставляю - Львів та досвід 5+ років - оскільки кількість вакансій може змінюватися
    }

    @Test // Переводимо сайт на англ локаль, та шукаемо контакти
    public void contacts_in_english() {
        open("https://dou.ua/");
        $("body > footer > div > div > div.col18.m-db > p > a").scrollIntoView(true).click();
        $("body > footer > div > div > div.col24.m-db.m-cola > ul > li:nth-child(1) > a").click();
        $("body > div.g-page > section > article > div > ul:nth-child(1) > li:nth-child(1)").shouldBe(text("Jobs, advertising, general issues — support@dou.ua"));
    }

    @Test // Перевіряемо якщо в пошку задати - Телефон, то в результаті будуть мобільні телефони
    public void rozetka_test() {
        open("https://rozetka.com.ua/ua/");
        $("#rz-banner > span > span").click(); // закриваемо поп-ап підсказку
        $("body > rz-app-root > div > div > rz-header > rz-main-header > header > div > div > div > form > div > div.search-form__input-wrapper > input").click();
        $("body > rz-app-root > div > div > rz-header > rz-main-header > header > div > div > div > form > div > div.search-form__input-wrapper > input").setValue("Телефон");
        $("body > rz-app-root > div > div > rz-header > rz-main-header > header > div > div > div > form > button").pressEnter();
        $("body > rz-app-root > div > div > rz-category > div > main > div:nth-child(1) > div > h1").shouldBe(text("Мобільні телефони"));
    }

    @Test // Шукаемо чи є магазин на Відрадному
    public void shop_rozetka(){
        open("https://rozetka.com.ua/ua/");
        $("#rz-banner > span > span").click(); // закриваемо поп-ап підсказку
        $("body > rz-app-root > div > div > rz-main-page > div > aside > rz-main-page-sidebar > a:nth-child(4)").click();
        $("#googleMapSearch").click();
        $("#googleMapSearch").setValue("Відрадний").pressEnter();
        $("#gmarker_937995ee-1516-4c64-bdf0-db096d76bba2").shouldBe(text("просп. Відрадний, 6/1"));
    }
}


