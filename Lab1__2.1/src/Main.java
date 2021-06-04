import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in,"cp1251");
        System.out.print("Введите количество рек => ");
        int kol = sc.nextInt();
        sc.nextLine(); // очистка буфера после ввода числа
        River[] rivers = new River[kol];  // получена ссылка на массив рек
        System.out.println("Введите информацию о каждой реке: ");
        for (int i = 0; i < rivers.length; i++) {
            rivers[i] = new River(); // получена ссылка на i-тый элемент
            // Присвоение значений полям
            System.out.print("Введите название " + (i + 1) + " реки => ");
            rivers[i].name = sc.nextLine();
            System.out.print("Введите её место расположения => ");
            rivers[i].location = sc.nextLine();
            System.out.print("Введите её длину => ");
            rivers[i].length = sc.nextInt();
            sc.nextLine(); //очистка буфера
        } // end for

        // Вывод информации о реках
        System.out.println("\nРеки:");
        System.out.format("%15s%25s%10s\n", "Название", "Место расположения", "Длина");
        for (River r : rivers) {
            System.out.format("%15s%25s%10d\n", r.name, r.location, r.length);
        }

        //Определяем самую короткую реку
        int p = 0;
        for (int i = 1; i < rivers.length; i++) {
            if (rivers[i].length < rivers[p].length) {
                p = i;
            }
        }
        System.out.println("\nСамая короткая река:");
        System.out.format("%15s%25s%10s\n", "Название", "Место расположения", "Длина");
        System.out.format("%15s%25s%10d\n", rivers[p].name, rivers[p].location, rivers[p].length);

        //Информация о реках, с длиной больше средней
        double s = 0;
        for (int i = 0; i < rivers.length; i++) {
            s += rivers[i].length;
        }
        s /= rivers.length;
        System.out.println("\nСредняя длина рек: " + s);
        System.out.println("\nРеки с длиной больше средней:");
        System.out.format("%15s%25s%10s\n", "Название", "Место расположения", "Длина");
        for (int i = 0; i < rivers.length; i++) {
            if (rivers[i].length > s) {
                System.out.format("%15s%25s%10d\n", rivers[i].name, rivers[i].location, rivers[i].length);
            }
        }

        //Упорядочивание списка рек по названиям в алфавитном порядке
        for (int i = 0; i < rivers.length - 1; i++) {
            for (int j = i + 1; j < rivers.length; j++) {
                if (rivers[i].name.compareTo(rivers[j].name) > 0) {
                    River r = rivers[i];
                    rivers[i] = rivers[j];
                    rivers[j] = r;
                }
            }
        }

        System.out.println("\nРеки упорядоченные по названиям:");
        System.out.format("%15s%25s%10s\n", "Название", "Место расположения", "Длина");
        for (River r : rivers) {
            System.out.format("%15s%25s%10d\n", r.name, r.location, r.length);
        }

        //Поиск по названию реки
        System.out.print("Введите название искомой реки => ");
        String name = sc.nextLine();
        p = -1;
        for (int i = 0; i < rivers.length; i++) {
            if (name.equalsIgnoreCase(rivers[i].name)) {
                p = i;
            }
        }
        if (p > -1) {
            System.out.println("\nТакая река есть в списке:");
            System.out.format("%15s%25s%10s\n", "Название", "Место расположения", "Длина");
            System.out.format("%15s%25s%10d\n", rivers[p].name, rivers[p].location, rivers[p].length);
        }
        else {
            System.out.println("Такой реки нет в списке");
        }

        //Поиск реки и изменение её длины
        System.out.print("Введите название искомой реки => ");
        name = sc.nextLine();
        p = -1;
        for (int i = 0; i < rivers.length; i++) {
            if (name.equalsIgnoreCase(rivers[i].name)) {
                p = i;
            }
        }
        if (p > -1) {
            System.out.println("\nТакая река есть в списке:");
            System.out.format("%15s%25s%10s\n", "Название", "Место расположения", "Длина");
            System.out.format("%15s%25s%10d\n", rivers[p].name, rivers[p].location, rivers[p].length);

            System.out.print("\nУточните длину реки => ");
            rivers[p].length = sc.nextInt();
            sc.nextLine(); //очистка буфера

            System.out.println("\nРека после изменения данных:");
            System.out.format("%15s%25s%10s\n", "Название", "Место расположения", "Длина");
            System.out.format("%15s%25s%10d\n", rivers[p].name, rivers[p].location, rivers[p].length);
        }
        else {
            System.out.println("Такой реки нет в списке");
        }
    }
}
