package bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ManagedBean;
import model.Candidato;
import negocio.CandidatoService;

@ManagedBean
@SessionScoped
public class ApuracaoBean implements Serializable {
    
    private CandidatoService cs = new CandidatoService();

    private List<Candidato> listaPresidentes = new ArrayList<>();
    private List<Candidato> listaGovernadores = new ArrayList<>();
    private List<Candidato> listaPrefeitos = new ArrayList<>();

    public ApuracaoBean() {
        loadListaPresidentes();
        loadListaGovernadores();
        loadListaPrefeitos();
    }
    public void atualizar(){
        loadListaPresidentes();
        loadListaGovernadores();
        loadListaPrefeitos(); 
    } 
    
    public void loadListaPresidentes() {
        listaPresidentes = cs.buscarPresidentesByVote();
    }

    public void loadListaGovernadores() {
        listaGovernadores = cs.buscarGovernadoresByVote();
    }

    public void loadListaPrefeitos() {
        listaPrefeitos = cs.buscarPrefeitosByVote();
    }

    public List<Candidato> getListaPresidentes() {
        return listaPresidentes;
    }

    public void setListaPresidentes(List<Candidato> listaPresidentes) {
        this.listaPresidentes = listaPresidentes;
    }

    public List<Candidato> getListaGovernadores() {
        return listaGovernadores;
    }

    public void setListaGovernadores(List<Candidato> listaGovernadores) {
        this.listaGovernadores = listaGovernadores;
    }

    public List<Candidato> getListaPrefeitos() {
        return listaPrefeitos;
    }

    public void setListaPrefeitos(List<Candidato> listaPrefeitos) {
        this.listaPrefeitos = listaPrefeitos;
    }

    
    
}
