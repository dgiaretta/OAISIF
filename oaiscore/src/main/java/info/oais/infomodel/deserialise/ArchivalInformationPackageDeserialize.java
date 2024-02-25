/**
 * Deserialize the ArchivalInformationInterface into 
 */
package info.oais.infomodel.deserialise;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.fasterxml.jackson.databind.module.SimpleModule;

import info.oais.infomodel.implementation.ArchivalInformationPackageRefImpl;
import info.oais.infomodel.interfaces.ArchivalInformationPackage;
import java.io.IOException;

/**
 * 
 */
public class ArchivalInformationPackageDeserialize extends StdDeserializer<ArchivalInformationPackage> {

    public ArchivalInformationPackageDeserialize() {
        this(null);
    }

    protected ArchivalInformationPackageDeserialize(Class<?> vc) {
        super(vc);
    }

    @Override
    public ArchivalInformationPackage deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
    	
    	JsonNode node = p.readValueAsTree();
        String version = node.get("version").asText();
        System.out.println("version: "+version);
        String packageType = node.get("PackageType").asText();
        System.out.println("PackageType: "+packageType);
        String packageDescription = node.get("PackageDescription").asText();
        System.out.println("PackageDescription: "+packageDescription);
        String pdi_txt = node.get("PDI").asText();
        System.out.println("PDI: "+pdi_txt);
        String informationObject_txt = node.get("InformationObject").asText();
        System.out.println("InformationObject: "+informationObject_txt);

        ArchivalInformationPackageRefImpl impl = new ArchivalInformationPackageRefImpl();
        //impl.setContentInformation(informationObject);
        //impl.setB(b);

        return impl;
    }
}
