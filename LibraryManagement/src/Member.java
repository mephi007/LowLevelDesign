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
	
	public boolean checkoutBookItem(BookItem bookItem) throws Exception {
	    if (this.getTotalBooksCheckedOut() >= Constants.MAX_BOOKS_ISSUED_TO_A_USER) {
	      System.out.println("The user has already checked-out maximum number of books");
	      return false;
	    }
	    BookReservation bookReservation = BookReservation.fetchReservationDetails(bookItem.getBarcode());
	    if (bookReservation != null && bookReservation.getMemberId() != this.getId()) {
	      // book item has a pending reservation from another user
	      System.out.println("This book is reserved by another member");
	      return false;
	    } else if (bookReservation != null) {
	      // book item has a pending reservation from the give member, update it
	      bookReservation.updateStatus(ReservationStatus.Completed);
	    }

	    if (!bookItem.checkout(bookItem, this.getId())) {
	      return false;
	    }

	    this.incTotalBooksCheckedOut();
	    return true;
	  }
	
}
