package jrippleseclipseplugin.handlers;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;

/**
 * Our sample handler extends AbstractHandler, an IHandler base class.
 * @see org.eclipse.core.commands.IHandler
 * @see org.eclipse.core.commands.AbstractHandler
 */
public class MenuButtonHandler extends AbstractHandler {
	/**
	 * The constructor.
	 */
	public MenuButtonHandler() {
	}

	/**
	 * the command has been executed, so extract extract the needed information
	 * from the application context.
	 */
	public Object execute(ExecutionEvent event) throws ExecutionException {
		//IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
		//MessageDialog.openInformation(
		//		window.getShell(),
		//		"JRipplesEclipsePlugin",
		//		"Holder of Places");
		
		// Launching the JSwingRipples application
		try {

	        URL location = MenuButtonHandler.class.getProtectionDomain().getCodeSource().getLocation();
			String route = location.getFile()+"jswingripples.jar";
			//System.out.println(route);
			File file = new File(route);
			URL[] urls = { file.toURI().toURL() };
			URLClassLoader loader = new URLClassLoader(urls);
			Class<?> cls = loader.loadClass("org.incha.ui.JSwingRipplesApplication");
			Method main = cls.getDeclaredMethod("main", String[].class);
			String[] args = {};
			main.invoke(null, (Object)args);
			loader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
