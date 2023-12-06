package stand;

import org.eclipse.persistence.descriptors.ClassExtractor;
import org.eclipse.persistence.sessions.Session;

public class PessoaClassExtractor extends ClassExtractor {
    
	@Override
    public Class<?> extractClassFromRow(org.eclipse.persistence.sessions.Record databaseRow, Session session) {
        if (databaseRow.containsKey("CLIENT_SPECIFIC")) {
            return Cliente.class;
        } else if (databaseRow.containsKey("ADMIN_SPECIFIC")) {
            return Administrador.class;
        } else {
            return Pessoa.class;
        }
    }
}
