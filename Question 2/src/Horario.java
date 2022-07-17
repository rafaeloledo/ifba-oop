package prova03112021POO.q2.src;

import javax.swing.JOptionPane;

import prova03112021POO.q2.GUI.Curso.TelaQ2;

public class Horario extends Object
{
    private String horaIn;
    private String minIn;
    private String horaFin;
    private String minFin;
    private double duracaoH;
    private String dia;
    
    public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	public Horario(String horaIn, String minIn, String horaFin, String minFin)
    {
    	this.setHoraFin(horaFin);
    	this.setHoraIn(horaIn);
    	this.setMinFin(minFin);
    	this.setMinIn(minIn);
    	setDuracao();
    }
	
	public Horario(String horaIn, String minIn, String horaFin, String minFin, String dia)
    {
    	this.setHoraFin(horaFin);
    	this.setHoraIn(horaIn);
    	this.setMinFin(minFin);
    	this.setMinIn(minIn);
    	this.dia = dia;
    	setDuracao();
    }
    
    @Override
    public String toString()
    {
    	return dia + ": " + this.horaIn + ":" + this.minIn + " - " 
    			+ this.horaFin + ":" + minFin;
    }

	public String getHoraIn() {
		return horaIn;
	}

	public void setHoraIn(String horaIn) {
		this.horaIn = horaIn;
	}

	public String getMinIn() {
		return minIn;
	}

	public void setMinIn(String minIn) {
		this.minIn = minIn;
	}

	public String getHoraFin() {
		return horaFin;
	}

	public void setHoraFin(String horaFin) {
		this.horaFin = horaFin;
	}

	public String getMinFin() {
		return minFin;
	}

	public void setMinFin(String minFin) {
		this.minFin = minFin;
	}
	public int setDuracao()
	{
		try
		{	
			double hrIni = Double.parseDouble(horaIn);
			double minIni = Double.parseDouble(minIn)/60f;
			double hrFin = Double.parseDouble(horaFin);
			double minFinn = Double.parseDouble(minFin)/60f;
			double hrIniT = hrIni + minIni;
			double hrFinT = hrFin + minFinn;
			double total = hrFinT - hrIniT;
			this.duracaoH = total;
		}
		catch(Exception ex)
		{
			JOptionPane.showMessageDialog(TelaQ2.getFrame(), "Erro ao definir duração.");
			return 0;
		}
		return 1;
	}

	public double getDuracaoH() {
		
		return duracaoH;
	}
}
