public class JogoPalavras {
	
	static boolean theGame = true;
	static String messageToPlayer;
	static int sucessPlayer;
    static int errorPlayer;
	static int sizeList;
	static long secTime;
    static long minTime;
	
	
  public static void main(String[] args) {
  
    String listStage[] = {
			"abstract","assert","boolean","break","byte",
			"case","catch","char","class","const",
			"continue","default","do","double","else",
			"enum","extends","final","finally","float",
			"for","goto","if","implements","import",
			"instanceof","int","interface","long","native",
			"new","package","private","protected","public",
			"return","short","static","strictfp","super",
			"switch","synchronized","this","throw","throws",
			"transient","try","void","volatile","while"			
		};
	
  
   java.util.Scanner sc = new java.util.Scanner(System.in);
   String inputPlayer;  
   double initialTime = System.currentTimeMillis();
   double elapsedTime = System.currentTimeMillis();   
   String resultAttempt;
   sizeList = listStage.length;
   int timeToPlay = 5;  
  
   
   HandlerWords handler = new HandlerWords(listStage,'#');   
   int sizeWordLargest = handler.getSizeWordLargest();
   String[] maskList;
   
   Format umFormat = new Format(sizeWordLargest);   
   
   System.out.print("Nome do Jogador: ");
   String namePlayer = sc.next();
   Player player = new Player(namePlayer);
   
   String mensageToPlayer = "Bem vindo ao jogo das Palavras - BOA SORTE ";
   maskList = umFormat.formatList(handler.getMaskList());
   GameBoard board = new GameBoard(namePlayer, mensageToPlayer, maskList, sizeWordLargest);
   board.helpGame();
   
      while(theGame) {
				
		inputPlayer = player.getInputPlayer("Entre com a palavra: ");
		elapsedTime = System.currentTimeMillis();	
				
		//Analyzer hit	
		resultAttempt = handler.checkAttemptWord(inputPlayer);
		
		// Check Actions to do;
		checkActions(resultAttempt, inputPlayer);								
		
		checkTime(initialTime,elapsedTime);
		
		System.out.printf("%02d:%02d%n",minTime,secTime);
		
		if (minTime >= timeToPlay) {
			messageToPlayer = "time out!";			
			break;
		}
		if (sizeList == handler.getcountSucess()) {
			messageToPlayer = "Voce acertou todas as palavras P A R A B E N S";
			break;
			
		}
		showboard(handler, umFormat, board);		
	}	
	
	sucessPlayer = handler.getcountSucess();
	errorPlayer = handler.getcountErrs();  
	showListFinal(handler, umFormat, board);
	
	checkTime(initialTime,elapsedTime);		
	System.out.printf("\nAcertos: %s /%s | Erros: %s\ntempo usado: %02d:%02d minutos.",sucessPlayer,sizeList,errorPlayer,minTime,secTime);
	  
  }
  
  public static void checkTime(double initialTime, double elapsedTime) {
	secTime = (long)((elapsedTime - initialTime) / 1000) % 60; // Converte mili em seg.
	minTime = (long)((elapsedTime - initialTime) / 60000) % 60; // Converte mili em min.	  
  }
   
  public static void showListFinal(HandlerWords handler, Format umFormat, GameBoard board){
	  	
	String[] hitsWords = umFormat.formatList(handler.getHitsWords());	
	umFormat.formatOnlyLine();
	System.out.printf("Palavras acertadas [%s/%s]:\n",sucessPlayer,sizeList);
	board.screenGame(hitsWords);
	
	String[] missesWords = umFormat.formatList(handler.getMissesWords());
	umFormat.formatOnlyLine();
	System.out.printf("Palavras nao escolhidas [%s/%s]:\n",(sizeList-sucessPlayer),sizeList);
	board.screenGame(missesWords);   	  
	
  }
  
  
  public static void showboard(HandlerWords handler, Format umFormat, GameBoard board){
	String[] maskList = umFormat.formatList(handler.getMaskList());	
	board.updateBoard(messageToPlayer,  maskList, sucessPlayer, errorPlayer);
	board.screenGame(); 	  
  }
  
  
  public static String  checkActions(String resultAttempt, String inputPlayer){
	switch(resultAttempt) {					
			case "Okey":
				messageToPlayer = "Acertou!";			
				break;
			
			case "Missed":
				messageToPlayer = "A palavra "+ inputPlayer +" nao e reservada do java!";
				break;
			
			case "Repeated":
				messageToPlayer = "A "+ inputPlayer + " ja foi usada!";				
				break;
			
			case "Help":
				messageToPlayer = "Help ainda nao implementado!";				
				break;			
			
			case "Quit":
				messageToPlayer = "Saindo do jogo - Tchau!";
				theGame = false;				
				break;				
			
			case "Numeral":
				messageToPlayer = "Numero somente valido 9 para sair";				
				break;				
			
			default:				
				messageToPlayer = "Ops alguma coisa deu MUITO errado! Saindo. Palavra [" + resultAttempt + "]";
				theGame = false;			
		}
		return messageToPlayer;
	}  
  
}
