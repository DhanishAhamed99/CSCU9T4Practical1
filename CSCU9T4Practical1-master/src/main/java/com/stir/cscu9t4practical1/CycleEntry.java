/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.stir.cscu9t4practical1;

/**
 *
 * @author Dhanish03
 */
public class CycleEntry extends Entry{
     private String terrain;
     private String tempo;
     
     public CycleEntry(String n, int d, int m, int y, int h, int min, int s, float dist, String ter, String tem){
          super(n,d,m,y,h,min,s,dist);
          terrain = ter;
          tempo = tem;
     }
    
     public String getTerrain(){
         return terrain;
     }//getTerrain
     
     public String getTempo(){
         return tempo;
     }//getTempo
     
     @Override
     public String getEntry () {
         String result = getName()+" cycled " + getDistance() + " km in "
         +getHour()+":"+getMin()+":"+ getSec() + " on "
         +getDay()+"/"+getMonth()+"/"+getYear()+ " on " + getTerrain() + " at "+ getTempo() + " tempo\n";
         return result;
  } //getEntry
}
