package LHC_92200133030.models;

public class input_product {
//    private int id ;
    private String product_name ;
//    private  int batch_id ;
    private int cost;

    public input_product(String product_name, int cost) {
//        this.id = id;
        this.product_name = product_name;
//        this.batch_id = batch_id;
        this.cost = cost;
    }

//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

//    public int getBatch_id() {
//        return batch_id;
//    }
//
//    public void setBatch_id(int batch_id) {
//        this.batch_id = batch_id;
//    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
