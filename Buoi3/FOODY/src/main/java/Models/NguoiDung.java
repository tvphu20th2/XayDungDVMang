package Models;

public class NguoiDung {
	int id;
	String tendangnhap;
	public NguoiDung(int id, String tendangnhap) 
	{
		super();
		this.id = id;
		this.tendangnhap = tendangnhap;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTendangnhap() {
		return tendangnhap;
	}
	public void setTendangnhap(String tendangnhap) {
		this.tendangnhap = tendangnhap;
	}
}
