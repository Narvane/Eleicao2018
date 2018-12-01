
package negocio;


import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.Query;
import model.Eleitor;
import model.EleitorVotos;
import model.EleitorVotosPK;


public class EleitorService{
    
    EntityManager em = Persistence.createEntityManagerFactory("ProfessorJpaPU").createEntityManager();
    
    public Eleitor buscarEleitor(int titulo, String senha){
        em.getEntityManagerFactory().getCache().evictAll();
        em.clear();
        
        Query consulta = em.createQuery("select e from Eleitor e where e.tituloeleitor="+titulo+" and e.senha='"+senha+"'");
        Eleitor eleitor = (Eleitor) consulta.getSingleResult();
        return eleitor;
    }
    public void registrarVoto(int titulo, int idcargo, int numCandidato){
        EleitorVotos reg = new EleitorVotos();
        reg.setNumcandidato(numCandidato);
        EleitorVotosPK registro = new EleitorVotosPK();
        reg.setEleitorVotosPK(registro);
        registro.setIdcargos(idcargo);
        registro.setTituloeleitor(titulo);
        
        em.getTransaction().begin();
        em.persist(reg);
        em.getTransaction().commit();
    }
    public void cadastrarEleitor(Eleitor e){
        em.getTransaction().begin();
        em.persist(e);
        em.getTransaction().commit();
    }
    public void updateEleitor(Eleitor e){
        e = buscarEleitor(e.getTituloeleitor(), e.getSenha());
        e.setStep(e.getStep()+1);
        
        em.getTransaction().begin();
        em.merge(e);
        em.getTransaction().commit();
    }
}
