package bean;

import java.io.Serializable;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ManagedBean;
import model.Candidato;
import model.Eleitor;
import model.EleitorVotos;
import model.EleitorVotosPK;
import model.Voto;
import model.VotoPK;
import negocio.CandidatoService;
import negocio.EleitorService;
import negocio.EleitorVotosService;
import negocio.VotoService;


@ManagedBean
@SessionScoped
public class VotarBean implements Serializable {
    
    private String image = "8471679.jpg";

    CandidatoService cs = new CandidatoService();
    EleitorService es = new EleitorService();
    VotoService vs = new VotoService();
    EleitorVotosService evs = new EleitorVotosService();

    Eleitor eleitor = HomeBean.getEleitor();
    private boolean urnaPane = true;

    private boolean btnConfirmar = true;
    private boolean btnVerificar = true;
    private boolean btnBranco = true;
    private boolean btnCorrigir = true;
    private boolean textFieldVoto = true;
    private boolean msgFinalizado = false;

    public static int step = 0;
    private Integer numVoto;

    private Candidato candidato = new Candidato();

    public VotarBean() {
        updateEleitor();
        step = eleitor.getStep();
        candidato.setImagem("Branco.png");
    }
    public void updateEleitor(){
        HomeBean.setEleitor(es.buscarEleitor(HomeBean.getEleitor().getTituloeleitor(), HomeBean.getEleitor().getSenha())); 
    }
    
    public void nextStep() {
        if (step < 2) {
            step++;
            System.out.println(step);
        } else {
            turnOffUrna();
            msgFinalizado = true;
            step++;
        }
    }

    public void verificar() {
        //System.out.println(cargo());
        //candidato.setNome(cs.buscarCandidatoByNum(cargo(), numVoto).getNome());
        //candidato.setVice(cs.buscarCandidatoByNum(cargo(), numVoto).getVice());
        //candidato.setPartido(cs.buscarCandidatoByNum(cargo(), numVoto).getPartido());
        //candidato.setSlogan(cs.buscarCandidatoByNum(cargo(), numVoto).getSlogan());

        //Filtro Cargo por Numero
        VotoPK vpk = new VotoPK();
        vpk.setIdcargo(cargo());
        vpk.setNumcandidato(numVoto);
        Voto v = new Voto();
        v.setVotoPK(vpk);

        if (vs.filtrarCandidato(v)) {

            //Depois de filtrado
            Candidato c = new Candidato();
            c.setNumcandidato(v.getVotoPK().getNumcandidato());

            //cs.buscarCandidatoPorNum(numVoto);

            candidato.setNome(cs.buscarCandidatoPorNum(numVoto).getNome());
            candidato.setVice(cs.buscarCandidatoPorNum(numVoto).getVice());
            candidato.setPartido(cs.buscarCandidatoPorNum(numVoto).getPartido());
            candidato.setSlogan(cs.buscarCandidatoPorNum(numVoto).getSlogan());
            candidato.setImagem(cs.buscarCandidatoPorNum(numVoto).getImagem());
        }
        else{
            System.out.println("Não existe este numero para este cargo!");
        }
    }

    public void confirmar() {
        //Candidato candidatoEscolhido = cs.buscarCandidatoByNum(cargo(), numVoto);
        //candidatoEscolhido.setVotos(candidatoEscolhido.getVotos() + 1);
        //es.registrarVoto(eleitor.getTituloeleitor(), cargo(), numVoto);
        //cs.computarVoto(candidatoEscolhido);
        //corrigir();
        //nextStep();

        //Filtro Cargo por Numero
        VotoPK vpk = new VotoPK();
        vpk.setIdcargo(cargo());
        vpk.setNumcandidato(numVoto);
        Voto v = new Voto();
        v.setVotoPK(vpk);

        if (vs.filtrarCandidato(v)) {

            //Depois de filtrado
            Candidato c = new Candidato();
            c.setNumcandidato(v.getVotoPK().getNumcandidato());

            cs.computarVoto(c);

            //Registrar Voto
            EleitorVotos ev = new EleitorVotos();
            EleitorVotosPK evpk = new EleitorVotosPK();
            evpk.setIdcargos(v.getVotoPK().getIdcargo());
            evpk.setTituloeleitor(eleitor.getTituloeleitor());
            ev.setNumcandidato(evpk.getTituloeleitor());
            ev.setNumcandidato(c.getNumcandidato());
            ev.setEleitorVotosPK(evpk);

            if (evs.registrarVoto(ev)) {
                System.out.println("Voto Registrado com sucesso!");
            } else {
                System.out.println("Você já votou!");
            }
            
            es.updateEleitor(eleitor);
            corrigir();
            nextStep();
            updateEleitor();

        }else{
            System.out.println("Voto Invalido!");
        }

    }

