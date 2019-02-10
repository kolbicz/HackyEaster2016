//javac -cp .;commons-codec-1.10.jar url.java
//java -cp .;commons-codec-1.10.jar url

import java.security.MessageDigest;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base32;
import org.apache.commons.codec.binary.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import java.security.SecureRandom;
import java.util.Random;

public class url 
{
	
	private static final String KEY = "55555";
	private static final String KEY_FULL = "x" + KEY + KEY + KEY; // 128 bit
	private static final String IV = "hackyeasterisfun";	
	private static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	private static SecureRandom rnd = new SecureRandom();
	
	private static String calculateShortUrl(String url) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(url.getBytes("UTF-8"));
			byte[] hash = md.digest();
			byte[] part = new byte[4];
			System.arraycopy(hash, 0, part, 0, 4);
			String b32 = new String(new Base32().encode(part), "UTF-8");
			b32 = b32.replaceAll("=", "");
			return "http://crunch.ly/" + b32;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private static String cryptTicket(String url, String shortUrl) {
		try {
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
			SecretKeySpec keySpec = new SecretKeySpec(KEY_FULL.getBytes("UTF-8"), "AES");
			cipher.init(Cipher.ENCRYPT_MODE, keySpec, new IvParameterSpec(IV.getBytes("UTF-8")));
			String plain = new String(Base64.encodeBase64(url.getBytes("UTF-8")), "UTF-8");
			plain += "@" + new String(Base64.encodeBase64(shortUrl.getBytes("UTF-8")), "UTF-8");
			byte[] crypted = cipher.doFinal(plain.getBytes("UTF-8"));
			return Base64.encodeBase64String(crypted);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}  	
	
	public static String randomString(int len){
	   StringBuilder sb = new StringBuilder( len );
	   for( int i = 0; i < len; i++ ) 
	      sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
	   return sb.toString();
	}	
	
	public static void possibleStrings(int maxLength, char[] alphabet, String curr) {
	
	    if(curr.length() == maxLength) {
	    	String myurl = "http://evileaster.com/"+curr;
    		if (calculateShortUrl(myurl).equals("http://crunch.ly/IU66SMI")) {    			
    			System.out.println("found: "+myurl);
    		}   
	
	    } else {
	        for(int i = 0; i < alphabet.length; i++) {
	            String oldCurr = curr;
	            curr += alphabet[i];
	            possibleStrings(maxLength,alphabet,curr);
	            curr = oldCurr;
	        }
	    }
	}	
	
   public static void main (String[] args)
   {
	
	System.out.println(calculateShortUrl("http://hackyeaster.hacking-lab.com"));
	char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789".toCharArray();
    possibleStrings(1, alphabet,"");
    System.out.println("done 1");
    possibleStrings(2, alphabet,"");
    System.out.println("done 2");
    possibleStrings(3, alphabet,"");
    System.out.println("done 3");
    possibleStrings(4, alphabet,"");
    System.out.println("done 4");
    possibleStrings(5, alphabet,"");
    System.out.println("done 5");
    possibleStrings(6, alphabet,"");
    System.out.println("done 6");
    possibleStrings(7, alphabet,"");
    System.out.println("done 7");
    possibleStrings(8, alphabet,"");
    System.out.println("done 8");
    possibleStrings(9, alphabet,"");
    System.out.println("done 9");
    possibleStrings(10, alphabet,"");
    System.out.println("finished");
	

   }    
 
   
}