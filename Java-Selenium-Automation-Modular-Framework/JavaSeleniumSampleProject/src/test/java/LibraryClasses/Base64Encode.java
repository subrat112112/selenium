package LibraryClasses;

import java.io.UnsupportedEncodingException;
import java.util.Base64;

public class Base64Encode {

	
	public String encode(String value) throws UnsupportedEncodingException{
		String encodedValue =Base64.getEncoder().encodeToString(value.getBytes("UTF-8"));	
		return encodedValue;
	}
	
	public String decode(String value) throws UnsupportedEncodingException{
		byte[] bytedecoded =  Base64.getDecoder().decode(value);
		String decoded = new String(bytedecoded,"UTF-8");
		
		return decoded;
	}
}
