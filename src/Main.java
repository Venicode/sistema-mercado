import controller.StockController;
import controller.SupplierController;
import controller.VendaController;
import controller.mainController;
import models.Payment.Cash;
import models.People.Client;
import models.People.Supplier;
import models.Product.Grocery;
import models.Stock.Stock;
import models.Venda.Venda;

public class Main {
    public static void main(String[] args) {
        mainController newmainController = new mainController();
        newmainController.mainController();
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
        Client newCliente = new Client(
                "1234561232",
                "Vitoria",
                "123123123");
        Cash newPaymentCash = new Cash(
                newProduct.getSellingPrice(),
                30
        );
        Stock newStockClass = new Stock();
        StockController newStock = new StockController(newStockClass);
        newStock.cadastrarProdutoNoEstoque(newProduct);
        newStock.cadastrarProdutoNoEstoque(newProduct2);
        newStock.listarProdutosNoEstoque();
        SupplierController newSupplierController = new SupplierController();
        newSupplierController.cadastrarFornecedor(newSupplier);
        newSupplierController.listarFornecedores();
        Venda newVenda = new Venda(
                newCliente,
                newProduct,
                newPaymentCash,
                20,
                3
        );
        VendaController newVendaRealizada = new VendaController();
        newPaymentCash.methodPayment();
        newVendaRealizada.realizarVenda(newVenda, newStock);

        Venda newVenda2 = new Venda(
                newCliente,
                newProduct,
                newPaymentCash,
                50,
                3
        );
        VendaController newVendaRealizada2 = new VendaController();
        newPaymentCash.methodPayment();
        newVendaRealizada2.realizarVenda(newVenda2, newStock);
        System.out.println("Estoque total: " + newStock.saldoAtualEstoque());

    }
}
