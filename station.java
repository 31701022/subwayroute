package signalproject;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
  
//站点类，用于存储站点名和对应线路以及前后站点
public class station {

     private String name;
     public station prev; 
     public station next; 
     private Map<station,LinkedHashSet<station>> orderSetMap = new HashMap<station,LinkedHashSet<station>>();
     private  String line;
     public station (String name){
         this.name = name;
     }
     public String getLine() {
    	 return line;
     }
     public void setLine(String line) {
         this.line = line;
     }
     public String getName() {
         return name;
     }
   
     public void setName(String name) {
         this.name = name;
     }
      
     public LinkedHashSet<station> getAllPassedStations(station station) {
         if(orderSetMap.get(station) == null){
             LinkedHashSet<station> set = new LinkedHashSet<station>();
             set.add(this);
             orderSetMap.put(station, set);
         }
         return orderSetMap.get(station);
     }
   
     public Map<station, LinkedHashSet<station>> getOrderSetMap() {
         return orderSetMap;
     }
      
     @Override
     public boolean equals(Object obj) {
         if(this == obj){
             return true;
         } else if(obj instanceof station){
        	 station s = (station) obj;
            if(s.getName().equals(this.getName())){
                 return true;
            } else {
                 return false;
             }
         } else {
             return false;
         }
     }
      
     @Override
     public int hashCode() {
         return this.getName().hashCode();
    }
   
 }