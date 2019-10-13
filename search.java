package signalproject;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;



public class search {
	public List <String > linename= new ArrayList<>();//�洢������
	 int count =0;
	 String name="";
     private List<station> outList = new ArrayList<station>();//��¼��������վ��
     public void search(station s1,station s2) throws IOException {
    	 
    	 if(outList.size() == subway.totalStaion){
    		
    		 System.out.println("�ҵ�Ŀ��վ�㣺"+s2.getName()+"��������"+(s1.getAllPassedStations(s2).size()-1)+"վ");
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
         if(s1.getOrderSetMap().isEmpty()){//������վ��OrderSetMapΪ�գ����һ�������վ��ǰ��վ���ʼ��֮
             List<station> Linkedstations = getAllLinkedStations(s1);
             for(station s : Linkedstations){
                s1.getAllPassedStations(s).add(s);
             }
         }
         station parent = getShortestPath(s1);//��ȡ�������վs1�����վ
         
         if(parent == s2){
             System.out.println("�ҵ�Ŀ��վ�㣺"+s2+"��������"+(s1.getAllPassedStations(s2).size()-1)+"վ");
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
             if(outList.contains(child)){//�Ѿ���������station�����ٷ���
                 continue;
             }
             int shortestPath = (s1.getAllPassedStations(parent).size()-1) + 1;//ǰ�����1��ʾ����·����Ҫȥ������վ�㣬�������1��ʾ������1վ����
             if(s1.getAllPassedStations(child).contains(child)){ //���s1�Ѿ����������station�ľ��룬��ô�Ƚϳ���С�ľ���
                 if((s1.getAllPassedStations(child).size()-1) > shortestPath){  //����s1����Χ��վ����С·��
                     s1.getAllPassedStations(child).clear();
                     s1.getAllPassedStations(child).addAll(s1.getAllPassedStations(parent));
                     s1.getAllPassedStations(child).add(child);
                 }
             } else {        //���s1��û�м��������station�ľ���

            	 s1.getAllPassedStations(child).addAll(s1.getAllPassedStations(parent));
                 s1.getAllPassedStations(child).add(child);
             }
         }
         outList.add(parent);
         search(s1,s2);
     }
     // Dijkstra �㷨
     private station getShortestPath(station station){ //stationվ������վ����̾��룬ÿ��������վ����Ϊһ

    	 int minPatn = Integer.MAX_VALUE;
         station rets = null;
         for(station s :station.getOrderSetMap().keySet()){
             if(outList.contains(s)){
                 continue;
             }
             LinkedHashSet<station> set  = station.getAllPassedStations(s);//����station��sվ������������վ��ļ���
             if(set.size() < minPatn){
                 minPatn = set.size();
                 rets = s;
             }
         }
         return rets;
     }
     private List<station> getAllLinkedStations(station station){ //��ȡ����stationֱ������������վ
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
