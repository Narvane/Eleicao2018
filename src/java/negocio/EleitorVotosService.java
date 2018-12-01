package negocio;


import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import model.Candidato;
import model.EleitorVotos;
import model.VotoPK;


public class EleitorVotosService{
    
    EntityManager em = Persistence.createEntityManagerFactory("ProfessorJpaPU").createEntityManager();
    
    
    public Boolean registrarVoto(EleitorVotos ev){
        try{
            em.getTransaction().begin();
            em.persist(ev);
            em.getTransaction().commit();
            return true;
        }catch(Exception e){
            return false;
        }
    }
}
