package REG_2241019507;
import java.util.*;



class Employee 
{
    private String name;
    private int empId;
    private double salary;
    private Date hireDate;
    private String jobPosition;
    private String contactNumber;
    private Address address;

    public Employee(String name, int empId, double salary, Date hireDate, String jobPosition,String contactNumber, Address address) 
    {
        this.name = name;
        this.empId = empId;
        this.salary = salary;
        this.hireDate = hireDate;
        this.jobPosition = jobPosition;
        this.contactNumber = contactNumber;
        this.address = address;
    }

    public String getName() 
    {
        return name;
    }

    public int getEmpId() 
    {
        return empId;
    }

    public double getSalary() 
    {
        return salary;
    }

    public Date getHireDate() 
    {
        return hireDate;
    }

    public String getJobPosition() 
    {
        return jobPosition;
    }

    public String getContactNumber() 
    {
        return contactNumber;
    }

    public Address getAddress() 
    {
        return address;
    }
}



 class Date 
{
    private int day;
    private int month;
    private int year;

    public Date(int day, int month, int year) 
    {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDay() 
    {
        return day;
    }

    public int getMonth() 
    {
        return month;
    }

    public int getYear() 
    {
        return year;
    }

    public void setDay(int day) 
    {
        this.day = day;
    }

    public void setMonth(int month) 
    {
        this.month = month;
    }

    public void setYear(int year) 
    {
        this.year = year;
    }

    public boolean isBetween(Date startDate, Date endDate) 
    {
        Calendar start = Calendar.getInstance();
        start.set(startDate.year, startDate.month - 1, startDate.day);

        Calendar end = Calendar.getInstance();
        end.set(endDate.year, endDate.month - 1, endDate.day);

        Calendar current = Calendar.getInstance();
        current.set(this.year, this.month - 1, this.day);

        return current.compareTo(start) >= 0 && current.compareTo(end) <= 0;
    }

    public String toString() 
    {
        return String.format("%02d-%02d-%04d", day, month, year);
    }
}



class Address 
{
    private String street;
    private String city;
    private String state;
    private String country;
    private String zipCode;

    public Address(String street, String city, String state, String country, String zipCode) 
    {
        this.street = street;
        this.city = city;
        this.state = state;
        this.country = country;
        this.zipCode = zipCode;
    }

    public String getStreet() 
    {
        return street;
    }

    public String getCity() 
    {
        return city;
    }

    public String getState()
    {
        return state;
    }

    public String getCountry()
    {
        return country;
    }

    public String getZipCode()
    {
        return zipCode;
    }
}



public class Test 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        Employee[] employees = new Employee[500];
        // create employee objects and store in the array
        for (int i = 0; i < 500; i++) {
            System.out.println("Enter details of employee #" + (i+1));
            System.out.print("Name: ");
            String name = sc.next();
            System.out.print("Employee ID: ");
            int empId = sc.nextInt();
            System.out.print("Salary: ");
            double salary = sc.nextDouble();
            System.out.println("Enter hire date (dd mm yyyy): ");
            int day = sc.nextInt();
            int month = sc.nextInt();
            int year = sc.nextInt();
            Date hireDate = new Date(day, month, year);
            System.out.print("Job position: ");
            String jobPosition = sc.next();
            System.out.print("Contact number: ");
            String contactNumber = sc.next();
            System.out.println("Enter address:");
            System.out.print("Street: ");
            String street = sc.next();
            System.out.print("City: ");
            String city = sc.next();
            System.out.print("State: ");
            String state = sc.next();
            System.out.print("Country: ");
            String country = sc.next();
            System.out.print("Zip code: ");
            String zipCode = sc.next();
            Address address = new Address(street, city, state, country, zipCode);
            Employee employee = new Employee(name, empId, salary, hireDate, jobPosition, contactNumber, address);
            employees[i] = employee;
        }
        arrangeEmployeeBySalary(employees);
        getEmployeesByJobPosition(employees, "manager");
        foreignEmployeeCount(employees);
        getEmployeesBySalary(employees, 150000, 300000);
        Date startDate = new Date(1, 4, 2022);
        Date endDate = new Date(31, 3, 2023);
        getEmployeesByHireDate(employees, startDate, endDate);
    }

    public static void arrangeEmployeeBySalary(Employee[] employees) 
    {
        // sort the array in descending order by salary
        Arrays.sort(employees, (e1, e2) -> Double.compare(e2.getSalary(), e1.getSalary()));
        // display the details of the employees
        for (Employee employee : employees) 
        {
            System.out.println(employee.getName() + " " + employee.getSalary());
        }
    }

    public static void getEmployeesByJobPosition(Employee[] employees, String jobPosition) 
    {
        // display the details of the employees whose jobPosition is manager
        for (Employee employee : employees) 
        {
            if (employee.getJobPosition().equalsIgnoreCase(jobPosition)) 
            {
                System.out.println(employee.getName() + " " + employee.getJobPosition());
            }
        }
    }

    public static void getEmployeesByHireDate(Employee[] employees, Date startDate, Date endDate) 
    {
        System.out.println("Employees hired between " + startDate + " and " + endDate + ":");
        for (Employee employee : employees) {
            if (employee.getHireDate().isBetween(startDate, endDate)) {
                System.out.println(employee.getName() + ", " + employee.getJobPosition() + ", " + employee.getHireDate());
            }
        }
    }

    public static int foreignEmployeeCount(Employee[] employees) 
    {
        int count = 0;
        for (Employee employee : employees)
        {
            String countryCode = employee.getContactNumber().substring(0, 3);
            if (!countryCode.equals("IND")) 
            {
                count++;
            }
        }
        return count;
    }

    public static void getEmployeesBySalary(Employee[] employees, double s1, double s2) 
    {
        for (Employee employee : employees) 
        {
            double salary = employee.getSalary();
            if (salary >= s1 && salary <= s2) 
            {
                System.out.println(employee);
            }
        }
    }
    
}