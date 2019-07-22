
import java.util.Comparator;

public class BookComparator implements Comparator<Book> {

	@Override
	public int compare(Book o1, Book o2) {
		int val = compareByPrice(o1, o2);
		if (val == 0)
			return compareByName(o1, o2);
		return val;
	}

	public int compareByPrice(Book o1, Book o2) {
		if (o1 == null) {
			if (o2 == null)
				return 0;
			return -1;
		}
		if (o2 == null)
			return 1;
		return o1.getBookPrice().compareTo(o2.getBookPrice());
	}

	public int compareByName(Book o1, Book o2) {
		if (o1 == null) {
			if (o2 == null)
				return 0;
			return -1;
		}
		if (o2 == null)
			return 1;
		return o1.getBookTitle().compareTo(o2.getBookTitle());
	}

}
