import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Member extends Account {
	private Date dateofMemberShip;
	private int totalBooksCheckedOut;
	private List<BookItem> booksIssued;
	private List<BookItem> booksReserved;
	
	public Member(Account account) {
		super();
		dateofMemberShip = new Date();
		totalBooksCheckedOut = 0;
		booksIssued = new ArrayList();
		booksReserved = new ArrayList();
	}
	public Date getDateofMemberShip() {
		return dateofMemberShip;
	}
	public void setDateofMemberShip(Date dateofMemberShip) {
		this.dateofMemberShip = dateofMemberShip;
	}
	public int getTotalBooksCheckedOut() {
		return totalBooksCheckedOut;
	}
	public void setTotalBooksCheckedOut(int totalBooksCheckedOut) {
		this.totalBooksCheckedOut = totalBooksCheckedOut;
	}
	
	public  boolean reserveBookItem(BookItem bookItem) {
		booksReserved.add(bookItem);
		return true;
	}
	
	public void incTotalBooksCheckedOut() {
		this.totalBooksCheckedOut++;
	}
	
}
