package class6;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class HomeWork6 {
  public static void main(String[] args) {
    // new Q6_1().ans();
    // new Q6_2().ans();
    // new Q6_3().ans();
//    new Q6_4().ans();
    new Q6_5().ans();
  }
}


/**
 * <pre>
 * 
 * 請使用Map物件，處理以下問題
 * 
 * 會員資料
 * 編號  姓名
 * C1    藍色
 * C2    香菇
 * C3    小草
 * 
 * 1.會員編號C1的姓名更改成紅色，並印出前後修改的內容
 * 2.會員編號C2已被停止使用，新增一個新的會員資料
 *   編號:C4 ,  姓名: 天天，並印出整體會員資料
 * 
 * </pre>
 */
class Q6_1 {
  public void ans() {
    Map<String, Member> data = genMap();
    printData(data);
    editDataName(data, "C1", "紅色");
    printData(data);
    removeData(data, "C2");
    addData(data, "C4", "天天");
    printData(data);
  }

  public void addData(Map<String, Member> data, String addID, String addName) {
    data.put(addID, new Member(addID, addName));
  }

  public void removeData(Map<String, Member> data, String removeKey) {
    data.remove(removeKey);
  }

  public void editDataName(Map<String, Member> data, String editKey, String name) {
    data.get(editKey).setName(name);
  }

  public Map<String, Member> genMap() {
    Map<String, Member> members = new HashMap<String, Member>();
    addData(members, "C1", "藍色");
    addData(members, "C2", "香菇");
    addData(members, "C3", "小草");
    return members;
  }

  public void printData(Map<String, Member> data) {
    for (String key : data.keySet()) {
      System.out.println("ID: " + data.get(key).getId() + ", Name: " + data.get(key).getName());
    }
    System.out.println("==");
  }
}


/**
 * <pre>
 * 請使用List物件，處理以下問題
 * 
 * 會員資料
 * 編號  姓名
 * C1    藍色
 * C2    香菇
 * C3    小草
 * 
 * 1.會員編號C1的姓名更改成紅色，並印出前後修改的內容
 * 2.會員編號C2已被停止使用，新增一個新的會員資料
 *   編號:C4 ,  姓名: 天天，並印出整體會員資料
 * 
 * </pre>
 */
class Q6_2 {
  public void ans() {
    List<Member> data = genList();
    printData(data);
    editDataName(data, "C1", "紅色");
    printData(data);
    removeData(data, "C2");
    data.add(new Member("C4", "天天"));
    printData(data);
  }

  public void removeData(List<Member> data, String removeKey) {
    for (Member member : data) {
      if (removeKey.equals(member.getId())) {
        data.remove(member);
        break;
      }
    }
  }

  public void editDataName(List<Member> data, String editKey, String name) {
    for (Member member : data) {
      if (editKey.equals(member.getId())) {
        member.setName(name);
        break;
      }
    }
  }

  public List<Member> genList() {
    List<Member> members = new ArrayList<Member>();
    members.add(new Member("C1", "藍色"));
    members.add(new Member("C2", "香菇"));
    members.add(new Member("C3", "小草"));
    return members;
  }

  public void printData(List<Member> data) {
    for (Member member : data) {
      System.out.println("ID: " + member.getId() + ", Name: " + member.getName());
    }
    System.out.println("==");
  }

}


class Member {
  private String id;
  private String name;

  public Member(String id, String name) {
    this.setId(id);
    this.setName(name);
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

}


/**
 * <pre>
 * 使用Set物件與Random物件搭配
 * 產生10組大樂透號碼
 * </pre>
 */
class Q6_3 {
  public void ans() {
    for (int i = 0; i < 10; i++) {
      System.out.println(printSet(lotteryGenerator()));
    }
  }

  public Set<Integer> lotteryGenerator() {
    Set<Integer> data = new HashSet<Integer>();
    while (data.size() < 6) {
      int number = new Random().nextInt(49) + 1;
      data.add(number);
    }
    return data;
  }

