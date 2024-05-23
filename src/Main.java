public class Main {
    public static void main(String[] args) {
        Employee[] empArray = new Employee[5];
        empArray[0] = new Employee("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312", 30000, 30);
        empArray[1] = new Employee("Petrov Petr", "QA", "petr@mail.ru", "89618794566", 90000, 35);
        empArray[2] = new Employee("Sidorova Irina", "AQA", "iriii@mailbox.com", "89156668899", 80000, 29);
        empArray[3] = new Employee("Arova Polina", "Engineer", "arova@mail.ru", "89564389788", 45000, 32);
        empArray[4] = new Employee("Markov Mark", "Analyst", "markmark@gmail.com", "89167544889", 120000, 33);
        System.out.println("Задание №1\n");
        for (Employee employee : empArray)
            employee.info();
        System.out.println("\nЗадание №2\n");
        int size = 5;
        Park park = new Park(size);
        park.addAttraction("Лодочки", "10:00-17:00", 250);
        park.addAttraction("Цепочка", "10:00-16:00", 250);
        park.addAttraction("Колесо обозрения", "12:00-20:00", 350);
        park.addAttraction("Автодром", "10:00-17:00", 350);
        park.addAttraction("Самолет", "10:00-17:00", 250);
        park.addAttraction("Самолет2", "10:00-17:00", 250);
        park.getInformation();
    }
}