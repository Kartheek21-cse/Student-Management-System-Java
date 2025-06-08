package Driver;

import java.util.Scanner;

import Service.StudentService;

public class StudentDriver {

	public static void main(String[] args) {
		StudentService s=new StudentService();
		int choice=0;
		Scanner sc=new Scanner(System.in);
		System.out.println("--------WELCOME TO SCHOOL---------");
		do {
		System.out.println("press 1 to insert the data");
		System.out.println("press 2 to update the data");
		System.out.println("press 3 to delete the data");
		System.out.println("press 4 to fetch the data");
		System.out.println("enter 5 to EXIT");
		System.out.println("enter your choice");
	    choice=sc.nextInt();
		switch(choice) {
		case 1:
			int i=s.save();
			if(i!=0) {
				System.out.println("data saved!!!");
				}
			else {
				System.out.println("data not saved!!!");
			}
			break;
		case 2:
	       int k=s.update();
				if(k!=0) {
					System.out.println("Data updated!!!!");
				}
				else {
					System.out.println("id not found to be update");
				}
			break;
		case 3:
			int m=s.delete();
			if(m!=0) {
				System.out.println("id is deleted");
			}
			else {
				System.out.println("id not found to be deleted");
			}
			break;
		case 4:
		     int n=s.fetch();
		     if(n==0) {
		    	 System.out.println("id not found to  fetch");
		     }
			break;
		case 5:
			boolean flag=s.exits();
			if(flag) {
				System.out.println("application is closed");
			}
			else {
				System.out.println("apllication is still in use");
			}
			break;
			default:
				System.out.println("invalid input");
				break;
		}
		System.out.println();
	}while(choice!=5);
		System.out.println("come again Have a great day");
	}
}
