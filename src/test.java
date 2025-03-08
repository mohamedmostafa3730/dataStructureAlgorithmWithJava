import DataStructure.Hash;

public class test {
    public static void main(String[] args) {
        // Dictionary
        // Dictionary<String,String> m = new Dictionary<>();
        // m.set("mohamed", "01014593730");
        // m.set("Ahmed", "03034857264");
        // m.set("Mostafa", "83957486354");
        // m.set("Ali", "92846578493");
        // m.print();
        // m.remove("Ahmed");
        // m.print();
        // Hash
        String teXt = "This is Original Text";
        Hash h = new Hash();
        int afterHas32 = h.Hash32(teXt);
        long afterHas64 = h.hash64(teXt);

        System.out.println("=================");
        System.out.println("Before Hashing => " + teXt);
        System.out.println("-----------------");
        System.out.println("After Hashing with 32 => " + afterHas32);
        System.out.println("-----------------");
        System.out.println("After Hashing with 64 => " + afterHas64);
        System.out.println("=================");
    }

}
