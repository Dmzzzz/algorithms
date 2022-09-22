package recursion.fibonachi;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ReadFiles {

    public static void main(String[] args) {
        /**
         *  Есть 2 метода - которые на вход получают путь Корневой директории,
         *  рекурсивно проходят по всем вложенным директориям и сохраняют в List названия файлов
         *
         *
         *  1ый метод не работает - в нем Локальный List<String> result = new ArrayList<>();
         *   и он не возвращает то, что нужно - как бы перетирая на каждом вызове Рекурсии
         *
         *  2ой метод рабочий, при каждом вызове мы передается в параметры метода Результирующий List
         *
         *  Задался вопросом, почему так?  почему Рекурсия не работает в 1ом методе?
         *  Ведь в Рекурсии - например Разворота строки reverse(...) - result накапливается
         *
         *  Стал предполагать, что каждый вызов рекурсии - frame, имеет как бы свое Локальное состояние
         *  и оно  как бы не возврщается(как в случае разворота строки),
         *  во 2м методе мы как бы передаем его в праметры и оно накапливается при каждом вызове
         *
         */


        List<String> allFiles = readAllFiles("D:\\1");

        List<String> allFiles2 = readAllFiles2("D:\\1", new ArrayList<>());

        System.out.println(allFiles);
        System.out.println(allFiles2);

        System.out.println(reverse("12345"));
    }

    private static String reverse(String str) {
        if (str == null || str.isEmpty()) {
            return "";
        }

        char ch = str.charAt(str.length()-1);
        return ch + reverse(str.substring(0, str.length()-1));
    }


    private static List<String> readAllFiles(String strPath) {
        File file = Paths.get(strPath).toFile();
        List<String> result = new ArrayList<>();

        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File f : files) {
                if (!f.isDirectory()) {
                    result.add(f.getName());
                } else {
                    readAllFiles(f.getAbsolutePath());
                }
            }
        }
        return result;
    }

    private static List<String> readAllFiles2(String strPath, List<String> listOfFiles) {
        File file = Paths.get(strPath).toFile();

        if (file.isDirectory()) {
            File[] files = file.listFiles();
            for (File f : files) {
                if (!f.isDirectory()) {
                    listOfFiles.add(f.getName());
                } else {
                    readAllFiles2(f.getAbsolutePath(), listOfFiles);
                }
            }
        }
        return listOfFiles;
    }
}