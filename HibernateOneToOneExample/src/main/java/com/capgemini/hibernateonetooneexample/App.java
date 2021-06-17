package com.capgemini.hibernateonetooneexample;

import java.util.Scanner;

import com.capgemini.hibernateonetooneexample.dao.InstructorDao;
import com.capgemini.hibernateonetooneexample.entity.Instructor;
import com.capgemini.hibernateonetooneexample.entity.InstructorDetail;

public class App 
{
    public static void main( String[] args )
    {
        Instructor instructor = new Instructor("Ramya","Krishna","ramyaki@gmail.com");
        InstructorDetail instructorDetail = new InstructorDetail("www.youtube.com/ramya","Guitar");
        InstructorDao instructorDao = new InstructorDao();
        
        
        Scanner sc = new Scanner(System.in);
        char ch = 'y';
        while(ch == 'y') {
        System.out.println("Enter the transaction");
        System.out.println("insert : insert data");
        System.out.println("update : update data");
        System.out.println("delete : delete data");
        System.out.println("get : get a instructor by id");
        System.out.println("getall : get all instructor data");
        System.out.println("exit : to exit");
        String choice = sc.next();
        
        switch(choice) {
        case "insert":
            instructor.setInstructorDetail(instructorDetail);
            instructorDao.SaveInstructor(instructor);
            break;
        case "update":
        	instructor = new Instructor("Ramya","Krishna","ramkrish@gmail.com");
        	instructorDao.updateInstructor(instructor);
        	break;
        case "delete":
        	System.out.println("Enter the Instructor Id");
        	int id = sc.nextInt();
        	instructorDao.deleteInstructor(id);
        	break;
        case "get":
        	System.out.println("Enter the Instructor Id");
        	int gid = sc.nextInt();
        	Instructor instr = instructorDao.getInstructor(gid);
        	System.out.println(instr.getEmail()+"\t\t"
        	+instr.getFirstName()+"\t\t"+instr.getLastName());
        	break;
        	
        case "getall":
        	instructorDao.getAllInstructors();
        	break;
        case "exit":
        	System.exit(0);
        }
        System.out.println("do you want to continue");
        ch = sc.next().trim().charAt(0);
        }
    
    }
}
