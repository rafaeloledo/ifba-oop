package prova03112021POO.q1.B;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;

import prova03112021POO.q1.ConversaoDeUnidadesDeArea;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaQ1B {

	private JFrame frame;
	private JTextField textField;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaQ1B window = new TelaQ1B();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public TelaQ1B() {
		initialize();
	}
	
	private void initialize() {
		ConversaoDeUnidadesDeArea c = new ConversaoDeUnidadesDeArea();
		frame = new JFrame();
		frame.setBounds(100, 100, 511, 338);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(133, 67, 153, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Área em m²");
		lblNewLabel.setBounds(38, 69, 85, 17);
		frame.getContentPane().add(lblNewLabel);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(38, 140, 416, 117);
		frame.getContentPane().add(textArea);
		
		JButton btnNewButton = new JButton("Converter");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
				{
					double input = Double.parseDouble(textField.getText());
					if(input < 0)
					{
						throw new Exception();
					}
					String conversoes = c.getAreasFutebol(input);
					textArea.setText(conversoes);
				}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(frame, "O valor precisa ser positivo e numérico.");
				}
			}
		});
		btnNewButton.setBounds(317, 66, 121, 23);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("Conversões");
		lblNewLabel_1.setBounds(38, 115, 127, 14);
		frame.getContentPane().add(lblNewLabel_1);
	}
}
