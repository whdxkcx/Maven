package cn.com.ssh.MvnBookSSHDemo.DAO.Hibernate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Hello world!
 *
 */

class BTNode{
	int data;
	BTNode lchild=null;
	BTNode rchild=null;
}
public class App 
{
	
	
    public static void main( String[] args )
    {
        Scanner in=new Scanner(System.in);
        String str1="ananas";
        String str2="banana";
        System.out.println(newName(str1, str2));
        
    }
    
   public static String newName(String str1,String str2) {
	   //以第一个字符串为基准
	   String s1=newNameF(str1, str2);
	   //以第二个字符串为基准
	   String s2=newNameF(str2, str1);
	   int len1=s1.length();
	   int len2=s2.length();
	   //判断以哪个字符串为基准时，获得的字符串更短。
	   if(len1>len2) return  s2;
	   else return s1;
   }
   
   
   public  static String newNameF(String str1,String str2) {
	      char ca[]=str2.toCharArray();
	      int len=str2.length();
	      String str=str1;
	      int i=0;
	      for(;i<len;i++) {
	    	  int index=str1.indexOf(ca[i]);
	    	  if(index==-1)  break;
	    	  str1=str1.substring(index+1, str1.length());
	      }
	      str=str+str2.substring(i, len);
	      return str;
   }
    
    
    static HashMap<Integer, Integer>  map=new HashMap<Integer, Integer>();
	static int max=Integer.MIN_VALUE;
    public static int maxCount(BTNode node) {
    	if(node==null) {
    		return 0;
    	}
    	//如果当前节点的值大于等于当前max，就把它的个数存储起来。并把max等于当前节点的值
    	if(max<=node.data) {
    		max=node.data;
    	if(map.containsKey(node.data)) {
    		map.put(node.data, map.get(node.data)+1);
    	}
    	    else map.put(node.data,1);
    	}
    	maxCount(node.lchild);
    	maxCount(node.rchild);
    	return map.get(max);
    }
    
    
    
    
    
    public static char firstThree(String s) {
    	char[] ca=s.toCharArray();
    	HashMap<Character, Integer>  map=new HashMap<Character, Integer>();
    	int len=ca.length;
    	//若字符串长度为0，则返回空字符串
    	if(len==0) return  ' ';
    	for(int i=0;i<len;i++) {
    		if(map.containsKey(ca[i])) {
    			map.put(ca[i], map.get(ca[i])+1);
    			//如果当前字符的个数为3，则必是第一个出现3次的字符，直接返回即可
    			if(map.get(ca[i])==3) {
    				return ca[i];
    			}
    		}
    		else map.put(ca[i],1);
    	}
    	//否则，没有出现3次的字符，返回空
    	return ' ';
    }
    
    
   
}
