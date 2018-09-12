package persistence;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import padraomemento.Aluno;

public class AlunoDAO {

    private static AlunoDAO instance = new AlunoDAO();
    public static AlunoDAO getInstance() {
        return instance;
    }
    
    public void save(Aluno aluno) throws SQLException, ClassNotFoundException{
        Connection conn = null;
        Statement st = null;
        
        try{
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("insert into aluno(nome) values ('"+ aluno.getNome() +"')");
        } catch(SQLException e){
            throw e;
        } finally{
            closeResources(conn, st);
        }
    }
    
   /* public void load(Aluno aluno) throws SQLException, ClassNotFoundException{
        Connection conn = null;
        Statement st = null;
        
        try{
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            ResultSet resultado = st.executeQuery("select email from aluno where nome='"+aluno.getNome()+"'");
            while (resultado.next())
            {
                String email = resultado.getString("email");
                aluno.setEmail(email);
            }
        } catch(SQLException e){
            throw e;
        } finally{
            closeResources(conn, st);
        }
    
    }
    
    public void change (Aluno aluno) throws SQLException, ClassNotFoundException{
        Connection conn = null;
        Statement st = null;
        
        try{
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("update aluno set email='"+aluno.getEmail()+"' where nome='"+aluno.getNome()+"'");
        } catch(SQLException e){
            throw e;
        } finally{
            closeResources(conn, st);
        }
    }
    
    public void delete(Aluno aluno) throws SQLException, ClassNotFoundException{
        Connection conn = null;
        Statement st = null;
        
        try{
            conn = DatabaseLocator.getInstance().getConnection();
            st = conn.createStatement();
            st.execute("delete from aluno where nome='"+aluno.getNome()+"'");
        } catch(SQLException e){
            throw e;
        } finally{
            closeResources(conn, st);
        }
    
    }*/
    
    public void closeResources (Connection conn, Statement st)
    {
        try{
            if(st!=null) st.close();
            if(conn!=null) conn.close();
        }
        catch (SQLException e){
        
        }
    }
}