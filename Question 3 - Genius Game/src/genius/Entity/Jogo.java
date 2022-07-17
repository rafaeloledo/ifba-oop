package genius.Entity;

import java.awt.Frame;
import java.io.Serializable;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import genius.gui.Screen;
import genius.gui.buttons.Botao;

public class Jogo implements Serializable {
	private static final long serialVersionUID = -2332514880567487959L;

	private int[] computerList = new int[100];
	private int[] player1List = new int[100];
	private int[] player2List = new int[100];
	private int numChoosePC = 0, numChoosePlayer1 = 0, numChoosePlayer2 = 0;
	private int counter; // quantidade de botoes apertados em uma rodada
	private boolean stop = true; // condicao de parada caso o jogador tenha ganho o jogo
	private boolean passTurn; // condicao para passar a vez do jogador no modo pvp
	private boolean pause;
	private int player1TotalPoints = 0, player2TotalPoints = 0;
	private int player1TurnPoints = 0, player2TurnPoints = 0;
	private int pvpChampionshipTurn = 1;
	private int sleep1 = 700, sleep2 = 500;
	private int speed = 1, difficultyLevel = 1;
	private String atualMode = "PvE";

	public void startGame(Screen game) {
		Thread t = new Thread(game, "Jogadas");
		t.start();
		stop = false;
	}

	public void newGame() {
		this.setCounter(0);
		this.setNumChoosePC(0);
		this.setNumChoosePlayer1(0);
		this.setNumChoosePlayer2(0);
	}

	public void changeDifficultyLvl() {
		difficultyLevel++;
		if (difficultyLevel == 4) {
			difficultyLevel = 1;
		}
	}

	public void changeSpeed() {
		speed++;

		if (speed == 4) {
			speed = 1;
		}

		switch (speed) {
			case 1: {
				sleep1 = 700;
				sleep2 = 500;
				break;
			}
			case 2: {
				sleep1 = 450;
				sleep2 = 270;
				break;
			}
			case 3: {
				sleep1 = 105;
				sleep2 = 150;
				break;
			}
		}
	}

	public void mudaModo(JFrame geniusFrame, JTextField txtModo) {
		if (stop) {
			if (atualMode.equals("PvE")) {
				txtModo.setText("PvP");
				atualMode = "PvP";
			} else {
				txtModo.setText("PvE");
				atualMode = "PvE";
			}
		} else {
			JOptionPane.showMessageDialog(geniusFrame, "Erro...Termine o jogo em andamento para trocar de modo.");
		}
	}

	public void escolhaPC(Botao btnVermelho, Botao btnAmarelo, Botao btnAzul,
			Botao btnVerde, Botao btnPlay, JFrame geniusFrame) throws InterruptedException {
		/*
		 * Escolha dos botoes e alocacao de seus numeros no vetor de escolhas do
		 * computador.
		 * Pisca os botoes contidos no vetor.
		 */

		int numeroBotao = (int) (Math.random() * 4);
		computerList[numChoosePC] = numeroBotao;

		if (!stop) {
			boolean aux = false; // variavel auxiliar para determinar a mensagem de pausa exibida
			boolean entrar = true;
			int z = 0;

			// pisca os botoes escolhidos pelo computador enquanto aux for true

			while (entrar) {
				Thread.sleep(500);

				// checa se o botao de pause foi apertado novamente e exibe e mensagem
				// correspondente

				if (!pause && aux) {
					JOptionPane.showMessageDialog(geniusFrame, "Programa retomado com Sucesso!");
					aux = false;
				}

				if (!pause) {
					switch (computerList[z]) {
						case 0: {
							try {
								Thread.sleep(sleep1);
								btnVermelho.apertaBotao();
								Thread.sleep(sleep2);
								btnVermelho.desapertaBotao();
							} catch (Exception e) {
								e.getStackTrace();
							}
							break;
						}
						case 1: {
							try {
								Thread.sleep(sleep1);
								btnAzul.apertaBotao();
								Thread.sleep(sleep2);
								btnAzul.desapertaBotao();
							} catch (Exception e) {
								e.getStackTrace();
							}
							break;
						}
						case 2: {
							try {
								Thread.sleep(sleep1);
								btnVerde.apertaBotao();
								Thread.sleep(sleep2);
								btnVerde.desapertaBotao();
							} catch (Exception e) {
								e.getStackTrace();
							}
							break;
						}
						case 3: {
							try {
								Thread.sleep(sleep1);
								btnAmarelo.apertaBotao();
								Thread.sleep(sleep2);
								btnAmarelo.desapertaBotao();
							} catch (Exception e) {
								e.getStackTrace();
							}
							break;
						}

					}
					z++;
				}
				if (pause && !aux) // checa se o botao de pause foi apertado exibe e mensagem correspondente
				{
					// zera o ponto de inicio do contador do PC , fazendo com que toda sequêcia seja
					// repetida desde o momento do pause
					z = 0;
					JOptionPane.showMessageDialog(geniusFrame,
							"Programa pausado com Sucesso!" + "\nAperte o botao pause novamente para retomar!");
					aux = true;
				}
				if (z > numChoosePC) {
					entrar = false;
				}
			}
		}
	}

