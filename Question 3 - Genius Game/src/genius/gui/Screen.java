package genius.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import genius.Entity.Jogo;
import genius.gui.buttons.Botao;
import genius.gui.buttons.InnerButton;
import genius.gui.buttons.PauseButton;
import genius.gui.buttons.SaveButton;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.ImageIcon;


public class Screen implements Runnable
{
	private JTextField tfDificuldade, tfVelocidade, tfModo;
	private Botao btnVermelho, btnAzul, btnVerde, btnAmarelo, btnPlay, btnSave;    	
	private JFrame geniusFrame  = new JFrame();
    private JButton btnDif,btnIniciar, btnVel, btnModo, btnLoad, btnInstruction, btnNewButton;
	private static Screen screen;
    private Jogo jogo;
	
    public static void main(String[] args)
	{
		setScreen(new Screen());
		getScreen().jogo = new Jogo();
		getScreen().montaJogo();
	}
	
	public void montaJogo()
	{
		geniusFrame.getContentPane().setBackground(Color.DARK_GRAY);
        geniusFrame.setSize(535, 416);
		geniusFrame.setLocationRelativeTo(null);
        geniusFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /* Recado ao professor:
        Professor, estes pathings postos a seguir funcionam em qualquer sistema desde que quem o execute para testes em IDE o faça abrindo diretamente
        o projeto mencionado. Tivemos que tomar esta medida devido ao fato do senhor usar Mac e os integrantes Windows, senão, haveria conflito. */

        btnVermelho = new Botao("src/genius/Conteudo/VermelhoNormal.Gif", "src/genius/Conteudo/VermelhoApertado.Gif", 
        		"src/genius/Conteudo/som1.wav");
        btnAzul = new Botao("src/genius/Conteudo/AzulNormal.Gif", "src/genius/Conteudo/AzulApertado.Gif", 
        		"src/genius/Conteudo/som2.wav");
        btnVerde = new Botao("src/genius/Conteudo/VerdeNormal.Gif", "src/genius/Conteudo/VerdeApertado.Gif", 
        		"src/genius/Conteudo/som3.wav");
        btnAmarelo = new Botao("src/genius/Conteudo/AmareloNormal.Gif", "src/genius/Conteudo/AmareloApertado.Gif", 
        		"src/genius/Conteudo/som4.wav");
        btnPlay = new Botao("src/genius/Conteudo/PlayNormal.gif", "src/genius/Conteudo/PlayApertado.gif", 
        "src/genius/Conteudo/pause.wav");
        btnSave = new Botao("src/genius/Conteudo/SalvarNormal.gif", "src/genius/Conteudo/SalvarApertado.gif", 
                "src/genius/Conteudo/salvar.wav");        

        btnVermelho.getBotao().addActionListener(new InnerButton(jogo, btnVermelho, "vermelho"));
        btnAzul.getBotao().addActionListener(new InnerButton(jogo, btnAzul, "azul"));
        btnVerde.getBotao().addActionListener(new InnerButton(jogo, btnVerde, "verde"));
        btnAmarelo.getBotao().addActionListener(new InnerButton(jogo, btnAmarelo, "amarelo"));
        btnPlay.getBotao().addActionListener(new PauseButton(btnPlay, jogo));
        btnSave.getBotao().addActionListener(new SaveButton(btnSave, jogo));
       
        geniusFrame.getContentPane().add(btnVermelho.getBotao());
        geniusFrame.getContentPane().add(btnAzul.getBotao());
        geniusFrame.getContentPane().add(btnVerde.getBotao());
        geniusFrame.getContentPane().add(btnAmarelo.getBotao());
        geniusFrame.getContentPane().add(btnPlay.getBotao());
        geniusFrame.getContentPane().add(btnSave.getBotao());
        geniusFrame.getContentPane().setLayout(null);

		tfDificuldade = new JTextField();
        tfDificuldade.setText("" + jogo.getDifficultyLvl());
        tfDificuldade.setEditable(false);
        tfDificuldade.setBounds(173, 178, 22, 20);
        tfDificuldade.setColumns(10);
        geniusFrame.getContentPane().add(tfDificuldade);
        
        btnDif = new JButton("Dificuldade");
		btnDif.setForeground(Color.WHITE);
        btnDif.setBackground(Color.BLUE);
        btnDif.addActionListener(new ActionListener()
        {
        	public void actionPerformed(ActionEvent e)
        	{
        		jogo.changeDifficultyLvl();
        		String string_dificuldade = Integer.toString(jogo.getDifficultyLvl());
        		tfDificuldade.setText(string_dificuldade);
        	}
        });
        btnDif.setBounds(63, 177, 100, 23);
        geniusFrame.getContentPane().add(btnDif);
        
        btnIniciar = new JButton("Iniciar");
		btnIniciar.setBackground(Color.GREEN);
        btnIniciar.addActionListener(new ActionListener()
        {
        	public void actionPerformed(ActionEvent e)
        	{
        		jogo.startGame(screen);
        	}
        });
        btnIniciar.setBounds(205, 168, 108, 40);
        geniusFrame.getContentPane().add(btnIniciar);
        
		tfVelocidade = new JTextField();
        tfVelocidade.setText("" + jogo.getSpeed());
        tfVelocidade.setEditable(false);
        tfVelocidade.setColumns(10);
        tfVelocidade.setBounds(323, 178, 22, 20);
        geniusFrame.getContentPane().add(tfVelocidade);

        btnVel = new JButton("Velocidade");
		btnVel.setForeground(Color.WHITE);
        btnVel.setBackground(Color.BLUE);
        btnVel.addActionListener(new ActionListener()
        {
        	public void actionPerformed(ActionEvent e)
        	{
        		jogo.changeSpeed();
				String string_velocidade = Integer.toString(jogo.getSpeed());
        		tfVelocidade.setText(string_velocidade);
        	}
        });
        btnVel.setBounds(365, 177, 100, 23);
        geniusFrame.getContentPane().add(btnVel);

		tfModo = new JTextField();
        tfModo.setHorizontalAlignment(SwingConstants.CENTER);
        tfModo.setEditable(false);
        tfModo.setForeground(Color.BLACK);
        tfModo.setBackground(Color.WHITE);
        tfModo.setText("PvE");
        tfModo.setColumns(10);
        tfModo.setBounds(284, 143, 45, 23);

        geniusFrame.getContentPane().add(tfModo);
        
        btnModo = new JButton("Modo");
        btnModo.addActionListener(new ActionListener()
        {
        	public void actionPerformed(ActionEvent e)
        	{
        		jogo.mudaModo(geniusFrame, tfModo);
        	}
        });
        btnModo.setForeground(Color.BLACK);
        btnModo.setBackground(Color.ORANGE);
        btnModo.setBounds(205, 143, 74, 23);
        geniusFrame.getContentPane().add(btnModo);       
        
        btnLoad = new JButton("Load");
        btnLoad.addActionListener(new ActionListener() 
        {
        	public void actionPerformed(ActionEvent e) 
        	{
        		JFileChooser jfc = new JFileChooser();
        		jfc.showOpenDialog(btnLoad);
        		File archive = jfc.getSelectedFile();
        		
        		ObjectInputStream ois = null;
        		try
                {
        			FileInputStream fis = new FileInputStream(archive);
        			ois = new ObjectInputStream(fis);
        			jogo = (Jogo) ois.readObject();
        			setGuiTfields();
        		}
        		catch(Exception ex)
        		{
        			System.out.println("Erro ao carregar arquivo.");
        		}
        	}
        });
        btnLoad.setBounds(375, 209, 74, 23);
        geniusFrame.getContentPane().add(btnLoad);
        
        btnInstruction = new JButton("");
        btnInstruction.addActionListener(new ActionListener()
        {
        	public void actionPerformed(ActionEvent e)
            {
        		JOptionPane.showMessageDialog(geniusFrame,
        				"Modos de Jogo:"
                		+"\nJogador vs Máquina (PvE)"
        				+"\nJogador vs Jogador (PvP)"
        				+"\n\nDificuldades de Jogo:"
                		+"\n1 = 5 acertos seguidos"
                		+"\n2 = 10 acertos seguidos"
                		+"\n3 = 15 acertos seguidos", "Instruções", JOptionPane.INFORMATION_MESSAGE);
        	}
        });
        btnInstruction.setIcon(new ImageIcon(Screen.class.getResource("/genius/Conteudo/interregacao.GIF")));
        btnInstruction.setBounds(105, 209, 33, 23);
        geniusFrame.getContentPane().add(btnInstruction);
        
        btnNewButton = new JButton("New Game");
        btnNewButton.addActionListener(new ActionListener()
        {
        	public void actionPerformed(ActionEvent e)
        	{
        		jogo.newGame();
        	}
        });
        btnNewButton.setBounds(46, 143, 133, 23);
        geniusFrame.getContentPane().add(btnNewButton);
        
        btnVermelho.getBotao().setBounds(10, 11, 224, 126);
        btnAzul.getBotao().setBounds(10, 239, 224, 126);
        btnVerde.getBotao().setBounds(288, 239, 221, 126);
        btnAmarelo.getBotao().setBounds(288, 11, 221, 126);
        btnPlay.getBotao().setBounds(215,210,39,23);
        btnSave.getBotao().setBounds(262,210,39,23);
        
        geniusFrame.setVisible(true);  
    }
	
    public JTextField getTfDificuldade()
    {
		return tfDificuldade;
	}

	public JTextField getTfVelocidade()
    {
		return tfVelocidade;
	}

	public JTextField getTfModo() {
		return tfModo;
	}

    public Jogo getJogo() {
        return this.jogo;
    }

    public void setJogo(Jogo jogo) {
        this.jogo = jogo;
    }

    public void setGuiTfields()
    {
        getTfDificuldade().setText(""+jogo.getDifficultyLvl());
        getTfVelocidade().setText(""+ jogo.getSpeed());
        getTfModo().setText(""+ jogo.getAtualMode());
    }

    public static Screen getScreen() {
        return screen;
    }

    public static void setScreen(Screen screen) {
        Screen.screen = screen;
    }

    @Override
    public void run() 
    {
        jogo.runGame(geniusFrame, tfModo, btnVermelho, btnAmarelo, btnAzul, btnVerde , btnPlay);
    }
}