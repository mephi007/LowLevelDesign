import java.util.Date;

public class BookItem extends Book{
	private String barcode;
	private boolean isReferenceOnly;
	private Date borrowed;
	private Date dueDate;
	private double price;
	private BookFormat format;
	private BookStatus status;
	private Date dateOfPurchase;
	private Date publicationsDate;
	private Rack placedAt;
	public String getBarcode() {
		return barcode;
	}
	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
	public boolean isReferenceOnly() {
		return isReferenceOnly;
	}
	public void setReferenceOnly(boolean isReferenceOnly) {
		this.isReferenceOnly = isReferenceOnly;
	}
	public Date getBorrowed() {
		return borrowed;
	}
	public void setBorrowed(Date borrowed) {
		this.borrowed = borrowed;
	}
	public Date getDueDate() {
		return dueDate;
	}
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public BookFormat getFormat() {
		return format;
	}
	public void setFormat(BookFormat format) {
		this.format = format;
	}
	public BookStatus getStatus() {
		return status;
	}
	public void setStatus(BookStatus status) {
		this.status = status;
	}
	public Date getDateOfPurchase() {
		return dateOfPurchase;
	}
	public void setDateOfPurchase(Date dateOfPurchase) {
		this.dateOfPurchase = dateOfPurchase;
	}
	public Date getPublicationsDate() {
		return publicationsDate;
	}
	public void setPublicationsDate(Date publicationsDate) {
		this.publicationsDate = publicationsDate;
	}
	public Rack getPlacedAt() {
		return placedAt;
	}
	public void setPlacedAt(Rack placedAt) {
		this.placedAt = placedAt;
	}
	
	public boolean checkout(BookItem bookItem, String memberId) throws Exception{
		try {
			if(bookItem.isReferenceOnly) {
				throw new Exception();
			}
			if(!BookLending.lendBook(this.getBarcode(), memberId)) {
				return false;
			}
			this.updateBookItemStatus(BookStatus.Loaned);
			return true;
		}catch(Exception e) {
			System.out.println("This book is Reference only and can't be issued");
		}
		return false;
	}
	private void updateBookItemStatus(BookStatus loaned) {
		// TODO Auto-generated method stub
		this.status = BookStatus.Loaned;
	}
}
