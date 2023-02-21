package project3;

public class Manager extends Staff implements ICalculator {
	private String title;

	public Manager() {

	}

	public Manager(String title) {
		this.title = title;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public void input() {
		super.input();
		System.out.println("Thêm chức danh:");
		System.out.println("1-Business Leader");
		System.out.println("2-Project Leader");
		System.out.println("3-Technical Leader");
		System.out.print("Thêm: ");
		int number;
		do {
			number = Integer.parseInt(HumanResources.sc.nextLine());
			if (number == 1) {
				title = "Business Leader";
				break;
			} else if (number == 2) {
				title = "Project Leader";
				break;
			} else if (number == 3) {
				title = "Technical Leader";
				break;
			}
		} while (number != 1 && number != 2 && number != 3);
		System.out.println("Chức danh: " + title);
		setSalary(salaryAll());
	}

	@Override
	public void displayInformation() {
		System.out.println("ID quản lý: " + super.getId() + " Tên: " + super.getName() + " Tuổi: " + super.getAge()
		+ " Hệ số lương: " + super.getSalaryHS() + " Ngày vào làm: " + super.getStartDay() + " Ngày nghỉ: "
		+ super.getOffDay() + " Chức danh: " + getTitle());
	}

	@Override
	public double salaryAll() {
		double salary = 0;
		if (title.equals("Business Leader")) {
			salary = getSalaryHS() * managerSalary + businessLeader;
		} else if (title.equals("Project Leader")) {
			salary = getSalaryHS() * managerSalary + projectLeader;
		} else if (title.equals("Technical Leader")) {
			salary = getSalaryHS() * managerSalary + technicalLeader;
		}
		return salary;
	}

}
