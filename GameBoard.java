/*
 * Globalcode - "The Developers Company"
 * 
 * Academia do Java
 * 
 * Jogo da Forca versão Orientada a Objeto
 * Classe ScreenGame
 *
 * Tela de exibição do jogo.
 * @
 *	
 * @autor : Franklin
 * @data: 11/03/2018
 * @version: 1.0
 */

 
class GameBoard {
	
	private String namePlayer;
	private int hits;
	private int misses;	
	private String message;
	private String[] listWords;
	private int maximumWords;	
	
	
	Format umformat = new Format();
	
	/*
	   setter game board
	*/
	public GameBoard( String namePlayer, String mensageToPlayer, String[] listWords, int maximumWords){
				
		this.setNamePlayer(namePlayer);
		this.setMessage(mensageToPlayer);				
		this.listWords = listWords;		
		this.maximumWords = maximumWords;
		this.screenGame();	
	}	
	
	/*
	   update board Game Complete
	*/
	void updateBoard(String messageToPlayer,  String[] listWords, int hitsPlayer, int missesPlayer) {		
		this.updateBoard(messageToPlayer, listWords);		
		this.setHits(hitsPlayer);
		this.setMisses(missesPlayer);
		//this.screenGame();
	}
		
	/*
	   update board Game message and listWords
	*/
	void updateBoard(String messageToPlayer,  String[] listWords) {		
		this.setMessage(messageToPlayer);
		this.listWords = listWords;		
	}
		
	/*
	   setter message To Player
	*/
	void setMessage(String messageToPlayer) {
		this.message = messageToPlayer;
	}
	
	/*
	   setter name player
	*/
	void setNamePlayer(String namePlayer) {
		this.namePlayer = namePlayer;
	}
	
	/*
	   setter hits player
	*/
	void setHits(int hitsPlayer) {
		this.hits = hitsPlayer;
	}	
	
	/*
	   setter misses player
	*/
	void setMisses(int missesPlayer) {
		this.misses = missesPlayer;
	}	
		
	/*
	   setter listUsedWords
	*/
	void setListWords(String[] listWords) {
		this.listWords = listWords;
	}
	
	
	public void helpGame(){
	   
		umformat.formatLine();		
		System.out.println ("\n" + umformat.formatCenterText("- Jogo das Palavras - Versao Orientada a Objeto" + "\n")); 		 
		System.out.println ("Este e um jogo de adivinhar as 50 palavras reservadas do java"); 
		System.out.println ("O tempo para adivinhar todas e 5 minutos."); 		
		System.out.println ("Para tela de ajuda digite [2]. \tPara sair digite [9].\n");
		System.out.println (umformat.formatCenterText("B O A  S O R T E"));
		umformat.formatLine();
		
	}							
	
	public void printListWord(String[] listWords){
		int sizeList = listWords.length;
				
		for (int y = 0; y < sizeList; y++){		
			if (y%5 == 0) {System.out.println();}
			System.out.print(listWords[y] + "\t");	
		}
		System.out.println();
	}
	
	public void screenGame() {
	
		umformat.formatLine();
		String[] listUsed = listWords; 	 
		
		System.out.println (umformat.formatCenterText("- Jogo das Palavras -")+"\n"); 
		
		printListWord(listWords);		
			
		System.out.printf("\nJogador[%s]\t acertos[%d/%d] \tErros [%d]\n", 
							namePlayer, hits, maximumWords,misses);			
		
		String text_formatted = "Para ajuda digite [2] Para sair digite [9]\n\n"; 
		System.out.printf(umformat.formatRightText(text_formatted));
		System.out.printf("[%s]\n", message); 
  }  
     
 public void screenGame(String[] toShow) {
	
		umformat.formatLine();		 		
		System.out.println (umformat.formatCenterText("- Jogo das Palavras -"));		
		this.printListWord(toShow);		
		umformat.formatLine();
		
		
  }  
  
  
}