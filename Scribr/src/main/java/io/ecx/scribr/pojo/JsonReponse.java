package io.ecx.scribr.pojo;

public class JsonReponse {

	private Boolean success;
	
	private String error;
	
	private String message;
	
	

	public JsonReponse(Boolean success) {
		super();
		this.success = success;
	}
	
	

	public JsonReponse(String error, String message) {
		super();
		this.success = false;
		this.error = error;
		this.message = message;
	}



	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
}
