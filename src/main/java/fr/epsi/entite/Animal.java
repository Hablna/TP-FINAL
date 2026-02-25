package fr.epsi.entite;

import jakarta.persistence.*;

import java.util.Date;

@Entity
//La stratégie d'heritagee
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date birth;
    private String couleur;

    @ManyToOne
    @JoinColumn(name = "id_petstore_animal")
    private PetStore petStore;

    public Animal() {}
    public Animal(Date birth, String couleur) {
        this.birth = birth;
        this.couleur = couleur;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public PetStore getPetStore() {
        return petStore;
    }

    public void setPetStore(PetStore petstore) {
        this.petStore = petstore;
    }
}
