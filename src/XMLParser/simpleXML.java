package XMLParser;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public class simpleXML extends MyXMLParser {

    public simpleXML(String filename) {
        super(filename);
        this.filename = filename;
    }

    @Override
    public String parseXML() {
        StringBuilder composedData = new StringBuilder();
        try {
            File inputFile = new File(filename);
            SAXBuilder saxBuilder = new SAXBuilder();
            Document document = saxBuilder.build(inputFile);
            Element classElement = document.getRootElement();

            List<Element> foodList = classElement.getChildren("food");

            // Create table header
            composedData.append(String.format("%-30s%-30s%-90s%-30s\n", "Name", "Price", "Description", "Calories"));

            // Loop through food elements and add data to table
            for (int temp = 0; temp < foodList.size(); temp++) {
                Element food = foodList.get(temp);
                composedData.append(String.format("%-30s%-30s%-90s%-30s\n", 
                        food.getChildText("name"), food.getChildText("price"), 
                        food.getChildText("description"), food.getChildText("calories")));
            }
        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }

        return composedData.toString();
    }

}
