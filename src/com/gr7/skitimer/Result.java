package com.gr7.skitimer;

class Result {
	boolean success;
	Exception error;
	
	private Result(Boolean success, Exception error) {
		this.success = success;
		this.error = error;
	}
	
	public static Result success(){
		return new Result(true, null);
	}
	
	public static Result error(Exception e){
		return new Result(false, e);
	}
	
	public boolean isSuccess() {
		return success;
	}
	
	public Exception getError() {
		return error;
	}
}
