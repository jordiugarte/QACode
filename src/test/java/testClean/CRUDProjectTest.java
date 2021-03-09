package testClean;

import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import todoLy.*;
import singletonSession.Session;

public class CRUDProjectTest {
    MainPage mainPage = new MainPage();
    LoginModal loginModal = new LoginModal();
    LeftSection leftSection = new LeftSection();
    CenterSection centerSection = new CenterSection();
    DialogSection dialogSection = new DialogSection();
    String user = "upbui@upbui.com";
    String pwd = "1234";

    @Test
    public void verify_create_project_todoly() throws InterruptedException {
        String name = "CleanProject";
        Session.getSession().getDriver().get("http://todo.ly/");
        mainPage.loginImage.click();
        loginModal.loginAction(user, pwd);

        leftSection.addNewProjectButton.click();
        leftSection.nameProjectTextBox.set(name);
        leftSection.addButton.click();

        Thread.sleep(2000);
        Assert.assertEquals("ERROR !!Projecto No Creado", name, centerSection.projectNameLabel.getText());

    }

    @Test
    public void verify_update_project_todoly() throws InterruptedException {
        String name = "CleanProject";
        String newName = "NewCleanProject";
        Session.getSession().getDriver().get("http://todo.ly/");
        mainPage.loginImage.click();
        loginModal.loginAction(user, pwd);

        leftSection.selectProjectButton(name).click();
        leftSection.optionsProjectButton.click();
        leftSection.editProjectButton.click();
        leftSection.editProjectTextBox.clear();
        leftSection.editProjectTextBox.set(newName);
        leftSection.saveEditProjectTextBox.click();

        Thread.sleep(2000);
        Assert.assertEquals("ERROR !!Projecto No Creado", newName, leftSection.selectProjectButton(newName).getText());

    }

    @Test
    public void verify_delete_project_todoly() throws InterruptedException {
        String name = "CleanProject";

        Session.getSession().getDriver().get("http://todo.ly/");
        mainPage.loginImage.click();
        loginModal.loginAction(user, pwd);

        leftSection.selectProjectButton(name).click();
        leftSection.optionsProjectButton.click();
        leftSection.deleteProjectButton.click();
        dialogSection.acceptButton();

        Thread.sleep(2000);
        Assert.assertTrue("ERROR !!Projecto No Eliminado", !leftSection.selectProjectButton(name).controlIsDisplayed());

    }

    @After
    public void close() {
        Session.getSession().closeSession();
    }
}
