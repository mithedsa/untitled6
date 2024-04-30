import org.junit.Assert;
import org.junit.Test;

public class AAuthTest extends TestBase{
    @Test
    public void firstTest() throws Exception {

        AccountData user = new AccountData(Settings.getLogin(),Settings.getPassword());

        manager.loginHelper.Login(user.getUsername(), user.getPassword());

        String userName = manager.loginHelper.assertUsername();

        Assert.assertEquals(user.getUsername(), userName);

    }
}
