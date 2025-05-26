package Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import Entity.Student;

public class StudentService {
       Scanner sc=new Scanner(System.in);
       private static String url="jdbc:postgresql://localhost:5432/studentdetails?user=postgres&password=123";
       private static Connection conn;
       static {
    	   try {
    		   Class.forName("org.postgresql.Driver");
    		   conn=DriverManager.getConnection(url);
    		   
    	   }
    	   catch(Exception e) {
    		   e.printStackTrace();
    	   }
       }
       Student s=new Student();
       public  int save() {
    	   System.out.println("How many Student records you need to store");
    	   int k=sc.nextInt();
    	   int res=0;
    	   for(int i=1;i<=k;i++) {
    	    res=0;
    	   System.out.println("Enter the Student id");
    	   int id=sc.nextInt();
    	   System.out.println("Enter the Student name");
    	   String name=sc.next();
    	   System.out.println("Enter the Student age");
    	   int age=sc.nextInt();
    	   System.out.println("Enter the Student course");
    	   String course=sc.next();
    	   
    	   s.setId(id);
    	   s.setName(name);
    	   s.setAge(age);
    	   s.setCourse(course);
    	   try {
    		   String sql="Insert into student values(?,?,?,?)";
    		   PreparedStatement pstm=conn.prepareStatement(sql);
    		   pstm.setInt(1, s.getId());
    		   pstm.setString(2,s.getName());
    		   pstm.setInt(3, s.getAge());
    		   pstm.setString(4, s.getCourse());
    		   res=pstm.executeUpdate();
    		   
    	   }
    	   catch(Exception e) {
    		   e.printStackTrace();
    	   }
       }
    	   return res;
      }
       
       public int update() {
    	   System.out.println("enter the id you want to update");
    	   int id=sc.nextInt();
			System.out.println("press 1 to update the name");
			System.out.println("press 2 to update the age");
			System.out.println("press 3 to update the course");
			System.out.println("enter your choice");
			int choice=sc.nextInt();
			if(choice==1) {
				int res=0;
				System.out.println("enter the new name");
				String name=sc.next();
    	   try {
    		   String sql="update student set name=? where id=?";
    		   PreparedStatement pstm=conn.prepareStatement(sql);
    		   s.setName(name);
    		   pstm.setString(1,s.getName());
    		   pstm.setInt(2,id); 
    		   res=pstm.executeUpdate();
    		   }
    	   catch(Exception e) {
    		   e.printStackTrace();    	  
    		   }
    	   return res;
       }
			else if(choice==2) {
				System.out.println("enter the new age");
				int age=sc.nextInt();
				int res=0;
    	   try {
    		   String sql="update student set age=? where id=?";
    		   PreparedStatement pstm=conn.prepareStatement(sql);
    		   s.setAge(age);
    		   pstm.setInt(1,s.getAge());
    		   pstm.setInt(2,id); 
    		   res=pstm.executeUpdate();
    		   }
    	   catch(Exception e) {
    		   e.printStackTrace();    	  
    		   }
    	   return res;
			}
			else if(choice==3) {
				System.out.println("enter the new course");
				String course=sc.next();
				int res=0;
    	   try {
    		   String sql="update student set course=? where id=?";
    		   PreparedStatement pstm=conn.prepareStatement(sql);
    		   s.setCourse(course);
    		   pstm.setString(1,s.getCourse());
    		   pstm.setInt(2,id);  
    		   res=pstm.executeUpdate();
    		   }
    	   catch(Exception e) {
    		   e.printStackTrace();    	  
    		   }
    	   return res;
			}
			else {
				return 0;
			}
       }
       public int delete() {
    	   System.out.println("Enter the id want to delete");
    	   int res=0;
    	   int id=sc.nextInt();
    	   try {
    		   String sql="delete from student where id=?";
    		   PreparedStatement pstm=conn.prepareStatement(sql);
    		   pstm.setInt(1, id);
    		   res=pstm.executeUpdate();
    	   }
    	   catch(Exception e) {
    		   e.printStackTrace();
    	   }
    	   return res;
       }
       public int fetch() {
    	   System.out.println("press 1 to fetch particular id");
    	   System.out.println("press 2 to fetch all details");
    	   System.out.println("enter your choice");
    	   int i=sc.nextInt();
    	   if(i==1) {
    	   System.out.println("enter the id you want to fetch");
    	   int id=sc.nextInt();
    	   int res=0;
    	   try {
    		   String sql="select * from student where id=?";
    		   PreparedStatement pstm=conn.prepareStatement(sql);
    		   pstm.setInt(1, id);
    		  ResultSet rs=pstm.executeQuery();
    		  while(rs.next()) {
    			  System.out.print("ID :"+rs.getInt(1)+" ");
    			  System.out.print("Name :"+rs.getString(2)+" ");
    			  System.out.print("Age :"+rs.getInt(3)+" ");
    			  System.out.print("Course :"+rs.getString(4)+" ");
    			  System.out.println();
    			  break;
    		  }
    		  res=1;
    	   }
    	   catch(Exception e) {
    		   e.printStackTrace();
    		   }
    	   return res;
    	   }
    	   else if(i==2) {
    		   int res=0;
        	   try {
        		   String sql="select * from student";
        		   PreparedStatement pstm=conn.prepareStatement(sql);
        		  ResultSet rs=pstm.executeQuery();
        		  while(rs.next()) {
        			  System.out.print("ID :"+rs.getInt(1)+" ");
        			  System.out.print("Name :"+rs.getString(2)+" ");
        			  System.out.print("Age :"+rs.getInt(3)+" ");
        			  System.out.print("Course :"+rs.getString(4)+" ");
        			  System.out.println();
        		  }
        		  res=1;
        	   }
        	   catch(Exception e) {
        		   e.printStackTrace();
        		   }
        	   return res;
    	   }
    	   else
    		   return 0;
       }
       public boolean exits() {
    	   boolean flag=false;
    	   try {
    		   conn.close();
    		   flag=true;
    	   }
    	   catch(Exception e) {
    	   e.printStackTrace();
       }
       return flag;
       }
}
