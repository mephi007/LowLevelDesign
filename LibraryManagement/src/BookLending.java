import java.util.Date;

public class BookLending {
	private Date creationDate;
	private Date dueDate;
	private Date returnDate;
	private String bookItemBarCode;
	private String memberId;
	
	public static boolean lendBook(String barcode, String memeberId) {
		return false;
	}
	
	public static BookLending fetchLendingDetails(String barcode) {
		return null;
	}
	
}
