package info.oais.oaisif.specificadapter;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.networknt.schema.JsonSchema;
import com.networknt.schema.JsonSchemaFactory;

@SpringBootTest
class SpecificadapterApplicationTests {

	@Test
	void contextLoads() {
	}
//	@Test 
//	public void givenValidInput_whenValidating_thenValid() throws ValidationException { 
//	    JsonSchemaFactory factory = JsonSchemaFactory.getInstance(SpecVersion.VersionFlag.V4); 
//	    JsonSchema jsonSchema = factory.getSchema( 
//	     JSONSchemaUnitTest.class.getResourceAsStream("/schema.json")); 
//	    JsonNode jsonNode = mapper.readTree( 
//	     JSONSchemaUnitTest.class.getResourceAsStream("/product_valid.json")); 
//	    Set<ValidationMessage> errors = jsonSchema.validate(jsonNode); 
//	    assertThat(errors).isEmpty(); 
//	}
}
