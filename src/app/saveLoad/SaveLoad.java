package app.saveLoad;

import app.settings.Settings;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class SaveLoad { // saving and loading data

    public static void load(SaveData saveData){
        try {
            JAXBContext context = JAXBContext.newInstance(Wrapper.class);
            Unmarshaller um = context.createUnmarshaller();
            Wrapper wrapper = (Wrapper) um.unmarshal(Settings.getFileSave());
            saveData.setAccounts(wrapper.getAccounts());
            saveData.setArticles(wrapper.getArticles());
            saveData.setTransactions(wrapper.getTransactions());
            saveData.setTransfers(wrapper.getTransfers());
            saveData.setCurrencies(wrapper.getCurrencies());

        } catch (JAXBException e) {
            System.out.println("File does not exist");
        }
    }


    public static void save(SaveData saveData){
        try {
            JAXBContext context = JAXBContext.newInstance(Wrapper.class);
            Marshaller m = context.createMarshaller();
            m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            Wrapper wrapper = new Wrapper();
            wrapper.setAccounts(saveData.getAccounts());
            wrapper.setArticles(saveData.getArticles());
            wrapper.setTransactions(saveData.getTransactions());
            wrapper.setTransfers(saveData.getTransfers());
            wrapper.setCurrencies(saveData.getCurrencies());

            m.marshal(wrapper, Settings.getFileSave());
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