  public String printSet(Set<Integer> data) {
    String lottery = "";
    for (Integer i : data) {
      lottery += i + ", ";
    }
    return lottery.substring(0, lottery.length() - 2);
  }
}


/**
 * <pre>
 * 
 * 以下請使用Map物件儲存以下資訊
 * 並解決四個問題
 * 
 * 會員資料
 * 編號  姓名
 * C1    小Q
 * C2    小咪
 * C3    查理
 * 
 * 訂單資料
 * 訂單 會員編號  訂購內容     金額
 * O001     C1      衣服        789
 * O002     C1        3C       1999
 * O003     C2      遊戲       1899
 * O004     C2    保養品       3300
 * O005     C3    攝影機      14999
 * 
 * 請用新增會員與訂單類別(Class)
 * 設定每位會員資料以及訂單資料後
 * 
 * 1.用會員編號查詢會員買的商品
 *   輸出格式 => 編號 姓名 訂單 訂購內容 金額
 *   
 * 2.算出每位會員的平均每筆消費金額
 *   輸出格式 => 編號 姓名 平均消費金額
 *   
 * 3.依照消費總金額高到低排序
 *   輸出格式 => 編號 姓名 消費總金額
 *   
 * 4.依照消費總金額低到高排序
 *   輸出格式 => 編號 姓名 消費總金額
 * 
 * </pre>
 */
class Q6_4 {
  public void ans() {
    Map<String, Member> memberMap = memberMap();
    Map<String, OrderData> orderMap = orderMap();
    Map<String, List<OrderData>> customorOrderMap = customorOrderMap(memberMap, orderMap);
    input(memberMap, customorOrderMap);
    System.out.println("==");
    calcAvg(customorOrderMap, memberMap);
    System.out.println("==");
    printCustomorBought(sortPriceAsc(customorOrderMap, true), memberMap);
    System.out.println("==");
    printCustomorBought(sortPriceAsc(customorOrderMap, false), memberMap);
  }

  public void input(Map<String, Member> memberMap, Map<String, List<OrderData>> customorOrderMap) {
    Scanner sc = new Scanner(System.in);
    boolean getResult = false;
    Member thisMember = null;
    String customorId = "";
    while (!getResult) {
      customorId = inputCustomorId(sc);
      thisMember = memberMap.get(customorId);
      if (thisMember != null) {
        getResult = true;
      } else {
        System.out.println("會員編號不正確");
      }
    }
    printOrderList(customorOrderMap.get(customorId), memberMap);
  }

  public void calcAvg(Map<String, List<OrderData>> customorOrderMap, Map<String, Member> memberMap) {
    System.out.println("編號\t姓名\t平均消費金額");
    for (String key : customorOrderMap.keySet()) {
      int totalPrice = 0;
      int orderCount = customorOrderMap.get(key).size();
      for (OrderData order : customorOrderMap.get(key)) {
        totalPrice += order.getPrice();
      }
      float avg = (float) totalPrice / orderCount;
      System.out.println(key + "\t" + memberMap.get(key).getName() + "\t" + avg);
    }
  }

  public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map, boolean isAsc) {
    List<Map.Entry<K, V>> list = new LinkedList<>(map.entrySet());
    if(isAsc) {
      Collections.sort(list, new Comparator<Map.Entry<K, V>>() {
        @Override
        public int compare(Map.Entry<K, V> o1, Map.Entry<K, V> o2) {
          return (o1.getValue()).compareTo(o2.getValue());
        }
      });
    } else {
      Collections.sort(list, new Comparator<Map.Entry<K, V>>() {
        @Override
        public int compare(Map.Entry<K, V> o1, Map.Entry<K, V> o2) {
          return (o2.getValue()).compareTo(o1.getValue());
        }
      });
    }

    Map<K, V> result = new LinkedHashMap<>();
    for (Map.Entry<K, V> entry : list) {
      result.put(entry.getKey(), entry.getValue());
    }
    return result;
  }

  public Map<String, Integer> sortPriceAsc(Map<String, List<OrderData>> customorOrderMap, boolean isAsc) {
    Map<String, Integer> totalBought = new HashMap<String, Integer>();
    for (String key : customorOrderMap.keySet()) {
      int totalPrice = 0;
      for (OrderData order : customorOrderMap.get(key)) {
        totalPrice += order.getPrice();
      }
      totalBought.put(key, totalPrice);
    }
    return sortByValue(totalBought, isAsc);
  }
  
  public void printCustomorBought(Map<String, Integer> customorBought, Map<String, Member> memberMap) {
    System.out.println("編號\t姓名\t消費總金額");
    for(String key: customorBought.keySet()) {
      System.out.println(key + "\t" + memberMap.get(key).getName() + "\t" + customorBought.get(key));
    }
  }

  public Map<String, List<OrderData>> customorOrderMap(Map<String, Member> memberMap,
      Map<String, OrderData> orderMap) {
    Map<String, List<OrderData>> customorOrderMap = new HashMap<String, List<OrderData>>();
    for (String key : memberMap.keySet()) {
      customorOrderMap.put(key, getOrderData(orderMap, key));
    }
    return customorOrderMap;
  }

