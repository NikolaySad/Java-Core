# Java Core (семинары)

![picture for project](https://raw.githubusercontent.com/Terekhov-A-S/Java_core_seminar5/main/src/main/resources/Java_core.jpg)

[к решению 1 ЗАДАЧИ](https://github.com/Terekhov-A-S/Java_core_seminar5/tree/main#задача-1)  ||  [к решению 2 ЗАДАЧИ](https://github.com/Terekhov-A-S/Java_core_seminar5/tree/main#решение-1)  ||  [перейти в папку Java](https://github.com/Terekhov-A-S/Java_core_seminar5/tree/main/src/main/java)


### Задача 1.

Написать функцию, создающую резервную копию всех файлов в директории(без поддиректорий) во вновь созданную папку ./backup

#### Решение

Для работы с файлами и директориями будем использовать пакеты java.nio.file и java.io. Создаем класс BackupUtility с необходимыми методами.
Здесь "./source" и "./backup" это путь папки, откуда будем делать копию и путь папки куда будем копировать.

```java
import java.io.IOException;
import java.nio.file.*;

public class BackupUtility {

    public static void main(String[] args) {
        try {
            createBackup("./source", "./backup");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void createBackup(String sourceDir, String backupDir) throws IOException {
        Path sourcePath = Paths.get(sourceDir);
        Path backupPath = Paths.get(backupDir);

        if (!Files.exists(backupPath)) {
            Files.createDirectories(backupPath);
        }

        try (DirectoryStream<Path> stream = Files.newDirectoryStream(sourcePath)) {
            for (Path entry : stream) {
                if (Files.isRegularFile(entry)) {
                    copyFile(entry, backupPath.resolve(entry.getFileName()));
                }
            }
        }
    }

    private static void copyFile(Path source, Path destination) throws IOException {
        Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
    }
}

```

В нашем конкретном случае, для проверки работоспособности, будем использовать вместо "./source" путь "."
В результате выполнения нашего кода в корне будет создана директория с именем ["backup"](https://github.com/Terekhov-A-S/Java_core_seminar5/tree/main/backup)

![Backup_folder](https://raw.githubusercontent.com/Terekhov-A-S/Java_core_seminar5/main/src/main/resources/Backup.png)

---


### Задача 2.

Предположить, что числа в исходном массиве из 9 элементов имеют диапазон [0, 3], и представляют собой, например, 
состояния ячеек поля для игры в крестикинолики, где 0 – это пустое поле, 1 – это поле с крестиком, 2 – это поле с ноликом, 3 – резервное значение. 
Такое предположение позволит хранить в одном числе типа int всё поле 3х3. Записать в файл 9 значений так, чтобы они заняли три байта.

#### Решение

Для хранения 9 значений в трех байтах, мы можем использовать тип данных byte. 
Каждый элемент массива будет представлять собой один байт. Значения [0, 3] легко умещаются в диапазон значений типа byte.
Создаем класс WriteToFile, в котором инициализируем массив с необходимыми значениями.

```java
import java.io.*;

public class WriteToFile {

    public static void main(String[] args) {
        byte[] gameBoard = {1, 2, 0, 3, 2, 1, 0, 3, 2};

        try (DataOutputStream outputStream = new DataOutputStream(new FileOutputStream("tic-tac-toe_board.dat"))) {
            for (byte value : gameBoard) {
                outputStream.writeByte(value);
            }
            System.out.println("Данные успешно записаны в файл.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

```
Этот код создает массив gameBoard и записывает его значения в файл "tic-tac-toe_board.dat" с использованием DataOutputStream. 
Обращаем внимание, что значения [0, 3] на самом деле представляют собой байты, и мы сами можем декодировать их при необходимости.

![Size_for_tic-tac-toe_board](https://raw.githubusercontent.com/Terekhov-A-S/Java_core_seminar5/main/src/main/resources/size_for_tic-tac-toe_board.png)

Теперь каждое значение записывается как байт, и всего 9 значений займут 9 байт, что соответствует требованиям задачи. 


Так же создадим класс с методом, для корректного считывания байтов из файла с использованием DataInputStream:

```java
import java.io.*;

public class ReadFromFile {

    public static void main(String[] args) {
        try {
            byte[] gameBoard = readGameBoard("tic-tac-toe_board.dat");
            printGameBoard(gameBoard);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static byte[] readGameBoard(String filename) throws IOException {
        try (DataInputStream inputStream = new DataInputStream(new FileInputStream(filename))) {
            byte[] gameBoard = new byte[9];
            for (int i = 0; i < 9; i++) {
                gameBoard[i] = inputStream.readByte();
            }
            return gameBoard;
        }
    }

    public static void printGameBoard(byte[] gameBoard) {
        System.out.println("Считанные значения из файла:");
        for (byte value : gameBoard) {
            System.out.println(value);
        }
    }
}

```

Этот код использует DataInputStream для считывания байтов из файла "tic-tac-toe_board.dat" и затем выводит считанные значения на экран. 
Обращаем внимание, что при чтении байтов необходимо обработать исключение IOException.

Использование формата .dat в данном случае связано с тем, что мы сохраняем бинарные данные (байты) в файле. 
Расширение файла не является строгим требованием, и можно использовать другие расширения в зависимости от конкретных потребностей проекта. 
Однако расширение .dat часто ассоциируется с файлами данных в бинарном формате.

В данном контексте, .dat может быть использован как сокращение от "data" (данные) и служить для обозначения файлов, содержащих бинарные данные. Это удобно для самопонятности и часто используется в программировании для подобных файлов.
