package prova03112021POO.q2.GUI.Aluno;

import javax.swing.JPanel;
import java.awt.Rectangle;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;

import prova03112021POO.q2.GUI.Curso.PanelCursos;
import prova03112021POO.q2.GUI.Curso.TelaQ2;
import prova03112021POO.q2.src.Aluno;
import prova03112021POO.q2.src.Disciplina;
import prova03112021POO.q2.src.MeuCurso;


import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PanelAluno extends JPanel {
	
	private static final long serialVersionUID = 5413882312813838492L;
	
	private JTextField tfNomeAluno;
	private JTextField tfDataNascAluno;
	private JTextField tfCpfAluno;
	private static JComboBox<MeuCurso> cbCursos;
	private JComboBox<Disciplina> cbListDiscAluno;
	protected JButton btnInserirAluno;
	
	public PanelAluno() {
		
		setVisible(false);
		setBounds(new Rectangle(10, 33, 631, 597));
		setLayout(null);
		
		
		tfNomeAluno = new JTextField();
		tfNomeAluno.setColumns(10);
		tfNomeAluno.setBounds(174, 116, 306, 24);
		add(tfNomeAluno);
		
		
		tfDataNascAluno = new JTextField();
		tfDataNascAluno.setColumns(10);
		tfDataNascAluno.setBounds(174, 151, 306, 24);
		add(tfDataNascAluno);
		
		tfCpfAluno = new JTextField();
		tfCpfAluno.setColumns(10);
		tfCpfAluno.setBounds(174, 186, 306, 24);
		add(tfCpfAluno);
		
		
		cbListDiscAluno = new JComboBox<Disciplina>();
		cbListDiscAluno.setBounds(174, 221, 306, 24);
		add(cbListDiscAluno);
		
		cbCursos = new JComboBox<MeuCurso>();
		cbCursos.setBounds(174, 256, 306, 24);
		add(cbCursos);
		
		btnInserirAluno = new JButton("Inscrever Aluno");
		btnInserirAluno.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				try 
				{
					Aluno a = new Aluno();
					
					String nome = getTfNomeAluno().getText();
					String dataNasc = getTfDataNascAluno().getText();
					String cpf = getTfCpfAluno().getText();
					Disciplina d = (Disciplina) getCbListDiscAluno().getSelectedItem();
					
					a.setNome(nome);
					a.setDataNasc(dataNasc);
					a.setCpf(cpf);
					a.setListaDiscAtiva(d);
					
					TelaQ2.getCbAlunosASer().addItem(a);
				}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(TelaQ2.getFrame(), "Erro ao inserir aluno.");
				}
			}
		});
		btnInserirAluno.setBounds(250, 513, 132, 23);
		add(btnInserirAluno);
		
		JButton btnExCur = new JButton("Exibir Cursos");
		btnExCur.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					getCbCursos().removeAllItems();
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
		btnExCur.setBounds(490, 257, 131, 23);
		add(btnExCur);
		
		JLabel lbCurACad = new JLabel("Curso:");
		lbCurACad.setBounds(22, 261, 261, 14);
		add(lbCurACad);
		
		JLabel lblCadAluno = new JLabel("Cadastro do Aluno");
		lblCadAluno.setHorizontalAlignment(SwingConstants.CENTER);
		lblCadAluno.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCadAluno.setBounds(174, 37, 264, 37);
		add(lblCadAluno);
		
		JLabel lblNomeProf = new JLabel("Nome:");
		lblNomeProf.setHorizontalAlignment(SwingConstants.LEFT);
		lblNomeProf.setBounds(22, 121, 261, 14);
		add(lblNomeProf);
		
		JLabel lblDataDeNascimento = new JLabel("Data de nascimento:");
		lblDataDeNascimento.setHorizontalAlignment(SwingConstants.LEFT);
		lblDataDeNascimento.setBounds(22, 156, 261, 14);
		add(lblDataDeNascimento);
		
		JLabel lblCpf = new JLabel("Cpf:");
		lblCpf.setHorizontalAlignment(SwingConstants.LEFT);
		lblCpf.setBounds(22, 191, 261, 14);
		add(lblCpf);
		
		JLabel lblListaDeDisciplinas = new JLabel("Disciplina:");
		lblListaDeDisciplinas.setHorizontalAlignment(SwingConstants.LEFT);
		lblListaDeDisciplinas.setBounds(22, 226, 261, 14);
		add(lblListaDeDisciplinas);
		
		JButton btnExDisc = new JButton("Exibir Disciplinas");
		btnExDisc.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					getCbListDiscAluno().removeAllItems();
					MeuCurso m = (MeuCurso) getCbCursos().getSelectedItem();
					Disciplina d;
					for(int i = 0; i < m.getListaDisc().size(); i++) 
					{
						d = m.getListaDisc().get(i);
						getCbListDiscAluno().addItem(d);
					}
					
				}
				catch(Exception ex)
				{
					
				}
			}
		});
		btnExDisc.setBounds(490, 222, 131, 23);
		add(btnExDisc);
	}

	public JTextField getTfNomeAluno() {
		return tfNomeAluno;
	}

	public void setTfNomeAluno(String e) {
		this.tfNomeAluno.setText(e);;
	}

	public JTextField getTfDataNascAluno() {
		return tfDataNascAluno;
	}

	public void setTfDataNascAluno(String e) {
		this.tfDataNascAluno.setText(e);
	}

	public JTextField getTfCpfAluno() {
		return tfCpfAluno;
	}

	public void setTfCpfAluno(String e) {
		this.tfCpfAluno.setText(e);
	}

	public JComboBox<Disciplina> getCbListDiscAluno() {
		return cbListDiscAluno;
	}

	public void setCbListDiscAluno(Disciplina e) {
		this.cbListDiscAluno.addItem(e);
	}

	public static JComboBox<MeuCurso> getCbCursos() {
		return cbCursos;
	}

	public static void setCbCursos(MeuCurso e) {
		PanelAluno.cbCursos.addItem(e);
	}
	
	
}
