import java.util.Arrays;


public class ProductsArray {

    private String[] products;

    public ProductsArray() {
        products = new String[20];

        products [0] = "Arroz";
        products [1] = "Leche";
        products [2] = "Pan";
        products [3] = "Queso";
        products [4] = "Huevos";
        products [5] = "Agua";
        products [6] = "Panela";
        products [7] = "Limon";
        products [8] = "Papa";
        products [9] = "Yuca";
        products [10] = "Tomate";
        products [11] = "Salsas";
        products [12] = "Zanahoria";
        products [13] = "Lechuga";
        products [14] = "Espinaca";
        products [15] = "Lentejas";
        products [16] = "Frijoles";
        products [17] = "Ahuyama";
        products [18] = "Calabaza";
        products [19] = "Cilantro";




    }

    public void showProductsStartingWith(char letter) {
        System.out.println("Productos que comienzan con '" + letter + "':");
        for (String product : products) {
            if (product != null && product.toLowerCase().charAt(0) == Character.toLowerCase(letter)) {
                System.out.println(product);
            }
        }
    }

    public void printProductsInAlphabeticalOrder() {
        Arrays.sort(products);
        System.out.println("Productos ordenados alfabéticamente:");
        for (String product : products) {
            if (product != null) {
                System.out.println(product);
            }
        }
    }
}

