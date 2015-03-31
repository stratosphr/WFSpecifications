package codegeneration.xml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import java.util.ArrayList;

/**
 * Created by stratosphr on 09/03/15.
 */
public class XMLNode {

    protected String name;
    private Element element;
    private ArrayList<XMLNode> children;

    public XMLNode(String name) {
        this.name = name;
        children = new ArrayList<XMLNode>();
    }

    public void addChild(XMLNode child) {
        children.add(child);
    }

    public Element getElement(Document document) {
        if(element == null){
            element = document.createElement(name);
            for(XMLNode node : children){
                element.appendChild(node.getElement(document));
            }
        }
        return element;
    }

}
