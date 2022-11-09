package com.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.model.HuffmanTable;
import com.model.HuffmanTree;
import com.model.Node;
import com.model.Packet;
import com.model.SecretPass;

public class Demo {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
//		Byte data = 1;
//		Node node = new Node(data, 5);
////		System.out.println(node.toString());
//		
//		
//		String content = "i like like like java do you like a java";
//		byte [] bytes = content.getBytes();
//		
//		HuffmanTree tree = new HuffmanTree(bytes);
////		System.out.println(tree.getNodeList());
////		tree.preorderPrint();
//		
//		HuffmanTable table = new HuffmanTable(tree);
//		table.printTable();
		
//		TestObjectStream();
		readObject();
		
	}
	
	
	public static void TestObjectStream() throws IOException {
		String content = "i like like like java do you like a java";
		byte [] bytes = content.getBytes();
		HuffmanTree tree = new HuffmanTree(bytes);
		HuffmanTable table = new HuffmanTable(tree);
		
		table.printTable();
		
//		SecretPass s = new SecretPass();
//		Packet p = new Packet(table,s);
//		writeObj(p);
//		
	}
	
	public static void writeObj(Packet p) throws IOException, IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("test1.txt"));
		oos.writeObject(p);
		oos.close();
	}
	
	public static void readObject() throws IOException, IOException, ClassNotFoundException {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream("test1.txt"));
		Packet obj = (Packet)ois.readObject();
		HuffmanTable tb = obj.getTable();
		SecretPass s = obj.getSec();
		tb.printTable();
		System.out.println(s.pass);
		ois.close();
	}
	

}
