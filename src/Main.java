import java.io.IOException;

/**
 *   КЛАСС MAIN
 *   предназначен для инициализации классов, запуска и управления программой.
 */
public class Main {

    /**
     *   ЗАПУСК МЕТОДОВ:
     *   shopToys.fileReader      - составления общего списка игрушек на основе данных из файла;
     *   shopToys.addToy          - добавление игрушек;
     *   shopToys.changeData      - изменение данных о товаре;
     *   shopToys.changeFrequency - изменение частоты выпадения игрушки по ее индексу;
     *   shopToys.changeQuantity  - изменение количества товара;
     *   shopToys.delToy          - удаление игрушки из базы данных;
     *   winningToys.lottery      - подведение итогов 10 розыгрышей подряд;
     *   winningToys.writeData    - запись данных в файл winningToys
     */

    public static void main(String[] args) throws IOException {

        // МЕТОДЫ ФОРМИРОВАНИЯ БАЗЫ ДАННЫХ
        ShopToys shopToys = new ShopToys();
        shopToys.fileReader("prizes");
        shopToys.addToy(4, "Чебурашка", 6, 120);
        shopToys.addToy(5, "Баз Лайтер", 5, 110);
        shopToys.addToy(6, "Крокодил Гена", 5, 110);

        // МЕТОДЫ ИЗМЕНЕНИЯ ПОЗИЦИЙ В БАЗЕ ДАННЫХ
        shopToys.changeData(5, "Ежик", 4, 110);
        shopToys.changeFrequency(5,7);
        shopToys.changeQuantity(5, 109);
        shopToys.delToy(5);
        System.out.println(shopToys);

        // МЕТОДЫ ПРОВЕДЕНИЯ ЛОТЕРЕИ ДАННЫХ В ФАЙЛЫ
        ToysLottery toysLottery = new ToysLottery(shopToys);
        Recorder winningToys = new Recorder();
        winningToys.lottery(10, toysLottery);

        // МЕТОДЫ ЗАПИСИ РЕЗУЛЬТАТОВ ЛОТЕРЕИ В ФАЙЛ
        winningToys.writeData("winningToys");
        System.out.println(winningToys);
    }
}