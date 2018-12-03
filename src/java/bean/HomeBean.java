package bean;

import java.io.Serializable;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ManagedBean;
import model.Eleitor;

@ManagedBean
@SessionScoped
public class HomeBean implements Serializable {
    
    private static Eleitor eleitor = new Eleitor();

    private boolean candidatosPane = true;
    private boolean votarPane = false;
    private boolean apuracaoPane = false;
    private boolean blockApuracao = false;
    private boolean blockVotar = false;

    public HomeBean() {
    }

    public void turnOnCandidatosPane() {
        candidatosPane = true;
        votarPane = false;
        apuracaoPane = false;
        blockApuracao = false;
        blockVotar = false;
    }

    public void turnOnVotarPane() {
        if(eleitor.getStep() < 3){
            candidatosPane = false;
            votarPane = true;
            apuracaoPane = false;
            blockApuracao = false;
            blockVotar = false;
        }else{
            candidatosPane = false;
            votarPane = false;
            apuracaoPane = false;
            blockApuracao = false;
            blockVotar = true;
        }
    }

    public void turnOnApuracaoPane() {
        if (eleitor.getStep() < 3) {
            candidatosPane = false;
            votarPane = false;
            apuracaoPane = false;
            blockApuracao = true;
            blockVotar = false;
        } else {
            candidatosPane = false;
            votarPane = false;
            apuracaoPane = true;
            blockApuracao = false;
            blockVotar = false;
        }
    }

    public boolean isVotarPane() {
        return votarPane;
    }

    public void setVotarPane(boolean votarPane) {
        this.votarPane = votarPane;
    }

    public boolean isApuracaoPane() {
        return apuracaoPane;
    }

    public void setApuracaoPane(boolean apuracaoPane) {
        this.apuracaoPane = apuracaoPane;
    }

    public boolean isCandidatosPane() {
        return candidatosPane;
    }

    public void setCandidatosPane(boolean candidatosPane) {
        this.candidatosPane = candidatosPane;
    }

    public boolean isBlockApuracao() {
        return blockApuracao;
    }

    public void setBlockApuracao(boolean blockApuracao) {
        this.blockApuracao = blockApuracao;
    }

    public boolean isBlockVotar() {
        return blockVotar;
    }

    public void setBlockVotar(boolean blockVotar) {
        this.blockVotar = blockVotar;
    }

    public static Eleitor getEleitor() {
        return eleitor;
    }

    public static void setEleitor(Eleitor eleitor) {
        HomeBean.eleitor = eleitor;
    }

}
