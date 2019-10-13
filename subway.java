package signalproject;

import java.io.File;  
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.io.BufferedReader;  
import java.io.BufferedWriter;  
import java.io.FileInputStream;  
import java.io.FileWriter;
import java.io.IOException;  
  
public class subway { 
	private static List<station> line1 = new ArrayList<station>();//1����
	private static List<station> line2 = new ArrayList<station>();
	private static List<station> line4 = new ArrayList<station>();
	private static List<station> line5 = new ArrayList<station>();
	private static List<station> line6 = new ArrayList<station>();
	private static List<station> line7 = new ArrayList<station>();
	private static List<station> line8 = new ArrayList<station>();
	private static List<station> line9 = new ArrayList<station>();
	private static List<station> line10 = new ArrayList<station>();
	private static List<station> line13 = new ArrayList<station>();
	private static List<station> line14 = new ArrayList<station>();
	private static List<station> line15 = new ArrayList<station>();
	private static List<station> line16 = new ArrayList<station>();
	private static List<station> linebatong = new ArrayList<station>();
	private static List<station> linechangping = new ArrayList<station>();
	private static List<station> lineyizhuang = new ArrayList<station>();
	private static List<station> linefangshan = new ArrayList<station>();
	private static List<station> lineshoudujicahng = new ArrayList<station>();
	private static List<station> linedaxing = new ArrayList<station>();
	private static List<String> linename = new ArrayList<String>();
	private static List<station> lines1 = new ArrayList<station>();
	public static Set<List<station>> lineSet = new HashSet<List<station>>();//�����߼���
	private static ArrayList<List<station>> lists = new ArrayList<List<station>>();
	public static int totalStaion = 0;//�ܵ�վ������

	
	public static void main(String[] args) throws IOException {
		int arg =0;
    	try{
    		for(;arg<args.length;arg++) {
    		if(args[arg].equals("-map")) {
		lists.add(line1);
		lists.add(line2);
		lists.add(line4);
		lists.add(line5);
		lists.add(line6);
		lists.add(line7);
		lists.add(line8);
		lists.add(line9);
		lists.add(line10);
		lists.add(line13);
		lists.add(line14);
		lists.add(line15);
		lists.add(line16);
		lists.add(linebatong);
		lists.add(linechangping);
		lists.add(lineyizhuang);
		lists.add(linefangshan);
		lists.add(lineshoudujicahng);
		lists.add(linedaxing);
		lists.add(lines1);

     
        	File filename=new File(args[arg+1]);
	    	InputStreamReader reader=new InputStreamReader(new FileInputStream(filename));
	        BufferedReader br=new BufferedReader(reader);
        // ����һ�����������ļ�����ת�ɼ�����ܶ���������  
            String line = "";  
            line = br.readLine(); 
           
            String[] line1s = line.split("��");
            for(String s : line1s){
                linename.add(s);
            }
            for(int j=0;j<lists.size();j++) {
            if(line != null) { 
                line = br.readLine();
                String[] lines = line.split("��");
                
                for(String s : lines){
                	station sa1=new station(s);
                	sa1.setLine(linename.get(j));
                    lists.get(j).add(sa1);
                }
                for(int i =0;i<lists.get(j).size();i++){
                    if(i<lists.get(j).size()-1){
                    	lists.get(j).get(i).next = lists.get(j).get(i+1);
                    	lists.get(j).get(i+1).prev = lists.get(j).get(i);
                    }
                }
            }
            }
       
//        for(int k=0;k<lists.size();k++)
//        System.out.println(lists.get(k).get(1).getName());
        
        for(int k=0;k<lists.size();k++)
        	totalStaion=lists.get(k).size()+totalStaion;
        
        lineSet.add(line1);
        lineSet.add(line2);
        lineSet.add(line4);
        lineSet.add(line5);
        lineSet.add(line6);
        lineSet.add(line7);
        lineSet.add(line8);
        lineSet.add(line9);
        lineSet.add(line10);
        lineSet.add(line13);
		lineSet.add(line14);
		lineSet.add(line15);
		lineSet.add(line16);
		lineSet.add(linebatong);
		lineSet.add(linechangping);
		lineSet.add(lineyizhuang);
		lineSet.add(linefangshan);
		lineSet.add(lineshoudujicahng);
		lineSet.add(linedaxing);
		lineSet.add(lines1);
		System.out.println("��õ�ͼ�ɹ�");
       	    break;
       	    }
    		}
       	}catch (IOException e) {
       		System.out.println("�ļ�������󣬶�ȡ�ļ�ʧ��");
       	}

       	if(arg==args.length) {System.out.println("map����ƥ��ʧ��");
       	return;}
       	else {
        	//ָ����·��վ��
        	int i=0;
        	for(;i<args.length;i++) {
        		if(args[i].equals("-a")) {
        			int w=0;
        			for(;w<args.length;w++) {
        				if(args[w].equals("-o")) {
    	    				File writeName=new File(args[w+1]);
    	    				writeName.createNewFile();
    	    				FileWriter writer=new FileWriter(writeName);
    	    				BufferedWriter out=new BufferedWriter(writer);
    	    				if(args[i+1].equals("1����")) {
    	    					 System.out.println("������·�ɹ�");
    	    					out.write("1���ߣ�"+"\r\n");
    	    					for(station node:line1) {
    	    						out.write(node.getName()+"\r\n");
    	    					}
    	    					out.flush();
    		    				out.close();
    	    				}
    	    				else if(args[i+1].equals("2����")) {
    	    					System.out.println("������·�ɹ�");
    	    					out.write("2���ߣ�"+"\r\n");
    	    					for(station node:line2) {
    	    						out.write(node.getName()+"\r\n");
    	    					}
    	    					out.flush();
    		    				out.close();
    	    				}
    	    				else if(args[i+1].equals("4����")) {
    	    					 System.out.println("������·�ɹ�");
        						out.write("3���ߣ�"+"\r\n");
    	    					for(station node:line4) {
    	    						out.write(node.getName()+"\r\n");
    	    					}
    	    					out.flush();
    		    				out.close();
    	    				}
    	    				else if(args[i+1].equals("5����")) {
    	    					 System.out.println("������·�ɹ�");
        						out.write("5���ߣ�"+"\r\n");
    	    					for(station node:line5) {
    	    						out.write(node.getName()+"\r\n");
    	    					}
    	    					out.flush();
    		    				out.close();
    	    				}
    	    				else if(args[i+1].equals("6����")) {
    	    					 System.out.println("������·�ɹ�");
        						out.write("6���ߣ�"+"\r\n");
    	    					for(station node:line6) {
    	    						out.write(node.getName()+"\r\n");
    	    					}
    	    					out.flush();
    		    				out.close();
    	    				}
    	    				else if(args[i+1].equals("7����")) {
    	    					 System.out.println("������·�ɹ�");
        						out.write("7���ߣ�"+"\r\n");
       	    					for(station node:line7) {
    	    						out.write(node.getName()+"\r\n");
    	    					}
    	    					out.flush();
    		    				out.close();
    	    				}
    	    				else if(args[i+1].equals("8����")) {
    	    					 System.out.println("������·�ɹ�");

        						out.write("8���ߣ�"+"\r\n");

    	    					for(station node:line8) {
    	    						out.write(node.getName()+"\r\n");
    	    					}
    	    					out.flush();
    		    				out.close();
    	    				}
    	    				else if(args[i+1].equals("9����")) {

    	    					 System.out.println("������·�ɹ�");
        						out.write("9���ߣ�"+"\r\n");
    	    					for(station node:line9) {
    	    						out.write(node.getName()+"\r\n");
    	    					}
    	    					out.flush();
    		    				out.close();
    	    				}else if(args[i+1].equals("10����")) {
    	    						 System.out.println("������·�ɹ�");
    	    						out.write("10���ߣ�"+"\r\n");
    	    						for(station node:line10) {

    		    						out.write(node.getName()+"\r\n");
    		    					}
    	    						out.flush();
    	    	    				out.close();
    	    					}

    	    					else if(args[i+1].equals("13����")) {

    	    						 System.out.println("������·�ɹ�");

    	    						out.write("13���ߣ�"+"\r\n");
    	    						for(station node:line13) {
    		    						out.write(node.getName()+"\r\n");
    	    						}
    	    						out.flush();
    	    	    				out.close();
    	    					}
    	    					else if(args[i+1].equals("14����")) {

   	    						 System.out.println("������·�ɹ�");

   	    						out.write("14���ߣ�"+"\r\n");
   	    						for(station node:line13) {
   		    						out.write(node.getName()+"\r\n");
   	    						}
   	    						out.flush();
   	    	    				out.close();
   	    					}
    	    					else if(args[i+1].equals("15����")) {

   	    						 System.out.println("������·�ɹ�");

   	    						out.write("15���ߣ�"+"\r\n");
   	    						for(station node:line13) {
   		    						out.write(node.getName()+"\r\n");
   	    						}
   	    						out.flush();
   	    	    				out.close();
   	    					}
    	    				
    	    					else if(args[i+1].equals("16����")) {

   	    						 System.out.println("������·�ɹ�");

   	    						out.write("16���ߣ�"+"\r\n");
   	    						for(station node:line13) {
   		    						out.write(node.getName()+"\r\n");
   	    						}
   	    						out.flush();
   	    	    				out.close();
   	    					}
    	    					else if(args[i+1].equals("��ͨ��")) {

   	    						 System.out.println("������·�ɹ�");

   	    						out.write("��ͨ�ߣ�"+"\r\n");
   	    						for(station node:line13) {
   		    						out.write(node.getName()+"\r\n");
   	    						}
   	    						out.flush();
   	    	    				out.close();
   	    					}
    	    					else if(args[i+1].equals("��ƽ��")) {

      	    						 System.out.println("������·�ɹ�");

      	    						out.write("��ƽ�ߣ�"+"\r\n");
      	    						for(station node:line13) {
      		    						out.write(node.getName()+"\r\n");
      	    						}
      	    						out.flush();
      	    	    				out.close();
      	    					}
    	    					else if(args[i+1].equals("��ׯ��")) {

      	    						 System.out.println("������·�ɹ�");

      	    						out.write("��ׯ�ߣ�"+"\r\n");
      	    						for(station node:line13) {
      		    						out.write(node.getName()+"\r\n");
      	    						}
      	    						out.flush();
      	    	    				out.close();
      	    					}
    	    					else if(args[i+1].equals("��ɽ��")) {

      	    						 System.out.println("������·�ɹ�");

      	    						out.write("��ɽ�ߣ�"+"\r\n");
      	    						for(station node:line13) {
      		    						out.write(node.getName()+"\r\n");
      	    						}
      	    						out.flush();
      	    	    				out.close();
      	    					}
    	    					else if(args[i+1].equals("������")) {

     	    						 System.out.println("������·�ɹ�");

     	    						out.write("�����ߣ�"+"\r\n");
     	    						for(station node:line13) {
     		    						out.write(node.getName()+"\r\n");
     	    						}
     	    						out.flush();
     	    	    				out.close();
     	    					}
    	    					else if(args[i+1].equals("�׶�������")) {

     	    						 System.out.println("������·�ɹ�");

     	    						out.write("�׶������ߣ�"+"\r\n");
     	    						for(station node:line13) {
     		    						out.write(node.getName()+"\r\n");
     	    						}
     	    						out.flush();
     	    	    				out.close();
     	    					}
    	    					else if(args[i+1].equals("S1��")) {

    	    						 System.out.println("������·�ɹ�");

    	    						out.write("S1�ߣ�"+"\r\n");
    	    						for(station node:line13) {
    		    						out.write(node.getName()+"\r\n");
    	    						}
    	    						out.flush();
    	    	    				out.close();
    	    					}
    	    					else {
    	    						System.out.println("δ�ҵ���·");
    	    					}
    	    				break;
    	    			}
        			}
        			if(w==args.length) {
        				System.out.println("�����������");
        				return;
        			}
        		       break;
        		}
        		//������·��
        		if(args[i].equals("-b")) {
        			search se = new search();
        			
        			int w=0;
        			for(;w<args.length;w++) {
    	    			try{if(args[w].equals("-o")) {
    	    				File writeName=new File(args[w+1]);
    	    				writeName.createNewFile();
    	    				se.search(new station(args[i+1]), new station(args[i+2]));
    	    				FileWriter writer=new FileWriter(writeName);
    	    				BufferedWriter out=new BufferedWriter(writer);
    	    				for(int ii=0;i<se.linename.size();i++)
    	    				out.write(se.linename.get(i)+"\r\n");
    	    				out.flush();
    	    				out.close();
    	    				break;
    	    			}
    	    			}	catch(IOException e) {
    	    				 e.printStackTrace();
    	    			}
    	    		}
        			if(w==args.length) {
        				System.out.println("�����������");
        				return;
        			}
        		
        		break;
        		}	
        	}
        	}	
}  }
       	
