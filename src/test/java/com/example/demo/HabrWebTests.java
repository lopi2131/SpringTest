package com.example.demo;

import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BaseHooks;

public class HabrWebTests extends BaseHooks {

    @Test
    public void demoApplicationTest() {

        mainPage.open()
                .moveToCompanies()
                .findOtus();

        Assert.assertEquals(companiesPage.checkSearchResult(), "OTUS", "Проверка результатов поиска");

        companiesPage.openOtus();
        Assert.assertTrue(companiesPage.checkLocation().contains("Москва"), "Проверка локации");
        Assert.assertNotNull(companiesPage.checkContentList(), "Проверка, что список не пустой");

        companiesPage.moveToEmployees();
        Assert.assertTrue(companiesPage.checkQaLead().contains("Семён Вяземский"), "Проверка ФИО QA Lead");

        companiesPage.moveToVacancies();
        Assert.assertTrue(companiesPage.checkVacanciesListNull().contains("нет открытых вакансий"), "Проверка отсутствия открытых вакансий");

        companiesPage.moveToSiteInform();

        Assert.assertTrue(siteInformPage.checkTitle().contains("Информация"), "Проверка заголовка страницы");

        siteInformPage.searchOtusNotes();
        Assert.assertTrue(searchPage.checkFirstPost().toLowerCase().contains("otus"), "Проверк, что результат поиска содержит текст OTUS");

        searchPage.moveToHub();
        Assert.assertTrue(searchPage.checkOtusBlog().toLowerCase().contains("otus"), "Проверка, что в Хабах есть OTUS");

        searchPage.moveToUsers();
        Assert.assertEquals(searchPage.checkUsersCount(), 6, "Проверка количества сотрудников OTUS");

        searchPage.moveToOtusUser();
        Assert.assertEquals(searchPage.checkSubs(), "OTUS. Онлайн-образование", "Проверка, что сотрудник подписан на блог OTUS");

        searchPage.setLanguage();
        Assert.assertTrue(searchPage.checkInterfaceLang().contains("bookmarks"), "Проверка языка интерфейса");

        searchPage.moveToManagement();
        Assert.assertTrue(management.checkTabLang().contains("articles"), "Проверка языка вкладки");

        management.moveToReg();
        Assert.assertTrue(signUpPage.checkTitle().toLowerCase().contains("registration"), "Проверка заголовка");
        Assert.assertFalse(signUpPage.checkSignUpBtn(), "Проверка, что кнопка неаквтина, если не заполнены все поля");

        signUpPage.moveToLogIn();
        Assert.assertTrue(logInPage.checkTitle().equalsIgnoreCase("log in"), "Проверка заголовка");
    }
}
