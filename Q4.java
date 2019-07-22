import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q4 {

	public static void main(String[] args) {
		
		List<String> list1 = new ArrayList<>();
		List<String> list2 = new ArrayList<>();
		Scanner scan = new Scanner(System.in);
		boolean flag = true;
		String input;
		
		while(flag)
		{
			System.out.print("Enter a string to add in list 1: ");
			input = scan.next();
			list1.add(input);
			System.out.print("Enter 1 to continue and any number to exit: ");
			if(scan.nextInt() != 1)
				flag = false;
		}
		flag = true;
		while(flag)
		{
			System.out.print("Enter a string to add in list 2: ");
			input = scan.next();
			list2.add(input);
			System.out.print("Enter 1 to continue and any number to exit: ");
			if(scan.nextInt() != 1)
				flag = false;
		}
		
		System.out.println("Coomon elements in both the list: ");
		list1.retainAll(list2);
		System.out.println(list1);
		

	}

}
