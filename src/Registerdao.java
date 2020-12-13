import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;

public class Registerdao {
	private String dburl="jdbc:mysql://localhost:3306/userdb";
	private String dbname="root";
	private String dbpassword="";
	private String dbdriver="com.mysql.jdbc.Driver";
	public void loadDriver(String dbDriver)
	{
		try {
			Class.forName(dbDriver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public Connection getConnection()
	{
		Connection con=null;
		try {
		con=DriverManager.getConnection(dburl,dbname,dbpassword);
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	public String insert(member m)
    { 
		loadDriver(dbdriver);
		Connection con=getConnection();
		String result="Data entered sucessfully,Please login to continue";
		String sql="insert into userdb.member values(?,?,?,?)";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, m.getUname());
			ps.setString(2, m.getPassword());
			ps.setString(3, m.getMobileNumber());
			ps.setString(4, m.getEmail());
			ps.executeUpdate();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result=e.toString();
		}
		return result;
		}
	public member getmember(String uname,String password)
    { 
		loadDriver(dbdriver);
		Connection con=getConnection();
		member m=new member();
		int result=0;
		String sql="select * from userdb.member where uname=? and password=?";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, uname);
			ps.setString(2, password);
			ResultSet rs=ps.executeQuery();
			if(rs.next()==false)
			{
				result=1;
			}
			else
			{
				do
				{
					m.setUname(rs.getString(1));
					m.setPassword(rs.getString(2));
					m.setMobileNumber(rs.getString(3));
					m.setEmail(rs.getString(4));
				}while(rs.next());
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result=1;
		}
		if(result==0)
		return m;
		else
		return null;
		}
}
