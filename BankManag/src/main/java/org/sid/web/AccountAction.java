//package org.sid.web;
//
//import org.apache.struts2.convention.annotation.Action;
//import org.apache.struts2.convention.annotation.ParentPackage;
//import org.apache.struts2.convention.annotation.Result;
//import org.json.simple.JSONObject;
//import org.json.simple.parser.JSONParser;
//
//import com.opensymphony.xwork2.ActionSupport;
//
//@ParentPackage("json-default")
//public class AccountAction extends ActionSupport {
//
//	private static final long serialVersionUID = 1L;
//	private String custCode;
//	private String jsonRequestdata;
//
//	@Override
//	@Action(value = "custJsonAccounts", results = { @Result(name = "success", type = "json") })
//	public String execute() throws Exception {
//		System.out.println("in CUSTJSONACCOUNTS ACTION CLASS");
//		JSONObject json = (JSONObject) new JSONParser().parse(jsonRequestdata);
//
//		System.out.println("custCode : "+json.get("custCode"));
//		return ActionSupport.SUCCESS;
//	}
//
//	public String getCustCode() {
//		return custCode;
//	}
//
//	public void setCustCode(String custCode) {
//		this.custCode = custCode;
//	}
//
//	public String getJsonRequestdata() {
//		return jsonRequestdata;
//	}
//
//	public void setJsonRequestdata(String jsonRequestdata) {
//		this.jsonRequestdata = jsonRequestdata;
//	}
//
//}
