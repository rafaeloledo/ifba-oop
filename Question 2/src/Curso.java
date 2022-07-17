package prova03112021POO.q2.src;

import java.util.ArrayList;

public abstract class Curso extends Object
{
    protected String nome;
    public ArrayList<Disciplina> listaDisciplinas = new ArrayList<>();
    public ArrayList<Disciplina> listaDisciplinasConc = new ArrayList<>();
    public ArrayList<Horario> listaHorarios = new ArrayList<>();
    public ArrayList<Aluno> listaAlunos = new ArrayList<>();
    public ArrayList<Aluno> listaExAlunos = new ArrayList<>();

    public abstract void setNome(String e);
    public abstract String getNome();
    public abstract void setDisciplina(Disciplina e);
    public abstract ArrayList<Disciplina> getListaDisc();
    public abstract void setDisciplinaConc(Disciplina e);
    public abstract ArrayList<Disciplina> getListaDiscConc();
    public abstract void setHorario (Horario e);
    public abstract ArrayList<Horario> getListHorarios();
    public abstract void setAluno(Aluno e);
    public abstract ArrayList<Aluno> getListaAlunos();
    public abstract ArrayList<Aluno> getListaExAlunos();

}
