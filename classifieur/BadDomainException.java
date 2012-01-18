package classifieur;

import tools.Msg;

public final class BadDomainException extends Exception {

	private static final long serialVersionUID = 1L;

	BadDomainException(){
		Msg.puts("Mauvais domaine");
	}
}
