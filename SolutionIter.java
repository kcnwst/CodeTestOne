import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SolutionIter implements Iterable<Integer>{
	public static void main(String args[]) {
		// TODO Auto-generated method stub
		for(Integer x : new SolutionIter()) {
			System.out.println(x);
		}
	}
	
	public SolutionIter() {}
	
	public SolutionIter(Reader inp) {}

	public Iterator<Integer> iterator() {
		List<Integer> result = new ArrayList<Integer>();
		
		try {
			BufferedReader b = new BufferedReader(new FileReader("/Users/kcn/eclipse-workspace/SolutionIter/src/test.txt"));
			String line;
			
			while((line = b.readLine()) != null) {
				
				line = line.trim();
				
				if(hasChar(line)) {
					continue;
				}

				if(hasSpace(line)) {
					continue;
				}

				if(containsInvalidSign(line)) {
					continue;
				}				
				
				if(hasDecimal(line)) {
					continue;
				}

				try {
					int num = Integer.parseInt(line);
					//System.out.println(num + " ^");
					if(outOfLimit(num)) {
						//System.out.println(num + " +1");
						continue;
					} else {
						//System.out.println(num + " +2");
						result.add(num);
					}
				} catch(Exception e) {
					continue;
				}
				
				line = b.readLine();
			}
			
			b.close();
			
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		return result.iterator();
	}
	
	public boolean hasChar(String s) {
		char[] temp = s.toCharArray();
		
		for(char t : temp) {
			if(Character.isLetter(t)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean hasSpace(String s) {
		if(s.contains(" ")) {
			return true;
		}
		return false;
	}
	
	public boolean hasDecimal(String s) {
		if(s.contains(".")) {
			return true;
		}
		return false;
	}
	
	public boolean outOfLimit(int i) {
		if(i > 1000000000 || i < -1000000000) {
			return true;
		}
		return false;
	}
	
	public boolean containsInvalidSign(String s) {
		if(s.contains("++") || s.contains("--")) {
			return true;
		}
		return false;
	}
}
