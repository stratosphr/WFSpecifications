package codegeneration.xml;

import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.StringWriter;

/**
 * Created by stratosphr on 09/03/15.
 */
public class XMLDocument {

    private Document document;
    private XMLNode rootNode;

    public XMLDocument() {
        try {
            this.document = DocumentBuilderFactory.newInstance().newDocumentBuilder().newDocument();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
    }

    public void setRootNode(XMLNode rootNode) {
        this.rootNode = rootNode;
        document.appendChild(rootNode.getElement(document));
    }

    public Document getDocument() {
        return document;
    }

    @Override
    public String toString() {
        try {
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            DOMSource source = new DOMSource(getDocument());
            StringWriter res = new StringWriter();
            StreamResult result = new StreamResult(res);
            transformer.transform(source, result);
            return res.toString();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }
        return "";
    }

}
