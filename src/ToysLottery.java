import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class ToysLottery {
    /**
     *   КЛАСС ToyLottery
     *   предназначен для формирования рондомной очереди игрушек при проведении лотереи с учетом частоты их выпадения.
     *   Для реализации класса используется утилита Queue, которая позволяет структурировать данные по принципу
     *   очереди в супермаркете - добавляет элемент в конец, удаляя другой с начала.
     */

    private final Queue<Toy> lotteryToysQueue;
    /**
     *   МЕТОДЫ КЛАССА:
     *   ToysLottery - предназначен для формирования очереди игрушек при проведении лотереи;
     *   size        - возвращает данные о количесве элементов в очереди;
     *   poll        - извлекает и удаляет первый элемент очереди или возвращает значение null, если эта она пуста.
     */

    public ToysLottery(ShopToys shopToys) {
        ArrayList<Toy> playableToys = new ArrayList<>();
        lotteryToysQueue = new LinkedList<>();
        for (Toy toy : shopToys.getToys()) {
            for (int i = 0; i < toy.getFrequency(); i++) {
                playableToys.add(toy);
            }
        }
        Collections.shuffle(playableToys);
        lotteryToysQueue.addAll(playableToys);
    }

    public int size() {
        return lotteryToysQueue.size();
    }

    public Toy poll() {
        return lotteryToysQueue.poll();
    }
}