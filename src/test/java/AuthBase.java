import org.junit.Before;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.HashMap;

public class AuthBase extends TestBase{

    @Before
    public void setUp() throws Exception {
        super.setUp();
        manager.loginHelper.Login(Settings.getLogin(), Settings.getPassword());
    }
}
