package project3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class HumanResources {
	static List<Staff> list = new ArrayList<>();
	static Scanner sc = new Scanner(System.in);
	static Department department = new Department();

	public static void main(String[] args) {
		int number;
		do {
			menu();
			System.out.print("Nhập chức năng: ");
			number = Integer.parseInt(sc.nextLine());
			System.out.println();
			if (number == 1) {
				displayNV();
			} else if (number == 2) {
				displayDepartment();
			} else if (number == 3) {
				displayEM();
				displayPart();
			} else if (number == 4) {
				inputNV();
			} else if (number == 5) {
				search();
			} else if (number == 6) {
				displaySalary();
			} else if (number == 7) {
				displaySalaryUp();
			} else if (number == 8) {
				displaySalaryDown();
			} else if (number == 9) {
				System.out.println("Kết thúc chương trình!");
			}
		} while (number != 9);
	}

//Menu chức năng
	static void menu() {
		System.out.println("MENU ---------------------------- ");
		System.out.println("Vui lòng chọn chức năng: ");
		System.out.println(
				"1. Hiển thị danh sách nhân viên hiện có trong công ty.\n" + "2. Hiển thị các bộ phận trong công ty.\n"
						+ "3. Hiển thị các nhân viên theo từng bộ phận.\n" + "4. Thêm nhân viên mới vào công ty.\n"
						+ "5. Tìm kiếm thông tin nhân viên theo tên hoặc mã nhân viên.\n"
						+ "6. Hiển thị bảng lương của nhân viên toàn công ty.\n"
						+ "7. Hiển thị bảng lương của nhân viên theo thứ tự tăng dần.\n"
						+ "8. Hiển thị bảng lương của nhân viên theo thứ tự giảm dần.\n" + "9. Kết thúc chương trình");
		System.out.print("Chọn: ");
	}

//Đặt id và tên bộ phận nhân viên
	public static void departmentEmployee() {
		department.departmentID = "EPY";
		department.departmentName = "Employee";
	}

//Đặt id và tên bộ phận quản lý
	public static void departmentManager() {
		department.departmentID = "MNG";
		department.departmentName = "Manager";
	}

//Nhập số lượng nhân viên cần thêm
	private static void inputNV() {
		System.out.print("Nhập số lượng nhân viên cần thêm: ");
		int n = Integer.parseInt(sc.nextLine());
		System.out.println();
		for (int i = 0; i < n; i++) {
			System.out.println("Nhập thông tin cho nhân viên thứ " + (i + 1) + ":");
			Staff staff = createStaff();
			list.add(staff);
		}

	}

//Nhập thông tin nhân viên
	private static Staff createStaff() {
		Staff staff;
		System.out.println("Chọn bộ phận cần thêm:");
		System.out.println("1. Bộ phận Employee");
		System.out.println("2. Bộ phận Manager");
		System.out.print("Chọn: ");
		int number;

		do {
			number = Integer.parseInt(sc.nextLine());
			System.out.println();
			if (number == 1) {
				staff = new Employee();
				System.out.println("Nhập thông tin Employee:");
				break;
			} else if (number == 2) {
				staff = new Manager();
				System.out.println("Nhập thông tin Manager:");
				break;
			} else {
				System.out.println("Yêu cầu nhập lại");
			}
		} while (true);

		staff.input();
		return staff;
	}

//Hiển thị danh sách nhân viên toàn công ty
	private static void displayNV() {
		for (Staff staff : list) {
			staff.displayInformation();
		}
	}

//Hiển thị bộ phận công ty
	public static void displayDepartment() {
		System.out.println("Các bộ phận trong công ty: ");
		departmentEmployee();
		System.out.println(department.toString());
		departmentManager();
		System.out.println(department.toString());
	}

//Hiển thị nhân viên từng bộ phận
	public static void displayEM() {
		System.out.println("Nhân viên:");
		for (Staff staff : list) {
			if (staff instanceof Employee) {
				staff.displayInformation();
			}
		}
		System.out.println("Quản lý:");
		for (Staff staff : list) {
			if (staff instanceof Manager) {
				staff.displayInformation();
			}
		}
	}

//Hiển thị số lượng nhân viên từng bộ phận
	private static void displayPart() {
		System.out.println("Số lượng nhân viên theo từng bộ phận: ");
		int count = 0;
		for (Staff staff : list) {
			if (staff instanceof Employee) {
				count++;
			}
		}
		departmentEmployee();
		department.departmentNumbers = count;
		System.out.println(department.toString());

		count = 0;
		for (Staff staff : list) {
			if (staff instanceof Manager) {
				count++;
			}
		}
		departmentManager();
		department.departmentNumbers = count;
		System.out.println(department.toString());
	}

//Tìm kiểm thông tin nhân viên dựa vào id và tên
	public static void search() {

		System.out.print("Nhập tên hoặc mã nhân viên cần tìm kiếm: ");
		String key = sc.nextLine();
		int count = 0;
		for (Staff staff : list) {
			if (staff.getName().contains(key)) {
				count++;
				staff.displayInformation();
			} else if (staff.getId().contains(key)) {
				count++;
				staff.displayInformation();
			}
		}
		if (count == 0) {
			System.out.println("Nhân viên đã nhập không có trong danh sách!");
		} else {
			System.out.println("Tìm thấy " + count + " nhân viên!");
		}
	}

//Hiển thị lương nhân viên
	private static void displaySalary() {
		for (Staff staff : list) {
			System.out.println("Họ tên: " + staff.getName() + " Mã nhân viên: " + staff.getId() + " Lương: "
					+ Math.round(staff.getSalary()) + " vnd");
		}
	}

//Hiển thị lương nhân viên tăng dần
	private static void displaySalaryUp() {
		System.out.println("Hiển thị bảng lương nhân viên theo thứ tự tăng dần:");
		Collections.sort(list, new Comparator<Staff>() {

			@Override
			public int compare(Staff o1, Staff o2) {
				return (int) (o1.getSalary() - o2.getSalary());
			}
		});
		displaySalary();
	}

//Hiển thị lương nhân viên giảm dần
	private static void displaySalaryDown() {
		System.out.println("Hiển thị bảng lương nhân viên theo thứ tự giảm dần:");
		Collections.sort(list, new Comparator<Staff>() {

			@Override
			public int compare(Staff o1, Staff o2) {
				return (int) (o2.getSalary() - o1.getSalary());
			}
		});
		displaySalary();
	}
}
