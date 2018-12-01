package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;


@Entity
@Table(name = "ELEITOR_VOTOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EleitorVotos.findAll", query = "SELECT e FROM EleitorVotos e")
    , @NamedQuery(name = "EleitorVotos.findByTituloeleitor", query = "SELECT e FROM EleitorVotos e WHERE e.eleitorVotosPK.tituloeleitor = :tituloeleitor")
    , @NamedQuery(name = "EleitorVotos.findByIdcargos", query = "SELECT e FROM EleitorVotos e WHERE e.eleitorVotosPK.idcargos = :idcargos")
    , @NamedQuery(name = "EleitorVotos.findByNumcandidato", query = "SELECT e FROM EleitorVotos e WHERE e.numcandidato = :numcandidato")})
public class EleitorVotos implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EleitorVotosPK eleitorVotosPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "NUMCANDIDATO")
    private int numcandidato;

    public EleitorVotos() {
    }

    public EleitorVotos(EleitorVotosPK eleitorVotosPK) {
        this.eleitorVotosPK = eleitorVotosPK;
    }

    public EleitorVotos(EleitorVotosPK eleitorVotosPK, int numcandidato) {
        this.eleitorVotosPK = eleitorVotosPK;
        this.numcandidato = numcandidato;
    }

    public EleitorVotos(int tituloeleitor, int idcargos) {
        this.eleitorVotosPK = new EleitorVotosPK(tituloeleitor, idcargos);
    }

    public EleitorVotosPK getEleitorVotosPK() {
        return eleitorVotosPK;
    }

    public void setEleitorVotosPK(EleitorVotosPK eleitorVotosPK) {
        this.eleitorVotosPK = eleitorVotosPK;
    }

    public int getNumcandidato() {
        return numcandidato;
    }

    public void setNumcandidato(int numcandidato) {
        this.numcandidato = numcandidato;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (eleitorVotosPK != null ? eleitorVotosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EleitorVotos)) {
            return false;
        }
        EleitorVotos other = (EleitorVotos) object;
        if ((this.eleitorVotosPK == null && other.eleitorVotosPK != null) || (this.eleitorVotosPK != null && !this.eleitorVotosPK.equals(other.eleitorVotosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.EleitorVotos[ eleitorVotosPK=" + eleitorVotosPK + " ]";
    }

}
