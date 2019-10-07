import java.io.*;
import java.util.ArrayList;

public class Saving implements java.io.Serializable{

	//public ArrayList <BinaryNode<String>> arrayOfNodes = new ArrayList<BinaryNode<String>>();
	public Saving () {
		// TODO Auto-generated constructor stub
	}

	// this method is used to save the arraylist that contains the root nodes for the game taken as input parameter arrayOfNodes
	public static void saveTree(ArrayList <BinaryNode<String>> arrayOfNodes) {
		
		 try {
			 // tells the programme where to save the new file on the desktop and what to call it
		FileOutputStream fileOut = new FileOutputStream("C:\\Users\\niamh\\OneDrive\\Documents\\Eclipse\\savedTree.ser");
		ObjectOutputStream out = new ObjectOutputStream(fileOut);
		//saves the arrayOfNodes and then prints out if it has been successful
		 out.writeObject(arrayOfNodes);
         out.close();
         fileOut.close();
         System.out.println("Save succesful");
         //if unsuccessful the catch will print out the error that occurred
      } catch (IOException i) {
         i.printStackTrace();
      }
		 }
	
	// this method loads in the arraylist that contains the saved trees
	public static ArrayList <BinaryNode<String>> loadTree() {
		try {
			// tells the programme where the file will be loaded from and what it is called
	         FileInputStream fileIn = new FileInputStream("C:\\Users\\niamh\\OneDrive\\Documents\\Eclipse\\savedTree.ser");
	         ObjectInputStream in = new ObjectInputStream(fileIn);
	         ArrayList <BinaryNode<String>> arrayOfNodes = (ArrayList<BinaryNode<String>>) in.readObject();
	         in.close();
	         fileIn.close();
	         // reads in file and returns the arrayOfNodes to the GuessingGame class
	         return arrayOfNodes;
	      // calls method to execute the game
	      } catch (IOException i) {
	         i.printStackTrace();
	         return null;
	         //second catch to print out if the file does not exist or cannot be found
	      } catch (ClassNotFoundException c) {
	         System.out.println("File not found");
	         c.printStackTrace();
	         return null;
	      }
	}
}
