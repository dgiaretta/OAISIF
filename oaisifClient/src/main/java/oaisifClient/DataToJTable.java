package oaisifClient;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import info.oais.oaisif.pds.*;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

public class DataToJTable extends JTable {
    public DataToJTable(String fileRoot) {
        
//        JTable table = new JTable();
//        DefaultTableModel model = new DefaultTableModel();
//        table.setModel(model);
//        
//        File xmlFile = new File(fileRoot + ".xml");
//        JAXBContext jaxbContext;
//
//        try {
//        	  jaxbContext = JAXBContext.newInstance(ProductObservational.class);        
//        	  Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
//        	  ProductObservational prodObs = (ProductObservational) jaxbUnmarshaller.unmarshal(xmlFile);
//        	  System.out.println(prodObs);
//        	  List<FileAreaObservational> fao = (List<FileAreaObservational>) prodObs.getFileAreaObservational(); //.getTableCharacter().getRecordCharacter();
//        	  List<ByteStream> getArrayOrArray1DOrArray2D = fao.get(0).getTableCharacter().getRecordCharacter();
//        } catch (JAXBException e) {
//        	  e.printStackTrace();
//        }
//
        // Read data from the fixed-size column text file
//        String filePath = fileRoot; 
//        ProductObservational cd = new ProductObservational(filePath + ".xml");
//        RecordCharacter rc = cd.getFileAreaObservational().getTableCharacter().getRecordCharacter();
//        ArrayList<FieldCharacter> fcs = rc.getFieldCharacters();
//        int cols = rc.getFields();
//        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
//            String line;
//            int start;
//            int end;
//            String colVal;
//            while ((line = reader.readLine()) != null) {
//            	for (int i=0 ; i<cols; i++) {
//            		start = fcs.get(i).getLocation();
//            		end   = start + fcs.get(i).getFieldLength()-1;
//            		colVal = line.substring(start, end);
//            	}
//                // Split the line based on fixed column widths
//                String col1 = line.substring(0, 10).trim(); // Example: first 10 characters
//                String col2 = line.substring(10, 20).trim(); // Example: next 10 characters
//                // Add data to the table model
//                model.addRow(new Object[]{col1, col2});
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
