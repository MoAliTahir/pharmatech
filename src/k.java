import javax.faces.context.FacesContext;

public class k {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Package p = FacesContext.class.getPackage();
		System.out.println(p.getImplementationTitle() + " " + p.getImplementationVersion());
	}

}
