package XMLParser;

import java.io.*;
import java.util.*;
import org.jdom2.*;
import org.jdom2.input.SAXBuilder;    


public class cdXML extends MyXMLParser{
    
    private static final String HEADER_ROW = String.format("\n%-30s %-30s %-30s %-30s %-30s %-30s\n\n", 
        "Song Title", "Song Artist", "Country of Origin", "Record Company", "Price", "Year Released");

    public cdXML(String filename){
        super(filename);
        this.filename = filename;
    }

    @Override
    public String parseXML() {
        StringBuilder xmlData = new StringBuilder();
        try {
            //Stores the filename parameter
            File inputFile = new File(filename);
            //Initializes the saxbuilder object
            SAXBuilder saxBuilder = new SAXBuilder();
            Document document = saxBuilder.build(inputFile);
            //gets the root element and then applies the corresponding name to the list
            Element classElement = document.getRootElement();
            List<Element> cdList = classElement.getChildren("CD");

            xmlData.append(HEADER_ROW);

            //arranges the xml data into table like format
            for (int temp = 0; temp < cdList.size(); temp++) {    
                Element cd = cdList.get(temp);
                xmlData.append(String.format("%-30s %-30s %-30s %-30s %-30s %-30s\n", 
                    cd.getChild("TITLE").getText(), cd.getChild("ARTIST").getText(),
                    cd.getChild("COUNTRY").getText(), cd.getChild("COMPANY").getText(),
                    cd.getChild("PRICE").getText(), cd.getChild("YEAR").getText()));
            }
        } catch(JDOMException e) {
            e.printStackTrace();
        } catch(IOException ioe) {
            ioe.printStackTrace();
        }
        
        return xmlData.toString();
    }
}

        
       