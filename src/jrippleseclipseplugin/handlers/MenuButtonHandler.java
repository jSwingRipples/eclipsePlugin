package jrippleseclipseplugin.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.incha.ui.JSwingRipplesApplication;

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
	public Object execute(ExecutionEvent event) {
		String[] args = {};
		JSwingRipplesApplication.main(args);
		return null;
	}
	
}
