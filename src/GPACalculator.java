import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class GPACalculator extends JFrame  implements ActionListener, FocusListener {

	//PRIVATE INSTANCE VARIABLES ++++++++++++++++++++
	private JPanel _contentPane, _todoPanel;
	private JLabel _GPACalLabel, _creditHourEarnedLabel, _currentGPALabel, _numCourseLabel, _sNoLabel, _courseCodeLabel, _creditHoursLabel, _gradeLabel, _result;
	private JTextField _creditHoursTextField, _currentGPATextField;
	private JComboBox _numCourseComboBox;
	private String[] _numOfCourses = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
	private GridBagLayout gridBagLayout;
	private ArrayList<Components> _addComponents;
	private JButton _calculateGPA;
	private double _creditHours =0, _creditHoursEarned = 0;
	private double _currentGPA =0 ;
	private double _grade = 0;

	//CONSTRUCTOR ++++++++++++++++++++
	public GPACalculator() {
		this._initialize();
		this._addUIComponents();

		//Adding event listeners
		this._creditHoursTextField.addActionListener(this);
		this._currentGPATextField.addActionListener(this);
		this._numCourseComboBox.addActionListener(this);
		this._calculateGPA.addActionListener(this);
		this._creditHoursTextField.addFocusListener(this);
		this._currentGPATextField.addFocusListener(this);
	}

	//PRIVATE MEHTODS ++++++++++++++++++++
	private void _initialize(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(300, 100, 600, 550);
		this._contentPane = new JPanel();
		this._contentPane.setBackground(new Color(238, 232, 170));
		this._contentPane.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		setContentPane(this._contentPane);
	}


	private void _addUIComponents(){

		//Using Absolute layout ++++++++++++
		this._contentPane.setLayout(null);


		//Adding labels +++++++++++++++++
		this._GPACalLabel = new JLabel("GPA CALCULATOR", SwingConstants.CENTER);
		this._GPACalLabel.setFont(new Font("Helvetica", Font.BOLD, 15));
		this._GPACalLabel.setBounds(218, 11, 155, 14);
		this._contentPane.add(this._GPACalLabel);

		this._creditHourEarnedLabel = new JLabel("Credit Hours Earned");
		this._creditHourEarnedLabel.setBounds(27, 45, 122, 14);
		this._contentPane.add(this._creditHourEarnedLabel);

		this._currentGPALabel = new JLabel("Current GPA");
		this._currentGPALabel.setBounds(315, 45, 77, 14);
		this._contentPane.add(this._currentGPALabel);

		this._numCourseLabel = new JLabel("Number of Courses");
		this._numCourseLabel.setBounds(315, 83, 122, 14);
		this._contentPane.add(this._numCourseLabel);
		
		this._sNoLabel = new JLabel("S No.");
		this._sNoLabel.setBounds(27, 141, 62, 14);
		this._contentPane.add(this._sNoLabel);
		
		this._courseCodeLabel = new JLabel("Course Code");
		this._courseCodeLabel.setBounds(112, 141, 96, 14);
		this._contentPane.add(this._courseCodeLabel);
		
		this._creditHoursLabel = new JLabel("Credit Hours");
		this._creditHoursLabel.setBounds(277, 141, 96, 14);
		this._contentPane.add(this._creditHoursLabel);
		
		this._gradeLabel = new JLabel("Grade");
		this._gradeLabel.setBounds(445, 141, 46, 14);
		this._contentPane.add(this._gradeLabel);
		
		this._result = new JLabel();
		
		this._result.setBounds(224, 473, 200, 14);
		this._contentPane.add(this._result);

		//Adding TextFields +++++++++++
		this._creditHoursTextField = new JTextField();
		this._creditHoursTextField.setBackground(Color.CYAN);
		this._creditHoursTextField.setText("0");
		this._creditHoursTextField.setBounds(174, 42, 50, 20);
		this._creditHoursTextField.setHorizontalAlignment(JTextField.CENTER);
		this._contentPane.add(this._creditHoursTextField);
		this._creditHoursTextField.setColumns(10);

		this._currentGPATextField = new JTextField();
		this._currentGPATextField.setBackground(Color.CYAN);
		this._currentGPATextField.setText("0");
		this._currentGPATextField.setBounds(460, 42, 50, 20);
		this._currentGPATextField.setHorizontalAlignment(JTextField.CENTER);
		this._contentPane.add(this._currentGPATextField);
		this._currentGPATextField.setColumns(10);

		//Adding Combo Boxes ++++++++++++++
		this._numCourseComboBox = new JComboBox();
		this._numCourseComboBox.setAutoscrolls(true);
		this._numCourseComboBox.setModel(new DefaultComboBoxModel(this._numOfCourses));
		this._numCourseComboBox.setBackground(Color.CYAN);
		this._numCourseComboBox.setBounds(460, 80, 50, 20);
		this._numCourseComboBox.setMaximumRowCount(4);
		this._numCourseComboBox.setSelectedIndex(0);
		this._contentPane.add(this._numCourseComboBox);
		
		//Adding to do panel +++++++++
		this._todoPanel = new JPanel();
		this._todoPanel.setBackground(new Color(238, 232, 170));
		this._todoPanel.setBounds(27, 176, 536, 250);
		this._contentPane.add(this._todoPanel);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{40, 10, 180, 140, 166};
		gridBagLayout.rowHeights = new int[]{20, 20, 20, 20, 20, 20, 20, 20, 20, 20};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		this._todoPanel.setLayout(gridBagLayout);
		
		//add a default values to the todoPanel
		this._addComponents = new ArrayList<Components>();
		this._addComponents.add(new Components(this._todoPanel, 0));
		
		//Adding Calculate button ++++++++++=
		this._calculateGPA = new JButton("Calculate");
		this._calculateGPA.setBackground(Color.CYAN);
		this._calculateGPA.setBounds(452, 437, 89, 23);
		this._contentPane.add(_calculateGPA);
		
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		
		if(event.getSource()==this._creditHoursTextField){
			this._creditHoursEarned = Double.parseDouble(this._creditHoursTextField.getText());
		}
		
		if(event.getSource()==this._currentGPATextField){
			this._currentGPA = Double.parseDouble(this._currentGPATextField.getText());
		}
		
		if(event.getSource() == this._numCourseComboBox) {
			// store the selected index item
			int numTodoFields = this._numCourseComboBox.getSelectedIndex() + 1;
			
			//clear the todoPanel 
			this._todoPanel.removeAll();

			for (Components toAdd : this._addComponents) {
				toAdd.removeEventHandler();
			}
			
			// clear the todoArrayList
			this._addComponents.clear();
			
			// add the selected number of rows to the todoArrayList 
			for(int index = 0; index < numTodoFields; index++) {
				Components addComponents = new Components(this._todoPanel, index);
				this._addComponents.add(addComponents);
			}
			
			
			// redraw the todoPanel
			this._todoPanel.revalidate();	
			this._todoPanel.repaint();
			
		}
		
		if(event.getSource()== this._calculateGPA){
			double product, totalProduct = 0;
			double totalCreditHours = 0;
			double GPA = 0;
			double roundGPA = 0;
			for (Components added: this._addComponents){
			
				this._creditHours = added.getCreditHours();
				totalCreditHours = totalCreditHours + this._creditHours;
				this._grade = added.getCalGrade();
				product = this._creditHours * this._grade;
				totalProduct = product + totalProduct; 
			}
			GPA = (totalProduct + (this._currentGPA * this._creditHoursEarned))/ (totalCreditHours + this._creditHoursEarned);
			roundGPA = (double) Math.round(GPA*100.0)/100.0;
			this._result.setText(String.valueOf("Your GPA is: " + roundGPA));
		}
	}

	@Override
	public void focusGained(FocusEvent e) {
		
	}

	@Override
	public void focusLost(FocusEvent event) {
		if(event.getSource()==this._creditHoursTextField){
			this._creditHoursEarned = Double.parseDouble(this._creditHoursTextField.getText());
		}
		
		if(event.getSource()==this._currentGPATextField){
			this._currentGPA = Double.parseDouble(this._currentGPATextField.getText());
		}
	}
}