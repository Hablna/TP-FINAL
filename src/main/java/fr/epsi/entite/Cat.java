package fr.epsi.entite;

import jakarta.persistence.Entity;

import java.util.Date;

@Entity
public class Cat extends Animal {
    private String chipId;

    public Cat() {
        //A cause de l'heritage, pareil que Fish
        super();
    }

    public Cat(Date birth, String couleur, String chipId) {
        super(birth, couleur);
        this.chipId = chipId;
    }

    public String getChipId() {
        return chipId;
    }

    public void setChipId(String chipId) {
        this.chipId = chipId;
    }
}
