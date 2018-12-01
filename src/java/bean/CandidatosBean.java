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
public class CandidatosBean implements Serializable {
    
    CandidatoService cs = new CandidatoService();

    private List<Candidato> listaPresidentes;
    private List<Candidato> listaGovernadores;
    private List<Candidato> listaPrefeitos;

    public CandidatosBean() {
        loadListaPresidentes();
        loadListaGovernadores();
        loadListaPrefeitos();
    }

    public void loadListaPresidentes() {
        listaPresidentes = cs.buscarPresidentes();
    }

    public void loadListaGovernadores() {
        listaGovernadores = cs.buscarGovernadores();
    }

    public void loadListaPrefeitos() {
        listaPrefeitos = cs.buscarPrefeitos();
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
