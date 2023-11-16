package exercise1.ex6;

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

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
        return maKhachHang + "," + gioiTinh.toString() + "," + tuoi;
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

    @Override
    public String toString() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String strDate = dateFormat.format(ngayLamViec);
        return maNhanVien + "," + gioiTinh.toString() + "," + strDate;
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
        return super.toString() + "," + caDangKy.toString();
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
        return super.toString() + "," +thamNien;
    }
}

class MatHang{
    private String maHangHoa;
    private String tenHangHoa;
    private String phanLoai;
    private double gia;

    public MatHang(){

    }

    public MatHang(String maHangHoa, String tenHangHoa, String phanLoai, double gia) {
        this.maHangHoa = maHangHoa;
        this.tenHangHoa = tenHangHoa;
        this.phanLoai = phanLoai;
        this.gia = gia;
    }

    public String getMaHangHoa() {
        return maHangHoa;
    }

    public void setMaHangHoa(String maHangHoa) {
        this.maHangHoa = maHangHoa;
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
        return maHangHoa + "," + tenHangHoa + "," + phanLoai + "," + gia;
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
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String strDate = dateFormat.format(ngayMua);
        String listMH = "";
        for(MatHang matHang : listMatHang){
            listMH += matHang.getMaHangHoa() + " ";
        }
        return maHoaDon + "," + maNhanVienBanHang + "," + maKhachHang + "," + listMH + "," + gia + "," + strDate + "]";
    }
}

class MatHangRepository{
    HashMap<String, MatHang> map = new HashMap<>();

    public MatHangRepository(){
        this.map = map;
    }

    public void addMatHang(MatHang matHang){
        map.put(matHang.getMaHangHoa(), matHang);
    }

    public MatHang getMatHang(String maHangHoa){
        return map.get(maHangHoa);
    }
}

class HoaDonRepository{
    HashMap<String, HoaDon> map = new HashMap<>();

    public HoaDonRepository(){
        this.map = map;
    }

    public void addHoaDon(HoaDon hoaDon){
        map.put(hoaDon.getMaHoaDon(), hoaDon);
    }

    public HoaDon getHoaDon(String maHoaDon){
        return map.get(maHoaDon);
    }
}

public class Ex6 {
    static MatHangRepository matHangRepository = new MatHangRepository();
    static HoaDonRepository hoaDonRepository = new HoaDonRepository();
    public static void main(String[] args) throws IOException, ParseException {
        List<NhanVien> listNV = loadNhanVien();
        List<KhachHang> listKH = loadKhachHang();
        List<MatHang> listMH = loadMatHang();
        List<HoaDon> listHD = loadHoaDon();
//        doanhThu();
//        tienKhach();
        deleteRandom(listNV);
    }

    public static List<NhanVien> loadNhanVien() throws IOException, ParseException {
        List<NhanVien> listNV = new ArrayList<>();
        FileReader fr = new FileReader("src/exercise1/ex6/NhanVien.txt");
        BufferedReader bf = new BufferedReader(fr);

        String line;
        while ((line=bf.readLine()) != null){
            String[] str = line.split(",");
            Date date = new SimpleDateFormat("dd/MM/yyyy").parse(str[2]);
            if(str[3].equals(CaDangKy.SANG.toString()) || str[3].equals(CaDangKy.CHIEU.toString()) || str[3].equals(CaDangKy.TOI.toString())){
                NhanVienBanHang nv = new NhanVienBanHang(str[0], GioiTinh.valueOf(str[1]), date, CaDangKy.valueOf(str[3]));
                listNV.add(nv);
//                System.out.println(nv.toString());
            }else{
                NhanVienNhapHang nv = new NhanVienNhapHang(str[0], GioiTinh.valueOf(str[1]), date, Integer.parseInt(str[3]));
                listNV.add(nv);
//                System.out.println(nv.toString());
            }
        }

        return listNV;
    }

    public static List<KhachHang> loadKhachHang() throws IOException {
        List<KhachHang> listKH = new ArrayList<>();
        FileReader fr = new FileReader("src/exercise1/ex6/KhachHang.txt");
        BufferedReader bf = new BufferedReader(fr);

        String line;
        while ((line=bf.readLine()) != null){
            String[] str = line.split(",");
            KhachHang kh = new KhachHang(str[0], GioiTinh.valueOf(str[1]), Integer.parseInt(str[2]));
            listKH.add(kh);
//            System.out.println(kh.toString());
        }

        return listKH;
    }

