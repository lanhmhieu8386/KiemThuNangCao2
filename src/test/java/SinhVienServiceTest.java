import org.example.Entity.SinhVien;
import org.example.Service.SinhVienService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SinhVienServiceTest {

    SinhVienService service;

    @BeforeEach
    public void setUp() {
        service = new SinhVienService();
        SinhVien entity = new SinhVien("PH576721", "Lãnh Minh Hiếu", 22, 9.5f, 3, "PTPM");
        service.addSinhVien(entity);
    }

    // Kiem tra add thang cong
    @Test
    public void TestAddThanhCong() {
        int sizeTruoc = service.size();
        SinhVien entity = new SinhVien("PH57621", "Lãnh Minh Hiếu 2", 20, 10f, 2, "PTPM");
        service.addSinhVien(entity);
        Assertions.assertEquals(sizeTruoc + 1, service.size());
    }

    // Kiem tra add thất bại
    @Test
    public void testAddThatBai() {
        SinhVien entity = new SinhVien("PH57621", "Lãnh Minh Hiếu 2", 20, -10f, 2, "PTPM");
        Assertions.assertThrows(IllegalArgumentException.class, () -> service.addSinhVien(entity));
    }

    //Test update
    @Test
    public void testUpdateThanhCong() {

        SinhVien entity = new SinhVien("PH57621", "Lãnh Minh Hiếu 2", 20, 10f, 2, "PTPM");
        service.addSinhVien(entity);

        SinhVien entity2 = new SinhVien("PH57621", "Lãnh Minh Hiếu 2", 20, 9f, 2, "PTPM");
        service.updateSinhVien(entity2);

        SinhVien result = service.findByMa("PH57621");

        Assertions.assertEquals(9f, result.getDiemTrungBinh());

    }

    // Update that bai
    @Test
    public void testUpdateThatBai() {
        SinhVien entity = new SinhVien("PH57621", "Lãnh Minh Hiếu 2", 20, 10f, -2, "PTPM");
        Assertions.assertThrows(IllegalArgumentException.class, () -> service.updateSinhVien(entity));
    }

    // Test update diem 0-10
    @Test
    public void testKiThuatBien() {
        SinhVien entity = new SinhVien("PH57621", "Lãnh Minh Hiếu 2", 20, 10f, 2, "PTPM");
        service.addSinhVien(entity);

        SinhVien entity2 = new SinhVien("PH57621", "Lãnh Minh Hiếu 2", 20, 0f, 2, "PTPM");
        service.updateSinhVien(entity2);

        SinhVien result = service.findByMa("PH57621");

        Assertions.assertEquals(0f, result.getDiemTrungBinh());
    }

    @Test
    public void testKiThuatBienMinTru1() {
        SinhVien entity = new SinhVien("PH57621", "Lãnh Minh Hiếu 2", 20, -1f, 2, "PTPM");
        Assertions.assertThrows(IllegalArgumentException.class, () -> service.updateSinhVien(entity));
    }

    @Test
    public void testKiThuatBienMinCong1() {
        SinhVien entity = new SinhVien("PH57621", "Lãnh Minh Hiếu 2", 20, 0f, 2, "PTPM");
        service.addSinhVien(entity);

        SinhVien entity2 = new SinhVien("PH57621", "Lãnh Minh Hiếu 2", 20, 1f, 2, "PTPM");
        service.updateSinhVien(entity2);

        SinhVien result = service.findByMa("PH57621");

        Assertions.assertEquals(1f, result.getDiemTrungBinh());
    }

    // TEST MAX
    @Test
    public void testKiThuatBienMax() {
        SinhVien entity = new SinhVien("PH57621", "Lãnh Minh Hiếu 2", 20, 0f, 2, "PTPM");
        service.addSinhVien(entity);

        SinhVien entity2 = new SinhVien("PH57621", "Lãnh Minh Hiếu 2", 20, 10f, 2, "PTPM");
        service.updateSinhVien(entity2);

        SinhVien result = service.findByMa("PH57621");

        Assertions.assertEquals(10f, result.getDiemTrungBinh());
    }

    // Ky thuat bien max - 1
    @Test
    public void testKiThuatBienMaxTru1() {
        SinhVien entity = new SinhVien("PH57621", "Lãnh Minh Hiếu 2", 20, 10f, 2, "PTPM");
        service.addSinhVien(entity);

        SinhVien entity2 = new SinhVien("PH57621", "Lãnh Minh Hiếu 2", 20, 9f, 2, "PTPM");
        service.updateSinhVien(entity2);

        SinhVien result = service.findByMa("PH57621");

        Assertions.assertEquals(9f, result.getDiemTrungBinh());
    }

    // Ky thuat bien max cong 1
    @Test
    public void testKiThuatBienMaxCong1() {
        SinhVien entity = new SinhVien("PH57621", "Lãnh Minh Hiếu 2", 20, 11f, 2, "PTPM");
        Assertions.assertThrows(IllegalArgumentException.class, () -> service.updateSinhVien(entity));
    }


    // TEST DELETE
    @Test
    public void testDeleteThanhCong() {
        SinhVien entity = new SinhVien("PH57621", "Lãnh Minh Hiếu 2", 20, 10f, 2, "PTPM");
        service.addSinhVien(entity);

        service.deleteSinhVien(entity);
        Assertions.assertNull(service.findByMa("PH57621"));
    }

    @Test
    public void testDeletEntityNull() {
        SinhVien entity = new SinhVien("PH57621", "Lãnh Minh Hiếu 2", 20, 10f, 2, "PTPM");
        service.addSinhVien(entity);
        Assertions.assertThrows(IllegalArgumentException.class, () -> service.deleteSinhVien(null));
    }

    // TEST TIM KIEM
    @Test
    public void testTimKiemThanhCong() {
        SinhVien entity = new SinhVien("PH57621", "Lãnh Minh Hiếu 2", 20, 10f, 2, "PTPM");
        service.addSinhVien(entity);

        SinhVien result = service.findByMa("PH57621");
        Assertions.assertEquals("PH57621", result.getMaSV());
    }

    @Test
    public void testTimKiemMaSVTrong() {
        SinhVien entity = new SinhVien("PH57621", "Lãnh Minh Hiếu 2", 20, 10f, 2, "PTPM");
        service.addSinhVien(entity);
        Assertions.assertThrows(IllegalArgumentException.class, () -> service.findByMa(""));
    }

    @Test
    public void testTimKiemMaNull() {
        SinhVien entity = new SinhVien("PH57621", "Lãnh Minh Hiếu 2", 20, 10f, 2, "PTPM");
        service.addSinhVien(entity);
        Assertions.assertThrows(IllegalArgumentException.class, () -> service.findByMa(null));
    }


}
