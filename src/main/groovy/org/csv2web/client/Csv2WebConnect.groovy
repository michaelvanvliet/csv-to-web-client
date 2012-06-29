package main.groovy.org.csv2web.client

import groovyx.net.http.*
import static groovyx.net.http.ContentType.URLENC
import static groovyx.net.http.Method.POST

class Csv2WebConnect {
	
	// set default url to api
	private String apiUrl
	
	public Csv2WebConnect(){
		this.apiUrl = 'http://localhost:8080/api/'
	}
	
	public Csv2WebConnect(String apiUrl){
		this.apiUrl = apiUrl
	}
	
	public static void main(String [] args){ 
		//TODO: Create a way to call this jar from the command-line
	}
	
	def httpPost(path, params = [:]){
		
		HashMap postResponse
	
		try {			 
			new HTTPBuilder(this.apiUrl).post( path: path, body: params, requestContentType: URLENC ) { resp, json ->
				postResponse = json
			}	 
		} catch (e) { 
			//TODO: Better error handling
		}
			
		return postResponse as HashMap // using a HashMap instead of a JsonObject is more user-friendly  
	}

	def list(){
		return httpPost('list')
	}
		
	def labels(){
		return httpPost('labels')
	}
	
	def record(int rid){
		return httpPost('record', [Rid: rid])
	}
	
	def search(String label, String value, boolean regex){		
		return httpPost('search', ['label':label, 'value':value, 'regex': regex ? 1 : 0])
	}
	
	def searchBetween(String label, String valueA, String valueB){
		return httpPost('searchbetween', ['label':label, 'valueA':valueA, 'valueB':valueB] )
	}
	
}