  public List<OrderData> getOrderData(Map<String, OrderData> orderMap, String customorId) {
    List<OrderData> orderList = new ArrayList<OrderData>();
    for (OrderData data : orderMap.values()) {
      if (customorId.equals(data.getCustomorId())) {
        orderList.add(data);
      }
    }
    return orderList;
  }

  public void printOrderList(List<OrderData> orderList, Map<String, Member> memberMap) {
    System.out.println("編號\t姓名\t訂單\t訂購內容\t金額");
    for (OrderData data : orderList) {
      System.out.println(data.getCustomorId() + "\t"
          + memberMap.get(data.getCustomorId()).getName() + "\t" + data.getOrderId() + "\t"
          + data.getCatagory() + "\t" + data.getPrice());
    }
  }

  public Map<String, Member> memberMap() {
    Map<String, Member> members = new HashMap<String, Member>();
    members.put("C1", new Member("C1", "小Q"));
    members.put("C2", new Member("C2", "小咪"));
    members.put("C3", new Member("C3", "查理"));
    return members;
  }

  public Map<String, OrderData> orderMap() {
    Map<String, OrderData> orderMap = new HashMap<String, OrderData>();
    orderMap.put("O001", new OrderData("O001", "C1", "衣服", 789));
    orderMap.put("O002", new OrderData("O002", "C1", "3C", 1999));
    orderMap.put("O003", new OrderData("O003", "C2", "遊戲", 1899));
    orderMap.put("O004", new OrderData("O004", "C2", "保養品", 3300));
    orderMap.put("O005", new OrderData("O005", "C3", "攝影機", 14999));
    return orderMap;
  }

  public String inputCustomorId(Scanner sc) {
    System.out.print("請輸入會員編號查詢訂單:");
    String operator = sc.next();
    return operator;
  }
}


/**
 * <pre>
 * 
 * 以下請使用List物件儲存以下資訊
 * 並解決四個問題
 * 
 * 會員資料
 * 編號  姓名
 * C1    小Q
 * C2    小咪
 * C3    查理
 * 
 * 訂單資料
 * 訂單 會員編號  訂購內容     金額
 * O001     C1      衣服        789
 * O002     C1        3C    1999
 * O003     C2      遊戲       1899
 * O004     C2    保養品       3300
 * O005     C3    攝影機      14999
 * 
 * 請用新增會員與訂單類別(Class)
 * 設定每位會員資料以及訂單資料後
 * 
 * 1.用會員編號查詢會員買的商品
 *   輸出格式 => 編號 姓名 訂單 訂購內容 金額
 *   
 * 2.算出每位會員的平均每筆消費金額
 *   輸出格式 => 編號 姓名 平均消費金額
 *   
 * 3.依照消費總金額高到低排序
 *   輸出格式 => 編號 姓名 消費總金額
 *   
 * 4.依照消費總金額低到高排序
 *   輸出格式 => 編號 姓名 消費總金額
 * 
 * </pre>
 */
class Q6_5 {
  public void ans() {
    List<Member> memberMap = memberList();
    List<OrderData> orderMap = orderList();
    Map<String, List<OrderData>> customorOrderMap = customorOrderMap(memberMap, orderMap);
    input(memberMap, customorOrderMap);
    System.out.println("==");
    calcAvg(customorOrderMap, memberMap);
    System.out.println("==");
    printCustomorBought(sortPriceAsc(customorOrderMap, true), memberMap);
    System.out.println("==");
    printCustomorBought(sortPriceAsc(customorOrderMap, false), memberMap);
  }

  public void input(List<Member> memberMap, Map<String, List<OrderData>> customorOrderMap) {
    Scanner sc = new Scanner(System.in);
    boolean getResult = false;
    Member thisMember = null;
    String customorId = "";
    while (!getResult) {
      customorId = inputCustomorId(sc);
      thisMember = getMember(memberMap, customorId);
      if (thisMember != null) {
        getResult = true;
      } else {
        System.out.println("會員編號不正確");
      }
    }
    printOrderList(customorOrderMap.get(customorId), memberMap);
  }
  
  public Member getMember(List<Member> memberList, String customorId) {
    Member thismember = null;
    for(Member member : memberList) {
      if(customorId.equals(member.getId())) {
        thismember = member;
      }
    }
    return thismember;
  }

  public void calcAvg(Map<String, List<OrderData>> customorOrderMap, List<Member> memberMap) {
    System.out.println("編號\t姓名\t平均消費金額");
    for (String key : customorOrderMap.keySet()) {
      int totalPrice = 0;
      int orderCount = customorOrderMap.get(key).size();
      for (OrderData order : customorOrderMap.get(key)) {
        totalPrice += order.getPrice();
      }
      float avg = (float) totalPrice / orderCount;
      System.out.println(key + "\t" + getMember(memberMap, key).getName() + "\t" + avg);
    }
  }

