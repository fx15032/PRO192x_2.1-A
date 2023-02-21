package project3;

public class Employee extends Staff implements ICalculator {
	private double overTime;

	public Employee() {
		
	}

	public Employee(double overTime) {
		this.overTime = overTime;
	}

	public double getOverTime() {
		return overTime;
	}

	public void setOverTime(double overTime) {
		this.overTime = overTime;
	}

	@Override
	public void input() {
		super.input();
		System.out.print("Nhập giờ làm thêm: ");
		overTime = Double.parseDouble(HumanResources.sc.nextLine());
		setSalary(salaryAll());
	}

	@Override
	public void displayInformation() {
		System.out.println("ID nhân viên: " + super.getId() + " Tên: " + super.getName() + " Tuổi: " + super.getAge()
				+ " Hệ số lương: " + super.getSalaryHS() + " Ngày vào làm: " + super.getStartDay() + " Ngày nghỉ: "
				+ super.getOffDay() + " Giờ làm thêm: " + getOverTime());

	}

	@Override
	public double salaryAll() {
		return getSalaryHS() * empSalary + overTime * overSalary;
	}
}

