package prova03112021POO.q2.GUI.Professor;

import javax.swing.JPanel;
import java.awt.Rectangle;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;

import prova03112021POO.q2.GUI.Curso.TelaQ2;
import prova03112021POO.q2.GUI.Disciplina.PanelCadListDisc;

import prova03112021POO.q2.src.Professor;

import javax.swing.JTextField;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelCadProfessor extends JPanel {
	
	private static final long serialVersionUID = -5934762127246733142L;

	protected JTextField tfNomeProf;
	protected JTextField tfDataNasc;
	protected JTextField tfCpfProf;
	protected JButton btnInserirProfessor;

	
	public PanelCadProfessor() {
		setVisible(false);
		setBounds(new Rectangle(10, 33, 631, 597));
		setLayout(null);
		
		JLabel lblCadProf = new JLabel("Cadastro de Professor");
		lblCadProf.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadProf.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCadProf.setBounds(175, 49, 264, 37);
		add(lblCadProf);
		
		tfNomeProf = new JTextField();
		tfNomeProf.setColumns(10);
		tfNomeProf.setBounds(294, 136, 248, 24);
		add(tfNomeProf);
		
		JLabel lblNomeProf = new JLabel("Nome:");
		lblNomeProf.setHorizontalAlignment(SwingConstants.LEFT);
		lblNomeProf.setBounds(80, 139, 204, 14);
		add(lblNomeProf);
		
		JLabel lblDataNascProf = new JLabel("Data de nascimento:");
		lblDataNascProf.setHorizontalAlignment(SwingConstants.LEFT);
		lblDataNascProf.setBounds(80, 176, 204, 14);
		add(lblDataNascProf);
		
		tfDataNasc = new JTextField();
		tfDataNasc.setColumns(10);
		tfDataNasc.setBounds(294, 171, 248, 24);
		add(tfDataNasc);
		
		JLabel lblCpf = new JLabel("Cpf (sem caracteres):");
		lblCpf.setHorizontalAlignment(SwingConstants.LEFT);
		lblCpf.setBounds(80, 211, 204, 14);
		add(lblCpf);
		
		tfCpfProf = new JTextField();
		tfCpfProf.setColumns(10);
		tfCpfProf.setBounds(294, 206, 248, 24);
		add(tfCpfProf);
		
		btnInserirProfessor = new JButton("Inserir Professor");
		btnInserirProfessor.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					Professor p = new Professor();
					String nome = tfNomeProf.getText();
					String dataNasc = tfDataNasc.getText();
					long cpf = Long.parseLong(tfCpfProf.getText());
					p.setNome(nome);
					p.setDataNasc(dataNasc);
					p.setCpfSemHifen(cpf);
					PanelCadListDisc.cbProfCad.addItem(p);
					
				}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(TelaQ2.getFrame(),"Erro ao inserir professor.");
				}
				
			}
		});
		btnInserirProfessor.setBounds(247, 520, 132, 23);
		add(btnInserirProfessor);

	}
}
