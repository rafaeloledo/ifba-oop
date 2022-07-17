package prova03112021POO.q2.src;

public class Professor 
{
    private String nome;
    private String dataNasc;
    private long cpfSemHifen;
    
    @Override
    public String toString()
    {
    	return this.nome;
    }
    
    public String getNome() 
    {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public long getCpfSemHifen() {
        return cpfSemHifen;
    }

    public void setCpfSemHifen(long cpfSemHifen) {
        this.cpfSemHifen = cpfSemHifen;
    }

	public String getDataNasc() {
		return dataNasc;
	}

	public void setDataNasc(String dataNasc) {
		this.dataNasc = dataNasc;
	}
    
}
