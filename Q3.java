import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class Q3 {

	public static void main(String[] args) {
		Map<String, Integer> treeMap = new TreeMap<>();
		List<String> userInput = new ArrayList<>();
		Scanner scan = new Scanner(System.in);
		int choice;
		String word;

		// Take user input
		boolean flag = true;
		while (flag) {
			System.out.print("Enter your choice: \n 1. Add in List\n 2. Exit\nChoice: ");
			choice = scan.nextInt();
			switch (choice) {
			case 1:
				System.out.print("Enter string: ");
				word = scan.next();
				userInput.add(word);
				break;
			case 2:
				flag = false;
				break;

			default:
				System.out.println("Wrong I/P");
				break;
			}
		}

		for (String s : userInput) {
			if (treeMap.containsKey(s)) {
				treeMap.put(s, treeMap.get(s) + 1);
			} else {
				treeMap.put(s, 1);
			}
		}

		
		Iterator itr = treeMap.entrySet().iterator();
		while (itr.hasNext()) {
			Map.Entry<String, Integer> entrySet = (Map.Entry) itr.next();
			if (entrySet.getValue() > 1)
				System.out.println(entrySet.getKey());
		}
	}

}
