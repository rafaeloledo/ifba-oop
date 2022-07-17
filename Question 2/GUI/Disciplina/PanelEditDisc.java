package prova03112021POO.q2.GUI.Disciplina;

import javax.swing.JPanel;
import java.awt.Rectangle;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextField;

import prova03112021POO.q2.GUI.Curso.PanelCursos;
import prova03112021POO.q2.src.Aula;
import prova03112021POO.q2.src.Disciplina;
import prova03112021POO.q2.src.Horario;
import prova03112021POO.q2.src.MeuCurso;
import prova03112021POO.q2.src.Professor;
import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;

public class PanelEditDisc extends JPanel 
{
	private static final long serialVersionUID = -5809124652163739091L;
	
	protected static JTextField tfCod;
	protected static JTextField tfSigla;
	protected static JTextField tfNome;
	protected static JTextField tfPer;
	protected static JTextField tfHrIn;
	protected static JTextField tfHrFin;
	protected static JTextField tfMinIn;
	protected static JTextField tfMinFin;
	protected static JComboBox<Horario> cbHrAlt;
	protected static JComboBox<String> cbDiaSem;
	protected static JComboBox<Aula> cbAulas;
	protected static JComboBox<Professor> cbProf;
	protected static JComboBox<Disciplina> cbDisc; 
	
	public static JComboBox<MeuCurso> cbCursos;
	
