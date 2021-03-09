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

    @Test
    public void verify_create_item_todoly() throws InterruptedException {
        String projectName = "CleanProject";
        String itemName = "Item";

        Session.getSession().getDriver().get("http://todo.ly/");
        mainPage.loginImage.click();
        loginModal.loginAction(user, pwd);

        leftSection.selectProjectButton(projectName).click();
        centerSection.itemNameTextBox.click();
        centerSection.itemNameTextBox.clear();
        centerSection.itemNameTextBox.set(itemName);
        centerSection.addItemButton.click();

        Thread.sleep(2000);
        Assert.assertEquals("ERROR !!Item no creado", itemName, centerSection.selectItemButton(itemName).getText());
    }

    @Test
    public void verify_update_item_todoly() throws InterruptedException {
        String projectName = "CleanProject";
        String itemName = "Item";
        String newItemName = "NewItem";

        Session.getSession().getDriver().get("http://todo.ly/");
        mainPage.loginImage.click();
        loginModal.loginAction(user, pwd);

        leftSection.selectProjectButton(projectName).click();
        centerSection.selectItemButton(itemName).click();
        centerSection.itemNameTextBox.clear();
        centerSection.itemNameTextBox.set(newItemName);
        centerSection.itemNameTextBox.click();
        centerSection.itemNameTextBox.clear();
        centerSection.itemNameTextBox.set(itemName);
        centerSection.saveItemButton.click();

        Thread.sleep(2000);
        Assert.assertEquals("ERROR !!Item no actualizado", itemName, centerSection.selectItemButton(itemName).getText());
    }


    @Test
    public void verify_delete_item_todoly() throws InterruptedException {
        String projectName = "CleanProject";
        String itemName = "Item";

        Session.getSession().getDriver().get("http://todo.ly/");
        mainPage.loginImage.click();
        loginModal.loginAction(user, pwd);

        leftSection.selectProjectButton(projectName).click();
        centerSection.selectItemButton(itemName).click();
        centerSection.itemOptionsButton.click();
        centerSection.deleteOptionsButton.click();

        Thread.sleep(2000);
        Assert.assertTrue("ERROR !!Item No Eliminado", !centerSection.selectItemButton(itemName).controlIsDisplayed());
    }

    @After
    public void close() {
        Session.getSession().closeSession();
    }
}
