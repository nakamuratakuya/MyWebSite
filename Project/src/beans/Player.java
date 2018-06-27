package beans;

public class Player {
	private int id;
	private String name;
	private String icon;

	private int yakusyokuId;

	private int gamecount;
	private int wincount;

	public Player(int id, String name, String icon) {
		this.id = id;
		this.name = name;
		this.icon = icon;
	}


	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getIcon() {
		return icon;
	}

	public int getYakusyokuId() {
		return yakusyokuId;
	}

	public void setYakusyokuId(int yakusyokuId) {
		this.yakusyokuId = yakusyokuId;
	}


	public int getGamecount() {
		return gamecount;
	}


	public void setGamecount(int gamecount) {
		this.gamecount = gamecount;
	}


	public int getWincount() {
		return wincount;
	}


	public void setWincount(int wincount) {
		this.wincount = wincount;
	}

}
