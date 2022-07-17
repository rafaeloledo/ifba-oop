package prova03112021POO.q2.GUI.Aluno;

import javax.swing.JPanel;
import java.awt.Rectangle;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import prova03112021POO.q2.GUI.Curso.PanelCursos;
import prova03112021POO.q2.src.Aluno;
import prova03112021POO.q2.src.Horario;
import prova03112021POO.q2.src.MeuCurso;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelAlunoHorario extends JPanel 
{

	private static final long serialVersionUID = -1551750327761516528L;
	private static JComboBox<Horario> cbHor;
	private static JComboBox<MeuCurso> cbCursos;
	private static JComboBox<Aluno> cbAlunos;
	
	public PanelAlunoHorario() 
	{
		
		setVisible(false);
		setBounds(new Rectangle(10, 33, 631, 597));
		setLayout(null);
		
		cbHor = new JComboBox<>();
		cbHor.setBounds(126, 218, 339, 22);
		add(cbHor);
		
		cbCursos = new JComboBox<>();
		cbCursos.setBounds(126, 131, 339, 22);
		add(cbCursos);
		
		cbAlunos = new JComboBox<>();
		cbAlunos.setBounds(126, 175, 339, 24);
		add(cbAlunos);
		
		JButton btnListCur = new JButton("Listar Cursos");
		btnListCur.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					MeuCurso c;
					for(int i = 0; i < PanelCursos.getCbCurCad().getItemCount() ; i++)
					{
						c = PanelCursos.getCbCurCad().getItemAt(i);
						getCbCursos().addItem(c);
					}
				}
				catch(Exception ex)
				{
					
				}
			}
		});
		btnListCur.setBounds(479, 131, 122, 23);
		add(btnListCur);
		
		JButton btnExAlun = new JButton("Exibir Alunos");
		btnExAlun.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					MeuCurso c = (MeuCurso) getCbCursos().getSelectedItem();
					Aluno a;
					for(int i = 0; i < c.getListaAlunos().size(); i++)
					{
						a = c.getListaAlunos().get(i);
						setCbAlunos(a);
					}
				}
				catch(Exception ex)
				{
					
				}
			}
		});
		btnExAlun.setBounds(479, 176, 122, 23);
		add(btnExAlun);
		
		JButton btnCadastrarH = new JButton("Cadastrar Horário");
		btnCadastrarH.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				try
				{
					Horario h = (Horario) getCbHor().getSelectedItem();
					Aluno a = (Aluno) getCbAlunos().getSelectedItem();
					a.getQuadroHorarios().add(h);
				}
				catch(Exception ex)
				{
					
				}
			}
		});
		btnCadastrarH.setBounds(475, 253, 126, 23);
		add(btnCadastrarH);
		
		JButton btnNewButton = new JButton("Exibir Horários");
		btnNewButton.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					cbHor.removeAllItems();
					Aluno a = (Aluno) cbAlunos.getSelectedItem();
					Horario h;
					for(int i = 0; i < a.getQuadroHorarios().size(); i++)
					{
						h = a.getQuadroHorarios().get(i);
						getCbHor().addItem(h);
					}
				}
				catch(Exception ex)
				{
					
				}
			}
		});
		btnNewButton.setBounds(475, 218, 126, 23);
		add(btnNewButton);
		
		JLabel lblCadHorAlun = new JLabel("Cadastro de Horario do Aluno");
		lblCadHorAlun.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadHorAlun.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCadHorAlun.setBounds(184, 40, 280, 58);
		add(lblCadHorAlun);
		
		JLabel lblCurso = new JLabel("Curso:");
		lblCurso.setBounds(10, 135, 71, 14);
		add(lblCurso);
		
		JLabel lblHorDisp = new JLabel("Horários Disponíveis");
		lblHorDisp.setBounds(10, 222, 122, 14);
		add(lblHorDisp);
		
		JLabel lblAlun = new JLabel("Aluno:");
		lblAlun.setBounds(10, 180, 101, 14);
		add(lblAlun);
		
	}

	public static JComboBox<Horario> getCbHor() 
	{
		return cbHor;
	}

	public static void setCbHor(Horario e) 
	{
		PanelAlunoHorario.cbHor.addItem(e);
	}

	public static JComboBox<MeuCurso> getCbCursos() 
	{
		return cbCursos;
	}

	public static void setCbCursos(MeuCurso e) 
	{
		PanelAlunoHorario.cbCursos.addItem(e);
	}

	public static JComboBox<Aluno> getCbAlunos() {
		return cbAlunos;
	}

	public static void setCbAlunos(Aluno e) {
		PanelAlunoHorario.cbAlunos.addItem(e);
	}
	
}
