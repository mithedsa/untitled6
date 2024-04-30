import org.junit.Assert;
import org.junit.Test;

public class ELoginTest extends TestBase{

    @Test
    public void ALoginWithValidData() throws Exception {
        AccountData user = new AccountData(Settings.getLogin(),Settings.getPassword());

        manager.loginHelper.Login(user.getUsername(), user.getPassword());

        String userName = manager.loginHelper.assertUsername();

        Assert.assertEquals(user.getUsername(), userName);

    }


    @Test
    public void BLoginWithInvalidData(){
        manager.navigationHelper.OpenHomePage(Settings.baseURL);
        manager.navigationHelper.SetWindowSize();

        AccountData user = new AccountData("Settings.getLogin()", "Settings.getPassword()");

        manager.loginHelper.Login(user.getUsername(), user.getPassword());
//
//        String userName = manager.loginHelper.assertUsername();
//
//        Assert.assertEquals(user.getUsername(), userName);

    }


}
