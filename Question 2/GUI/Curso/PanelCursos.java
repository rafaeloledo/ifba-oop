package prova03112021POO.q2.GUI.Curso;

import java.awt.Rectangle;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;


import prova03112021POO.q2.src.MeuCurso;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelCursos extends JPanel {

	private static final long serialVersionUID = 5450852660136834270L;
	
	private static JComboBox<MeuCurso> cbCurCad;

	public PanelCursos() {
		
		setVisible(false);
		setBounds(new Rectangle(10, 33, 631, 597));
		setLayout(null);
		
		cbCurCad = new JComboBox<>();
		cbCurCad.setBounds(87, 129, 374, 24);
		add(cbCurCad);
		
		JButton btnRemov = new JButton("Remover");
		btnRemov.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					int i = getCbCurCad().getSelectedIndex();
					getCbCurCad().removeItemAt(i);
				}
				catch(Exception ex)
				{
					
				}
			}
		});
		btnRemov.setBounds(488, 130, 133, 23);
		add(btnRemov);
		
		JLabel lbCurCad = new JLabel("Cursos Cadastrados");
		lbCurCad.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lbCurCad.setHorizontalAlignment(SwingConstants.CENTER);
		lbCurCad.setBounds(188, 32, 222, 46);
		add(lbCurCad);
		
		JLabel lbListaCur = new JLabel("Lista:");
		lbListaCur.setBounds(10, 134, 145, 14);
		add(lbListaCur);
		
	}

	public static JComboBox<MeuCurso> getCbCurCad() {
		return cbCurCad;
	}

	public static void setCbCurCad(MeuCurso e) {
		PanelCursos.cbCurCad.addItem(e);
	}
}
