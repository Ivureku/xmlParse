package XMLParser;

import java.io.*;
import java.util.*;
import org.jdom2.*;
import org.jdom2.input.SAXBuilder;    

public class plantXML extends MyXMLParser{
    private static final String HEADER_ROW = String.format("\n%-25s %-25s %-25s %-25s %-25s %-25s\n\n", "COMMON", "BOTANICAL", "ZONE", "LIGHT", "PRICE", "AVAILABILITY");

    public plantXML(String filename){
        super(filename);
        this.filename = filename;
    }

    @Override
    public String parseXML() {
        StringBuilder xmlData = new StringBuilder();
        try {
            File inputFile = new File(filename);
            SAXBuilder saxBuilder = new SAXBuilder();
            Document document = saxBuilder.build(inputFile);
            Element classElement = document.getRootElement();
            List<Element> plantList = classElement.getChildren("PLANT");

            xmlData.append(HEADER_ROW);

            for (int temp = 0; temp < plantList.size(); temp++) {    
                Element plants = plantList.get(temp);
                xmlData.append(String.format("%-25s %-25s %-25s %-25s %-25s %-25s\n", 
                    plants.getChild("COMMON").getText(), plants.getChild("BOTANICAL").getText(),
                    plants.getChild("ZONE").getText(), plants.getChild("LIGHT").getText(),
                    plants.getChild("PRICE").getText(), plants.getChild("AVAILABILITY").getText()));
            }
        } catch(JDOMException e) {
            e.printStackTrace();
        } catch(IOException ioe) {
            ioe.printStackTrace();
        }
        
        return xmlData.toString();

    }
    
}