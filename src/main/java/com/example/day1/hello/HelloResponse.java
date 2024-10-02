package com.example.day1.hello;

public class HelloResponse{
	private String hello;

	public HelloResponse(String helloSpringBoot) {
		this.hello = helloSpringBoot;
	}

	public void setHello(String hello){
		this.hello = hello;
	}

	public String getHello(){
		return hello;
	}

	@Override
 	public String toString(){
		return 
			"HelloResponse{" + 
			"hello = '" + hello + '\'' + 
			"}";
		}
}
