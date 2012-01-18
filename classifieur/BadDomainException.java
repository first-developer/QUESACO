//  ===================================
//  PROJET QUESACO
//  @autors :   Laura BENDHAIBA
//              Lionel LONKAP TSAMBA
//  ===================================

package classifieur;


import tools.Msg;

// Class: BadDomainException
//========================================================
public final class BadDomainException extends Exception {

	private static final long serialVersionUID = 1L;

	BadDomainException(){
		Msg.puts("Mauvais domaine");
	}
}
