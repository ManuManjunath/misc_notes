void main() {
  print("Enums\n--------------------");
  
  // It only allows you to take departments from the enum
  final e1 = Employee("John Doe", Departments.technology);
  final e2 = Employee("Jane Doe", Departments.technology);
  final e3 = Employee("Jason Doe", Departments.hr);
  final e4 = Employee("Jacob Doe", Departments.finance);
  
  e1.wfhStatus();
  e2.wfhStatus();
  e3.wfhStatus();
  e4.wfhStatus();
  
}

class Employee {
  final String name;
  final Departments department;
  
  Employee(this.name, this.department);
  
  void wfhStatus() {
    print("Can $name wfh? ${department.wfh}");
  }
}

enum Departments {
  technology(true), 
  hr(true), 
  finance(false), 
  sales(false);
  
  final bool wfh;
  const Departments(this.wfh);
  
}
