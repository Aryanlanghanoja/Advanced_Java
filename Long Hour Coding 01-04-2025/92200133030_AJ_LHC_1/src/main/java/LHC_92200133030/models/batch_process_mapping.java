package LHC_92200133030.models;

public class batch_process_mapping {

    private int batch_id ;
    private int process_id ;

    public batch_process_mapping(int batch_id, int process_id) {
        this.batch_id = batch_id;
        this.process_id = process_id;
    }

    public int getBatch_id() {
        return batch_id;
    }

    public void setBatch_id(int batch_id) {
        this.batch_id = batch_id;
    }

    public int getProcess_id() {
        return process_id;
    }

    public void setProcess_id(int process_id) {
        this.process_id = process_id;
    }
}
