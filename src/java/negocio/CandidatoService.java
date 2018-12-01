
package negocio;


import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import model.Candidato;
import model.VotoPK;


public class CandidatoService{
    
    EntityManager em = Persistence.createEntityManagerFactory("ProfessorJpaPU").createEntityManager();
    
   
    public List<Candidato> buscarPresidentes(){
        
        em.getEntityManagerFactory().getCache().evictAll();
        em.clear();
        Query consulta = em.createQuery("Select c from Candidato c, Voto v, Cargo ca where c.numcandidato = v.votoPK.numcandidato and v.votoPK.idcargo = ca.idcargo and ca.idcargo=1 ");
        
       
        
        List<Candidato> presidentes = consulta.getResultList();
        
        return presidentes;
    }
    
    public List<Candidato> buscarGovernadores(){
        
        em.getEntityManagerFactory().getCache().evictAll();
        em.clear();
        
        Query consulta = em.createQuery("Select c from Candidato c, Voto v, Cargo ca where c.numcandidato = v.votoPK.numcandidato and v.votoPK.idcargo = ca.idcargo and ca.idcargo=2 ");
        List<Candidato> governadores = consulta.getResultList();
        
        return governadores;
    }
    
    public List<Candidato> buscarPrefeitos(){
        
        em.getEntityManagerFactory().getCache().evictAll();
        em.clear();
        
        Query consulta = em.createQuery("Select c from Candidato c, Voto v, Cargo ca where c.numcandidato = v.votoPK.numcandidato and v.votoPK.idcargo = ca.idcargo and ca.idcargo=3");
        List<Candidato> prefeitos = consulta.getResultList();
        
        return prefeitos;
    }
    public List<Candidato> buscarPresidentesByVote(){
        
        em.getEntityManagerFactory().getCache().evictAll();
        em.clear();
        
        Query consulta = em.createQuery("Select c from Candidato c, Voto v, Cargo ca where c.numcandidato = v.votoPK.numcandidato and v.votoPK.idcargo = ca.idcargo and ca.idcargo=1 order by c.votos desc");
        List<Candidato> presidentes = consulta.getResultList();
        
        return presidentes;
    }
    public List<Candidato> buscarGovernadoresByVote(){
        
        em.getEntityManagerFactory().getCache().evictAll();
        em.clear();
        
        Query consulta = em.createQuery("Select c from Candidato c, Voto v, Cargo ca where c.numcandidato = v.votoPK.numcandidato and v.votoPK.idcargo = ca.idcargo and ca.idcargo=2 order by c.votos desc");
        List<Candidato> governadores = consulta.getResultList();
        
        return governadores;
    }
    public List<Candidato> buscarPrefeitosByVote(){
        
        em.getEntityManagerFactory().getCache().evictAll();
        em.clear();
        
        Query consulta = em.createQuery("Select c from Candidato c, Voto v, Cargo ca where c.numcandidato = v.votoPK.numcandidato and v.votoPK.idcargo = ca.idcargo and ca.idcargo=3 order by c.votos desc");
        List<Candidato> prefeitos = consulta.getResultList();
        
        return prefeitos;
    }  
    public Candidato buscarCandidatoByNum(int idCargo, int num){
        em.getEntityManagerFactory().getCache().evictAll();
        em.clear();
        
        
        Query consulta = em.createQuery("Select c from Candidato c, Voto v, Cargo ca where c.numcandidato = v.votoPK.numcandidato and v.votoPK.idcargo = ca.idcargo and v.votoPK.idcargo="+idCargo+" and v.votoPK.numcandidato="+num);
        Candidato candidato = (Candidato) consulta.getSingleResult();
        //Candidato candidato = (Candidato) em.find(Candidato.class, num);
        return candidato;
    }
    public Candidato buscarCandidatoPorNum(int num){
        em.getEntityManagerFactory().getCache().evictAll();
        em.clear();
        
        Query consulta = em.createQuery("Select c from Candidato c where c.numcandidato = :numero");
        consulta.setParameter("numero", num);
        Candidato candidato = (Candidato) consulta.getSingleResult();

        return candidato;
    }
    
    public void computarVoto(Candidato candidatoEscolhido){
        candidatoEscolhido = buscarCandidatoPorNum(candidatoEscolhido.getNumcandidato());
        candidatoEscolhido.setVotos(candidatoEscolhido.getVotos() + 1);
        
        em.getTransaction().begin();
        em.merge(candidatoEscolhido);
        em.getTransaction().commit();
    }
}
