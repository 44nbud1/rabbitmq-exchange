package com.latihan.rabbitmq.exchange.fanout.model;

public class DataSiswa {

    private String nama;
    private String mataPelajaran;
    private String alamat;

    public DataSiswa() {
    }

    public DataSiswa(String nama, String mataPelajaran, String alamat) {
        this.nama = nama;
        this.mataPelajaran = mataPelajaran;
        this.alamat = alamat;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getMataPelajaran() {
        return mataPelajaran;
    }

    public void setMataPelajaran(String mataPelajaran) {
        this.mataPelajaran = mataPelajaran;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }
}
