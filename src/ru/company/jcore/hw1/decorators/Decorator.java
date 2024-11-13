package ru.company.jcore.hw1.decorators;

public class Decorator {
    
    public static void decorate(double index) {
        System.out.println("Индекс массы Вашего тела равен " + Math.round(index * 100.0) / 100.0);
        System.out.println("Пояснения: ");
        
            if(index < 16) {
                System.out.println("Выраженный дефицит массы тела");
                System.out.println("Необходима срочная консультация специалиста!");
            }
            else if ((index >= 16) && (index < 18.5)) {
                System.out.println("Недостаточная (дефицит) масса тела");
                System.out.println("Необходима консультация специалиста!");
            }
            else if ((index >= 18.5) && (index < 24.5)) {
                System.out.println("Норма.");
            }
            else if ((index >= 24.5) && (index < 30)) {
                System.out.println("Избыточная масса тела (предожирение)");
                System.out.println("Необходима консультация специалиста.");
            }
            else if ((index >= 30) && (index < 35)) {
                System.out.println("Ожирение первой степени");
                System.out.println("Необходима консультация специалиста.");
            }
            else if ((index >= 35) && (index < 40)) {
                System.out.println("Ожирение второй степени");
                System.out.println("Необходима консультация специалиста!");
            }
            else if (index >= 40) {
                System.out.println("Ожирение третьей степени (морбидное)");
                System.out.println("Необходима срочная консультация специалиста!");
            }
    }   
}
