
package prova03112021POO.q2.GUI.Curso;

import java.awt.Rectangle;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import prova03112021POO.q2.src.Horario;
import prova03112021POO.q2.src.MeuCurso;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelCursoHorarios extends JPanel {

	private static final long serialVersionUID = -2488002021631054994L;
	
	private static JComboBox<MeuCurso> cbCursos;
	private static JComboBox<Horario> cbHorarios;
	
	public PanelCursoHorarios() {
		
		setVisible(false);
		setBounds(new Rectangle(10, 33, 631, 597));
		setLayout(null);
		
		cbCursos = new JComboBox<>();
		cbCursos.setBounds(114, 108, 363, 24);
		add(cbCursos);
		
		cbHorarios = new JComboBox<Horario>();
		cbHorarios.setBounds(114, 143, 363, 24);
		add(cbHorarios);
		
		JButton bExibHr = new JButton("Exibir Horários");
		bExibHr.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				getCbHorarios().removeAllItems();
				MeuCurso mc = (MeuCurso) getCbCursos().getSelectedItem();
				Horario h;
				for(int i = 0; i < mc.getListHorarios().size(); i++)
				{
					h = mc.getListHorarios().get(i);
					getCbHorarios().addItem(h);
				}
			}
		});
		bExibHr.setBounds(498, 144, 127, 23);
		add(bExibHr);
		
				
		JButton btnExibirCursos = new JButton("Exibir Cursos");
		btnExibirCursos.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					cbCursos.removeAllItems();
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
		btnExibirCursos.setBounds(498, 109, 127, 23);
		add(btnExibirCursos);
		
		JLabel lbHrCurso = new JLabel("Horários do Curso");
		lbHrCurso.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbHrCurso.setHorizontalAlignment(SwingConstants.CENTER);
		lbHrCurso.setBounds(209, 32, 189, 39);
		add(lbHrCurso);
		
		JLabel lbListCurs = new JLabel("Cursos:");
		lbListCurs.setBounds(10, 113, 118, 14);
		add(lbListCurs);
		
		JLabel lbHorarios = new JLabel("Horários:");
		lbHorarios.setBounds(10, 148, 118, 14);
		add(lbHorarios);
	}

	public static JComboBox<MeuCurso> getCbCursos() {
		return cbCursos;
	}

	public static void setCbCursos(MeuCurso e) {
		PanelCursoHorarios.cbCursos.addItem(e);
	}

	public static JComboBox<Horario> getCbHorarios() {
		return cbHorarios;
	}

	public static void setCbHorarios(Horario e) {
		PanelCursoHorarios.cbHorarios.addItem(e);
	}
	
}
