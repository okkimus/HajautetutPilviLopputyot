import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;


public class SAXparser {

    public SAXparser() {

        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();

        try {
            SAXParser saxParser = saxParserFactory.newSAXParser();
            LayerHandler handler = new LayerHandler();
            saxParser.parse(new File("c:\\Users\\Jan\\Desktop\\output.xml"), handler);
            //Get Layers list
            List<Layer> layerList = handler.getLayerList();
            //print layer information
            for (Layer layer : layerList)
                System.out.println(layer);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
    }
}