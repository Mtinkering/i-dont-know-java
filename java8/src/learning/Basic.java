package learning;


import java.util.Hashtable;

public class Basic {
    public static void main(String[] args) {
        // 1. Modifiers in java
        // private protected public
        // static final

        // access modifiers:
        // field, method, constructor, class

        // non-access modifiers:
        // static abstract synchronized native volatile transient etc.


        // 2. final keyword in Java
        // final variable: constant variables
        // final method: prevent overriding
        // final class: not subclass == immutable class

        // 3. final vs finally vs finalize
        // final keyword
        // finally try catch
        // finalize: method that GC calls

        Basic s = new Basic();
//        s = null;

        // Requesting JVM to call Garbage Collector method
        System.gc();
        System.out.println("Main Completes");


        // 4. Which hash method that hashtable uses for insertion and retrieval
    }

    public static void main2(String[] args)
    {

        // Creating an empty Hashtable
        Hashtable<Integer, String> hash_table =
                new Hashtable<Integer, String>();

        // Inserting values into the table
        hash_table.put(10, "Geeks");
        hash_table.put(15, "4");
        hash_table.put(20, "Geeks");
        hash_table.put(25, "Welcomes");
        hash_table.put(30, "You");

        // Displaying the Hashtable
        System.out.println("Initial table is: " + hash_table);

        // Inserting existing key along with new value
        String returned_value = (String)hash_table.put(50, "All");

        // Verifying the returned value
        System.out.println("Returned value is: " + returned_value);

        // Displaying the new table
        System.out.println("New table is: " + hash_table);
    }

    public void finalize()
    {
        System.out.println("finalize method overriden");
    }
}
