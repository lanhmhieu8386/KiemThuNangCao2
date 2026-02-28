import org.example.Entity.ArrayUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class ArrayUtilsTest {

    ArrayUtils a = new ArrayUtils();

    // Kiem tra hop le
    @Test
    public void testHopLe() {
        int mongMuon = 1001;
        int thucTe = a.tinhTong(new int[]{1, 1000});
        Assertions.assertEquals(mongMuon, thucTe);
    }

    // Kiem tra bien min - 1
    @Test
    public void kiemTraBienMin() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> a.tinhTong(new int[]{0, 999}));
    }

    // Kiem tra min + 1
    @Test
    public void kiemTraBienMinCong1() {
        int mongMuon = 1001;
        int thucTe = a.tinhTong(new int[]{2, 999});
        Assertions.assertEquals(mongMuon, thucTe);
    }

    // Kiem tra max + 1
    @Test
    public void kiemTraBienMaxCong1() {

        Assertions.assertThrows(IllegalArgumentException.class, () -> a.tinhTong(new int[]{1, 1001}));
    }

    // Kiem tra max - 1
    @Test
    public void kiemTraBienMaxTru1() {
        int mongMuon = 1000;
        int thucTe = a.tinhTong(new int[]{1, 999});
        Assertions.assertEquals(mongMuon, thucTe);
    }

    // Kiem tra mang rong
    @Test
    public void kiemTraMangRong() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> a.tinhTong(new int[]{}));
    }

    // Kiem tra mang null
    @Test
    public void kiemTraMangNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> a.tinhTong(null));
    }
}