	public void botaoApertado(Botao botao, String corBotao) throws ParameterException {

		String opcao;
		opcao = corBotao.toLowerCase();

		switch (opcao) {
			case "vermelho": {
				botao.getSom().play();
				;
				++counter;
				if (!passTurn) {
					player1List[numChoosePlayer1] = 0;
					numChoosePlayer1++;
				} else {
					player2List[numChoosePlayer2] = 0;
					numChoosePlayer2++;
				}
				break;
			}
			case "azul": {
				botao.getSom().play();
				++counter;
				if (!passTurn) {
					player1List[numChoosePlayer1] = 1;
					numChoosePlayer1++;
				} else {
					player2List[numChoosePlayer2] = 1;
					numChoosePlayer2++;
				}
				break;
			}
			case "verde": {
				botao.getSom().play();
				++counter;
				if (!passTurn) {
					player1List[numChoosePlayer1] = 2;
					numChoosePlayer1++;
				} else {
					player2List[numChoosePlayer2] = 2;
					numChoosePlayer2++;
				}
				break;
			}
			case "amarelo": {
				botao.getSom().play();
				++counter;
				if (!passTurn) {
					player1List[numChoosePlayer1] = 3;
					numChoosePlayer1++;
				} else {
					player2List[numChoosePlayer2] = 3;
					numChoosePlayer2++;
				}
				break;
			}
			default: {
				throw new ParameterException("Cor invalida");
			}
		}
	}

