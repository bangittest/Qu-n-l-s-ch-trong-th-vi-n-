import java.util.Scanner;

public class Book {
    private int bookId;
    private String bookName;
    private String author;
    private String description;
    private double importPrice;
    private double exportPrice;
    private float interest;
    private int quantity;
    private boolean bookStatus=true;

    public Book(){

    }
    public Book(int bookId, String bookName, String author, String description, double importPrice, double exportPrice, float interest, int quantity, boolean bookStatus) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.author = author;
        this.description = description;
        this.importPrice = importPrice;
        this.exportPrice = exportPrice;
        this.interest = interest;
        this.quantity = quantity;
        this.bookStatus = bookStatus;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(double importPrice) {
        this.importPrice = importPrice;
    }

    public double getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(double exportPrice) {
        this.exportPrice = exportPrice;
    }

    public float getInterest() {
        return interest;
    }

    public void setInterest(float interest) {
        this.interest = interest;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(boolean bookStatus) {
        this.bookStatus = bookStatus;
    }

    public void inputData(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Nhap ten sach: ");
        this.bookName=scanner.nextLine();

        System.out.println("nhap ten tac gia: ");
        this.author=scanner.nextLine();

        System.out.println("nhap mo ta ve sach: ");
        while (true){
            this.description=scanner.nextLine();
            if (description.length()>=10){
                break;
            }else {
                System.out.println("mo ta it nhat phai 10 ki tu !");
            }
        }
        System.out.println("nhap gia nhap: ");
        while (true){
            this.importPrice=scanner.nextInt();
            if (importPrice>0){
                break;
            }else {
                System.out.println("gia nhap khong dung dinh dang");
            }
        }

        System.out.println("nhap gia xuat: ");
        while (true){
            this.exportPrice=scanner.nextInt();
            if (exportPrice>1.2*importPrice){
                break;
            }else {
                System.out.println("gia xuat phao lon hon: ");
            }
        }
        this.interest= (float) (exportPrice-importPrice);

        System.out.println("nhap so luong san pham: ");
        while (true){
            this.quantity=scanner.nextInt();
            if (quantity>0){
                break;
            }else {
                System.out.println("so luong k dung dinh dang");
            }
        }
        scanner.nextLine();

        System.out.println("trang thai true/false: ");
        this.bookStatus=scanner.nextBoolean();

    }

    public void displayData(){
        System.out.println("ma sach:" +bookId);
        System.out.println("ten sach: " + bookName);
        System.out.println("tac gia: " + author);
        System.out.println("mo ta: " + description);
        System.out.println("gia nhap: " + importPrice);
        System.out.println("gia xuat: " + exportPrice);
        System.out.println("loi nhuan: " + interest);
        System.out.println("so luong san pham: " + quantity);
        System.out.println("trang thai: " + bookStatus);
    }


}
