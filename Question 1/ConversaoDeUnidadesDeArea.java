package prova03112021POO.q1;

import java.util.ArrayList;

public class ConversaoDeUnidadesDeArea 
{
	private double output;
	private ArrayList<String> selecoes = new ArrayList<>();
	private String conversoes;

	public void setSelecoes(ArrayList<String> array)
	{
		for(int i = 0; i < array.size(); i++)
		{
			selecoes.add(i, array.get(i));
		}
	}
	public ArrayList<String> getSelecoes()
	{
		return this.selecoes;
	}
	// método usado na letra A
	public double getResultado(double input)
	{
		String pos1 = selecoes.get(0), pos2 = selecoes.get(1);
		switch(pos1)
		{
			case "metro(s) quadrado(s)":
			{
				switch(pos2)
				{
					case "metro(s) quadrado(s)":
					{
						// relacao 1:1
						output = input;
						break;
					}
					case "pe(s) quadrado(s)":
					{
						// 1 metro quadrado = 10.76391041671 pés quadrados
						output = input * 10.76391041671;
						break;
					}
					case "milha(s) quadrada(s)":
					{
						// 1 metros quadrados = 10.76391041671 * (1/(640.00000006326 * 43559.999995694)) milhas²
						output = input * 3.8610215854245905e-07;
						break;
					}
					case "acre(s)":
					{
						// 1 metro quadrado = 10.76391041671 * (1/43559.999995694) acres
						output = input * 0.00024710538149159863;
						break;
					}
					case "centimetro(s) quadrado(s)":
					{
						// 1 metro quadrado = (10.76391041671 * 929.0304) centimetros quadrados
						output = input * 10000.000000000258;
					}
					
				}
				break;
			}
			case "pe(s) quadrado(s)":
			{
				switch(pos2)
				{
					case "metro(s) quadrado(s)":
					{
						// 1 pé quadrado = 1/10.76391041671 m²
						output = input * 0.09290303999999759;
						break;
					}
					case "pe(s) quadrado(s)":
					{
						// relacao 1:1
						output = input;
						break;
					}
					case "milha(s) quadrada(s)":
					{
						// 1 pé quadrado = 1/(640.00000006326 * 43559.999995694) milhas quadradas
						output = input * 3.587006427915549e-08;
						break;
					}
					case "acre(s)":
					{
						// 1 pé(s) quadrado(s) = (1/43559.999995694) acres
						output = input * 2.2956841140928653e-05;
						break;
					}
					case "centimetro(s) quadrado(s)":
					{
						// 1 pé(s) quadrado = 929.0304 centímetros quadrados
						output = input * 929.0304;
						break;
					}
					
				}
				break;
			}
			case "milha(s) quadrada(s)":
			{
				switch(pos2)
				{
					case "metro(s) quadrado(s)":
					{
						// 1 milhas² = 1/(10.76391041671 * (1/(640.00000006326 * 43559.999995694))) m²
						output = input * 2589988.1103359116;
						break;
					}
					case "pe(s) quadrado(s)":
					{
						// 1 milha quadrada = (640.00000006326 * 43559.999995694) pés quadrados
						output = input * 27878399.999999765;
						break;
					}
					case "milha(s) quadrada(s)":
					{
						// relacao 1:1
						output = input;
						break;
					}
					case "acre(s)":
					{
						// 1 milha quadrada = 640.00000006326 acres
						output = input * 640.00000006326;
						break;
					}
					case "centimetro(s) quadrado(s)":
					{
						// 1 milhas2 = 640.00000006326 * (43559.999995694 * 929.0304) cm2
						output = input * 25899881103.359783;
						break;
					}
					
				}
				break;
			}
			case "acre(s)":
			{
				switch(pos2)
				{
					case "metro(s) quadrado(s)":
					{
						// 1 acre = 43559.999995694 * (1/10.7639104167) m²
						output = input * 4046.8564220036146;
						break;
					}
					case "pe(s) quadrado(s)":
					{
						// 1 acre = 43559.999995694 pés quadrados.
						output = input * 43559.999995694;
						break;
					}
					case "milha(s) quadrada(s)":
					{
						// 1 acre = (1/640.00000006326) milhas quadradas
						output = input * (1/640.00000006326);
						break;
					}
					case "acre(s)":
					{
						output = input;
						break;
					}
					case "centimetro(s) quadrado(s)":
					{
						// 1 acre = (43559.999995694 * 929.0304) centimetros quadrados
						output = input * 40468564.2199996;
						break;
					}
					
				}
				break;
			}
			case "centimetro(s) quadrado(s)":
			{
				switch(pos2)
				{
					case "metro(s) quadrado(s)":
					{
						// 1 cm² = 1/(10.76391041671 * 929.0304) m²
						output = input * 9.999999999999742e-05;
						break;
					}
					case "pe(s) quadrado(s)":
					{
						// 1 cm² = 1/(929.0304) pés quadrados
						output = input * 0.0010763910416709723;
						break;
					}
					case "milha(s) quadrada(s)":
					{
						// 1 cm2 = 1/(640.00000006326 * (43559.999995694 * 929.0304)) milhas²
						output = input * 3.8610215854244907e-11;
						break;
					}
					case "acre(s)":
					{
						// 1 cm² = 1/(43559.999995694 * 929.0304) acres
						output = input * 2.4710538149159223e-08;
						break;
					}
					case "centimetro(s) quadrado(s)":
					{
						output = input;
						break;
					}
					
				}
				break;
			}
		}
		return output;
	}
	// método usado na letra B
	public String getAreasFutebol(double input)
	{	
		this.conversoes = null;

		for(int i = 0; i<3;i++){
			switch(i)
			{
				case 0:
				{
					String pes = ""+(input*10.76391041671);
					conversoes = "Em pés quadrados: " + pes + "\n";
					break;
				}
				case 1:
				{
					String acres = ""+(input * (10.76391041671 * (1/43559.999995694)));
					conversoes += "Em acres: " + acres + "\n";
					break;
				}
				case 2:
				{
					String cm = ""+(input * (10.76391041671 * 929.0304));
					conversoes += "Em centímetros quadrados: " + cm + "\n";
					break;
				}
			}
		}
		return conversoes;
	}
}