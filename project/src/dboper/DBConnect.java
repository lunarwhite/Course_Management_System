package dboper;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class DBConnect {
	//对于工具类，多用static
	public static Connection createConnection() {
		Connection conn=null;
		
		//抽离出变量，提高复用性
		String url="jdbc:mysql://localhost/studentdb?serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=UTF-8";
		String user="root";
		String password="";
		
		try {
			conn=DriverManager.getConnection(url,user,password);
			JOptionPane.showMessageDialog(null, "数据库连接成功~~", "ding", JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "数据库连接失败TAT", "ding", JOptionPane.ERROR_MESSAGE);
		}
		return conn;
	}
}
