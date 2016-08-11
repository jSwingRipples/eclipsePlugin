package jrippleseclipseplugin.handlers;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.ISelectionService;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.incha.ui.JSwingRipplesApplication;

/**
 * Our sample handler extends AbstractHandler, an IHandler base class.
 * @see org.eclipse.core.commands.IHandler
 * @see org.eclipse.core.commands.AbstractHandler
 */
public class ContextMenuHandler extends AbstractHandler {
	/**
	 * The constructor.
	 */	
	public ContextMenuHandler() {
	}

	/**
	 * the command has been executed, so extract the needed information
	 * from the application context.
	 */
	@Override
	public Object execute(ExecutionEvent arg0) throws ExecutionException {
		
		IWorkbenchWindow window = PlatformUI.getWorkbench().getActiveWorkbenchWindow();
		ISelectionService service = window.getSelectionService();
		ISelection selection = service.getSelection();
		
		IProject project = getSelectedProject(selection);
		String path = project.getLocation().toPortableString();
		
		String[] args = {path};
		JSwingRipplesApplication.main(args);
		return null;
	}

	private IProject getSelectedProject(ISelection selection) {
		IStructuredSelection structSelection = (IStructuredSelection)selection;
		IAdaptable adap = (IAdaptable)structSelection.getFirstElement();
		IResource res = (IResource)adap.getAdapter(IResource.class);
		IFile file = (IFile)res;
		return file.getProject();
	}
}
