package signalproject;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;



public class search {
	public List <String > linename= new ArrayList<>();//存储输出结果
	 int count =0;
	 String name="";
     private List<station> outList = new ArrayList<station>();//记录分析过的站点
     public void search(station s1,station s2) throws IOException {
    	 
    	 if(outList.size() == subway.totalStaion){
    		
    		 System.out.println("找到目标站点："+s2.getName()+"，共经过"+(s1.getAllPassedStations(s2).size()-1)+"站");
    		 name=s1.getLine();
    		 for(station station : s1.getAllPassedStations(s2)){
    			 count++;
    			if(name!=station.getLine()) {
    			 System.out.println(station.getLine());
    			 linename.add(station.getLine());
    			}
    			 if(count==s1.getAllPassedStations(s2).size()) {
    			 System.out.print(station.getName());
    			 linename.add(station.getName());
    			}
    			 else {
    				 System.out.print(station.getName()+"->");
    				 linename.add(station.getName());
    			 }
    			 name=station.getLine();
    }
        return;
    	         }
    	
         if(!outList.contains(s1)){
             outList.add(s1);
         }
         if(s1.getOrderSetMap().isEmpty()){//如果起点站的OrderSetMap为空，则第一次用起点站的前后站点初始化之
             List<station> Linkedstations = getAllLinkedStations(s1);
             for(station s : Linkedstations){
                s1.getAllPassedStations(s).add(s);
             }
         }
         station parent = getShortestPath(s1);//获取距离起点站s1最近的站
         
         if(parent == s2){
             System.out.println("找到目标站点："+s2+"，共经过"+(s1.getAllPassedStations(s2).size()-1)+"站");
             name=s1.getLine();
             for(station station : s1.getAllPassedStations(s2)){
            		if(name!=station.getLine()) {
           			 System.out.println(station.getLine());
           			 linename.add(station.getLine());
           			}
            	 if(count==s1.getAllPassedStations(s2).size()) {
            	
    				 System.out.print(station.getName());
    				 linename.add(station.getName());
    			}
    			 else {
    				 System.out.print(station.getName()+"->");
    				 linename.add(station.getName());
    				}
             }
             return;
         }
        
         for(station child : getAllLinkedStations(parent)){
             if(outList.contains(child)){//已经分析过的station，不再分析
                 continue;
             }
             int shortestPath = (s1.getAllPassedStations(parent).size()-1) + 1;//前面这个1表示计算路径需要去除自身站点，后面这个1表示增加了1站距离
             if(s1.getAllPassedStations(child).contains(child)){ //如果s1已经计算过到此station的距离，那么比较出最小的距离
                 if((s1.getAllPassedStations(child).size()-1) > shortestPath){  //重置s1到周围各站的最小路径
                     s1.getAllPassedStations(child).clear();
                     s1.getAllPassedStations(child).addAll(s1.getAllPassedStations(parent));
                     s1.getAllPassedStations(child).add(child);
                 }
             } else {        //如果s1还没有计算过到此station的距离

            	 s1.getAllPassedStations(child).addAll(s1.getAllPassedStations(parent));
                 s1.getAllPassedStations(child).add(child);
             }
         }
         outList.add(parent);
         search(s1,s2);
     }
     // Dijkstra 算法
     private station getShortestPath(station station){ //station站到各个站的最短距离，每相邻两个站距离为一

    	 int minPatn = Integer.MAX_VALUE;
         station rets = null;
         for(station s :station.getOrderSetMap().keySet()){
             if(outList.contains(s)){
                 continue;
             }
             LinkedHashSet<station> set  = station.getAllPassedStations(s);//参数station到s站所经过的所有站点的集合
             if(set.size() < minPatn){
                 minPatn = set.size();
                 rets = s;
             }
         }
         return rets;
     }
     private List<station> getAllLinkedStations(station station){ //获取参数station直接相连的所有站
         List<station> result = new ArrayList<station>();
         for(List<station> line : subway.lineSet){
             if(line.contains(station)){
            	 station s = line.get(line.indexOf(station));
                 if(s.prev != null){
                     result.add(s.prev);
                 }
                 if(s.next != null){
                     result.add(s.next);
                 }
             }
         }
         
         return result;
     }

     }
