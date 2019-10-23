public class BST<T> {


	class BSTNode{

		Comparable data;

		BSTNode right;
		BSTNode left;


		public BSTNode(Comparable value){
			this.data = value;
		}
	}

	private BSTNode root;

	public BST(){
		root = null;
	}



	public void insert(Comparable value) {

		root = insert(root, value);
	}

	private BSTNode insert(BSTNode n, Comparable value) {

		if (n == null) {
			return new BSTNode(value);
		}


		if (n.data.compareTo(value) < 0) {
			n.right = insert(n.right, value);
			return n;
		}

		else{
			n.left = insert(n.left, value);
			return n;
		}

	}

	public void delete(Comparable value){
		root = delete(root, value);
	}




	private BSTNode delete(BSTNode n, Comparable value) {
		if (n == null) {
			return null;
		}
		if (n.data.compareTo(value) == 0) {
			if (n.left == null) {
				return n.right;
			} else if (n.right == null) {
				return n.left;
			} else {
				if (n.right.left == null) {
					n.data = n.right.data;
					n.right = n.right.right;
					return n;
				} else {
					n.data = removeValue(n.right);
					return n;
				}
			}
		}
		else if(n.data.compareTo(value)<0){
				n.right = delete(n.left, value);
			}
			else{
				delete(n.left,value);
			}

		return n;

	}

	Comparable removeValue(BSTNode n){

		if(n.left.left == null){

			Comparable value = n.left.data;
			n.left = n.left.right;
			return value;
		}
		else{
			return removeValue(n.left);
		}
	}

	public boolean find(Comparable value){
		return find(root, value);
	}



	private boolean find(BSTNode n, Comparable value){
		if(n==null){
			return false;
		}
		if(n.data.compareTo(value) == 0){
			return true;
		}
		else if(n.data.compareTo(value) > 0){
			return find(n.left,value);
		}
		else{
			return find(n.right,value);
		}
	}


	public void print(){
		print(root);
	}

	private void print(BSTNode n){

		if(n != null){
			print(n.left);
			System.out.println(n.data);
			print(n.right);
		}
	}



}