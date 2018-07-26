package kr.geun.o.bc.basic;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * BlockChain Utils
 *
 * @author akageun
 */
public class BcUtils {

	/**
	 * Hash 생성
	 *
	 * @param inputValues
	 * @return
	 */
	public static String generateHash(String... inputValues) {
		try {
			StringBuffer sb = new StringBuffer();
			for (String inputValue : inputValues) {
				sb.append(inputValue);
			}

			String input = sb.toString();

			MessageDigest digest = MessageDigest.getInstance("SHA-256");

			byte[] hash = digest.digest(input.getBytes("UTF-8"));
			StringBuffer hexString = new StringBuffer();

			for (int i = 0; i < hash.length; i++) {
				String hex = Integer.toHexString(0xff & hash[i]);
				if (hex.length() == 1) {
					hexString.append('0');
				}

				hexString.append(hex);
			}
			return hexString.toString();

		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			throw new RuntimeException(e);

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
