package payslipProgram;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class GUI implements ActionListener {
	
	String filePath = "";
	String outputFile = "src/payslip-output.csv";
	JFrame frame;
	
	public GUI() {
		frame = new JFrame("Montly Payslip Program");
	    JPanel panel = new JPanel();
	    JButton button = new JButton("Select a csv file");
	    
	    button.setPreferredSize(new Dimension(150,50));
	    button.addActionListener(this);
	    
	    panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
	    panel.setPreferredSize(new Dimension(300, 150));
	    panel.add(button);
	    
	    frame.add(panel);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setSize(500,300);
	    frame.pack();
	    frame.setVisible(true);
	}	

	public static void main(String[] args) {
		new GUI();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		JFileChooser chooser = new JFileChooser();
		int returnVal = chooser.showOpenDialog(null);
		if(returnVal == JFileChooser.APPROVE_OPTION) {
			filePath = chooser.getSelectedFile().toString();
			new GUI();
			//read input file
			IO io = new IO();
			io.FileReader(filePath);
			//output
			boolean result = io.FileWriter(outputFile);
			if(result) {
				JOptionPane.showMessageDialog(frame,
					    "The csv file has been generated in monthly-payslip/src folder",
					    "The output:",
					    JOptionPane.PLAIN_MESSAGE);
				System.out.println("Finished!");
			} else {
				JOptionPane.showMessageDialog(frame,
					    "Something went wrong!",
					    "The output:",
					    JOptionPane.PLAIN_MESSAGE);
				System.out.println("Failed!");
			}
		}
		
	}

}
