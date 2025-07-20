package controledao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import modelo.Aluno;
import modelo.exceptions.NotExistException;

/**
 *
 * @author RaFaEl
 */
public class ControleAluno {

    private void verificaCurso(Aluno a)
            throws SQLException, NotExistException {

        List<String> listaSigla = getSiglas();
        boolean exist = false;

        for (String s : listaSigla) {
            if (s.equals(a.getCurso())) {
                exist = true;
            }
        }

        if (!exist) {
            throw new NotExistException("Curso " + a.getCurso() + " nao existe!");
        }
    }

    public void inserir(Aluno a)
            throws SQLException, NotExistException {

        verificaCurso(a);

        Connection conexao = GerenteConexao.getConexao();
        String sql = "insert into aluno (prontuario, nome, curso, ano_ingresso)"
                + "values (?, ?, ?, ?)";

        PreparedStatement ps = conexao.prepareStatement(sql);

        ps.setString(1, a.getProntuario());
        ps.setString(2, a.getNome());
        ps.setString(3, a.getCurso());
        ps.setInt(4, a.getAnoIngresso());

        ps.executeUpdate();
        conexao.commit();
        ps.close();
        conexao.close();
    }

    public void remover(String prontuario)
            throws SQLException, NotExistException {

        Connection conexao = GerenteConexao.getConexao();
        String sql = "DELETE FROM aluno WHERE prontuario = ?";

        PreparedStatement ps = conexao.prepareStatement(sql);

        ps.setString(1, prontuario);

        int linhas = ps.executeUpdate();

        conexao.commit();
        ps.close();
        conexao.close();

        if (linhas == 0) {
            throw new NotExistException("O prontuario " + prontuario
                    + "nao existe!");
        }
    }

    public void alterar(Aluno a)
            throws SQLException, NotExistException {

        Connection conexao = GerenteConexao.getConexao();
        String sql = "update aluno set nome = ?, curso = ?, ano_ingresso = ?"
                + "where prontuario = ?";

        PreparedStatement ps = conexao.prepareStatement(sql);

        ps.setString(4, a.getProntuario());
        ps.setString(1, a.getNome());
        ps.setString(2, a.getCurso());
        ps.setInt(3, a.getAnoIngresso());

        int quantidadeAlterado = ps.executeUpdate();

        conexao.commit();
        ps.close();
        conexao.close();

        if (quantidadeAlterado == 0) {
            throw new NotExistException("O prontuario " + a.getProntuario()
                    + "nao existe!");
        }
    }

    public List<Aluno> getAlunos()
            throws SQLException {

        List<Aluno> listaAluno = new ArrayList<>();

        Connection conexao = GerenteConexao.getConexao();
        String sql = "SELECT * FROM aluno";

        PreparedStatement ps = conexao.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();

        Aluno a;
        while (rs.next()) {
            a = new Aluno();
            a.setProntuario(rs.getString("prontuario"));
            a.setNome(rs.getString("nome"));
            a.setCurso(rs.getString("curso"));
            a.setAnoIngresso(rs.getInt("ano_ingresso"));

            listaAluno.add(a);
        }

        return listaAluno;
    }

    public List<String> getSiglas()
            throws SQLException {

        Connection conexao = GerenteConexao.getConexao();
        String sql = "SELECT sigla FROM curso";

        PreparedStatement ps = conexao.prepareStatement(sql);

        ResultSet rs = ps.executeQuery();

        List<String> siglas = new ArrayList<>();
        while (rs.next()) {
            siglas.add(rs.getString("sigla"));
        }

        return siglas;
    }
}
