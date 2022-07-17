package prova03112021POO.q2.GUI.ExAlunos;

import javax.swing.JPanel;
import java.awt.Rectangle;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import prova03112021POO.q2.GUI.Curso.PanelCursos;
import prova03112021POO.q2.src.Aluno;
import prova03112021POO.q2.src.MeuCurso;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelExAlunos extends JPanel {
	
	private static final long serialVersionUID = 3548927876936018101L;
	protected static JButton btnExAlun;
	protected static JComboBox<MeuCurso> cbCurso;
	protected static JComboBox<Aluno> cbExAlun;
	
	public PanelExAlunos() {
		setVisible(false);
		setBounds(new Rectangle(10, 33, 631, 597));
		setLayout(null);
		
		cbCurso = new JComboBox<MeuCurso>();
		cbCurso.setBounds(110, 133, 353, 22);
		add(cbCurso);
		
		cbExAlun = new JComboBox<Aluno>();
		cbExAlun.setBounds(110, 171, 353, 22);
		add(cbExAlun);
		
		JButton btnExAlun = new JButton("Exibir Ex-Alunos");
		btnExAlun.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					cbExAlun.removeAllItems();
					MeuCurso mc = (MeuCurso) cbCurso.getSelectedItem();
					Aluno a;
					for(int i = 0; i < mc.listaExAlunos.size() ; i++)
					{
						a = mc.getListaExAlunos().get(i);
						cbExAlun.addItem(a);
					}
				}
				catch(Exception ex)
				{
					
				}
			}
		});
		btnExAlun.setBounds(473, 171, 148, 23);
		add(btnExAlun);
		
		JButton btnCursos = new JButton("Exibir Cursos");
		btnCursos.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				cbCurso.removeAllItems();
				MeuCurso mc;
				for(int i = 0; i < PanelCursos.getCbCurCad().getItemCount(); i++) 
				{
					mc = PanelCursos.getCbCurCad().getItemAt(i);
					cbCurso.addItem(mc);
				}
				
			}
		});
		btnCursos.setBounds(473, 133, 148, 23);
		add(btnCursos);

		JLabel lblExAlun = new JLabel("Ex-alunos:");
		lblExAlun.setBounds(10, 175, 75, 14);
		add(lblExAlun);
		
		JLabel lblListaExAlun = new JLabel("Lista de Ex-Alunos");
		lblListaExAlun.setHorizontalAlignment(SwingConstants.CENTER);
		lblListaExAlun.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblListaExAlun.setBounds(220, 50, 190, 33);
		add(lblListaExAlun);
		
		JLabel lblCurso = new JLabel("Curso:");
		lblCurso.setBounds(10, 137, 46, 14);
		add(lblCurso);
	}
}
