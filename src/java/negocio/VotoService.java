package negocio;


import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import model.Voto;


public class VotoService{
    
    EntityManager em = Persistence.createEntityManagerFactory("ProfessorJpaPU").createEntityManager();
    
    public boolean filtrarCandidato(Voto v){
        em.getEntityManagerFactory().getCache().evictAll();
        em.clear();
        Query consulta = em.createQuery("Select v from Voto v where v.votoPK.idcargo = :cargo and v.votoPK.numcandidato = :numero");
        consulta.setParameter("cargo", v.getVotoPK().getIdcargo());
        consulta.setParameter("numero", v.getVotoPK().getNumcandidato());
        Voto vt = null;
        try{
            vt = (Voto) consulta.getSingleResult();
        }catch(NoResultException e){
            v = null;
        }
        return (vt != null);
    }
}