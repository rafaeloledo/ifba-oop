package prova03112021POO.q2.GUI.Horario;

import javax.swing.JPanel;
import java.awt.Rectangle;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import prova03112021POO.q2.GUI.Aula.PanelCadAula;
import prova03112021POO.q2.GUI.Curso.TelaQ2;
import prova03112021POO.q2.src.Horario;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class PanelHorario extends JPanel {

	private static final long serialVersionUID = 3709858639436420412L;
	
	protected JTextField tfHrIn;
	protected JTextField tfHrFn;
	protected JTextField tfMnIn;
	protected JTextField tfMnFn;
	protected JButton btInserirAula;
	private JComboBox<String> cbDiaSem;
	private JLabel lblDiaSem;
	
	public PanelHorario() {
		setVisible(false);
		setBounds(new Rectangle(10, 33, 631, 597));
		setLayout(null);
		
		tfHrIn = new JTextField();
		tfHrIn.setBounds(252, 126, 104, 20);
		add(tfHrIn);
		tfHrIn.setColumns(10);
		
		tfHrFn = new JTextField();
		tfHrFn.setColumns(10);
		tfHrFn.setBounds(252, 151, 104, 20);
		add(tfHrFn);
		
		tfMnIn = new JTextField();
		tfMnIn.setColumns(10);
		tfMnIn.setBounds(403, 126, 104, 20);
		add(tfMnIn);
		
		tfMnFn = new JTextField();
		tfMnFn.setColumns(10);
		tfMnFn.setBounds(403, 151, 104, 20);
		add(tfMnFn);
		
		btInserirAula = new JButton("Inserir Horário");
		btInserirAula.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				JComboBox<Horario> ref = TelaQ2.getCbHrASCad();
				JComboBox<Horario> ref1 = PanelCadAula.cbHorariosAula;
				try
				{
					int index = 1;
					String horaIn = tfHrIn.getText(), minIn = tfMnIn.getText();
					String horaFin = tfHrFn.getText(), minFin = tfMnFn.getText();
					if(horaIn.length()>0 && minIn.length()>0 && horaFin.length()>0 && minFin.length()>0)
					{
						while(index <= ref.getItemCount())
						{
							Horario temp = ref.getItemAt(index-1);
							if(temp!=null) 
							{
								String horaInTemp = temp.getHoraIn();
								String minInTemp = temp.getMinIn();
								String horaFinTemp = temp.getHoraFin();
								String minFinTemp = temp.getMinFin();
								if((horaIn.equalsIgnoreCase(horaInTemp)) && (minIn.equalsIgnoreCase(minInTemp)) && 
										(horaFin.equalsIgnoreCase(horaFinTemp)) &&
										(minFin.equalsIgnoreCase(minFinTemp)))
								{
									JOptionPane.showMessageDialog(TelaQ2.getFrame(), "Já existe este horário");
									throw new Exception();
								}
								
							}
							index++;
						}
						String dia = (String) cbDiaSem.getSelectedItem();
						Horario h = new Horario(horaIn, minIn, horaFin, minFin, dia);
						ref.addItem(h);
						ref1.addItem(h);
					}
					else
					{
						JOptionPane.showMessageDialog(TelaQ2.getFrame(), "Por favor, preencha os campos corretamente.");
						throw new Exception();
					}
				}	
				catch(Exception ex)
				{
					
				}
			}
		});
		btInserirAula.setBounds(213, 504, 195, 23);
		add(btInserirAula);
		
		JLabel lblTitulo = new JLabel("Cadastro de Horário");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setBounds(174, 45, 264, 37);
		add(lblTitulo);
		
		JLabel lblHrIn = new JLabel("Hora de início:");
		lblHrIn.setBounds(87, 129, 139, 14);
		add(lblHrIn);
		
		JLabel lblHrFn = new JLabel("Hora de fim:");
		lblHrFn.setBounds(87, 154, 139, 14);
		add(lblHrFn);
		
		JLabel lblHifen = new JLabel("-");
		lblHifen.setVerticalAlignment(SwingConstants.BOTTOM);
		lblHifen.setHorizontalAlignment(SwingConstants.CENTER);
		lblHifen.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblHifen.setBounds(366, 129, 27, 20);
		add(lblHifen);
		
		JLabel lblHifen1 = new JLabel("-");
		lblHifen1.setHorizontalAlignment(SwingConstants.CENTER);
		lblHifen1.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblHifen1.setBounds(366, 154, 27, 20);
		add(lblHifen1);
		
		cbDiaSem = new JComboBox<String>();
		cbDiaSem.setModel(new DefaultComboBoxModel<String>(new String[] {"Segunda-Feira", "Terça-Feira", "Quarta-Feira", "Quinta-Feira", "Sexta-Feira"}));
		cbDiaSem.setBounds(232, 211, 364, 24);
		add(cbDiaSem);
		
		lblDiaSem = new JLabel("Dia da semana:");
		lblDiaSem.setBounds(25, 216, 144, 14);
		add(lblDiaSem);
		
	}
}
