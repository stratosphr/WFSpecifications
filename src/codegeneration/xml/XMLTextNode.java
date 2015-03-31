package codegeneration.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 * Created by stratosphr on 09/03/15.
 */
public class XMLTextNode extends XMLNode {

    private String text;
    private Element element;

    public XMLTextNode(String name, String text) {
        super(name);
        this.text = text;
    }

    @Override
    public void addChild(XMLNode child) {
    }

    @Override
    public Element getElement(Document document) {
        Element node = document.createElement(name);
        node.appendChild(document.createTextNode(text));
        return node;
    }

}
