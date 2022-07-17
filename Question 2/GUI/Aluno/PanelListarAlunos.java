package prova03112021POO.q2.GUI.Aluno;

import javax.swing.JPanel;
import java.awt.Rectangle;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import prova03112021POO.q2.GUI.Curso.PanelCursos;
import prova03112021POO.q2.src.Aluno;
import prova03112021POO.q2.src.MeuCurso;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import prova03112021POO.q2.src.Nota;
import prova03112021POO.q2.src.Disciplina;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelListarAlunos extends JPanel {

	private static final long serialVersionUID = -7988450051587713990L;
	
	private static JComboBox<MeuCurso> cbCursos;
	private static JComboBox<Aluno> cbAlunos;
	private static JComboBox<Nota> cblistNotDiscAtiv;
	private static JComboBox<Disciplina> cbListDiscConcAluno;
	private static JComboBox<Nota> cbListNtsDiscConcAluno;
	private static JComboBox<Disciplina> cbDiscNC; 
	
	public PanelListarAlunos() {
		
		setVisible(false);
		setBounds(new Rectangle(10, 33, 631, 597));
		setLayout(null);
		
		
		cbCursos = new JComboBox<>();
		cbCursos.setBounds(116, 137, 338, 22);
		add(cbCursos);
		
		cbAlunos = new JComboBox<>();
		cbAlunos.setBounds(116, 180, 338, 22);
		add(cbAlunos);
		
		cbDiscNC = new JComboBox<>();
		cbDiscNC.setBounds(10, 459, 260, 24);
		add(cbDiscNC);
		
		cblistNotDiscAtiv = new JComboBox<Nota>();
		cblistNotDiscAtiv.setBounds(10, 262, 260, 24);
		add(cblistNotDiscAtiv);
		
		cbListDiscConcAluno= new JComboBox<Disciplina>();
		cbListDiscConcAluno.setBounds(10, 387, 260, 24);
		add(cbListDiscConcAluno);
		
		cbListNtsDiscConcAluno = new JComboBox<Nota>();
		cbListNtsDiscConcAluno.setBounds(10, 327, 260, 24);
		add(cbListNtsDiscConcAluno);
		
		JButton btnListCur = new JButton("Exibir Cursos");
		btnListCur.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				try 
				{
					cbCursos.removeAllItems();
					MeuCurso mc;
					for(int i = 0; i < PanelCursos.getCbCurCad().getItemCount() ; i++)
					{					
						mc = (MeuCurso) PanelCursos.getCbCurCad().getSelectedItem();
						cbCursos.addItem(mc);
					}
				}
				catch(Exception ex)
				{
					
				}
			}
		});
		btnListCur.setBounds(464, 137, 140, 23);
		add(btnListCur);
		
		JButton btnListarAlunos = new JButton("Exibir Alunos");
		btnListarAlunos.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					cbAlunos.removeAllItems();
					Aluno a;
					MeuCurso mc = (MeuCurso) cbCursos.getSelectedItem();
					for(int i = 0; i < mc.listaAlunos.size(); i++)
					{
						a = mc.listaAlunos.get(i);
						cbAlunos.addItem(a);
					}
				}
				catch(Exception ex)
				{
					
				}
			}
		});
		btnListarAlunos.setBounds(464, 180, 140, 23);
		add(btnListarAlunos);
		
		JButton btnDiscNC = new JButton("Exibir Disciplinas Ainda não Conclúidas");
		btnDiscNC.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					getCbDiscNC().removeAllItems();
					Aluno a = (Aluno) getCbAlunos().getSelectedItem();
					Disciplina d;
					for(int i = 0; i < a.getListaDiscAtiva().size(); i++)
					{
						d = a.getListaDiscAtiva().get(i);
						getCbDiscNC().addItem(d);
					}
				}
				catch(Exception ex)
				{
					
				}
			}
		});
		btnDiscNC.setBounds(297, 460, 260, 23);
		add(btnDiscNC);
		
		JButton btnExListNDiscAtiv = new JButton("Exibir Notas das Disciplinas Ativas");
		btnExListNDiscAtiv.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					cblistNotDiscAtiv.removeAllItems();
					Aluno a = (Aluno) cbAlunos.getSelectedItem();
					Nota n;
					for(int i = 0; i < a.getListaNotasDiscAtiva().size(); i++)
					{
						n = a.getListaNotasDiscAtiva().get(i);
						cblistNotDiscAtiv.addItem(n);
					}
				}
				catch(Exception ex)
				{
					
				}
			}
		});
		btnExListNDiscAtiv.setBounds(297, 263, 260, 23);
		add(btnExListNDiscAtiv);
		
		JButton btnDiscConc = new JButton("Exibir Disciplinas Concluídas");
		btnDiscConc.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				try 
				{
					cbListDiscConcAluno.removeAllItems();
					Aluno a = (Aluno) cbAlunos.getSelectedItem();
					Disciplina d;
					for(int i = 0; i < a.getListaDiscConc().size(); i++)
					{
						d = a.getListaDiscConc().get(i);
						cbListDiscConcAluno.addItem(d);
					}
				}
				catch(Exception ex)
				{
					
				}
			}
		});
		btnDiscConc.setBounds(297, 328, 260, 23);
		add(btnDiscConc);
		
		JButton btnListNDiscConc = new JButton("Exibir Notas das Disciplinas Concluídas");
		btnListNDiscConc.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					cbListNtsDiscConcAluno.removeAllItems();
					Aluno a = (Aluno) cbAlunos.getSelectedItem();
					Nota n;
					for(int i = 0; i < a.getListaNotasDiscConc().size(); i++) 
					{
						n = a.getListaNotasDiscConc().get(i);
						cbListNtsDiscConcAluno.addItem(n);
					}
				}
				catch(Exception ex)
				{
					
				}
			}
		});
		btnListNDiscConc.setBounds(297, 388, 260, 23);
		add(btnListNDiscConc);

		JLabel lblCurso = new JLabel("Curso:");
		lblCurso.setBounds(10, 141, 72, 14);
		add(lblCurso);
		
		JLabel lblAlunos = new JLabel("Alunos:");
		lblAlunos.setBounds(10, 184, 72, 14);
		add(lblAlunos);
		
		JLabel lblListAlun = new JLabel("Lista de Alunos");
		lblListAlun.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblListAlun.setHorizontalAlignment(SwingConstants.CENTER);
		lblListAlun.setBounds(237, 38, 140, 47);
		add(lblListAlun);
		
		JLabel lblListaDeNotas = new JLabel("Lista de notas das disciplinas ativas:");
		lblListaDeNotas.setHorizontalAlignment(SwingConstants.LEFT);
		lblListaDeNotas.setBounds(10, 232, 225, 14);
		add(lblListaDeNotas);
		
		JLabel lblListaDeDiscConc = new JLabel("Lista de disciplinas concluídas:");
		lblListaDeDiscConc.setHorizontalAlignment(SwingConstants.LEFT);
		lblListaDeDiscConc.setBounds(10, 302, 261, 14);
		add(lblListaDeDiscConc);
		
		JLabel lblListaDeNotasDiscConc = new JLabel("Lista de notas das disciplinas concluídas:");
		lblListaDeNotasDiscConc.setHorizontalAlignment(SwingConstants.LEFT);
		lblListaDeNotasDiscConc.setBounds(9, 362, 261, 14);
		add(lblListaDeNotasDiscConc);
		
		JLabel lblDiscNC = new JLabel("Lista de disciplinas ainda não concluídas:");
		lblDiscNC.setBounds(10, 434, 236, 14);
		add(lblDiscNC);
	}

	public static JComboBox<MeuCurso> getCbCursos() {
		return cbCursos;
	}

	public static void setCbCursos(MeuCurso e) {
		PanelListarAlunos.cbCursos.addItem(e);
	}

	public static JComboBox<Aluno> getCbAlunos() {
		return cbAlunos;
	}

	public static void setCbAlunos(Aluno e) {
		PanelListarAlunos.cbAlunos.addItem(e);
	}

	public static JComboBox<Nota> getCblistNotDiscAtiv() {
		return cblistNotDiscAtiv;
	}

	public static void setCblistNotDiscAtiv(Nota e) {
		PanelListarAlunos.cblistNotDiscAtiv.addItem(e);;
	}

	public static JComboBox<Disciplina> getCbListDiscConcAluno() {
		return cbListDiscConcAluno;
	}

	public static void setCbListDiscConcAluno(Disciplina e) {
		PanelListarAlunos.cbListDiscConcAluno.addItem(e);
	}

	public static JComboBox<Nota> getCbListNtsDiscConcAluno() {
		return cbListNtsDiscConcAluno;
	}

	public static void setCbListNtsDiscConcAluno(Nota e) {
		PanelListarAlunos.cbListNtsDiscConcAluno.addItem(e);
	}

	public static JComboBox<Disciplina> getCbDiscNC() {
		return cbDiscNC;
	}

	public static void setCbDiscNC(Disciplina e) {
		PanelListarAlunos.cbDiscNC.addItem(e);
	}
	
}
