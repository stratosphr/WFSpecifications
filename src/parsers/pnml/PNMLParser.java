package parsers.pnml;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import petrinets.Flow;
import petrinets.Place;
import petrinets.Transition;
import petrinets.WFNet;
import specifications.Specification;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;

public class PNMLParser {

    private Specification specification;

    public WFNet parse(String fileName) {
        WFNet ret = new WFNet();
        HashMap<String, petrinets.Node> nodes = new HashMap<>();
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(fileName);
            NodeList nodeList = document.getDocumentElement().getChildNodes();
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node rootNode = nodeList.item(i);
                if (rootNode instanceof Element) {
                    if (rootNode.getNodeName().equals("net")) {
                        NodeList children = rootNode.getChildNodes();
                        for (int j = 0; j < children.getLength(); j++) {
                            Node child = children.item(j);
                            if(child instanceof Element) {
                                switch (child.getNodeName()){
                                    case "place":
                                        Place place = new Place(((Element) child).getAttribute("id"));
                                        nodes.put(place.toString(), place);
                                        ret.addPlace(place);
                                        break;
                                    case "transition":
                                        Transition transition = new Transition(((Element) child).getAttribute("id"));
                                        nodes.put(transition.toString(), transition);
                                        ret.addTransition(transition);
                                        break;
                                    case "arc":
                                        petrinets.Node source = nodes.get(((Element) child).getAttribute("source"));
                                        petrinets.Node target = nodes.get(((Element) child).getAttribute("target"));
                                        ret.addFlow(new Flow(source, target));
                                        break;
                                }
                            }
                        }
                    }
                }
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
        return ret;
    }

}
