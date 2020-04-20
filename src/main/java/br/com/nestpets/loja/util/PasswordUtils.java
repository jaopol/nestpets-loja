/**
 * 
 */
package br.com.nestpets.loja.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import lombok.Data;

/**
 * @author jp
 *
 */
@Data
public class PasswordUtils {
	
	private static final Logger log = LoggerFactory.getLogger( PasswordUtils.class );

	public PasswordUtils() {
		
	}
	
	/**
	 * Gera a criptografia da senha
	 * @param senha
	 * @return
	 */
	public static String geraBCrypt(String senha) {
		if(senha==null) {
			return senha;
		}
		log.info("Gerando hash com BCrypt");
		BCryptPasswordEncoder bCrypt = new BCryptPasswordEncoder( 16 );
		return bCrypt.encode(senha);
	}
	
	
	
	

}
