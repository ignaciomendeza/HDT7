package structure;

import java.util.ArrayList;

/**
 * 
 */

/**
 * @author MAAG
 *
 */
public class Ordenador<K, V> implements ITraversal<K, V> {

	private ArrayList<String> miListado = new ArrayList<String>();
	
	@Override
	public void visit(TreeNode<K, V> actualNode) {
		String actual = (String) actualNode.getValue();
		miListado.add(actual);
	}

	/**
	 * @return the miListado
	 */
	public ArrayList<String> getMiListado() {
		return miListado;
	}

	/**
	 * @param miListado the miListado to set
	 */
	public void setMiListado(ArrayList<String> miListado) {
		this.miListado = miListado;
	}

	
	
}
