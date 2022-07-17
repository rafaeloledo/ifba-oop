package prova03112021POO.q2.GUI.Curso;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import prova03112021POO.q2.GUI.Aluno.PanelAluno;
import prova03112021POO.q2.GUI.Aluno.PanelListarAlunos;
import prova03112021POO.q2.GUI.Aluno.PanelQuadroHorario;
import prova03112021POO.q2.GUI.Aula.PanelCadAula;
import prova03112021POO.q2.GUI.Disciplina.PanelCadListDisc;
import prova03112021POO.q2.GUI.Disciplina.PanelEditDisc;
import prova03112021POO.q2.GUI.Disciplina.PanelLancNota;
import prova03112021POO.q2.GUI.ExAlunos.PanelExAlunos;
import prova03112021POO.q2.GUI.Horario.PanelAltHorario;
import prova03112021POO.q2.GUI.Horario.PanelHorario;
import prova03112021POO.q2.GUI.Professor.PanelCadProfessor;

import prova03112021POO.q2.src.Aluno;
import prova03112021POO.q2.src.Disciplina;
import prova03112021POO.q2.src.Horario;
import prova03112021POO.q2.src.MeuCurso;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.Color;


public class TelaQ2 {

	private static JFrame frame;
	protected JPanel panelHome;
	
	public static PanelCadListDisc panelCadListDisc;
	public static PanelHorario panelHorario;
	public static PanelCadProfessor panelCadProfessor;
	public static PanelCadAula panelCadAula;
	public static PanelAluno panelAluno;
	public static PanelCursos panelCursos;
	public static PanelAltHorario panelAltHorario;
	public static PanelCursoHorarios panelCursoHorarios;
	public static PanelCursoDisciplinas panelCursoDisciplinas;
	public static PanelListarAlunos panelListarAlunos;
	public static PanelExAlunos panelExAlunos;
	public static PanelQuadroHorario panelQuadroHorario;
	public static PanelEditDisc panelEditDisc;
	public static PanelLancNota panelLancNota;
	
