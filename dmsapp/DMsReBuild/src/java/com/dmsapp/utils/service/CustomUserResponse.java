package com.dmsapp.utils.service;

import com.dmsapp.domain.sub.SubMaster;
import java.util.List;

public class CustomUserResponse {

    private String page;
    private String total;
    private String records;
    private List<SubMaster> rows;

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getRecords() {
        return records;
    }

    public void setRecords(String records) {
        this.records = records;
    }

    public List<SubMaster> getRows() {
        return rows;
    }

    public void setRows(List<SubMaster> rows) {
        this.rows = rows;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
}
