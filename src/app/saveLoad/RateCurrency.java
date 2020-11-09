package app.saveLoad;

import app.model.Currency;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilderFactory;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class RateCurrency {

    public static HashMap<String, Double> getRates (Currency base) throws Exception {
        HashMap<String, NodeList> result = new HashMap<>();

        String url = "http://www.cbr.ru/scripts/XML_daily.asp";

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        Document doc = factory.newDocumentBuilder().parse(new URL(url).openStream());

        NodeList nl = doc.getElementsByTagName("Valute");

        for (int i = 0, l = nl.getLength(); i < l; i++) {
            Node node = nl.item(i);
            NodeList nlChildren = node.getChildNodes();
            for (int j = 0, k = nlChildren.getLength(); j < k; j++) {
                if (nlChildren.item(j).getNodeName().equals("CharCode"))
                    result.put(nlChildren.item(j).getTextContent(), nlChildren);
            }
        }


        HashMap<String, Double> rates = new HashMap<>();
        for (Map.Entry<String, NodeList> entry : result.entrySet()) {
            NodeList temp = entry.getValue();
            double value = 0;
            int nominal = 0;
            for (int i = 0, l = temp.getLength(); i < l; i++) {
                if (temp.item(i).getNodeName().equals("Value"))
                    value = Double.parseDouble(temp.item(i).getTextContent().replace(',', '.'));
                else if (temp.item(i).getNodeName().equals("Nominal"))
                    nominal = Integer.parseInt(temp.item(i).getTextContent());
            }

            double amount = value / nominal;
            rates.put(entry.getKey(), (double) Math.round((amount * 10000) / 10000));
        }
        rates.put("RUB", 1.0);

        double div = rates.get(base.getCode());
        for (Map.Entry<String, Double> entry : rates.entrySet()){
            entry.setValue(entry.getValue() / div);
        }
        return rates;
    }
}
