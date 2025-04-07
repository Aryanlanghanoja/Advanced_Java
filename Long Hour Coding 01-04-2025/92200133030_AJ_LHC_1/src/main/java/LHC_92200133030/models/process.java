package LHC_92200133030.models;

public class process {
    private int process_id ;
    private String process_name ;
    private String output_product ;
    private  int batch_id   ;
    private int cost  ;

    public process(String process_name) {
//        this.process_id = process_id;
        this.process_name = process_name;
//        this.output_product = output_product;
//        this.batch_id = batch_id;
//        this.cost = cost;
    }

    public int getProcess_id() {
        return process_id;
    }

    public void setProcess_id(int process_id) {
        this.process_id = process_id;
    }

    public String getProcess_name() {
        return process_name;
    }

    public void setProcess_name(String process_name) {
        this.process_name = process_name;
    }

    public String getOutput_product() {
        return output_product;
    }

    public void setOutput_product(String output_product) {
        this.output_product = output_product;
    }

    public int getBatch_id() {
        return batch_id;
    }

    public void setBatch_id(int batch_id) {
        this.batch_id = batch_id;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
