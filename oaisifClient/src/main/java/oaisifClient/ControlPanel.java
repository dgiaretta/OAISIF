package oaisifClient;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
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
import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.Vector;
import java.awt.event.ActionEvent;

@PropertySource("classpath:oaisifclient.properties")

public class ControlPanel {
	

	//@Value("${GENERICADAPTERURL}")  
	// String gaUrl = null;
	
	String gaUrl = null; //   "http://www.oais.info:8765";
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
	 * Create the application.
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
		//Identifier saipid = null;
		
		System.out.println("GA:"+ gaUrl);
		JButton btnNewButton_0 = new JButton("SwitchBoard");
		frame.getContentPane().add(btnNewButton_0, BorderLayout.WEST);
		btnNewButton_0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SwitchBoardEntry sbe = selectArchive(gaUrl);
				String archUrl = sbe.getArchiveURL();
				Identifier saipid = selectAIP(archUrl);
				showAIP(gaUrl, saipid);
			}
		});
		
		JButton btnNewButton_1 = new JButton("List all AIPs");
		frame.getContentPane().add(btnNewButton_1, BorderLayout.NORTH);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Identifier saipid = selectAIP(gaUrl);
				showAIP(gaUrl, saipid);
			}
		});
		
		JButton btnNewButton_2 = new JButton("Show specified AIP");		
		frame.getContentPane().add(btnNewButton_2, BorderLayout.EAST);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showAIP(gaUrl, null);
			}
		});
		
		JButton btnNewButton_3 = new JButton("List all RI available");
		frame.getContentPane().add(btnNewButton_3, BorderLayout.SOUTH);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//showRRORI(gaUrl);
			}
		});

	}
	
	private SwitchBoardEntry selectArchive(String gaUrl) {
		
		ObjectMapper mapper = new ObjectMapper();
		System.out.println("SB GA:"+ gaUrl);
	    URI targetURI=null;
		try {
			targetURI = new URI(gaUrl+"/api/GA/GetSwitchboardAll");
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

	private Identifier selectAIP(String gaUrl) {
		
		if (gaUrl == null) {
			gaUrl = JOptionPane.showInputDialog("Please input an Archive Generic Adapter URL"); 
		}
		ObjectMapper mapper = new ObjectMapper();
		System.out.println("AIP GA:"+ gaUrl);
	    URI targetURI=null;
		try {
			targetURI = new URI(gaUrl+"/api/GA/AIPAll");
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

	private void showAIP(String gaUrl, Identifier saipid) {
		if (gaUrl == null) {
			gaUrl = JOptionPane.showInputDialog("Please input an Archive Generic Adapter URL"); 
		}
		if (saipid == null) {
			String inputValue = JOptionPane.showInputDialog("Please input an AIP ID as IdType,IdName"); 
			String[] res = inputValue.split("[,]", 0);
			saipid = new IdentifierRefImpl(res[0], res[1]);
		}
		ObjectMapper mapper = new ObjectMapper();
		System.out.println("AIP GA:"+ gaUrl);
	    URI targetURI=null;
		try {
			targetURI = new URI(gaUrl+"/api/GA/GetAIP?aipid="+saipid.getIdName());
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

		System.out.println("AIP: "+ res);
		
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
	    
		JTextArea textArea = new JTextArea(30, 50);
		textArea.setText(prettyJson);
		textArea.setEditable(true);
		JScrollPane scrollPane = new JScrollPane(textArea); 
		JOptionPane.showMessageDialog (frame, scrollPane);
		//JOptionPane.showMessageDialog (null, scrollPane, "AIP"+saipid, JOptionPane.INFORMATION_MESSAGE);
			
	}
	private int displayTableAndSelectRow(Vector<Vector<String>> dataList, Vector<String> columnNames) {
		JTable table = new JTable(dataList, columnNames);
	    table.setRowSelectionAllowed(true);
	    ListSelectionModel selectionModel = table.getSelectionModel();
        selectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        /**
         * SHow the table and wait for a row to be selected and OK button pressed
         */
	    JOptionPane.showMessageDialog(null, new JScrollPane(table));
	    
	    int rowIndex = table.getSelectedRow();
	    
	    System.out.println("Selected row is:" + rowIndex);;
	    
	    return rowIndex;
	    
	}
	
	

}
