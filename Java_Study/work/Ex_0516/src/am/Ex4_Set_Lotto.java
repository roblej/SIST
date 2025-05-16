package am;

import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

public class Ex4_Set_Lotto {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
// 		set 구조로 로또
		TreeSet<Integer> set= new TreeSet<>();
		
		while(set.size()<6) {
			set.add((int)(Math.random()*45+1));			
		}
		
		Iterator<Integer> it = set.iterator();
		while(it.hasNext()) {
			int num = it.next();
			System.out.println(num);
		}
		
	}

}
