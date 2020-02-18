package com.foo.rest.examples.spring.plainselect;

public class Welcome {

	private final String id;
	private final String content;
	private String name;

	public Welcome(String id, String content, String name) {
		this.id = id;
		this.content = content;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public String getContent() {
		return content;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return "Welcome{" +
				"id=" + id +
				", content='" + content + '\'' +
				", name='" + name + '\'' +
				'}';
	}
}
