package pl.pp;

public class Konto {

    private String nazwaWlasciciela;
    private String nrKonta;
    private double dnSrodki;
    private String email;
    private String nrTelefonu;

    public Konto() {
    }

    public Konto(String nazwaWlasciciela, String nrKonta, double dnSrodki, String email, String nrTelefonu) {
        this.nazwaWlasciciela = nazwaWlasciciela;
        this.nrKonta = nrKonta;
        this.dnSrodki = dnSrodki;
        this.email = email;
        this.nrTelefonu = nrTelefonu;
    }

    public double doladowanie(double dnSrodki){
        this.dnSrodki += dnSrodki;
        return dnSrodki;

    }

    public double pobieranie(double dnSrodki) {
        if (this.dnSrodki - dnSrodki < 0) {
            System.out.println("Operacja nie powiodla sie: niewystarczajace srodki.");
            return 0;
        }
        this.dnSrodki -= dnSrodki;
        return dnSrodki;
    }

    public void ileZlotych(){
        System.out.println("teraz na koncie jest: " + dnSrodki);
    }

    public String getNazwaWlasciciela() {
        return nazwaWlasciciela;
    }

    public void setNazwaWlasciciela(String nazwaWlasciciela) {
        this.nazwaWlasciciela = nazwaWlasciciela;
    }

    public double getDnSrodki() {
        return dnSrodki;
    }

    public void setDnSrodki(double dnSrodki) {
        this.dnSrodki = dnSrodki;
    }

    public String getNrKonta() {
        return nrKonta;
    }

    public void setNrKonta(String nrKonta) {
        this.nrKonta = nrKonta;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNrTelefonu() {
        return nrTelefonu;
    }

    public void setNrTelefonu(String nrTelefonu) {
        this.nrTelefonu = nrTelefonu;
    }
}
