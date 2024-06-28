package com.justiceasare.gtptextprocessing.models;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class DataModel {
    private final StringProperty data;

    public DataModel(String data) {
        this.data = new SimpleStringProperty(data);
    }

    public String getData() {
        return data.get();
    }

    public void setData(String data) {
        this.data.set(data);
    }

    public StringProperty dataProperty() {
        return data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DataModel dataModel = (DataModel) o;
        return getData().equals(dataModel.getData());
    }

    @Override
    public int hashCode() {
        return data.get().hashCode();
    }

    @Override
    public String toString() {
        return data.get();
    }
}
