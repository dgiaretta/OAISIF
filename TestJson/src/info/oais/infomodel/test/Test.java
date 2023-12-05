/**
 * 
 */
package info.oais.infomodel.test;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Base64;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.*;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.*;
import info.oais.infomodel.implementation.*;
import info.oais.infomodel.implementation.representationinformation.*;
import info.oais.infomodel.implementation.utility.*;
import info.oais.infomodel.implementation.pdi.*;
import info.oais.infomodel.interfaces.*;
import info.oais.infomodel.interfaces.pdi.*;
import info.oais.infomodel.interfaces.representationinformation.*;
import info.oais.infomodel.interfaces.utility.*;

/**
 * 
 */
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String dataObject = "This is a test";
		String encodedBase64String = Base64.getEncoder().encodeToString(dataObject.getBytes());
		DataObject digiObj = new DataObjectRefImpl(encodedBase64String);
		RepresentationInformation ri1 =  new RepresentationInformationRefImpl(new DataObjectRefImpl("Base64 encoding"), null);
		RepresentationInformation ri2 =  new RepresentationInformationRefImpl();
		ArrayList<RepresentationInformation> ral = new ArrayList<RepresentationInformation>();
		ral.add(ri1);
		ral.add(ri2);
		RepInfoOrGroup rog = new RepInfoOrGroupRefImpl(ral);
		//@SuppressWarnings("removal")
		//Float data = Float.valueOf(123.456f);
		//String encodedBase64Float = Base64.getEncoder().encodeToString(ByteBuffer.allocate(4).putFloat(data).array());
		StructureRepInfo strRi =  new StructureRepInfoRefImpl(new DataObjectRefImpl("Base64 encoding"), null);
		SemanticRepInfo semRi =  new SemanticRepInfoRefImpl();
		RepresentationInformation ri = new RepresentationInformationRefImpl(strRi, semRi, rog);
		InformationObject io = new InformationObjectRefImpl(digiObj, ri);
		ProvenanceInformation prov = new ProvenanceInformationRefImpl("This is Provenance - info was created by DG");
		ReferenceInformation ref = new ReferenceInformationRefImpl();
		((ReferenceInformationRefImpl) ref).setString("This is where it is");
		AccessRightsInformation ar = new AccessRightsInformationRefImpl("Only for MOIMS-DAI");
		ContextInformation con = new ContextInformationRefImpl("The context is testing JSON serialisation for OAIS-IF");
		FixityInformation fi = new FixityInformationRefImpl("This is unchanged - honest guv");
		
		PreservationDescriptionInformation pdi = new PreservationDescriptionInformationRefImpl(prov, ref, ar, con, fi);
		
		PackageDescription pd = new PackageDescriptionRefImpl("This is a test AIP");
		boolean complete = true;
		Identifier id = new IdentifierRefImpl("http://localhost/test", "URI");
		ArchivalInformationPackage aip = new ArchivalInformationPackageRefImpl(io, (PreservationDescriptionInformationRefImpl) pdi, pd, complete, id);
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(Include.NON_NULL);
		String result = "";
		try {
			result = mapper.writeValueAsString(aip);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("JSON for AIP is:" + result);
	}
    public static <T> T json2Java(String str, Class<T> classType){
    //public static <T> T json2Java(String str, Class<T> classType){

    	T t = null;
    	
    	 try {
    		ObjectMapper mapper = new ObjectMapper();
    	    mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
			t=mapper.readValue(str, classType);
		}catch (Exception e) {
			e.printStackTrace();
		}
    	 
        return t;
    }
}
