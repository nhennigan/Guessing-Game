import java.util.ArrayList;

import javax.swing.JOptionPane; 

public class GuessingGame {

	static BinaryNode<String> STree = new BinaryNode<String>();
	static BinaryNode<String> BTree = new BinaryNode<String>();
	public static String userInput;
	public static String usersPick;
	public static String correctAns;
	public static ArrayList<BinaryNode<String>> saved = new ArrayList<BinaryNode<String>>();
	
	public GuessingGame() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main (String arg[]) {

		// creates two binary trees
		STree= SimpsonsTree();
		BTree= BigBangTheoryTree();

		//adds the two trees to the array saved so that they may be saved and loaded later
		saved.add(STree);
		saved.add(BTree);
			
		//calls method to choose which tree to play
		pickGame();
	}
	
	//this method allows the user to choose which tree they would like to use
	public static void pickGame() {
		
		//takes users input
		usersPick=JOptionPane.showInputDialog("If you want to guess a Simpson charater press A or B to "
				+ "guess a Big Bang Theory character");
		JOptionPane.showMessageDialog(null,"Please answer all questions yes or no");
		
		if(usersPick.equalsIgnoreCase("a")) {
			System.out.println("Lets guess a Simpson Character!");
			// calls method to execute the game with Simpson tree
			playGame(STree);
			printingTree(STree);
		}
		else if (usersPick.equalsIgnoreCase("b")) {
			System.out.println("Lets guess a Big Bang Theory Character!");
			// calls method to execute the game with big bang theory tree
			playGame(BTree);
			printingTree(BTree);
		}
	}
	
	//this method executes the guessing game
	public static void playGame(BinaryNodeInterface<String> binaryNodeInterface) {
		String newQuestion="";
		String oldAns="";
		//print out current node
		userInput=JOptionPane.showInputDialog(binaryNodeInterface.getData());
		
		while (true) {
			//if yes go left in tree
			if (userInput.equalsIgnoreCase("yes")) {
				
				//ensures there is a left child and then calls the function again 
				if (binaryNodeInterface.hasLeftChild()) {
					playGame(binaryNodeInterface.getLeftChild());
				}
				//if there is no left child i.e at a leaf node, then the game is correct and asks the user what to do next
				else{
					//asks the user what to do next
					menu();
				}
			}
			
			//if no, go right in the tree
			else if (userInput.equalsIgnoreCase("no")) {
				
				//ensures there is a right node then calls the function again 
				if (binaryNodeInterface.hasRightChild()) {
				playGame(binaryNodeInterface.getRightChild());
				}
				//if there is no right child i.e at a leaf node, the game has guessed incorrectly and asks the 
				//user to enter the real answer and a question to improve the game
				else {
					//correctAns is set to the new answer inputed by the user
					correctAns=JOptionPane.showInputDialog("Oh no! Please enter the correct answer");
					//Initializes two new nodes
					BinaryNodeInterface<String> newNode = new BinaryNode<String>();
					BinaryNodeInterface<String> newNode1 = new BinaryNode<String>();
					//oldAns is set to the data that was in the node when it guessed incorrectly
					oldAns=binaryNodeInterface.getData();
					// sets data in newNode to the correct answer inputed by the user
					newNode.setData(correctAns);
					// sets data in newNode1 to oldAns (the incorrect guess)
					newNode1.setData(oldAns);
					// Asks the user for a new question and stores the info as a string called newQuestion
					newQuestion=JOptionPane.showInputDialog("Can you help make the game better by adding a question?");
					//sets current node data to the new question
					binaryNodeInterface.setData(newQuestion);
					// sets the new left child to the correct answer provided by the user
					binaryNodeInterface.setLeftChild(newNode);
					// sets the new right child to the incorrect answer guessed originally
					binaryNodeInterface.setRightChild(newNode1);
					//asks the user what to do next
					menu();
				}
			}
					
			//if an invalid answer is received the user is notified and goes back to the option menu
			else {
				JOptionPane.showMessageDialog(null, "Please enter a valid answer");
				menu();
			}
			break;
		}
		
	}
	
