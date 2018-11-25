/*
 * Globalcode - "The Developers Company"
 * 
 * Academia do Java
 * 
 * Jogo das Plavras versão Orientada a Objeto
 * Classe HandlerWords
 *
 * Manipulação da palavra selecionada para o jogo
 * @handlerMaskWord() - manibula a mascara da palavra, retorna palavra com mascara nas letras não adivinhadas;
 * @checkAttemptWord() - verifica se acertou a palavra, retorna boolean; 
 *	
 * @autor : Franklin
 * @data: 11/02/2018
 * @version: 1.0
 */

 
class HandlerWords {
	
	private String[] tempMaskList;
	private String[] listSelected;
	private String[] hitsList;
	private String[] missesList;
	private int sizeList;
	private int countSucess;
	private int countErrs;
	private int sizeWordLargest;
	
	
	/*
		class creater
		@listSelected - List are in the game;List are in the game
		@typeMask - What prototype of the (mask) ex: (*): *** / (#): ### / (-): ---
		
		And create a temporary list of words with a mask.
	*/
	public HandlerWords(String[] listSelected, char typeMaskWord) {      
		
		sizeWordLargest = 0;
		countSucess = 0;
		countErrs = 0;		
        this.sizeList = listSelected.length;		
		this.listSelected = listSelected;		
		this.tempMaskList = new String[sizeList];
		this.createListMask(sizeList, typeMaskWord);		
	}
	
	/*
		create temporary list mask
	*/
	
	private void createListMask(int size, char typeMaskWord){		
		String tempWord;	
		int sizeWord;		
		for (int y = 0; y < sizeList; y++){
			sizeWord = listSelected[y].length();
			
			if(sizeWordLargest < sizeWord) {
				sizeWordLargest = sizeWord; //Load the largest word size
			}
			
			tempWord = "";
			for(int x = 0; x < sizeWord; x++)
				tempWord += typeMaskWord;
 			
			tempMaskList[y] = tempWord;
		}				
	}
	
	/* 
		getter list of hits words;
	*/
	public String[] getHitsWords(){
		this.loadHitsMissesList();
		
		return hitsList; 			
	}
	
	/* 
		getter list of misses words;
	*/
	public String[] getMissesWords(){
		this.loadHitsMissesList();
		
		return missesList; 			
	}
	
	/* 
		Load hits and misses lists;
		@hitsList[] hits words;
		@missesList[] misses words;
	*/
	private void loadHitsMissesList(){
		
		int tmpHitsSize = 0;
		int tmpMissesSize = 0;
		String[] tmpHitsList = new String[sizeList];
		String[] tmpMissesList = new String[sizeList];
		
		for(int x = 0; x < sizeList; x++){			
			if( tempMaskList[x] == listSelected[x]) {
				tmpHitsList[tmpHitsSize++] = listSelected[x];				
			} 
			else {
				tmpMissesList[tmpMissesSize++] = listSelected[x];					
			}			
		}
		
		this.hitsList = new String[tmpHitsSize];		
		for(int y = 0; y < tmpHitsSize; y++){
			this.hitsList[y] = tmpHitsList[y];		
		}
		
		this.missesList = new String[tmpMissesSize];
		for(int z = 0; z < tmpMissesSize; z++) {
			this.missesList[z] = tmpMissesList[z];	
		}
	}
			
	/*
		getter largest size word
		this is used to create screen board
	*/			  	
	public int getSizeWordLargest() {			
		return sizeWordLargest;
	}
	
	/*
		getter tempMaskList
	*/			  	
	public String[] getMaskList() {			
		return tempMaskList;
	}
	
	/*
		getter numberSuccess
	*/
	public int getcountSucess() {
		return countSucess;
	}
	
	/*
		getter countErrs
	*/
	public int getcountErrs() {
		return countErrs;
	}
	
	/* 
		Analyze the hint:
		
			@answer default return: "Missed"
			if hint is correct  return: "Okey" and remove the mask of the keyword;
			if the hint already been used return: "Repeated"
			if the hint '2' return: "Help"
			if the hint '9'return: "Quit"
			//if any error return: "@Error"
			// not implemented yet! if number (without 2 and 9) return "numeral"	
	*/
	
	public String checkAttemptWord(String attempt) {
		//String wordAttempt = attempt.toLowerCase();  //equalsIgnoreCase(attempt)
		String test;
		String answer = "Missed";		
		
		//System.out.println("wordAttempt: "+wordAttempt);		
		// '2' for help
		if ("2".equalsIgnoreCase(attempt)){
			answer = "Help";	
		}
		// '9' to quit the game.
		else if ("9".equalsIgnoreCase(attempt)){
			answer = "Quit";	
		}			
		else {				
			// check if the word is correct		
			
            for( int y = 0; y < sizeList;y++){				
				//System.out.println("-> " + listSelected[y]);	
				// word already used.
				if (tempMaskList[y].equalsIgnoreCase(attempt)) {					
					answer = "Repeated";
					break;
				}
				//find!
				else if (listSelected[y].equalsIgnoreCase(attempt)){			
					answer = "Okey";
					tempMaskList[y] = listSelected[y];					
					countSucess++;
					break;
				}							
			}
			//Finished the survey. If didn't hit the letter, count the error;
			if (answer == "Missed") countErrs++;		
		}	
		return answer;
	}
	
}
	