  public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map, boolean isAsc) {
    List<Map.Entry<K, V>> list = new LinkedList<>(map.entrySet());
    if(isAsc) {
      Collections.sort(list, new Comparator<Map.Entry<K, V>>() {
        @Override
        public int compare(Map.Entry<K, V> o1, Map.Entry<K, V> o2) {
          return (o1.getValue()).compareTo(o2.getValue());
        }
      });
    } else {
      Collections.sort(list, new Comparator<Map.Entry<K, V>>() {
        @Override
        public int compare(Map.Entry<K, V> o1, Map.Entry<K, V> o2) {
          return (o2.getValue()).compareTo(o1.getValue());
        }
      });
    }

    Map<K, V> result = new LinkedHashMap<>();
    for (Map.Entry<K, V> entry : list) {
      result.put(entry.getKey(), entry.getValue());
    }
    return result;
  }

  public Map<String, Integer> sortPriceAsc(Map<String, List<OrderData>> customorOrderMap, boolean isAsc) {
    Map<String, Integer> totalBought = new HashMap<String, Integer>();
    for (String key : customorOrderMap.keySet()) {
      int totalPrice = 0;
      for (OrderData order : customorOrderMap.get(key)) {
        totalPrice += order.getPrice();
      }
      totalBought.put(key, totalPrice);
    }
    return sortByValue(totalBought, isAsc);
  }
  
  public void printCustomorBought(Map<String, Integer> customorBought, List<Member> memberMap) {
    System.out.println("編號\t姓名\t消費總金額");
    for(String key: customorBought.keySet()) {
      System.out.println(key + "\t" + getMember(memberMap, key).getName() + "\t" + customorBought.get(key));
    }
  }

  public Map<String, List<OrderData>> customorOrderMap(List<Member> memberMap,
      List<OrderData> orderMap) {
    Map<String, List<OrderData>> customorOrderMap = new HashMap<String, List<OrderData>>();
    for (Member member : memberMap) {
      customorOrderMap.put(member.getId(), getOrderData(orderMap, member.getId()));
    }
    return customorOrderMap;
  }

  public List<OrderData> getOrderData(List<OrderData> orderMap, String customorId) {
    List<OrderData> orderList = new ArrayList<OrderData>();
    for (OrderData data : orderMap) {
      if (customorId.equals(data.getCustomorId())) {
        orderList.add(data);
      }
    }
    return orderList;
  }

  public void printOrderList(List<OrderData> orderList, List<Member> memberMap) {
    System.out.println("編號\t姓名\t訂單\t訂購內容\t金額");
    for (OrderData data : orderList) {
      System.out.println(data.getCustomorId() + "\t"
          + getMember(memberMap, data.getCustomorId()).getName() + "\t" + data.getOrderId() + "\t"
          + data.getCatagory() + "\t" + data.getPrice());
    }
  }

  public List<Member> memberList() {
    List<Member> members = new ArrayList<Member>();
    members.add(new Member("C1", "小Q"));
    members.add(new Member("C2", "小咪"));
    members.add(new Member("C3", "查理"));
    return members;
  }

  public List<OrderData> orderList() {
    List<OrderData> orderList = new ArrayList<OrderData>();
    orderList.add(new OrderData("O001", "C1", "衣服", 789));
    orderList.add(new OrderData("O002", "C1", "3C", 1999));
    orderList.add(new OrderData("O003", "C2", "遊戲", 1899));
    orderList.add(new OrderData("O004", "C2", "保養品", 3300));
    orderList.add(new OrderData("O005", "C3", "攝影機", 14999));
    return orderList;
  }

  public String inputCustomorId(Scanner sc) {
    System.out.print("請輸入會員編號查詢訂單:");
    String operator = sc.next();
    return operator;
  }
}


class OrderData {
  private String orderId;
  private String customorId;
  private String catagory;
  private int price;

  public OrderData(String orderId, String customorId, String catagory, int i) {
    this.setOrderId(orderId);
    this.setCustomorId(customorId);
    this.setCatagory(catagory);
    this.setPrice(i);
  }

  public String getOrderId() {
    return orderId;
  }

  public void setOrderId(String orderId) {
    this.orderId = orderId;
  }

  public String getCustomorId() {
    return customorId;
  }

  public void setCustomorId(String customorId) {
    this.customorId = customorId;
  }

  public String getCatagory() {
    return catagory;
  }

  public void setCatagory(String catagory) {
    this.catagory = catagory;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

}