	//this method creates the binary tree for guessing Simpson character
	public static BinaryNode<String> SimpsonsTree() {
		BinaryNode<String> hTree = new BinaryNode<String>("Is it Homer?");
		BinaryNode<String> iTree = new BinaryNode<String>("Is it Bart?");
		BinaryNode<String> jTree = new BinaryNode<String>("Is it Moe?");
		BinaryNode<String> kTree = new BinaryNode<String>("Is it Grandpa?");
		BinaryNode<String> lTree = new BinaryNode<String>("Is it Marge?");
		BinaryNode<String> mTree = new BinaryNode<String>("Is it Lisa?");
		BinaryNode<String> nTree = new BinaryNode<String>("Is it Patty?");
		BinaryNode<String> oTree = new BinaryNode<String>("Is it Ms Krabappel?");
		
		BinaryNode<String> dTree = new BinaryNode<String>("Is he an adult?", hTree, iTree);
		BinaryNode<String> eTree = new BinaryNode<String>("Does he work in a bar?", jTree, kTree);
		BinaryNode<String> fTree = new BinaryNode<String>("Is she an adult?", lTree, mTree);
		BinaryNode<String> gTree = new BinaryNode<String>("Is she related to Marge?", nTree, oTree);
		
		BinaryNode<String> bTree = new BinaryNode<String>("Is he a main character?", dTree, eTree);
		BinaryNode<String> cTree = new BinaryNode<String>("Is she a main character?", fTree, gTree);
		
		BinaryNode<String> aTree = new BinaryNode<String>("Are they male?", bTree, cTree);
		return aTree;
	}
	
	//this method creates the binary tree for guessing Big Bang Theory character
	public static BinaryNode<String> BigBangTheoryTree() {
		BinaryNode<String> hTree = new BinaryNode<String>("Is it Sheldon?");
		BinaryNode<String> iTree = new BinaryNode<String>("Is it Lenard?");
		BinaryNode<String> jTree = new BinaryNode<String>("Is it Bert?");
		BinaryNode<String> kTree = new BinaryNode<String>("Is it Steward?");
		BinaryNode<String> lTree = new BinaryNode<String>("Is it Penney?");
		BinaryNode<String> mTree = new BinaryNode<String>("Is it Amy?");
		BinaryNode<String> nTree = new BinaryNode<String>("Is it Mary Cooper (Sheldons mom)?");
		BinaryNode<String> oTree = new BinaryNode<String>("Is it Leslie Winckle?");
		
		BinaryNode<String> dTree = new BinaryNode<String>("Is he tall?", hTree, iTree);
		BinaryNode<String> eTree = new BinaryNode<String>("Does he work at the university?", jTree, kTree);
		BinaryNode<String> fTree = new BinaryNode<String>("Is she blonde?", lTree, mTree);
		BinaryNode<String> gTree = new BinaryNode<String>("Is she a mother?", nTree, oTree);
		
		BinaryNode<String> bTree = new BinaryNode<String>("Is he a main character?", dTree, eTree);
		BinaryNode<String> cTree = new BinaryNode<String>("Is she a main character?", fTree, gTree);
		
		BinaryNode<String> aTree = new BinaryNode<String>("Are they male?", bTree, cTree);
		return aTree;
	}
	
	//This method traverses through the tree using recursion to print out all the nodes 
	public static void printingTree(BinaryNodeInterface<String> binaryNodeInterface) {
		//if there is a left node the if statement calls the method again
		if (binaryNodeInterface.hasLeftChild()) {
			
			printingTree(binaryNodeInterface.getLeftChild());
		}
		//if there is a right node the if statement calls the method again
		if (binaryNodeInterface.hasRightChild()) {
			printingTree(binaryNodeInterface.getRightChild());
		}
		//It then prints out the current node from bottom up
		System.out.println(binaryNodeInterface.getData());
	}
	
	// this method asks the user how they would like to continue when the game has been won, lost or if an 
	// invalid input is received
	public static void menu() {
	
		while(true) {
		String choice=JOptionPane.showInputDialog(
				  "Would you like to \n 1 Play again?"
				+ "\n 2 Store the tree?"
				+ "\n 3 Load a stored tree?"
				+ "\n 4 Quit the game?");
		//calls the method to choose a tree and this starts the game again from the start
		if (choice.equals("1")) {
			pickGame();
		}
		//calls the Saving class to save the tree and any improvements made, then calls itself to 
		// show the menu of options again
		else if (choice.equals("2")) {
			Saving.saveTree(saved);
			menu();
		}
		//if the user wants to load a saved tree the programme must run the tree that is stored in the arraylist called saved
		else if (choice.equals("3")) {
			saved=Saving.loadTree();
			usersPick=JOptionPane.showInputDialog("If you want to guess a Simpson charater press A or B to "
					+ "guess a Big Bang Theory character");
			JOptionPane.showMessageDialog(null,"Please answer all questions yes or no");
			
			if(usersPick.equalsIgnoreCase("a")) {
				System.out.println("Lets guess a Simpson Character!");
				playGame(saved.get(0));
			}
			else if (usersPick.equalsIgnoreCase("b")) {
				System.out.println("Lets guess a Big Bang Theory Character!");
				playGame(saved.get(1));
			}
		}
		// end game
		else if(choice.equals("4")) {
				break;
		}
	}
	}

}
