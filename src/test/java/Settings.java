import org.w3c.dom.Document;
import org.w3c.dom.Node;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class Settings {

public static String file = "C://Users//lika2//IdeaProjects//untitled6//Settings.xml";
public static String baseURL;
public static String login;
public static String password;


    public static String getBaseURL() throws Exception {
        if (baseURL == null) {
            Document document = loadSettings();
            Node baseUrlNode = document.getDocumentElement().getElementsByTagName("baseURL").item(0);
            baseURL = baseUrlNode.getTextContent();
        }
        return baseURL;
    }

    public void setBaseURL(String baseURL) {
        this.baseURL = baseURL;
    }


    public static String getLogin() throws Exception {
        if (login == null) {
            Document document = loadSettings();
            Node loginNode = document.getDocumentElement().getElementsByTagName("login").item(0);
            login = loginNode.getTextContent();
        }
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public static String getPassword() throws Exception {
        if (password == null) {
            Document document = loadSettings();
            Node passwordNode = document.getDocumentElement().getElementsByTagName("password").item(0);
            password = passwordNode.getTextContent();
        }
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static Document loadXmlFile(String filePath) {
        try {
            File xmlFile = new File(file);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(xmlFile);
            doc.getDocumentElement().normalize();
            return doc;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Document loadSettings() {
        Document xmlDocument = loadXmlFile(file);
        if (xmlDocument != null) {
            System.out.println("XML file loaded successfully.");
        } else {
            System.out.println("Failed to load XML file.");
        }
        return xmlDocument;
    }
}