    public static List<MatHang> loadMatHang() throws IOException {
        List<MatHang> listMH = new ArrayList<>();
        FileReader fr = new FileReader("src/exercise1/ex6/MatHang.txt");
        BufferedReader bf = new BufferedReader(fr);

        String line;
        while ((line=bf.readLine()) != null){
            String[] str = line.split(",");
            MatHang mh = new MatHang(str[0], str[1], str[2], Double.parseDouble(str[3]));
            matHangRepository.addMatHang(mh);
            listMH.add(mh);
//            System.out.println(mh.toString());
        }

        return listMH;
    }

    public static List<HoaDon> loadHoaDon() throws IOException, ParseException {
        List<HoaDon> listHD = new ArrayList<>();
        loadMatHang();
        FileReader fr = new FileReader("src/exercise1/ex6/HoaDon.txt");
        BufferedReader bf = new BufferedReader(fr);

        String line;
        while ((line=bf.readLine()) != null){
            String[] str = line.split(",");
            Date date = new SimpleDateFormat("dd/MM/yyyy").parse(str[5]);
            String[] listStr = str[3].split(" ");
//            System.out.println(Arrays.stream(listStr).toList());
            List<MatHang> listMatHang = new ArrayList<>();
            double gia = 0.0;
            for (String s : listStr){
                listMatHang.add(matHangRepository.getMatHang(s));
                gia += matHangRepository.getMatHang(s).getGia();
            }
//            System.out.println(gia + " " + str[4]);
//            System.out.println(Double.parseDouble(str[4]));
            HoaDon hd = new HoaDon(str[0], str[1], str[2], listMatHang, gia, date);
            hd.setGia(gia);
//            System.out.println(hd.getGia());
            listHD.add(hd);
            hoaDonRepository.addHoaDon(hd);
        }

        return listHD;
    }

    public static void doanhThu() throws IOException, ParseException {
        List<HoaDon> listHD = loadHoaDon();
        Map<String, Double> doanhThu = new HashMap<>();
        for(HoaDon hoaDon : listHD){
            String maNhanVien = hoaDon.getMaNhanVienBanHang();
//            System.out.println(hoaDon.getGia());
            doanhThu.put(maNhanVien, doanhThu.getOrDefault(maNhanVien, 0.0) + hoaDon.getGia());
        }

        System.out.println("Doanh thu cua moi nhan vien: ");
        for(Map.Entry<String, Double> entry : doanhThu.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue() + "VND");
        }
    }

    public static void tienKhach() throws IOException, ParseException {
        List<HoaDon> listHD = loadHoaDon();
        Map<String, Double> tienKhach = new HashMap<>();
        for(HoaDon hoaDon : listHD){
            String maKhachHang = hoaDon.getMaKhachHang();
            Date ngayMua = hoaDon.getNgayMua();
            Date now = new Date();

            if(ngayMua.getMonth() == now.getMonth()) {
                tienKhach.put(maKhachHang, tienKhach.getOrDefault(maKhachHang, 0.0) + hoaDon.getGia());
            }
        }

        System.out.println("So tien khach chi tieu trong thang nay: ");
        for(Map.Entry<String, Double> entry : tienKhach.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue() + "VND");
        }
    }

    public static <T> void deleteRandom(List<T> list) throws IOException {
        Random rand = new Random();
        T randomElement = list.get(rand.nextInt(list.size()));
        list.remove(randomElement);
        T element = list.get(rand.nextInt(list.size()));
        String path = "";
        if(element instanceof KhachHang){
            path = "KhachHang.txt";
        } else if (element instanceof MatHang) {
            path = "MatHang.txt";
        } else if (element instanceof HoaDon) {
            path = "HoaDon.txt";
        } else if (element instanceof NhanVien) {
            path = "NhanVien.txt";
        }

        FileWriter fw = new FileWriter("src/exercise1/ex6/" + path);
        BufferedWriter bw = new BufferedWriter(fw);

        for (T e : list){
            bw.write(e.toString() + "\n");
        }

        bw.close();
    }
}
