package org.eclipse.classes;


import org.eclipse.interfaces.ShowText;

public class Text implements ShowText {

	private String title;

	public Text() {
		super();
	}

	public Text(String title) {
		System.out.println(title);
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "Text [title=" + title + "]";
	}

	@Override
	public Text getText(String title) {
		return new Text(title);
	}
}
