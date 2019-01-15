package ifpr.main.usuario;

import ifpr.usuario.Usuario;
import ifpr.usuario.dao.UsuarioDao;
import ifpr.usuario.dao.UsuarioDaoImpl;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class UsuariosTableModel extends AbstractTableModel {

    private UsuarioDao usuarioDao;
    private List<Usuario> usuarios;
    private String[] columnNames;
    private Object[][] columnData;

    public UsuariosTableModel() {
        usuarioDao = new UsuarioDaoImpl();
        usuarios = new ArrayList<Usuario>();
        columnNames = new String[]{"Nome", "Login", "Matrícula"};
        columnData = new Object[][]{};
    }

    @Override
    public String getColumnName(int column) {
        return this.columnNames[column];
    }

    @Override
    public int getRowCount() {
        return usuarios.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return columnData[rowIndex][columnIndex];
    }

    public void updateDataModel() {
        atualizarDados();
        fireTableDataChanged();
    }

    public void updateModel() {
        usuarios = usuarioDao.list(50);
        updateDataModel();
    }

    private void atualizarDados() {
        columnData = new Object[usuarios.size()][columnNames.length + 1];
        for (int i = 0; i < usuarios.size(); i++) {
            Usuario usuario = usuarios.get(i);
            columnData[i][0] = usuario.getNome();
            columnData[i][1] = usuario.getLogin();
            columnData[i][2] = usuario.getMatricula();
            columnData[i][3] = usuario;
        }
    }
    
    public void setUsuarios(List<Usuario> usuarios){
        this.usuarios = usuarios;
    }
}
