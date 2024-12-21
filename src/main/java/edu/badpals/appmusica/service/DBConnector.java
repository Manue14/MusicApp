package edu.badpals.appmusica.service;

import edu.badpals.appmusica.entities.Test;
import jakarta.persistence.*;
import org.hibernate.HibernateException;

public class DBConnector {
    private EntityManagerFactory emf;
    private EntityManager em;

    public DBConnector() throws HibernateException {
        this.emf = Persistence.createEntityManagerFactory("default");
        this.em = emf.createEntityManager();
    }

    public void insertTest(Test test) {
        try {
            this.em.getTransaction().begin();
            if (test == null) {
                throw new IllegalArgumentException("Test cannot be null");
            }
            this.em.persist(test);
            this.em.getTransaction().commit();
            System.out.println("Test added successfully");
        } catch (EntityExistsException e) {
            this.em.getTransaction().rollback();
            System.out.println("Test already exists");
        } catch (IllegalArgumentException e) {
            this.em.getTransaction().rollback();
            System.out.println("El objeto que intentas persistir no es válido");
        } catch (PersistenceException e) {
            this.em.getTransaction().rollback();
            System.out.println("Error de persistencia: " + e.getMessage());
        } catch (Exception e) {
            this.em.getTransaction().rollback();
            System.out.println(e.getMessage());
        }
    }

    public Test getTest(Integer id) {
        try {
            if (id == null) {
                throw new IllegalArgumentException("El id no puede ser nulo");
            }
            Test test = this.em.find(Test.class, id);
            return test;
        } catch (IllegalArgumentException e) {
            System.out.println("Error de argumento: " + e.getMessage());
        } catch (NonUniqueResultException e) {
            System.out.println("Se obtuvieron más resultados de los esperados");
        } catch (NoResultException e) {
            System.out.println("El test con id: " + id + " no existe");
        } catch (HibernateException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