	public PanelEditDisc() 
	{
		setVisible(false);
		setBounds(new Rectangle(10, 33, 631, 597));
		setLayout(null);
		
		cbCursos = new JComboBox<>();
		cbCursos.setBounds(117, 93, 286, 22);
		add(cbCursos);
		
		cbDisc = new JComboBox<Disciplina>();
		cbDisc.setBounds(117, 126, 286, 22);
		add(cbDisc);
		
		cbHrAlt = new JComboBox<Horario>();
		cbHrAlt.setBounds(117, 303, 286, 24);
		add(cbHrAlt);
		
		cbDiaSem = new JComboBox<String>();
		cbDiaSem.setBounds(117, 338, 182, 24);
		add(cbDiaSem);
		
		cbAulas = new JComboBox<Aula>();
		cbAulas.setBounds(101, 430, 182, 24);
		add(cbAulas);
		
		cbProf = new JComboBox<>();
		cbProf.setBounds(117, 209, 156, 22);
		add(cbProf);
		
		tfCod = new JTextField();
		tfCod.setBounds(117, 154, 156, 20);
		tfCod.setColumns(10);
		add(tfCod);
		
		tfNome = new JTextField();
		tfNome.setColumns(10);
		tfNome.setBounds(117, 243, 156, 20);
		add(tfNome);
		
		tfPer = new JTextField();
		tfPer.setColumns(10);
		tfPer.setBounds(117, 270, 156, 20);
		add(tfPer);
		
		tfHrIn = new JTextField();
		tfHrIn.setColumns(10);
		tfHrIn.setBounds(117, 373, 104, 20);
		add(tfHrIn);
		
		tfHrFin = new JTextField();
		tfHrFin.setColumns(10);
		tfHrFin.setBounds(117, 400, 104, 20);
		add(tfHrFin);
		
		tfMinIn = new JTextField();
		tfMinIn.setColumns(10);
		tfMinIn.setBounds(274, 373, 104, 20);
		add(tfMinIn);
		
		tfMinFin = new JTextField();
		tfMinFin.setColumns(10);
		tfMinFin.setBounds(274, 400, 104, 20);
		add(tfMinFin);
		
		
		tfSigla = new JTextField();
		tfSigla.setColumns(10);
		tfSigla.setBounds(117, 178, 156, 20);
		add(tfSigla);
		
		
		JButton btnExCurs = new JButton("Exibir Cursos");
		btnExCurs.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					MeuCurso mc;
					cbCursos.removeAllItems();
					for(int i = 0; i < PanelCursos.getCbCurCad().getItemCount(); i++)
					{	
						mc = PanelCursos.getCbCurCad().getItemAt(i);
						cbCursos.addItem(mc);
					}
				}
				catch(Exception ex)
				{
					
				}
			}
		});
		btnExCurs.setBounds(465, 93, 156, 23);
		add(btnExCurs);
		
		JButton btnListarCdigo = new JButton("Alterar Código");
		btnListarCdigo.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					Disciplina d = (Disciplina) cbDisc.getSelectedItem();
					String cod = d.getCodigo();
					d.setCodigo(cod);
				}
				catch(Exception ex)
				{
					
				}
			}
		});
		btnListarCdigo.setBounds(465, 153, 156, 23);
		add(btnListarCdigo);
		
		JButton btnAltSigla = new JButton("Alterar Sigla");
		btnAltSigla.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					Disciplina d = (Disciplina) cbDisc.getSelectedItem();
					String sig = tfSigla.getText();
					d.setSigla(sig);	
				}
				catch(Exception ex)
				{
					
				}
			}
		});
		btnAltSigla.setBounds(465, 177, 156, 23);
		add(btnAltSigla);
		
		JButton btnExProf = new JButton("Exibir Professores");
		btnExProf.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					Professor p;
					Disciplina d;
					MeuCurso mc = (MeuCurso) cbCursos.getSelectedItem();
					for(int i = 0; i < mc.getListaDisc().size()  ; i++)
					{
						d = mc.listaDisciplinas.get(i);
						p = d.getProfessor();
						cbProf.addItem(p);
					}
				}
				catch(Exception ex)
				{
					
				}
				
			}
		});
		btnExProf.setBounds(283, 209, 156, 23);
		add(btnExProf);
		
		JButton btnAlterarNome = new JButton("Alterar Nome");
		btnAlterarNome.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					Disciplina d = (Disciplina) cbDisc.getSelectedItem();
					String n = tfNome.getText();
					d.setNome(n);
				}
				catch(Exception ex)
				{
					
				}
			}
		});
		btnAlterarNome.setBounds(465, 242, 156, 23);
		add(btnAlterarNome);
		
		JButton btnAlterarPerodo = new JButton("Alterar Período");
		btnAlterarPerodo.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					Disciplina d = (Disciplina) cbDisc.getSelectedItem();
					String per = tfPer.getText();
					d.setPeriodo(per);
				}
				catch(Exception ex)
				{
					
				}
			}
		});
		btnAlterarPerodo.setBounds(465, 269, 156, 23);
		add(btnAlterarPerodo);
		
		JButton bAltHr = new JButton("Exibir Horários");
		bAltHr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					Disciplina d = (Disciplina) cbDisc.getSelectedItem();
					Aula a;
					Horario h;
					for(int i = 0; i < d.getListaAulasSem().size(); i++) 
					{
						a = d.getListaAulasSem().get(i);
						for(int j = 0; j < a.getHorarios().size(); j++) 
						{
							h = a.getHorarios().get(j);
							cbHrAlt.addItem(h);					
						}
					}
				}
				catch(Exception ex)
				{
					
				}
			}
		});
		bAltHr.setBounds(467, 304, 154, 23);
		add(bAltHr);
		
		JButton btnExAul = new JButton("Exibir Aulas");
		btnExAul.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					cbAulas.removeAllItems();
					Disciplina d = (Disciplina)	cbDisc.getSelectedItem();
					Aula a;
					for(int i = 0; i <  d.getListaAulasSem().size(); i++) 
					{
						a = d.getListaAulasSem().get(i);
						cbAulas.addItem(a);
					}
				}
				catch(Exception ex)
				{
					
				}
			}
		});
		btnExAul.setBounds(293, 431, 156, 23);
		add(btnExAul);

		JButton btnExibirDisciplinas = new JButton("Exibir Disciplinas");
		btnExibirDisciplinas.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					MeuCurso mc = (MeuCurso) cbCursos.getSelectedItem();
					Disciplina d;
					cbDisc.removeAllItems();
					for(int i = 0; i < mc.listaDisciplinas.size(); i++)
					{
						d = mc.listaDisciplinas.get(i);
						cbDisc.addItem(d);
					}
				}
				catch(Exception ex)
				{
					
				}
			}
		});
		btnExibirDisciplinas.setBounds(465, 126, 156, 23);
		add(btnExibirDisciplinas);
		
		JButton btnAlterarProfessor = new JButton("Alterar Professor");
		btnAlterarProfessor.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					Disciplina d = (Disciplina) cbDisc.getSelectedItem();
					Professor p = (Professor) cbProf.getSelectedItem();
					d.setProfessor(p);
				}
				catch(Exception ex)
				{
					
				}
			}
		});
		btnAlterarProfessor.setBounds(465, 209, 156, 23);
		add(btnAlterarProfessor);
		
		JButton btnExibirNome = new JButton("Exibir Nome");
		btnExibirNome.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					Disciplina d = (Disciplina) cbDisc.getSelectedItem();
					String n = d.getNome();
					tfNome.setText(n);
				}
				catch(Exception ex)
				{
					
				}
			}
		});
		btnExibirNome.setBounds(285, 242, 156, 23);
		add(btnExibirNome);
		
		JButton btnExibirPerodo = new JButton("Exibir Período");
		btnExibirPerodo.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					Disciplina d = (Disciplina) cbDisc.getSelectedItem();
					String p = d.getPeriodo();
					tfPer.setText(p);
				}
				catch(Exception ex)
				{
					
				}
			}
		});
		btnExibirPerodo.setBounds(283, 269, 156, 23);
		add(btnExibirPerodo);
		
		JButton btnExibirCdigo = new JButton("Exibir Código");
		btnExibirCdigo.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					Disciplina d = (Disciplina) cbDisc.getSelectedItem();
					String cod = d.getCodigo();
					tfCod.setText(cod);
				}
				catch(Exception ex)
				{
					
				}
			}
		});
		btnExibirCdigo.setBounds(283, 154, 156, 23);
		add(btnExibirCdigo);
		
		JButton btnExSigla = new JButton("Exibir Sigla");
		btnExSigla.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					Disciplina d = (Disciplina) cbDisc.getSelectedItem();
					String sigla = d.getSigla();
					tfSigla.setText(sigla);
				}
				catch(Exception ex)
				{
					
				}
			}
		});
		btnExSigla.setBounds(283, 177, 156, 23);
		add(btnExSigla);
		
		JButton btnAltDiaSem = new JButton("Alterar Dia da Semana");
		btnAltDiaSem.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					Aula a = (Aula) cbAulas.getSelectedItem();
					String d = (String) cbDiaSem.getSelectedItem();
					a.setDiaDaSem(d);
				}
				catch(Exception ex)
				{
					
				}
			}
		});
		btnAltDiaSem.setBounds(465, 339, 156, 23);
		add(btnAltDiaSem);
		
		JButton btnAlterarAula = new JButton("Alterar Aulas");
		btnAlterarAula.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					Aula a = (Aula) getCbAulas().getSelectedItem();
					Disciplina d = (Disciplina) getCbDisc().getSelectedItem();
					d.setListaAulasSem(a);
				}
				catch(Exception ex)
				{
					
				}
			}
		});
		btnAlterarAula.setBounds(465, 431, 156, 23);
		add(btnAlterarAula);
		
		JButton btnAltHor = new JButton("Alterar Horário");
		btnAltHor.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					Horario h = new Horario(tfHrIn.getText(),tfMinIn.getText(),tfHrFin.getText(),tfMinFin.getText());
					Aula a = (Aula) cbAulas.getSelectedItem();
					a.getHorarios().remove(cbHrAlt.getSelectedItem());
					a.getHorarios().add(h);
				}
				catch(Exception ex)
				{
					
				}
			}
		});
		btnAltHor.setBounds(465, 393, 156, 23);
		add(btnAltHor);
		
		JButton btnRemoverAulaDa = new JButton("Remover Aula da Disciplina");
		btnRemoverAulaDa.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				try
				{
					Disciplina d = (Disciplina) cbDisc.getSelectedItem();
					Aula a = (Aula) cbAulas.getSelectedItem();
					for(int i = 0; i < d.getListaAulasSem().size() ; i++) 
					{
						if(a == d.getListaAulasSem().get(i))
						{
							d.getListaAulasSem().remove(i);
						}
					}
					
				}
				catch(Exception ex)
				{
					
				}
			}
		});
		btnRemoverAulaDa.setBounds(414, 465, 207, 23);
		add(btnRemoverAulaDa);
		
		JLabel lblEdDisc = new JLabel("Edição de Disciplinas");
		lblEdDisc.setHorizontalAlignment(SwingConstants.CENTER);
		lblEdDisc.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblEdDisc.setBounds(219, 25, 207, 33);
		add(lblEdDisc);
		
		JLabel lblCurs = new JLabel("Curso:");
		lblCurs.setBounds(10, 99, 103, 14);
		add(lblCurs);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 243, 82, 14);
		add(lblNome);
		
		JLabel lbHrAAlt = new JLabel("Horário a alterar:");
		lbHrAAlt.setBounds(10, 308, 154, 14);
		add(lbHrAAlt);
		
		JLabel lblNovaHrDeInic = new JLabel("Nova hora de início:");
		lblNovaHrDeInic.setBounds(10, 377, 139, 14);
		add(lblNovaHrDeInic);
		
		JLabel lblNovaHrdeF = new JLabel("Nova hora de fim:");
		lblNovaHrdeF.setBounds(10, 402, 139, 14);
		add(lblNovaHrdeF);
		
		JLabel lblHifen = new JLabel("-");
		lblHifen.setVerticalAlignment(SwingConstants.TOP);
		lblHifen.setHorizontalAlignment(SwingConstants.CENTER);
		lblHifen.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblHifen.setBounds(237, 373, 27, 20);
		add(lblHifen);
		
		JLabel lblHifen1 = new JLabel("-");
		lblHifen1.setHorizontalAlignment(SwingConstants.CENTER);
		lblHifen1.setFont(new Font("Tahoma", Font.PLAIN, 21));
		lblHifen1.setBounds(237, 404, 27, 20);
		add(lblHifen1);
		
		JLabel lblDiaSem = new JLabel("Dia da semana:");
		lblDiaSem.setBounds(10, 343, 144, 14);
		add(lblDiaSem);
		
		JLabel lblAul = new JLabel("Aula:");
		lblAul.setBounds(10, 435, 46, 14);
		add(lblAul);
		
		JLabel lblPer = new JLabel("Período:");
		lblPer.setBounds(10, 270, 82, 14);
		add(lblPer);
		
		JLabel lblCod = new JLabel("Código:");
		lblCod.setBounds(10, 157, 92, 14);
		add(lblCod);
		
		JLabel lblSigla = new JLabel("Sigla:");
		lblSigla.setBounds(10, 178, 82, 14);
		add(lblSigla);
		
		JLabel lblProf = new JLabel("Professor:");
		lblProf.setBounds(10, 210, 82, 14);
		add(lblProf);
		
		JLabel lblDisc = new JLabel("Disciplina:");
		lblDisc.setBounds(10, 125, 103, 14);
		add(lblDisc);
		
	}

	public static JComboBox<Aula> getCbAulas() {
		return cbAulas;
	}

	public static JComboBox<Disciplina> getCbDisc() {
		return cbDisc;
	}
}

