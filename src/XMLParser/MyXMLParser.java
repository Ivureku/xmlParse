package XMLParser;


public abstract class MyXMLParser{

    protected String filename;

    public MyXMLParser(String filename){
        this.filename = filename;
    }

    public abstract String parseXML();

}