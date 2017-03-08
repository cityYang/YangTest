package Bean;

import java.util.ArrayList;
import java.util.List;

public class RemoveElement {
	public static void main(String[]args){
		long [] testlong =null;
		List<Long>list =new ArrayList<Long>();
		list.add(1l);
		list.add(2l);
		if(list.size()>0){
			testlong = new long[list.size()];
			for(int i =0;i<list.size();i++){
				testlong[i]=list.get(i);
			}
		}
		System.out.println(testlong[1]);
	}

}
