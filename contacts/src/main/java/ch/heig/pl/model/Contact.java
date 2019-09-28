package ch.heig.pl.model;

public class Contact {
    private String nom;
    private int telephone;

    public Contact(String nom, int telephone) {
        this.nom = nom;
        this.telephone = telephone;
    }

    public String getNom() {
        return nom;
    }

    public int getTelephone() {
        return telephone;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "nom='" + nom + '\'' +
                ", telephone=" + telephone +
                '}';
    }
}
