package prova03112021POO.q2.GUI.Disciplina;

import javax.swing.JPanel;

import java.awt.Rectangle;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;

import prova03112021POO.q2.GUI.Curso.TelaQ2;
import prova03112021POO.q2.src.Aula;
import prova03112021POO.q2.src.Disciplina;
import prova03112021POO.q2.src.Professor;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class PanelCadListDisc extends JPanel {

	
	private static final long serialVersionUID = 1L;
	
	protected JTextField tfNome;
	protected JTextField tfCodigo;
	protected JTextField tfSigla;
	protected JTextField tfPeriodo;
	protected JButton btnInsDisc ;
	public static JComboBox<Professor> cbProfCad;
	public static JComboBox<Aula> cbAulSem;

	
	public PanelCadListDisc() {
		
		setVisible(false);
		setBounds(new Rectangle(10, 33, 631, 597));
		setLayout(null);
		
		tfNome = new JTextField();
		tfNome.setColumns(10);
		tfNome.setBounds(284, 132, 256, 24);
		add(tfNome);
		
		tfCodigo = new JTextField();
		tfCodigo.setColumns(10);
		tfCodigo.setBounds(284, 167, 256, 24);
		add(tfCodigo);
		
		tfSigla = new JTextField();
		tfSigla.setColumns(10);
		tfSigla.setBounds(284, 202, 256, 24);
		add(tfSigla);
		
		cbAulSem = new JComboBox<Aula>();
		cbAulSem.setBounds(284, 237, 256, 24);
		add(cbAulSem);
		
		cbProfCad = new JComboBox<Professor>();
		cbProfCad.setBounds(284, 272, 256, 24);
		add(cbProfCad);
		
		tfPeriodo = new JTextField();
		tfPeriodo.setColumns(10);
		tfPeriodo.setBounds(284, 307, 256, 24);
		add(tfPeriodo);
		
		btnInsDisc = new JButton("Inserir Disciplina");
		btnInsDisc.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				try {
					if(tfNome.getText().length()>0 && tfCodigo.getText().length()>0 
							&& tfSigla.getText().length()>0) {
						
						JComboBox<Disciplina> ref = TelaQ2.getCbDiscASCad();
						int indexP = cbProfCad.getSelectedIndex();
						int indexA = cbAulSem.getSelectedIndex();
						Disciplina d = new Disciplina();
						String nome = tfNome.getText();
						String codigo = tfCodigo.getText();
						String periodo = tfPeriodo.getText();
						Professor p = cbProfCad.getItemAt(indexP);
						Aula a = cbAulSem.getItemAt(indexA);
						d.setCodigo(codigo);
						d.setPeriodo(periodo);
						d.setNome(nome);
						d.setProfessor(p);
						d.setListaAulasSem(a);
						ref.addItem(d);
					}
					else
					{
						throw new Exception();
					}
				}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(TelaQ2.getFrame(), "Por favor, preencha todos os campos corretamente.");
				}
			}
		});
		btnInsDisc.setBounds(225, 506, 183, 23);
		add(btnInsDisc);

		JLabel lblCadDeAulas = new JLabel("Cadastro de Disciplina");
		lblCadDeAulas.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadDeAulas.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCadDeAulas.setBounds(160, 43, 314, 37);
		add(lblCadDeAulas);
		
		JLabel lblNomeDisc = new JLabel("Nome:");
		lblNomeDisc.setHorizontalAlignment(SwingConstants.LEFT);
		lblNomeDisc.setBounds(70, 135, 204, 14);
		add(lblNomeDisc);
		
		JLabel lblCodDisc = new JLabel("Código:");
		lblCodDisc.setHorizontalAlignment(SwingConstants.LEFT);
		lblCodDisc.setBounds(70, 172, 204, 14);
		add(lblCodDisc);
		
		JLabel lblSiglaDisc = new JLabel("Sigla:");
		lblSiglaDisc.setHorizontalAlignment(SwingConstants.LEFT);
		lblSiglaDisc.setBounds(70, 207, 204, 14);
		add(lblSiglaDisc);
		
		JLabel lblAulSem = new JLabel("Aulas semanais possíveis:");
		lblAulSem.setHorizontalAlignment(SwingConstants.LEFT);
		lblAulSem.setBounds(70, 242, 204, 14);
		add(lblAulSem);
		
		JLabel lblProfCad = new JLabel("Professor da Disciplina:");
		lblProfCad.setHorizontalAlignment(SwingConstants.LEFT);
		lblProfCad.setBounds(70, 277, 204, 14);
		add(lblProfCad);
		
		JLabel lblPeriodo = new JLabel("Período:");
		lblPeriodo.setHorizontalAlignment(SwingConstants.LEFT);
		lblPeriodo.setBounds(70, 312, 204, 14);
		add(lblPeriodo);
	}
}
