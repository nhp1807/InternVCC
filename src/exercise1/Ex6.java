package exercise1;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

enum GioiTinh{
    MALE, FEMALE, OTHER
}

enum CaDangKy{
    SANG, CHIEU, TOI
}

class KhachHang{
    private String maKhachHang;
    private GioiTinh gioiTinh;
    private int tuoi;

    public KhachHang(){

    }

    public KhachHang(String maKhachHang, GioiTinh gioiTinh, int tuoi) {
        this.maKhachHang = maKhachHang;
        this.gioiTinh = gioiTinh;
        this.tuoi = tuoi;
    }

    public KhachHang(GioiTinh gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public GioiTinh getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(GioiTinh gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public int getTuoi() {
        return tuoi;
    }

    public void setTuoi(int tuoi) {
        this.tuoi = tuoi;
    }

    @Override
    public String toString() {
        return "KhachHang{" +
                "maKhachHang='" + maKhachHang + '\'' +
                ", gioiTinh=" + gioiTinh +
                ", tuoi=" + tuoi +
                '}';
    }
}

class NhanVien{
    private String maNhanVien;
    private GioiTinh gioiTinh;
    private Date ngayLamViec;

    public NhanVien(){

    }

    public NhanVien(String maNhanVien, GioiTinh gioiTinh, Date ngayLamViec) {
        this.maNhanVien = maNhanVien;
        this.gioiTinh = gioiTinh;
        this.ngayLamViec = ngayLamViec;
    }

    public String getMaNhanVien() {
        return maNhanVien;
    }

    public void setMaNhanVien(String maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public GioiTinh getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(GioiTinh gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public Date getNgayLamViec() {
        return ngayLamViec;
    }

    public void setNgayLamViec(Date ngayLamViec) {
        this.ngayLamViec = ngayLamViec;
    }
}

class NhanVienBanHang extends NhanVien{
    private CaDangKy caDangKy;

    public NhanVienBanHang(){

    }

    public NhanVienBanHang(String maNhanVien, GioiTinh gioiTinh, Date ngayLamViec, CaDangKy caDangKy) {
        super(maNhanVien, gioiTinh, ngayLamViec);
        this.caDangKy = caDangKy;
    }

    public CaDangKy getCaDangKy() {
        return caDangKy;
    }

    public void setCaDangKy(CaDangKy caDangKy) {
        this.caDangKy = caDangKy;
    }

    @Override
    public String toString() {
        return "NhanVienBanHang{" +
                "caDangKy=" + caDangKy +
                '}';
    }
}

class NhanVienNhapHang extends NhanVien{
    private int thamNien;

    public NhanVienNhapHang(){

    }

    public NhanVienNhapHang(String maNhanVien, GioiTinh gioiTinh, Date ngayLamViec, int thamNien) {
        super(maNhanVien, gioiTinh, ngayLamViec);
        this.thamNien = thamNien;
    }

    @Override
    public String toString() {
        return "NhanVienNhapHang{" +
                "thamNien=" + thamNien +
                '}';
    }
}

class MatHang{
    private String maHoaDon;
    private String tenHangHoa;
    private String phanLoai;
    private double gia;

    public MatHang(){

    }

    public MatHang(String maHoaDon, String tenHangHoa, String phanLoai, double gia) {
        this.maHoaDon = maHoaDon;
        this.tenHangHoa = tenHangHoa;
        this.phanLoai = phanLoai;
        this.gia = gia;
    }

    public String getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public String getTenHangHoa() {
        return tenHangHoa;
    }

    public void setTenHangHoa(String tenHangHoa) {
        this.tenHangHoa = tenHangHoa;
    }

    public String getPhanLoai() {
        return phanLoai;
    }

    public void setPhanLoai(String phanLoai) {
        this.phanLoai = phanLoai;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    @Override
    public String toString() {
        return "MatHang{" +
                "maHoaDon='" + maHoaDon + '\'' +
                ", tenHangHoa='" + tenHangHoa + '\'' +
                ", phanLoai='" + phanLoai + '\'' +
                ", gia=" + gia +
                '}';
    }
}

class HoaDon{
    private String maHoaDon;
    private String maNhanVienBanHang;
    private String maKhachHang;
    private List<MatHang> listMatHang;
    private double tongGia;
    private double gia;
    private Date ngayMua;

    public HoaDon(){

    }

    public HoaDon(String maHoaDon, String maNhanVienBanHang, String maKhachHang, List<MatHang> listMatHang, double tongGia, Date ngayMua) {
        this.maHoaDon = maHoaDon;
        this.maNhanVienBanHang = maNhanVienBanHang;
        this.maKhachHang = maKhachHang;
        this.listMatHang = listMatHang;
        this.tongGia = tongGia;
        this.ngayMua = ngayMua;
    }

    public String getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public String getMaNhanVienBanHang() {
        return maNhanVienBanHang;
    }

    public void setMaNhanVienBanHang(String maNhanVienBanHang) {
        this.maNhanVienBanHang = maNhanVienBanHang;
    }

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public List<MatHang> getListMatHang() {
        return listMatHang;
    }

    public void setListMatHang(List<MatHang> listMatHang) {
        this.listMatHang = listMatHang;
    }

    public double getTongGia() {
        return tongGia;
    }

    public void setTongGia(double tongGia) {
        this.tongGia = tongGia;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public Date getNgayMua() {
        return ngayMua;
    }

    public void setNgayMua(Date ngayMua) {
        this.ngayMua = ngayMua;
    }

    @Override
    public String toString() {
        return "HoaDon{" +
                "maHoaDon='" + maHoaDon + '\'' +
                ", maNhanVienBanHang='" + maNhanVienBanHang + '\'' +
                ", maKhachHang='" + maKhachHang + '\'' +
                ", listMatHang=" + listMatHang +
                ", tongGia=" + tongGia +
                ", gia=" + gia +
                ", ngayMua=" + ngayMua +
                '}';
    }
}

public class Ex6 {
    public static void main(String[] args) {
        KhachHang kh1 = new KhachHang("KH1", GioiTinh.MALE, 21);
        KhachHang kh2 = new KhachHang("KH2", GioiTinh.FEMALE, 22);

        System.out.println(kh1.toString());
        System.out.println(kh2.toString());

        Date date = new Date();
        NhanVienBanHang nv1 = new NhanVienBanHang("NV1", GioiTinh.MALE, date, CaDangKy.SANG);
        NhanVienBanHang nv2 = new NhanVienBanHang("NV2", GioiTinh.FEMALE, date, CaDangKy.CHIEU);

        NhanVienNhapHang nv3 = new NhanVienNhapHang("NV3", GioiTinh.FEMALE, date, 5);
        NhanVienNhapHang nv4 = new NhanVienNhapHang("NV4", GioiTinh.OTHER, date, 2);

        System.out.println(nv1.toString());
        System.out.println(nv2.toString());
        System.out.println(nv3.toString());
        System.out.println(nv4.toString());

        MatHang mh1 = new MatHang("HD1", "Java", "Loai 1", 100);
        MatHang mh2 = new MatHang("HD1", "C++", "Loai 2", 150);

        System.out.println(mh1.toString());
        System.out.println(mh2.toString());

        List<MatHang> listMatHang = new ArrayList<>();
        listMatHang.add(mh1);
        listMatHang.add(mh2);
        HoaDon hd1 = new HoaDon("HD1", "NV1", "KH1", listMatHang, 250, date);
        System.out.println(hd1.toString());
    }
}
