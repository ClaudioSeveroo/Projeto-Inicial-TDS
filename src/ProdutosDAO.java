
import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.ArrayList;


public class ProdutosDAO {
    
    Connection conn;
    PreparedStatement prep;
    ResultSet resultset;
    ArrayList<ProdutosDTO> listagem = new ArrayList<>();
    
    public void cadastrarProduto (ProdutosDTO produto){
        
        
        conn = new conectaDAO().connectDB();
        String sql = "INSERT INTO produtos(nome, valor, status) VALUES "
                        + "(?, ?, ?)"; 
                    try {
                        PreparedStatement stmt = this.conn.prepareStatement(sql);
                        stmt.setString(1, produto.getNome());
                        stmt.setInt(2, produto.getValor());
                        stmt.setString(3, produto.getStatus());
                        stmt.execute();  
                        JOptionPane.showMessageDialog(null, "Cadastro Realizado com Sucesso!", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
                        
                    } catch (Exception e) {
                        System.out.println("Erro ao inserir funcionario: " + e.getMessage());
                    }
        
    }
    
    public ArrayList<ProdutosDTO> listarProdutos(){
        
        return listagem;
    }
    
    
    
        
}

