package com.fox.day03;

public class w_00_person {
	private int id;
	private String name;
	private String username;
	private String password;
	private int age;
	private String news;
	private double height;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getNews() {
		return news;
	}
	public void setNews(String news) {
		this.news = news;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	@Override
	public String toString() {
		return "w_00_person [id=" + id + ", name=" + name + ", username=" + username + ", password=" + password
				+ ", age=" + age + ", news=" + news + ", height=" + height + "]";
	}
}
