import org.openqa.selenium.By;

public class LoginHelper extends HelperBase{
    ApplicationManager manager;
    public String loggedInUser;

    public LoginHelper(ApplicationManager manager) {
        super(manager);
    }

    public void Login(String username, String password) {
        if (IsLoggedIn()) {
            if (IsLoggedIn(username)){
                return;
            }
            Logout();
        }

        LoginFielsClick();
        LoginField(username);
        PasswordFieldClick();
        PasswordField(password);
        AuthBtn();

        loggedInUser = username;
    }

    public void AuthBtn() {
        driver.findElement(By.id("login_subm")).click();
    }

    public void PasswordField(String password) {
        driver.findElement(By.xpath("//*[@id=\"Password\"]")).sendKeys(password);
    }

    public void PasswordFieldClick() {
        driver.findElement(By.xpath("//*[@id=\"Password\"]")).click();
    }

    public void LoginField(String username) {
        driver.findElement(By.xpath("//*[@id=\"Nik\"]")).sendKeys(username);
    }

    public void LoginFielsClick() {
        driver.findElement(By.xpath("//*[@id=\"Nik\"]")).click();
    }

    public AccountData getCreatedGroup(){
        String name = driver.findElement(By.id("Nik")).getText();
        String psw = driver.findElement(By.id("Password")).getText();
        AccountData datas = new AccountData(name, psw);
        return datas;
    }

    public String assertUsername() {
        return driver.findElement(By.id("author")).getText();
    }

    public Boolean IsLoggedIn(){
        return loggedInUser != null;
    }

    public Boolean IsLoggedIn(String username){
        return loggedInUser != null && loggedInUser.equals((username));
    }

    public void Logout() {
        loggedInUser = null;
    }

}
