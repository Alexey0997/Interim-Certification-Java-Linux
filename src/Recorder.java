import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Recorder {
    /**
     *   КЛАСС Recorder
     *   предназначен для фиксации и вывода данных о результатах лотереи в консоль и файл учета.
     *   Информация структурирована с помощью массива строк ArrayList<String>.
     */
    private final ArrayList<String> lotteryResult = new ArrayList<>();

    /**
     *   toString - метод переопределяющий порядок вывода на консоль данных о результах лотереи.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n\tРЕЗУЛЬТАТЫ ЛОТЕРЕИ:\n");
        for (int i = 0; i < lotteryResult.size(); i++) {
            sb.append("\t").append(i + 1).append(". ").append(lotteryResult.get(i)).append("\n");

        }
        return sb.toString();
    }

    /**
     *   МЕТОДЫ КЛАССА:
     *   lottery    - предназначен для формирования списка победителей лотереи;
     *   writeData  - записывает данные из списка победителей лотереи в файл.
     */

    public void lottery(int count, ToysLottery toysLottery) {
        int numberToys = toysLottery.size();
        for (int i = 1; i <= Math.min(count, numberToys); i++) {
            Toy currentToy = toysLottery.poll();
            lotteryResult.add(currentToy.getToyName());
        }
    }
    public void writeData(String filePath) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("РЕЗУЛЬТАТЫ ЛОТЕРЕИ:\n");
            for (int i = 0; i < lotteryResult.size(); i++) {
                writer.write((i + 1) + ". " + lotteryResult.get(i) + "\n");

            }
        }
    }
}