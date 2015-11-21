import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Components extends JFrame implements ActionListener {

	//Private instance variables ++++++++++
	private JLabel _gridLabel;
	private JTextField _gridCodeTextField;
	private JTextField _gridHoursTField;
	private JComboBox _gridComboBox;
	private String[] _grades = {"A+:90-100%", "A:80-89%", "B+:75-79%", "B:70-74%", "C+:65-69%", "C:60-64%", "D+:55-59%", "D:50-54%", "F:0-49%"};
	private String _courseGrade;
	private double _creditHours;
	private double _calGrade;
	
	public double getCreditHours() {
		return this._creditHours;
	}

	public void setCreditHours(double creditHours) {
		this._creditHours = creditHours;
	}

	public double getCalGrade() {
		return this._calGrade;
	}

	public void setCalGrade(double calGrade) {
		this._calGrade = calGrade;
	}

		// CONSTRUCTOR +++++++++++++++++++++++++++++++++++++
		public Components(JPanel todoPanel, int row) {
			
			this._gridLabel = new JLabel();
			this._gridLabel.setText(Integer.toString(row + 1) + ".");
			GridBagConstraints gridLabelCons = new GridBagConstraints();
			gridLabelCons.insets = new Insets(0, 0, 0, 5);
			gridLabelCons.fill = GridBagConstraints.BOTH;
			gridLabelCons.gridx = 0;
			gridLabelCons.gridy = row;
			todoPanel.add(this._gridLabel, gridLabelCons);
			
			this._gridCodeTextField = new JTextField();
			this._gridCodeTextField.setBackground(Color.CYAN);
			GridBagConstraints gridCodeTFieldCons = new GridBagConstraints();
			gridCodeTFieldCons.insets = new Insets(0, 0, 0, 5);
			gridCodeTFieldCons.weightx = 1.0;
			gridCodeTFieldCons.fill = GridBagConstraints.BOTH;
			gridCodeTFieldCons.gridx = 2;
			gridCodeTFieldCons.gridy = row;
			todoPanel.add(this._gridCodeTextField, gridCodeTFieldCons);
			this._gridCodeTextField.setColumns(10);
			
			this._gridHoursTField = new JTextField();
			this._gridHoursTField.setBackground(Color.CYAN);
			GridBagConstraints gridHoursTFieldCons = new GridBagConstraints();
			gridHoursTFieldCons.insets = new Insets(0, 0, 0, 5);
			gridHoursTFieldCons.fill = GridBagConstraints.BOTH;
			gridHoursTFieldCons.gridx = 3;
			gridHoursTFieldCons.gridy = row;
			todoPanel.add(this._gridHoursTField, gridHoursTFieldCons);
			this._gridHoursTField.setColumns(10);
			
			this._gridComboBox = new JComboBox();
			this._gridComboBox.setModel(new DefaultComboBoxModel(this._grades));
			this._gridComboBox.setMaximumRowCount(4);
			this._gridComboBox.setBackground(Color.CYAN);
			this._gridComboBox.setSelectedIndex(0);
			GridBagConstraints gridGradeComboBox = new GridBagConstraints();
			gridGradeComboBox.fill = GridBagConstraints.HORIZONTAL;
			gridGradeComboBox.gridx = 4;
			gridGradeComboBox.gridy = row;
			todoPanel.add(this._gridComboBox, gridGradeComboBox);
			
			//Add event listeners +++++
			this._gridComboBox.addActionListener(this);
			this._gridHoursTField.addActionListener(this);
			this._gridCodeTextField.addActionListener(this);
			
		}

		
		
		public double grade(){
			this._courseGrade = (String)(this._gridComboBox.getSelectedItem());
			double grade = 0;
			switch (this._courseGrade){
			case "A+:90-100%":
				grade = 4.5;
				break;
			case "A:80-89%":
				grade = 4.0;
				break;
			case "B+:75-79%":
				grade = 3.5;
				break;
			case "B:70-74%":
				grade = 3.0;
				break;
			case "C+:65-69%":
				grade = 2.5;
				break;
			case "C:60-64%":
				grade = 2.0;
				break;
			case "D+:55-59%":
				grade = 1.5;
				break;
			case "D:50-54%":
				grade = 1.0;
				break;
			case "F:0-49%":
				grade = 0.0;
				break;
			default:
				grade = 4.5;
				break;
			}

			return grade;
		}
		
		@Override
		public void actionPerformed(ActionEvent event) {
			if(event.getSource()==this._gridComboBox){
				this._calGrade = grade();
			}
			if(event.getSource()==this._gridHoursTField){
				this._creditHours = Integer.parseInt(this._gridHoursTField.getText());
			}
			if (event.getSource()== this._gridCodeTextField){
				if(this._gridCodeTextField.equals("")){
					JOptionPane.showInputDialog("Course Name is required \nPlease Enter Course Name");
				}
			}
		}
		
		/*public float productOfTwo(){
			float product =0.0f;
			product = this._calGrade * this._creditHours;
			return product;
		}*/
		
		public void removeEventHandler() {
			this._gridLabel.removeAll();
			this._gridCodeTextField.removeActionListener(this);
			this._gridCodeTextField.removeAll();
			this._gridHoursTField.removeActionListener(this);
			this._gridHoursTField.removeAll();
			this._gridComboBox.removeActionListener(this);
			this._gridComboBox.removeAll();
		}

}
