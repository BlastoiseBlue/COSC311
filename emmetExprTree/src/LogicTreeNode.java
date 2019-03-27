/**
 * @author Emmet Stanevich
 */
public class LogicTreeNode extends ExprTreeNode {
	private byte element;
	LogicTreeNode(byte elem){
		super((char)elem);
	}
	LogicTreeNode(byte elem, LogicTreeNode l, LogicTreeNode r){
		super((char) elem,l,r);
		element=elem;
	}
}
