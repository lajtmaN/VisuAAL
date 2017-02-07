package parsers;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.IOException;

public class XmlHandler {
    private Document document;
    private String filepath;

    public XmlHandler(String _filepath) throws ParserConfigurationException, IOException, SAXException {
        filepath = _filepath;

        //Find and prepare document
        DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
        document = documentBuilder.parse(filepath);
        document.getDocumentElement().normalize();
    }

    /**
     * Finds the global declarations entry
     * @return returns the global declarations
     */
    public String getGlobalDeclarations() {
        return getGlobalDeclsElement().getFirstChild().getNodeValue();
    }

    /**
     * Set the global declarations
     * @param input is the new value
     * @throws TransformerException
     */
    public void setGlobalDeclarations(String input) throws TransformerException {
        Element firstElement = getGlobalDeclsElement();
        firstElement.getFirstChild().setNodeValue(input);
        writeXML();
    }

    //Find the global declarations element
    private Element getGlobalDeclsElement() {
        NodeList listOfDecls = document.getElementsByTagName("declaration");
        Node GlobalDecls = listOfDecls.item(0);

        if(GlobalDecls.getNodeType() == Node.ELEMENT_NODE) {
            return (Element) GlobalDecls;
        }
        return null;
    }

    // write the content into xml file
    private void writeXML() throws TransformerException {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(document);
        StreamResult result = new StreamResult(new File(filepath));
        transformer.transform(source, result);
    }
}
