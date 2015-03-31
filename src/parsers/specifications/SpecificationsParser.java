package parsers.specifications;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import specifications.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.FileNotFoundException;
import java.io.IOException;

public class SpecificationsParser {

    public Specification parse(String fileName) {
        Specification specification = null;
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(fileName);
            SpecificationType specificationType = (document.getDocumentElement().getNodeName().equals("specifications:MustSpecification")) ? SpecificationType.MUST : SpecificationType.MAY;
            NodeList nodeList = document.getDocumentElement().getChildNodes();
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node rootFormula = nodeList.item(i);
                if (rootFormula instanceof Element) {
                    specification = new Specification(specificationType, getFormula(rootFormula));
                    break;
                }
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return specification;
    }

    private Formula getFormula(Node node) {
        switch (((Element) node).getAttribute("xsi:type")) {
            case "specifications:Conjunction":
                ConjunctionFormula conjunction = new ConjunctionFormula();
                for (int i = 0; i < node.getChildNodes().getLength(); i++) {
                    Node child = node.getChildNodes().item(i);
                    if (child instanceof Element) {
                        conjunction.addChild(getFormula(child));
                    }
                }
                return conjunction;
            case "specifications:Disjunction":
                DisjunctionFormula disjunction = new DisjunctionFormula();
                for (int i = 0; i < node.getChildNodes().getLength(); i++) {
                    Node child = node.getChildNodes().item(i);
                    if (child instanceof Element) {
                        disjunction.addChild(getFormula(child));
                    }
                }
                return disjunction;
            case "specifications:Negation":
                NegationFormula negation = new NegationFormula();
                for (int i = 0; i < node.getChildNodes().getLength(); i++) {
                    Node child = node.getChildNodes().item(i);
                    if (child instanceof Element) {
                        negation.addChild(getFormula(child));
                    }
                }
                return negation;
            case "specifications:Transition":
                TransitionFormula transition = new TransitionFormula(((Element) node).getAttribute("name"));
                return transition;
            default:
                return null;
        }
    }

}
