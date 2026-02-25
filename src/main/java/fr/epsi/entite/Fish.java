package fr.epsi.entite;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.util.Date;
@Entity
public class Fish extends  Animal {
    @Enumerated(EnumType.STRING)
    private FishLivEnv fishLivEnv;

    public Fish() {
        super();
    }

    public Fish(Date birth, String couleur, FishLivEnv livingEnv) {
        super(birth, couleur); // Appelle le constructeur d'Animal
        this.fishLivEnv = livingEnv;
    }

    public FishLivEnv getFishLivEnv() {
        return fishLivEnv;
    }

    public void setFishLivEnv(FishLivEnv fishLivEnv) {
        this.fishLivEnv = fishLivEnv;
    }
}
