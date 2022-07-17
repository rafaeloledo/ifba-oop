package prova03112021POO.q2.GUI.Horario;

import javax.swing.JPanel;
import java.awt.Rectangle;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import prova03112021POO.q2.src.Horario;
import prova03112021POO.q2.src.MeuCurso;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import prova03112021POO.q2.GUI.Aula.PanelCadAula;
import prova03112021POO.q2.GUI.Curso.PanelCursos;
import prova03112021POO.q2.GUI.Curso.TelaQ2;
import javax.swing.DefaultComboBoxModel;

public class PanelAltHorario extends JPanel {

	
	private static final long serialVersionUID = 8081422472621500752L;
	private JTextField tfHraIn;
	private JTextField tfHraFin;
	private JTextField tfMinIn;
	private JTextField tfMinFin;
	public static JComboBox<Horario> cbHrAlt;
	public static JComboBox<MeuCurso> cbCursosAltHr;
	public static JComboBox<String> cbDiaSem;
	
	public PanelAltHorario() {
		
		setVisible(false);
		setBounds(new Rectangle(10, 33, 631, 597));
		setLayout(null);
		
		tfHraIn = new JTextField();
		tfHraIn.setColumns(10);
		tfHraIn.setBounds(297, 322, 104, 20);
		add(tfHraIn);
		
		tfHraFin = new JTextField();
		tfHraFin.setColumns(10);
		tfHraFin.setBounds(297, 347, 104, 20);
		add(tfHraFin);
		
		tfMinIn = new JTextField();
		tfMinIn.setColumns(10);
		tfMinIn.setBounds(448, 322, 104, 20);
		add(tfMinIn);
		
		tfMinFin = new JTextField();
		tfMinFin.setColumns(10);
		tfMinFin.setBounds(448, 347, 104, 20);
		add(tfMinFin);
		
		cbHrAlt = new JComboBox<Horario>();
		cbHrAlt.setBounds(114, 202, 369, 24);
		add(cbHrAlt);
		
		JLabel lblNewLabel = new JLabel("Alterar Horários");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(226, 25, 190, 52);
		add(lblNewLabel);
		
		JLabel lbHrAAlt = new JLabel("Horário a alterar:");
		lbHrAAlt.setBounds(10, 207, 154, 14);
		add(lbHrAAlt);
		
		JLabel lblNovaHoraDe = new JLabel("Nova hora de início:");
		lblNovaHoraDe.setBounds(72, 325, 139, 14);
		add(lblNovaHoraDe);
		
		JLabel lblNovaHoraDe_1 = new JLabel("Nova hora de fim:");
		lblNovaHoraDe_1.setBounds(72, 350, 139, 14);
		add(lblNovaHoraDe_1);
		
		
		JLabel lblHifen = new JLabel("-");
		lblHifen.setVerticalAlignment(SwingConstants.TOP);
		lblHifen.setHorizontalAlignment(SwingConstants.CENTER);
		lblHifen.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblHifen.setBounds(411, 321, 27, 20);
		add(lblHifen);
		
		JLabel lblHifen1 = new JLabel("-");
		lblHifen1.setHorizontalAlignment(SwingConstants.CENTER);
		lblHifen1.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblHifen1.setBounds(411, 347, 27, 20);
		add(lblHifen1);
		
		JButton bAltHr = new JButton("Exibir Horários");
		bAltHr.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				cbHrAlt.removeAllItems();
				Horario h;
				MeuCurso mc;
				for(int i =0; i < PanelCursos.getCbCurCad().getItemCount(); i++)
				{
					mc = PanelCursos.getCbCurCad().getItemAt(i);
					for(int j = 0; j < mc.listaHorarios.size(); j++)
					{
						h = mc.listaHorarios.get(j);
						PanelAltHorario.cbHrAlt.addItem(h);
					}
				}
			}
		});
		bAltHr.setBounds(493, 203, 123, 23);
		add(bAltHr);
		
		JButton btnAltHr = new JButton("Alterar/Criar");
		btnAltHr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try 
				{
				MeuCurso mc = (MeuCurso) cbCursosAltHr.getSelectedItem();
				Horario h = (Horario) cbHrAlt.getSelectedItem();
				String hrIn = tfHraIn.getText(), hrFin = tfHraFin.getText(), mnIn = tfMinIn.getText(),
						mnFin = tfMinFin.getText();
				if(h != null) {
					for(int i = 0; i < mc.listaHorarios.size(); i++)
					{
						if(h == mc.listaHorarios.get(i))
						{
							mc.listaHorarios.get(i).setHoraFin(hrFin);
							mc.listaHorarios.get(i).setHoraIn(hrIn);
							mc.listaHorarios.get(i).setMinFin(mnFin);
							mc.listaHorarios.get(i).setMinIn(mnIn);
							mc.listaHorarios.get(i).setDuracao();
						}
					}
				}
				else
				{
					String d = (String) cbDiaSem.getSelectedItem();
					JComboBox<Horario> ref = TelaQ2.getCbHrASCad();
					JComboBox<Horario> ref1 = PanelCadAula.cbHorariosAula;
					h = new Horario(hrIn, mnIn, hrFin, mnFin, d);
					ref.addItem(h);
					ref1.addItem(h);
					mc.listaHorarios.add(h);
				}
				}
				catch(Exception ex )
				{
					
				}
			}
		});
		btnAltHr.setBounds(272, 457, 104, 23);
		add(btnAltHr);
		
		JLabel lblNewLabel_1 = new JLabel("Curso:");
		lblNewLabel_1.setBounds(10, 156, 77, 14);
		add(lblNewLabel_1);
		
		cbCursosAltHr = new JComboBox<MeuCurso>();
		cbCursosAltHr.setBounds(114, 151, 369, 24);
		add(cbCursosAltHr);
		
		JButton btnListCur = new JButton("Listar Cursos");
		btnListCur.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				cbCursosAltHr.removeAllItems();
				MeuCurso mc;
				for(int i = 0; i < PanelCursos.getCbCurCad().getItemCount(); i++)
				{
					mc = PanelCursos.getCbCurCad().getItemAt(i);
					cbCursosAltHr.addItem(mc);
				}
			}
		});
		btnListCur.setBounds(493, 152, 123, 23);
		add(btnListCur);
		
		cbDiaSem = new JComboBox<String>();
		cbDiaSem.setModel(new DefaultComboBoxModel<String>(new String[] {"Segunda-Feira", "Terça-Feira", "Quarta-Feira", "Quinta-Feira", "Sexta-Feira"}));
		cbDiaSem.setBounds(217, 256, 364, 24);
		add(cbDiaSem);
		
		JLabel lblDiaSem = new JLabel("Dia da semana:");
		lblDiaSem.setBounds(10, 261, 144, 14);
		add(lblDiaSem);

	}
}
