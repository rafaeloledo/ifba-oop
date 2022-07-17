package prova03112021POO.q2.GUI.Curso;

import java.awt.Rectangle;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import prova03112021POO.q2.src.Disciplina;
import prova03112021POO.q2.src.MeuCurso;

import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelCursoDisciplinas extends JPanel {

	private static final long serialVersionUID = 5026258263869492205L;
	
	private static JComboBox<MeuCurso> cbCurso;
	private static JComboBox<Disciplina> cbDisciplinas;

	public PanelCursoDisciplinas() {
		setVisible(false);
		setBounds(new Rectangle(10, 33, 631, 597));
		setLayout(null);
		
		cbDisciplinas = new JComboBox<Disciplina>();
		cbDisciplinas.setBounds(90, 201, 355, 24);
		add(cbDisciplinas);
		cbCurso = new JComboBox<MeuCurso>();
		cbCurso.setBounds(90, 145, 355, 24);
		add(cbCurso);
		
		JButton btnExibirDisc = new JButton("Exibir Disciplinas");
		btnExibirDisc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					if(PanelCursoDisciplinas.getCbCurso().getItemCount() > 0)
					{
						getCbDisciplinas().removeAllItems();
						MeuCurso mc = (MeuCurso) PanelCursoDisciplinas.getCbCurso().getSelectedItem();
						Disciplina d;
						for(int i = 0; i < mc.getListaDisc().size() ; i++)
						{
							d = mc.getListaDisc().get(i);
							getCbDisciplinas().addItem(d);
						}
					}
				}
				catch(Exception ex)
				{
					
				}
			}
		});
		btnExibirDisc.setBounds(459, 202, 162, 23);
		add(btnExibirDisc);
		
		JLabel lblNewLabel = new JLabel("Disciplinas do Curso");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(205, 40, 204, 61);
		add(lblNewLabel);
		
		JLabel lbCurso = new JLabel("Curso: ");
		lbCurso.setBounds(10, 150, 144, 14);
		add(lbCurso);
		
		JLabel lbDisciplinas = new JLabel("Disciplinas:");
		lbDisciplinas.setBounds(10, 206, 144, 14);
		add(lbDisciplinas);
		
		
		JButton btnExibirCursos = new JButton("Exibir Cursos");
		btnExibirCursos.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				if(PanelCursoDisciplinas.getCbCurso().getItemCount() == 0) 
				{
					getCbCurso().removeAllItems();
					MeuCurso mc;
					for(int i = 0; i < PanelCursos.getCbCurCad().getItemCount(); i++)
					{	
						mc = (MeuCurso) PanelCursos.getCbCurCad().getSelectedItem();
						PanelCursoDisciplinas.getCbCurso().addItem(mc);
					}
				}
			}
		});
		btnExibirCursos.setBounds(459, 146, 162, 23);
		add(btnExibirCursos);
		
		JButton btnRemoverDisciplina = new JButton("Remover Disciplina");
		btnRemoverDisciplina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					MeuCurso c = (MeuCurso) getCbCurso().getSelectedItem();
					Disciplina d = (Disciplina) getCbDisciplinas().getSelectedItem();
					c.getListaDisc().remove(d);
				}
				catch(Exception ex)
				{
					
				}
			}
		});
		btnRemoverDisciplina.setBounds(459, 236, 162, 23);
		add(btnRemoverDisciplina);
	}

	public static JComboBox<MeuCurso> getCbCurso() {
		return cbCurso;
	}

	public static void setCbCurso(JComboBox<MeuCurso> cbCurso) {
		PanelCursoDisciplinas.cbCurso = cbCurso;
	}

	public static JComboBox<Disciplina> getCbDisciplinas() {
		return cbDisciplinas;
	}

	public static void setCbDisciplinas(JComboBox<Disciplina> cbDisciplinas) {
		PanelCursoDisciplinas.cbDisciplinas = cbDisciplinas;
	}
	
}
