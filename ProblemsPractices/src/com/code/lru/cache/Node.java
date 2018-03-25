package com.code.lru.cache;

public class Node {
	private String data;
	private String url;
	private Node next;
	private Node prev;
	
	public Node(String url) {
		this.url = url;
		this.data = getData(url);
	}

	private String getData(String url2) {
		String[] strArray = url2.split("-");
		String tmp = "";
		for(String str :strArray) {
			tmp = tmp + "_"+str;
		}
		return tmp;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}

	public Node getPrev() {
		return prev;
	}

	public void setPrev(Node prev) {
		this.prev = prev;
	}
	

}
