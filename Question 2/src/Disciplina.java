package prova03112021POO.q2.src;

import java.util.ArrayList;

public class Disciplina extends Object
{
    private String codigo;
    private String sigla;
    private String nome;
    public ArrayList<Aluno> listaAlunos = new ArrayList<>();
	private ArrayList<Aula> listaAulasSem = new ArrayList<>();
    private Professor professor;
    private String periodo;
    private boolean status;
    
    public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public ArrayList<Aluno> getListaAlunos() {
    	return this.listaAlunos;
    }
    public void setListaAlunos(Aluno a) {
    	this.listaAlunos.add(a);
    }
    @Override
    public String toString()
    {
    	return this.nome;
    }
    public String getCodigo() 
    {
        return codigo;
    }

    public void setCodigo(String codigo) 
    {
        this.codigo = codigo;
    }

    public String getSigla() 
    {
        return sigla;
    }

    public void setSigla(String sigla) 
    {
        this.sigla = sigla;
    }

    public String getNome() 
    {
        return nome;
    }

    public void setNome(String nome) 
    {
        this.nome = nome;
    }

    public ArrayList<Aula> getListaAulasSem() 
    {
        return listaAulasSem;
    }

    public void setListaAulasSem(Aula e) 
    {
        this.listaAulasSem.add(e);
    }

    public Professor getProfessor() 
    {
        return professor;
    }

    public void setProfessor(Professor professor) 
    {
        this.professor = professor;
    }

    public String getPeriodo() 
    {
        return periodo;
    }

    public void setPeriodo(String periodo) 
    {
        this.periodo = periodo;
    }
}