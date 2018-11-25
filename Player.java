/*
 * Globalcode - "The Developers Company"
 * 
 * Academia do Java
 * 
 * Jogo da Forca versão Orientada a Objeto
 * Classe Player
 *
 * @autor : Franklin
 * @data: 10/30/2018
 * @version: 1.0 - Incial 
			 1.1 - introduce creator whit @namePlayer
 */

import java.util.Scanner; 
 
class Player {

    private String namePlayer;
    private int pointPlayer;
	private int levelGame;
	private int stageGame; 
	private int maxPointPlayer;

    /**
     * @param namePlayer
     *            name of the player;
     * @param pointPlayer
     *            total points of the player;
	 * @param levelGame
     *            the level is the game;
	 * @param stageGame
     *            the stage is the game;
	 * @param maxPointPlayer
     *            maximus erros that player can to have	 
     */
    
	public Player(String namePlayer) {
		this.setNamePlayer(namePlayer);		
	}
	
	void initializePlayer(int pointPlayer, int levelGame, int stageGame, int maxPoint) {
        //this.namePlayer = this.getNamePlayer();
        this.pointPlayer = pointPlayer;
		this.maxPointPlayer = maxPoint;
		this.levelGame = levelGame;
		this.stageGame = stageGame;
    }

    /**
     * Method to getting any inf of the player
     **/
    public String getInputPlayer(String msgString) {
		Scanner attempts = new Scanner(System.in);
		System.out.print(msgString);
		return attempts.next();       
    }
	
	/**
        setter player name
     **/	 
	void setNamePlayer(String namePlayer){
		this.namePlayer = namePlayer;
	}
		
	/**
		getter player name
     **/
	public String getNamePlayer(){
		return namePlayer;
	}
	
	/**
         setter the maximum point to the player
     **/
	public void setMaxPointPlayer( int maxPoint){
		this.maxPointPlayer = maxPoint;		
	}
	
	/**
        getter the maximum point to the player
     **/
	int getMaxPointPlayer(){
		return maxPointPlayer;		
	}
		
	/**
        add point of the player
    **/
	public boolean addPointPlayer(int addPoint) {
		this.pointPlayer += addPoint;
		if ( pointPlayer >= maxPointPlayer) 
			return true;
		return false;
	}
	
	/**
         substract point of the player
    **/
	public void subtractPointPlayer(int SubstractPoint) {
		this.pointPlayer -= SubstractPoint;		
	}
	
	/**
         reset Point player attempts of the player
    **/
	public void resetPointPlayer() {
		this.pointPlayer = 0;		
	}
	
	/**
        getter total points of the player
     **/
	int getPointPlayer(){
		return pointPlayer;
	}
	
	/**
        add level game of the player
     **/
	void addLevelPlayer(){
		this.levelGame++;
	}

	/**
         getter level game of the player
     **/
	int getLevelGame(){
		return levelGame;
	}

	/**
        add Stage of the game 
     **/
	void addStageGame(){
		this.stageGame++;
	}

	/**
		getter Stage of the game
     **/
	int getStageGame(){
		return stageGame;
	}

}