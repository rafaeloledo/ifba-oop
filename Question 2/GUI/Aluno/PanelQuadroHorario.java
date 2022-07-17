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

public class PanelQuadroHorario extends JPanel 
{
	
	private static final long serialVersionUID = -7363632374589299769L;
	
	private static JComboBox<MeuCurso> cbCursos;
	private static JComboBox<Horario> cbHorários;
	private static JComboBox<Aluno> cbAlunos;
	
	public PanelQuadroHorario() {
		
		setVisible(false);
		setBounds(new Rectangle(10, 33, 631, 597));
		setLayout(null);
		
		cbCursos = new JComboBox<>();
		cbCursos.setBounds(110, 111, 342, 24);
		add(cbCursos);
		
		cbHorários = new JComboBox<>();
		cbHorários.setBounds(110, 186, 342, 24);
		add(cbHorários);
		
		JButton btnExCursos = new JButton("Exibir Cursos");
		btnExCursos.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					getCbCursos().removeAllItems();
					MeuCurso mc;
					for(int i = 0; i < PanelCursos.getCbCurCad().getItemCount(); i++)
					{
						mc = PanelCursos.getCbCurCad().getItemAt(i);
						getCbCursos().addItem(mc);
					}
				}
				catch(Exception ex)
				{
					
				}
			}
		});
		btnExCursos.setBounds(478, 112, 128, 23);
		add(btnExCursos);
		
		JButton btnExibirAlunos = new JButton("Exibir Alunos");
		btnExibirAlunos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					getCbAlunos().removeAllItems();
					MeuCurso c = (MeuCurso) getCbCursos().getSelectedItem();
					Aluno a;
					for(int i = 0; i < c.getListaAlunos().size(); i++)
					{
						a = c.getListaAlunos().get(i);
						getCbAlunos().addItem(a);
					}
				}
				catch(Exception ex)
				{
					
				}
			}
		});
		btnExibirAlunos.setToolTipText("");
		btnExibirAlunos.setBounds(478, 147, 128, 23);
		add(btnExibirAlunos);
		
		JButton btnExibirHorrios = new JButton("Exibir Horários");
		btnExibirHorrios.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					getCbHorários().removeAllItems();
					Aluno a = (Aluno) getCbAlunos().getSelectedItem();
					Horario h;
					for(int i = 0; i < a.getQuadroHorarios().size(); i++)
					{
						h = a.getQuadroHorarios().get(i);
						getCbHorários().addItem(h);
					}
				}
				catch(Exception ex)
				{
					
				}
			}
		});
		btnExibirHorrios.setBounds(478, 187, 128, 23);
		add(btnExibirHorrios);
		
		cbAlunos = new JComboBox<Aluno>();
		cbAlunos.setBounds(110, 146, 342, 24);
		add(cbAlunos);
		
		JLabel lblQdHrAluno = new JLabel("Quadro de Horários do Aluno");
		lblQdHrAluno.setHorizontalAlignment(SwingConstants.CENTER);
		lblQdHrAluno.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblQdHrAluno.setBounds(168, 34, 284, 60);
		add(lblQdHrAluno);
		
		JLabel lblCurso = new JLabel("Curso:");
		lblCurso.setBounds(10, 116, 46, 14);
		add(lblCurso);
		JLabel lblHorarios = new JLabel("Horários:");
		lblHorarios.setBounds(10, 191, 73, 14);
		add(lblHorarios);
		
		JLabel lblAluno = new JLabel("Aluno: ");
		lblAluno.setBounds(10, 151, 90, 14);
		add(lblAluno);
		
		
	}
	public static JComboBox<MeuCurso> getCbCursos() {
		return cbCursos;
	}
	public static void setCbCursos(MeuCurso e) {
		PanelQuadroHorario.cbCursos.addItem(e);
	}
	public static JComboBox<Horario> getCbHorários() {
		return cbHorários;
	}
	public static void setCbHorários(Horario e){
		PanelQuadroHorario.cbHorários.addItem(e);
	}
	public static JComboBox<Aluno> getCbAlunos() {
		return cbAlunos;
	}
	public static void setCbAlunos(Aluno e) {
		PanelQuadroHorario.cbAlunos.addItem(e);
	}
}