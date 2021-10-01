package logic.constants;

public enum ComputerNotebookSectioons {
  NOTEBOOKS("Ноутбуки"),
  COMPUTERS("Компьютеры"),
  MONITORS("Мониторы"),
  GAMING("Gaming"),
  COMPUTER_PARTS("Компьютерные комплектующие"),
  NETWORK_HARDWARE("Сетевое оборудование"),
  TABLETS("Планшеты"),
  ELECTRONICS_ACCESSORIES("Аксессуары для электроники"),
  MICROPHONES("Микрофоны"),
  OFFICE_EQUIPMENT("Оргтехника"),
  SOFTWARE("Программное обеспечение"),
  SERVER_EQUIPMENT("Серверное оборудование"),
  HEADPHONES_AND_ACCESSORIES("Наушники и аксессуары"),
  CABLES_AND_ADAPTERS("Кабели и переходники"),
  GRAPHIC_TABLETS("Графические планшеты"),
  ACUSTIC_SYSTEMS("Акустические системы"),
  KEYBOARDS_AND_MICE("Клавиатуры и мыши"),
  INTERACTIVE_EQUIPMENT("Интерактивное оборудование");

    private final String name;

    ComputerNotebookSectioons(String name){
        this.name = name;
    }

    public String get(){
        return name;
    }
    }
