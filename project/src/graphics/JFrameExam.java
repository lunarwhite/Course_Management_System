package graphics;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
import javax.xml.crypto.Data;

import dboper.DBOperate;
import objects.Student;

import javax.swing.JSplitPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JInternalFrame;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.ActionEvent;

public class JFrameExam extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	//手动提前全局变量
	ResultSet rSet;
	DBOperate dbOperate;
	List<Student> arlistUser;

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameExam frame = new JFrameExam();
					frame.setVisible(true);
					JOptionPane.showMessageDialog(null, "图形界面生成成功~~", "ding", JOptionPane.INFORMATION_MESSAGE);
					
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "图形界面生成失败TAT", "ding", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JFrameExam() {
		setTitle("Java2020\u8003\u8BD5\u9898");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 693, 394);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u8F93\u5165\u59D3\u540D");
		lblNewLabel.setBounds(10, 30, 54, 15);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(74, 27, 203, 21);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JInternalFrame internalFrame = new JInternalFrame("\u5B66\u751F\u57FA\u672C\u4FE1\u606F\u7F16\u8F91\u7A97\u53E3\r\n");
		internalFrame.setBounds(400, 67, 267, 278);
		contentPane.add(internalFrame);
		internalFrame.getContentPane().setLayout(null);
		
		//JComboBox
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"\u7537", "\u5973"}));
		comboBox.setBounds(74, 113, 121, 28);
		internalFrame.getContentPane().add(comboBox);
		
		//姓名查询
		JButton btnNewButton = new JButton("\u67E5\u8BE2\r\n");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//数据库操作
				dbOperate=new DBOperate();
				
				//获取输入
				String input=textField.getText().trim();
				
				if(input.length()==0) {
					rSet=dbOperate.queryAll();
				}else {
					rSet=dbOperate.queryByName(input);
				}
				
				//数据结构的转移，对象化↓
				arlistUser=new ArrayList<Student>();
				
				try {
					while(rSet.next()) {
						//获取列名
						Student user=new Student(
								rSet.getString(1),
								rSet.getString(2),
								rSet.getString(3),
								rSet.getInt(4)
						);
						
						//加入数组
						arlistUser.add(user);
					}
					//JOptionPane.showMessageDialog(null, "数据导入成功~~", "ding", JOptionPane.INFORMATION_MESSAGE);
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "数据导入失败TAT", "ding", JOptionPane.ERROR_MESSAGE);
				}
				
				//数据结构的转移，对象化↑
				table.setModel(new AbstractTableModel() {
					
					private static final long serialVersionUID = 1L;

					@Override
					public Object getValueAt(int rowIndex, int columnIndex) {
						
						Student user=arlistUser.get(rowIndex);
						
						//获取列名
						Object[] cell= {
								user.getIdString(),
								user.getNameString(),
								user.getGenderString(),
								user.getScore()
						};
						
						return cell[columnIndex];
					}
					
					@Override
					public int getRowCount() {
						
						return arlistUser.size();
					}
					
					@Override
					public int getColumnCount() {
						
						int num=0;
						try {
							num= rSet.getMetaData().getColumnCount();
							//JOptionPane.showMessageDialog(null, "获取列数成功~~", "ding", JOptionPane.INFORMATION_MESSAGE);
						} catch (SQLException e) {
							JOptionPane.showMessageDialog(null, "获取列数失败TAT", "ding", JOptionPane.ERROR_MESSAGE);
						}
						return num;
					}
					
					@Override
					public String getColumnName(int colum) {
						String colname = "";
						try {
							colname = rSet.getMetaData().getColumnName(colum+1);
							//JOptionPane.showMessageDialog(null, "获取列名成功~~", "ding", JOptionPane.INFORMATION_MESSAGE);
						} catch (SQLException e) {
							JOptionPane.showMessageDialog(null, "获取列名失败TAT", "ding", JOptionPane.ERROR_MESSAGE);
						}
						return colname;
					}
				});
						
				table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
					@Override
					public void valueChanged(ListSelectionEvent e) {
						if(!e.getValueIsAdjusting()) {
							int row=table.getSelectedRow();
							String idString=(String) table.getValueAt(row, 0);
							String nameString=(String) table.getValueAt(row,1);
							int score=(int) table.getValueAt(row,3);
							String genderString=(String) table.getValueAt(row,2);
							
							
							textField_1.setText(idString);
							textField_2.setText(nameString);
							textField_3.setText(score+"");
							
							//如果性别为男
							if(genderString.equals("\u7537")) {
								comboBox.setSelectedIndex(0);
							}else {
								comboBox.setSelectedIndex(1);
							}
						}
					}
				});
				
				//窗口结束时close数据库 释放资源
				dbOperate.closeAll();
				
			}
		});
		btnNewButton.setBounds(285, 26, 93, 23);
		contentPane.add(btnNewButton);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(22, 71, 368, 274);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		
		JLabel lblNewLabel_1 = new JLabel("\u5B66\u53F7");
		lblNewLabel_1.setBounds(10, 22, 54, 15);
		internalFrame.getContentPane().add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setBounds(74, 19, 121, 21);
		internalFrame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		textField_1.setEditable(false);
		
		JLabel lblNewLabel_2 = new JLabel("\u59D3\u540D\r\n");
		lblNewLabel_2.setBounds(10, 68, 54, 15);
		internalFrame.getContentPane().add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(74, 65, 122, 21);
		internalFrame.getContentPane().add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("\u6027\u522B\r\n");
		lblNewLabel_3.setBounds(10, 120, 54, 15);
		internalFrame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("\u6210\u7EE9\r\n");
		lblNewLabel_4.setBounds(10, 171, 54, 15);
		internalFrame.getContentPane().add(lblNewLabel_4);
		
		textField_3 = new JTextField();
		textField_3.setBounds(74, 168, 121, 21);
		internalFrame.getContentPane().add(textField_3);
		textField_3.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("\u4FEE\u6539");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//数据库操作
				dbOperate=new DBOperate();
				String idString=textField_1.getText().trim();
				
				//设置姓名
				
				String input2=textField_2.getText().trim();//姓名
				if(input2.length()==0) {
					JOptionPane.showMessageDialog(null, "姓名不能为空", "ding", JOptionPane.WARNING_MESSAGE);
				}else {
					dbOperate.updateName(idString, input2);
				}
				
				//设置成绩
				String input3=textField_3.getText().trim();//成绩
				int score=Integer.valueOf(input3);

				if(score>100||score<0) {
					JOptionPane.showMessageDialog(null, "成绩应取0~100", "ding", JOptionPane.WARNING_MESSAGE);
				}else {
					dbOperate.updateScore(idString, score);
				}

				//设置姓别
				//性别，0-男，1-女
	        	int index=comboBox.getSelectedIndex();
	        	String g;
	        	if(index==0) {
	        		dbOperate.updateGender(idString, "男");
	        		g="男";
	        	}else {
	        		dbOperate.updateGender(idString, "女");
	        		g="女";
	        	}
	        	
