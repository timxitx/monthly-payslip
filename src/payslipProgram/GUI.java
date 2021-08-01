package payslipProgram;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import payslipProgram.Calculation;

public class GUI implements ActionListener {
	
	String filePath = "";
	
	public GUI() {
		JFrame frame = new JFrame("Montly Payslip Program");
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
			new Calculation(filePath);
		}
		
	}

}
