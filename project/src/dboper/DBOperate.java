package dboper;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import thread.LogTask;


public class DBOperate {
	//全局变量
	Connection conn;
	Statement stmt;
	ResultSet rs;
	
	public DBOperate() {
		conn=DBConnect.createConnection();
	}
	
	//查询-所有
	public ResultSet queryAll() {
		try {
			stmt=conn.createStatement();	
			String query1="select * from stuscore order by score DESC";
					
			rs=stmt.executeQuery(query1);
			JOptionPane.showMessageDialog(null, "全查询成功，并按成绩降序排列~~", "ding", JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "全查询失败TAT", "ding", JOptionPane.ERROR_MESSAGE);
		}
		return rs;
	}
	
	//模糊查询-by name
	public ResultSet queryByName(String name) {
		try {
			stmt=conn.createStatement();		
			String query1="select * from stuscore where name like '%" +name+"%'  order by score DESC";		
			
			rs=stmt.executeQuery(query1);
			
			JOptionPane.showMessageDialog(null, "按姓名查询成功，并按成绩降序排列~~", "ding", JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "按姓名查询失败TAT", "ding", JOptionPane.ERROR_MESSAGE);
		}
		return rs;
	}
	
	//更新name
	public void updateName(String id,String name) {
		try {
			stmt=conn.createStatement();	
			String query1="update stuscore set name="+"\""+name+"\""+" where id like "+"\""+id+"\""+";";
			
			stmt.executeUpdate(query1);
			
			JOptionPane.showMessageDialog(null, "姓名更新成功~~", "ding", JOptionPane.INFORMATION_MESSAGE);
			LogTask me1=new LogTask(query1);

			Thread thread=new Thread(me1);
			thread.start();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "姓名更新失败TAT", "ding", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	//更新score
	public void updateScore(String id,int score) {
		try {
			stmt=conn.createStatement();	
			String query1="update stuscore set score="+"\""+score+"\""+" where id like "+"\""+id+"\""+";";
	
			stmt.executeUpdate(query1);
			
			JOptionPane.showMessageDialog(null, "成绩更新成功~~", "ding", JOptionPane.INFORMATION_MESSAGE);
			LogTask me2=new LogTask(query1);

			Thread thread=new Thread(me2);
			thread.start();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "成绩更新失败TAT", "ding", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	//更新gender
	public void updateGender(String id,String gender) {
		try {
			stmt=conn.createStatement();	
			String query1="update stuscore set gender="+"\""+gender+"\""+" where id like "+"\""+id+"\""+";";
	
			stmt.executeUpdate(query1);
			
			JOptionPane.showMessageDialog(null, "性别更新成功~~", "ding", JOptionPane.INFORMATION_MESSAGE);
			LogTask me3=new LogTask(query1);

			Thread thread=new Thread(me3);
			thread.start();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "性别更新失败TAT", "ding", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	//close
	public void closeAll() {
		//first open,last close
		
		//close-result set
		try {
			if(rs!=null) rs.close();
			//JOptionPane.showMessageDialog(null, "数据集关闭成功~~", "ding", JOptionPane.INFORMATION_MESSAGE);	
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "数据集关闭失败TAT", "ding", JOptionPane.ERROR_MESSAGE);
		}
		
		//close-Statement
		try {
			if(stmt!=null) stmt.close();
			//JOptionPane.showMessageDialog(null, "数据库资源释放成功~~", "ding", JOptionPane.INFORMATION_MESSAGE);		
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "数据库资源释放失败TAT", "ding", JOptionPane.ERROR_MESSAGE);
		}
		
		//close-Connection
		try {
			if(conn!=null) conn.close();
			JOptionPane.showMessageDialog(null, "数据库断开连接成功~~", "ding", JOptionPane.INFORMATION_MESSAGE);		
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "数据库断开连接失败TAT", "ding", JOptionPane.ERROR_MESSAGE);
		}
	}
}
