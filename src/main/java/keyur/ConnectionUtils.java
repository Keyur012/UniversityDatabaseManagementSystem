package keyur;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;

import org.apache.ibatis.jdbc.ScriptRunner;

import dao.Admin;
import dao.Courses;
import dao.DepartmentNames;
import dao.Employee;
import dao.EmployeePhoneNumbers;
import dao.Expertise;
import dao.Hostels;
import dao.Projects;
import dao.Student;
import dao.StudentEnroll;
import dao.StudentHasFeeType;
import dao.StudentHostel;
import dao.StudentPhoneNumbers;
import dao.Supervisor;
import dao.TaughtBy;
import dao.Teacher;
import dao.TypesOfFee;

import java.sql.Statement;

public class ConnectionUtils {
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		return DriverManager.getConnection("jdbc:mysql://localhost:3306/finalp","root","XXXpasswordXXX");
	}
	
	public static int insertIntoStudent(Student st) throws ClassNotFoundException, SQLException {
		int status = 0;
		
		Connection conn = ConnectionUtils.getConnection();
		
		PreparedStatement psmt = conn.prepareStatement("insert into student(studentId,studentName,studentEmail,studentDob,studentPincode,studentCity,studentBranch,studentProgramme,studentClass,studentPortalPassword) values(?,?,?,?,?,?,?,?,?,?)");
		
		int i = 1;
		psmt.setString(i++, st.getStudentId());
		psmt.setString(i++, st.getStudentName());
		psmt.setString(i++, st.getStudentEmail());
		psmt.setDate(i++, st.getStudentDob());
		psmt.setString(i++, st.getStudentPincode());
		psmt.setString(i++, st.getStudentCity());
		psmt.setString(i++, st.getStudentBranch());
		psmt.setString(i++, st.getStudentProgramme());
		psmt.setString(i++, st.getStudentClass());
		psmt.setString(i++, st.getStudentPortalPassword());
		
		status = psmt.executeUpdate();
		return status;
	}
	
	public static int insertIntoAdmin(Admin admin) throws ClassNotFoundException, SQLException {
		int status = 0;
		Connection conn = ConnectionUtils.getConnection();
		String sql = "";
		sql = "insert into admin values(?,?,?,?)";
		PreparedStatement psmt = conn.prepareStatement(sql);
		psmt.setString(1,admin.getEmployeeId());
		psmt.setInt(2, admin.getEmployeeOfficeNumber());
		psmt.setString(3, admin.getEmployeeOfficeName());
		psmt.setString(4,admin.getPost());
		
		status = psmt.executeUpdate();
		return status;
	}
	
	public static int insetIntoCourses(Courses c) throws ClassNotFoundException, SQLException {
		int status = 0;
		Connection conn = ConnectionUtils.getConnection();
		String sql = "";
		sql = "insert into courses values(?,?,?,?)";
		PreparedStatement psmt = conn.prepareStatement(sql);
		
		psmt.setString(1,c.getCouresId());
		psmt.setString(2,c.getCoordinatorId());
		psmt.setString(3,c.getCourseName());
		psmt.setInt(4, c.getCourseYear());
		
		status = psmt.executeUpdate();
		return status;
	}
	
	public static int insertIntoDepartmentNames(DepartmentNames d) throws ClassNotFoundException, SQLException {
		int status = 0;
		Connection conn = ConnectionUtils.getConnection();
		String sql = "";
		sql = "inset into departmentnames values(?,?)";
		PreparedStatement psmt = conn.prepareStatement(sql);
		
		psmt.setString(1,d.getDepartmentId());
		psmt.setString(2,d.getDepartmentName());
		
		status = psmt.executeUpdate();
		return status;
	}
	
	public static int insertIntoEmployee(Employee st) throws ClassNotFoundException, SQLException {
		int status = 0;
		Connection conn = ConnectionUtils.getConnection();
		String sql = "";
		sql = "inset into employee values(?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement psmt = conn.prepareStatement(sql);
		
		psmt.setString(1, st.getEmployeeId());
		psmt.setString(2, st.getEmployeeName());
		psmt.setString(3, st.getEmployeeEmail());
		psmt.setDate(4, st.getDate());
		psmt.setInt(5, st.getExperience());
		psmt.setString(6, st.getEmployeeHighestDegree());
		psmt.setString(7, st.getEmployeePincode());
		psmt.setString(8, st.getEmployeeCity());
		psmt.setString(9, st.getEmployeePortalPassword());
		psmt.setInt(10, st.getIsTeacher());
		
		status = psmt.executeUpdate();
		return status;
	}
	
	public static int insertIntoEmployeePhoneNumbers(EmployeePhoneNumbers d) throws ClassNotFoundException, SQLException {
		int status = 0;
		Connection conn = ConnectionUtils.getConnection();
		String sql = "";
		sql = "inset into employeephonenumbers values(?,?)";
		PreparedStatement psmt = conn.prepareStatement(sql);
		
		psmt.setString(1,d.getEmployeeId());
		psmt.setString(2,d.getEmployeePhoneNumber());
		
		status = psmt.executeUpdate();
		return status;
	}
	
	public static int insertIntoExpertise(Expertise d) throws ClassNotFoundException, SQLException {
		int status = 0;
		Connection conn = ConnectionUtils.getConnection();
		String sql = "";
		sql = "inset into expertise values(?,?)";
		PreparedStatement psmt = conn.prepareStatement(sql);
		
		psmt.setString(1,d.getEmployeeId());
		psmt.setString(2,d.getExpertise());
		
		status = psmt.executeUpdate();
		return status;
	}
	
	public static int insertIntoHostels(Hostels d) throws ClassNotFoundException, SQLException {
		int status = 0;
		Connection conn = ConnectionUtils.getConnection();
		String sql = "";
		sql = "inset into hostels values(?,?)";
		PreparedStatement psmt = conn.prepareStatement(sql);
		
		psmt.setInt(1,d.getHostelId());
		psmt.setString(2,d.getHostelName());
		
		status = psmt.executeUpdate();
		return status;
	}
	
	public static int insertIntoProjects(Projects d) throws ClassNotFoundException, SQLException {
		int status = 0;
		Connection conn = ConnectionUtils.getConnection();
		String sql = "";
		sql = "inset into projects values(?,?)";
		PreparedStatement psmt = conn.prepareStatement(sql);
		
		psmt.setString(1,d.getEmployeeId());
		psmt.setString(2,d.getProjectName());
		
		status = psmt.executeUpdate();
		return status;
	}
	
	public static int insertIntoStudentEnroll(StudentEnroll d) throws ClassNotFoundException, SQLException {
		int status = 0;
		Connection conn = ConnectionUtils.getConnection();
		String sql = "";
		sql = "inset into studentenroll values(?,?,?,?)";
		PreparedStatement psmt = conn.prepareStatement(sql);
		
		psmt.setString(1,d.getStudentId());
		psmt.setString(2,d.getCourseId());
		psmt.setInt(3, d.getYear());
		psmt.setInt(4, d.getMarks());
		
		status = psmt.executeUpdate();
		return status;
	}
	
	public static int insertIntoStudentHasFeeType(StudentHasFeeType d) throws ClassNotFoundException, SQLException {
		int status = 0;
		Connection conn = ConnectionUtils.getConnection();
		String sql = "";
		sql = "inset into studenthasfeetype values(?,?)";
		PreparedStatement psmt = conn.prepareStatement(sql);
		
		psmt.setString(1,d.getStudentId());
		psmt.setString(2,d.getFeeType());
		
		status = psmt.executeUpdate();
		return status;
	}
	
	public static int insertIntoStudentHostel(StudentHostel d) throws ClassNotFoundException, SQLException {
		int status = 0;
		Connection conn = ConnectionUtils.getConnection();
		String sql = "";
		sql = "inset into studenthostel values(?,?,?,?)";
		PreparedStatement psmt = conn.prepareStatement(sql);
		
		psmt.setString(1,d.getStudentId());
		psmt.setString(2,d.getStudentHostelId());
		psmt.setInt(3, d.getHostelId());
		psmt.setInt(4, d.getStudentRoomNumber());
		
		status = psmt.executeUpdate();
		return status;
	}
	
	public static int insertIntoStudentPhoneNumbes(StudentPhoneNumbers d) throws ClassNotFoundException, SQLException {
		int status = 0;
		Connection conn = ConnectionUtils.getConnection();
		String sql = "";
		sql = "inset into studentphonenumbers values(?,?)";
		PreparedStatement psmt = conn.prepareStatement(sql);
		
		psmt.setString(1,d.getStudentId());
		psmt.setString(2,d.getStudentPhoneNumbers());
		
		status = psmt.executeUpdate();
		return status;
	}
	
	public static int insertIntoSupervisor(Supervisor d) throws ClassNotFoundException, SQLException {
		int status = 0;
		Connection conn = ConnectionUtils.getConnection();
		String sql = "";
		sql = "inset into supervisor values(?,?)";
		PreparedStatement psmt = conn.prepareStatement(sql);
		
		psmt.setString(1,d.getSupervisorId());
		psmt.setString(2,d.getTeacherId());
		
		status = psmt.executeUpdate();
		return status;
	}
	
	public static int insertIntoTaughtBy(TaughtBy d) throws ClassNotFoundException, SQLException {
		int status = 0;
		Connection conn = ConnectionUtils.getConnection();
		String sql = "";
		sql = "inset into taugthby values(?,?)";
		PreparedStatement psmt = conn.prepareStatement(sql);
		
		psmt.setString(1,d.getCourseId());
		psmt.setString(2,d.getEmployeeId());
		
		status = psmt.executeUpdate();
		return status;
	}
	
	public static int insertIntoTeacher(Teacher d) throws ClassNotFoundException, SQLException {
		int status = 0;
		Connection conn = ConnectionUtils.getConnection();
		String sql = "";
		sql = "inset into teacher values(?,?,?)";
		PreparedStatement psmt = conn.prepareStatement(sql);
		
		psmt.setString(1,d.getEmployeeId());
		psmt.setString(2,d.getDepartmentId());
		psmt.setString(3, d.getEmployeePost());
		
		status = psmt.executeUpdate();
		return status;
	}
	
	public static int insertIntoTypesOfFee(TypesOfFee d) throws ClassNotFoundException, SQLException {
		int status = 0;
		Connection conn = ConnectionUtils.getConnection();
		String sql = "";
		sql = "inset into typesoffee values(?,?)";
		PreparedStatement psmt = conn.prepareStatement(sql);
		
		psmt.setString(1,d.getFeeType());
		psmt.setFloat(2,d.getFeeAmount());
		
		status = psmt.executeUpdate();
		return status;
	}
	
	public static HashSet<String> checkTables (HashSet<String> set) throws SQLException, ClassNotFoundException {
		Connection conn = ConnectionUtils.getConnection();
		
		Statement stmt = conn.createStatement();
	    ResultSet rs = stmt.executeQuery("Show tables");
	    
	    while(rs.next()) {
	    	set.remove(rs.getString(1));
	    }
		
		return set;
	}
	
	public static void runScript(String name) throws ClassNotFoundException, SQLException, FileNotFoundException {
		Connection conn = ConnectionUtils.getConnection();
		
		ScriptRunner sr = new ScriptRunner(conn);
		System.out.println(name);
		Reader reader = new BufferedReader(new FileReader("pathFromRootDisk\\keyur\\src\\main\\java\\keyur\\sqlFiles\\" + name + ".sql"));
		
		sr.runScript(reader);
	}
	
	public static HashSet<String> checkTrigger( HashSet<String> set ) throws SQLException, ClassNotFoundException{
		Connection conn = ConnectionUtils.getConnection();
		Statement stmt = conn.createStatement();
		
		ResultSet rs = stmt.executeQuery("show triggers");
		
		while(rs.next()) {
			set.remove(rs.getString("Trigger"));
		}
		
		return set;
	}
	
	public static HashSet<String> checkProcedure(HashSet<String> set) throws SQLException, ClassNotFoundException {
		Connection conn = ConnectionUtils.getConnection();
		Statement stmt = conn.createStatement();
		
		ResultSet rs = stmt.executeQuery("SHOW PROCEDURE STATUS WHERE Db = 'finalp'");
		
		while(rs.next()) {
			set.remove(rs.getString("Name"));
		}
		
		return set;
	}
	
	public static void initialCheck() throws ClassNotFoundException, SQLException {
		Connection conn = ConnectionUtils.getConnection();
		Statement stmt = conn.createStatement();

		stmt.execute("CREATE DATABASE IF NOT EXISTS `finalp`");
		stmt.execute("use finalp");
	}
}