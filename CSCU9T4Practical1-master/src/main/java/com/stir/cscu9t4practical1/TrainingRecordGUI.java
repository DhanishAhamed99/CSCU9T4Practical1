// GUI and main program for the Training Record
package com.stir.cscu9t4practical1;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.lang.Number;

public class TrainingRecordGUI extends JFrame implements ActionListener {

    private JTextField name = new JTextField(30);
    private JTextField day = new JTextField(2);
    private JTextField month = new JTextField(2);
    private JTextField year = new JTextField(4);
    private JTextField hours = new JTextField(2);
    private JTextField mins = new JTextField(2);
    private JTextField secs = new JTextField(2);
    private JTextField dist = new JTextField(4);
    private JTextField reps = new JTextField(2);
    private JTextField rec = new JTextField(2);
    private JTextField ter = new JTextField(7);
    private JTextField tem = new JTextField(10);
    private JTextField whe = new JTextField(5);
    private JLabel labn = new JLabel(" Name:");
    private JLabel labd = new JLabel(" Day:");
    private JLabel labm = new JLabel(" Month:");
    private JLabel laby = new JLabel(" Year:");
    private JLabel labh = new JLabel(" Hours:");
    private JLabel labmm = new JLabel(" Mins:");
    private JLabel labs = new JLabel(" Secs:");
    private JLabel labdist = new JLabel(" Distance (km):");
    private JLabel labsprint = new JLabel(" Sprint=> ");
    private JLabel labrep = new JLabel(" Repetitions:");
    private JLabel labrec = new JLabel(" Recovery:");
    private JButton addR = new JButton("Add Sprint");
    private JLabel labcycle = new JLabel(" Cycle=> ");
    private JLabel labter = new JLabel(" Terrain:");
    private JLabel labtem = new JLabel(" Tempo:");
    private JButton addC = new JButton("Add Cycle");
    private JLabel labswim = new JLabel(" Swim=> ");
    private JLabel labwhe = new JLabel(" Where:");
    private JButton addS = new JButton("Add Swim");
    private JButton lookUpByDate = new JButton("Look Up");
    private JButton findAllByDate = new JButton("Find All By Date");

    private TrainingRecord myAthletes = new TrainingRecord();

    private JTextArea outputArea = new JTextArea(5, 50);

    public static void main(String[] args) {
        TrainingRecordGUI applic = new TrainingRecordGUI();
    } // main

    // set up the GUI 
    public TrainingRecordGUI() {
        super("Training Record");
        setLayout(new FlowLayout());
        add(labn);
        add(name);
        name.setEditable(true);
        add(labd);
        add(day);
        day.setEditable(true);
        add(labm);
        add(month);
        month.setEditable(true);
        add(laby);
        add(year);
        year.setEditable(true);
        add(labh);
        add(hours);
        hours.setEditable(true);
        add(labmm);
        add(mins);
        mins.setEditable(true);
        add(labs);
        add(secs);
        secs.setEditable(true);
        add(labdist);
        add(dist);
        dist.setEditable(true);
        add(labsprint);
        add(labrep);
        add(reps);
        reps.setEditable(true);
        add(labrec);
        add(rec);
        rec.setEditable(true);
        add(addR);
        add(labcycle);
        add(labter);
        add(ter);
        ter.setEditable(true);
        add(labtem);
        add(tem);
        tem.setEditable(true);
        add(addC);
        add(labswim);
        add(labwhe);
        add(whe);
        whe.setEditable(true);
        add(addS); 
        addR.addActionListener(this);
        addC.addActionListener(this);
        addS.addActionListener(this);
        add(lookUpByDate);
        lookUpByDate.addActionListener(this);
        add(findAllByDate);
        findAllByDate.addActionListener(this);
        add(outputArea);
        outputArea.setEditable(false);
        setSize(1000, 200);
        setVisible(true);
        blankDisplay();

        // To save typing in new entries while testing, uncomment
        // the following lines (or add your own test cases)
        
    } // constructor

    // listen for and respond to GUI events 
    public void actionPerformed(ActionEvent event) {
        String message = "";
        if (event.getSource() == addR) {
            message = addEntry("sprint");
        }
        if (event.getSource() == addC) {
            message = addEntry("cycle");
        }
        if (event.getSource() == addS) {
            message = addEntry("swim");
        }
        if (event.getSource() == lookUpByDate) {
            message = lookupEntry();
        }
        if (event.getSource() == findAllByDate) {
            message = findAllEntry();
        }
        outputArea.setText(message);
        blankDisplay();
    } // actionPerformed

    public String addEntry(String what) {
        if(!name.getText().isBlank()){
            System.out.println("Adding "+what+" entry to the records");
            String n = name.getText();
            int m = Integer.parseInt(month.getText());
            int d = Integer.parseInt(day.getText());
            int y = Integer.parseInt(year.getText());
            float km = java.lang.Float.parseFloat(dist.getText());
            int h = Integer.parseInt(hours.getText());
            int mm = Integer.parseInt(mins.getText());
            int s = Integer.parseInt(secs.getText());
            Entry e;
        
            if(what.equals("sprint")){
                int rep = Integer.parseInt(reps.getText());
                int re = Integer.parseInt(rec.getText());
                e = new SprintEntry(n, d, m, y, h, mm, s, km, rep , re);
            }
        
            else if(what.equals("cycle")){
                String terr = ter.getText();
                String tempo = tem.getText();
                e = new CycleEntry(n, d, m, y, h, mm, s, km, terr, tempo);
            }
            
            else{
                String where = whe.getText();
                e = new SwimEntry(n, d, m, y, h, mm, s, km, where);
            }
           
            String message = myAthletes.addEntry(e);
            return message;
            }
        
        else return("Please enter a name");
    }
    
    public String lookupEntry() {
        try{
        int m = Integer.parseInt(month.getText());
        int d = Integer.parseInt(day.getText());
        int y = Integer.parseInt(year.getText());
        outputArea.setText("looking up record ...");
        String message = myAthletes.lookupEntry(d, m, y);
        return message;
        }
        catch(NumberFormatException e){
           return("Invalid data type entered for Date. Please use numbers only");
        }     
    }
    
    public String findAllEntry(){
        try{
        int m = Integer.parseInt(month.getText());
        int d = Integer.parseInt(day.getText());
        int y = Integer.parseInt(year.getText());
        outputArea.setText("looking up record ...");
        String message = myAthletes.lookupEntries(d, m, y);
        return message;
        }
        catch(NumberFormatException e){
           return("Invalid data type entered for Date. Please use numbers only");
        }  
        
    }

    public void blankDisplay() {
        name.setText("");
        day.setText("");
        month.setText("");
        year.setText("");
        hours.setText("");
        mins.setText("");
        secs.setText("");
        dist.setText("");
        reps.setText("");
        rec.setText("");
        ter.setText("");
        tem.setText("");
        whe.setText("");

    }// blankDisplay
    // Fills the input fields on the display for testing purposes only
    public void fillDisplay(Entry ent) {
        name.setText(ent.getName());
        day.setText(String.valueOf(ent.getDay()));
        month.setText(String.valueOf(ent.getMonth()));
        year.setText(String.valueOf(ent.getYear()));
        hours.setText(String.valueOf(ent.getHour()));
        mins.setText(String.valueOf(ent.getMin()));
        secs.setText(String.valueOf(ent.getSec()));
        dist.setText(String.valueOf(ent.getDistance()));
    }

} // TrainingRecordGUI