//	        	//左侧同时显示
	        	//数据库操作

				rSet=dbOperate.queryAll();

				
				//数据结构的转移，对象化↓
				arlistUser=new ArrayList<Student>();
				
				try {
					while(rSet.next()) {
						//获取列名
						Student user=new Student(
								rSet.getString(1),
								rSet.getString(2),
								rSet.getString(3),
								rSet.getInt(4)
						);
						
						//加入数组
						arlistUser.add(user);
					}
					//JOptionPane.showMessageDialog(null, "数据导入成功~~", "ding", JOptionPane.INFORMATION_MESSAGE);
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, "数据导入失败TAT", "ding", JOptionPane.ERROR_MESSAGE);
				}
				
				//数据结构的转移，对象化↑
				table.setModel(new AbstractTableModel() {
					
					private static final long serialVersionUID = 1L;

					@Override
					public Object getValueAt(int rowIndex, int columnIndex) {
						
						Student user=arlistUser.get(rowIndex);
						
						//获取列名
						Object[] cell= {
								user.getIdString(),
								user.getNameString(),
								user.getGenderString(),
								user.getScore()
						};
						
						return cell[columnIndex];
					}
					
					@Override
					public int getRowCount() {
						
						return arlistUser.size();
					}
					
					@Override
					public int getColumnCount() {
						
						int num=0;
						try {
							num= rSet.getMetaData().getColumnCount();
							//JOptionPane.showMessageDialog(null, "获取列数成功~~", "ding", JOptionPane.INFORMATION_MESSAGE);
						} catch (SQLException e) {
							JOptionPane.showMessageDialog(null, "获取列数失败TAT", "ding", JOptionPane.ERROR_MESSAGE);
						}
						return num;
					}
					
					@Override
					public String getColumnName(int colum) {
						String colname = "";
						try {
							colname = rSet.getMetaData().getColumnName(colum+1);
							//JOptionPane.showMessageDialog(null, "获取列名成功~~", "ding", JOptionPane.INFORMATION_MESSAGE);
						} catch (SQLException e) {
							JOptionPane.showMessageDialog(null, "获取列名失败TAT", "ding", JOptionPane.ERROR_MESSAGE);
						}
						return colname;
					}
				});
						
				table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
					@Override
					public void valueChanged(ListSelectionEvent e) {
						if(!e.getValueIsAdjusting()) {
							int row=table.getSelectedRow();
							String idString=(String) table.getValueAt(row, 0);
							String nameString=(String) table.getValueAt(row,1);
							int score=(int) table.getValueAt(row,3);
							String genderString=(String) table.getValueAt(row,2);
							
							
							textField_1.setText(idString);
							textField_2.setText(nameString);
							textField_3.setText(score+"");
							
							//如果性别为男
							if(genderString.equals("\u7537")) {
								comboBox.setSelectedIndex(0);
							}else {
								comboBox.setSelectedIndex(1);
							}
						}
					}
				});
				
				//窗口结束时close数据库 释放资源
				dbOperate.closeAll();
			}
		});
		btnNewButton_1.setBounds(10, 215, 93, 23);
		internalFrame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\u6E05\u7A7A\r\n");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//清空操作
				textField_1.setText("");
				textField_2.setText("");
				textField_3.setText("");
			}

		});
		
		btnNewButton_2.setBounds(113, 215, 93, 23);
		internalFrame.getContentPane().add(btnNewButton_2);
		internalFrame.setVisible(true);
	}
}
