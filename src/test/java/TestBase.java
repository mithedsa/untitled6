import org.junit.Before;

public class TestBase {

    ApplicationManager manager;

    @Before
    public void setUp() throws Exception {
        manager = ApplicationManager.getInstance();
        manager.navigationHelper.OpenHomePage(Settings.baseURL);
        manager.navigationHelper.SetWindowSize();
    }
}
