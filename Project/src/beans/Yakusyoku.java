package beans;

public class Yakusyoku {
	private int id;
	private String name;
	private String side;
	private String detail;
	private String comment;
	private String icon;

	public Yakusyoku(int id,String name,int side,String detail, String comment, String icon) {
		this.id = id;
		this.name = name;

		//市民側
		if(side==0) {
			this.side = "市民側";
		}
		
		//人狼側
		else if(side==1) {
			this.side = "人狼側";
		}

		//第三勢力
		else if(side==2) {
			this.side = "第三勢力";
		}

		this.detail = detail;
		this.comment = comment;
		this.icon = icon;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSide() {
		return side;
	}
	public void setSide(String side) {
		this.side = side;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
}