	private static JComboBox<Disciplina> cbDiscASCad;
	private static JComboBox<Horario> cbHrASCad;
	private static JComboBox<Aluno> cbAlunosASer;
	private JTextField tfNomeCurso;

	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					new TelaQ2();
					TelaQ2.frame.setVisible(true);
				} 
				catch(Exception e)
				{
					e.printStackTrace();
				}
			}
		});
	}

	public TelaQ2() 
	{
		initialize();
	}

	private void initialize() 
	{		
		
		frame = new JFrame();
		frame.setTitle("Cadastro de Cursos - CAC");
		frame.setBounds(100, 100, 667, 662);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		panelHome = new JPanel();
		panelHome.setBounds(10, 33, 631, 579);
		panelHome.setLayout(null);
		
		panelCursos = new PanelCursos();
		panelLancNota = new PanelLancNota();
		panelEditDisc = new PanelEditDisc();
		panelExAlunos = new PanelExAlunos();
		panelQuadroHorario = new PanelQuadroHorario();
		panelListarAlunos = new PanelListarAlunos();
		panelCursoHorarios = new PanelCursoHorarios();
		panelAltHorario = new PanelAltHorario();
		panelCursoDisciplinas = new PanelCursoDisciplinas();
		panelCadAula = new PanelCadAula();
		panelCadListDisc = new PanelCadListDisc();
		panelHorario = new PanelHorario();
		panelAluno = new PanelAluno();
		panelCadProfessor = new PanelCadProfessor();
		
		cbDiscASCad = new JComboBox<>();
		cbDiscASCad.setBounds(233, 139, 364, 24);
		panelHome.add(cbDiscASCad);
		
		cbAlunosASer = new JComboBox<Aluno>();
		cbAlunosASer.setBounds(233, 221, 364, 24);
		panelHome.add(cbAlunosASer);
		
		cbHrASCad = new JComboBox<Horario>();
		cbHrASCad.setBounds(233, 178, 364, 24);
		panelHome.add(cbHrASCad);
		
		tfNomeCurso = new JTextField();
		tfNomeCurso.setBounds(233, 104, 364, 24);
		tfNomeCurso.setColumns(10);
		panelHome.add(tfNomeCurso);
		
		JButton btnCadCur = new JButton("Cadastrar Curso");
		btnCadCur.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				try 
				{
					MeuCurso c = new MeuCurso();
					String nome = getTfNomeCurso().getText();
					if(nome.length() == 0)
					{
						JOptionPane.showMessageDialog(frame, "Digite algo no campo nome.");
						throw new Exception();
					}
					c.setNome(nome);
					
					Disciplina d;
					Horario h;
					Aluno a;
					
					for(int i = 0; i < getCbAlunosASer().getItemCount(); i++)
					{
						a = (Aluno) getCbAlunosASer().getSelectedItem();
						c.setAluno(a);
					}
					for(int i = 0; i < getCbHrASCad().getItemCount(); i++)
					{
						h = (Horario) getCbHrASCad().getSelectedItem();
						c.setHorario(h);
						
					}
					for(int i = 0; i< getCbDiscASCad().getItemCount(); i++)
					{
						d = (Disciplina) getCbDiscASCad().getSelectedItem();
						c.setDisciplina(d);
					}
					PanelCursos.getCbCurCad().addItem(c);
				}
				catch(Exception ex){}
			}
		});
		btnCadCur.setBounds(250, 502, 134, 23);
		panelHome.add(btnCadCur);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 651, 22);
		
		JMenu menuCurso = new JMenu("Curso");
		menuBar.add(menuCurso);
		
		JMenuItem mitemCrCur = new JMenuItem("Criar curso");
		mitemCrCur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setPanel(panelHome);
			}
		});
		menuCurso.add(mitemCrCur);
		
		JMenuItem mitemHorsCurso = new JMenuItem("Horários do Curso");
		mitemHorsCurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setPanel(panelCursoHorarios);
			}
		});
		menuCurso.add(mitemHorsCurso);
		
		JMenuItem mitemDiscsCurso = new JMenuItem("Disciplinas do Curso");
		mitemDiscsCurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setPanel(panelCursoDisciplinas);
			}
		});
		menuCurso.add(mitemDiscsCurso);
		
		JMenuItem mitemCursCads = new JMenuItem("Cursos Cadastrados");
		mitemCursCads.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setPanel(panelCursos);
			}
		});
		menuCurso.add(mitemCursCads);
		
		JMenu mHr = new JMenu("Horários");
		menuBar.add(mHr);
		
		JMenuItem mitemCadHr = new JMenuItem("Cadastro de Horário");
		mitemCadHr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setPanel(panelHorario);
			}
		});
		mHr.add(mitemCadHr);
		
		JMenuItem mitemEditHrCur = new JMenuItem("Editar Horários do Curso");
		mitemEditHrCur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setPanel(panelAltHorario);
			}
		});
		mHr.add(mitemEditHrCur);
		
		JMenu mnAula = new JMenu("Aula");
		menuBar.add(mnAula);
		
		JMenuItem mitemCadAul = new JMenuItem("Cadastro de Aula");
		mitemCadAul.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setPanel(panelCadAula);
			}
		});
		mnAula.add(mitemCadAul);
		
		JMenu menuDisciplinas = new JMenu("Disciplinas");
		menuDisciplinas.setHorizontalAlignment(SwingConstants.CENTER);
		menuBar.add(menuDisciplinas);
		
		JMenuItem mitemCadastDisc = new JMenuItem("Cadastro de Disciplina");
		mitemCadastDisc.setHorizontalTextPosition(SwingConstants.CENTER);
		mitemCadastDisc.setHorizontalAlignment(SwingConstants.LEFT);
		mitemCadastDisc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setPanel(panelCadListDisc);
			}
		});
		menuDisciplinas.add(mitemCadastDisc);
		
		JMenuItem mitemEditDiscCur = new JMenuItem("Editar Disciplinas do Curso");
		mitemEditDiscCur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setPanel(panelEditDisc);
				
			}
		});
		menuDisciplinas.add(mitemEditDiscCur);
		
		JMenuItem mitemLancrNota = new JMenuItem("Lançar Nota");
		mitemLancrNota.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setPanel(panelLancNota);
			}
		});
		menuDisciplinas.add(mitemLancrNota);
		
		JMenu mnProfessor = new JMenu("Professor");
		menuBar.add(mnProfessor);
		
		JMenuItem mitemCadProf = new JMenuItem("Cadastro de Professor");
		mitemCadProf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setPanel(panelCadProfessor);
			}
		});
		mnProfessor.add(mitemCadProf);
		
		JMenu mnAluno = new JMenu("Aluno");
		menuBar.add(mnAluno);
		
		JMenuItem mitemCadAlunCur = new JMenuItem("Cadastro de Aluno");
		mitemCadAlunCur.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setPanel(panelAluno);
			}
		});
		mnAluno.add(mitemCadAlunCur);
		
		JMenuItem mitemListExAlun = new JMenuItem("Listar Ex-Alunos");
		mitemListExAlun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setPanel(panelExAlunos);
			}
		});
		mnAluno.add(mitemListExAlun);
		
		JMenuItem mitemListAlun = new JMenuItem("Listar Aluno");
		mitemListAlun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setPanel(panelListarAlunos);
			}
		});
		mnAluno.add(mitemListAlun);
		
		JMenuItem mitemGerHr = new JMenuItem("Gerar Horário");
		mitemGerHr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setPanel(panelQuadroHorario);
			}
		});
		mnAluno.add(mitemGerHr);
		
		
		JLabel lbCurso = new JLabel("Curso");
		lbCurso.setHorizontalAlignment(SwingConstants.CENTER);
		lbCurso.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbCurso.setBounds(250, 11, 121, 68);
		panelHome.add(lbCurso);
		
		JLabel lbDiscASCad = new JLabel("Disciplinas a serem cadastradas:");
		lbDiscASCad.setHorizontalAlignment(SwingConstants.LEFT);
		lbDiscASCad.setBounds(26, 144, 197, 14);
		panelHome.add(lbDiscASCad);
		
		JLabel lbNomeDoCurso = new JLabel("Nome do curso: *");
		lbNomeDoCurso.setHorizontalAlignment(SwingConstants.LEFT);
		lbNomeDoCurso.setBounds(26, 107, 197, 14);
		panelHome.add(lbNomeDoCurso);
		
		JLabel lbHorASCad = new JLabel("Horários a serem cadastrados:");
		lbHorASCad.setHorizontalAlignment(SwingConstants.LEFT);
		lbHorASCad.setBounds(26, 183, 197, 14);
		panelHome.add(lbHorASCad);
		
		JLabel lbAlunosASer = new JLabel("Alunos a serem cadastrados");
		lbAlunosASer.setHorizontalAlignment(SwingConstants.LEFT);
		lbAlunosASer.setBounds(26, 226, 197, 14);
		panelHome.add(lbAlunosASer);
		
		JLabel lblNewLabel = new JLabel("* Obrigatório.");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBounds(26, 266, 151, 14);
		panelHome.add(lblNewLabel);
		
		
		frame.getContentPane().add(panelLancNota);
		frame.getContentPane().add(panelEditDisc);
		frame.getContentPane().add(panelQuadroHorario);
		frame.getContentPane().add(panelExAlunos);
		frame.getContentPane().add(panelListarAlunos);
		frame.getContentPane().add(panelAltHorario);
		frame.getContentPane().add(panelCursoHorarios);
		frame.getContentPane().add(panelCursoDisciplinas);
		frame.getContentPane().add(panelCursos);
		frame.getContentPane().add(panelAluno);
		frame.getContentPane().add(panelHome);
		frame.getContentPane().add(panelCadAula);
		frame.getContentPane().add(panelCadListDisc);
		frame.getContentPane().add(panelHorario);
		frame.getContentPane().add(panelCadProfessor);
		frame.getContentPane().add(menuBar);
	}
	public void setPanel(JPanel p)
	{
		
		panelLancNota.setVisible(false);
		panelQuadroHorario.setVisible(false);
		panelEditDisc.setVisible(false);
		panelExAlunos.setVisible(false);
		panelListarAlunos.setVisible (false);
		panelAltHorario.setVisible(false);
		panelCursoHorarios.setVisible(false);
		panelCursoDisciplinas.setVisible(false);
		panelCursos.setVisible(false);
		panelAluno.setVisible(false);
		panelCadAula.setVisible(false);
		panelHome.setVisible(false);
		panelHorario.setVisible(false);
		panelCadListDisc.setVisible(false);
		panelCadProfessor.setVisible(false);
		p.setVisible(true);
	}

	public static JComboBox<Aluno> getCbAlunosASer() {
		return cbAlunosASer;
	}

	public static void setCbAlunosASer(Aluno e) {
		TelaQ2.cbAlunosASer.addItem(e);
	}

	public JTextField getTfNomeCurso() {
		return tfNomeCurso;
	}

	public void setTfNomeCurso(String s) {
		this.tfNomeCurso.setText(s);
	}

	public static JComboBox<Horario> getCbHrASCad() {
		return cbHrASCad;
	}

	public static void setCbHrASCad(Horario e){
		TelaQ2.cbHrASCad.addItem(e);
	}

	public static JComboBox<Disciplina> getCbDiscASCad() {
		return cbDiscASCad;
	}

	public static void setCbDiscASCad(Disciplina e) {
		TelaQ2.cbDiscASCad.addItem(e);
	}

	public static JFrame getFrame() {
		return frame;
	}
}