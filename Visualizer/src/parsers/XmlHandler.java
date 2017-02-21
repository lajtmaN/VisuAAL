package parsers;

import Helpers.GUIHelper;
import Model.TemplateUpdate;
import View.MainWindowController;
import javafx.stage.FileChooser;
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
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;

public class XmlHandler {
    final private String dynamicTemplateUpdaterName = "visualizer_updater";
    private Document document;
    private String filepath;

    public XmlHandler(String _filepath) throws ParserConfigurationException, IOException, SAXException {
        //Find and prepare document
        filepath = _filepath;
        DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
        //TODO: Ku være det sku fixes?
        documentFactory.setValidating(false);
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

    public void setDeclarations(HashMap<String, String> allDelcs) throws TransformerException {
        NodeList listOfDecls = document.getElementsByTagName("declaration");
        listOfDecls.item(0).getFirstChild().setNodeValue(allDelcs.get(null));// Global decls

        for (int i = 1; i < listOfDecls.getLength(); i++) {
            NodeList templateElements = listOfDecls.item(i).getParentNode().getChildNodes();
            String scopeOfDecls = getNameOfTemplate(templateElements);
            //String scopeOfDecls = listOfDecls.item(i).getPreviousSibling().getPreviousSibling().getFirstChild().getNodeValue();
            listOfDecls.item(i).getFirstChild().setNodeValue(allDelcs.get(scopeOfDecls));
        }

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

    public HashMap<String, String> getAllDeclarations() {
        NodeList listOfDecls = document.getElementsByTagName("declaration");
        HashMap<String, String> allDecls = new HashMap<>();
        allDecls.put(null, listOfDecls.item(0).getFirstChild().getNodeValue()); // Global decls

        for (int i = 1; i < listOfDecls.getLength(); i++) {
            NodeList templateElements = listOfDecls.item(i).getParentNode().getChildNodes();
            String scopeOfDecls = getNameOfTemplate(templateElements);
            allDecls.put(scopeOfDecls, listOfDecls.item(i).getFirstChild().getNodeValue());
        }
        return allDecls;
    }

    public String getParamaterForTemplate(String template) {
        NodeList templates = document.getElementsByTagName("template");
        for (int i = 0; i < templates.getLength(); i++) {
            NodeList templateNodes = templates.item(i).getChildNodes();
            if (getNameOfTemplate(templateNodes).equals(template)){
                return getTagOfTemplate("parameter", templateNodes);
            }
        }
        return null;
    }

    private String getNameOfTemplate(NodeList templateElements) {
        return getTagOfTemplate("name", templateElements);
    }

    private String getTagOfTemplate(String tag, NodeList templateElements) {
        for (int j=0; j < templateElements.getLength(); j++ ){
            if (templateElements.item(j).getNodeName().equals(tag)){
                return templateElements.item(j).getFirstChild().getNodeValue();
            }
        }
        return null;
    }

    public void writeXMLToFilePath(String newPath) throws TransformerException {
        filepath = newPath;
        writeXML();
    }

    // write the content into xml file
    private void writeXML() throws TransformerException {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(document);
        StreamResult result = new StreamResult(new File(filepath));
        transformer.transform(source, result);
    }

    public void addTemplateUpdatesToModel(List<TemplateUpdate> templateUpdates) throws TransformerException {
        Node n = getDynamicTemplate();
        if(n != null) {
            n.getParentNode().removeChild(n);
        }

        addUpdatesToNode(document.getFirstChild(), templateUpdates);

        addSystemDecl();

        writeXML();
    }

    private void addSystemDecl() {
        Node systemDecls = document.getElementsByTagName("system").item(0).getFirstChild();
        String sysDeclsValue = systemDecls.getNodeValue();

        if(!sysDeclsValue.contains(dynamicTemplateUpdaterName)) {
            String newSysDeclsValue = sysDeclsValue.substring(0, sysDeclsValue.length()-1) + ", "
                    + dynamicTemplateUpdaterName + ";";
            systemDecls.setNodeValue(newSysDeclsValue);
        }
    }

    private void addUpdatesToNode(Node parent, List<TemplateUpdate> templateUpdates) {
        Node template = document.createElement("template");

        Node name = document.createElement("name");
        name.setTextContent("visualizer_updater");
        template.appendChild(name);

        Node decl = document.createElement("declaration");
        String clockName = "visualizer_updater_clock";
        decl.setTextContent("clock " + clockName + ";");
        template.appendChild(decl);

        int startId = 2000;
        int nextId = startId;
        int yPos = 0;

        for(int i = 0; i <= templateUpdates.size(); i++) {
            Node location = document.createElement("location");
            ((Element)location).setAttribute("id", "id" + nextId++);
            ((Element)location).setAttribute("x", "0");
            ((Element)location).setAttribute("y", String.valueOf(yPos));

            if(i < templateUpdates.size()) {
                Node label = document.createElement("label");
                ((Element) label).setAttribute("kind", "invariant");
                ((Element) label).setAttribute("x", "20");
                ((Element) label).setAttribute("y", String.valueOf(yPos));

                label.setTextContent(clockName + " <= " + templateUpdates.get(i).getTime());

                location.appendChild(label);
            }

            yPos += 70;
            template.appendChild(location);
        }

        Node initLoc = document.createElement("init");
        ((Element)initLoc).setAttribute("ref", "id" + startId);
        template.appendChild(initLoc);
        yPos = 0;
        for(int i = 0; i < templateUpdates.size(); i++) {
            Node transition = document.createElement("transition");

            Node src = document.createElement("source");
            ((Element)src).setAttribute("ref", "id" + (startId + i));
            transition.appendChild(src);

            Node target = document.createElement("target");
            ((Element)target).setAttribute("ref", "id" + (startId + i + 1));
            transition.appendChild(target);

            Node label1 = document.createElement("label");
            ((Element)label1).setAttribute("kind", "guard");
            ((Element)label1).setAttribute("x", "20");
            ((Element)label1).setAttribute("y", String.valueOf(yPos + 15));
            label1.setTextContent(clockName + " == " + templateUpdates.get(i).getTime());
            transition.appendChild(label1);

            Node label2 = document.createElement("label");
            ((Element)label2).setAttribute("kind", "assignment");
            ((Element)label2).setAttribute("x", "20");
            ((Element)label2).setAttribute("y", String.valueOf(yPos + 30));
            label2.setTextContent(templateUpdates.get(i).getVariable() + " = " + templateUpdates.get(i).getTheValue());
            transition.appendChild(label2);

            yPos += 70;
            template.appendChild(transition);
        }

        NodeList templateList = document.getElementsByTagName("template");
        parent.insertBefore(template, templateList.item(0));
    }

    private Node getDynamicTemplate() {
        NodeList templateList = document.getElementsByTagName("template");

        String name = null;
        Node n = templateList.item(0).getFirstChild();

        //In case of new new line etc. Skip it
        if(n.getFirstChild() == null) {
            n = n.getNextSibling();
        }
        if(n.hasChildNodes()) {
            name = n.getFirstChild().getNodeValue();
        }

        if(name != null && name.equals(dynamicTemplateUpdaterName))
            return templateList.item(0);
        else
            return null;
    }

    public String getSystemDeclaration (){
        NodeList systemNode = document.getElementsByTagName("system");
        return systemNode.item(0).getFirstChild().getNodeValue();
    }

    public boolean existVisualizerTemplate() {
        return (getDynamicTemplate() != null);
    }

    public int getTemplateCount() {
        return document.getElementsByTagName("template").getLength();
    }
}























