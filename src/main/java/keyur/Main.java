package keyur;

import java.io.FileNotFoundException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import dao.Employee;
import dao.Student;
import dao.StudentHostel;
import dao.Teacher;

public class Main {
	
	/**
	 * @param args
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 * @throws ParseException
	 */
	
	//We Assume our database name is "finalP"
	
	public static void main (String[] args) throws ClassNotFoundException, SQLException, ParseException {
		System.out.println(" Welcome to The University DataBase Managment System");
		
		String[] databaseTablesToBeIn = {"admin","courses","departmentnames","employee","employeephonenumbers","emppassword","expertise","hostels","projects","student","studentenroll","studenthasfeetype","studenthostel","studentphonenumbers","stupassword","supervisor","taugthby","teacher","typesoffee"};
		
		HashSet<String> set = new HashSet<>();
		
		for(int i = 0;i<databaseTablesToBeIn.length;i++) {
			set.add(databaseTablesToBeIn[i]);
		}
		
		ConnectionUtils.initialCheck();
		
		set = ConnectionUtils.checkTables(set);
		
		HashSet<String> firstDependent = new HashSet<>(),secondDependent = new HashSet<>();
		
		firstDependent.add("admin");
		firstDependent.add("employeephonenumbers");
		firstDependent.add("studenthostel");
		firstDependent.add("studentphonenumbers");
		firstDependent.add("teacher");
		firstDependent.add("typesoffee");
		
		secondDependent.add("courses");
		secondDependent.add("expertise");
		secondDependent.add("projects");
		secondDependent.add("studentenroll");
		secondDependent.add("studenthasfeetype");
		secondDependent.add("supervisor");
		secondDependent.add("taugthby");
		
		HashSet<String> views = new HashSet<>();
		views.add("emppassword");
		views.add("stupassword");
		
		for(String name : set) {
			
			if(views.contains(name) || firstDependent.contains(name) || secondDependent.contains(name)) {
				continue;
			}
			
			try {
				ConnectionUtils.runScript(name);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		for(String name : set) {
			if(views.contains(name) || secondDependent.contains(name)) {
				continue;
			}
			
			try {
				ConnectionUtils.runScript(name);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		for(String name : set) {
			if(views.contains(name)) {
				continue;
			}
			
			try {
				ConnectionUtils.runScript(name);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		for(String name : set) {
			try {
				ConnectionUtils.runScript(name);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		HashSet<String> triggersToBeIn = new HashSet<>();
		triggersToBeIn.add("checkAgeInsert");
		triggersToBeIn.add("checkAgeUpdate");
		
		triggersToBeIn = ConnectionUtils.checkTrigger(triggersToBeIn);
		
		for(String name : triggersToBeIn) {
			try {
				ConnectionUtils.runScript(name);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		HashSet<String> proceduresToBeIn = new HashSet<>();
		proceduresToBeIn.add("getFeeAmounOfStudent");
		proceduresToBeIn.add("getMarksCnameConame");
		proceduresToBeIn.add("getRoomNumberAndHostel");
		
		proceduresToBeIn = ConnectionUtils.checkProcedure(proceduresToBeIn);
		
		for(String name : proceduresToBeIn) {
			try {
				ConnectionUtils.runScript(name);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		Scanner scan = new Scanner(System.in);
		
		while(true) {
		
			System.out.println("For Insert data Press 1");
			System.out.println("For Update data press 2");
			System.out.println("For Delete data press 3");
			System.out.println("For query about student hostel data press 4");
			System.out.println("For query about student Fee data press 5");
			System.out.println("For query about student Fee data press 6 course");
			System.out.println("for custom press 8");
			System.out.println("Exit press 8");
			
			int pp = scan.nextInt();
			
			if(pp==1) {
				System.out.println("For insert into student table press 1");
				System.out.println("For insert into studentHostel table press 2");
				System.out.println("For insert into Employee table press 3");
				System.out.println("For insert into StudentEnroll table press 4");
				
				int n = scan.nextInt();
				
				if(n==1) {
					Student st = new Student();
					
					String s = "";
					System.out.println("Enter Student Id");
					s = scan.next();
					st.setStudentId(s);
					System.out.println("Enter Student Name");
					s = scan.next();
					st.setStudentName(s);
					System.out.println("Enter Student Email");
					s = scan.next();
					st.setStudentEmail(s);
					System.out.println("Enter Student Dob");
					try {
					s = scan.next();
					SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
					java.util.Date date = sdf1.parse(s);
					java.sql.Date sqlDate = new java.sql.Date(date.getTime()); 
					st.setStudentDob(sqlDate);
					} catch(Exception e) {
						
					}
					
					System.out.println("Enter Student Pincode");
					s = scan.next();
					st.setStudentPincode(s);
					System.out.println("Enter Student City");
					s = scan.next();
					st.setStudentCity(s);
					System.out.println("Enter Student Branch");
					s = scan.next();
					st.setStudentBranch(s);
					System.out.println("Enter Student programme");
					s = scan.next();
					st.setStudentProgramme(s);
					System.out.println("Enter Student Class");
					s = scan.next();
					st.setStudentClass(s);
					System.out.println("Enter Student Portal Password");
					s = scan.next();
					st.setStudentPortalPassword(s);
					
					ConnectionUtils.insertIntoStudent(st);
				} else if (n==2) {
					StudentHostel st = new StudentHostel();
					
					String s = "";
					System.out.println("Enter Student Id");
					s = scan.next();
					st.setStudentId(s);
					
					System.out.println("Enter Student Hostel Id");
					
					s = scan.next();
					st.setStudentHostelId(s);
					
					System.out.println("Enter Hostel Id");
					
					int p = scan.nextInt();
					st.setHostelId(p);
					
					System.out.println("Enter Student Romm number");
					
					p = scan.nextInt();
					st.setStudentRoomNumber(p);
					
					ConnectionUtils.insertIntoStudentHostel(st);
				} else if (n == 3) {
					Employee st = new Employee();
					
					String s = "";
					System.out.println("Enter Employee Id");
					s = scan.next();
					st.setEmployeeId(s);
					
					scan.nextLine();
					System.out.println("Enter Employee Name");
					s = scan.nextLine();
					st.setEmployeeName(s);
					
					System.out.println("Enter Employee Email");
					s = scan.next();
					st.setEmployeeEmail(s);
					
					System.out.println("Enter Student Joining Date");
					s = scan.next();
					try {
						SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
						java.util.Date date = sdf1.parse(s);
						java.sql.Date sqlDate = new java.sql.Date(date.getTime()); 
						st.setDate(sqlDate);
						} catch(Exception e) {
							
					}
					
					System.out.println("Enter Employee Pincode");
					s = scan.next();
					st.setEmployeePincode(s);
					System.out.println("Enter Employee City");
					s = scan.next();
					st.setEmployeeCity(s);
					
					System.out.println("Enter Employee Highest Degree");
					s = scan.next();
					st.setEmployeeHighestDegree(s);
	
					System.out.println("Enter Employee Portal Password");
					s = scan.next();
					st.setEmployeePortalPassword(s);
					
					System.out.println("Enter Employee is teacher or not");
					int ppp = scan.nextInt();
					st.setIsTeacher(ppp);
					
					ConnectionUtils.insertIntoEmployee(st);
				} else if (n == 4) {
					Teacher st = new Teacher();
					
					String s = "";
					System.out.println("Enter Employee Id");
					s = scan.next();
					st.setEmployeeId(s);
					
					System.out.println("Enter Department Id");
					s = scan.next();
					st.setDepartmentId(s);
					
					System.out.println("Enter Employee Post");
					s = scan.next();
					st.setEmployeePost(s);
					
					ConnectionUtils.insertIntoTeacher(st);
				}
			} else if (pp == 2 || pp == 3 || pp == 7) {
				System.out.println("Please Enter Custom Query");
				String s;
				Scanner ss = new Scanner (System.in);
				s = ss.nextLine();
				
				try {
					
					Connection con = ConnectionUtils.getConnection();
					PreparedStatement st = con.prepareStatement(s);
					st.executeUpdate();
					
				} catch(Exception e) {
					System.out.println("Something Went Wrong");
					System.out.println(e.getMessage());
				}
				ss.close();
			} else if (pp == 4) {
				Connection con = ConnectionUtils.getConnection();
				
				System.out.println("Enter Strudent Id");
				
				String s = scan.next();
				CallableStatement cmt =  con.prepareCall("{call getRoomNumberAndHostel(?, ? ,? )}");
				cmt.setString(1, s);
				cmt.registerOutParameter(2, Types.INTEGER);
				cmt.registerOutParameter(3, Types.VARCHAR);
				
				cmt.executeUpdate();
				
				int roomNumber = cmt.getInt(2);
				String hname = cmt.getString(3);
				
				System.out.println("Room number " + roomNumber + " HostelName " + hname);
			} else if (pp== 5) {
				Connection con = ConnectionUtils.getConnection();
				
				System.out.println("Enter Strudent Id");
				
				String s = scan.next();
				CallableStatement cmt =  con.prepareCall("{call getFeeAmounOfStudent(?, ? )}");
				cmt.setString(1, s);
				cmt.registerOutParameter(2, Types.INTEGER);
				
				cmt.executeUpdate();
				
				int roomNumber = cmt.getInt(2);
				
				System.out.println("Fee Amount " + roomNumber);
			} else if (pp == 6) {
				Connection con = ConnectionUtils.getConnection();
				
				System.out.println("Enter Strudent Id");
				String s = scan.next();
				System.out.println("Enter Course id");
				String ss = scan.next();
				
				CallableStatement cmt =  con.prepareCall("{call getMarksCnameConame(?, ?, ?, ?, ? )}");
				cmt.setString(1, s);
				cmt.setString(2, ss);
				cmt.registerOutParameter(3, Types.INTEGER);
				cmt.registerOutParameter(4, Types.VARCHAR);
				cmt.registerOutParameter(5, Types.VARCHAR);
				
				cmt.executeUpdate();
				
				System.out.println("marks " + cmt.getInt(3) + " Course name " + cmt.getString(4) + " Coordinator name " + cmt.getString(5));
			} else if (pp == 8){
				break;
			}
			
		}
	}
}
