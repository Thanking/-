package two;

/**
 * -*- coding: utf-8 -*-
 *
 * @author 卢升达
 * @version 1.0
 * @date 2021-03-21
 */
public class Person {
	private String name;
	private char sex;  //性别，'F'表示女性，'M'表示男性
	public Person(String n,char s){
		name=n;
		sex=s;
	}

	public String GetName(){
		return name;
	}
	public char GetSex(){
		return sex;
	}
	public void SetSex(char s){
		sex=s;
	}
	public void SetName(String n){
		name=n;
	}
}
