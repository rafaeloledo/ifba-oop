package prova03112021POO.q2.GUI.Aluno;
import javax.swing.JPanel;
import java.awt.Rectangle;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import prova03112021POO.q2.GUI.Curso.PanelCursos;
import prova03112021POO.q2.src.Aluno;
import prova03112021POO.q2.src.Disciplina;
import prova03112021POO.q2.src.MeuCurso;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelCursoAlunos extends JPanel {

	private static final long serialVersionUID = -8134045021468140561L;
	private JButton btnExDiscAlun;
	private JComboBox<Aluno> cbAlunos;
	private JComboBox<Disciplina> cbDisc;
	private JComboBox<MeuCurso> cbCursos;
	
	public PanelCursoAlunos() 
	{
		
		setVisible(false);
		setBounds(new Rectangle(10, 33, 631, 597));
		setLayout(null);
		
		cbCursos = new JComboBox<>();
		cbCursos.setBounds(130, 120, 319, 24);
		add(cbCursos);
		
		cbDisc = new JComboBox<>();
		cbDisc.setBounds(33, 244, 319, 24);
		add(cbDisc);
		
		cbAlunos = new JComboBox<>();
		cbAlunos.setBounds(130, 163, 319, 24);
		add(cbAlunos);
		
		JButton btnExCur = new JButton("Exibir Cursos");
		btnExCur.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					getCbCursos().removeAllItems();
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
		btnExCur.setBounds(490, 121, 112, 23);
		add(btnExCur);
		
		JButton btnExAlun = new JButton("Exibir Alunos");
		btnExAlun.addActionListener(new ActionListener() {
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
		btnExAlun.setBounds(490, 164, 112, 23);
		add(btnExAlun);
		
		JButton btnExDiscAlun = new JButton("Exibir Disciplinas do Aluno");
		btnExDiscAlun.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					getCbDisc().removeAllItems();
					Aluno a = (Aluno) getCbAlunos().getSelectedItem();
					Disciplina d;
					for(int i = 0; i < a.getListaDiscAtiva().size(); i++)
					{
						d = a.getListaDiscAtiva().get(i);
						getCbDisc().addItem(d);
					}
				}
				catch(Exception ex)
				{
					
				}
			}
		});
		btnExDiscAlun.setBounds(378, 245, 212, 23);
		add(btnExDiscAlun);
		
		JButton btnDefDiscAlunSelecCT = new JButton("Definir Disciplina do Aluno Selecionado Como Terminada");
		btnDefDiscAlunSelecCT.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					Aluno a = (Aluno) getCbAlunos().getSelectedItem();
					Disciplina d = (Disciplina) cbDisc.getSelectedItem();
					a.setListaDiscConc(d);
					a.getListaDiscAtiva().remove(d);
				}
				catch(Exception ex)
				{
					
				}
			}
		});
		btnDefDiscAlunSelecCT.setBounds(33, 304, 371, 23);
		add(btnDefDiscAlunSelecCT);

		JLabel lblAlunosCurso = new JLabel("Alunos do Curso");
		lblAlunosCurso.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlunosCurso.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblAlunosCurso.setBounds(207, 35, 186, 56);
		add(lblAlunosCurso);
		
		JLabel lblCurso = new JLabel("Curso:");
		lblCurso.setBounds(33, 125, 46, 14);
		add(lblCurso);
		
		JLabel lblAlunos = new JLabel("Alunos:");
		lblAlunos.setBounds(33, 168, 46, 14);
		add(lblAlunos);
		
		JLabel lblDisc = new JLabel("Disciplina:");
		lblDisc.setBounds(33, 219, 100, 14);
		add(lblDisc);
	}
	
	public JButton getBtnExDiscAlun() {
		return btnExDiscAlun;
	}
	public JComboBox<Aluno> getCbAlunos() {
		return cbAlunos;
	}
	public void setCbAlunos(Aluno a) {
		this.cbAlunos.addItem(a);
	}
	public JComboBox<Disciplina> getCbDisc() {
		return cbDisc;
	}
	public void setCbDisc(Disciplina a) {
		this.cbDisc.addItem(a);
	}
	public JComboBox<MeuCurso> getCbCursos() {
		return cbCursos;
	}
	public void setCbCursos(MeuCurso a) {
		this.cbCursos.addItem(a); 
	}
}
