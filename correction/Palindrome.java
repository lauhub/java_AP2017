package fr.viacesi.pau.ap2017;

public class Palindrome {
	public static void main(String[] args) {
		Palindrome p = new Palindrome();
		System.out.println(p.estPalindrome("abcdedcba"));
		System.out.println(p.estPalindrome("abcdefcba"));
		System.out.println(p.estPalindrome("abcdeedcba"));
		System.out.println(p.estPalindrome("abcdefdcba"));
	}
	
	/**
	 * Renvoie true si la chaîne donnée en paramètre est 
	 * un palindrome
	 * @param chaine la chaîne à tester
 	 * @return true si palindrome, false sinon
	 */
	boolean estPalindrome(String chaine){
		/*
		 * Si j'ai un palindrome, les caractères
		 * sont positionnés en miroir
		 * 
		 *           abcdedcba
		 *           ^^ ^ ^ ^^
		 *           || |_| ||
		 *           ||_____||
		 *           |_______|
		 *
		 * L'index du dernier caractère correspond à la longueur 
		 * de la chaîne moins un
		 * L'index de l'avant dernier caractère correspond à la 
		 * longueur de la chaine moins deux
		 * 
		 * Donc l'index miroir de l'index i est : 
		 * indexMiroir = chaine.length() - 1 -i 
		 */
		char droite = 'a', gauche = 'b';
		boolean palindrome = false;
		int i = 0;
		int indexMiroir = chaine.length() - 1 - i ;
		
		while (i < indexMiroir) {
			droite = chaine.charAt(indexMiroir);
			gauche = chaine.charAt(i);
			palindrome = (gauche == droite);
			if (! palindrome){
				break ;
			}
			i ++;
			indexMiroir = chaine.length() - 1 - i ;
		}
		return palindrome ;
	}
}


