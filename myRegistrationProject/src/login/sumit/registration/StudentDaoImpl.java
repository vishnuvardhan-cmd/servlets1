package login.sumit.registration;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDaoImpl implements StudentDao {
	Connection con=null;
	PreparedStatement ps=null;
	@Override
	public int insertStudent(Student s) {
		int status=0;
		try {
			con=MyConnectionProvider.getConnection();
			ps=con.prepareStatement("insert into student values(?,?,?,?)");
			ps.setInt(1,s.getId());
			ps.setString(2,s.getUsername());
			ps.setString(3,s.getPassword());
			ps.setString(4,s.getEmail());
			status = ps.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public Student getStudent(String username, String password) {
		Student s=new Student();
		try{
			con=MyConnectionProvider.getConnection();
			ps=con.prepareStatement("select * from student where username=? and password=?");
			ps.setString(2,username);
			ps.setString(3,password);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				s.setId(rs.getInt(1));
				s.setUsername(rs.getString(2));
				s.setPassword(rs.getString(3));
				s.setEmail(rs.getString(4));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return s;
	}

}
