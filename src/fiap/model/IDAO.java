/**Interface para os objetos de todas as classes DAO
 * @author Luis Felipe
 * @version 1.0
 * @since 11/11/2022
 */
package fiap.model;

public interface IDAO {
	
	public String inserir(Object obj);
	
	public String alterar(Object obj);
	
	public String excluir(Object obj);

}
