package AugustoFeltrin.Aula04;

public class ExercicioB {
	public static boolean palindromo(String palavra) {
		if(palavra.length() == 1) {
			return true;
		}
		
		if(palavra.charAt(0) == palavra.charAt(palavra.length() - 1)) {
			return palindromo(palavra.substring(1, palavra.length() - 1));
		}
		
		return false;
	}
	
	public static void main(String args[]) {
		String palavra = "ovo";
		System.out.println(palavra + " é palindromo? " + palindromo(palavra));
	}
}
