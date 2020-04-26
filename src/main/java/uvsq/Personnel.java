package uvsq;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;

public final class Personnel implements Groupe, Serializable {

    private final String nom;
    private final String prenom;
    private final String fonction;
    private final LocalDate naissance;
    private final List<String> numerotel;

    public static class Builder {

        private final String nom;
        private final String prenom;
        private final String fonction;
        private LocalDate naissance = LocalDate.now();
        private List<String> numerotel = new ArrayList<>();

        public Builder ( String nom, String prenom, String fonction){
            this.nom = nom;
            this.prenom = prenom;
            this.fonction = fonction;
        }

        public Builder addphone(String tel){
            this.numerotel.add(tel);
            return this;
        }

        public Builder naissance(LocalDate time ){
            this.naissance = time;
            return this;
        }

        public Personnel build(){
            return new Personnel(this);
        }
    }

    private Personnel(Builder build){
        this.nom = build.nom;
        this.prenom = build.prenom;
        this.naissance = build.naissance;
        this.fonction = build.fonction;
        this.numerotel = build.numerotel;
    }

    @Override
    public void print(){
        System.out.println(this.nom + " " + this.prenom + " " + this.fonction);
    }

    public String getFonction() {
        return fonction;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public LocalDate getNaissance() {
        return naissance;
    }

    public List<String> getNumerotel() {
        return numerotel;
    }
}
