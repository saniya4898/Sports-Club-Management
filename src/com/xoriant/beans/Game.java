package com.xoriant.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="game")
public class Game {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="game_id")
	private Integer gameId;
	@Column(name="game_name")
	private String gameName;
	
	public Game() {
		// TODO Auto-generated constructor stub
	}

	public Game(String gameName) {
		super();
		this.gameName = gameName;
	}

	public Integer getGameId() {
		return gameId;
	}

	public void setGameId(Integer gameId) {
		this.gameId = gameId;
	}

	public String getGameName() {
		return gameName;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

	@Override
	public String toString() {
		return "Game [gameId=" + gameId + ", gameName=" + gameName + "]";
	}
	
}
