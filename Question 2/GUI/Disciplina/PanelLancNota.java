package prova03112021POO.q2.GUI.Disciplina;

import javax.swing.JPanel;
import java.awt.Rectangle;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import prova03112021POO.q2.GUI.Curso.PanelCursos;
import prova03112021POO.q2.src.Aluno;
import prova03112021POO.q2.src.Disciplina;
import prova03112021POO.q2.src.MeuCurso;
import prova03112021POO.q2.src.Nota;

import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;

public class PanelLancNota extends JPanel {
	
	private static final long serialVersionUID = 2130933618111729034L;
	protected static JComboBox<MeuCurso> cbCursos;
	protected static JButton btnExibirAlunos;
	protected static JComboBox<Disciplina> cbDisciplinas;
	protected static JComboBox<Aluno> cbAlunos;
	private JTextField tfNota;

	public PanelLancNota() {
		setVisible(false);
		setBounds(new Rectangle(10, 33, 631, 597));
		setLayout(null);
		
		cbCursos = new JComboBox<>();
		cbCursos.setBounds(101, 118, 373, 22);
		add(cbCursos);
		
		cbDisciplinas = new JComboBox<>();
		cbDisciplinas.setBounds(101, 155, 373, 22);
		add(cbDisciplinas);
		
		cbAlunos = new JComboBox<Aluno>();
		cbAlunos.setBounds(101, 196, 373, 22);
		add(cbAlunos);
		
		tfNota = new JTextField();
		tfNota.setBounds(101, 240, 373, 20);
		add(tfNota);
		tfNota.setColumns(10);
		
		JButton btnExCur = new JButton("Exibir Cursos");
		btnExCur.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					getCbCursos().removeAllItems();
					MeuCurso c;
					for(int i = 0; i < PanelCursos.getCbCurCad().getItemCount(); i++)
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
		btnExCur.setBounds(484, 118, 137, 23);
		add(btnExCur);
		
		JButton btnListDisc = new JButton("Exibir Disciplinas");
		btnListDisc.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					getCbDisciplinas().removeAllItems();
					MeuCurso c = (MeuCurso) getCbCursos().getSelectedItem();
					Disciplina d;
					for(int i = 0; i < c.getListaDisc().size(); i++)
					{
						d = c.getListaDisc().get(i);
						getCbDisciplinas().addItem(d);
					}
				}
				catch(Exception ex)
				{
					
				}
			}
		});
		btnListDisc.setBounds(484, 155, 137, 23);
		add(btnListDisc);
		
		JButton btnAlterarNota = new JButton("Lançar Nota");
		btnAlterarNota.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					Double nota = Double.parseDouble(tfNota.getText());
					Disciplina d = (Disciplina) cbDisciplinas.getSelectedItem();
					Aluno a = (Aluno) cbAlunos.getSelectedItem();
					Nota n = new Nota(nota, d);
					a.setListaNotasDiscAtiva(n);
				}
				catch(Exception ex)
				{
					
				}
			}
		});
		btnAlterarNota.setBounds(484, 239, 137, 23);
		add(btnAlterarNota);
		
		JButton btnExibirAlunos = new JButton("Exibir Alunos");
		btnExibirAlunos.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					getCbAlunos().removeAllItems();
					Disciplina d = (Disciplina) cbDisciplinas.getSelectedItem();
					Aluno a;
					for(int i = 0; i < d.getListaAlunos().size(); i++)
					{
						a = d.getListaAlunos().get(i);
						cbAlunos.addItem(a);
					}
				}
				catch(Exception ex)
				{
					
				}
			}
		});
		btnExibirAlunos.setBounds(484, 196, 137, 23);
		add(btnExibirAlunos);
		
		JLabel lblNota = new JLabel("Disciplina:");
		lblNota.setBounds(10, 159, 115, 14);
		add(lblNota);
		
		JLabel lblLancNota = new JLabel("Lançamento de Nota");
		lblLancNota.setHorizontalAlignment(SwingConstants.CENTER);
		lblLancNota.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLancNota.setBounds(220, 39, 203, 42);
		add(lblLancNota);
		
		JLabel lbCurso = new JLabel("Curso:");
		lbCurso.setBounds(10, 122, 115, 14);
		add(lbCurso);
		
		JLabel lblAluno = new JLabel("Aluno: ");
		lblAluno.setBounds(10, 200, 83, 14);
		add(lblAluno);
				
		JLabel lblNewLabel = new JLabel("Nota: ");
		lblNewLabel.setBounds(10, 243, 83, 14);
		add(lblNewLabel);
	}

	public static JComboBox<MeuCurso> getCbCursos() {
		return cbCursos;
	}

	public static JComboBox<Disciplina> getCbDisciplinas() {
		return cbDisciplinas;
	}

	public static JComboBox<Aluno> getCbAlunos() {
		return cbAlunos;
	}
	
}
