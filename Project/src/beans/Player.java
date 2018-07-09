package beans;

public class Player {
	private int id;
	private String name;
	private String icon;

	private int yId;
	private String yName;
	private String yComment;
	private String yIcon;
	private String yDetail;

	private int votedCount;
	private String votePlayerName;
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




	public int getyId() {
		return yId;
	}


	public void setyId(int yId) {
		this.yId = yId;
	}


	public String getyName() {
		return yName;
	}


	public void setyName(String yName) {
		this.yName = yName;
	}


	public String getyComment() {
		return yComment;
	}


	public void setyComment(String yComment) {
		this.yComment = yComment;
	}


	public String getyIcon() {
		return yIcon;
	}


	public void setyIcon(String yIcon) {
		this.yIcon = yIcon;
	}


	public String getyDetail() {
		return yDetail;
	}


	public void setyDetail(String yDetail) {
		this.yDetail = yDetail;
	}


	public int getVotedCount() {
		return votedCount;
	}


	public void setVotedCount() {
		this.votedCount++;
	}


	public String getVotePlayerName() {
		return votePlayerName;
	}


	public void setVotePlayerName(String votePlayerId) {
		this.votePlayerName = votePlayerId;
	}

}
