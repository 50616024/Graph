package graph;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

import graph.MySQL;

public class Graph_view extends Frame implements ActionListener, WindowListener {
	
	private Button button1 = new Button("BarChart");
	private Button button2 = new Button("LineChart");
	private int flg = 0;
	DefaultCategoryDataset data = new DefaultCategoryDataset();
	JFreeChart chart;
	
	
	public Graph_view() {
		addWindowListener(this);
		setTitle("Graph");
		setLayout(new FlowLayout(FlowLayout.CENTER));
		add(button1);
		add(button2);
		button1.addActionListener(this);
		button2.addActionListener(this);
		/*    
		data.addValue(300, "USA", "2005");
		data.addValue(500, "USA", "2006");
		data.addValue(120, "USA", "2007");
		
		data.addValue(200, "China", "2005");
		data.addValue(400, "China", "2006");
		data.addValue(320, "China", "2007");
		*/
		
		int id, ton;
		String name, year;
		ResultSet rs;
		
		MySQL mysql = new MySQL();
		
		rs = mysql.selectAll();//テーブルから情報を持ってくる

		
		try {
			while(rs.next()){//1行ずつ読み込む
			    //id = data.getInt("id");
			    name = rs.getString("name");
			    year = rs.getString("year");
			    ton = rs.getInt("ton");
			    data.addValue(ton, name, year);
			}  //try catchで囲む
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		chart = 
			      ChartFactory.createLineChart("Import Volume",
			                                   "Year",
			                                   "Ton",
			                                   data,
			                                   PlotOrientation.VERTICAL,
			                                   true,
			                                   false,
			                                   false);

			    ChartPanel cpanel = new ChartPanel(chart);
			    add(cpanel, BorderLayout.CENTER);
	    
	}
	
	@Override
	public void windowActivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		System.exit(0);
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String button = e.getActionCommand();
			
		if(button == "BarChart") {	
			
			int id, ton;
			String name, year;
			ResultSet rs;
			
			MySQL mysql = new MySQL();
			
			rs = mysql.selectAll();//テーブルから情報を持ってくる

			
			try {
				while(rs.next()){//1行ずつ読み込む
				    //id = data.getInt("id");
				    name = rs.getString("name");
				    year = rs.getString("year");
				    ton = rs.getInt("ton");
				    data.addValue(ton, name, year);
				}  //try catchで囲む
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			chart = 
				      ChartFactory.createBarChart("Import Volume",
				                                   "Year",
				                                   "Ton",
				                                   data,
				                                   PlotOrientation.VERTICAL,
				                                   true,
				                                   false,
				                                   false);
			
			//ChartPanel cpanel = new ChartPanel(chart); 
			//add(cpanel, BorderLayout.CENTER);
			
			ChartFrame frame = new ChartFrame("Line Chart",chart);
			frame.pack();
			frame.setVisible(true);
			
			
		}else if(button == "LineChart") {
			
			int id, ton;
			String name, year;
			ResultSet rs;
			
			MySQL mysql = new MySQL();
			
			rs = mysql.selectAll();//テーブルから情報を持ってくる

			
			try {
				while(rs.next()){//1行ずつ読み込む
				    //id = data.getInt("id");
				    name = rs.getString("name");
				    year = rs.getString("year");
				    ton = rs.getInt("ton");
				    data.addValue(ton, name, year);
				}  //try catchで囲む
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			chart = 
				      ChartFactory.createLineChart("Import Volume",
				                                   "Year",
				                                   "Ton",
				                                   data,
				                                   PlotOrientation.VERTICAL,
				                                   true,
				                                   false,
				                                   false);
			
			//ChartPanel cpanel = new ChartPanel(chart); 
			//add(cpanel, BorderLayout.CENTER);
			
			ChartFrame frame = new ChartFrame("Line Chart",chart);
			frame.pack();
			frame.setVisible(true);
			
			
		}
		
		
		
	}
	
}
