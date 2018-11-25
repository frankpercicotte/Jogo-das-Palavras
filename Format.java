/*
 * Globalcode - "The Developers Company"
 * 
 * Academia do Java
 * 
 * Jogo da Forca versão Orientada a Objeto
 * Classe Format
 *
 * Formatação em geral.
 * @
 *	
 * @autor : Franklin
 * @data: 11/15/2018
 * @version: 1.0
 */

 
class Format { 
	
	// Define os valores default, no caso de usar construtor sem carregar os atributos.
	private String separeterFist = "[";
	private String separeterLast = "]";	
	private int biggestWord;	
	
	private char typeCharacter;
	private byte numberCharacter;
	
	
	/* 
		Construtor completo 
		@separeterFist - Primeiro caracter para abrir a coluna;
		@separeterLast - Ultimo caracter para fechar a coluna;
		@biggestWord - Tamanho da maior palavra;		
		@typeCharacter - Tipo de caracter para formatar linha;
		@numberCharacter - Quantos caracteres numa linha (== tamanho da linha);
	*/
	public Format(String separeterFist, String separeterLast, int biggestWord,  
					char typeCharacter, byte numberCharacter) {
						
		this(separeterFist,separeterLast,biggestWord);
		this.typeCharacter = typeCharacter;
		this.numberCharacter = numberCharacter;			
	}
		
	public Format(String separeterFist, String separeterLast, int biggestWord) {
		this(biggestWord);
		this.separeterFist = separeterFist;
		this.separeterLast = separeterLast;			
	}
	
	public Format(int biggestWord) {		
		this.biggestWord = biggestWord;		
	}	
	
	public Format(char typeCharacter, byte numberCharacter){
		this.typeCharacter = typeCharacter;
		this.numberCharacter = numberCharacter;
	}
	
	public Format() {		
		separeterFist = "[";
		separeterLast = "]";					
		typeCharacter = '-';
		numberCharacter = 90;		
	}	
		
	public String[] formatList(String[] stringList){
	
		String tmpString = "";			
		int sizeList = stringList.length;
		String[] formattedList = new String[sizeList];		
			
		for( int y = 0; y < sizeList; y++) {			
			tmpString = formatList(stringList[y]);			
			formattedList[y] = tmpString ;	
		}		
		return formattedList;
	}
		
		
	public String formatList(String stringWord){
	
		String formattedWord = "";			
		String initialSpace = "";			
		String finalSpace = "";
		String tmpString = separeterFist;
		
		int sizeWord = stringWord.length();		
		int initialSizeSpace = (biggestWord - sizeWord) /2;			
		int finalSizeSpace = biggestWord - (sizeWord + initialSizeSpace);		 
				
		for(int i = 0; i < biggestWord; i++) {
			initialSpace += (i < initialSizeSpace) ? " " : ""; 
			finalSpace += (i >= (initialSizeSpace + sizeWord)) ? " " : "";			
		}
		
		formattedWord = separeterFist + initialSpace + stringWord + finalSpace + separeterLast;			
		
		return formattedWord;
	}	
				
	
	/* 
		Format to generic menssage.
	*/
	public void genericMessage(String text) {
	formatLine();		
	System.out.print(formatCenterText(text));
	formatLine();	
	}  


	
	/* 
	Set type character (ex.: '*' or '#'..) and quantity number of character in line.
	*/
	public void setTypeCharacterAndNumber(char typeCharacter, byte numberCharacter){
		this.typeCharacter = typeCharacter;
		this.numberCharacter = numberCharacter;
	} 

	/* 
		Only character line
	*/
	public void formatOnlyLine() {
				
		for( int y = 0; y < numberCharacter; y++)
			System.out.print(typeCharacter);
		System.out.println();	
		
	}
	
	void formatLine() {
		char Character = typeCharacter;
		System.out.println();		
		this.formatOnlyLine();
			
	}
	
	String formatCenterText(String text){
		int sizeText = text.length();
		int sizeCenter = (numberCharacter - sizeText) / 2;
		
		String formattedText = "";

		for( int y = 0; y < sizeCenter; y++) 
			formattedText += " ";

		return formattedText + text;	
	}

	String formatRightText(String text){
		int sizeText = text.length();
		int sizeRight = (numberCharacter - sizeText);
		
		String formattedText = "";
		for( int y = 0; y < sizeRight; y++) 
			formattedText += " ";

		return formattedText + text;	
	}
}	