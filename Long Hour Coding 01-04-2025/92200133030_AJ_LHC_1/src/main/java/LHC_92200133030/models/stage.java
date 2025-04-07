package LHC_92200133030.models;

public class stage {
    private int stage_id ;
    private String stage_name;

    public stage(int stage_id, String stage_name) {
        this.stage_id = stage_id;
        this.stage_name = stage_name;
    }

    public int getStage_id() {
        return stage_id;
    }

    public void setStage_id(int stage_id) {
        this.stage_id = stage_id;
    }

    public String getStage_name() {
        return stage_name;
    }

    public void setStage_name(String stage_name) {
        this.stage_name = stage_name;
    }
}
