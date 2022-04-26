package tuan4.QLSach_SaveText;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class GUI_Book extends JFrame implements ActionListener, MouseListener {
	/**
	 * 
	 */
	private JTextField txtMa;
	private JTextField txtTua;
	private JTextField txtNamXB;
	private JTextField txtSoTrang;
	private JTextField txtISBN;
	private JTextField txtTacGia;
	private JTextField txtNhaXB;
	private JTextField txtDonGia;
	private JButton btnThem;
	private JButton btnXoaRong;
	private JButton btnXoa;
	private JButton btnSua;
	private JButton btnLuu;
	private JComboBox<String> cboSearch;
	private DefaultTableModel modelTable;
	private JTable tblSach;
	private BookList list;

	public GUI_Book(String title) {
		setTitle(title);
		doShow();
		//trấn
	}

	public void doShow() {
		setSize(800, 500);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		list = new BookList();
		addConTrol();
	}

	public void addConTrol() {
		JPanel pnCha = new JPanel();
		pnCha.setLayout(new BorderLayout());

		// North
		JPanel pnNorth = new JPanel();
		pnNorth.setBorder(new TitledBorder(BorderFactory.createLineBorder(Color.CYAN), "Records Editor"));
		pnNorth.setPreferredSize(new Dimension(800, 170));
		pnCha.add(pnNorth, BorderLayout.NORTH);

		JLabel lbMa = new JLabel("Mã sách:");
		txtMa = new JTextField();
		txtMa.setText("C004");
		txtMa.setPreferredSize(new Dimension(200, 20));
		JLabel lbTua = new JLabel("Tựa sách:");
		txtTua = new JTextField();
		txtTua.setText("Conan");
		txtTua.setPreferredSize(new Dimension(300, 20));
		JLabel lbNamXB = new JLabel("Năm xuất bản:");
		txtNamXB = new JTextField();
		txtNamXB.setText("1994");
		txtNamXB.setPreferredSize(new Dimension(300, 20));
		JLabel lbSoTrang = new JLabel("Số trang:");
		txtSoTrang = new JTextField();
		txtSoTrang.setText("104");
		txtSoTrang.setPreferredSize(new Dimension(300, 20));
		JLabel lbISBN = new JLabel("International Standard Book Number:");
		txtISBN = new JTextField();
		txtISBN.setText("76-4238-4325-09");
		txtISBN.setPreferredSize(new Dimension(170, 20));
		JLabel lbTacGia = new JLabel("Tác giả:");
		txtTacGia = new JTextField();
		txtTacGia.setText("Aoyama Gosho");
		txtTacGia.setPreferredSize(new Dimension(250, 20));
		JLabel lbNhaXB = new JLabel("Nhà xuất bản:");
		txtNhaXB = new JTextField();
		txtNhaXB.setText("Kim Đồng");
		txtNhaXB.setPreferredSize(new Dimension(250, 20));
		JLabel lbDonGia = new JLabel("Đơn giá:");
		txtDonGia = new JTextField();
		txtDonGia.setText("20000");
		txtDonGia.setPreferredSize(new Dimension(250, 20));

		pnNorth.add(lbMa);
		pnNorth.add(txtMa);
		pnNorth.add(Box.createHorizontalStrut(430));
		pnNorth.add(lbTua);
		pnNorth.add(txtTua);
		pnNorth.add(lbTacGia);
		pnNorth.add(txtTacGia);
		pnNorth.add(lbNamXB);
		pnNorth.add(txtNamXB);
		pnNorth.add(lbNhaXB);
		pnNorth.add(txtNhaXB);
		pnNorth.add(lbSoTrang);
		pnNorth.add(txtSoTrang);
		pnNorth.add(lbDonGia);
		pnNorth.add(txtDonGia);
		pnNorth.add(lbISBN);
		pnNorth.add(txtISBN);
		pnNorth.add(Box.createHorizontalStrut(330));

		lbMa.setPreferredSize(lbNamXB.getPreferredSize());
		lbTua.setPreferredSize(lbNamXB.getPreferredSize());
		lbSoTrang.setPreferredSize(lbNamXB.getPreferredSize());
		lbTacGia.setPreferredSize(lbNhaXB.getPreferredSize());
		lbDonGia.setPreferredSize(lbNhaXB.getPreferredSize());

		// center
		JPanel pnCenter = new JPanel();
		pnCenter.setLayout(new BoxLayout(pnCenter, BoxLayout.Y_AXIS));
		pnCha.add(pnCenter, BorderLayout.CENTER);

		// button
		JPanel pnBut = new JPanel();
		btnThem = new JButton("Thêm");
		btnXoaRong = new JButton("Xóa rỗng");
		btnXoa = new JButton("Xóa");
		btnSua = new JButton("Sửa");
		btnLuu = new JButton("Lưu");
		JLabel lbTim = new JLabel("Tìm theo mã sách:");
		cboSearch = new JComboBox<String>();
		cboSearch.addItem("Chọn mã sách");

		cboSearch.setPreferredSize(new Dimension(120, 20));
		pnBut.add(btnThem);
		pnBut.add(btnXoaRong);
		pnBut.add(btnXoa);
		pnBut.add(btnSua);
		pnBut.add(btnLuu);
		pnBut.add(lbTim);
		pnBut.add(cboSearch);
		pnCenter.add(pnBut);

		// table
		JPanel pnTable = new JPanel();
		pnTable.setPreferredSize(new Dimension(800, 250));
		pnTable.setBorder(new TitledBorder(BorderFactory.createLineBorder(Color.CYAN), "Danh sách các cuốn sách"));
		String[] row = { "MaSach", "TuaSach", "TacGia", "NamXuatBan", "NhaXuatBan", "SoTrang", "DonGia", "ISBN" };

		modelTable = new DefaultTableModel(row, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};

		try {
			list = SaveFileByText.readFile("data/ListBook_SaveText.txt");
		} catch (Exception e) {
			e.printStackTrace();
		}

		loadDataToTable(list.getList());
		loadDataToComBoBox();

		tblSach = new JTable(modelTable);
		JScrollPane sc = new JScrollPane(tblSach);
		sc.setPreferredSize(new Dimension(770, 220));
		pnTable.add(sc);
		pnCenter.add(pnTable);
		add(pnCha);

		// event
		btnThem.addActionListener(this);
		btnXoaRong.addActionListener(this);
		btnXoa.addActionListener(this);
		btnSua.addActionListener(this);
		btnLuu.addActionListener(this);
		cboSearch.addActionListener(this);
		tblSach.addMouseListener(this);
	}

	public void loadDataToTable(List<Book> list) {
		modelTable.setRowCount(0);
		for (Book book : list) {
			String[] row = { book.getId(), book.getTitle(), book.getAuthor(), book.getLauchYear() + "",
					book.getPublishCompany(), book.getPageNumber() + "", book.getPrice() + "", book.getIsbn() };
			modelTable.addRow(row);
		}
	}

	public void loadDataToComBoBox() {
		int i = 0;
		cboSearch.removeAllItems();
		cboSearch.addItem("Chọn mã sách");
		while (i < list.getList().size()) {
			cboSearch.addItem(list.getList().get(i).getId());
			i++;
		}
	}

	public boolean kiemTraForm() {
		if (txtMa.getText().isEmpty() || txtTua.getText().isEmpty() || txtTacGia.getText().isEmpty()
				|| txtNamXB.getText().isEmpty() || txtNhaXB.getText().isEmpty() || txtSoTrang.getText().isEmpty()
				|| txtDonGia.getText().isEmpty() || txtISBN.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Bạn phải nhập đầy đủ thông tin!");
			return false;
		} else {
			String thongBao = "";
			// Mã sách
			String idBook = txtMa.getText();
			char firstChar = txtTua.getText().charAt(0);
			String patternStrMa = "^" + firstChar + "[0-9]{3}$";

			// Tựa sách & Tác giả
			String titleBook = txtTua.getText();
			String author = txtTacGia.getText();
			String patternStrTen = "^([A-Z][a-z]+\\'?\\s?)+";

			// ISBN
			// 16666-444-333-888
			String isbn = txtISBN.getText();
			String patternStrISBN = "^(\\d+-){3}\\d+(-\\d+)?$";

			if (!idBook.matches(patternStrMa))
				thongBao += "Mã sách phải có ký tự đầu là ký tự đầu của tựa sách, theo sau là 3 ký số!";
			if (!titleBook.matches(patternStrTen))
				thongBao += "\nTựa sách gồm nhiều từ ngăn cách bởi khoảng trắng. Không chứa ký số hoặc các ký tự đặc biệt khác, ngoại trừ ký tự '";
			if (!author.matches(patternStrTen))
				thongBao += "\nTác giả gồm nhiều từ ngăn cách bởi khoảng trắng. Không chứa ký số hoặc các ký tự đặc biệt khác, ngoại trừ ký tự '";
			if (!isbn.matches(patternStrISBN))
				thongBao += "\nISBN có mẫu dạng X-X-X-X (hoặc X-X-X-X-X). Trong đó, X gồm các ký số, ít nhất là 1 ký số!";
			if (thongBao.isEmpty())
				return true;
			else {
				JOptionPane.showMessageDialog(null, thongBao);
				return false;
			}
		}
	}

	public static void main(String[] args) {
		new GUI_Book("Quản lý sách").setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
		if (o.equals(btnThem)) {
			if (kiemTraForm()) {
				Book book = list.findById(txtMa.getText());
				// Kiểm tra sách không tồn tại thì mới được thêm
				if (book == null) {
					Book temp = createBook();
					list.add(temp);
					loadDataToTable(list.getList());
					loadDataToComBoBox();
					clearInput();
				} else
					JOptionPane.showMessageDialog(null, "Mã sách đã tồn tại!");
			}
		} else if (o.equals(btnXoaRong)) {
			clearInput();
		} else if (o.equals(btnXoa)) {
			int index = tblSach.getSelectedRow();
			if (index == -1) {
				JOptionPane.showMessageDialog(null, "Bạn phải chọn dòng cần xóa!");
			} else {
				int option = JOptionPane.showConfirmDialog(null, "Bạn thực sự muốn xóa?", "Xóa", JOptionPane.YES_OPTION);
				if (option == JOptionPane.YES_OPTION) {
					String idBook = modelTable.getValueAt(index, 0) + "";
					list.deleteById(idBook);
					
					loadDataToTable(list.getList());
					loadDataToComBoBox();
				}
			}
		} else if (o.equals(btnSua)) {
			if (kiemTraForm()) {
				int i = tblSach.getSelectedRow();
				if (i == -1)
				{
					JOptionPane.showMessageDialog(null, "Bạn phải chọn sách cần cập nhật!");
				} else {
					if(kiemTraForm()) {
						Book book = createBook();
						if(list.update(book)) {
							JOptionPane.showMessageDialog(null, "Sửa thành công!");
							loadDataToTable(list.getList());
							loadDataToComBoBox();
							clearInput();
						}
						else {
							JOptionPane.showMessageDialog(null, "Sửa thất bại!");
						}
					}
					
				}
			}
		} else if (o.equals(btnLuu)) {
			try {
				SaveFileByText.writeFile("data/ListBook_SaveText.txt", list);
				JOptionPane.showMessageDialog(null, "Ghi data thành công!");
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} else {
			String chon = (String) cboSearch.getSelectedItem();
			int i = 0;
			while (i < tblSach.getRowCount() && !tblSach.getValueAt(i, 0).toString().equals(chon))
				i++;
			if (i < tblSach.getRowCount()) {// tìm thấy
				tblSach.setRowSelectionAllowed(true);
				tblSach.setRowSelectionInterval(i, i);
			}
		}
	}

	private void clearInput() {
		txtMa.setText("");
		txtTua.setText("");
		txtTacGia.setText("");
		txtNamXB.setText("");
		txtNhaXB.setText("");
		txtSoTrang.setText("");
		txtDonGia.setText("");
		txtISBN.setText("");
		txtMa.requestFocus();
	}

	private Book createBook() {
		String id = txtMa.getText();
		String title = txtTua.getText();
		String author = txtTacGia.getText();
		int lauchYear = Integer.parseInt(txtNamXB.getText());
		String publishCompany = txtNhaXB.getText();
		int pageNumber = Integer.parseInt(txtSoTrang.getText());
		double price = Double.parseDouble(txtDonGia.getText());
		String isbn = txtISBN.getText();

		Book book = new Book(id, title, author, lauchYear, publishCompany, pageNumber, price, isbn);
		return book;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		int rowsel = tblSach.getSelectedRow();
		txtMa.setText(modelTable.getValueAt(rowsel, 0).toString());
		txtTua.setText(modelTable.getValueAt(rowsel, 1).toString());
		txtTacGia.setText(modelTable.getValueAt(rowsel, 2).toString());
		txtNamXB.setText(modelTable.getValueAt(rowsel, 3).toString());
		txtNhaXB.setText(modelTable.getValueAt(rowsel, 4).toString());
		txtSoTrang.setText(modelTable.getValueAt(rowsel, 5).toString());
		txtDonGia.setText(modelTable.getValueAt(rowsel, 6).toString());
		txtISBN.setText(modelTable.getValueAt(rowsel, 7).toString());

		cboSearch.setSelectedIndex(0);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		

	}

	@Override
	public void mouseExited(MouseEvent e) {
		

	}
}
