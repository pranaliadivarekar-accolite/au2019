import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Q1 {

	public static void main(String[] args) {
		List<Book> bookList;
		bookList = new ArrayList<>();

		bookList.add(new Book(1, "Only time will tell", "Sydney", "Thriller", 200.0));
		bookList.add(new Book(2, "DaVinci Code", "Dan Brown", "Thriller", 400.0));
		bookList.add(new Book(3, "Two States", "Chetan Bhagat", "Romantic", 250.0));
		bookList.add(new Book(4, "The Kite Runner", "Khaleid Hossei", "Spritual", 320.0));
		bookList.add(new Book(5, "How to kill a mocking bird", "Harper Lee", "Thriller", 500.0));
		bookList.add(new Book(6, "Lost in Time", "O Henry", "Comedy", 150.0));
		bookList.add(new Book(7, "Angels and Demon", "Dan Brown", "Thriller", 300.0));
		bookList.add(new Book(8, "What young India wants?", "Chetan Bhagat", "Comedy", 200.0));
		bookList.add(new Book(9, "A girl with the dragon tatoo", "Khaleid Hossei", "Thriller", 420.0));
		bookList.add(new Book(10, "Gone Girl", "Dan Brown", "Thriller", 500.0));

		bookList.sort(new BookComparator());
		System.out.println("Sort List: ");
		System.out.println(bookList);

		Iterator<Book> itr = bookList.iterator();

		//Iterating and decreasing the price by 20%
		while (itr.hasNext()) {
			Book b = itr.next();
			b.setBookPrice(b.getBookPrice() - (b.getBookPrice() * 0.2));
		}

		System.out.println("Updated List: ");
		System.out.println(bookList);

	}

}
