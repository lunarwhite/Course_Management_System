package thread;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

public class LogTask implements Runnable{
	private String s;
	public LogTask() {
		
	}
	public LogTask(String s) {
		this.s=s;
	}
	
	public void writeLog() {
		String fileName="D:\\examlog.txt";
		File file = new File(fileName);
		
        BufferedWriter writer;
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        
		try {
			writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file, true)));
			//写入
	        writer.write(df.format(new Date())+" "+s);
	        writer.write("\r\n");
	        
	        writer.flush();
	        writer.close();
	        
//	        JOptionPane.showMessageDialog(null, "日志文件写入成功~~", "ding", JOptionPane.INFORMATION_MESSAGE);
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "日志文件未找到TAT", "ding", JOptionPane.ERROR_MESSAGE);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "日志文件写入失败TAT", "ding", JOptionPane.ERROR_MESSAGE);
		}
	}

	@Override
	public void run() {
		writeLog();
	}
	
}
