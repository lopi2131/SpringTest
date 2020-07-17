package com.example.demo;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utils.BaseHooks;

public class HabrWebTests extends BaseHooks {

    @Autowired
    public MainPage mainPage;

    @Autowired
    public CompaniesPage companiesPage;

    @Autowired
    public SiteInformPage siteInformPage;

    @Autowired
    public SearchPage searchPage;

    @Autowired
    public Management management;

    @Autowired
    public SignUpPage signUpPage;

    @Autowired
    public LogInPage logInPage;

    @Test
    public void checkSearchResult() {

        mainPage.open()
                .moveToCompanies()
                .findOtus();
        Assert.assertEquals(companiesPage.checkSearchResult(), "OTUS", "Проверка результатов поиска");
    }

    @Test
    public void checkLocation() {
        mainPage.open()
                .moveToCompanies()
                .findOtus()
                .openOtus();
        Assert.assertTrue(companiesPage.checkLocation().contains("Москва"), "Проверка локации");
        Assert.assertNotNull(companiesPage.checkContentList(), "Проверка, что список не пустой");
    }

    @Test
    public void checkQaLead() {
        mainPage.open()
                .moveToCompanies()
                .findOtus()
                .openOtus()
                .moveToEmployees();
        Assert.assertTrue(companiesPage.checkQaLead().contains("Семён Вяземский"), "Проверка ФИО QA Lead");
    }

    @Test
    public void checkVacancy() {
        mainPage.open()
                .moveToCompanies()
                .findOtus()
                .openOtus()
                .moveToEmployees()
                .moveToVacancies();
        Assert.assertTrue(companiesPage.checkVacanciesListNull().contains("нет открытых вакансий") || companiesPage.checkVacanciesListNull().contains("The company has no open vacancies on") , "Проверка отсутствия открытых вакансий");
    }

    @Test
    public void checkTitle() {
        mainPage.open()
                .moveToCompanies()
                .findOtus()
                .openOtus()
                .moveToEmployees()
                .moveToVacancies()
                .moveToSiteInform();
        Assert.assertTrue(siteInformPage.checkTitle().contains("Информация"), "Проверка заголовка страницы");
    }

    @Test
    public void checkSearchResultContainsOtus() {
        mainPage.open()
                .moveToCompanies()
                .findOtus()
                .openOtus()
                .moveToEmployees()
                .moveToVacancies()
                .moveToSiteInform()
                .searchOtusNotes();
        Assert.assertTrue(searchPage.checkFirstPost().toLowerCase().contains("otus"), "Проверк, что результат поиска содержит текст OTUS");
    }

    @Test
    public void checkHubContainsOtus() {
        mainPage.open()
                .moveToCompanies()
                .findOtus()
                .openOtus()
                .moveToEmployees()
                .moveToVacancies()
                .moveToSiteInform()
                .searchOtusNotes()
                .moveToHub();
        Assert.assertTrue(searchPage.checkOtusBlog().toLowerCase().contains("otus"), "Проверка, что в Хабах есть OTUS");

    }

    @Test
    public void checkCountEmployee() {
        mainPage.open()
                .moveToCompanies()
                .findOtus()
                .openOtus()
                .moveToEmployees()
                .moveToVacancies()
                .moveToSiteInform()
                .searchOtusNotes()
                .moveToHub()
                .moveToUsers();
        Assert.assertEquals(searchPage.checkUsersCount(), 6, "Проверка количества сотрудников OTUS");
    }

    @Test
    public void checkEmployeeSubscribe() {
        mainPage.open()
                .moveToCompanies()
                .findOtus()
                .openOtus()
                .moveToEmployees()
                .moveToVacancies()
                .moveToSiteInform()
                .searchOtusNotes()
                .moveToHub()
                .moveToUsers()
                .moveToOtusUser();
        Assert.assertEquals(searchPage.checkSubs(), "OTUS. Онлайн-образование", "Проверка, что сотрудник подписан на блог OTUS");
    }

    @Test
    public void checkInterfaceLang() {
        mainPage.open()
                .moveToCompanies()
                .findOtus()
                .openOtus()
                .moveToEmployees()
                .moveToVacancies()
                .moveToSiteInform()
                .searchOtusNotes()
                .moveToHub()
                .moveToUsers()
                .moveToOtusUser()
                .setLanguage();
        Assert.assertTrue(searchPage.checkInterfaceLang().contains("bookmarks"), "Проверка языка интерфейса");
    }

    @Test
    public void checkTabLang() {
        mainPage.open()
                .moveToCompanies()
                .findOtus()
                .openOtus()
                .moveToEmployees()
                .moveToVacancies()
                .moveToSiteInform()
                .searchOtusNotes()
                .moveToHub()
                .moveToUsers()
                .moveToOtusUser()
                .setLanguage()
                .moveToManagement();
        Assert.assertTrue(management.checkTabLang().contains("articles"), "Проверка языка вкладки");
    }

    @Test
    public void checkBtn() {
        mainPage.open()
                .moveToCompanies()
                .findOtus()
                .openOtus()
                .moveToEmployees()
                .moveToVacancies()
                .moveToSiteInform()
                .searchOtusNotes()
                .moveToHub()
                .moveToUsers()
                .moveToOtusUser()
                .setLanguage()
                .moveToManagement()
                .moveToReg();
        Assert.assertTrue(signUpPage.checkTitle().toLowerCase().contains("registration"), "Проверка заголовка");
        Assert.assertFalse(signUpPage.checkSignUpBtn(), "Проверка, что кнопка неаквтина, если не заполнены все поля");
    }

    @Test
    public void checkTitleLogIn() {
        mainPage.open()
                .moveToCompanies()
                .findOtus()
                .openOtus()
                .moveToEmployees()
                .moveToVacancies()
                .moveToSiteInform()
                .searchOtusNotes()
                .moveToHub()
                .moveToUsers()
                .moveToOtusUser()
                .setLanguage()
                .moveToManagement()
                .moveToReg()
                .moveToLogIn();
        Assert.assertTrue(logInPage.checkTitle().equalsIgnoreCase("log in"), "Проверка заголовка");
    }
}
