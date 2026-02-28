package org.example.Service;

import org.example.Entity.SinhVien;

import java.util.ArrayList;
import java.util.List;

public class SinhVienService {

    List<SinhVien> lstSinhVien = new ArrayList<>();

    public void addSinhVien(SinhVien entity) {
        if (entity.getMaSV() == null || entity.getMaSV().trim().isEmpty()) {
            throw new IllegalArgumentException("Ma sinh vien khong duoc de trong");
        }

        if (entity.getTen() == null || entity.getTen().trim().isEmpty()) {
            throw new IllegalArgumentException("Ten sinh vien khong duoc de trong");
        }
        if (entity.getDiemTrungBinh() < 0 || entity.getDiemTrungBinh() > 10) {
            throw new IllegalArgumentException("Diem trung binh phai trong khoang 0-10");
        }

        if (entity.getKyHoc() < 0) {
            throw new IllegalArgumentException("Hoc ky phai lon hon 0");
        }
        if (entity.getChuyenNganh() == null || entity.getChuyenNganh().trim().isEmpty()) {
            throw new IllegalArgumentException("Chuyen nganh khong duoc de trong");
        }

        lstSinhVien.add(entity);
    }

    public SinhVien updateSinhVien(SinhVien entity) {
        if (entity == null) {
            throw new IllegalArgumentException("Chua chon sinh vien");
        }
        if (entity.getTen() == null || entity.getTen().trim().isEmpty()) {
            throw new IllegalArgumentException("Ten sinh vien khong duoc de trong");
        }
        if (entity.getDiemTrungBinh() < 0 || entity.getDiemTrungBinh() > 10) {
            throw new IllegalArgumentException("Diem trung binh phai trong khoang 0-10");
        }

        if (entity.getKyHoc() < 0) {
            throw new IllegalArgumentException("Hoc ky phai lon hon 0");
        }
        if (entity.getChuyenNganh() == null || entity.getChuyenNganh().trim().isEmpty()) {
            throw new IllegalArgumentException("Chuyen nganh khong duoc de trong");
        }
        for (SinhVien s : lstSinhVien) {
            if (s.getMaSV().equals(entity.getMaSV())) {
                s.setTen(entity.getTen());
                s.setDiemTrungBinh(entity.getDiemTrungBinh());
                s.setChuyenNganh(entity.getChuyenNganh());
                s.setKyHoc(entity.getKyHoc());
                return s;
            }
        }
        throw new IllegalArgumentException("Khong tim thay sinh vien");
    }

    public void deleteSinhVien(SinhVien entity) {
        if (entity == null) {
            throw new IllegalArgumentException("Chua chon sinh vien");
        }

        boolean removed = lstSinhVien
                .removeIf(s -> s.getMaSV().equals(entity.getMaSV()));

        if (!removed) {
            throw new IllegalArgumentException("Khong tim thay sinh vien");
        }
    }

    public SinhVien timKiem(String maSV) {
        if (maSV == null || maSV.trim().isEmpty()) {
            throw new IllegalArgumentException("Ma sinh vien khong duoc de trong");
        }

        return lstSinhVien.stream()
                .filter(s -> s.getMaSV().equals(maSV))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Khong tim thay sinh vien"));
    }

    public SinhVien findByMa(String maSV) {
        if (maSV == null || maSV.trim().isEmpty()) {
            throw new IllegalArgumentException("Ma sinh vien khong duoc de trong");
        }

        for (SinhVien s : lstSinhVien) {
            if (s.getMaSV().equals(maSV)) {
                return s;
            }
        }

        return null; // không tìm thấy
    }

    public int size() {
        return lstSinhVien.size();
    }
}
