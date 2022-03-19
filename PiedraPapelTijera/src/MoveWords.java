import java.util.Random;

public class MoveWords{

    public static final int EMPATE = 0;
    public static final int GANA = 1;
    public static final int PIERDE = 2;

    private static final String[] validMoves = {"TIJERAS", "PAPEL", "PIEDRA", "SEPIA", "TORITO"};
    private static final String[] validCommands = {"SALIR", "HELP"};

    private Random rnd;
    
    public MoveWords(){
    	rnd = new Random();
    }
    
    public boolean isValidMoveCommand(String value){

	    for (int i =0; i< validMoves.length; i++){
	        if(validMoves[i].equals(value))
	    	    return true;
	    }
	    
	    for (int i =0; i< validCommands.length; i++){
	        if(validCommands[i].equals(value))
		        return true;
	    }
	    
	    return false;
    }

    public String randomMove(){
	    float p = rnd.nextFloat();
	    return validMoves[ (int) (p * validMoves.length)];
    }

    public void showMoves(){
        for (String move : validMoves)
	        System.out.print(move+" ");
	    System.out.println();
    }
    public void showCommands(){
	    for (String cmd : validCommands)
	        System.out.print(cmd+" ");
	    System.out.println();
    }

    public void showWords(){
        showMoves();
        showCommands();    
    }

    private static int getIndex(String value){
	    for (int i =0; i< validMoves.length; i++){
	        if(validMoves[i].equals(value))
		        return i;
	    }
    	return -1;
    }

    public static int checkWinner(String first, String second){
	    int first_i, second_i;

	    first_i = getIndex(first);
	    second_i = getIndex(second);

	    
	    
	    if (first.equals("TIJERAS") && second.equals("PAPEL")) return GANA;
	    if (first.equals("TIJERAS") && second.equals("PIEDRA")) return PIERDE;
	    if (first.equals("TIJERAS") && second.equals("SEPIA")) return PIERDE;
	    if (first.equals("TIJERAS") && second.equals("TORITO")) return GANA;
	    
	    
	    if (first.equals("PAPEL") && second.equals("TIJERAS")) return PIERDE;
	    if (first.equals("PAPEL") && second.equals("PIEDRA")) return GANA;
	    if (first.equals("PAPEL") && second.equals("SEPIA")) return GANA;
	    if (first.equals("PAPEL") && second.equals("TORITO")) return PIERDE;
	    
	    if (first.equals("PIEDRA") && second.equals("TIJERAS")) return GANA;
	    if (first.equals("PIEDRA") && second.equals("PAPEL")) return PIERDE;
	    if (first.equals("PIEDRA") && second.equals("SEPIA")) return PIERDE;
	    if (first.equals("PIEDRA") && second.equals("TORITO")) return GANA;
	    
	    if (first.equals("SEPIA") && second.equals("TIJERAS")) return GANA;
	    if (first.equals("SEPIA") && second.equals("PAPEL")) return PIERDE;
	    if (first.equals("SEPIA") && second.equals("PIEDRA")) return GANA;
	    if (first.equals("SEPIA") && second.equals("TORITO")) return PIERDE;
	    
	    if (first.equals("TORITO") && second.equals("TIJERAS")) return PIERDE;
	    if (first.equals("TORITO") && second.equals("PAPEL")) return GANA;
	    if (first.equals("TORITO") && second.equals("PIEDRA")) return PIERDE;
	    if (first.equals("TORITO") && second.equals("SEPIA")) return GANA;
	    
	    else return EMPATE;
	    
	    //return (( (first_i +1) % validMoves.length ) == second_i ) ? GANA: PIERDE;
	}
	
} 
