package tuan4.QLSach_SaveText;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;


public class SaveFileByText {
	
	public static BookList readFile(String part) throws Exception{
        BookList list = new BookList();
        File file = new File(part);
        if(file.exists()){
            Scanner sc = new Scanner(file, StandardCharsets.UTF_8);
            System.out.println("file ton tai!");
            
            if(sc.hasNextLine()) {
                sc.nextLine();// bỏ qua dòng tiêu đề
            }

            while (sc.hasNextLine()){
            
                String line = sc.nextLine();

                String []data = line.split(";");

                Book nv = new Book(data[0], data[1], data[2], Integer.parseInt(data[3]), data[4], 
                				Integer.parseInt(data[5]), Double.parseDouble(data[6]), data[7]);
                                
                list.add(nv);
            }
            sc.close();
        }
        else{
        	file.createNewFile();
            System.out.print("Tao File");
        }
        return list;
    }
	
	
    public static void writeFile(String part, BookList list) throws Exception{
		String title = "MaSach;TuaSach;TacGia;NamXuatBan;NhaXuatBan;SoTrang;DonGia;ISBN";
        try(PrintWriter out = new PrintWriter(new FileOutputStream(part),true, StandardCharsets.UTF_8)){

        	out.println(title);

            for(Book book : list.getList()){
                String data = book.getId() + ";" +
                				book.getTitle() + ";" +
                				book.getAuthor() + ";" +
                				book.getLauchYear() + ";" +
                				book.getPublishCompany() + ";" +
                				book.getPageNumber() + ";" + 
                				book.getPrice() + ";" +
                				book.getIsbn();
                			
                out.println(data);
            }
        }
    }
}
