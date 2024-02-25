/**
 * 
 */
package oaiscore;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

import info.oais.infomodel.implementation.ArchivalInformationPackageRefImpl;
import info.oais.infomodel.implementation.utility.Json2Java;

/**
 * 
 */
class JacksonTest {

	/**
	 * Test method for {@link info.oais.infomodel.implementation.utility.Json2Java#json2Java(java.lang.String, java.lang.Class)}.
	 */
	@Test
	void testJson2Java() {
		/**
		 * Create a JSON string for a full AIP
		 */
		String aipJson = "{ \"ArchivalInformationPackage\": { \"version\": \"1.0\", \"PackageType\": \"AIP\", 	 \"IsDeclaredComplete\": \"True\", \"PackageDescription\": \"This is an example AIP\", \"PDI\": { \"Provenance\": { \"DataObject\": { \"IdentifierType\": \"URI\", \"Identifier\": \"http://myprov.example.com/prov\", \"size\": \"12345678\" }, \"RepresentationInformation\": { \"IdentifierType\": \"URI\", \"Identifier\": \"http://myprov.example.com/provri\" } }, \"Reference\": { \"DataObject\": { \"IdentifierType\": \"URI\", \"Identifier\": \"http://myprov.example.com/ref\" }, \"RepresentationInformation\": { \"IdentifierType\": \"URI\", \"Identifier\": \"http://myprov.example.com/refri\" } }, \"AccessRights\": { \"DataObject\": { \"IdentifierType\": \"URI\", \"Identifier\": \"http://myprov.example.com/ar\" }, \"RepresentationInformation\": { \"IdentifierType\": \"URI\", \"Identifier\": \"http://myprov.example.com/arri\" } }, \"Context\": { \"DataObject\": { \"IdentifierType\": \"URI\", \"Identifier\": \"http://myprov.example.com/context\" }, \"RepresentationInformation\": { \"IdentifierType\": \"URI\", \"Identifier\": \"http://myprov.example.com/contextri\" } }, \"Fixity\": { \"DataObject\": { \"IdentifierType\": \"URI\", \"Identifier\": \"http://myprov.example.com/fix\" }, \"RepresentationInformation\": { \"IdentifierType\": \"URL\", \"Identifier\": \"http://myprov.example.com/fixri\" } } }, \"InformationObject\": { \"DataObject\": { \"IdentifierType\": \"URI\", \"Identifier\": \"http://myprov.example.com/do\", \"size\": \"12345678\" }, \"RepresentationInformation\": { \"AndGroup\": { \"SemanticsRI\": { \"DataObject\": { \"IdentifierType\": \"URI\", \"Identifier\": \"http://myprov.example.com/dosem\" }, \"RepresentationInformation\": { \"IdentifierType\": \"URI\", \"Identifier\": \"http://opm.example.com/ristr\" } }, \"StructureRI\": { \"DataObject\": { \"IdentifierType\": \"URI\", \"Identifier\": \"http://myprov.example.com/dostr\" }, \"RepresentationInformation\": { \"IdentifierType\": \"URI\", \"Identifier\": \"http://opm.example.com/ristr\" } }, \"OtherRI\": { \"OrGroup\": [ { \"DataObject\": { \"IdentifierType\": \"URI\", \"Identifier\": \"http://myprov.example.com/java-sw\" }, \"RepresentationInformation\": { \"IdentifierType\": \"URI\", \"Identifier\": \"http://opm.example.com/java-sw-system\" } }, { \"DataObject\": { \"IdentifierType\": \"URI\", \"Identifier\": \"http://myprov.example.com/csharp-sw\" }, \"RepresentationInformation\": { \"IdentifierType\": \"URI\", \"Identifier\": \"http://opm.example.com/csharp-sw-system\" } } ] } } } } } } ";
		ObjectMapper mapper = new ObjectMapper();
		JsonNode node=null;
		List<String> keys = new ArrayList<>();
		
		try {
			node = mapper.readTree(aipJson);
		} catch (JsonMappingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("aipJson is "+ node);
		System.out.println("node    is "+ node);
//		Iterator<String> iterator = node.fieldNames();
//	    while (iterator.hasNext()){
//	    	System.out.println("Field: "+iterator.next());
//	    }
//        String version = node.get("/ArchivalInformationPackage/version").asText();
//        System.out.println("version: "+version);
//        String packageType = node.get("/ArchivalInformationPackage/PackageType").asText();
        
//        List<String> fieldKeys;
		try {
			System.out.println("Get fieldkeys");
		    //List<String> keys = new ArrayList<>();
		    //JsonNode jsonNode = mapper.readTree(json);
		    getAllKeysUsingJsonNodeFieldNames(node, keys);
			//fieldKeys = getAllKeysInJsonUsingJsonNodeFieldNames(aipJson, mapper);
//			for(int i=0;i<fieldKeys.size();i++){
//	            System.out.println("Field: " + i + " is " + fieldKeys.get(i));
//	        } 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		String packageType = node.at("/ArchivalInformationPackage/PackageType").asText();
        System.out.println("PackageType: "+packageType);
		String version = node.at("/ArchivalInformationPackage/Version").asText();
        System.out.println("Version: "+version);
		String isDeclaredComplete = node.at("/ArchivalInformationPackage/IsDeclaredComplete").asText();
        System.out.println("IsDeclaredComplete: "+isDeclaredComplete);
        String packageDescription = node.at("/ArchivalInformationPackage/PackageDescription").asText();
        System.out.println("PackageDescription: "+packageDescription);
        JsonNode pdi =  node.at("/ArchivalInformationPackage/PDI");
        System.out.println("PDI: "+ pdi);
        System.out.println("--- Provenance: " + pdi.at("/Provenance"));
        System.out.println("---*Provenance: " + node.at("/ArchivalInformationPackage/PDI/Provenance"));
        System.out.println("--- Reference : " + pdi.at("/Reference"));
        System.out.println("--- Context   : " + pdi.at("/Context"));
        System.out.println("--- AccessRts : " + pdi.at("/AccessRights"));
        System.out.println("--- Fixity    : " + pdi.at("/Fixity"));
        String informationObject_txt = node.at("/ArchivalInformationPackage/InformationObject").asText();
        System.out.println("InformationObject: "+informationObject_txt);
		
		ArchivalInformationPackageRefImpl aip = new Json2Java().json2Java(aipJson, ArchivalInformationPackageRefImpl.class);
		if (aip == null) {
			System.out.println("**** AIP OBJECT is NULL");
			fail("Not yet implemented");
		}
		System.out.println("AIP is:"+aip.toString());
		
	}
	                    
	private static void getAllKeysUsingJsonNodeFieldNames(JsonNode value, List<String> keysin) {
		List<String> keys = new ArrayList<>();
        if (value.isObject()) {
        	System.out.println("---OBJECT---"+ value);
            Iterator<Map.Entry<String, JsonNode>> fields = value.fields();
            fields.forEachRemaining(field -> {
                keys.add(field.getKey());
                getAllKeysUsingJsonNodeFieldNames((JsonNode) field.getValue(), keys);
            });
			for(int i=0;i<keys.size();i++){
	            System.out.println("Field: " + i + " is " + keys.get(i));
	        } 
        } else if (value.isArray()) {
        	System.out.println("---ARRAY---"+ value);
            ArrayNode arrayField = (ArrayNode) value;
            arrayField.forEach(node -> {
                getAllKeysUsingJsonNodeFieldNames(node, keys);
            });
			for(int i=0;i<keys.size();i++){
	            System.out.println("Field: " + i + " is " + keys.get(i));
	        } 
        }
    }
	
//	public List<String> getAllKeysInJsonUsingJsonNodeFieldNames(String json, ObjectMapper mapper) throws JsonMappingException, JsonProcessingException {
//
//	    List<String> keys = new ArrayList<>();
//	    JsonNode jsonNode = mapper.readTree(json);
//	    getAllKeysUsingJsonNodeFieldNames(jsonNode, keys);
//	    return keys;
//	}
//	private void getAllKeysUsingJsonNodeFields(JsonNode jsonNode, List<String> keys) {
//
//	    if (jsonNode.isObject()) {
//	        Iterator<Map.Entry<String, JsonNode>> fields = jsonNode.fields();
//	        fields.forEachRemaining(field -> {
//	            keys.add(field.getKey());
//	            getAllKeysUsingJsonNodeFieldNames((JsonNode) field.getValue(), keys);
//	        });
//	    } else if (jsonNode.isArray()) {
//	        ArrayNode arrayField = (ArrayNode) jsonNode;
//	        arrayField.forEach(node -> {
//	            getAllKeysUsingJsonNodeFieldNames(node, keys);
//	        });
//	    }
//	}

}