	public void pveMode(JFrame geniusFrame, Botao btnVermelho, Botao btnAmarelo, Botao btnAzul, Botao btnVerde,
			Botao btnPlay) {
		try {
			boolean acabou = true;
			boolean liberado = true;

			while (acabou) {
				Thread.sleep(250);

				// Vez do computador

				// Se o computador estiver liberado, faz sua jogada

				if (liberado) {
					geniusFrame.setTitle("Aguarde....");
					// geniusFrame.setEnabled(false);
					escolhaPC(btnVermelho, btnAmarelo, btnAzul, btnVerde, btnPlay, geniusFrame);
					numChoosePC++; // Incrementa a posicao para a proxima rodada
					liberado = false;
					geniusFrame.setTitle("Sua vez!");
					geniusFrame.setEnabled(true);
				}

				Thread.sleep(1000);
				// vez do JOGADOR
				// Aguarda ate que o jogador aperte a quantidade certa de botoes
				if (counter == numChoosePC) {

					for (int x = 0; x < numChoosePC; x++) {

						if (player1List[x] == computerList[x]) {
							// Se acertou, zera o counter de botões apertados e libera o computador para a
							// próxima rodada
							counter = 0;
							liberado = true;
						} else {
							JOptionPane.showMessageDialog(geniusFrame, "Game Over!");
							System.exit(0);
						}
					}

					switch (difficultyLevel) {
						case 1: {
							// checa se o lvl de dificultyLevel é 1 e se o jogador acertou a quantidade x
							if (numChoosePlayer1 == 5) {
								mensagemRodadaPVE(geniusFrame);
								stop = true;
							}
							break;
						}
						case 2: {
							// checa se o lvl de dificultyLevel é 2 e se o jogador acertou a quantidade x
							if (numChoosePlayer1 == 10) {
								mensagemRodadaPVE(geniusFrame);
								stop = true;
							}
							break;
						}
						case 3: {
							// checa se o lvl de dificultyLevel é 3 e se o jogador acertou a quantidade x
							if (numChoosePlayer1 == 15) {
								mensagemRodadaPVE(geniusFrame);
								stop = true;
							}
							break;
						}
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void pvpMode(JFrame geniusFrame, Botao btnVermelho, Botao btnAmarelo, Botao btnAzul, Botao btnVerde,
			Botao btnPlay) {
		try {
			boolean acabou = true;
			boolean liberado = true;

			while (acabou) {
				Thread.sleep(250);

				// Vez do computador

				// Se o computador estiver liberado, faz sua jogada

				if (liberado) {
					geniusFrame.setTitle("Aguarde....");
					// geniusFrame.setEnabled(false);
					escolhaPC(btnVermelho, btnAmarelo, btnAzul, btnVerde, btnPlay, geniusFrame);
					numChoosePC++; // Incrementa a posicao para a proxima rodada
					liberado = false;
					geniusFrame.setTitle("Sua vez!");
					geniusFrame.setEnabled(true);
				}

				Thread.sleep(1000);
				// vez do JOGADOR
				// Aguarda ate que o jogador aperte a quantidade certa de botoes
				if (counter == numChoosePC) {

					for (int x = 0; x < numChoosePC; x++) {
						int aux;

						// Verifica se é o jogador 1

						if (!passTurn) {
							// Verifica se o jogador atual eh o jogador 1 e inicializa a variável aux com
							// valor da lista correspondente
							aux = player1List[x];
						}
						// Ou se é o jogador 2
						else {
							aux = player2List[x];
						}

						// Verifica se a jogada do jogador é igual à da máquina

						if (aux == computerList[x]) {
							// Se acertou, zera o counter de botões apertados e libera o computador para a
							// proxima rodada
							counter = 0;
							liberado = true;
						} else {
							counter = 0; // Se errou , zera a counter de botoes apertados
							liberado = true; // libera o computador para a proxima rodada
							numChoosePC--; // Decrementa do index do computador

							if (!passTurn) // identifica se eh o jogador 1
							{
								// passa a vez para o jogador 2
								passTurn = true;

								/*
								 * zerando o index de jogadas / que representa a quantidade de
								 * acertos que o jogador precisa pra ganhar o jogo /antes de contabilizar
								 */
								numChoosePlayer1 = 0;
								JOptionPane.showMessageDialog(geniusFrame, "Voce errou Jogador 1! "
										+ "Passe a vez para o Jogador 2\nPreste atencao uma nova jogada sera gerada!");
								break;
							}
							// caso seja o jogador 2
							else {
								// passa a vez para o jogador 1
								passTurn = false;

								/*
								 * zerando o index de jogadas / que representa a quantidade de
								 * acertos que o jogador precisa pra ganhar o jogo /antes de contabilizar
								 */
								numChoosePlayer2 = 0;

								JOptionPane.showMessageDialog(geniusFrame, "Você errou Jogador 2! "
										+ "Passe a vez para o Jogador 1\nPreste atenção, uma nova jogada será gerada!");
								break;
							}
						}

					}
					// Contabilizando os pontos dos jogadores 1 e 2

					player1TotalPoints += numChoosePlayer1;
					player2TotalPoints += numChoosePlayer2;
					player1TurnPoints += numChoosePlayer1;
					player2TurnPoints += numChoosePlayer2;

					boolean empate = false;

					if (player1TotalPoints == player2TotalPoints) {
						empate = true;
					}

					// determinando o dificultyLevel do jogo no PVP

					switch (difficultyLevel) {
						case 1: {
							// checa se o lvl de dificultyLevel é 1 e se o jogador acertou a quantidade x
								if (numChoosePlayer1 == 5 || numChoosePlayer2 == 5) {
									relatorio_rodada(geniusFrame);
									stop = true;

								if (empate) {
									mensagemEmpatePVP(geniusFrame);
									liberado = false;
								} else {
									relatorio_final(geniusFrame);
								}
							}
							break;
						}
						case 2: {
							// checa se o lvl de dificultyLevel é 2 e se o jogador acertou a quantidade x
							if (numChoosePlayer1 == 10 || numChoosePlayer2 == 10) {
								relatorio_rodada(geniusFrame);
								stop = true;

								if (empate) {
									mensagemEmpatePVP(geniusFrame);
									liberado = false;
								} else {
									relatorio_final(geniusFrame);
								}
							}
						}
						case 3: {
							// checa se o lvl de dificultyLevel é 3 e se o jogador acertou a quantidade x
							if (numChoosePlayer1 == 15 || numChoosePlayer2 == 15) {
								relatorio_rodada(geniusFrame);
								stop = true;

								if (empate) {
									mensagemEmpatePVP(geniusFrame);
									liberado = false;
								} else {
									relatorio_final(geniusFrame);
								}
							}
						}
					}

					// zerando indexs humanos
					numChoosePlayer1 = 0; // index de jogadas humanas retorna a 0 para a proxima rodada / jogador 1
					numChoosePlayer2 = 0; // index de jogadas humanas retorna a 0 para a proxima rodada / jogador 2
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void runGame(JFrame geniusFrame, JTextField txtModo, Botao btnVermelho, Botao btnAmarelo,
			Botao btnAzul, Botao btnVerde, Botao btnPlay) {
		
		if(getAtualMode().equals("PVE"))
			pveMode(geniusFrame, btnVermelho, btnAmarelo, btnAzul, btnVerde, btnPlay);
		else
			pvpMode(geniusFrame, btnVermelho, btnAmarelo, btnAzul, btnVerde, btnPlay);
	}

	public void relatorio_rodada(JFrame geniusFrame) {
		JOptionPane.showMessageDialog(geniusFrame, "Pontos Totais Jogador 1 : " + player1TotalPoints
				+ "\nPontos Totais Jogador 2 : " + player2TotalPoints
				+ "\nPontos da Rodada do Jogador 1 : " + player1TurnPoints
				+ "\nPontos da Rodada do Jogador 2 : " + player2TurnPoints);
		
		// zerando pontos da rodada do jogador 1 e 2
		player1TurnPoints = 0;
		player2TurnPoints = 0;
	}

	public void relatorio_final(JFrame geniusFrame) {
		if (player1TotalPoints > player2TotalPoints) {
			JOptionPane.showMessageDialog(geniusFrame, "\nParabéns ao Jogador 1! Você venceu!" +
					"\nCom o total de " + player1TotalPoints + " pontos");
		} else {
			JOptionPane.showMessageDialog(geniusFrame, "\nParabéns ao Jogador 2! Você venceu!" +
					"\nCom o total de " + player2TotalPoints + " pontos");
		}
		player1TotalPoints = 0;
		player2TotalPoints = 0;
		player1TurnPoints = 0;
		player2TurnPoints = 0;
	}

	public void mensagemRodadaPVE(JFrame geniusFrame) {
		JOptionPane.showMessageDialog(geniusFrame, "Você Venceu!!\nNo difficulty level: " + difficultyLevel
				+ "\nNa speed : " + speed + "\nJogando no modo PVE");
	}

	public void mensagemEmpatePVP(JFrame geniusFrame) {
		String jogadoratual;

		if (!passTurn) {
			jogadoratual = "Jogador 1";
		} else {
			jogadoratual = "Jogador 2";
		}
		pvpChampionshipTurn++;

		Screen.getScreen().getJogo().newGame();

		geniusFrame.setTitle("Aperte iniciar novamente");

		JOptionPane.showMessageDialog(geniusFrame, "EMPATE !\nPreparado para a rodada " + pvpChampionshipTurn + " ?" +
				"\nO " + jogadoratual + " comeca jogando" +
				"\nClique em iniciar para começar a próxima rodada");
	}

	public int getDifficultyLvl() {
		return difficultyLevel;
	}

	public void setNumChoosePC(int numChoosePC) {
		this.numChoosePC = numChoosePC;
	}

	public void setNumChoosePlayer1(int numChoosePlayer1) {
		this.numChoosePlayer1 = numChoosePlayer1;
	}

	public void setNumChoosePlayer2(int numChoosePlayer2) {
		this.numChoosePlayer2 = numChoosePlayer2;
	}

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

	public int getNumChoosePC() {
		return numChoosePC;
	}

	public int getNumChoosePlayer1() {
		return numChoosePlayer1;
	}

	public int getNumChoosePlayer2() {
		return numChoosePlayer2;
	}

	public String getAtualMode() {
		return atualMode;
	}

	public boolean isPause() {
		return pause;
	}

	public int[] getComputerList() {
		return computerList;
	}

	public void setPause(boolean pause) {
		this.pause = pause;
	}

	public int getSpeed() {
		return speed;
	}
}