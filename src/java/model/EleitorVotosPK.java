package model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;


@Embeddable
public class EleitorVotosPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "TITULOELEITOR")
    private int tituloeleitor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "IDCARGOS")
    private int idcargos;

    public EleitorVotosPK() {
    }

    public EleitorVotosPK(int tituloeleitor, int idcargos) {
        this.tituloeleitor = tituloeleitor;
        this.idcargos = idcargos;
    }

    public int getTituloeleitor() {
        return tituloeleitor;
    }

    public void setTituloeleitor(int tituloeleitor) {
        this.tituloeleitor = tituloeleitor;
    }

    public int getIdcargos() {
        return idcargos;
    }

    public void setIdcargos(int idcargos) {
        this.idcargos = idcargos;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) tituloeleitor;
        hash += (int) idcargos;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EleitorVotosPK)) {
            return false;
        }
        EleitorVotosPK other = (EleitorVotosPK) object;
        if (this.tituloeleitor != other.tituloeleitor) {
            return false;
        }
        if (this.idcargos != other.idcargos) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "model.EleitorVotosPK[ tituloeleitor=" + tituloeleitor + ", idcargos=" + idcargos + " ]";
    }

}
