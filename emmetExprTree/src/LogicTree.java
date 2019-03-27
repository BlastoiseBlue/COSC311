import java.io.IOException;

/**
 * @author Emmet Stanevich
 */
public class LogicTree extends ExprTree {
	LogicTreeNode root;
	LogicTree(LogicTreeNode r){
		super(r);
	}
	@Override
	public boolean evaluate(){
		return evalSub(root);
	}
	private boolean evalSub(LogicTreeNode n){
		if(Character.isDigit(n.getElement()))return (n.getElement())-48==1;
		else{
			switch (n.getElement()){
				case '+':
					return (evalSub((LogicTreeNode) n.getLeft())||evalSub((LogicTreeNode) n.getRight()));
				case '-':
					return (!evalSub((LogicTreeNode) n.getRight()));
				case '*':
					return (evalSub((LogicTreeNode) n.getLeft())&&evalSub((LogicTreeNode) n.getRight()));
			}
		}throw new Error("Cannot evaluate");
	}
	
	@Override
	public void build() throws IOException {
		super.build();
	}
}
