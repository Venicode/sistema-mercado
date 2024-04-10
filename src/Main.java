import controller.StockController;
import controller.SupplierController;
import models.People.Supplier;
import models.Product.Grocery;
import models.Stock.Stock;

public class Main {
    public static void main(String[] args) {
        System.out.println("Teste");
        Supplier newSupplier = new Supplier(
                "Atacadao",
                "(11)4151-2340",
                "atacacao@gmail.com",
                "97.104.730/0001-74"
        );
        Grocery newProduct = new Grocery(
                "arroz",
                10,
                20,
                newSupplier,
                200,
                "10/08/2024"
        );
        Grocery newProduct2 = new Grocery(
                "macarrao",
                10,
                20,
                newSupplier,
                200,
                "10/08/2024"
        );
        StockController newStock = new StockController();
        newStock.cadastrarProdutoNoEstoque(newProduct);
        newStock.cadastrarProdutoNoEstoque(newProduct2);
        newStock.listarProdutosNoEstoque();
        SupplierController newSupplierController = new SupplierController();
        newSupplierController.cadastrarFornecedor(newSupplier);
        newSupplierController.listarFornecedores();
    }
}