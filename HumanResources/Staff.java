package project3;

public abstract class Staff {
	private String id, name, startDay;
	private int age, offDay;
	private double salaryHS, salary;
	private Department department;

	public Staff() {

	}

	public Staff(String id, String name, String startDay, int age, int offDay, double salaryHS, double salary) {
		super();
		this.id = id;
		this.name = name;
		this.startDay = startDay;
		this.age = age;
		this.offDay = offDay;
		this.salaryHS = salaryHS;
		this.salary = salary;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStartDay() {
		return startDay;
	}

	public void setStartDay(String startDay) {
		this.startDay = startDay;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getOffDay() {
		return offDay;
	}

	public void setOffDay(int offDay) {
		this.offDay = offDay;
	}

	public double getSalaryHS() {
		return salaryHS;
	}

	public void setSalaryHS(double salaryHS) {
		this.salaryHS = salaryHS;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public abstract void displayInformation();
	
	public void input() {
		System.out.print("Nhập id nhân viên: ");
		id = HumanResources.sc.nextLine();
		System.out.print("Nhập tên nhân viên: ");
		name = HumanResources.sc.nextLine();
		System.out.print("Nhập tuổi nhân viên: ");
		age = Integer.parseInt(HumanResources.sc.nextLine());
		System.out.print("Nhập hệ số lương: ");
		salaryHS = Double.parseDouble(HumanResources.sc.nextLine());
		System.out.print("Nhập ngày vào làm: ");
		startDay = HumanResources.sc.nextLine();
		System.out.print("Nhập số ngày nghỉ phép: ");
		offDay = Integer.parseInt(HumanResources.sc.nextLine());
	}

}
