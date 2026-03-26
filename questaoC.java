public class questaoC {

    public static int contarOcorrencias(String s, char c) {
        if (s == null || s.isEmpty()) {
            return 0;
        }

        int contagem = (s.charAt(0) == c) ? 1 : 0;
        
        return contagem + contarOcorrencias(s.substring(1), c);
    }
}