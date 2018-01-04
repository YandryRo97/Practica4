/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import modelo.Equipo;
import modelo.Estadio;
import modelo.Grupo;
import modelo.Jugador;
import modelo.Pais;
import modelo.Torneo;

/**
 *
 * @author USUARIO
 */
public class GestionDato 
{
    
    
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("Practica4PU");
    
   
    public boolean persistirEquipo(Equipo e) throws Exception{
        boolean retorno=false;
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(e);
        em.getTransaction().commit();
        em.close();
        retorno=true;
        return retorno;
    }
     
    public List<Equipo> leerEquipo() {
        
        List<Equipo> retorno=null;        
        EntityManager em = emf.createEntityManager();
        retorno=em.createQuery("SELECT e FROM Equipo e ORDER BY e.id").getResultList(); 
        em.close();
        return retorno;
    }
     
   
///////////////////////////////////////////////////////////////////
    
    
    public boolean persistirPais(Pais p)throws Exception {
        boolean retorno=false;
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(p);
        em.getTransaction().commit();
        em.close();
        retorno=true;
        return retorno;
    }
     
    public List<Pais> leerPais() {
        List<Pais> retorno=null;        
        EntityManager em = emf.createEntityManager();
        retorno=em.createQuery("SELECT p FROM Pais p ORDER BY p.id").getResultList();        
        em.close();
        return retorno;
    }
     
     
    

  
    ////////////////////////////////////////////////////////////////////////////
    
     public boolean persistirGrupo(Grupo g) throws Exception {
        boolean retorno=false;
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(g);
        em.getTransaction().commit();
        em.close();
        retorno=true;
        return retorno;
    }
     
    public List<Grupo> leerGrupo() {
        List<Grupo> retorno=null;        
        EntityManager em = emf.createEntityManager();
        retorno=em.createQuery("SELECT g FROM Grupo g ORDER BY g.id").getResultList();        
        em.close();
        return retorno;
    }
     
     
    
    ////////////////////////////////////////////////////////////////////////////////
    
     public boolean persistirJugador(Jugador j) throws Exception {
        boolean retorno=false;
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(j);
        em.getTransaction().commit();
        em.close();
        retorno=true;
        return retorno;
    }
     
    public List<Jugador> leerJugador() {
        List<Jugador> retorno=null;        
        EntityManager em = emf.createEntityManager();
        retorno=em.createQuery("SELECT j FROM Jugador j ORDER BY j.id").getResultList();        
        em.close();
        return retorno;
    }
     
     
    
    ////////////////////////////////////////////////////////////////////////////
    
    public boolean persistirEstadio(Estadio est) throws Exception{
        boolean retorno=false;
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(est);
        em.getTransaction().commit();
        em.close();
        retorno=true;
        return retorno;
    }
     
    public List<Estadio> leerEstadio() {
        List<Estadio> retorno=null;        
        EntityManager em = emf.createEntityManager();
        retorno=em.createQuery("SELECT est FROM Estadio est ORDER BY est.id").getResultList();        
        em.close();
        return retorno;
    }
     
     
   
    
    ///////////////////////////////////////////////////////////////////////////
    
    public boolean persistirTorneo(Torneo t) throws Exception{
        boolean retorno=false;
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(t);
        em.getTransaction().commit();
        em.close();
        return retorno;
    }
     
    public List<Torneo> leerTorneo() {
        List<Torneo> retorno=null;        
        EntityManager em = emf.createEntityManager();
        retorno=em.createQuery("SELECT t FROM Torneo t ORDER BY t.id").getResultList();        
        em.close();
        return retorno;
    }
     
   
}
