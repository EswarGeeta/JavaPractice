public class FirstProgram {

    public static void main(String[] args) {
        System.out.println("sample program");

        System.out.println('A');
        Book book1 = new Book(1, "first Boook");
        Book book2 = new Book(2, "second Boook");
        System.out.println(book1.hashCode());
        System.out.println(book2.hashCode());

    }

    private static class Book {
        private final int id;
        private final String name;

        public Book(int id, String name) {
            this.id = id;
            this.name = name;
        }

    }
}
