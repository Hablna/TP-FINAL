package fr.epsi;

import fr.epsi.entite.*;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.Date;
import java.util.List;

public class TestPetStore {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("petstore");
        var em = emf.createEntityManager();
        try {
            // --- 1. Création d'Adresses ---
            Address addr1 = new Address("10", "Rue des Chats", "75001", "Paris");
            Address addr2 = new Address("5", "Avenue des Poissons", "44000", "Nantes");
            Address addr3 = new Address("22", "Boulevard Médor", "69000", "Lyon");
            em.persist(addr1); em.persist(addr2); em.persist(addr3);

            /** --- 2. Création de PetStores ---
            PetStore ps1 = new PetStore("Le Palais des Chats", "Jean Dupont", addr1);
            PetStore ps2 = new PetStore("Aquarium Géant", "Alice Martin", addr2);
            PetStore ps3 = new PetStore("L'Arche de Noé", "Bob Smith", addr3);
            em.persist(ps1); em.persist(ps2); em.persist(ps3);

            // --- 3. Création de Produits (avec Enum ProdType) ---
            Product p1 = new Product("P001", "Croquettes Bio", 25.50, ProdType.FOOD);
            Product p2 = new Product("P002", "Litière Parfumée", 12.00, ProdType.CLEANING);
            Product p3 = new Product("P003", "Arbre à chat", 45.00, ProdType.ACCESSORY);

            // Association ManyToMany
            ps1.getProducts().add(p1); ps1.getProducts().add(p2);
            em.persist(p1); em.persist(p2); em.persist(p3);

            // --- 4. Création d'Animaux (Héritage JOINED) ---
            Cat cat1 = new Cat(new Date(), "Noir", "CHIP-123");
            Cat cat2 = new Cat(new Date(), "Roux", "CHIP-456");
            Fish fish1 = new Fish(new Date(), "Bleu", FishLivEnv.SEA_WATER);

            em.persist(cat1); em.persist(cat2); em.persist(fish1);

            em.getTransaction().commit();

            // --- 5. Requête demandée ---
            System.out.println("--- Liste des animaux de " + ps1.getName() + " ---");
            List<Animal> animals = em.createQuery(
                            "SELECT a FROM Animal a WHERE a.petStore.id = :id", Animal.class)
                    .setParameter("id", ps1.getId())
                    .getResultList();

            for (Animal a : animals) {
                System.out.println("Animal: " + a.getCouleur() + " (Type: " + a.getClass().getSimpleName() + ")");
            }**/
        } catch (Exception ex) {
            System.out.println("Erreur : " + ex.getMessage());
        }
    }
}
