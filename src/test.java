import DataStructure.Dictionary;

public class test {
    public static void main(String[] args) {
        Dictionary<String,String> m = new Dictionary<>();
        m.set("mohamed", "01014593730");
        m.set("Ahmed", "03034857264");
        m.set("Mostafa", "83957486354");
        m.set("Ali", "92846578493");
        m.print();
        m.remove("Ahmed");
        m.print();
    }

}
