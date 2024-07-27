package oaisifClient;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import info.oais.infomodel.implementation.IdentifierRefImpl;
import info.oais.infomodel.interfaces.Identifier;
import info.oais.oaisif.switchBoard.SwitchBoardEntry;

import javax.swing.JButton;
import javax.swing.JEditorPane;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;

@PropertySource("classpath:oaisifclient.properties")

/**
 * Client for OAIS-IF to show \n
 * - SwitchBoard to list archives \n
 * - List all AIPs in archive and select one\n
 * - Show the selected AIP
 */

public class ControlPanel {
	

	//@Value("${GENERICADAPTERURL}")  
	// String gaUrl = null;
	/**
	 * Set the default Generic Adapter location
	 */
	String gaUrl = "http://www.oais.info:8765/oaisif/v1";
	String rrUrl = "http://www.oais.info:8083/oaisif/v1";
	String sbUrl = "http://www.oais.info:8085/oaisif/v1";
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				try {					
					ControlPanel window = new ControlPanel();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application GUI.
	 */
	public ControlPanel() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new FlowLayout());
		
		/**
		 * Add the buttons
		 */
		
		System.out.println("SB:"+ sbUrl);
		JButton btnNewButton_0 = new JButton("SwitchBoard");
		frame.getContentPane().add(btnNewButton_0);
		btnNewButton_0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwitchBoardEntry sbe = selectArchive(sbUrl);
				String archUrl = sbe.getArchiveURL();
				Identifier saipid = selectIP(archUrl, "Archive", "/oaisif/v1/information-packages");
				showIP(archUrl, saipid, "Archive","/oaisif/v1/information-packages/");
			}
		});
		
		JButton btnNewButton_1 = new JButton("List all IPs");
		frame.getContentPane().add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Identifier saipid = selectIP(gaUrl, "Generic Adapter", "/information-packages");
				showIP(gaUrl, saipid, "Generic Adapter","/information-packages/");
			}
		});
		
		JButton btnNewButton_2 = new JButton("Show specified IP");		
		frame.getContentPane().add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showIP(gaUrl, null, "IP", "/information-packages/");
				
			}
		});
		
		JButton btnNewButton_3 = new JButton("List all RI available");
		frame.getContentPane().add(btnNewButton_3);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Identifier saipid = selectIP(rrUrl, "Rep Info", "/representation-info-repository/information-packages");
				showIP(rrUrl, saipid, "RRORI", "/representation-info-repository/information-packages/");
				// showRI(gaUrl);
			}
		});

	}
	
	/**
	 * SHow a table with the SwitchBoard entries from which an archive can be selected
	 * @param gaUrl The URL for the Generic Adapter to use 
	 * @return a SwitchBoard entry
	 */
	private SwitchBoardEntry selectArchive(String sbUrl) {
		
		ObjectMapper mapper = new ObjectMapper();
		System.out.println("SB:"+ sbUrl);
	    URI targetURI=null;
		try {
			targetURI = new URI(sbUrl+"/switchboard/sources");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("targetURI:"+targetURI);
		System.out.println("targetURI:"+targetURI);
	    HttpRequest httpRequest = HttpRequest.newBuilder()
	            .uri(targetURI)
	            .GET()
	            .build();
	    HttpClient httpClient = HttpClient.newHttpClient();
	    HttpResponse<String> response = null;
		try {
			response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String res = response.body();

		System.out.println("List of known archives: "+ res);
		
		SwitchBoardEntry[] swArray= null;
		try {
			swArray = mapper.readValue(res, SwitchBoardEntry[].class);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Vector<Vector<String>> dataList = new Vector<>();
	    for (int i = 0; i < swArray.length; i++) {

	    	SwitchBoardEntry sbe = swArray[i];
	        Vector<String> data = new Vector<>();

	        data.add(sbe.getArchiveName());
	        data.add(sbe.getArchiveDescription());
	        data.add(sbe.getArchiveURL());
	        dataList.add(data);
	    }
	    Vector<String> columnNames = new Vector<>();
	    columnNames.add("Archive Name");
	    columnNames.add("Archive Description");
	    columnNames.add("Archive URL");
	    
	    int rowIndex = displayTableAndSelectRow(dataList, columnNames);
	   
	    SwitchBoardEntry sbEntry = swArray[rowIndex];
	    System.out.println("Selected entry:"+sbEntry);
	    return sbEntry;
	}

	/**
	 * Show a table listing the RIs from the Generic Adapter 
	 * @param gaUrl The URL of the Generic Adapter
	 */
	private void showRI(String url, String targ) {
		
		if (gaUrl == null) {
			gaUrl = JOptionPane.showInputDialog("Please input an Archive Generic Adapter URL"); 
		}
		ObjectMapper mapper = new ObjectMapper();
		System.out.println("RI :"+ rrUrl);
	    URI targetURI=null;
		try {
			targetURI = new URI(rrUrl+"/representation-info-repository/information-packages");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("targetURI:"+targetURI);

	    HttpRequest httpRequest = HttpRequest.newBuilder()
	            .uri(targetURI)
	            .GET()
	            .build();
	    HttpClient httpClient = HttpClient.newHttpClient();
	    HttpResponse<String> response = null;
		try {
			response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String res = response.body();

		System.out.println("List of RIs: "+ res);
		
		JsonNode swArray = null;
		try {
			swArray = mapper.readTree(res);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Vector<Vector<String>> dataList = new Vector<>();
		JsonNode dataRow = swArray;
		Vector<String> columnNames = new Vector<>();
	    columnNames.add("IdType");
	    columnNames.add("Ident");
	    columnNames.add("Package Type");
	    columnNames.add("Is Declared Complete");
	    columnNames.add("Package Description");
	    columnNames.add("Size (if known)");
		if (dataRow.isArray()) {
			for (JsonNode arrayItem : dataRow) {
				System.out.println("row :" + arrayItem);
				Vector<String> row = new Vector<>();
				dataList.add(row);
				for (int i = 0 ; i<6; i++) {
					String col = columnNames.get(i); 
					System.out.println("Item "+i+" :" + col + " : " + arrayItem.get(col));
			        row.add(arrayItem.get(col).asText());
			    }
	        }
		}
	    
	    int rowIndex = displayTableAndSelectRow(dataList, columnNames);
	    String urlStr  = (dataList.get(rowIndex).get(3)).split(",")[0];
	    System.out.println(" URL:"+ urlStr);
	    
	    JPanel panel = new JPanel();
	    panel.setLayout(new FlowLayout());
	    JEditorPane jEditorPane = new JEditorPane();
	    jEditorPane.setEditable(false);   
	    URL myUrl = null;
		try {
			myUrl = new URL(urlStr);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	    try {   
	    	jEditorPane.setPage(url);
	    } catch (IOException e) { 
	    	jEditorPane.setContentType("text/html");
	    	jEditorPane.setText("<html>Page not found.</html>");
	    }

	    JScrollPane jScrollPane = new JScrollPane(jEditorPane);
	    jScrollPane.setPreferredSize(new Dimension(540,400));      

	    panel.add(jScrollPane);
	    frame.getContentPane().add(panel, BorderLayout.CENTER); 
	    frame.setVisible(true);
	    return;
	}
	
	
	
	/**
	 * Show a table listing the AIPs from the Generic Adapter 
	 * and allow the user to select one.
	 * @param gaUrl The URL of the Generic Adapter
	 * @return The Identifier of the AIP wanted.
	 */
	private Identifier selectIP(String url, String targ, String app) {
		
		if (url == null) {
			url = JOptionPane.showInputDialog("Please input an target URL"); 
		}
		ObjectMapper mapper = new ObjectMapper();
		System.out.println("IP " + targ + ":"+ url);
	    URI targetURI=null;
		try {	
			targetURI = new URI(url+app);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("targetURI:"+targetURI);

	    HttpRequest httpRequest = HttpRequest.newBuilder()
	            .uri(targetURI)
	            .GET()
	            .build();
	    HttpClient httpClient = HttpClient.newHttpClient();
	    HttpResponse<String> response = null;
		try {
			response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String res = response.body();

		System.out.println("List of AIPs: "+ res);
		
		JsonNode swArray = null;
		try {
			swArray = mapper.readTree(res);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Vector<Vector<String>> dataList = new Vector<>();
		JsonNode dataRow = swArray.at("/InformationPackage/InformationObject/DataObject");
		int rowNum = 0;
		Vector<String> columnNames = new Vector<>();
		if (dataRow.isArray()) {
			for (JsonNode arrayItem : dataRow) {
				if (rowNum == 0) {
					for (final JsonNode objNode : arrayItem) {
						columnNames.add(objNode.asText());
				    }
				} else {
					Vector<String> row = new Vector<>();
					dataList.add(row);
					int col = 0;
					if (arrayItem.isArray()) {
						for (final JsonNode objNode : arrayItem) {
					        row.add(objNode.asText());
					    }
						col++;
					}
				}
				
				rowNum++;
	        }
		}
	    
	    int rowIndex = displayTableAndSelectRow(dataList, columnNames);
	    IdentifierRefImpl id = new IdentifierRefImpl(dataList.get(rowIndex).get(1), dataList.get(rowIndex).get(0));
	    return id;
	}

	/**
	 * SHow the AIP JSON
	 * @param gaUrl The URL of the Generic Adapter
	 * @param saipid The Identifier of the AIP wanted
	 */
	private void showIP(String url, Identifier saipid, String targ, String app) {
		System.out.println( url + ":"+saipid+":"+targ+" "+app);
		if (url == null) {
			url = JOptionPane.showInputDialog("Please input " + targ +" URL"); 
		}
		if (saipid == null) {
			String inputValue = JOptionPane.showInputDialog("Please input an IP ID as IdType,IdName"); 
			String[] res = inputValue.split("[,]", 0);
			saipid = new IdentifierRefImpl(res[0], res[1]);
		}
		ObjectMapper mapper = new ObjectMapper();
		System.out.println("IP "+ targ + ":" + url);
	    URI targetURI=null;
		try {
			targetURI = new URI(url+app+saipid.getIdName());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("targetURI:"+targetURI);

	    HttpRequest httpRequest = HttpRequest.newBuilder()
	            .uri(targetURI)
	            .GET()
	            .build();
	    HttpClient httpClient = HttpClient.newHttpClient();
	    HttpResponse<String> response = null;
		try {
			response = httpClient.send(httpRequest, HttpResponse.BodyHandlers.ofString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String res = response.body();

		System.out.println("IP: "+ res);
		
		ObjectMapper objectMapper = new ObjectMapper();
	    Object jsonObject;
	    String prettyJson="";
		try {
			jsonObject = objectMapper.readValue(res, Object.class);
			prettyJson = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(jsonObject);
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
		JTextArea textArea = new JTextArea(30, 100);
		textArea.setText(prettyJson);
		textArea.setEditable(true);
		JScrollPane scrollPane = new JScrollPane(textArea); 
		JOptionPane.showMessageDialog (frame, scrollPane);
		//JOptionPane.showMessageDialog (null, scrollPane, "AIP"+saipid, JOptionPane.INFORMATION_MESSAGE);
			
	}
	/**
	 * Display a table 
	 * @param dataList The rows/columns of the table
	 * @param columnNames The column names
	 * @return The row selected
	 */
	private int displayTableAndSelectRow(Vector<Vector<String>> dataList, Vector<String> columnNames) {
		JTable table = new JTable(dataList, columnNames);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
	    table.setRowSelectionAllowed(true);
	    ListSelectionModel selectionModel = table.getSelectionModel();
        selectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        /**
         * SHow the table and wait for a row to be selected and OK button pressed
         */
	    JOptionPane.showMessageDialog(null, new JScrollPane(table));
        // JPanel jp = new JPanel();
        //jp.add(table);
        //JScrollPane jsp = new JScrollPane(table);

        //jsp.setLayout(new GridLayout(1,1)); /* little trick ;) and believe me that this step is important to the automatic all columns resize! A import is also needed for using GridLayout*/
        //table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS); // this is obvius part
//        JScrollPane scrollPane = new JScrollPane(table);
//        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
//        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        // Add the scroll pane to the frame
//        frame.add(scrollPane);
//
//        frame.pack();
//        frame.setLocationRelativeTo(null);
//        frame.setVisible(true);
	    int rowIndex = table.getSelectedRow();
	    
	    System.out.println("Selected row is:" + rowIndex);;
	    
	    return rowIndex;
	    
	}
	
	

}
