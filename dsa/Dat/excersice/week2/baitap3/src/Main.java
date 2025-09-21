import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // a) Tạo bộ bài 52 quân
        Card[] deck = Deck.createDeck();

        System.out.println("=== Bộ bài ban đầu ===");
        printDeck(deck);

        // b) Sắp xếp bằng Comparator
        Arrays.sort(deck, new CompareCard());
        System.out.println("\n=== Bộ bài sau khi sắp xếp bằng Comparator ===");
        printDeck(deck);

        // c) Sắp xếp bằng Comparable + thuật toán sort tự cài (ví dụ BubbleSort)
        BubbleSort<Card> bubbleSort = new BubbleSort<>();
        Card[] deck2 = Deck.createDeck(); // tạo lại bộ bài mới để test
        bubbleSort.sort(deck2);

        System.out.println("\n=== Bộ bài sau khi sắp xếp bằng BubbleSort (Comparable) ===");
        printDeck(deck2);

        // InsertionSort
        InsertionSort<Card> insertionSort = new InsertionSort<>();
        Card[] deck3 = Deck.createDeck();
        insertionSort.sort(deck3);
        System.out.println("\nInsertionSort:");
        printDeck(deck3);

        // MergeSort
        MergeSort<Card> mergeSort = new MergeSort<>();
        Card[] deck4 = Deck.createDeck();
        mergeSort.sort(deck4);
        System.out.println("\nMergeSort:");
        printDeck(deck4);

        // QuickSort
        QuickSort<Card> quickSort = new QuickSort<>();
        Card[] deck5 = Deck.createDeck();
        quickSort.sort(deck5);
        System.out.println("\nQuickSort:");
        printDeck(deck5);
    }

    public static void printDeck(Card[] deck) {
        int count = 0;
        for (Card c : deck) {
            System.out.print(c + "  ");
            count++;
            if (count % 13 == 0) System.out.println(); // xuống dòng mỗi 13 lá
        }
    }
}
