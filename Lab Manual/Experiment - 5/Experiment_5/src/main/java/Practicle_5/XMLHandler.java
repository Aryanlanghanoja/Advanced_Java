package Practicle_5;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class XMLHandler {

    private static final String XML_FILE_PATH = "D:/Aryan Data/Usefull Data/Semester - 6/Advanced_Java/Lab Manual/Experiment - 5/Experiment_5/src/main/webapp/WEB-INF/user.xml";

    public void addEmailToXML(String email) {
        try {
            File file = new File(XML_FILE_PATH);

            Document doc;
            Element rootElement;

            if (file.exists()) {
                // Parse existing XML
                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                doc = dBuilder.parse(file);
                rootElement = doc.getDocumentElement();
            } else {
                // Create new XML
                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                doc = dBuilder.newDocument();
                rootElement = doc.createElement("Users");
                doc.appendChild(rootElement);
            }

            // Create a new element for email
            Element user = doc.createElement("User");
            Element emailElement = doc.createElement("Email");
            emailElement.appendChild(doc.createTextNode(email));

            user.appendChild(emailElement);
            rootElement.appendChild(user);

            // Write the content into XML
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(file);
            transformer.transform(source, result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
