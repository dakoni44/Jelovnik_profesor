package org.ftninformatika.termin18_jelovnik;

import java.util.ArrayList;
import java.util.List;

public class DataProvider {
    private List<Jelo> jela;
    private List<Kategorija> kategorije;
    private List<String> dummyIngridients;
    private static DataProvider _instance;

    public static DataProvider getInstance(){
        if (_instance == null){
            _instance = new DataProvider();
        }
        return _instance;
    }

    DataProvider(){
        fillKategorije();
        fillIngridients();
        fillJela();
    }

    private void fillJela(){
        jela = new ArrayList<>();
        jela.add(new Jelo(982, "Spageti", 5, dummyIngridients, "", 350f, 4.2f));
        jela.add(new Jelo(154, "Pohovani kackavalj", 0, dummyIngridients, "", 320f, 3.9f));
        jela.add(new Jelo(91, "Karadjordeva", 5, dummyIngridients, "", 799f, 4.5f));
        jela.add(new Jelo(745, "Sopska", 12, dummyIngridients, "", 200f, 2.2f));
        jela.add(new Jelo(339, "Krempita", 33, dummyIngridients, "", 150f, 4.8f));
        jela.add(new Jelo(198, "Pomfrit", 765, dummyIngridients, "", 990f, 2.9f));
        jela.add(new Jelo(256, "Paradajz corba", 1, dummyIngridients, "", 350f, 3.5f));
        jela.add(new Jelo(44, "Kapricoza", 5, dummyIngridients, "", 350f, 4.1f));
        jela.add(new Jelo(151, "Sladoled", 33, dummyIngridients, "", 120f, 4.0f));
        jela.add(new Jelo(654, "Punjena paprika", 5, dummyIngridients, "", 350f, 4.9f));
    }

    private void fillKategorije(){
        kategorije = new ArrayList<>();
        kategorije.add(new Kategorija(0, "Predjelo"));
        kategorije.add(new Kategorija(1, "Supe"));
        kategorije.add(new Kategorija(5, "Glavno jelo"));
        kategorije.add(new Kategorija(12, "Salate"));
        kategorije.add(new Kategorija(33, "Dezerti"));
        kategorije.add(new Kategorija(765, "Prilozi"));
    }

    private void fillIngridients(){
        if (dummyIngridients != null){
            dummyIngridients = new ArrayList<>();
            dummyIngridients.add("Prsuta");
            dummyIngridients.add("Mocarela");
            dummyIngridients.add("Paradajz");
            dummyIngridients.add("Pavlaka");
            dummyIngridients.add("Brasno");
            dummyIngridients.add("Slanina");
            dummyIngridients.add("Piletina");
        }
    }

    public Kategorija getKategorijaById(int id){
        switch (id){
            case 0:
                return kategorije.get(0);
            case 1:
                return kategorije.get(1);
            case 5:
                return kategorije.get(2);
            case 12:
                return kategorije.get(3);
            case 33:
                return kategorije.get(4);
            case 765:
                return kategorije.get(5);
            default:
                return null;
        }
    }

    public Jelo getJeloById(int id){
        switch (id){
            case 982:
                return jela.get(0);
            case 154:
                return jela.get(1);
            case 91:
                return jela.get(2);
            case 745:
                return jela.get(3);
            case 339:
                return jela.get(4);
            case 198:
                return jela.get(5);
            case 256:
                return jela.get(6);
            case 44:
                return jela.get(7);
            case 151:
                return jela.get(8);
            case 654:
                return jela.get(9);
            default:
                return null;
        }
    }

    public List<Jelo> getJela() {
        return jela;
    }

    public List<Kategorija> getKategorije() {
        return kategorije;
    }
}
