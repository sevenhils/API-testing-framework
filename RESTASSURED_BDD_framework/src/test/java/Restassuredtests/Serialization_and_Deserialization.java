package Restassuredtests;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Serialization_and_Deserialization  implements Serializable{
	int a=10,b=20;

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// TODO Auto-generated method stub
		Serialization_and_Deserialization  t1=new Serialization_and_Deserialization();
		//seSerializatio
		FileOutputStream fos=new FileOutputStream("test.text");
		ObjectOutputStream oos=new ObjectOutputStream(fos);
		oos.writeObject(t1);
		//DeseSerializatio
		FileInputStream fis=new FileInputStream("test.text");
		ObjectInputStream ois=new ObjectInputStream(fis);
		Serialization_and_Deserialization t2=(Serialization_and_Deserialization) ois.readObject();
		System.out.println(t2.a+" "+t2.b);
	}

}
