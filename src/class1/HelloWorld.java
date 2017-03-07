package class1;

public class HelloWorld {

  // 這是一個類別，要用的時候new一個出來
  public static void main(String[] args) {
    // 使用哪個class 變數名稱 = new Object;
    Bc bc = new Bc();
    // bc.setWeight(100); // int 初始值是0
    // bc.setName("BBBBBB"); // String 初始值是 null
    bc.setGender("Male");
    System.out.println(bc.toString());
    Bc lana = new Bc();
    lana.setWeight(40);
    lana.setName("Lana");
    lana.setGender("Female");
    System.out.println(lana.toString());
  }
}


class Bc {

  private int weight; // private 封裝這個 int 在 Bc 裡面
  private String name;
  private String gender;

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getWeight() {
    return weight;
  }

  public void setWeight(int weight) {
    this.weight = weight;
  }

  @Override
  public String toString() {
    // toString：來自 java.lang.Object的方法，用同樣名稱可以複寫/改寫
    return "this bc's called " + name + ", " + (gender.equals("Female") ? "she" : "he")
        + "'s weight is " + weight;
  }

}
