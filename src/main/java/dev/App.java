package dev;

import entities.Film;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("imdb-pu");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        // Exemple : créer un film
        Film film = new Film();
        film.setId(1L);
        film.setTitre("Inception");
        film.setAnneeSortie(2010);
        film.setRating(8.8);
        film.setUrl("https://...");
        film.setResume("Un voleur d'idées...");

        em.persist(film);

        em.getTransaction().commit();
        em.close();
        emf.close();
    }
}
