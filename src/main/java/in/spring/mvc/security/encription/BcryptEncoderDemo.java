/**
 * 
 */
package in.spring.mvc.security.encription;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author Prasad Boini
 *
 */
public class BcryptEncoderDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String hashed = encoder.encode("password");
		System.out.println("hashed:" + hashed);
		if (encoder.matches("password", "$2a$05$.sBVM7MMv5kSeHjzBQVb1OBZZwQA5qPrJbEm.tqQwTpEcRjIAr6Da")) {
			System.out.println("1st Hurray...! Password matches..");
		} else {
			System.err.println("1st Password not matches...-->");
		}
		hashed = encoder.encode("password");
		System.out.println("hashed:" + hashed);

		if (encoder.matches("password", "$2a$05$.sBVM7MMv5kSeHjzBQVb1OBZZwQA5qPrJbEm.tqQwTpEcRjIAr6Da")) {
			System.out.println("2nd Hurray...! Password matches..");
		} else {
			System.err.println(" 2nd Password not matches...-->");
		}
	}

}
