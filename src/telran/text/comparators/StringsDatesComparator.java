package telran.text.comparators;

import static org.junit.jupiter.api.Assertions.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;

import org.junit.jupiter.api.Test;

public class StringsDatesComparator implements Comparator<String>  {
	//1 variant
//	@Override
//	public int compare(String o1, String o2) {
//		String[] date1 = o1.split("/",3);
//		String[] date2 = o2.split("/",3);
//		return !(date1[2].equals(date2[2]))
//				? Integer.parseInt(date1[2]) - Integer.parseInt(date2[2])
//						: !(date1[1].equals(date2[1]))
//						? Integer.parseInt(date1[1]) - Integer.parseInt(date2[1])
//								: Integer.parseInt(date1[0]) - Integer.parseInt(date2[0]) ;
//	}
	//2 variant
	DateFormat f = new SimpleDateFormat("dd/mm/yyyy");
	@Override
	public int compare(String o1, String o2) {
		try {
			return f.parse(o1).compareTo(f.parse(o2));
		} catch (ParseException e) {
			throw new IllegalArgumentException(e);
		}
	}
}
