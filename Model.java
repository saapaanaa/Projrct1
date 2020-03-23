package Model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import oracle.jdbc.driver.OracleDriver;

public class Model 
{
	private String name;
	private String userid;
	private String password;
	private int accno;
	private int  balance;
	private String email;
	int row;
	
	public String getUserid() 
	{
		return userid;
	}

	public void setUserid(String userid) 
	{
		this.userid = userid;
	}

	public String getName() 
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getPassword() 
	{
		return password;
	}

	public void setPassword(String password) 
	{
		this.password = password;
	}

	public int getAccno() 
	{
		return accno;
	}

	public void setAccno(int accno) 
	{
		this.accno = accno;
	}

	public int getBalance() 
	{
		return balance;
	}

	public void setBalance(int balance) 
	{
		this.balance = balance;
	}

	public String getEmail() 
	{
		return email;
	}

	public void setEmail(String email) 
	{
		this.email = email;
	}
	
	private String url = "jdbc:oracle:thin:@//localhost:1521/XE";
	private String userid1="system";
	private String password1="system";
	
	private PreparedStatement pstmt;
	private ResultSet res;
	private Connection con;
	
	public Model()
	{
		try
		{
		DriverManager.registerDriver(new OracleDriver());
		con=DriverManager.getConnection(url,userid1,password1);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	public boolean login()throws Exception
	{
			String sql="SELECT ACCNO FROM BANK WHERE USERID=? AND PASSWORD=?";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,userid);
			pstmt.setString(2,password);
			res=pstmt.executeQuery();
			
			if(res.next())
			{
				accno=res.getInt("ACCNO");
					return true;
			}
			else 
			{
				return false;
			}
	}
	public boolean checkBalance()throws Exception
	{
			String sql1="SELECT BALANCE FROM BANK WHERE ACCNO=?";
			pstmt=con.prepareStatement(sql1);
			pstmt.setInt(1,accno);
			res=pstmt.executeQuery();
			
			if(res.next())
			{
				balance=res.getInt("BALANCE");
					return true;
			}
			else 
			{
				return false;
			}
	}
	
	public int changePassword( String npwd)throws Exception
	{
		String sql2="UPDATE BANK SET PASSWORD=? WHERE PASSWORD=? AND ACCNO=?";
		pstmt=con.prepareStatement(sql2);
		pstmt.setString(1, npwd);
		pstmt.setString(2, password);
		pstmt.setInt(3,accno);
		int row= pstmt.executeUpdate();
		return row;
	}
	
	public int transfer1(int amount,int rvcno) throws Exception
	{
		String sql3="UPDATE BANK SET BALANCE=BALANCE-? WHERE ACCNO=?";
		pstmt=con.prepareStatement(sql3);
		pstmt.setInt(1,amount);
		pstmt.setInt(2,accno);
		int row= pstmt.executeUpdate();

		if(row==1)
		{
			statement1(amount);
			row=transfer2(amount,rvcno);
		}
		return row;
	}
	
	public int transfer2(int amount,int rvcno) throws Exception
	{
		String sql4="UPDATE BANK SET BALANCE=BALANCE+? WHERE ACCNO=?";
		pstmt=con.prepareStatement(sql4);
		pstmt.setInt(1,amount);
		pstmt.setInt(2,rvcno);
		int row= pstmt.executeUpdate();
		statement2(amount,rvcno);
		return row;
	}
	
	public void statement1(int amount) throws Exception
	{
		String sql4="INSERT INTO STATEMENT VALUES(?,?,?,?)";
		pstmt=con.prepareStatement(sql4);
		String amt="-"+amount;
		pstmt.setInt(1,accno);
		pstmt.setString(2,amt);
		
		java.util.Date date = new java.util.Date();
	    long t = date.getTime();
	    java.sql.Date sqlDate = new java.sql.Date(t);
	    java.sql.Time sqlTime = new java.sql.Time(t);

	    pstmt.setDate(3, sqlDate);
	    pstmt.setTime(4, sqlTime);
		pstmt.executeUpdate();
	}
	
	public void statement2(int amount,int rvcno) throws Exception
	{
		String sql4="INSERT INTO STATEMENT VALUES(?,?,?,?)";
		pstmt=con.prepareStatement(sql4);
		
		String amt="+"+amount;
		pstmt.setInt(1,rvcno);
		pstmt.setString(2,amt);
		
		java.util.Date date = new java.util.Date();
	    long t = date.getTime();
	    java.sql.Date sqlDate = new java.sql.Date(t);
	    java.sql.Time sqlTime = new java.sql.Time(t);

	    pstmt.setDate(3, sqlDate);
	    pstmt.setTime(4, sqlTime);
	      //java.sql.Timestamp sqlTimestamp = new java.sql.Timestamp(t);
	      //pstmt.setTimestamp(4, sqlTimestamp);
		pstmt.executeUpdate();
	}
	
	public ArrayList  getTrans() throws Exception
	{
		String sql4="SELECT TRANSACTION FROM STATEMENT WHERE ACCNO=?";
		ArrayList al=new ArrayList();
		pstmt=con.prepareStatement(sql4);
		pstmt.setInt(1,accno);
		res=pstmt.executeQuery();

		while(res.next())
		{
			al.add(res.getString("TRANSACTION"));
		}
			return al;
	}
	
	public ArrayList  getAAccno() throws Exception
	{
		String sql4="SELECT ACCNO FROM STATEMENT WHERE ACCNO=?";
		ArrayList al1=new ArrayList();
		pstmt=con.prepareStatement(sql4);
		pstmt.setInt(1,accno);
		res=pstmt.executeQuery();

		while(res.next())
		{
			al1.add(res.getInt("ACCNO"));
		}
			return al1;
	}
	
	public ArrayList  getTime() throws Exception
	{
		String sql4="SELECT TIME FROM STATEMENT WHERE ACCNO=?";
		ArrayList al2=new ArrayList();
		pstmt=con.prepareStatement(sql4);
		pstmt.setInt(1,accno);
		res=pstmt.executeQuery();

		while(res.next())
		{
			al2.add(res.getTime("TIME"));
		}
			return al2;
	}
	
	public ArrayList  getDate() throws Exception
	{
		String sql4="SELECT TRANSACTION_DATE FROM STATEMENT WHERE ACCNO=?";
		ArrayList al3=new ArrayList();
		pstmt=con.prepareStatement(sql4);
		pstmt.setInt(1,accno);
		res=pstmt.executeQuery();

		while(res.next())
		{
			al3.add(res.getDate("TRANSACTION_DATE"));
		}
			return al3;
	}

	
	public int forgot(String npwd) throws Exception
	{
		String sql4="UPDATE BANK SET PASSWORD=? WHERE EMAIL=?";
		pstmt=con.prepareStatement(sql4);
		
		pstmt.setString(1,npwd);
		pstmt.setString(2,email);
	      
		int row=pstmt.executeUpdate();
		return row;

	}
}


