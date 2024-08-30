package model;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.layout.BorderPane;

public class PersonModel extends PageModel
{
	private StringProperty email;
	private StringProperty pronoun;
	private StringProperty phone;
	PageModel pg;
	public PersonModel(Page p)
	{
		super(p);
		email = new SimpleStringProperty();
		pronoun = new SimpleStringProperty();
		phone = new SimpleStringProperty();
		this.email.setValue(((Person)p).getEmail());
		this.pronoun.setValue(((Person)p).getPronoun());
		this.phone.setValue(((Person)p).getPhone());
	}
	@Override
	public Person getPage()
	{
		return (Person)p;
	}
	public StringProperty getEmail() {
		return email;
	}
	public void setEmail(StringProperty email) {
		this.email = email;
	}
	public StringProperty getPronoun() {
		return pronoun;
	}
	public void setPronoun(StringProperty pronoun) {
		this.pronoun = pronoun;
	}
	public StringProperty getPhone() {
		return phone;
	}
	public void setPhone(StringProperty phone) {
		this.phone = phone;
	}
	@Override
	public PageTransitionModel create_transition(BorderPane view)
	{
		return new PersonTransitionModel(view, this);
	}
	
	
	


		
	
	
}
