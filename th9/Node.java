package th9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class Node {
	private List<Integer> data = new ArrayList<Integer>();

	public List<Integer> getData() {
		return data;
	}

	public void setData(List<Integer> data) {
		this.data = data;
	}

	public void add(Integer val) {
		this.data.add(val);
	}

	public void addAll(List<Integer> data) {
		this.data.addAll(data);
	}

	// Get children of the current nodes
	public List<Node> getSuccessors() {
	    List<Node> sc = new ArrayList<>();
	    data.sort(DESCOMPARATOR);
	    for (int i = 0; i < data.size(); i++) {
	        int count = data.get(i);
	        for (int j = 1; j <= count / 2; j++) {
	            Node n = new Node();
	            n.add(j);
	            n.add(count - j);
	            for(int k=0 ; k <data.size();k++) {
	            	if(k!=i)n.add(data.get(k));
	            }
	            n.getData().sort(DESCOMPARATOR);
	            if(!sc.contains(n))
	            sc.add(n);
	        }
	    }
	    return sc;
	}

	// Check whether a node is terminal or not
	public boolean isTerminal() {
		// Enter your code here
		data.sort(DESCOMPARATOR);
		return (data.get(0) <= 2);
	}

	public static final Comparator<Integer> DESCOMPARATOR = new Comparator<Integer>() {
		@Override
		public int compare(Integer o1, Integer o2) {
			return o2.compareTo(o1);
		}
	};

	@Override
	public String toString() {
		Collections.sort(this.data, DESCOMPARATOR);
		return this.data.toString();
	}

}
