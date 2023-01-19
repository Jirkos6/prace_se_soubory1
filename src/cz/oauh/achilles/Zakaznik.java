package cz.oauh.achilles;



public class Zakaznik {

    private String jmeno;
    private int pocetProdeju;

    public Zakaznik(String jmeno, int pocetProdeju) throws ZakaznikException {
        this.jmeno = jmeno;
        setPocetProdeju(pocetProdeju);
    }

    public String getJmeno() {
        return jmeno;
    }

    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }

    public int getPocetProdeju() {
        return pocetProdeju;
    }

    public void setPocetProdeju(int pocetProdeju) throws ZakaznikException {
        if (pocetProdeju <= 0) {
            throw new ZakaznikException("Nemůže být záporné číslo (" + pocetProdeju + ")!");
        }
        this.pocetProdeju = pocetProdeju;
    }

    }
