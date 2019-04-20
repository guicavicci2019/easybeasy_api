package br.com.fiap.easybeasy.endpoint;

import java.util.UUID;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

public class ApplicationEndpoint {

	protected String simpleJsonMessage(String message) {
		JSONObject json = new JSONObject();
		try {
			json.put("message", message);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return json.toString();
	}


	
}
