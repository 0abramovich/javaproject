package lab.lesson3;

public class Employee {
    private String FIO;
    private String job;
    private String email;
    private String phone;
    private double salary;
    private int age;

    public Employee(String FIO, String job, String email, String phone, double salary, int age) {
        this.FIO = FIO;
        this.job = job;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    // Метод для вывода информации об объекте
    public void printInfo() {
        System.out.println("Employee Information:");
        System.out.println("FIO: " + FIO);
        System.out.println("job: " + job);
        System.out.println("Email: " + email);
        System.out.println("Phone: " + phone);
        System.out.println("Salary: " + salary);
        System.out.println("Age: " + age);
    }

    public int getAge() {
        return age;
    }

    public static void main(String[] args) {
        Employee employee = new Employee("Абрамович Ольга Викторовна", "QA", "test@test.com", "+375445673423", 800, 23);
        employee.printInfo();
        System.out.println("--------------------------");
        Employee[] employeeArray = new Employee[5];
        employeeArray[0] = new Employee("Иванов Иван Петрович", "Engineer", "ivivan@mailbox.com", "+37544563789", 30000, 30);
        employeeArray[1] = new Employee("Петров Петр Иванович", "Manager", "petrov@mailbox.com", "+375445673420", 50000, 45);
        employeeArray[2] = new Employee("Сидоров Олег Викторович", "Director", "sidorov@mailbox.com", "+375445673428", 70000, 50);
        employeeArray[3] = new Employee("Федоров Дмитрий Петрович", "Developer", "fedorov@mailbox.com", "+375445673426", 60000, 25);
        employeeArray[4] = new Employee("Смирнов Динис Евгеньевич", "Analyst", "smirnov@mailbox.com", "+375445673425", 40000, 42);

        // Print information only about employees older than 40 years
        for (Employee employee1 : employeeArray) {
            if (employee1.getAge() > 40) {
                employee1.printInfo();
            }
        }

    }
}
