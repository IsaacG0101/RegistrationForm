import javax.swing.*;
import java.io.Serializable;
import javax.swing.text.MaskFormatter;

import java.awt.*; 
import java.awt.event.*;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream; 
  
class MyFrame 
    extends JFrame 
    implements ActionListener, Serializable { 
  
    // Components of the Form 
    private Container c; 
    private JLabel title; 
    private JLabel name; 
    private JLabel lname;
    private JLabel city;
    private JLabel state;
    private JLabel zip;
    private JLabel ssNumber;
    private JLabel sal;
    private JTextField mstate;
    private JTextField mzip;
    private JTextField mssNumber;
    private JTextField jcity;
    private JTextField tname;
    private JTextField lName;
    private JLabel mno; 
    private JTextField tmno; 
    private JLabel type; 
    private JRadioButton employee; 
    private JRadioButton customer; 
    private ButtonGroup gengp; 
    private JLabel dob; 
    private JComboBox date; 
    private JComboBox msal;
    private JComboBox month; 
    private JComboBox year; 
    private JLabel add; 
    private JTextArea tadd; 
    private JCheckBox term; 
    private JButton sub; 
    private JButton reset; 
    private JTextArea tout; 
    private JLabel res; 
    private JTextArea resadd; 
  
    private String dates[] 
        = { "1", "2", "3", "4", "5", 
            "6", "7", "8", "9", "10", 
            "11", "12", "13", "14", "15", 
            "16", "17", "18", "19", "20", 
            "21", "22", "23", "24", "25", 
            "26", "27", "28", "29", "30", 
            "31" }; 
    private String months[] 
        = { "Jan", "feb", "Mar", "Apr", 
            "May", "Jun", "July", "Aug", 
            "Sup", "Oct", "Nov", "Dec" }; 
    private String years[] 
        = { "1995", "1996", "1997", "1998", 
            "1999", "2000", "2001", "2002", 
            "2003", "2004", "2005", "2006", 
            "2007", "2008", "2009", "2010", 
            "2011", "2012", "2013", "2014", 
            "2015", "2016", "2017", "2018", 
            "2019" }; 
    
    private String ysal[] = {
    		"Mr", "Mrs", "Ms", "Doc", "Prof", "Rabbi"
    };
  
    // constructor, to initialize the components 
    // with default values. 
    public MyFrame() 
    { 
        setTitle("Registration Form"); 
        setBounds(300, 90, 900, 600); 
        setDefaultCloseOperation(EXIT_ON_CLOSE); 
        setResizable(false); 
        c = getContentPane(); 
        c.setLayout(null); 
  
        title = new JLabel("Registration Form"); 
        title.setFont(new Font("Arial", Font.PLAIN, 30)); 
        title.setSize(300, 30); 
        title.setLocation(300, 30); 
        c.add(title); 
  
        name = new JLabel("First Name"); 
        name.setFont(new Font("Arial", Font.PLAIN, 20)); 
        name.setSize(100, 20); 
        name.setLocation(100, 100); 
        c.add(name); 
  
        tname = new JTextField(); 
        tname.setFont(new Font("Arial", Font.PLAIN, 15)); 
        tname.setSize(190, 20); 
        tname.setLocation(200, 100);
        tname.addKeyListener(new KeyAdapter() {
        	public void keyPressed(KeyEvent e) {
        		char c = e.getKeyChar();
        		
        		if(Character.isLetter(c) || Character.isISOControl(c)) {
        			tname.setEditable(true);
        		}
        		else {
        			tname.setEditable(false);
        		}
        	}
         });
        c.add(tname);
        
        /*tname.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try{
					JTextField textField = (JTextField) e.getSource();
					String text = textField.getText();
					text.matches("[A-Z][a-zA-Z]*");
				} catch(Exception y) {
					System.out.println("Can only use A-Z, a-z letters for your name");
				}
                
				
			}
        	
        });
        c.add(tname);
        */
        lname = new JLabel("Last Name"); 
        lname.setFont(new Font("Arial", Font.PLAIN, 20)); 
        lname.setSize(100, 20); 
        lname.setLocation(100, 125);  
        c.add(lname); 
        
        lName = new JTextField(); 
        lName.setFont(new Font("Arial", Font.PLAIN, 15)); 
        lName.setSize(190, 20); 
        lName.setLocation(200, 125); 
        c.add(lName);
        
        city = new JLabel("City"); 
        city.setFont(new Font("Arial", Font.PLAIN, 20)); 
        city.setSize(100, 20); 
        city.setLocation(100, 175); 
        c.add(city); 
        
        jcity = new JTextField(); 
        jcity.setFont(new Font("Arial", Font.PLAIN, 15)); 
        jcity.setSize(190, 20); 
        jcity.setLocation(200, 175); 
        c.add(jcity);
        
        state = new JLabel("State"); 
        state.setFont(new Font("Arial", Font.PLAIN, 20)); 
        state.setSize(100, 20); 
        state.setLocation(100, 200); 
        c.add(state); 
        
        mstate = new JTextField(); 
        mstate.setFont(new Font("Arial", Font.PLAIN, 15)); 
        mstate.setSize(190, 20); 
        mstate.setLocation(200, 200); 
        c.add(mstate);
        
        
  
        mno = new JLabel("Mobile"); 
        mno.setFont(new Font("Arial", Font.PLAIN, 20)); 
        mno.setSize(100, 20); 
        mno.setLocation(100, 150); 
        c.add(mno); 
  
        tmno = new JTextField(); 
        tmno.setFont(new Font("Arial", Font.PLAIN, 15)); 
        tmno.setSize(150, 20); 
        tmno.setLocation(200, 150);
        tmno.addKeyListener(new KeyAdapter() {
        	public void keyPressed(KeyEvent ke) {
                String value = tmno.getText();
                int l = value.length();
                if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') {
             	   if(l < 10) {
                   tmno.setEditable(true);
             	   }
             	   else {
                   tmno.setEditable(false);
                   
                }
             }
                else {
             	  if(ke.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE) {
             		  tmno.setEditable(true);
            	   }
            	   else {
                  tmno.setEditable(false); 
             	  }
                }
             }
          });
        c.add(tmno); 
        
        zip = new JLabel("Zip"); 
        zip.setFont(new Font("Arial", Font.PLAIN, 20)); 
        zip.setSize(100, 20); 
        zip.setLocation(100, 225); 
        c.add(zip); 
        
        mzip = new JTextField(); 
        mzip.setFont(new Font("Arial", Font.PLAIN, 15)); 
        mzip.setSize(190, 20); 
        mzip.setLocation(200, 225);
        mzip.addKeyListener(new KeyAdapter() {
        	public void keyPressed(KeyEvent ke) {
                String value = mzip.getText();
                int l = value.length();
                if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') {
             	   if(l < 5) {
                   mzip.setEditable(true);
             	   }
             	   else {
                   mzip.setEditable(false);
                   
                }
             }
                else {
             	  if(ke.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE) {
             		  mzip.setEditable(true);
            	   }
            	   else {
                  mzip.setEditable(false); 
             	  }
                }
             }
          });
        
        c.add(mzip);
        
        ssNumber = new JLabel("SS Number"); 
        ssNumber.setFont(new Font("Arial", Font.PLAIN, 20)); 
        ssNumber.setSize(100, 20); 
        ssNumber.setLocation(100, 250); 
        c.add(ssNumber); 
        
        mssNumber = new JTextField(); 
        mssNumber.setFont(new Font("Arial", Font.PLAIN, 15)); 
        mssNumber.setSize(190, 20); 
        mssNumber.setLocation(200, 250);
        mssNumber.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {
               String value = mssNumber.getText();
               int l = value.length();
               if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') {
            	   if(l < 10) {
                  mssNumber.setEditable(true);
            	   }
            	   else {
                  mssNumber.setEditable(false);
                  
               }
            }
               else {
            	  if(ke.getExtendedKeyCode() == KeyEvent.VK_BACK_SPACE) {
            		  mssNumber.setEditable(true);
           	   }
           	   else {
                 mssNumber.setEditable(false); 
            	  }
               }
            }
         });
        c.add(mssNumber);
        
        type = new JLabel("type"); 
        type.setFont(new Font("Arial", Font.PLAIN, 20)); 
        type.setSize(100, 20); 
        type.setLocation(100, 275); 
        c.add(type); 
  
        employee = new JRadioButton("Employee"); 
        employee.setFont(new Font("Arial", Font.PLAIN, 15)); 
        employee.setSelected(true); 
        employee.setSize(75, 20); 
        employee.setLocation(200, 275); 
        c.add(employee); 
  
        customer = new JRadioButton("Customer"); 
        customer.setFont(new Font("Arial", Font.PLAIN, 15)); 
        customer.setSelected(false); 
        customer.setSize(80, 20); 
        customer.setLocation(275, 275); 
        c.add(customer); 
  
        gengp = new ButtonGroup(); 
        gengp.add(employee); 
        gengp.add(customer); 
  
        sal = new JLabel("Salutation"); 
        sal.setFont(new Font("Arial", Font.PLAIN, 20)); 
        sal.setSize(100, 20); 
        sal.setLocation(100, 75); 
        c.add(sal); 
  
        msal = new JComboBox(ysal); 
        msal.setFont(new Font("Arial", Font.PLAIN, 15)); 
        msal.setSize(50, 20); 
        msal.setLocation(200, 75); 
        c.add(msal); 
  
        month = new JComboBox(months); 
        month.setFont(new Font("Arial", Font.PLAIN, 15)); 
        month.setSize(60, 20); 
        month.setLocation(250, 250); 
        c.add(month); 
  
        year = new JComboBox(years); 
        year.setFont(new Font("Arial", Font.PLAIN, 15)); 
        year.setSize(60, 20); 
        year.setLocation(320, 250); 
        c.add(year); 
  
        add = new JLabel("Address"); 
        add.setFont(new Font("Arial", Font.PLAIN, 20)); 
        add.setSize(100, 20); 
        add.setLocation(100, 300); 
        c.add(add); 
  
        tadd = new JTextArea(); 
        tadd.setFont(new Font("Arial", Font.PLAIN, 15)); 
        tadd.setSize(200, 75); 
        tadd.setLocation(200, 300); 
        tadd.setLineWrap(true); 
        c.add(tadd); 
  
        term = new JCheckBox("Accept Terms And Conditions."); 
        term.setFont(new Font("Arial", Font.PLAIN, 15)); 
        term.setSize(250, 20); 
        term.setLocation(150, 400); 
        c.add(term); 
  
        sub = new JButton("Submit"); 
        sub.setFont(new Font("Arial", Font.PLAIN, 15)); 
        sub.setSize(100, 20); 
        sub.setLocation(150, 450); 
        sub.addActionListener(this); 
        c.add(sub); 
  
        reset = new JButton("Reset"); 
        reset.setFont(new Font("Arial", Font.PLAIN, 15)); 
        reset.setSize(100, 20); 
        reset.setLocation(270, 450); 
        reset.addActionListener(this); 
        c.add(reset); 
  
        tout = new JTextArea(); 
        tout.setFont(new Font("Arial", Font.PLAIN, 15)); 
        tout.setSize(300, 400); 
        tout.setLocation(500, 100); 
        tout.setLineWrap(true); 
        tout.setEditable(false); 
        c.add(tout); 
  
        res = new JLabel(""); 
        res.setFont(new Font("Arial", Font.PLAIN, 20)); 
        res.setSize(500, 25); 
        res.setLocation(100, 500); 
        c.add(res); 
  
        resadd = new JTextArea(); 
        resadd.setFont(new Font("Arial", Font.PLAIN, 15)); 
        resadd.setSize(200, 75); 
        resadd.setLocation(580, 175); 
        resadd.setLineWrap(true); 
        c.add(resadd); 
  
        setVisible(true); 
    } 
     
  
    // method actionPerformed() 
    // to get the action performed 
    // by the user and act accordingly 
    
    
    public void actionPerformed(ActionEvent e) 
    { 
        if (e.getSource() == sub) { 
            if (term.isSelected()) {
            	String data1;
                String data 
                	  = "Profession : " 
                      + (String)msal.getSelectedItem() + "\n" 
                      + "First Name : "
                      + tname.getText() + "\n"
                      + "Last Name : " 
                      + lName.getText() +"\n"
                      + "City : " 
                      + jcity.getText() + "\n"
                      + "State : " 
                      + mstate.getText() + "\n"
                      + "Zip : " 
                      + mzip.getText() + "\n"
                      +  "Mobile : "
                      + tmno.getText() + "\n"
                      + "SS Number : " 
                      + mssNumber.getText() + "\n"; 
                
                if (employee.isSelected()) 
                    data1 = "type : employee"
                            + "\n"; 
                else
                    data1 = "type : customer"
                            + "\n"; 
              /* String data2 
                    = "DOB : "
                      + (String)date.getSelectedItem() 
                      + "/" + (String)month.getSelectedItem() 
                      + "/" + (String)year.getSelectedItem() 
                      + "\n"; 
  				*/
                String data3 = "Address : " + tadd.getText(); 
                tout.setText(data + data1 + data3); 
                tout.setEditable(false); 
                res.setText("Registration Successfully.."); 
            } 
            else { 
                tout.setText(""); 
                resadd.setText(""); 
                res.setText("Please accept the"
                            + " terms & conditions.."); 
            }
            
        } 
  
        else if (e.getSource() == reset) { 
            String def = ""; 
            tname.setText(def); 
            tadd.setText(def); 
            tmno.setText(def); 
            res.setText(def); 
            tout.setText(def); 
            term.setSelected(false); 
            date.setSelectedIndex(0); 
            month.setSelectedIndex(0); 
            year.setSelectedIndex(0); 
            resadd.setText(def); 
        } 
    }


	

}