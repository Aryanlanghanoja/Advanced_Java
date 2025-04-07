package LHC_92200133030.models;

public class batch {

    private int batch_id ;
    private  int no_of_product ;
    private String product_name ;
    private  String batch_name ;
    private  String Status ;

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public batch(int batch_id , String product_name , int no_of_product) {
        this.batch_id = batch_id;
        this.product_name = product_name;
        this.no_of_product = no_of_product;
    }

    public int getBatch_id() {
        return batch_id;
    }

    public void setBatch_id(int batch_id) {
        this.batch_id = batch_id;
    }

    public String getBatch_name() {
        return batch_name;
    }

    public void setBatch_name(String batch_name) {
        this.batch_name = batch_name;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public int getNo_of_product() {
        return no_of_product;
    }

    public void setNo_of_product(int no_of_product) {
        this.no_of_product = no_of_product;
    }
}
