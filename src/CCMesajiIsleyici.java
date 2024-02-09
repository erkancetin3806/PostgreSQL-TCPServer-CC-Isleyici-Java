import java.util.Date;

public class CCMesajiIsleyici {

    public void isle(String mesaj) {

        System.out.println("ERK -> CCMesajiIsleyici isle-> Mesaj:\" + mesaj + \" CC mesajina uygundur.");

        String[] mesajParametreDizisi = mesaj.split(";");

        Integer pilSeviyesi = pilSeviyesiAyristir(mesajParametreDizisi, 6);
        /* Double enlem = enlemAyristir(mesajParametreDizisi, 8);
        Double boylam = boylamAyristir(mesajParametreDizisi, 9);
        String simKartIMSINumarasi = simKartIMSINumarasiAyristir(mesajParametreDizisi, 11);
        String gsmNo = gsmNoAyristir(mesajParametreDizisi, 13); */
    }

    private Integer pilSeviyesiAyristir(String[] mesajParametreDizisi, int indis) {
        Integer pilSeviyesi = null;

        try {
            pilSeviyesi = Integer.parseInt(mesajParametreDizisi[indis]);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("ERKAN -> CCMesajiIsleyici isle-> pilSeviyesi:" + pilSeviyesi);
        return pilSeviyesi;
    }
}

/*
    private String gsmNoAyristir(String[] mesajParametreDizisi, int indis) {
        String gsmNo = null;
        try {
            gsmNo = mesajParametreDizisi[indis];
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("SDT CCMesajiIsleyici isle-> gsmNo:" + gsmNo);
        return gsmNo;
    }

    private String simKartIMSINumarasiAyristir(String[] mesajParametreDizisi, int indis) {
        String simKartIMSINumarasi = null;
        try {
            simKartIMSINumarasi = mesajParametreDizisi[indis].replaceAll("\u0000", "");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("SDT CCMesajiIsleyici isle-> simKartIMSINumarasi:" + simKartIMSINumarasi);
        return simKartIMSINumarasi;
    }

    private Double boylamAyristir(String[] mesajParametreDizisi, int indis) {
        Double boylam = null;

        try {
            boylam = Double.parseDouble(mesajParametreDizisi[indis].replace(",", "."));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("SDT CCMesajiIsleyici isle-> boylam:" + boylam);
        return boylam;
    }

    private Double enlemAyristir(String[] mesajParametreDizisi, int indis) {
        Double enlem = null;

        try {
            enlem = Double.parseDouble(mesajParametreDizisi[indis].replace(",", "."));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("SDT CCMesajiIsleyici isle-> enlem:" + enlem);
        return enlem;
    }
} */