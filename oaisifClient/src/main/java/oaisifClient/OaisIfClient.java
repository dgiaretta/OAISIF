package oaisifClient;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.SwingUtilities;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

//import info.oais.infomodel.implementation.utility.OaisIfConfig;
import info.oais.oaisif.switchBoard.SwitchBoardEntry;

@PropertySource("classpath:specificadapter.properties")


public class OaisIfClient {
//private static final String TARGET_URL = "https://jsonplaceholder.typicode.com/todos/";
//public static void main(String[] args) throws URISyntaxException, IOException, InterruptedException {

	
	public static void main(String[] args) throws Exception {
		SwingUtilities.invokeLater(new Runnable(){
			
			@Value("${GENERICADAPTERURL}") 
			private String specUrl;
			
            public void run() {
            	/**
            	 * Select the archive from the SwitchBoard
            	 */
            	SwitchBoardEntry sbe = selectArchive();
            	/**
            	 * Get the configuration of the selected archive
            	 */
            	
            	/**
            	 * List the AIPs in the archive and the select an AIP
            	 */
            	
            	/**
            	 * 
            	 */

            }

			private SwitchBoardEntry selectArchive() {
				
				ObjectMapper mapper = new ObjectMapper();
				
			    URI targetURI=null;
				try {
					targetURI = new URI(specUrl+"/api/GA/GetSwitchboardAll");
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
			   
			    return swArray[rowIndex];
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
		});
	}

}
