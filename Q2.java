import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Q2 {

	public static void main(String[] args) {
		List<Book> bookList; 
		bookList = new ArrayList<>();
		bookList.add(new Book(1, "Only time will tell", "Sydney", "Thriller", 200.0));
		bookList.add(new Book(2, "DaVinci Code", "Dan Brown", "Thriller", 400.0));
		bookList.add(new Book(3, "Two States", "Chetan Bhagat", "Romantic", 250.0));
		bookList.add(new Book(4, "The Kite Runner", "Khaleid Hossei", "Spritual", 320.0));
		bookList.add(new Book(5, "How to kill a mocking bird", "Dan Brown", "Thriller", 500.0));
		bookList.add(new Book(6, "Lost in Time", "Chetan Bhagat", "Comedy", 150.0));
		bookList.add(new Book(7, "Angels and Demon", "Dan Brown", "Thriller", 300.0));
		bookList.add(new Book(8, "What young India wants?", "Chetan Bhagat", "Comedy", 200.0));
		bookList.add(new Book(9, "A girl with the dragon tatoo", "Khaleid Hossei", "Thriller", 420.0));
		bookList.add(new Book(10, "Gone Girl", "Dan Brown", "Thriller", 500.0));
		
		Map<String, Integer> map = new HashMap<>();
		
		//Creating a HashMap 
		for(Book bookObj: bookList)
		{
			if(map.containsKey(bookObj.getAuthorName()))
			{
				map.put(bookObj.getAuthorName(), map.get(bookObj.getAuthorName())+1);
			}
			else
			{
				map.put(bookObj.getAuthorName(), 1);
			}
		}
		
		//Iterating the HashMap
		Iterator itr = map.entrySet().iterator();
		while (itr.hasNext()) {
			Map.Entry<String, Integer> entrySet = (Map.Entry) itr.next();
			if (entrySet.getValue() > 2)
				System.out.println(entrySet.getKey());
		}
	}

}
