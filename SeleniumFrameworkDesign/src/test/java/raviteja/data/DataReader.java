package raviteja.data;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.bouncycastle.util.encoders.UTF8;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataReader {
	
public List<HashMap<String, String>> getJsonDataToMap() throws IOException
{
	//read json to string
	String JsonContent=FileUtils.readFileToString(new File(System.getProperty("user.dir")+"\\src\\test\\java\\raviteja\\data\\purchaseOrder.json"),StandardCharsets.UTF_8);
	
	//Now we need to conver this above String variable to Hashmap.
	ObjectMapper mapper=new ObjectMapper();
	
	List<HashMap<String,String>>data=mapper.readValue(JsonContent, new TypeReference<List<HashMap<String, String>>>()
			{
			});
	return data;
	
}
}
