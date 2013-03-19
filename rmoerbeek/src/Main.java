import org.uva.sea.ql.renderer.MainQL;

/* Main will create a new instance of MainQL, which is a graphical representation of a 
 * questionnaire written in the Domain Specific Language "QL".
 */


public class Main {
	
	public static void main(String[] args) {
		
		/* input arguments
		 * args[0]: Location of the textfile written in QL
		 * args[1]: Location of the output XML file
		 */
		new MainQL(args[0], args[1]);
		
	}

}
