import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ShopToys {
    /**
     *   КЛАСС ShopToys
     *   предназначен для организации контроля и учета товаров в магазине игрушек.
     *   Данные о товарах добавляются в изменяемый массив данных - ArrayList.
     */
    private final ArrayList<Toy> toys = new ArrayList<>();

    /**
     *   СЕЛЕКТОР:
     *   getToys - передает данные о массиве игрушек для чтения.
     */
    public ArrayList<Toy> getToys() {
        return toys;
    }

    /**
     *   toString - метод переопределяющий порядок вывода на печать данных об объектах класса.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\n\tСПИСОК ИГРУШЕК, ИМЕЮЩИХСЯ В МАГАЗИНЕ:\n");
        for (Toy toy : this.toys) {
            sb.append("\t№ ID: ").append(toy.getId()).append(". ").append(toy).append(".\n");
        }
        return sb.toString();
    }

    /**
     *   МЕТОДЫ КЛАССА:
     *   addToy - добавление игрушки в базу данных;
     *   delToy - удаление игрушки из базы данных;
     *   changeData - изменение данных о товаре;
     *   changeFrequency - изменение частоты выпадения игрушки;
     *   changeQuantity - изменение количесва игрушек на складе;
     *   fileReader - метод чтения данных из файла, содержащего сведения о товарах.
     *   */
    public void addToy(int id, String name, int frequency, int quantity) {
        Toy toy = new Toy(id, name, frequency, quantity);
        toys.add(toy);
    }

    public void delToy(Integer index) {
        try {
            if (index > 0 && index <= this.toys.size())
                this.toys.remove(index-1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void changeData(Integer id, String toyName, Integer quantity, Integer frequency){
        try {
            if (id > 0 && id <= this.toys.size())
                this.toys.remove(id-1);
            this.toys.add(new Toy(id, toyName, quantity, frequency));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void changeFrequency(int id, int frequency) {
        for (Toy toy: toys) {
            if (toy.getId() == id){
                toy.setFrequency(frequency);
            }
        }
    }

    public void changeQuantity(int id, int quantity) {
        for (Toy toy: toys) {
            if (toy.getId() == id){
                toy.setQuantity(quantity -1);
            }
        }
    }

    public void fileReader(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] toyData = line.split(" ");
                int id = Integer.parseInt(toyData[1]);
                String name = toyData[6];
                int frequency = Integer.parseInt(toyData[4]);
                int quantity = Integer.parseInt(toyData[8]);
                toys.add(new Toy(id, name, frequency, quantity));
            }
        } catch (IOException e) {
            System.err.format("Error reading file: %s%n", e);
        }
    }
}