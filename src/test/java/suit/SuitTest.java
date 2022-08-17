package suit;



import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

import test.*;


@RunWith(org.junit.runners.Suite.class)
@SuiteClasses({
	CriarContato.class,
	EditarContato.class,
	EditarParteDoContato.class,
	ListarContatos.class,
	ApagarContato.class,
	
})
public class SuitTest {


}
