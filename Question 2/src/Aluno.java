package prova03112021POO.q2.src;

import java.util.ArrayList;

public class Aluno extends Object
{
    private String nome;
    private String dataNasc;
    private String cpf;
    protected ArrayList<Disciplina> listaDiscAtiva = new ArrayList<>();
    protected ArrayList<Nota> listaNotasDiscAtiva = new ArrayList<>();
    protected ArrayList<Disciplina> listaDiscConc = new ArrayList<>();
    protected ArrayList<Nota> listaNotasDiscConc = new ArrayList<>();
    protected ArrayList<Horario> quadroHorarios = new ArrayList<>();
    
    @Override
    public String toString()
    {
    	return this.nome;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getDataNasc() {
        return dataNasc;
    }
    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }
    public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public ArrayList<Disciplina> getListaDiscAtiva() {
        return listaDiscAtiva;
    }
    public void setListaNotasDiscAtiva(Nota e) {
        this.listaNotasDiscAtiva.add(e);
    }
    public ArrayList<Disciplina> getListaDiscConc() {
        return listaDiscConc;
    }
    public void setListaDiscConc(Disciplina e) {
        this.listaDiscConc.add(e);
    }
    public ArrayList<Horario> getQuadroHorarios() {
        return quadroHorarios;
    }
    public void setQuadroHorarios(Horario e) {
        this.quadroHorarios.add(e);
    }
	public ArrayList<Nota> getListaNotasDiscAtiva() {
		return listaNotasDiscAtiva;
	}
	public ArrayList<Nota> getListaNotasDiscConc() {
		return listaNotasDiscConc;
	}
	public void setListaNotasDiscConc(Nota e) {
		this.listaNotasDiscConc.add(e);
	}
	public void setListaDiscAtiva(Disciplina e) {
		this.listaDiscAtiva.add(e);
	}
	
}

