package chapter8.question9;

public class Test {
    public static void main(String[] args) {
        Directory root = new Directory("Food", null);
        File taco = new File("Taco", root, 4);
        File hamburger = new File("Hamburger", root, 9);
        root.addEntry(taco);
        root.addEntry(hamburger);

        Directory healthy = new Directory("Healthy", root);
        Directory fruits = new Directory("fruits", healthy);
        File apple = new File("apple", fruits, 5);
        File banana = new File("banada", fruits, 10);
        fruits.addEntry(apple);
        fruits.addEntry(banana);
        healthy.addEntry(fruits);

        root.addEntry(healthy);

        System.out.println(root.numberofFiles());
        System.out.println(apple.getFullPath());
    }
}
