package prova03112021POO.q2.src;

import java.util.ArrayList;

public class Aula extends Object
{
	private String diaDaSem;
    public ArrayList<Horario> horarios = new ArrayList<Horario>();
    public static ArrayList<Double> listaDuracaoH = new ArrayList<Double>();
    private double duracaoT;
    
    @Override
    public String toString()
    {
    	String s = diaDaSem + ": " + String.format("%.3f", duracaoT) + "h";
    	return s;
    }
    
    public ArrayList<Horario> getHorarios() {
		return horarios;
	}

	public void setHorarios(Horario h) {
		this.horarios.add(h);
	}

    public ArrayList<Double> getListaDuracaoH() {
		return listaDuracaoH;
	}

	public void setDuracaoH(Double d) {
		listaDuracaoH.add(d);
		setDuracaoT();
	}

    public double getDuracaoT() {
		return this.duracaoT;
	}

	public void setDuracaoT() {
		try
		{
			this.duracaoT = 0;
			for(int i = 0; i < listaDuracaoH.size() ; i++)
			{
				this.duracaoT += listaDuracaoH.get(i); 
			}
		}
		catch(Exception ex) {}
	}

	public void setListaDuracaoH(Double d) {
		listaDuracaoH.add(d);
	}

    public String getDiaDaSem() {
		return diaDaSem;
	}
    
	public void setDiaDaSem(String diaDaSem) {
		this.diaDaSem = diaDaSem;
	}
	 
	public void setHorario(Horario h)
	{
		horarios.add(h);
	}
}
