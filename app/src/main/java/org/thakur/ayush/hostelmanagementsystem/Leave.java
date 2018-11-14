package org.thakur.ayush.hostelmanagementsystem;

/**
 * Created by win on 07-11-2018.
 */

public class Leave {
    String Id;
    String startDate;
    String endDate;
    String remark;

    public Leave() {
    }

    public Leave(String id, String startDate, String endDate, String remark) {
        Id = id;
        this.startDate = startDate;
        this.endDate = endDate;
        this.remark = remark;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}

