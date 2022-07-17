
package prova03112021POO.q2.GUI.Aula;

import javax.swing.JPanel;
import java.awt.Rectangle;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;

import javax.swing.JComboBox;

import prova03112021POO.q2.GUI.Curso.TelaQ2;
import prova03112021POO.q2.GUI.Disciplina.PanelCadListDisc;
import prova03112021POO.q2.src.Aula;
import prova03112021POO.q2.src.Horario;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class PanelCadAula extends JPanel {

	public static JComboBox<Horario> cbHorariosAula;
	
	private static final long serialVersionUID = 278480976446665830L;

	public PanelCadAula() {
		setVisible(false);
		setBounds(new Rectangle(10, 33, 631, 597));
		setLayout(null);
		
		cbHorariosAula = new JComboBox<Horario>();
		cbHorariosAula.setBounds(236, 173, 364, 24);
		add(cbHorariosAula);
		
		JButton btnCadHrario = new JButton("Cadastrar Aula");
		btnCadHrario.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				try 
				{
					Horario hor = (Horario) PanelCadAula.cbHorariosAula.getSelectedItem();
					hor.setDuracao();
					double dur = hor.getDuracaoH();
					Aula a = new Aula();
					a.setHorario(hor);
					a.setDuracaoH(dur);
					a.setDiaDaSem(hor.getDia());
					PanelCadListDisc.cbAulSem.addItem(a);
				}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(TelaQ2.getFrame(), "Erro ao cadastrar aula");
				}
			}
		});
		btnCadHrario.setBounds(249, 493, 140, 23);
		add(btnCadHrario);

		JLabel lblCadAula = new JLabel("Cadastro de Aula");
		lblCadAula.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadAula.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCadAula.setBounds(191, 41, 245, 40);
		add(lblCadAula);
		
		JLabel lblHorriosDisponveis = new JLabel("Horários disponíveis:");
		lblHorriosDisponveis.setHorizontalAlignment(SwingConstants.LEFT);
		lblHorriosDisponveis.setBounds(29, 178, 197, 14);
		add(lblHorriosDisponveis);
	}
}
