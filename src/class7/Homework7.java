package class7;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Homework7 {
  public static void main(String[] args) {
    new Q7_1().systemOn();
  }
}


/**
 * <pre>
 *  
 *  1.點餐系統
 *  2.訂單查詢
 *  3.飲料維護   (進階)
 *  4.飲料統計   (進階)
 *  5.點餐修改   (進階)
 *  
 * </pre>
 */
class Q7_1 {
  MenuGenerator menuGenerator = new MenuGenerator();
  Map<String, CustomerOrder> allOrders = new HashMap<String, CustomerOrder>();

  public void systemOn() {
    init();
  }

  private void init() {
    boolean stopSystem = false;
    Scanner sc = new Scanner(System.in);
    while (!stopSystem) {
      int selectFunction = inputDrinkNumber(sc, "1.點餐系統\n2.菜單系統\n3.訂單查詢\n4.訂單統計\n請選擇欲執行的系統: ");
      switch(selectFunction) {
        case 0:
          stopSystem = true;
          break;
        case 1:
          menuSystem();
          stopSystem = orderSystem(sc);
          break;
        case 2:
          stopSystem = menuSystem();
          break;
        case 3:
          stopSystem = modifyOrderSystem(sc);
          break;
        case 4:
          stopSystem = summary();
          break;
        default:
          System.out.println("無此功能，請重新選擇");
          stopSystem = false;
      }
    }
    sc.close();
    System.out.println("系統結束。");
  }
  
  public boolean menuSystem() {
    menuGenerator.addMenu(1, "紅茶", "好喝的紅茶", "魚池紅茶葉, 水", 110, 30);
    menuGenerator.addMenu(2, "綠茶", "好喝的綠茶", "不知道哪裡來的綠茶葉, 水", 105, 30);
    menuGenerator.addMenu(3, "奶茶", "好喝的奶茶", "魚池紅茶葉, 牛奶, 水", 185, 40);
    menuGenerator.printMenu();
    return false;
  }
  
  public boolean orderSystem(Scanner sc) {
    boolean stopOrder = false;
    while (!stopOrder) {
      input(sc);
      stopOrder = !inputContinue(sc, "繼續點餐？(Y/N): ");
    }
    System.out.println("點餐結束。");
    return false;
  }
  
  public boolean modifyOrderSystem(Scanner sc) {
    System.out.println(allOrders.keySet());
    boolean stopOrder = false;
    while (!stopOrder) {
      String orderKey = inputDrinkString(sc, "請輸入「訂單日期_編號」：");
      CustomerOrder thisOrder = allOrders.get(orderKey);
      if(!thisOrder.equals(null)) {
        printOrder(thisOrder);
      }
      stopOrder = !inputContinue(sc, "繼續查詢？(Y/N): ");
    }
    System.out.println("查詢結束。");
    return false;
  }
  
  public boolean summary() {
    int sum = 0;
    int qty = 0;
    Map<String, Integer> drinkSum = new HashMap<String, Integer>();
    for(String key : allOrders.keySet()) {
      List<DrinkDetail> thisOrderDrink = allOrders.get(key).getDrinkList();
      sum += allOrders.get(key).getPrice();
      qty += thisOrderDrink.size();
      for(DrinkDetail drink : thisOrderDrink) {
        String thisName = drink.getName();
        int OriVal = drinkSum.get(thisName) != null ? drinkSum.get(thisName) : 0;
        drinkSum.put(drink.getName(), OriVal + 1);
      }
    }
    System.out.println("訂單總金額： " + sum);
    System.out.println("訂單總飲料杯數： " + qty);
    for(String key : drinkSum.keySet()) {
      System.out.println(key + ": " + drinkSum.get(key) + "杯");
    }
    return false;
  }

  public void input(Scanner sc) {
    LocalDate today = LocalDate.now();
    DrinkDetail selectedDrink = null;
    int selectedNumber = 0;
    List<DrinkDetail> orderList = new ArrayList<DrinkDetail>();
    boolean getResult = false;
    while (!getResult) {
      selectedNumber = inputDrinkNumber(sc, "請輸入飲料編號開始進行點單: ");
      selectedDrink = menuGenerator.menu.get(selectedNumber);
      if (selectedDrink != null) {
        DrinkDetail newDrink =
            new DrinkDetail(selectedDrink.getName(), selectedDrink.getDescription(),
                selectedDrink.getIngredients(), selectedDrink.getCal(), selectedDrink.getPrice());
        orderList.add(inputDrinkgSetting(sc, newDrink));
        getResult = !inputContinue(sc, "再點一杯？(Y/N): ");
      } else {
        System.out.println("錯誤的飲料編號");
      }
    }
    generateOrder(sc, today.toString(), orderList);
  }

  public void generateOrder(Scanner sc, String today, List<DrinkDetail> drinkList) {
    String name = inputDrinkString(sc, "輸入顧客姓名: ");
    String phone = inputDrinkString(sc, "輸入顧客電話: ");
    String diliverYes = inputDrinkString(sc, "是否外送(Y/N): ");
    Boolean diliver = diliverYes.toUpperCase().equals("Y") ? true : false;
    String address = diliver ? inputDrinkString(sc, "輸入外送地址: ") : "";
    CustomerOrder newCustomerOrder = new CustomerOrder(name, phone, diliver, address, today, drinkList, countPrice(drinkList));
    allOrders.put(today + "_" + allOrders.size(), newCustomerOrder);
    printOrder(newCustomerOrder);
  }
  
  public int countPrice(List<DrinkDetail> drinkList) {
    int count = 0;
    for(DrinkDetail item : drinkList) {
      count += item.getPrice();
    }
    return count;
  }

