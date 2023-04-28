public class Toy {
    /**
     *   Класс Toy предназначен для создания объекта "Игрушка", имеющего четыре основных свойства:
     *   - id        - идентификационный номер;
     *   - toyName   - наименование игрушки;
     *   - frequency - частота выпадения игрушки при проведении лотереи;
     *   - quantity  - количество игрушек на складе.
     */
    private final int id;
    private final String toyName;
    private int frequency;
    private int quantity;

    /**
     *   Конструктор предназначен инициализации переменных класса.
     */
    public Toy(int id, String name, int frequency, int quantity) {
        this.id = id;
        this.toyName = name;
        this.frequency = frequency;
        this.quantity = quantity;
    }

    /**
     *   toString - метод переопределяющий порядок вывода на печать данных об объекте.
     */
    @Override
    public String toString() {
        return String.format("    КОЛИЧЕТСВО НА СКЛАДЕ (ШТ.): %s;     ВЕРОЯТНОСТЬ ВЫИГРЫША: %s%%;     НАИМЕНОВАНИЕ: %s",
                quantity,  frequency, toyName);
    }

    /**
     *   СЕЛЕКТОРЫ:
     *   getId        - передает данные об идентификационном номере для чтения;
     *   getToyName   - передает данные о наименовании игрушки для чтения;
     *   getFrequency - передает данные о частоте выпадения игрушки для чтения.
     */
    public int getId() {
        return id;
    }
    public String getToyName() {
        return toyName;
    }
    public int getFrequency() {
        return frequency;
    }

    /**
     *   МОДИФИКАТОРЫ:
     *   setFrequency  - позволяет пользователю изменить данные о частоте выпадения игрушки;
     *   setQuantity   - позволяет пользователю изменить данные о количесве игрушек на складе.
     */
    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}