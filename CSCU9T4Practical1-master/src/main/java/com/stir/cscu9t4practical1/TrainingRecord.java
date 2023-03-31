// An implementation of a Training Record as an ArrayList
package com.stir.cscu9t4practical1;




import java.util.*;


public class TrainingRecord {
    private List<Entry> tr;
    
    public TrainingRecord() {
        tr = new ArrayList<Entry>();
    } //constructor
    
    // add a record to the list
   public String addEntry(Entry e){
       ListIterator<Entry> iter = tr.listIterator();
       while (iter.hasNext()) {
          Entry current = iter.next();
          if (e.getName().equalsIgnoreCase(current.getName()) && e.getMonth()== current.getMonth()&& e.getDay()== current.getDay() && e.getYear()== current.getYear()){
              return("Duplicate entry entered"); 
            }     
       }
       tr.add(e);
       String result = "Record added\n" + getNumberOfEntries();
       return result;
   } // addClass
   
   // look up the entry of a given day and month
   public String lookupEntry (int d, int m, int y) {
       ListIterator<Entry> iter = tr.listIterator();
       String result = "No entries found";
       while (iter.hasNext()) {
          Entry current = iter.next();
          if (current.getDay()==d && current.getMonth()==m && current.getYear()==y) 
             result = current.getEntry();
            }
       return result;
   } // lookupEntry
   
      public String lookupEntries (int d, int m, int y) {
       ListIterator<Entry> iter = tr.listIterator();
       String result = "Sorry couldn't find anything for this date";
       String currResult;
       String finalResult = "";
       while (iter.hasNext()) {
          Entry current = iter.next();
          if (current.getDay()==d && current.getMonth()==m && current.getYear()==y){ 
             currResult = current.getEntry();
             finalResult = finalResult.concat(currResult);
             result = finalResult;
             }
        }
       return result;
       
   } // lookupAllEntry
   
   // Count the number of entries
   public int getNumberOfEntries(){
       return tr.size();
   }
   // Clear all entries
   public void clearAllEntries(){
       tr.clear();
   }
   
} // TrainingRecord