  public void printOrder(CustomerOrder order) {
    System.out.println("==============================");
    System.out.println(order.getDate() + "\n" + order.getName() + "\t" + order.getPhone() + "\n外送:"
        + order.getDiliver() + order.getAddress());
    List<DrinkDetail> list = order.getDrinkList();
    for (int i = 0; i < list.size(); i++) {
      printDetail(list.get(i));
    }
    System.out.println("共 " + order.getPrice() + " 元");
    System.out.println("==============================");
  }

  public int inputDrinkNumber(Scanner sc, String msg) {
    System.out.print(msg);
    int num = sc.nextInt();
    return num;
  }

  public String inputDrinkString(Scanner sc, String msg) {
    System.out.print(msg);
    String text = sc.next().toUpperCase();
    return text;
  }

  public Boolean inputContinue(Scanner sc, String msg) {
    Boolean continueAgain = false;
    System.out.print(msg);
    String text = sc.next().toUpperCase();
    if (text.equals("Y")) {
      continueAgain = true;
    }
    return continueAgain;
  }

  public DrinkDetail inputDrinkgSetting(Scanner sc, DrinkDetail selectedDrink) {
    Boolean successSetted = false;
    int setIce = 10;
    int setSweet = 10;
    String setSize = "L";
    while (!successSetted) {
      setIce = inputDrinkNumber(sc, "請輸入冰度(0-10): ");
      setSweet = inputDrinkNumber(sc, "請輸入甜度(0-10): ");
      setSize = inputDrinkString(sc, "中杯(M)/大杯(L): ");
      successSetted = drinkSetted(selectedDrink, setIce, setSweet, setSize);
      if (successSetted) {
        printDetail(selectedDrink);
      } else {
        System.out.println("飲料設定輸入有誤，請重新輸入");
      }
    }
    return selectedDrink;
  }

  public Boolean drinkSetted(DrinkDetail drink, int ice, int sweet, String size) {
    if (ice > 10 || ice < 0 || sweet > 10 || sweet < 0
        || (!size.equals("M") && !size.equals("L"))) {
      return false;
    } else {
      DrinkModify newSetting = new DrinkModify(ice, sweet, size);
      drink.setDrinkSetting(newSetting);
      return true;
    }
  }

  public void printDetail(DrinkDetail selectedDrink) {
    DrinkModify thisSettings = selectedDrink.getDrinkSetting();
    String iceText = iceTextDisplay(thisSettings.getIce());
    String sweetText = sweetTextDisplay(thisSettings.getSweet());
    System.out.println(selectedDrink.getName() + "\t" + thisSettings.getSize() + "\t" + iceText
        + "\t" + sweetText);
  }

  public String iceTextDisplay(int ice) {
    if (ice > 0) {
      return ice + "分冰";
    } else {
      return "去冰";
    }
  }

  public String sweetTextDisplay(int sweet) {
    if (sweet > 0) {
      return sweet + "分糖";
    } else {
      return "無糖";
    }
  }
}


class MenuGenerator {
  public Map<Integer, DrinkDetail> menu = new HashMap<Integer, DrinkDetail>();

  public Map<Integer, DrinkDetail> addMenu(Integer number, String name, String description,
      String ingredients, float cal, int price) {
    menu.put(number, new DrinkDetail(name, description, ingredients, cal, price));
    return menu;
  }

  public void printMenu() {
    for (Integer key : menu.keySet()) {
      System.out.println(key + ": " + menu.get(key).getName() + menu.get(key).getPrice() + "元");
    }
  }
}


class DrinkModify {
  private int ice;
  private int sweet;
  private String size;

  public int getIce() {
    return ice;
  }

  public void setIce(int ice) {
    this.ice = ice;
  }

  public int getSweet() {
    return sweet;
  }

  public void setSweet(int sweet) {
    this.sweet = sweet;
  }

  public String getSize() {
    return size;
  }

  public void setSize(String size) {
    this.size = size;
  }

  public DrinkModify(int i, int j, String size) {
    super();
    this.ice = i;
    this.sweet = j;
    this.size = size;
  }

}


class DrinkDetail {
  private String name;
  private String description;
  private String ingredients;
  private float cal;
  private int price;
  private DrinkModify drinkSetting;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getIngredients() {
    return ingredients;
  }

  public void setIngredients(String ingredients) {
    this.ingredients = ingredients;
  }

  public float getCal() {
    return cal;
  }

  public void setCal(float cal) {
    this.cal = cal;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public DrinkDetail(String name, String description, String ingredients2, float cal, int price) {
    super();
    this.name = name;
    this.description = description;
    this.ingredients = ingredients2;
    this.cal = cal;
    this.price = price;
  }

  public DrinkModify getDrinkSetting() {
    return drinkSetting;
  }

  public void setDrinkSetting(DrinkModify drinkSetting) {
    this.drinkSetting = drinkSetting;
  }

}


class CustomerOrder {
  private String name;
  private String phone;
  private Boolean diliver;
  private String address;
  private String date;
  private List<DrinkDetail> drinkList;
  private int price;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public Boolean getDiliver() {
    return diliver;
  }

  public void setDiliver(Boolean diliver) {
    this.diliver = diliver;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getDate() {
    return date;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public List<DrinkDetail> getDrinkList() {
    return drinkList;
  }

  public void setDrinkList(List<DrinkDetail> drinkList) {
    this.drinkList = drinkList;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public CustomerOrder(String name, String phone, Boolean diliver, String address, String date,
      List<DrinkDetail> drinkList, int price) {
    super();
    this.name = name;
    this.phone = phone;
    this.diliver = diliver;
    this.address = address;
    this.date = date;
    this.drinkList = drinkList;
    this.price = price;
  }

}
