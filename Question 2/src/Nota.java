package prova03112021POO.q2.src;

public class Nota extends Object {
	private double pont;
	private Disciplina d;
	
	public Nota(double pont, Disciplina d){
		this.pont = pont;
		this.d = d;
	}
	@Override
	public String toString()
	{
		return "Nota: " + pont;
	}
	public void setPont(Double pont) {
		this.pont = pont;
	}
	public Disciplina getD() {
		return d;
	}
	public void setD(Disciplina d) {
		this.d = d;
	}	
}
