package prova03112021POO.q1.A;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import prova03112021POO.q1.ConversaoDeUnidadesDeArea;

import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.lang.Double;

public class TelaQ1A {

	private JFrame frmQuestoA;
	private JTextField textField;
	private JTextField textField_1;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaQ1A window = new TelaQ1A();
					window.frmQuestoA.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TelaQ1A() {
		initialize();
	}

	private void initialize() {
		ConversaoDeUnidadesDeArea c = new ConversaoDeUnidadesDeArea();
		
		frmQuestoA = new JFrame();
		frmQuestoA.setTitle("Questão 1 A");
		frmQuestoA.setBounds(100, 100, 518, 306);
		frmQuestoA.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmQuestoA.getContentPane().setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("=");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 34));
		lblNewLabel.setBounds(230, 120, 28, 23);
		frmQuestoA.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(28, 120, 167, 33);
		frmQuestoA.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(298, 120, 180, 33);
		frmQuestoA.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JComboBox<String> comboBox = new JComboBox<>();
		comboBox.setModel(new DefaultComboBoxModel<>(new String[] {"metro(s) quadrado(s)", "pe(s) quadrado(s)", 
		"milha(s) quadrada(s)", "acre(s)", "centimetro(s) quadrado(s)"}));
		comboBox.setBounds(28, 34, 167, 39);
		frmQuestoA.getContentPane().add(comboBox);
		
		JComboBox<String> comboBox_1 = new JComboBox<>();
		comboBox_1.setModel(new DefaultComboBoxModel<>(new String[] {"metro(s) quadrado(s)", "pe(s) quadrado(s)", 
		"milha(s) quadrada(s)", "acre(s)", "centimetro(s) quadrado(s)"}));
		comboBox_1.setBounds(298, 34, 180, 39);
		frmQuestoA.getContentPane().add(comboBox_1);
		
		JLabel lblNewLabel_1 = new JLabel("    para");
		lblNewLabel_1.setBounds(222, 46, 46, 14);
		frmQuestoA.getContentPane().add(lblNewLabel_1);
		
		JButton btnConverter = new JButton("Converter");
		btnConverter.setBounds(191, 193, 116, 33);
		frmQuestoA.getContentPane().add(btnConverter);
		btnConverter.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				try 
				{
					ArrayList<String> aux = new ArrayList<>();
					String inputS = textField.getText();
					double inputD = Double.parseDouble(inputS);
					if(inputD < 0)
					{
						throw new Exception();
					}
					aux.add((String)comboBox.getSelectedItem());
					aux.add((String)comboBox_1.getSelectedItem());
					c.setSelecoes(aux);
					textField_1.setText(""+c.getResultado(inputD));
				}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(frmQuestoA, "O valor precisa ser positivo e numérico.");
				}
			}
		});
	}
}