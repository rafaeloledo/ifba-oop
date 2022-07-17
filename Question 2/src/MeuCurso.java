package prova03112021POO.q2.src;

import java.util.ArrayList;

public class MeuCurso extends Curso
{

    @Override
    public String toString()
    {
    	return this.nome;
    }
	@Override
    public void setNome(String e) {
        this.nome= e;
    }

    @Override
    public String getNome() {
        return this.nome;
    }

    @Override
    public void setDisciplina(Disciplina e) {
        this.listaDisciplinas.add(e);
    }

    @Override
    public ArrayList<Disciplina> getListaDisc() {
        return this.listaDisciplinas;
    }

    @Override
    public void setHorario(Horario e) {
        this.listaHorarios.add(e);
    }

    @Override
    public ArrayList<Horario> getListHorarios() {
        return this.listaHorarios;
    }

    @Override
    public void setAluno(Aluno e) {
        this.listaAlunos.add(e);
    }

    @Override
    public ArrayList<Aluno> getListaAlunos() {
        return this.listaAlunos;
    }
	@Override
	public ArrayList<Aluno> getListaExAlunos() {
		return this.listaExAlunos;
	}
	@Override
	public void setDisciplinaConc(Disciplina e) {
		this.listaDisciplinasConc.add(e);
	}
	@Override
	public ArrayList<Disciplina> getListaDiscConc() {
		return this.listaDisciplinasConc;
	}
}
