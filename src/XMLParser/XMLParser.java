package XMLParser;


public class XMLParser {

    public static void main(String [] args){

        // MyXMLParser cd = new cdXML("C:/Users/kkcasombrado/Downloads/XMLParser/src/XMLParser/cd_catalog.xml");
        // System.out.println(cd.parseXML());

        MyXMLParser plant = new plantXML("C:/Users/kkcasombrado/Downloads/XMLParser/src/XMLParser/plant_catalog.xml");
        System.out.println(plant.parseXML());

        // MyXMLParser food = new simpleXML("C:/Users/kkcasombrado/Downloads/XMLParser/src/XMLParser/simple.xml");
        // System.out.println(food.parseXML());

        

    }
    
}
