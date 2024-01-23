package och10;

// DTO : 데이터 전달하는 객체 단위 (일반적으로 테이블 단위) : 데이터 교환을 위한 Java Bean
	// 자바에서만 쓰면 DTO
	// html에서 끌어와서 쓰면 Java Bean
public class Dept {

	private int depno;
	private String dname;
	private String loc;
	
	public int getDepno() {
		return depno;
	}
	public void setDepno(int depno) {
		this.depno = depno;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	
}