    public void corrigir() {
        numVoto = null;
        candidato.setNome(null);
        candidato.setVice(null);
        candidato.setPartido(null);
        candidato.setSlogan(null);
        candidato.setImagem("Branco.png");
    }

    public void branco() {
            Integer votoBranco = 0;
            if(null != cargo())switch (cargo()) {
            case 1:
                votoBranco = 99;
                break;
            case 2:
                votoBranco = 98;
                break;
            case 3:
                votoBranco = 97;
                break;
            default:
                break;
        }
            
            //Depois de filtrado
            Candidato c = new Candidato();
            c.setNumcandidato(votoBranco);

            cs.buscarCandidatoPorNum(votoBranco);

            candidato.setNome(cs.buscarCandidatoPorNum(votoBranco).getNome());
            candidato.setVice(cs.buscarCandidatoPorNum(votoBranco).getVice());
            candidato.setPartido(cs.buscarCandidatoPorNum(votoBranco).getPartido());
            candidato.setSlogan(cs.buscarCandidatoPorNum(votoBranco).getSlogan());
            candidato.setImagem(cs.buscarCandidatoPorNum(votoBranco).getImagem());
            
            es.updateEleitor(eleitor);
            corrigir();
            nextStep();
            updateEleitor();

    }

    public Integer cargo() {
        switch (step) {
            case 0:
                return 3;
            case 1:
                return 2;
            case 2:
                return 1;
            default:
                break;
        }
        return 0;
    }
public void turnOffUrna() {
        urnaPane = false;
        btnConfirmar = false;
        btnVerificar = false;
        btnBranco = false;
        btnCorrigir = false;
        textFieldVoto = false;
    }

    public Integer getNumVoto() {
        return numVoto;
    }

    public void setNumVoto(Integer numVoto) {
        this.numVoto = numVoto;
    }

    public Candidato getCandidato() {
        return candidato;
    }

    public void setCandidato(Candidato candidato) {
        this.candidato = candidato;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }

    public EleitorService getEs() {
        return es;
    }

    public void setEs(EleitorService es) {
        this.es = es;
    }

    public Eleitor getEleitor() {
        return eleitor;
    }

    public void setEleitor(Eleitor eleitor) {
        this.eleitor = eleitor;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isUrnaPane() {
        return urnaPane;
    }

    public void setUrnaPane(boolean urnaPane) {
        this.urnaPane = urnaPane;
    }

    public boolean isBtnConfirmar() {
        return btnConfirmar;
    }

    public void setBtnConfirmar(boolean btnConfirmar) {
        this.btnConfirmar = btnConfirmar;
    }

    public boolean isBtnVerificar() {
        return btnVerificar;
    }

    public void setBtnVerificar(boolean btnVerificar) {
        this.btnVerificar = btnVerificar;
    }

    public boolean isBtnBranco() {
        return btnBranco;
    }

    public void setBtnBranco(boolean btnBranco) {
        this.btnBranco = btnBranco;
    }

    public boolean isBtnCorrigir() {
        return btnCorrigir;
    }

    public void setBtnCorrigir(boolean btnCorrigir) {
        this.btnCorrigir = btnCorrigir;
    }

    public boolean isTextFieldVoto() {
        return textFieldVoto;
    }

    public void setTextFieldVoto(boolean textFieldVoto) {
        this.textFieldVoto = textFieldVoto;
    }

    public boolean isMsgFinalizado() {
        return msgFinalizado;
    }

    public void setMsgFinalizado(boolean msgFinalizado) {
        this.msgFinalizado = msgFinalizado;
    }

   

}
