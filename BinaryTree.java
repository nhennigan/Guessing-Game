

/**
 * A class that implements the ADT binary tree.
 * 
 * @author Frank M. Carrano
 * @version 2.0
 */
public class BinaryTree<T> implements BinaryTreeInterface<T>, java.io.Serializable
{
	private static final long serialVersionUID = -1932834476575953631L;
	private BinaryNodeInterface<T> root;

	public BinaryTree()
	{
		root = null;
	} // end default constructor

	public BinaryTree(T rootData)
	{
		root = new BinaryNode<T>(rootData);
	} // end constructor

	public BinaryTree(T rootData, BinaryTree<T> leftTree, 
			BinaryTree<T> rightTree)
	{
		privateSetTree(rootData, leftTree, rightTree);
	} // end constructor

	public void setTree(T rootData)
	{
		root = new BinaryNode<T>(rootData);
	} // end setTree

	public void setTree(T rootData, BinaryTreeInterface<T> leftTree,
			BinaryTreeInterface<T> rightTree)
	{
		privateSetTree(rootData, (BinaryTree<T>)leftTree, 
				(BinaryTree<T>)rightTree);
	} // end setTree

	// 26.08
	private void privateSetTree(T rootData, BinaryTree<T> leftTree, 
			BinaryTree<T> rightTree)
	{
		root = new BinaryNode<T>(rootData);

		if ((leftTree != null) && !leftTree.isEmpty())
			root.setLeftChild(leftTree.root);

		if ((rightTree != null) && !rightTree.isEmpty())
		{
			if (rightTree != leftTree)
				root.setRightChild(rightTree.root);
			else
				root.setRightChild(rightTree.root.copy());
		} // end if

		if ((leftTree != null) && (leftTree != this))
			leftTree.clear(); 

		if ((rightTree != null) && (rightTree != this))
			rightTree.clear();
	} // end privateSetTree


	private BinaryNode<T> copyNodes() // not essential
	{
		return (BinaryNode<T>)root.copy();
	} // end copyNodes

	// 26.09
	public T getRootData()
	{
		T rootData = null;

		if (root != null)
			rootData = root.getData();

		return rootData;
	} // end getRootData

	// 26.09
	public boolean isEmpty()
	{
		return root == null;
	} // end isEmpty

	// 26.09
	public void clear()
	{
		root = null;
	} // end clear

	// 26.09
	protected void setRootData(T rootData)
	{
		root.setData(rootData);
	} // end setRootData

	// 26.09
	protected void setRootNode(BinaryNodeInterface<T> rootNode)
	{
		root = rootNode;
	} // end setRootNode

	// 26.09
	protected BinaryNodeInterface<T> getRootNode()
	{
		return root;
	} // end getRootNode

	// 26.10
	public int getHeight()
	{
		return root.getHeight();
	} // end getHeight

	// 26.10
	public int getNumberOfNodes()
	{
		return root.getNumberOfNodes();
	} // end getNumberOfNodes

	// 26.12
	public void inorderTraverse() 
	{
		inorderTraverse(root);
	} // end inorderTraverse

	private void inorderTraverse(BinaryNodeInterface<T> node) 
	{
		if (node != null)
		{
			inorderTraverse(node.getLeftChild());
			System.out.println(node.getData());
			inorderTraverse(node.getRightChild());
		} // end if
	} // end inorderTraverse

} // end BinaryTree
