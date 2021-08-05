import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Calcula implements ActionListener {
	
	JLabel label;
	JLabel maior;
	JLabel menor;
	JLabel media;
	JLabel resposta;
	JTextField textField;
	JTextField textField2;
	JTextField textField3;
	JTextField textField4;
	
	int maiorr = 0;
	int menorr = 0;
	int mediar = 0;

	int arrayListi = 0;
	int arraylistiLenght = 0;
	
	public Calcula() {
		
		JFrame frame = new JFrame("Números");
		frame.setVisible(true);
		frame.setSize(140, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new FlowLayout());
		
		label = new JLabel("Digite os números: ");
		frame.add(label);
		
		textField = new JTextField(10);
		textField.addActionListener(this);
		textField.setActionCommand("Enter");
		frame.add(textField);
		
		JButton button = new JButton("Adicionar");
		button.addActionListener(this);
		frame.add(button);
		
		maior = new JLabel("Maior");
		frame.add(maior);
		
		textField2 = new JTextField(10);
		frame.add(textField2);
		textField2.setEditable(false);
		
		menor = new JLabel("Menor");
		frame.add(menor);
		
		textField3 = new JTextField(10);
		frame.add(textField3);
		textField3.setEditable(false);
		
		media = new JLabel("Media");
		frame.add(media);
		
		textField4 = new JTextField(10);
		frame.add(textField4);
		textField4.setEditable(false);
		
		JButton button2 = new JButton("Calcular");
		frame.add(button2);
		button2.addActionListener(this);
		
		resposta = new JLabel("");
		frame.add(resposta);
		
	}
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {

				new Calcula();
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		if(textField.getText().contentEquals("")) {
			resposta.setText("Erro");
		}else {
			
			int num = Integer.parseInt(textField.getText());
			arrayListi += num;
			arraylistiLenght++;
			if(e.getActionCommand().equalsIgnoreCase("Adicionar")) {
				if(maiorr == 0 && menorr == 0 && mediar == 0) {
					
					maiorr = num;
					menorr = num;
					mediar = num;
				}
				if(maiorr < num) {
					maiorr = num;
				}
				if(menorr > num) {
					menorr = num;
				}
			}
			if(e.getActionCommand().equalsIgnoreCase("Calcular")) {
				
				mediar = arrayListi / arraylistiLenght;
				textField2.setText(String.valueOf(maiorr));
				textField3.setText(String.valueOf(menorr));
				textField4.setText(String.valueOf(mediar));
				
				maiorr = 0;
				menorr = 0;
				mediar = 0;
				arrayListi = 0;
				arraylistiLenght = 0;
				
			}
			
		}
		
	}

}
