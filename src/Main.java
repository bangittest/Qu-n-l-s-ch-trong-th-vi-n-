import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static final int MAX_BOOKS=100;
    private static Book[]books=new Book[MAX_BOOKS];
    private static int bookCount=0;

    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        while (true){
            System.out.println("**************** MENU ***************");
            System.out.println("1. Nhập số lượng sách thêm mới và nhập thông tin cho từng cuốn sách");
            System.out.println("2. Hiển thị thông tin tất cả sách trong thư viện");
            System.out.println("3. Thay đổi thông tin sách theo mã sách");
            System.out.println("4. Xóa sách theo mã sách");
            System.out.println("5. Sắp xếp sách theo lợi nhuận tăng dần");
            System.out.println("6. Tìm kiếm tương đối sách theo tên sách hoặc mô tả");
            System.out.println("7. Nhập sách");
            System.out.println("8. Bán sách");
            System.out.println("9. Thoát");
            int choise=scanner.nextInt();
            scanner.nextLine();
            switch (choise){
                case 1:
                    //them moi
                    addBook(scanner);
                    break;
                case 2:
                    //hien thi thong tin sach
                    displayBooks();
                    break;
                case 3:
                    //thay doi thong tin sach
                    modifyBook(scanner);
                    break;
                case 4:
                    //xoa sach
                    deleteBook(scanner);
                    break;
                case 5:
                    //sap xep
                    sortBooks(scanner);
                    break;
                case 6:
                    //tim kiem
                    seachBook(scanner);
                    break;
                case 7:
                    //nhap sach
                    importBook(scanner);
                    break;
                case 8:
                    //ban sach
                    sellBook(scanner);
                case 9:
                    //thoat
                    System.out.println("ket thuc");
                    System.exit(0);
                    break;
                default:
                    System.out.println("lua chon k hop le");
                    break;
            }

        }

    }

    private static void sellBook(Scanner scanner) {
        System.out.println("nhap ten sach can ban");
        String bookName=scanner.nextLine();

        System.out.println("nhap so luong can ban: ");
        int quantityToSell=scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < bookCount; i++) {
            if (books[i].getBookName().equalsIgnoreCase(bookName)){
                int currentQuantity = books[i].getQuantity();
                if (currentQuantity>=quantityToSell){
                    books[i].setQuantity(currentQuantity-quantityToSell);
                    System.out.println("ban sach thanh cong");
                    return;
                }else {
                    System.out.println("so luong sach khong du de ban ");
                    return;
                }
            }

        }
        System.out.println("k tim thay sach co ten " + bookName);
    }

    private static void importBook(Scanner scanner) {
        System.out.println("nhap ma sach can nhap them :");
        int importId=scanner.nextInt();
        scanner.nextLine();

        System.out.println("nhap sp luong can them : ");
        int quantityToAdd=scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < bookCount; i++) {
            if (books[i].getBookId()==importId){
                int currentQuantyti=books[i].getQuantity();
                books[i].setQuantity(currentQuantyti+quantityToAdd);
                System.out.println("nhap sach thanh cong");
                return;
            }
        }
        System.out.println("k tim thay sach co ma " + importId);
    }


    private static void seachBook(Scanner scanner) {
        System.out.println("nhap ten sach hoac mo ta can tim");
        String keyword=scanner.nextLine();

        boolean found=false;
        for (int i = 0; i < bookCount; i++) {
            Book book=books[i];
            if (book.getBookName().toLowerCase().contains(keyword) || book.getDescription().toLowerCase().contains(keyword)) {
                book.displayData();
                System.out.println("------------------------------");
                found = true;
            }
        }

        if (!found){
            System.out.println("k tim thay sach phu hop voi tu khoa " + keyword);
        }
    }

    private static void sortBooks(Scanner scanner) {
        Arrays.sort(books, 0, bookCount, (b1, b2) ->
                Float.compare(b1.getInterest(), b2.getInterest()));
        System.out.println("sap xep sach loi nhuan thanh cong");
    }

    private static void deleteBook(Scanner scanner) {
        System.out.println("nhap ma sach can xoa");
        int bookIddel=scanner.nextInt();
        for (int i = 0; i < bookCount; i++) {
            if (books[i].getBookId()==bookIddel){
                for (int j = i; j <bookCount-1 ; j++) {
                    books[j]=books[j+1];
                }
                bookCount--;
                System.out.println("xoa thanh cong");
            }
        }
        System.out.println("k tim thay");
    }

    private static void modifyBook(Scanner scanner) {
        System.out.println("Nhap ma sach can thay doi");
        int bookId=scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < bookCount; i++) {
            if (books[i].getBookId()==bookId){
                System.out.println("nhap thong tin sach moi");
                books[i].inputData();
                System.out.println("thay doi thanh cong");
                return;
            }
        }
        System.out.println("k tim thay");
    }

    private static void displayBooks() {
        System.out.println("Thong tin sach tat ca trong thu vien");
        for (int i = 0; i < bookCount; i++) {
            System.out.println("sach thu " + (i + 1) + ":");
            books[i].displayData();
            System.out.println("---------------------");
        }
    }

    private static void addBook(Scanner scanner) {
        System.out.println("Nhap so luong can them moi: ");
        int numBooksToAdd=scanner.nextInt();
        scanner.nextLine();

        if (numBooksToAdd>0 &&(bookCount+numBooksToAdd)<=MAX_BOOKS){
            for (int i = 0; i < numBooksToAdd; i++) {
                System.out.println("nhap thong tin cho cuon thu:" + (i+1) + ":");
                Book book=new Book();
                book.inputData();
                books[bookCount++]=book;
            }
            System.out.println("Them sach thanh cong");
        }else{
            System.out.println("so luong sach k hop le");
        }
    }
}
