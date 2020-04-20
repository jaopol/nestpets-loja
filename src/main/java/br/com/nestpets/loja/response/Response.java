package br.com.nestpets.loja.response;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;


/**
 * @author jp
 *
 * @param <T>
 */
@Data
public class Response<T> {

	private T data;

	private List<String> erros;

	public Response() {

	}

	public List<String> getErros() {
		if (this.erros == null) {
			this.erros = new ArrayList<String>();
		}

		return this.erros;
	}

}
