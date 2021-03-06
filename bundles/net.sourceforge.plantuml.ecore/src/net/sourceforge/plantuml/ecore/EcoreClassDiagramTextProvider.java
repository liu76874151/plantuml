package net.sourceforge.plantuml.ecore;

import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.edit.domain.IEditingDomainProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorPart;

public class EcoreClassDiagramTextProvider extends AbstractEcoreClassDiagramTextProvider {

	public EcoreClassDiagramTextProvider() {
		super(IEditingDomainProvider.class);
	}

	@Override
	protected String getDiagramText(IEditorPart editorPart, IEditorInput editorInput, ISelection selection) {
		if (selection instanceof IStructuredSelection) {
			Object sel = ((IStructuredSelection) selection).getFirstElement();
			if (AbstractEcoreClassDiagramTextProvider.isEcoreClassDiagramObject(sel) && sel instanceof EPackage) {
				return getDiagramText((EPackage) sel);
			}
			return null;
		}
		return getDiagramText(((IEditingDomainProvider) editorPart).getEditingDomain().getResourceSet());
	}
}
