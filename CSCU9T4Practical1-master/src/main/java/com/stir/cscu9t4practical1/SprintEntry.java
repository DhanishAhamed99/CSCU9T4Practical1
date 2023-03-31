/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.stir.cscu9t4practical1;


/**
 *
 * @author Dhanish03
 */
public class SprintEntry extends Entry{
   
    protected int repetitions;
    protected int recovery;
    
    public SprintEntry(String n, int d, int m, int y, int h, int min, int s, float dist, int reps, int rec){
    super(n,d,m,y,h,min,s,dist);
    repetitions = reps; 
    recovery = rec;
    } //Constructor
    
    public int getRepetitions(){
    return repetitions;
    } //getRepetitions
    
    public int getRecovery(){
        return recovery;
    }
    
    @Override
   public String getEntry () {
   String result = getName()+ " sprinted " + getRepetitions() + "x" + getDistance() + "m in "
             +getHour()+":"+getMin()+":"+ getSec() +" with " + getRecovery()+ " minutes recovery on "
             +getDay()+"/"+getMonth()+"/"+getYear()+"\n";
   return result;
  } //getEntry
    
    
}
